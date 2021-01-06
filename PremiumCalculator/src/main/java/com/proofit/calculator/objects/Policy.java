package com.proofit.calculator.objects;

import java.util.List;

public class Policy {

    private String number;
    private String status;
    private List<PolicyObject> objects;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<PolicyObject> getObjects() {
        return objects;
    }

    public void setObjects(List<PolicyObject> objects) {
        this.objects = objects;
    }
}
