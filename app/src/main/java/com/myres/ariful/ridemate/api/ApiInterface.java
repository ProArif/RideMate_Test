package com.myres.ariful.ridemate.api;

import com.myres.ariful.ridemate.util.ClientList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiInterface {
    @Headers("authorization: 32DFCFD@#&DSFDSFSDF!L@?hh7@32DF")
    @GET("v2/client")
    Call<ClientList> getClients();
}
