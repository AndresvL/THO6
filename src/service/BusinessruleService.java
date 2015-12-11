package service;

import controller.Generator;

public class BusinessruleService {
	public String getBusinessRuleByName(String rule) {
		String reply = new Generator().generate(rule);
		if(reply != null) {
			return reply; 
		} else {
			return "an error has occured fetching the businessrule with name: "+rule+" \n please contact a developer";
		}
		
	}	
}
