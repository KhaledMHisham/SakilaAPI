package gov.iti.jets.sakila.persistence.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "language")
public class Language  extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id", columnDefinition = "TINYINT UNSIGNED not null")
    private Short id;

    @Size(max = 20)
    @NotNull
    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "last_update", columnDefinition = "TIMESTAMP", nullable = false)
    @ColumnDefault("CURRENT_TIMESTAMP")
    private Instant lastUpdate;

    @OneToMany(mappedBy = "language")
    private Set<Film> languageFilms = new LinkedHashSet<>();

    @OneToMany(mappedBy = "originalLanguage")
    private Set<Film> originalLanguageFilms = new LinkedHashSet<>();
}