package com.suprun.criteria.controller.command;

import com.suprun.criteria.entity.criteria.Criteria;

import java.util.Map;

public interface ApplianceCommand {

    Map<String, Object> execute(Criteria request);
}
