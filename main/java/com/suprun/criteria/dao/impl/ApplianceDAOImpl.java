package com.suprun.criteria.dao.impl;

import com.suprun.criteria.dao.ApplianceDAO;
import com.suprun.criteria.dao.DAOException;
import com.suprun.criteria.dao.creator.CreatorCommand;
import com.suprun.criteria.dao.creator.CreatorProvider;
import com.suprun.criteria.dao.function.ParameterPredicate;
import com.suprun.criteria.dao.source.ApplianceSource;
import com.suprun.criteria.entity.Appliance;
import com.suprun.criteria.entity.criteria.Criteria;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ApplianceDAOImpl implements ApplianceDAO {

    @Override
    public List<Appliance> find(Criteria criteria) throws DAOException {
        Path applianceSourcePath = new ApplianceSource().receiveApplianceSourcePath();
        ParameterPredicate predicate = new ParameterPredicate();
        CreatorProvider creatorProvider = new CreatorProvider();
        CreatorCommand creatorCommand = creatorProvider.receiveCommand(criteria.getGroupSearchName());
        List<Appliance> appliances;
        try (Stream<String> applianceStream = Files.lines(applianceSourcePath)) {
            appliances = applianceStream.filter(line -> predicate.test(line, criteria)).map(creatorCommand::create).collect(Collectors.toList());
        } catch (IOException e) {
            throw new DAOException("File doesn't available", e);
        }
        return appliances;
    }
}