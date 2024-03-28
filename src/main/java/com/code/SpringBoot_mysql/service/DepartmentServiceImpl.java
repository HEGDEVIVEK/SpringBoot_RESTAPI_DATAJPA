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

    }

    @Override
    public List<Department> getdepartment() throws DepartmentNotFoundException {
        List<Department> departments=  departmentRepository.findAll();
        if(departments.isEmpty())
        {
            throw new  DepartmentNotFoundException("No department data Info found");
        }
        else
        {
            return departments;
        }
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
    public Department Namedepartments(String departmentName) throws DepartmentNotFoundException {
        //For inbulit Direct Intreface

        Department department= departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
        //return departmentRepository.findByName(departmentName);

        if(department!=null)
        {
            return department;
        }
        else
        {
            throw new DepartmentNotFoundException("DepartmentName "+departmentName+" Info not present");
        }

    }

    @Override
    public String Deletedepartment(Long departmentId) throws DepartmentNotFoundException {

        Optional<Department> department = departmentRepository.findById(departmentId);
        if(department.isPresent())
        {
            departmentRepository.deleteById(departmentId);
            return "DepartmentId "+departmentId+" deleted successfully!!";
        }
        else
        {
            throw new DepartmentNotFoundException("DepartmentName "+departmentId+" Info not present");
        }
    }

    @Override
    public Department Updatedepartments(Long departmentId, Department department) throws DepartmentNotFoundException {
        Optional<Department> department1 = departmentRepository.findById(departmentId);
       if(department1.isPresent())
       {

           Department department2=department1.get();
           department2.setDepartmentName(department.getDepartmentName());
           department2.setDepartmentAddress(department.getDepartmentAddress());
           department2.setDepartmentCode(department.getDepartmentCode());
           departmentRepository.save(department2);

           return departmentRepository.findById(departmentId).get();
       }
       else
        {
            throw new DepartmentNotFoundException("DepartmentName "+departmentId+" Info not present");
        }

    }

    @Override
    public List<Department> serachDeaprtment(String text)
    {
        return  departmentRepository.findByDepartmentNameIgnoreCaseContainingOrDepartmentAddressIgnoreCaseContaining(text, text);    }

}
