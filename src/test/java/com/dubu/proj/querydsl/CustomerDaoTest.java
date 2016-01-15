package com.dubu.proj.querydsl;

import com.dubu.proj.configration.TestConfiguration;
import com.dubu.proj.dao.CustomerDao;
import com.dubu.proj.dto.Customer;
import com.querydsl.core.types.QBean;
import com.querydsl.example.sql.QCustomer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import static com.querydsl.core.types.Projections.bean;
import static com.querydsl.example.sql.QCustomer.customer;

/**
 * Created by rigel on 1/13/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class})
@Transactional
public class CustomerDaoTest {


    final QBean<Customer> customerQBean = bean(Customer.class, customer.all());

    @Resource
    private CustomerDao customerDao;


    //    @Before
    public void setUp() {
        save();
    }


    @Test
    public void findAll() {

        Customer customer = new Customer();
        String name = customer.getName();


    }

    public void save() {

        Customer customer = new Customer();
        customer.setName("SmallS");
        final Customer save = customerDao.save(customer);
        System.out.println(save.getId());
    }

    @Test
    public void 찾아라() {

//        CustomerDao customerDao  =  new CustomerDao();
        Integer id = 10;
//        final List<Customer> all = customerDao.findAll(customer.id.eq(id));
        final List<Customer> all = customerDao.findAll();
        System.out.println(all);
    }
}
