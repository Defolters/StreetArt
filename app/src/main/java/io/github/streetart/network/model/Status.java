package io.github.streetart.network.model;

import com.google.gson.annotations.SerializedName;

public class Status {

    @SerializedName("code")
    private Integer code;
    @SerializedName("name")
    private String name;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
