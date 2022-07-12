package ru.job4j.dreamjob.store;

import ru.job4j.dreamjob.model.Candidate;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class CandidateStore {

    private static final CandidateStore INST = new CandidateStore();

    private final Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();

    private final AtomicInteger idCount = new AtomicInteger();

    private CandidateStore() {
        candidates.put(idCount.incrementAndGet(), new Candidate(idCount.get(), "Фролово Андрей Николаевич",
                "Ищу вакансию на должность младшего Java разработчика",
                LocalDate.of(2022, 6, 20)));
        candidates.put(idCount.incrementAndGet(), new Candidate(idCount.get(), "Middle Java Job",
                "Ищу вакансию на должность ведущего Java разработчика",
                LocalDate.of(2022, 6, 20)));
        candidates.put(idCount.incrementAndGet(), new Candidate(idCount.get(), "Senior Java Job",
                "Ищу вакансию на должность старшего Java разработчика",
                LocalDate.of(2022, 6, 20)));
    }

    public static CandidateStore instOf() {
        return INST;
    }

    public Collection<Candidate> findAll() {
        return candidates.values();
    }

    public void add(Candidate candidate) {
        candidate.setId(idCount.incrementAndGet());
        candidate.setCreated(LocalDate.now());
        candidates.put(candidate.getId(), candidate);
    }

    public Candidate findById(int id) {
        return candidates.get(id);
    }

    public void update(Candidate candidate) {
        candidates.replace(candidate.getId(), candidate);
    }
}
