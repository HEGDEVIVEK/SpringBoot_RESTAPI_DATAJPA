package com.code.SpringBoot_mysql.controller;

import com.code.SpringBoot_mysql.model.Department;
import com.code.SpringBoot_mysql.error.DepartmentNotFoundException;
import com.code.SpringBoot_mysql.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/insdepartments")
    public void saveDepartment(@Valid @RequestBody Department department)
    {
          departmentService.insertDepartment(department);

    }

   @GetMapping("/getdepartments")
    public List<Department> getDepartment()
   {
       return departmentService.getdepartment();
   }

   @GetMapping("/Iddepartments/{id}")
    public Department IdDepartment(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {

      return  departmentService.IdDepartment(departmentId);

   }

   @GetMapping("/Namedepartments/{name}")
   public ResponseEntity<Department> Namedepartments(@PathVariable("name") String departmentName)
   {
       Department department= departmentService.Namedepartments(departmentName);
       if(department!=null)
       {
           return new ResponseEntity<>(department, HttpStatus.OK);
       }
       else
       {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
   }

   @DeleteMapping("/Deletedepartments/{id}")
    public ResponseEntity<String> Deletedepartment(@PathVariable("id") Long departmentId)
   {

       String message=departmentService.Deletedepartment(departmentId);
       if(message!=null)
       {
           return new ResponseEntity<>(message, HttpStatus.OK);
       }
       else
       {
           return new ResponseEntity<>("DepartmentId "+departmentId+" NOt present !!",HttpStatus.NOT_FOUND);
       }


   }


   @PutMapping("/Updatedepartments/{id}")
    public ResponseEntity<String> Updatedepartments(@PathVariable("id") Long departmentId,
                                    @RequestBody Department department)

   {
       String message1=departmentService.Updatedepartments(departmentId,department);
       if(message1!=null)
       {
           return new ResponseEntity<>(message1, HttpStatus.OK);
       }
       else
       {
           return new ResponseEntity<>("Department "+departmentId+" Not found",HttpStatus.NOT_FOUND);

       }
   }


}
