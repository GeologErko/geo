package com.practice.springjdbc.dao;

import com.practice.springjdbc.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
@Component
@RequiredArgsConstructor
public class CategoryDaoImpl implements CategoryDao {

    private final JdbcTemplate jdbcTemplate;
    //.queryForRowSet - для отправки select запроса, возвращает тип SqlRowSet
    //.update - для отправки insert/update/delete запросов
    //ORM (Object Relational Mapping)
    //.query - возвращает

    @Override
    public List<Category> findAll() {
        String sql = "select * from categories";
        return jdbcTemplate.query(sql, this::mapRow);
    }
        /*
        String sql = "select * from categories";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql);
        List<Category> result = new ArrayList<>();

        while (sqlRowSet.next()){
           int id = sqlRowSet.getInt("id");
           String name = sqlRowSet.getString("name");
           Category category = new Category(id, name);
           result.add(category);
       }
        return result;
    }

         */
    //  RowMapper - функциональный интерфейс, в котором необходимо описать как преобразовать результат в объек
//    RowMapper<Category> rowMapper = new RowMapper<Category>() {
//
//        @Override
//        public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//            String sql = "select * from categories";
//            return jdbcTemplate.query(sql, this::mapRow)
//        }
//
//        String sql = "select * from categories";
//        ret
//    }
    @Override
    public Category findById(int id) {
        String sql = "select * from categories where id = ?";
        return jdbcTemplate.query(sql, this::mapRow, id)
                .stream()
                .findFirst()
                .orElseThrow();
    }
    @Override
    public Category create(Category category) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("categories")
                .usingGeneratedKeyColumns("id");

        Map<String, Object> map = Map.of(
                "name", category.getName()
        );

        int id = simpleJdbcInsert.executeAndReturnKey(map).intValue();
        category.setId(id);
        return category;
    }

    @Override
    public Category update(Category category) {
        String sql = "update categories set name = ? where id = ?";
        jdbcTemplate.update(sql, category.getName(), category.getId());
        return category;
    }

    @Override
    public void deleteById(int id) {
        String sql = "delete from categories where id = ?";
        jdbcTemplate.update(sql, id);

    }

    private Category mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        return new Category(id, name);
    }
}
