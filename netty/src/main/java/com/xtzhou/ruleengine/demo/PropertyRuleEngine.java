package com.xtzhou.ruleengine.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertyRuleEngine {
    @Value("#{properties.isOverCabin and properties.isCodeShare}")
    Boolean answer;

    public boolean testRule()
    {
        return answer;
    }
}
