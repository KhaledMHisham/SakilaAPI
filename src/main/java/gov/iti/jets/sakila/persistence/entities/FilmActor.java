package gov.iti.jets.sakila.persistence.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "film_actor")
public class FilmActor  extends BaseEntity{
    @EmbeddedId
    private FilmActorId id = new FilmActorId();

    @MapsId("actorId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "actor_id", nullable = false)
    private Actor actor;

    @MapsId("filmId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "film_id", nullable = false)
    private Film film;

    @NotNull
    @Column(name = "last_update", columnDefinition = "TIMESTAMP", nullable = false)
    @ColumnDefault("CURRENT_TIMESTAMP")
    private Instant lastUpdate;


    public FilmActor(Actor actor, Film film) {
        this.actor = actor;
        this.film = film;
    }
}