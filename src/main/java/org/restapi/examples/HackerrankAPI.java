package org.restapi.examples;

import static org.restapi.HttpUtil.invoke;

public class HackerrankAPI {
    final String BASE_URL = "https://jsonmock.hackerrank.com/api";
    private String url;

    public HackerrankAPI(String url) {
        this.url = url;
    }

    public String getResponse() {
        return invoke(BASE_URL + this.url);
    }
}
