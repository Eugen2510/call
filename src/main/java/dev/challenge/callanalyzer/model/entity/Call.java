package dev.challenge.callanalyzer.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "call")
@Getter
@Setter
public class Call {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "location")
    private String location;
    @Column(name = "emotional_tone")
    @Enumerated(EnumType.STRING)
    private EmotionalTone emotionalTone;
    @Column(name = "text")
    private String text;
    @ManyToMany
    @JoinTable(
            name = "call_category",  // Имя промежуточной таблицы
            joinColumns = @JoinColumn(name = "call_id"),  // Колонка, связывающая с таблицей Student
            inverseJoinColumns = @JoinColumn(name = "category_id")  // Колонка, связывающая с таблицей Course
    )
    private Set<Category> categories = new HashSet<>();

    public enum EmotionalTone{
        NEUTRAL,
        POSITIVE,
        NEGATIVE,
        ANGRY
    }
}
/*
 id BIGSERIAL PRIMARY KEY,
    name VARCHAR,
    location VARCHAR,
    emotional_tone VARCHAR NOT NULL CHECK (emotional_tone IN ('Neutral', ', Positive', ', Negative', 'Angry')),
    text VARCHAR
 */
