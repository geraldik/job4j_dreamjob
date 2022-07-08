package ru.job4j.dreamjob.store;

import ru.job4j.dreamjob.model.Post;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PostStore {

    private static final PostStore INST = new PostStore();

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private PostStore() {
        posts.put(1, new Post(1, "Junior Java Job",
                "В ГК «Программный Продукт» открыта вакансия младшего Java разработчика.",
                LocalDate.of(2022, 6, 20)));
        posts.put(2, new Post(2, "Middle Java Job",
                "В ГК «Программный Продукт» открыта вакансия ведущего Java разработчика.",
                LocalDate.of(2022, 6, 20)));
        posts.put(3, new Post(3, "Senior Java Job",
                "В ГК «Программный Продукт» открыта вакансия старшего Java разработчика.",
                LocalDate.of(2022, 6, 20)));
    }

    public static PostStore instOf() {
        return INST;
    }

    public Collection<Post> findAll() {
        return posts.values();
    }
}