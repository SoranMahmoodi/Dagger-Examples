package com.soran.mahmoodi.daggerexamples.repository.network;

import com.soran.mahmoodi.daggerexamples.model.Post;
import com.soran.mahmoodi.daggerexamples.model.User;

import java.util.List;

import io.reactivex.Flowable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface AuthApi {

    @GET("users/{id}")
    Flowable<User> getUser(@Path("id") int id);

    @GET("posts")
    Flowable<List<Post>> getPosts(@Query("userId") int id);
}
