package com.suprun.criteria.dao.creator.impl;

import com.suprun.criteria.dao.creator.CreatorCommand;
import com.suprun.criteria.entity.Appliance;
import com.suprun.criteria.entity.Speakers;
import com.suprun.criteria.entity.criteria.SearchCriteria;

public class SpeakersCreator implements CreatorCommand {
    
    @Override
    public Appliance create(String line) {
        int powerConsumption = parseIntValue(extractValue(line, SearchCriteria.Speakers.POWER_CONSUMPTION.toString()));
        int numberOfSpeakers = parseIntValue(extractValue(line, SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString()));
        String frequencyRange = extractValue(line, SearchCriteria.Speakers.FREQUENCY_RANGE.toString());
        int cordLength = parseIntValue(extractValue(line, SearchCriteria.Speakers.CORD_LENGTH.toString()));
        Speakers speakers = new Speakers(powerConsumption, numberOfSpeakers, frequencyRange, cordLength);
        return speakers;
    }
}
