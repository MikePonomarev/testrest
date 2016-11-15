package ru.mytestjava.rest.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import ru.mytestjava.rest.model.QueryString;
import ru.mytestjava.rest.repository.QueryRepository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JdbcQueryRepositoryImpl implements QueryRepository {

    private static final BeanPropertyRowMapper<QueryString> ROW_MAPPER = BeanPropertyRowMapper.newInstance(QueryString.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private SimpleJdbcInsert insertQuery;

    @Autowired
    public JdbcQueryRepositoryImpl(DataSource dataSource) {
        this.insertQuery = new SimpleJdbcInsert(dataSource)
                .withTableName("queries")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public QueryString save(String str) {
        QueryString queryString = new QueryString(str.trim());
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", queryString.getId())
                .addValue("queryText", queryString.getQueryText())
                .addValue("numberOfDigits", queryString.getNumberOfDigits());

        if (queryString.isNew()) {
            Number newKey = insertQuery.executeAndReturnKey(map);
            queryString.setId(newKey.intValue());
        } else {
            namedParameterJdbcTemplate.update(
                    "UPDATE queries SET queryText=:queryText, numberOfDigits=:numberOfDigits WHERE id=:id", map);
        }
        return queryString;
    }

    @Override
    public boolean delete(int id) {
        return jdbcTemplate.update("DELETE FROM queries WHERE id=?", id) != 0;
    }

    @Override
    public QueryString get(int id) {
        List<QueryString> users = jdbcTemplate.query("SELECT * FROM queries WHERE id=?", ROW_MAPPER, id);
        return DataAccessUtils.singleResult(users);
    }

    @Override
    public List<QueryString> getAll() {
        return jdbcTemplate.query("SELECT *  FROM queries", ROW_MAPPER);
    }
}
