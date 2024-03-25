package com.code.SpringBoot_mysql.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

@Entity
@Data   // getters setters
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    @NotBlank(message = "Department name is missing")
    @Length(min = 2,max = 5)
    private String departmentName;

    private String departmentAddress;
    private String departmentCode;


}
