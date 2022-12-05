package com.rozhan.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Actor {
    private Integer id;
    private String full_name;
    private String bio;
    private Integer age;
}
