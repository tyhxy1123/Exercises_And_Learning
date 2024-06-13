package com.javacode2018.chat05.demo2.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class GoodsModel {
    private Integer id;
    private String name;
    private Double price;
}
