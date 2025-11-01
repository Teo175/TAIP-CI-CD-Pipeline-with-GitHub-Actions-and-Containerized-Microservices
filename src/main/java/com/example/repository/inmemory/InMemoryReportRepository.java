package com.example.repository.inmemory;

import java.util.*;

import com.example.model.Report;
import com.example.repository.interfaces.IReportRepository;

public class InMemoryReportRepository implements IReportRepository {
    private final Map<String, Report> store = new HashMap<>();

    @Override
    public void save(Report report) { store.put(report.getReportId(), report); }

    @Override
    public Report findById(String id) { return store.get(id); }

    @Override
    public Collection<Report> findAll() { return store.values(); }

    @Override
    public void delete(String id) { store.remove(id); }

    @Override
    public boolean exists(String id) { return store.containsKey(id); }
}