package com.code.SpringBoot_mysql.service;

import com.code.SpringBoot_mysql.model.Department;
import com.code.SpringBoot_mysql.error.DepartmentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {
   public void insertDepartment(Department department);

  public List<Department> getdepartment() throws DepartmentNotFoundException;

   public Department IdDepartment(Long departmentId) throws DepartmentNotFoundException;

   public Department Namedepartments(String departmentName) throws DepartmentNotFoundException;

   public String Deletedepartment(Long departmentId) throws DepartmentNotFoundException;

    public  Department Updatedepartments(Long departmentId, Department department) throws DepartmentNotFoundException;


    List<Department> serachDeaprtment(String text);
}
