package ru.mytestjava.rest.service;

import ru.mytestjava.rest.model.QueryString;
import ru.mytestjava.rest.util.exception.NotFoundException;

import java.util.List;

public interface QueryService {

    QueryString save(String str);

    void delete(int id) throws NotFoundException;

    QueryString get(int id) throws NotFoundException;

    List<QueryString> getAll();

    void update(String str);

}
