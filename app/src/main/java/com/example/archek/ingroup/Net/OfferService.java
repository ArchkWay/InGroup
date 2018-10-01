package com.example.archek.ingroup.Net;

import com.example.archek.ingroup.Model.ObjectResponse;

import retrofit2.Call;
import retrofit2.http.GET;


public interface OfferService {//Get call

    @GET("?id=1")
        Call<ObjectResponse> getOffers();

}
