package ru.mytestjava.rest.repository;

import ru.mytestjava.rest.model.QueryString;

import java.util.List;

public interface QueryRepository {
    QueryString save(String str);

    // false if not found
    boolean delete(int id);

    // null if not found
    QueryString get(int id);

    List<QueryString> getAll();
}
