package resource;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import service.BusinessruleService;

@Path("/businessrule")
public class BusinessRuleResource {
	private BusinessruleService businessRuleService = new BusinessruleService();
	
	@GET 
	@Path("{businessRuleName}")
	public String getBusinessRuleByName(@PathParam("businessRuleName") String rule) {
		return businessRuleService.getBusinessRuleByName(rule);
	}

}
