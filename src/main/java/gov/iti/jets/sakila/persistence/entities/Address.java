package gov.iti.jets.sakila.persistence.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "address")
@ToString
public class Address extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", columnDefinition = "SMALLINT UNSIGNED not null")
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "address", nullable = false, length = 50)
    private String address;

    @Size(max = 50)
    @Column(name = "address2", length = 50)
    private String address2;

    @Size(max = 20)
    @NotNull
    @Column(name = "district", nullable = false, length = 20)
    private String district;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @Size(max = 10)
    @Column(name = "postal_code", length = 10)
    private String postalCode;

    @Size(max = 20)
    @NotNull
    @Column(name = "phone", nullable = false, length = 20)
    private String phone;

    @NotNull
    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

    @OneToMany(mappedBy = "address")
    private Set<Staff> staff = new LinkedHashSet<>();

    @OneToMany(mappedBy = "address")
    private Set<Store> stores = new LinkedHashSet<>();
    @OneToMany(mappedBy = "address")
    private Set<Customer> customers = new LinkedHashSet<>();

    @Lob
    @Column(name = "location", columnDefinition = "GEOMETRY(65535) not null")
    private byte[] location;

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