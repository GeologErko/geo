package com.practice.springjdbc.dao;

import com.practice.springjdbc.model.Product;
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
public class ProductDaoImpl implements ProductDao {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Product> findAll() {
        String sql = "select * from products";
        return jdbcTemplate.query(sql, this::mapRow);
    }
    @Override
    public Product findById(int id) {
        String sql = "select * from products where id = ?";
        return jdbcTemplate.query(sql, this::mapRow, id)
                .stream()
                .findFirst()
                .orElseThrow();
    }

    @Override
    public Product create(Product product) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("products")
                .usingGeneratedKeyColumns("id");
//                .usingGeneratedKeyColumns("price")
//                .usingGeneratedKeyColumns("category_id");

        Map<String, Object> map = Map.of(
                "name",product.getName(),
                "price", product.getPrice(),
                "category_id", product.getCategoryId()
        );
        int id = simpleJdbcInsert.executeAndReturnKey(map).intValue();
//        int price = simpleJdbcInsert.executeAndReturnKey(map).intValue();
//        int categoryId = simpleJdbcInsert.executeAndReturnKey(map).intValue();
        product.setId(id);
        return product;
    }

    @Override
    public Product update(Product product) {
//  не смог, чтобы по отдельности менять значения
        String sql = "update products set name = ?, price = ?, category_id = ? where id = ?";
        jdbcTemplate.update(sql, product.getName(), product.getPrice(), product.getCategoryId(), product.getId());
        return product;
    }

    @Override
    public void deleteById(int id) {
        String sql = "delete from products where id = ?";
        jdbcTemplate.update(sql, id);
    }

    private Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        int price = rs.getInt("price");
        int categoryId = rs.getInt("category_id");
        return new Product(id, name, price, categoryId);
    }
}
