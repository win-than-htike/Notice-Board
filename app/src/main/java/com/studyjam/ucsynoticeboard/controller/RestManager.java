package com.studyjam.ucsynoticeboard.controller;

import com.studyjam.ucsynoticeboard.callback.PostService;
import com.studyjam.ucsynoticeboard.helper.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by winthanhtike on 3/2/16.
 */
public class RestManager {

    private PostService mPostService;

    public PostService getPostService(){

        if (mPostService == null){

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.HTTP.url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mPostService = retrofit.create(PostService.class);

        }

        return mPostService;

    }

}
