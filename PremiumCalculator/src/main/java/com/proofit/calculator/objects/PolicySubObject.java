package com.proofit.calculator.objects;

import com.proofit.calculator.RiskType;

import java.math.BigDecimal;

public class PolicySubObject {

    private String name;
    private BigDecimal insuredSum;
    private RiskType risk;

    public PolicySubObject(String name, BigDecimal insuredSum, RiskType risk) {
        this.name = name;
        this.insuredSum = insuredSum;
        this.risk = risk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getInsuredSum() {
        return insuredSum;
    }

    public void setInsuredSum(BigDecimal insuredSum) {
        this.insuredSum = insuredSum;
    }

    public RiskType getRisk() {
        return risk;
    }

    public void setRisk(RiskType risk) {
        this.risk = risk;
    }
}
