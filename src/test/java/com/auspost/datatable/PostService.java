package com.auspost.datatable;

public class PostService {

	private String service;
    private String cost;


    public PostService(String service, String cost) {
        this.service = service;
        this.cost = cost;
    }

    public String getService() {
        return service;
    }

    public String getCost() {
        return cost;
    }
}
