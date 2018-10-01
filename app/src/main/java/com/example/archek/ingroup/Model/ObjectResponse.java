package com.example.archek.ingroup.Model;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ObjectResponse {//General model for json

    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("info")
    private String info;
    @SerializedName("offers")
    private List<Offer> offers;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public List <Offer> getOffers() {
        return offers;
    }



}

