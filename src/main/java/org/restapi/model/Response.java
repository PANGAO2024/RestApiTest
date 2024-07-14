package org.restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

//This definition is good enough if we use gson
public abstract class Response<Data> {
    private int total_pages;

    private List<Data> data;

    public int getTotalPages() {
        return total_pages;
    }

    public List<Data> getData() {
        return data;
    }
}

//@JsonIgnoreProperties(ignoreUnknown = true)
//public abstract class Response<Data> {
//    @JsonProperty("total_pages")
//    private int total_pages;
//
//    private List<Data> data;
//
//    public int getTotalPages() {
//        return total_pages;
//    }
//
//    public List<Data> getData() {
//        return data;
//    }
//}