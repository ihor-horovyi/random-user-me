package me.random.user.service;

import me.random.user.model.User;

import java.util.List;

public interface UserBuilder<T extends User> {

    UserBuilder count(Integer count);

    UserBuilder gender(User.Gender gender);

    UserBuilder password(String password);

    UserBuilder seed(String seed);

    List<User>  build();

}
