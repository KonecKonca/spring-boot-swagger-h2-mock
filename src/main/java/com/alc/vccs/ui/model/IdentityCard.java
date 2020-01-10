package com.alc.vccs.ui.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "identity_card")
public class IdentityCard {

    @Id
    @SequenceGenerator(name = "identity_card_id_seq", sequenceName = "identity_card_id_seq", allocationSize = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "identity_card_id_seq")
    private Long identityCardId;
    @Column
    @NotNull
    @Pattern(regexp = "[0-9]*", message = "example of correct identityCardVersion [14357668]")
    private String identityCardVersion;
    @Column
    @NotNull
    @Pattern(regexp = "[0-9]*", message = "example of correct identityCardNumber [14357668]")
    private String identityCardNumber;
    @Column
    @NotNull
    private String identityCardSupplier;
    @Column
    @NotNull
    private LocalDate dateOfIdentityCardReceiving;
    @Column
    @NotNull
    @ElementCollection
    @CollectionTable(name = "city_by_identity_card", joinColumns = @JoinColumn(name = "clientId"))
    private List<String> citiesByIdentityCard;
    @Column
    @NotNull
    private String addressByIdentityCard;

}
