package com.alc.vccs.ui.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Currency;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientDto {

    private Long clientId;
    private String name;
    private String lastName;
    private String fartherName;
    private String burnDate;
    private Boolean gender;
    private IdentityCardDto identityCardDto;
    private String areaOfBurn;
    private List<String> citiesByActualLiving;
    private String addressByActualLiving;
    private String homePhone;
    private String mobilePhone;
    private List<String> familyStatus;
    private List<String> citizenship;
    private List<String> disability;
    private Boolean retiree;
    private Double monthIncome;

}
