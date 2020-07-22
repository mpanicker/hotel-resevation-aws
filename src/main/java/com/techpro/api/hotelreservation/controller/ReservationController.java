package com.techpro.api.hotelreservation.controller;

//import com.mongodb.util.JSON;
import com.techpro.api.hotelreservation.domain.Reservation;
import com.techpro.api.hotelreservation.exception.ReservationException;
import com.techpro.api.hotelreservation.service.ReservationDynamoService;
import com.techpro.api.hotelreservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;


@RestController
@RequestMapping("/api/v1")
public class ReservationController {
    @Autowired
    ReservationDynamoService reservationService;

    // API - read
    //@PreAuthorize("(#oauth2.hasScope('reservation') and #oauth2.hasScope('read')) or hasRole('ADMIN')")
    @GetMapping("/reservation/{bookingNumber}")
    public ResponseEntity<?> getReservationByBookingNumber(@PathVariable final String bookingNumber) {
        Reservation r = reservationService.getReservation(bookingNumber);
        return ResponseEntity.ok().body(r);
    }

    @GetMapping("/reservation")
    public List<?> getReservationByEmail(@RequestParam final String email){
        List<Reservation> reservationList = reservationService.getReservationByEmail(email);
        return reservationList;
    }
    //change contract email_address

    @PostMapping( "/reservation")
    @ResponseBody
    public Reservation createReservation(@RequestBody Reservation newReservation){
        Reservation r = reservationService.createNewReservation(newReservation);
        return r;
    }

    @PutMapping("/reservation/{bookingNumber}")
    public ResponseEntity<?> updateReservation(@PathVariable final String bookingNumber, @RequestBody Reservation newReservation){
        Reservation r = null;
        try {
            r = reservationService.updateReservation(newReservation, bookingNumber);

        } catch (ReservationException re) {
            return ResponseEntity.badRequest().body(re);
        }
        return ResponseEntity.ok().body(r);
    }

    @DeleteMapping("/reservation/{bookingNumber}")
    public void deleteReservation(@PathVariable final String bookingNumber) {
        reservationService.deleteReservation(bookingNumber);
    }

}
