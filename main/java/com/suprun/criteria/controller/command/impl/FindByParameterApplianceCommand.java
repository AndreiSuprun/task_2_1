package com.suprun.criteria.controller.command.impl;

import com.suprun.criteria.entity.criteria.Criteria;
import com.suprun.criteria.controller.command.ApplianceCommand;
import com.suprun.criteria.entity.Appliance;
import com.suprun.criteria.service.ServiceException;
import com.suprun.criteria.service.ApplianceService;
import com.suprun.criteria.service.ServiceFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindByParameterApplianceCommand implements ApplianceCommand {

    private static final String APPLIANCES = "appliances";
    private static final String EXCEPTIONS = "exceptions";

    @Override
    public Map<String, Object> execute(Criteria request) {
        Map<String, Object> response = new HashMap<>();
        ServiceFactory factory = ServiceFactory.getInstance();
        ApplianceService applianceService = factory.getApplianceService();
        try{
            List<Appliance> appliances = applianceService.find(request);
            response.put(APPLIANCES, appliances);
        } catch (ServiceException e){
            response.put(EXCEPTIONS, e.getMessage());
        }
        return response;
    }
}
