package org.restapi.examples;

import org.restapi.model.Response;
import org.restapi.model.country.CountryData;

import static org.restapi.HttpUtil.convertJsonToObjectByGson;
import static org.restapi.HttpUtil.invoke;

/*** Given a country name, query the REST API at "https://jsonmock.hackerrank.com/api/countries?name=country"
and return the capital city's name.
The response is a JSON object with 5 fields. The essential field is data.
Either an array or an array with a single object that contains the country's record.
In the data array, the country has the following schema:
name: The name of the country (String)
capital: The name of the capital city (String)
A number of fields that are not of interest.
page,per_page, total, total_pages, etc. are not required for this task.
If the country is found, the data array contains exactly 1 element. If not, it is empty and the function should return '-1'

The api url is "https://jsonmock.hackerrank.com/api/countries"
The api response is like
{
   "page":1,
   "per_page":10,
   "total":250,
   "total_pages":25,
   "data":[
      {
         "name":"Afghanistan",
         "nativeName":"افغانستان",
         "topLevelDomain":[
            ".af"
         ],
         "alpha2Code":"AF",
         "numericCode":"004",
         "alpha3Code":"AFG",
         "currencies":[
            "AFN"
         ],
         "callingCodes":[
            "93"
         ],
         "capital":"Kabul",
         "altSpellings":[
            "AF",
            "Afġānistān"
         ],
         "relevance":"0",
         "region":"Asia",
         "subregion":"Southern Asia",
         "language":[
            "Pashto",
            "Dari"
         ],
         "languages":[
            "ps",
            "uz",
            "tk"
         ],
         "translations":{
            "de":"Afghanistan",
            "es":"Afganistán",
            "fr":"Afghanistan",
            "it":"Afghanistan",
            "ja":"アフガニスタン",
            "nl":"Afghanistan",
            "hr":"Afganistan"
         },
         "population":26023100,
         "latlng":[
            33,
            65
         ],
         "demonym":"Afghan",
         "borders":[
            "IRN",
            "PAK",
            "TKM",
            "UZB",
            "TJK",
            "CHN"
         ],
         "area":652230,
         "gini":27.8,
         "timezones":[
            "UTC+04:30"
         ]
      },...
 ***/
public class CountryAPI extends HackerrankAPI{

    static class CountryResponse extends Response<CountryData> {}
    public CountryAPI(String url) {
        super(url);
    }

    public String getCapital(String countryName) {
        String url = "/countries?name=%s";
        String responseString = invoke(String.format(BASE_URL + url, countryName));
        CountryResponse response = convertJsonToObjectByGson(responseString, CountryResponse.class);
        if (!response.getData().isEmpty() && response.getData().get(0).getCapital() != null) {
            return response.getData().get(0).getCapital();
        }
        return "-1";
    }
}
