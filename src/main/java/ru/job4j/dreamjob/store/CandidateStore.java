package ru.job4j.dreamjob.store;

import ru.job4j.dreamjob.model.Candidate;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CandidateStore {

    private static final CandidateStore INST = new CandidateStore();

    private final Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();

    private CandidateStore() {
        candidates.put(1, new Candidate(1, "Фролово Андрей Николаевич",
                "Ищу вакансию на должность младшего Java разработчика",
                LocalDate.of(2022, 6, 20)));
        candidates.put(2, new Candidate(2, "Middle Java Job",
                "Ищу вакансию на должность ведущего Java разработчика",
                LocalDate.of(2022, 6, 20)));
        candidates.put(3, new Candidate(3, "Senior Java Job",
                "Ищу вакансию на должность старшего Java разработчика",
                LocalDate.of(2022, 6, 20)));
    }

    public static CandidateStore instOf() {
        return INST;
    }

    public Collection<Candidate> findAll() {
        return candidates.values();
    }
}
