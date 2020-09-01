package com.soran.mahmoodi.daggerexamples.di.auth;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

import dagger.MapKey;

@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthScope {
}
