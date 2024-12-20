package com.helix.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "Employee")
@Data
public class Employee {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    @Id
    private long id;
    @Column(name = "emp_name")
    private String name;
    @Column(name = "emp_email")
    private String email;
    @Column(name = "joining date")
    private String j_date;
    @Column(name = "mobile number")
    private String Mob_no;

}
