package com.soran.mahmoodi.daggerexamples.ui.fargment.post;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.soran.mahmoodi.daggerexamples.R;
import com.soran.mahmoodi.daggerexamples.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class PostsFragment extends DaggerFragment {

    private PostsViewModel postsViewModel;
    private RecyclerView rvPosts;

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
    }

    private void setupViews(View view) {
        rvPosts = view.findViewById(R.id.rv_fragmentPosts);
    }

}