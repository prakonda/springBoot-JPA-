package com.parking.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ScriptResult {
    private MRZ mrz;
    private String error;

    public MRZ getMrz() {
        return mrz;
    }

    public void setMrz(MRZ mrz) {
        this.mrz = mrz;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "MRZ: { \n"+mrz+"\n}"+"\nerror: "+error;
    }
}
