package com.suprun.criteria.main;

import com.suprun.criteria.entity.Appliance;

import java.util.List;
import java.util.Map;

public class PrintApplianceInfo {

	private static String APPLIANCES = "appliances";
	private static String EXCEPTIONS = "exceptions";

	public static void print(Map<String, Object> appliances) {
		if (appliances.containsKey(APPLIANCES)){
			List<Appliance> list = (List<Appliance>) appliances.get(APPLIANCES);
			for(Appliance appliance: list){
				System.out.println(appliance.toString());
			}
		}
		if (appliances.containsKey(EXCEPTIONS)){
			String message = (String) appliances.get(EXCEPTIONS);
			System.out.println(message);
		}
	}
}
