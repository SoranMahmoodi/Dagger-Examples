package com.soran.mahmoodi.daggerexamples.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.soran.mahmoodi.daggerexamples.model.Post;

import java.util.List;

public class PostsResource<T> {

    @Nullable
    public PostStatus status;

    @Nullable
    public T data;
    @Nullable
    public String massage;

    public PostsResource(@Nullable PostStatus status, @Nullable T data, @Nullable String massage) {
        this.status = status;
        this.massage = massage;
        this.data = data;
    }

    public static <T> PostsResource<T> loading(@Nullable T data) {
        return new PostsResource<T>(PostStatus.LOADING, data, null);
    }

    public static <T> PostsResource<T> success(@Nullable T data) {
        return new PostsResource<>(PostStatus.SUCCESS, data, null);
    }

    public static <T> PostsResource<T> error(@NonNull String massage, @Nullable T data) {
        return new PostsResource<>(PostStatus.ERROR, data, massage);
    }
}
