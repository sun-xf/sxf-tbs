package com.sysware.ke.tbs.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class Department {
    private int id;
    private String name;
    private int totalNumber;
    private int status = 0;
}
