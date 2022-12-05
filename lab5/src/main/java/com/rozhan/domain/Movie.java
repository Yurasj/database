package com.rozhan.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "movie", schema = "netflix1", catalog = "")
public class Movie {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "info")
    private String info;
    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id", nullable = false)
    private Company company;
    @ManyToOne
    @JoinColumn(name = "language_id", referencedColumnName = "id", nullable = false)
    private Language language;
    @ManyToOne
    @JoinColumn(name = "actor_id", referencedColumnName = "id", nullable = false)
    private Actor actor;
    @ManyToOne
    @JoinColumn(name = "award_id", referencedColumnName = "id")
    private Award award;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie that = (Movie) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(info, that.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, info);
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Award getAward() {
        return award;
    }

    public void setAward(Award award) {
        this.award = award;
    }
}
