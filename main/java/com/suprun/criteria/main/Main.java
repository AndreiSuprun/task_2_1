package com.suprun.criteria.main;

import com.suprun.criteria.controller.ApplianceController;
import com.suprun.criteria.entity.TabletPC;
import com.suprun.criteria.entity.criteria.Criteria;
import com.suprun.criteria.entity.criteria.SearchCriteria;

import java.util.Map;

import static com.suprun.criteria.entity.criteria.SearchCriteria.Oven;

public class Main {

	public static void main(String[] args) {
		Map<String, Object> appliances;
		ApplianceController controller = ApplianceController.getInstance();
		final String requestType = "FIND_BY_PARAMETER";

		//////////////////////////////////////////////////////////////////

		Criteria criteriaOven = new Criteria(requestType, Oven.class.getSimpleName());//"Oven"
		criteriaOven.add(Oven.CAPACITY.toString(), "33");
		appliances = controller.processRequest(criteriaOven);
		PrintApplianceInfo.print(appliances);

		//////////////////////////////////////////////////////////////////

		criteriaOven = new Criteria(requestType, Oven.class.getSimpleName());
		criteriaOven.add(Oven.HEIGHT.toString(), "40");
		criteriaOven.add(Oven.DEPTH.toString(), "60");
		appliances = controller.processRequest(criteriaOven);
		PrintApplianceInfo.print(appliances);

		//////////////////////////////////////////////////////////////////

		Criteria criteriaTabletPC = new Criteria(requestType, TabletPC.class.getSimpleName());
		criteriaTabletPC.add(SearchCriteria.TabletPC.COLOR.toString(), "BLUE");
		criteriaTabletPC.add(SearchCriteria.TabletPC.DISPLAY_INCHES.toString(), "14");
		criteriaTabletPC.add(SearchCriteria.TabletPC.MEMORY_ROM.toString(), "8000");
		appliances = controller.processRequest(criteriaTabletPC);
		PrintApplianceInfo.print(appliances);
	}
}
