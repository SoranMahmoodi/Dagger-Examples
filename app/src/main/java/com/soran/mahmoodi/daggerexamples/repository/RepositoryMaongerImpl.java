package com.soran.mahmoodi.daggerexamples.repository;

import com.soran.mahmoodi.daggerexamples.model.User;
import com.soran.mahmoodi.daggerexamples.repository.network.ApiServiceHelper;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class RepositoryMaongerImpl  implements RepositoryManger{

    private ApiServiceHelper apiServiceHelper;

    @Inject
    public RepositoryMaongerImpl(ApiServiceHelper apiServiceHelper) {
        this.apiServiceHelper = apiServiceHelper;
    }

    @Override
    public Flowable<User> getUser(int id) {
        return apiServiceHelper.getUser(id);
    }

    @Override
    public Flowable<List<User>> getPost(int id) {
        return apiServiceHelper.getPosts(id);
    }
}
