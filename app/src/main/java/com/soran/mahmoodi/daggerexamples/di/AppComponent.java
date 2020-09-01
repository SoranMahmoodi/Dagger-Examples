package com.soran.mahmoodi.daggerexamples.di;

import android.app.Application;

import com.soran.mahmoodi.daggerexamples.utils.SessionManger;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, ActivityBuilder.class, AppModule.class, ViewModelFactoryModule.class,})
public interface AppComponent extends AndroidInjector<DaggerApplication> {

    SessionManger sessionManger();

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
