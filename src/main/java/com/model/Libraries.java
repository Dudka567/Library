package com.model;

import javax.persistence.*;

@Entity
@Table(name = "libraries", schema = "public")
public class Libraries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "source_language", nullable = false)
    private Languages source_language;

    @ManyToOne
    @JoinColumn(name = "target_language", nullable = false)
    private Languages target_language;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Languages getSource_language() {
        return source_language;
    }

    public void setSource_language(Languages source_language) {
        this.source_language = source_language;
    }

    public Languages getTarget_language() {
        return target_language;
    }

    public void setTarget_language(Languages target_language) {
        this.target_language = target_language;
    }

    public Libraries(Languages source_language, Languages target_language) {
        this.source_language = source_language;
        this.target_language = target_language;
    }

    protected Libraries() {
    }


}
