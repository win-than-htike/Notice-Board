package com.studyjam.ucsynoticeboard.callback;

import com.studyjam.ucsynoticeboard.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by winthanhtike on 3/2/16.
 */
public interface PostService {

    @GET("Blog/crud/postapi.php")
    Call<List<Post>> getAllPosts();

}
