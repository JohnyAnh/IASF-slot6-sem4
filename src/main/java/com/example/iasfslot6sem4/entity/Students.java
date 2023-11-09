package com.example.iasfslot6sem4.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Student")
@Data
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Date birth;
    private String classname;
    private String address;
}
