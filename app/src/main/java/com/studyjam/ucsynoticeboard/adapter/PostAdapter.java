package com.studyjam.ucsynoticeboard.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.studyjam.ucsynoticeboard.R;
import com.studyjam.ucsynoticeboard.model.Post;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by winthanhtike on 3/2/16.
 */
public class PostAdapter extends RecyclerView.Adapter<PostAdapter.Holder> {

    private List<Post> mFlowers;

    public PostAdapter() {
        this.mFlowers = new ArrayList<>();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, null, false);
        return new Holder(row);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        Post p = mFlowers.get(position);
        holder.tvPostName.setText(p.getTitle());
        holder.tvPostContent.setText(p.getContent());

    }

    @Override
    public int getItemCount() {
        return mFlowers.size();
    }

    public void addPost(Post post) {

        mFlowers.add(post);
        notifyDataSetChanged();

    }


    public class Holder extends RecyclerView.ViewHolder {

        private TextView tvPostName, tvPostContent;

        public Holder(View itemView) {
            super(itemView);

            tvPostName = (TextView)itemView.findViewById(R.id.tv_post_title);
            tvPostContent = (TextView)itemView.findViewById(R.id.tv_post_content);

        }
    }
}
