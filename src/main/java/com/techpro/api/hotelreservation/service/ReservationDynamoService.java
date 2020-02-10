package com.techpro.api.hotelreservation.service;

import com.techpro.api.hotelreservation.db.DynamoDBUtil;
import com.techpro.api.hotelreservation.domain.Reservation;
import com.techpro.api.hotelreservation.util.RandomString;
import org.codehaus.jackson.map.util.ISO8601Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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

        Reservation r = dynamoDBUtil.saveReservation(newReservation,"us-east-1");
        return r;
    }

   /* public Reservation getReservationByEmail(String email) {
        Reservation r = dynamoDBUtil.getReservationByEmail(email);
        return r;
    }*/

    public Reservation getReservation(String bookingNumber) {
        Reservation r = dynamoDBUtil.getReservation(bookingNumber);
        return r;
    }
}
