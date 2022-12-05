package com.rozhan.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Review {
    private Integer id;
    private String comment;
    private Integer rating;
    private Integer movie_id;
}
