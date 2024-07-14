package org.restapi.model.medical;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//add json annotation if we use convertJsonToObjectByObjectMapper
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Vitals {
    int pulse;

    public int getPulse() {
        return pulse;
    }

    public void setPulse(int pulse) {
        this.pulse = pulse;
    }
}
