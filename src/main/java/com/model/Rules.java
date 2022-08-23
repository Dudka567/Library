package com.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rules", schema = "public")
public class Rules implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "pattern", nullable = false)
    private String pattern;

    protected Rules() {
    }

    public Rules(String pattern) {
        this.pattern = pattern;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}