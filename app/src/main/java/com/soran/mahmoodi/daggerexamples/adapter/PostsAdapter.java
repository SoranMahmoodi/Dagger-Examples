package com.soran.mahmoodi.daggerexamples.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.soran.mahmoodi.daggerexamples.R;
import com.soran.mahmoodi.daggerexamples.model.Post;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder> {

    private List<Post> posts = new ArrayList<>();

    public void getPosts(List<Post> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_posts, parent, false);
        return new PostsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostsViewHolder holder, int position) {
        holder.bindPost(posts.get(position));
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class PostsViewHolder extends RecyclerView.ViewHolder {
        private TextView title, body;

        public PostsViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_rawPosts_title);
            body = itemView.findViewById(R.id.tv_rawPosts_body);
        }

        private void bindPost(Post post) {
            title.setText(post.getTitle());
            body.setText(post.getBody());
        }
    }
}
