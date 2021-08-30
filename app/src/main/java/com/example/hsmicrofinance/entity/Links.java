package com.example.hsmicrofinance.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links {
    @SerializedName("url")
    @Expose
    private Object url;
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("active")
    @Expose
    private Boolean active;

    public Links() {
    }

    public Links(Object url, String label, Boolean active) {
        this.url = url;
        this.label = label;
        this.active = active;
    }

    public Object getUrl() {
        return url;
    }

    public void setUrl(Object url) {
        this.url = url;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Links{" +
                "url=" + url +
                ", label='" + label + '\'' +
                ", active=" + active +
                '}';
    }
}
