package com.soran.mahmoodi.daggerexamples.di.auth;

import com.soran.mahmoodi.daggerexamples.repository.network.AuthApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class AuthModule {

    @Provides
    static AuthApi providerAuthApi(Retrofit retrofit) {
        return retrofit.create(AuthApi.class);
    }

}
