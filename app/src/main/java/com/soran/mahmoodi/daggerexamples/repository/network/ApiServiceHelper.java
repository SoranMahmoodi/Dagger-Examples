package com.soran.mahmoodi.daggerexamples.repository.network;

import com.soran.mahmoodi.daggerexamples.model.User;

import java.util.List;

import io.reactivex.Flowable;

public class ApiServiceHelper implements AuthApi {

    AuthApi authApi;

    public ApiServiceHelper(AuthApi authApi) {
        this.authApi = authApi;
    }

    @Override
    public Flowable<User> getUser(int id) {
        return authApi.getUser(id);
    }

    @Override
    public Flowable<List<User>> getPosts(int id) {
        return authApi.getPosts(id);
    }
}
