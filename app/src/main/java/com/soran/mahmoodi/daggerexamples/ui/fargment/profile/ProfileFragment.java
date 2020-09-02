package com.soran.mahmoodi.daggerexamples.ui.fargment.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.soran.mahmoodi.daggerexamples.R;
import com.soran.mahmoodi.daggerexamples.model.User;
import com.soran.mahmoodi.daggerexamples.utils.AuthResource;
import com.soran.mahmoodi.daggerexamples.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class ProfileFragment extends DaggerFragment {

    private ProfileViewModel profileViewModel;
    private TextView userName, email, website;
    @Inject
    ViewModelProviderFactory factory;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        profileViewModel = new ViewModelProvider(this, factory).get(ProfileViewModel.class);
        Toast.makeText(getContext(), "welcome to postFragment", Toast.LENGTH_SHORT).show();
        setupViews(view);
        subscribeObserver();
    }

    private void setupViews(View view) {
        userName = view.findViewById(R.id.tv_fragmentProfile_userName);
        email = view.findViewById(R.id.tv_fragmentProfile_email);
        website = view.findViewById(R.id.tv_fragmentProfile_website);
    }

    private void subscribeObserver() {
        profileViewModel.getUserDataProfile().removeObservers(getViewLifecycleOwner());
        profileViewModel.getUserDataProfile().observe(getViewLifecycleOwner(), userAuthResource -> {
            if (userAuthResource.status != null) {
                switch (userAuthResource.status) {
                    case AUTHENTICATED:
                        getDataUser(userAuthResource);
                        break;
                    case ERROR:
                        getErrorData(userAuthResource.massage);
                        break;
                }
            }
        });
    }

    private void getErrorData(String massage) {
        userName.setText("error");
        email.setText("error");
        website.setText(massage);
    }

    private void getDataUser(AuthResource<User> userAuthResource) {
        userName.setText(userAuthResource.data.getUserName());
        email.setText(userAuthResource.data.getEmail());
        website.setText(userAuthResource.data.getWebsite());
    }

}
