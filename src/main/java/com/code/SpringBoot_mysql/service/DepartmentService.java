package com.code.SpringBoot_mysql.service;

import com.code.SpringBoot_mysql.model.Department;
import com.code.SpringBoot_mysql.error.DepartmentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {
   public void insertDepartment(Department department);

  public List<Department> getdepartment();

   public Department IdDepartment(Long departmentId) throws DepartmentNotFoundException;

   public Department Namedepartments(String departmentName);

   public String Deletedepartment(Long departmentId);

    public  String Updatedepartments(Long departmentId, Department department);


}
