package com.studyjam.ucsynoticeboard.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.studyjam.ucsynoticeboard.R;
import com.studyjam.ucsynoticeboard.adapter.PostAdapter;
import com.studyjam.ucsynoticeboard.controller.RestManager;
import com.studyjam.ucsynoticeboard.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RestManager mManager;
    private PostAdapter mPostAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configViews();

        mManager = new RestManager();
        Call<List<Post>> listCall = mManager.getPostService().getAllPosts();
        listCall.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if (response.isSuccess()) {

                    List<Post> flowerList = response.body();

                    for (int i = 0; i < flowerList.size(); i++) {

                        Post post = flowerList.get(i);
                        mPostAdapter.addPost(post);

                    }
                }else {



                }

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });

    }

    private void configViews() {

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_post);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        mPostAdapter = new PostAdapter();
        mRecyclerView.setAdapter(mPostAdapter);

    }

}
