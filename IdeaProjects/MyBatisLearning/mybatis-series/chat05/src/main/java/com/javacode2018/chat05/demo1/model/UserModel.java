package com.javacode2018.chat05.demo1.model;


import lombok.*;

@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserModel {
    private Integer id;
    private String name;
}
