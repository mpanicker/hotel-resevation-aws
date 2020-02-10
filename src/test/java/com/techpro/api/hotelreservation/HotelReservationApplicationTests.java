package com.techpro.api.hotelreservation;

import com.techpro.api.hotelreservation.db.DynamoDBUtil;
import com.techpro.api.hotelreservation.db.ReservationRepository;
import com.techpro.api.hotelreservation.domain.Reservation;
import com.techpro.api.hotelreservation.service.ReservationDynamoService;
import com.techpro.api.hotelreservation.util.RandomString;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelReservationApplicationTests {
	@Autowired
	ReservationDynamoService reservationDynamoService;

	Reservation firstBooking, secondBooking;

	@Before
	public void setUp() {

		//reservationRepo.deleteAll();
		firstBooking = new Reservation();
		//firstBooking.setEmail("manoj@yahoo.com");

		//firstBooking = dynamoDBUtil.saveReservation(new Reservation(RandomString.getAlphaNumericString(8), 2, 3),"");
		//secondBooking = dynamoDBUtil.saveReservation(new Reservation(RandomString.getAlphaNumericString(8),4,4),"");

	}

	@Test
	public void setsIdOnSave() {

		Reservation manoj_reservation = reservationDynamoService.createNewReservation(firstBooking);
		assertThat(manoj_reservation.bookingNumber).isNotNull();

	}


	@Test
	public void findByEmail() {
		Reservation result = reservationDynamoService.getReservation("xxx");
		Assert.assertNull(result);

	}

	/*@Test
	public void findByBookingNumber() {

		Reservation manoj_reservation = reservationDynamoService.createNewReservation(firstBooking);
		Assert.assertEquals(reservationDynamoService.getReservation(manoj_reservation.getBookingNumber()).getEmail(),"manoj@yahoo.com");

	}*/

/*	@Test
	public void createNewReservationTest(){
		//Reservation  r = new Reservation(RandomString.getAlphaNumericString(8),2, 3,"masong18@gmail.com");
		Reservation r = reservationRepo.createNewReservation(RandomString.getAlphaNumericString(8),2, 3,"masong18@gmail.com");
		//Reservation result = createNewReservation(RandomString.getAlphaNumericString(8), 2, 3, "masong18@gmail.com");
		Assert.assertEquals(r.getEmail(), "masong18@gmail.com");
	}*/

}
