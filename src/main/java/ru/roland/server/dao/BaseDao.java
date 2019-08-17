package ru.roland.server.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Collection;

public abstract class BaseDao {

    private static final String INSERT_SIMPLE = "INSERT INTO %s(%s) VALUES (%s)";

    protected final String tableName;
    protected final JdbcTemplate jdbcTemplate;

    public BaseDao(String tableName, JdbcTemplate jdbcTemplate) {
        this.tableName = tableName;
        this.jdbcTemplate = jdbcTemplate;
    }

    protected void simpleInsert(Collection<String> columns, Collection values) {
        String columnsForQuery = generateColumnsForQuery(columns);
        String questionsForQuery = generateQuestionsForQuery(values);
        String query = String.format(INSERT_SIMPLE, tableName, columnsForQuery, questionsForQuery);
        jdbcTemplate.update(query, values.toArray());
    }

    protected String generateColumnsForQuery(Collection<String> columns) {
        return String.join(", ", columns);
    }

    protected String generateQuestionsForQuery(Collection values) {
        return "?, ".repeat(values.size() - 1) + "?";
    }

}
