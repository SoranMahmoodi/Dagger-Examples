package com.soran.mahmoodi.daggerexamples.ui.fargment.post;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

public class PostViewModel extends ViewModel {
    private static final String TAG = "PostViewModel";

    @Inject
    public PostViewModel() {
        Log.i(TAG, "PostViewModel: viewModel working....../ ");
    }
}
