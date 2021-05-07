package com.se2.ebanking.models;



import java.sql.Date;


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

    public long getSaving_id() {
        return saving_id;
    }

    public void setSaving_id(long saving_id) {
        this.saving_id = saving_id;
    }

    public Date getOpen_date() {
        return open_date;
    }

    public void setOpen_date(Date open_date) {
        this.open_date = open_date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getSaving_rate() {
        return saving_rate;
    }

    public void setSaving_rate(float saving_rate) {
        this.saving_rate = saving_rate;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }
}
