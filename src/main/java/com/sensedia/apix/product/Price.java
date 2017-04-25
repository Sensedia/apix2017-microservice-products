package com.sensedia.apix.product;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by renanpetronilho on 23/04/17.
 */
public class Price implements Serializable{

    private BigDecimal value;
    private String installment;
    private Integer loyalty;
    private Integer installmentNumber;
    private BigDecimal installmentValue;
    private Boolean available;

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getInstallment() {
        return installment;
    }

    public void setInstallment(String installment) {
        this.installment = installment;
    }

    public Integer getLoyalty() {
        return loyalty;
    }

    public void setLoyalty(Integer loyalty) {
        this.loyalty = loyalty;
    }

    public Integer getInstallmentNumber() {
        return installmentNumber;
    }

    public void setInstallmentNumber(Integer installmentNumber) {
        this.installmentNumber = installmentNumber;
    }

    public BigDecimal getInstallmentValue() {
        return installmentValue;
    }

    public void setInstallmentValue(BigDecimal installmentValue) {
        this.installmentValue = installmentValue;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Price{" +
                "value=" + value +
                ", installment='" + installment + '\'' +
                ", loyalty=" + loyalty +
                ", installmentNumber=" + installmentNumber +
                ", installmentValue=" + installmentValue +
                ", available=" + available +
                '}';
    }
}
