package org.restapi.model.medical;

//add json annotation if we use convertJsonToObjectByObjectMapper
//@JsonIgnoreProperties(ignoreUnknown = true)
public class MedicalData {
    Diagnosis diagnosis;
    Doctor doctor;
    Vitals vitals;

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Vitals getVitals() {
        return vitals;
    }

    public void setVitals(Vitals vitals) {
        this.vitals = vitals;
    }
}
