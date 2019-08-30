package tws.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tws.entity.Employee;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    List<Employee> selectAll();

    void addEmploy(Employee employee);

    List<Employee> selectSome(@Param("id") String id, @Param("name") String name);

    void updateOne(Employee employee);

    void deleteOne(@Param("id") String id);

    List<Employee> selectWithPage(@Param("offset") Integer offset, @Param("limit") Integer limit);

    Employee select(@Param("name") String name);
}
