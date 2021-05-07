package com.se2.ebanking.models;



public class TransactionRate {
    private float saving_rate;
    private float loan_rate;
    private float fee;

    public TransactionRate(float loan_rate, float saving_rate, float fee) {
        this.saving_rate = saving_rate;
        this.loan_rate = loan_rate;
        this.fee = fee;
    }

    public float getSaving_rate() {
        return saving_rate;
    }

    public void setSaving_rate(float saving_rate) {
        this.saving_rate = saving_rate;
    }

    public float getLoan_rate() {
        return loan_rate;
    }

    public void setLoan_rate(float loan_rate) {
        this.loan_rate = loan_rate;
    }

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }
}
