package com.studyjam.ucsynoticeboard.callback;

import com.studyjam.ucsynoticeboard.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by winthanhtike on 3/2/16.
 */
public interface PostService {

    @Headers("Content-Type: application/json")
    @GET("/Blog/crud/postapi.php")
    Call<List<Post>> getAllPosts();
}
