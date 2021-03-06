package com.proofit.calculator.objects;

import java.util.List;

public class PolicyObject {

    private String name;
    private List<PolicySubObject> subObjects;

    public PolicyObject(String name, List<PolicySubObject> subObjects) {
        this.name = name;
        this.subObjects = subObjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PolicySubObject> getSubObjects() {
        return subObjects;
    }

    public void setSubObjects(List<PolicySubObject> subObjects) {
        this.subObjects = subObjects;
    }
}
