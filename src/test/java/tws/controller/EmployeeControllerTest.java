package tws.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import tws.entity.Employee;
import tws.repository.EmployeeMapper;

import java.util.List;

@RunWith(SpringRunner.class)
@MybatisTest
public class EmployeeControllerTest {
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void testSql() {
        //given
        jdbcTemplate.execute("insert into employee values('001','syf',20) ");
        //when
        List<Employee> list = employeeMapper.selectAll();
        //then
        Assert.assertEquals("001",list.get(0).getId());
    }
}
