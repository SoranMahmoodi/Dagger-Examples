package com.soran.mahmoodi.daggerexamples.repository;

import com.soran.mahmoodi.daggerexamples.model.User;

import java.util.List;

import io.reactivex.Flowable;

public interface RepositoryManger {
    Flowable<User> getUser(int id);

    Flowable<List<User>> getPost(int id);
}
