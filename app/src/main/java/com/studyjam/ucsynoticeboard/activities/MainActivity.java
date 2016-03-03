package com.studyjam.ucsynoticeboard.activities;

import android.app.ProgressDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.studyjam.ucsynoticeboard.R;
import com.studyjam.ucsynoticeboard.adapter.PostAdapter;
import com.studyjam.ucsynoticeboard.controller.RestManager;
import com.studyjam.ucsynoticeboard.helper.Utils;
import com.studyjam.ucsynoticeboard.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RestManager mManager;
    private PostAdapter mPostAdapter;
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configViews();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_reload);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadNewPosts();
            }
        });

        mManager = new RestManager();

        Call<List<Post>> listCall = mManager.getInstance().getAllPosts();
        listCall.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if (response.isSuccess()) {

                    List<Post> postList = response.body();

                    for (int i = 0; i < postList.size(); i++) {

                        Post post = postList.get(i);
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

    private void getPost() {

        Call<List<Post>> listCall = mManager.getInstance().getAllPosts();
        listCall.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if (response.isSuccess()) {

                    List<Post> postList = response.body();

                    for (int i = 0; i < postList.size(); i++) {

                        Post post = postList.get(i);
                        mPostAdapter.addPost(post);

                    }
                }else {



                }

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });

        mDialog.dismiss();

    }

    private void loadNewPosts() {

        mDialog = new ProgressDialog(MainActivity.this);
        mDialog.setMessage("Loading Post...");
        mDialog.setCancelable(true);
        mDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mDialog.setIndeterminate(true);

        mPostAdapter.reset();

        mDialog.show();

        if (Utils.isNetworkAvailable(getApplicationContext())){

            getPost();

        }else {

        }

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
