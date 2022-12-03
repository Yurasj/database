package com.rozhan.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "language", schema = "netflix1", catalog = "")
public class Language {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "language")
    private String language;
    @OneToMany(mappedBy = "language")
    private Collection<Movie> moviesById;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Language that = (Language) o;
        return Objects.equals(id, that.id) && Objects.equals(language, that.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, language);
    }

    public Collection<Movie> getMoviesById() {
        return moviesById;
    }

    public void setMoviesById(Collection<Movie> moviesById) {
        this.moviesById = moviesById;
    }
}
