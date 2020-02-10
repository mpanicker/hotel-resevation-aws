package com.techpro.api.hotelreservation.service;

import com.techpro.api.hotelreservation.db.ReservationRepository;
import com.techpro.api.hotelreservation.domain.Reservation;
import com.techpro.api.hotelreservation.util.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

//@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepo;

    public Reservation getReservation(String bookingNumber) {
        Reservation r = reservationRepo.findByBookingNumber(bookingNumber);
        return r;
    }

    public List<Reservation> getReservationEmail(String email){
        List<Reservation> reservationList = reservationRepo.findByEmail(email);
        return reservationList;
    }

    public Reservation createNewReservation(Reservation newReservation) {
        String bookingNumber = RandomString.getAlphaNumericString(8);
        newReservation.setBookingNumber(bookingNumber);
        //Reservation r = reservationRepo.save(newReservation);
        //return r;
        return null;
    }

    public void updateReservation( String bookingNumber, Reservation newReservation){
        Reservation r = reservationRepo.findByBookingNumber(bookingNumber);

        if (newReservation.getCheck_in_date() != null){
            r.setCheck_in_date(newReservation.getCheck_in_date());
        }
        if (newReservation.getCheck_out_date() != null){
            r.setCheck_out_date(newReservation.getCheck_out_date());
        }
        if (newReservation.getNum_of_guest() != null){
            r.setNum_of_guest(newReservation.getNum_of_guest());
        }
        if (newReservation.getNum_of_rooms() != null){
            r.setNum_of_rooms(newReservation.getNum_of_rooms());
        }
        if (newReservation.getReservation_total_price() != null){
            r.setReservation_total_price(newReservation.getReservation_total_price());
        }
        if (newReservation.getReservation_currency() != null){
            r.setReservation_currency(newReservation.getReservation_currency());
        }
        if (newReservation.getReservation_tax() != null){
            r.setReservation_tax(newReservation.getReservation_tax());
        }
        if (newReservation.getPayment_method() != null){
            r.setPayment_method(newReservation.getPayment_method());
        }

        /*if (newReservation.getHotel_details() != null){
            for(Map.Entry<String, String> entry : newReservation.getHotel_details().entrySet()) {
                if (entry.getValue() != null) {
                    if(r.getHotel_details().containsKey(entry.getKey())){
                        r.getHotel_details().replace(entry.getKey(), entry.getValue());
                    }
                    else{
                        r.getHotel_details().put(entry.getKey(), entry.getValue());
                    }

                }
            }
        }

        if (newReservation.getPayment_details() != null){
            for(Map.Entry<String, String> entry : newReservation.getPayment_details().entrySet()) {
                if (entry.getValue() != null) {
                    r.getPayment_details().replace(entry.getKey(), entry.getValue());
                }
            }
        }

        if (newReservation.getRoom_details() != null){
            for(Map.Entry<String, String> entry : newReservation.getRoom_details().entrySet()) {
                if (entry.getValue() != null) {
                    r.getRoom_details().replace(entry.getKey(), entry.getValue());
                }
            }
        }

        if (newReservation.getPrimary_guest_details() != null){
            for(Map.Entry<String, String> entry : newReservation.getPrimary_guest_details().entrySet()) {
                if (entry.getValue() != null) {
                    r.getPrimary_guest_details().replace(entry.getKey(), entry.getValue());
                }
            }
        }*/
        //reservationRepo.save(r);
    }

    public void deleteReservation ( String bookingNumber){
        Reservation r = reservationRepo.findByBookingNumber(bookingNumber);
        //reservationRepo.delete(r);
    }
}
