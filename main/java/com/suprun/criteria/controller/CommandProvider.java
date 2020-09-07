package com.suprun.criteria.controller;

import com.suprun.criteria.controller.command.ApplianceCommand;
import com.suprun.criteria.controller.command.impl.EmptyApplianceCommand;
import com.suprun.criteria.controller.command.impl.FindByParameterApplianceCommand;
import com.suprun.criteria.entity.criteria.Criteria;

public class CommandProvider {
    
    private static CommandProvider instance;

    private CommandProvider(){};

    public static CommandProvider getInstance(){
        if (instance == null){
            instance = new CommandProvider();
        }
        return instance;
    }

    public ApplianceCommand receiveCommand(Criteria criteria){
        ApplianceCommand command;
        String request = criteria.getRequestType();
        try {
        RequestType requestType = RequestType.valueOf(request.toUpperCase());
        command = requestType.getCommand();
    } catch (IllegalArgumentException e) {
        command = new EmptyApplianceCommand();
    }
        return command;
    }

    enum RequestType {
        FIND_BY_PARAMETER(new FindByParameterApplianceCommand());
        private final ApplianceCommand applianceCommand;
        RequestType(ApplianceCommand applianceCommand) {
            this.applianceCommand = applianceCommand;
        }
        public ApplianceCommand getCommand(){
            return  applianceCommand;
        }
    }
}
