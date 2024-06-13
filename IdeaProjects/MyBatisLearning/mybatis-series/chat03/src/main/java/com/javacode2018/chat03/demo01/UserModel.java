package com.javacode2018.chat03.demo01;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Alias("user")
public class UserModel {
    private long id;
    private String name;
    private int age;
    private double salary;
    private int sex;
}
