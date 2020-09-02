package com.soran.mahmoodi.daggerexamples.ui.fargment.post;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.soran.mahmoodi.daggerexamples.R;
import com.soran.mahmoodi.daggerexamples.adapter.PostsAdapter;
import com.soran.mahmoodi.daggerexamples.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class PostsFragment extends DaggerFragment {
    private static final String TAG = "PostsFragment";
    private PostsViewModel postsViewModel;
    private RecyclerView rvPosts;

    @Inject
    PostsAdapter adapter;
    @Inject
    ViewModelProviderFactory factory;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_posts, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        postsViewModel = new ViewModelProvider(this, factory).get(PostsViewModel.class);
        setupViews(view);
        subscribeObserver();
    }

    private void setupViews(View view) {
        rvPosts = view.findViewById(R.id.rv_fragmentPosts);
        rvPosts.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
    }

    private void subscribeObserver() {
        postsViewModel.getPostsLiveData().removeObservers(getViewLifecycleOwner());
        postsViewModel.getPostsLiveData().observe(getViewLifecycleOwner(), listPostsResource -> {
            if (listPostsResource != null) {
                switch (listPostsResource.status) {
                    case LOADING:
                        break;
                    case SUCCESS:
                        adapter.getPosts(listPostsResource.data);
                        rvPosts.setAdapter(adapter);
                        break;
                    case ERROR:
                        Log.i(TAG, "subscribeObserver: " + listPostsResource.massage);
                        break;
                }
            }
        });
    }
}