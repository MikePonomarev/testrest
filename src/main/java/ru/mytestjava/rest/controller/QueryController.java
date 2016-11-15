package ru.mytestjava.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import ru.mytestjava.rest.model.QueryString;
import ru.mytestjava.rest.service.QueryService;

@RestController
public class QueryController {
    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private QueryService service;

    @GetMapping(value = "/listProcessedStrings")
    public String getAll() {
        LOG.info("getAll");
        return service.getAll().toString();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public QueryString get(@PathVariable("id") int id) {
        LOG.info("get " + id);
        return service.get(id);
    }

    @PostMapping(value = "/countDigits")
    public String create(@RequestParam("str") String str) {
        LOG.info("create " + str);
        QueryString created = service.save(str);
        return String.valueOf(created.getNumberOfDigits());
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") int id) {
        LOG.info("delete " + id);
        service.delete(id);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody String str, @PathVariable("id") int id) {
        LOG.info("update " + str);
        service.update(str);
    }

}
