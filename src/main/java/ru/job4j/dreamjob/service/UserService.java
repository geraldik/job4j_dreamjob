package ru.job4j.dreamjob.service;

import org.springframework.stereotype.Service;
import ru.job4j.dreamjob.model.User;
import ru.job4j.dreamjob.store.UserDBStore;

import java.util.Optional;


@Service
public class UserService {

    private final UserDBStore store;

    public UserService(UserDBStore  store) {
        this.store = store;
    }

    public Optional<User> add(User user) {
        return Optional.ofNullable(store.add(user));
    }

    public User findById(int id) {
        return store.findById(id);
    }

    public void update(User user) {
        store.update(user);
    }
}