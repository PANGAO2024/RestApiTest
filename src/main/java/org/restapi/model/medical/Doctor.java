package org.restapi.model.medical;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//add json annotation if we use convertJsonToObjectByObjectMapper
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Doctor {
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
