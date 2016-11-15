package ru.mytestjava.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mytestjava.rest.model.QueryString;
import ru.mytestjava.rest.repository.QueryRepository;
import ru.mytestjava.rest.util.exception.ExceptionUtil;
import ru.mytestjava.rest.util.exception.NotFoundException;

import java.util.List;

@Service
public class QueryServiceImpl implements QueryService {

    @Autowired
    private QueryRepository repository;

    @Override
    public QueryString save(String str) {
        return repository.save(str);
    }

    @Override
    public void delete(int id) {
        ExceptionUtil.checkNotFoundWithId(repository.delete(id), id);
    }

    @Override
    public QueryString get(int id) throws NotFoundException {
        return ExceptionUtil.checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public List<QueryString> getAll() {
        return repository.getAll();
    }

    @Override
    public void update(String str) {
        repository.save(str);
    }
}
