package com.example.archek.ingroup.Model;

import com.google.gson.annotations.SerializedName;

public class Offer {//model for elements list offers

    @SerializedName("id")
    private String  id;
    @SerializedName("name")
    private String name;
    @SerializedName("des")
    private String des;
    @SerializedName("logo")
    private String logo;
    @SerializedName("url")
    private String url;
    @SerializedName("btn")
    private String btn;
    @SerializedName("btn2")
    private Object btn2;
    @SerializedName("browser")
    private Boolean browser;
    @SerializedName("enabled")
    private Boolean enabled;
    @SerializedName("desc_full")
    private String  descFull;

    public String  getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDes() {
        return des;
    }

    public String getLogo() {
        return logo;
    }

    public String getUrl() {
        return url;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public String getDescFull() {
        return descFull;
    }



    public void setId(String  id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }



}

