package com.suprun.criteria.controller;

import com.suprun.criteria.entity.criteria.Criteria;
import com.suprun.criteria.controller.command.ApplianceCommand;

import java.util.Map;

public class ApplianceController {

    private static ApplianceController instance;

    private ApplianceController(){};

    public static ApplianceController getInstance(){
        if (instance == null){
            instance = new ApplianceController();
        }
        return instance;
    }

    public Map<String, Object> processRequest(Criteria request) {
        ApplianceCommand applianceCommand = CommandProvider.getInstance().receiveCommand(request);
        Map<String, Object> response = applianceCommand.execute(request);
        return response;
    }
}
