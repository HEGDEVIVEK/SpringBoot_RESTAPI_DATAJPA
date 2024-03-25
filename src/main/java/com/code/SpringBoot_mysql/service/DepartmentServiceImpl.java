package com.code.SpringBoot_mysql.service;

import com.code.SpringBoot_mysql.model.Department;
import com.code.SpringBoot_mysql.error.DepartmentNotFoundException;
import com.code.SpringBoot_mysql.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public void insertDepartment(Department department) {
        departmentRepository.save(department);
        //System.out.println(departmentRepository);
    }

    @Override
    public List<Department> getdepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department IdDepartment(Long departmentId) throws DepartmentNotFoundException {

        Optional<Department> department=  departmentRepository.findById(departmentId);
        if(department.isPresent())
        {
            return department.get();
        }
        else
        {
            throw new DepartmentNotFoundException("DepartmentID "+departmentId+" Info not present");
        }
    }

    @Override
    public Department Namedepartments(String departmentName)
    {
        //For inbulit Direct Intreface
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);

        //return departmentRepository.findByName(departmentName);

    }

    @Override
    public String Deletedepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).get();
        if(department!=null)
        {
            departmentRepository.deleteById(departmentId);
            return "DepartmentId "+departmentId+" deleted successfully!!";
        }
        else
        {
            return null;
        }
    }

    @Override
    public String Updatedepartments(Long departmentId, Department department) {
      Department department1 = departmentRepository.findById(departmentId).get();
       if(department1!=null)
       {

           department1.setDepartmentName(department.getDepartmentName());
           department1.setDepartmentAddress(department.getDepartmentAddress());
           department1.setDepartmentCode(department.getDepartmentCode());
           departmentRepository.save(department1);

           return "Successfully Department "+ departmentId+" Updated";
       }
       else
        {
            return null;
        }

    }

}
