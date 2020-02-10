package com.techpro.api.hotelreservation.db;

import com.techpro.api.hotelreservation.domain.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by manoj on 8/8/2019.
 */
public interface ReservationRepository{ // extends MongoRepository<Reservation,String>{

    public Reservation findByBookingNumber(String bookingNumber);

    public List<Reservation> findByEmail(String email);

    public Reservation createNewReservation(Reservation newReservation);

    public Reservation createNewReservation(String alphaNumericString, int i, int i1, String s);

    //public void createNewReservation(Reservation r);
}

/*public class findByEmail implements ReservationRepository{
    @Override
    public List<Reservation> findByEmail(String email) {

        return null;
    }
}*/

/*
abstract class  findByEmail implements ReservationRepository{
    @Autowired
    ReservationRepository reservationRepo;

    List<Reservation> reservationList = reservationRepo.findAll();

    @Override
    public List<Reservation> findByEmail(String email){
         for(Reservation reservation: reservationList){
             //String guestEmail;
             //String guestEmail = reservation.getPrimary_guest_details().get(email);
             if(reservation.getPrimary_guest_details().containsValue(email)){
                 reservationList.add(reservation);
             }
         }

        return reservationList;
    }

    public static void main(String[] args){
        findingByEmail(email);
    }
}
*/
