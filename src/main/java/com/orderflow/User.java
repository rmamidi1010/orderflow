package com.orderflow;

import java.util.Objects;

/** User entity for the order domain. */
public class User {
    private final String id;
    private final String email;

    public User(String id, String email) {
        this.id = Objects.requireNonNull(id, "id");
        this.email = Objects.requireNonNull(email, "email");
    }

    public String getId() { return id; }
    public String getEmail() { return email; }
}
