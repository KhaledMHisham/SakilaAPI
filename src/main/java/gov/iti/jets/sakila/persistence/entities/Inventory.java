package gov.iti.jets.sakila.persistence.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "inventory")
public class Inventory  extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "film_id", nullable = false)
    private Film film;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @NotNull
    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

    @OneToMany(mappedBy = "inventory")
    private Set<Rental> rentals = new LinkedHashSet<>();

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