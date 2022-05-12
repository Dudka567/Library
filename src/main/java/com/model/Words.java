package com.model;

import javax.persistence.*;

@Entity
@Table(name = "words", schema = "public")
public class Words {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "languages_first_id", nullable = false)
    private Languages language1;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "word_first_id", nullable = false)
    private Word word1;

    @ManyToOne
    @JoinColumn(name = "languages_second_id", nullable = false)
    private Languages language2;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "word_second_id", nullable = false)
    private Word word2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Languages getLanguage1() {
        return language1;
    }

    public void setLanguage1(Languages language1) {
        this.language1 = language1;
    }

    public Word getWord1() {
        return word1;
    }

    public void setWord1(Word word1) {
        this.word1 = word1;
    }

    public Languages getLanguage2() {
        return language2;
    }

    public void setLanguage2(Languages language2) {
        this.language2 = language2;
    }

    public Word getWord2() {
        return word2;
    }

    public void setWord2(Word word2) {
        this.word2 = word2;
    }

    public Words(Languages language1, Word word1, Languages language2, Word word2) {
        this.language1 = language1;
        this.word1 = word1;
        this.language2 = language2;
        this.word2 = word2;
    }

    protected Words() {
    }
}
