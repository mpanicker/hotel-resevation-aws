package com.techpro.api.hotelreservation.domain;

/**
 * Created by manoj on 1/12/2020.
 */
public class HotelDetails {

    private String hotel_name;
    private String hotel_address;
    private String hotel_phone;

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getHotel_address() {
        return hotel_address;
    }

    public void setHotel_address(String hotel_address) {
        this.hotel_address = hotel_address;
    }

    public String getHotel_phone() {
        return hotel_phone;
    }

    public void setHotel_phone(String hotel_phone) {
        this.hotel_phone = hotel_phone;
    }
}