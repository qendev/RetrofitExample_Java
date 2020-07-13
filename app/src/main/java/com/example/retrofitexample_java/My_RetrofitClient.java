package com.example.retrofitexample_java;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class My_RetrofitClient {

    private  static Retrofit retrofit;

    //Define the Base Url
    private static final String  BASE_URL = "https://jsonplaceholder.typicode.com";

    //create the Retrofit Instance
    public static Retrofit myRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    //Add the converter
                    //you can use multiple converters in a single Retrofit instance
                    .addConverterFactory(GsonConverterFactory.create())
                    //Build the Retrofit instance
                    .build();

        }
        return retrofit;
    }


    }

