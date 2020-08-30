package com.suprun.criteria.dao.creator;

import com.suprun.criteria.dao.creator.impl.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreatorProvider {

    private static final String APPLIANCE_TYPE_SELECTOR = "\\b\\w+";
    private static final String EMPTY_STRING = "";

    enum Creator{
        LAPTOP(new LaptopCreator()), OVEN(new OvenCreator()), REFRIGERATOR(new RefrigeratorCreator()),
        SPEAKERS(new SpeakersCreator()), TABLETPC(new TabletPCCreator()), VACUUMCLEANER(new VacuumCleanerCreator());
        private CreatorCommand creatorCommand;
        Creator(CreatorCommand creatorCommand){
            this.creatorCommand = creatorCommand;
        }
        public CreatorCommand getCreator(){
            return creatorCommand;
        }
    }

    public CreatorCommand receiveCommand(String line) {
        String applianceType = extractApplianceType(line);
        Creator creator = Creator.valueOf(applianceType.toUpperCase());
        CreatorCommand command = creator.getCreator();
        return command;
    }

    private String extractApplianceType(String line) {
        Pattern pattern = Pattern.compile(APPLIANCE_TYPE_SELECTOR);
        Matcher matcher = pattern.matcher(line);
        String value = EMPTY_STRING;
        if (matcher.find()){
            value = matcher.group().trim();
        }
        return value;
    }
}
