package com.soran.mahmoodi.daggerexamples.di.auth;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Scope
@Documented
@Retention(RUNTIME)
public @interface AuthScope {
}
