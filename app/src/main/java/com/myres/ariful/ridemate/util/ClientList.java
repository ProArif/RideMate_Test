package com.myres.ariful.ridemate.util;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ClientList {

    @SerializedName("client")
    private List<ClientModel> client;
    @SerializedName("error")
    private Boolean error;
    @SerializedName("message")
    private String message;

    public List<ClientModel> getClient() {
        return client;
    }

    public void setClient(List<ClientModel> client) {
        this.client = client;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
