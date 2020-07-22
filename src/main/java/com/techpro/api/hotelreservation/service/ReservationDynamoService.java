package com.techpro.api.hotelreservation.service;

import com.techpro.api.hotelreservation.db.DynamoDBUtil;
import com.techpro.api.hotelreservation.domain.Reservation;
import com.techpro.api.hotelreservation.exception.ReservationException;
import com.techpro.api.hotelreservation.util.RandomString;
import org.codehaus.jackson.map.util.ISO8601Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by manoj on 1/12/2020.
 */
@Service
public class ReservationDynamoService {
    @Autowired
    DynamoDBUtil dynamoDBUtil;

    public Reservation createNewReservation(Reservation newReservation) {
        String bookingNumber = RandomString.getAlphaNumericString(8);
        newReservation.setBookingNumber(bookingNumber);

        Date currentDate = new Date();
        String isoDateStr = ISO8601Utils.format(currentDate);
        newReservation.setDateCreated(isoDateStr);

        Reservation r = dynamoDBUtil.saveReservation(newReservation);
        return r;
    }

    public List<Reservation> getReservationByEmail(String email) {
        List<Reservation> reservations = dynamoDBUtil.getReservationByEmail(email);
        return reservations;
    }

   public Reservation updateReservation(Reservation updatedReservation, String bookingNumber) throws ReservationException{
       Reservation currentReservation = dynamoDBUtil.getReservation(bookingNumber);

       if(currentReservation == null) {
           throw new ReservationException("reservation does not exist",4001, HttpStatus.NOT_FOUND);
       }

       updatedReservation.setBookingNumber(currentReservation.getBookingNumber());
       Reservation modifiedReservation = dynamoDBUtil.saveReservation(updatedReservation);

       return modifiedReservation;
   }

    public Reservation getReservation(String bookingNumber) {
        Reservation r = dynamoDBUtil.getReservation(bookingNumber);
        return r;
    }

    public void deleteReservation(String bookingNumber) {
        Reservation currentReservation = dynamoDBUtil.getReservation(bookingNumber);

        dynamoDBUtil.deleteReservation(currentReservation);

    }
}
