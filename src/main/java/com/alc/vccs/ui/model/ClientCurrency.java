package com.alc.vccs.ui.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.NumberFormat;
import java.util.Locale;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client_currency")
public class ClientCurrency {
    private static final Locale locale = new Locale("en", "US");
    private static final NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

    @Id
    @SequenceGenerator(name = "client_currency_id_seq", sequenceName = "client_currency_id_seq", allocationSize = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_currency_id_seq")
    private Long clientCurrencyId;
    @Column
    private Double currencyValue;

    public ClientCurrency(Double currencyValue) {
        this.currencyValue = currencyValue;
    }

    @Override
    public String toString() {
        return currencyFormatter.format(currencyValue);
    }

}
