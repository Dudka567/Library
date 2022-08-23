package com.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "word", schema = "public")
public class Word implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "value", nullable = false)
    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Word(String value) {
        this.value = value;
    }

    protected Word() {
    }
}