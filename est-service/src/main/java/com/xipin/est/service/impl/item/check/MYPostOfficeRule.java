package com.xipin.est.service.impl.item.check;

import java.util.List;

import com.xipin.est.service.impl.item.check.eum.ExcelRuleEnum;

public class MYPostOfficeRule extends PostOfficeRule {

	private List<ExcelRuleEnum> rules;

	public List<ExcelRuleEnum> getRules() {
		return rules;
	}

	public void setRules(List<ExcelRuleEnum> rules) {
		this.rules = rules;
	}

}
