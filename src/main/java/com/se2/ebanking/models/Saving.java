package com.se2.ebanking.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@NoArgsConstructor
@Getter
@Setter
public class Saving {
    private long saving_id;
    private Date open_date;
    private int duration;
    private float amount;
    private float saving_rate;
    private long customer_id;

    public Saving(long id, float amount, int duration, float saving_rate, long customer_id) {
        this.saving_id=id;
        this.amount=amount;
        this.duration=duration;
        this.saving_rate=saving_rate;
        this.customer_id=customer_id;
    }

    public Saving(float amount, int duration, float saving_rate,  long customer_id,Date open_date) {
        this.amount=amount;
        this.duration=duration;
        this.saving_rate=saving_rate;
        this.customer_id=customer_id;
        this.open_date=open_date;
    }
}
