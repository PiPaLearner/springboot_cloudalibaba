package com.personal.user_center.entity.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@Table(name = "cloud_user")
public class CloudUser {
    @Id
    @GeneratedValue(generator = "JDBC")
    private String id;

    private String name;

    private Integer age;

    private String password;

    private String phone;

    private String sex;
}