package com.example.videomeetingapp.network;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClient {
private  static Retrofit retrofit = null;
public static Retrofit getClient(){
    if(retrofit ==  null){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://fcm.googleapis.com/fcm/")
                .addConverterFactory(ScalarsConverterFactory.create()) //add scalarsConverterFactory not jsonConverter we don't have manage network request
                .build();
    }
    return retrofit;
}

}
