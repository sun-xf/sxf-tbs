package com.sysware.ke.tbs.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private int status = 0;
}
