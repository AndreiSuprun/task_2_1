package com.suprun.criteria.dao.impl;

import com.suprun.criteria.dao.ApplianceDAO;
import com.suprun.criteria.dao.DAOException;
import com.suprun.criteria.dao.creator.CreatorCommand;
import com.suprun.criteria.dao.creator.CreatorProvider;
import com.suprun.criteria.entity.Appliance;
import com.suprun.criteria.entity.criteria.Criteria;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ApplianceDAOImpl implements ApplianceDAO {

    private static final String RESOURCE_FILE = "properties.file";
    private static final String FILE_NAME = "filename";
    private static final String PARAMETER_SELECTOR = ".*%s=(?i)(%s)[,\\s+]*.*";

    @Override
    public List<Appliance> find(Criteria criteria) throws DAOException {
        Path applianceSourcePath = receiveApplianceSourcePath();
        BiPredicate<String, Criteria> predicate = getParameterPredicate();
        CreatorProvider creatorProvider = CreatorProvider.getInstance();
        CreatorCommand creatorCommand = creatorProvider.receiveCommand(criteria.getGroupSearchName());
        List<Appliance> appliances;
        try {
            Stream<String> applianceStream = Files.lines(applianceSourcePath);
            appliances = applianceStream.filter(line -> predicate.test(line, criteria)).map(creatorCommand::create).collect(Collectors.toList());
        } catch (IOException e) {
            throw new DAOException("File doesn't available", e);
        }
        return appliances;
    }

    private Path receiveApplianceSourcePath() throws DAOException {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCE_FILE);
        String fileName = resourceBundle.getString(FILE_NAME);
        Path path;
        try {
            path = Path.of(fileName);
        } catch (InvalidPathException e) {
            throw new DAOException("Invalid file path", e);
        }
        return path;
    }

    private BiPredicate<String, Criteria> getParameterPredicate(){
        BiPredicate<String, Criteria> predicate = new BiPredicate<String, Criteria>() {
            @Override
            public boolean test(String line, Criteria criteria) {
                if (!line.contains(criteria.getGroupSearchName())){
                    return false;
                }
                boolean isParameterValid = false;
                for (String criteriaSearch : criteria.getSearchCriteriaSet()) {
                    String valueSelector = String.format(PARAMETER_SELECTOR, criteriaSearch, criteria.getSearchCriteriaValue(criteriaSearch));
                    if (line.contains(criteriaSearch) && line.matches(valueSelector)) {
                        isParameterValid = true;
                    } else {
                        return false;
                    }
                }
                return isParameterValid;
            }
        };
        return predicate;
    }
}
