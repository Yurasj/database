package com.rozhan.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "review", schema = "netflix1", catalog = "")
public class Review {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "comment")
    private String comment;
    @Basic
    @Column(name = "rating")
    private Integer rating;
    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id", nullable = false)
    private Movie movieByMovieId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review that = (Review) o;
        return Objects.equals(id, that.id) && Objects.equals(comment, that.comment) && Objects.equals(rating, that.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, comment, rating);
    }

    public Movie getMovieByMovieId() {
        return movieByMovieId;
    }

    public void setMovieByMovieId(Movie movieByMovieId) {
        this.movieByMovieId = movieByMovieId;
    }
}
