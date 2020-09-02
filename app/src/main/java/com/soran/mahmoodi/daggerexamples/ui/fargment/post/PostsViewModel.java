package com.soran.mahmoodi.daggerexamples.ui.fargment.post;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

public class PostsViewModel extends ViewModel {

    private static final String TAG = "PostsViewModel";

    @Inject
    public PostsViewModel() {
        Log.i(TAG, "PostsViewModel: viewModel working........");
    }
}

