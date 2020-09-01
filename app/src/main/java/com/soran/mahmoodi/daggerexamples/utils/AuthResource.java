package com.soran.mahmoodi.daggerexamples.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AuthResource<T> {

    @Nullable
    public final AuthStatus status;

    @Nullable
    public final T data;

    @Nullable
    public final String massage;

    public AuthResource(@Nullable AuthStatus status, @Nullable T data, @Nullable String massage) {
        this.status = status;
        this.data = data;
        this.massage = massage;
    }

    public static <T> AuthResource<T> authenticated(@Nullable T data) {
        return new AuthResource<>(AuthStatus.AUTHENTICATED, data, null);
    }

    public static <T> AuthResource<T> error(@NonNull String massage, @Nullable T data) {
        return new AuthResource<>(AuthStatus.ERROR, data, massage);
    }

    public static <T> AuthResource<T> loading(@Nullable T data) {
        return new AuthResource<>(AuthStatus.LOADING, data, null);
    }

    public static <T> AuthResource<T> logout() {
        return new AuthResource<>(AuthStatus.NOT_AUTHENTICATED, null, null);
    }
}
