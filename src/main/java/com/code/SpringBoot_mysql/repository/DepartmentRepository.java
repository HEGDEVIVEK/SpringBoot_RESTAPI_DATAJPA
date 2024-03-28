package com.code.SpringBoot_mysql.repository;

import com.code.SpringBoot_mysql.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface DepartmentRepository extends JpaRepository<Department, Long>
{
   public Department findByDepartmentNameIgnoreCase(String departmentName);

   public List<Department> findByDepartmentNameIgnoreCaseContainingOrDepartmentAddressIgnoreCaseContaining(String text, String text1);

   


   /* @Query("select d from Department d where d.departmentName=:nameD")

    public Department findByName(@Param("nameD") String name);

    */


    /*@Query("select d from Department d where d.departmentName=?1")

    public Department findByName(String name);*/


    /*@Query(value = "select * from DEPARTMENT where DEPARTMENT_NAME=?1", nativeQuery = true)

    public Department findByName(String name);*/
}
