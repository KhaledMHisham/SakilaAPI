package gov.iti.jets.sakila.persistence.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;


    public FilmActor(Actor actor, Film film) {
        this.actor = actor;
        this.film = film;
    }
    @PrePersist
    public void prePersist(){
        if (lastUpdate == null) {
            lastUpdate = Instant.now().truncatedTo(ChronoUnit.SECONDS);
        }
    }
    @PreUpdate
    public void preUpdate(){
        if (lastUpdate == null) {
            lastUpdate = Instant.now().truncatedTo(ChronoUnit.SECONDS);
        }
    }
}