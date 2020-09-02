package com.soran.mahmoodi.daggerexamples.ui.fargment.post;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.soran.mahmoodi.daggerexamples.model.Post;
import com.soran.mahmoodi.daggerexamples.model.User;
import com.soran.mahmoodi.daggerexamples.repository.network.AuthApi;
import com.soran.mahmoodi.daggerexamples.utils.PostsResource;
import com.soran.mahmoodi.daggerexamples.utils.SessionManger;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class PostsViewModel extends ViewModel {

    private static final String TAG = "PostsViewModel";
    private AuthApi authApi;
    private MediatorLiveData<PostsResource<List<Post>>> postsLiveData;
    private SessionManger sessionManger;

    @Inject
    public PostsViewModel(SessionManger sessionManger, AuthApi authApi) {
        this.sessionManger = sessionManger;
        this.authApi = authApi;
    }


    public LiveData<PostsResource<List<Post>>> getPostsLiveData() {
        if (postsLiveData == null) {
            postsLiveData = new MediatorLiveData<>();
            postsLiveData.setValue(PostsResource.loading((List<Post>) null));
            LiveData<PostsResource<List<Post>>> source = LiveDataReactiveStreams
                    .fromPublisher(authApi.getPosts(sessionManger.getUserAuth().getValue().data.getId())
                            .onErrorReturn(throwable -> {
                                Post post = new Post();
                                post.setId(-1);
                                ArrayList<Post> postArrayList = new ArrayList<>();
                                postArrayList.add(post);
                                return postArrayList;
                            })
                            .map(posts -> {
                                if (posts.size() > 0) {
                                    if (posts.get(0).getId() == -1) {
                                        PostsResource.error("clod not posts", null);
                                    }
                                }
                                return PostsResource.success(posts);
                            })
                            .subscribeOn(Schedulers.io()));

            postsLiveData.addSource(source, listPostsResource -> {
                postsLiveData.setValue(listPostsResource);
                postsLiveData.removeSource(source);

            });
        }
        return postsLiveData;
    }
}

