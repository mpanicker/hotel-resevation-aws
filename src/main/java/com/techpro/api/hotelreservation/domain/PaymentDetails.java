package com.techpro.api.hotelreservation.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

/**
 * Created by manoj on 1/12/2020.
 */
@DynamoDBDocument
public class PaymentDetails {

    private String credit_card_num;
    private String credit_card_type;
    private String expiry_date;
    private String sec_code;
    public Double reservation_total_price;
    public String reservation_currency;
    public Double reservation_tax;
    public String payment_method;

    @DynamoDBAttribute(attributeName = "credit_card_num")
    public String getCredit_card_num() {
        return credit_card_num;
    }

    public void setCredit_card_num(String credit_card_num) {
        this.credit_card_num = credit_card_num;
    }

    @DynamoDBAttribute(attributeName = "credit_card_type")
    public String getCredit_card_type() {
        return credit_card_type;
    }

    public void setCredit_card_type(String credit_card_type) {
        this.credit_card_type = credit_card_type;
    }

    @DynamoDBAttribute(attributeName = "expiry_date")
    public String getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(String expiry_date) {
        this.expiry_date = expiry_date;
    }

    @DynamoDBAttribute(attributeName = "sec_code")
    public String getSec_code() {
        return sec_code;
    }

    public void setSec_code(String sec_code) {
        this.sec_code = sec_code;
    }

    @DynamoDBAttribute(attributeName = "reservation_total_price")
    public Double getReservation_total_price() {
        return reservation_total_price;
    }

    public void setReservation_total_price(Double reservation_total_price) {
        this.reservation_total_price = reservation_total_price;
    }

    @DynamoDBAttribute(attributeName = "reservation_currency")
    public String getReservation_currency() {
        return reservation_currency;
    }

    public void setReservation_currency(String reservation_currency) {
        this.reservation_currency = reservation_currency;
    }

    @DynamoDBAttribute(attributeName = "reservation_tax")
    public Double getReservation_tax() {
        return reservation_tax;
    }

    public void setReservation_tax(Double reservation_tax) {
        this.reservation_tax = reservation_tax;
    }


    @DynamoDBAttribute(attributeName = "payment_method")
    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }


}