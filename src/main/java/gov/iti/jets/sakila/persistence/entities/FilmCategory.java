package gov.iti.jets.sakila.persistence.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "film_category")
public class FilmCategory  extends BaseEntity{
    @EmbeddedId
    private FilmCategoryId id = new FilmCategoryId();

    @MapsId("filmId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "film_id", nullable = false)
    private Film film;

    @MapsId("categoryId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(name = "last_update", columnDefinition = "TIMESTAMP", nullable = false)
    @ColumnDefault("CURRENT_TIMESTAMP")
    private Instant lastUpdate;

    public FilmCategory(Film film, Category category) {
        this.film = film;
        this.category = category;
    }
}