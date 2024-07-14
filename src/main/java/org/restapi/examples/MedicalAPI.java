package org.restapi.examples;

import org.restapi.model.medical.MedicalData;
import org.restapi.model.Response;

import java.util.ArrayList;
import java.util.List;

import static org.restapi.HttpUtil.*;

/*** calculate average pulse for given doctor.id, diagnosis.name from response.
 The api url is "https://jsonmock.hackerrank.com/api/medical_records"
 The api response is like
 {
 "page":1,
 "per_page":10,
 "total":99,
 "total_pages":10,
 "data":[
 {
 "id":1,
 "timestamp":1565637002408,
 "diagnosis":{
 "id":3,
 "name":"Pulmonary embolism",
 "severity":4
 },
 "vitals":{
 "bloodPressureDiastole":154,
 "bloodPressureSystole":91,
 "pulse":125,
 "breathingRate":32,
 "bodyTemperature":100
 },
 "doctor":{
 "id":2,
 "name":"Dr Arnold Bullock"
 },
 "userId":2,
 "userName":"Bob Martin",
 "userDob":"14-09-1989",
 "meta":{
 "height":174,
 "weight":172
 }
 },......
 ***/
public class MedicalAPI extends HackerrankAPI{
    public MedicalAPI(String url) {
        super(url);
    }

    static class MedicalResponse extends Response<MedicalData>{}

    public int getAvgPulse(int doctorId, String diagnosisName) {
        String url = "/medical_records?page=%s";
        String firstPageResponseString = invoke(String.format(BASE_URL + url, 1));

        MedicalResponse firstPageResponse = convertJsonToObjectByGson(firstPageResponseString, MedicalResponse.class);
        //MedicalResponse firstPageResponse = convertJsonToObjectByObjectMapper(firstPageResponseString, MedicalResponse.class);

        int totalPages = firstPageResponse.getTotalPages();
        List<MedicalData> dataList = new ArrayList<>();
        for (int i = 1; i <= totalPages; i++) {
            String responseString = invoke(String.format(BASE_URL + url, i));
            MedicalResponse response = convertJsonToObjectByGson(responseString, MedicalResponse.class);
            //MedicalResponse response = convertJsonToObjectByObjectMapper(responseString, MedicalResponse.class);
            dataList.addAll(response.getData());
        }
        double avgDouble = dataList.stream()
                .filter(data -> data.getDoctor().getId() == doctorId && data.getDiagnosis().getName().equals(diagnosisName))
                .mapToInt(data -> data.getVitals().getPulse())
                .average()
                .orElse(0);

        return (int) avgDouble;
    }
}
