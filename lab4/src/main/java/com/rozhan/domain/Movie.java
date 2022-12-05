package com.rozhan.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Movie {
    private Integer id;
    private Integer company_id;
    private Integer language_id;
    private Integer actor_id;
    private Integer award_id;
    private String name;
    private String info;
}
