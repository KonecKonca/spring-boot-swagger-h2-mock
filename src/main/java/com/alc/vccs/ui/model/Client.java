package com.alc.vccs.ui.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Currency;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client")
public class Client {

    @Id
    @SequenceGenerator(name = "client_id_seq", sequenceName = "client_id_seq", allocationSize = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_id_seq")
    private Long clientId;
    @Column
    @NotNull
    private String name;
    @Column
    @NotNull
    private String lastName;
    @Column
    @NotNull
    private String fartherName;
    @Column
    @NotNull
    private LocalDate burnDate;
    @Column
    @NotNull
    private Boolean gender;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "identityCardId")
    private IdentityCard identityCard;
    @Column
    @NotNull
    private String areaOfBurn;
    @NotNull
    @ElementCollection
    @CollectionTable(name = "actual_living_cities", joinColumns = @JoinColumn(name = "clientId"))
    @Column
    private List<String> citiesByActualLiving;
    @Column
    @NotNull
    private String addressByActualLiving;
    @Column
    @Pattern(regexp = "[0-9]{4}-[0-9]{3}-[0-9]{2}-[0-9]{2}", message = "example of correct home number [8017-222-11-22]")
    private String homePhone;
    @Column
    @Pattern(regexp = "[+][0-9]{3}[(](25|44|29)[)][0-9]{3}-[0-9]{2}-[0-9]{2}", message = "example of correct mobile number [+375(29)913-05-38]")
    private String mobilePhone;
    @NotNull
    @ElementCollection
    @CollectionTable(name = "family_statuses", joinColumns = @JoinColumn(name = "clientId"))
    @Column
    private List<String> familyStatus;
    @NotNull
    @ElementCollection
    @CollectionTable(name = "citizenship", joinColumns = @JoinColumn(name = "clientId"))
    @Column
    private List<String> citizenship;
    @NotNull
    @ElementCollection
    @CollectionTable(name = "disability", joinColumns = @JoinColumn(name = "clientId"))
    @Column
    private List<String> disability;
    @Column
    private Boolean retiree;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "clientCurrencyId")
    private ClientCurrency monthIncome;

}
