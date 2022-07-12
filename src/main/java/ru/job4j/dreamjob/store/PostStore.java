package ru.job4j.dreamjob.store;

import ru.job4j.dreamjob.model.Post;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class PostStore {

    private static final PostStore INST = new PostStore();

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private final AtomicInteger idCount = new AtomicInteger();

    private PostStore() {
        posts.put(idCount.incrementAndGet(), new Post(idCount.get(), "Junior Java Job",
                "В ГК «Программный Продукт» открыта вакансия младшего Java разработчика.",
                LocalDate.of(2022, 6, 20)));
        posts.put(idCount.incrementAndGet(), new Post(idCount.get(), "Middle Java Job",
                "В ГК «Программный Продукт» открыта вакансия ведущего Java разработчика.",
                LocalDate.of(2022, 6, 20)));
        posts.put(idCount.incrementAndGet(), new Post(idCount.get(), "Senior Java Job",
                "В ГК «Программный Продукт» открыта вакансия старшего Java разработчика.",
                LocalDate.of(2022, 6, 20)));
    }

    public static PostStore instOf() {
        return INST;
    }

    public Collection<Post> findAll() {
        return posts.values();
    }

    public void add(Post post) {
        post.setId(idCount.incrementAndGet());
        post.setCreated(LocalDate.now());
        posts.put(post.getId(), post);
    }

    public Post findById(int id) {
        return posts.get(id);
    }

    public void update(Post post) {
        posts.replace(post.getId(), post);
    }
}