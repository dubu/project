package com.dubu.proj.dao;

import com.dubu.proj.dto.Customer;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.QBean;
import com.querydsl.example.sql.QCustomer;
import com.querydsl.sql.SQLQueryFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

import static com.querydsl.core.types.Projections.bean;
import static com.querydsl.example.sql.QCustomer.customer;

/**
 * Created by rigel on 1/13/16.
 */
@Transactional
public class CustomerDao {

    @Inject
    SQLQueryFactory queryFactory;

    private QBean<Customer> customerBean = bean(Customer.class, QCustomer.customer.all());

    public List<Customer> findAll(Predicate... where) {

        List<Customer> fetch = queryFactory.select(customerBean)
                .from(QCustomer.customer)
                .where(where)
                .fetch();

        return fetch;
    }

    public Customer save(Customer c) {

        Integer id = c.getId();

        if (id == null) {
            id = queryFactory.insert(customer)
                    .set(customer.name, c.getName())
                    .executeWithKey(customer.id);
        }

        c.setId(id);
        return c;
    }

}
