package com.se2.ebanking.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Settings {
    private float saving_rate;
    private float loan_rate;
    private float fee;

    public Settings(float saving_rate, float loan_rate, float fee) {
        this.saving_rate = saving_rate;
        this.loan_rate = loan_rate;
        this.fee = fee;
    }
}
