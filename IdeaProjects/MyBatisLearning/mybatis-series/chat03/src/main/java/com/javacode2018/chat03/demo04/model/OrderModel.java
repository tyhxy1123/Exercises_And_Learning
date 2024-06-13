package com.javacode2018.chat03.demo04.model;


import lombok.*;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderModel {
    private Long id;
    private Long user_id;
    private Double price;
}