package com.parking.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ScriptResultReader {
    private ObjectMapper objectMapper;

    public ScriptResultReader(){
        objectMapper = new ObjectMapper();
    }

    public ScriptResult read(String scriptResult) throws IOException {
        return objectMapper.readValue(scriptResult, ScriptResult.class);
    }
}
