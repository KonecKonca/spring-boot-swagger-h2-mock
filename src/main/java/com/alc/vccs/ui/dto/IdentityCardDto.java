package com.alc.vccs.ui.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class IdentityCardDto {
    private Long identityCardId;
    private String identityCardVersion;
    private String identityCardNumber;
    private String identityCardSupplier;
    private String dateOfIdentityCardReceiving;
    private List<String> citiesByIdentityCard;
    private String addressByIdentityCard;
}
