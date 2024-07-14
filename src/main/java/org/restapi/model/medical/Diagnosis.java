package org.restapi.model.medical;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//add json annotation if we use convertJsonToObjectByObjectMapper
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Diagnosis {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
