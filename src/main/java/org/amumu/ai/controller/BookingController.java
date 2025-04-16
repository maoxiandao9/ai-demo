package org.amumu.ai.controller;

import org.amumu.ai.services.BookingTools;
import org.amumu.ai.services.BookingTools.BookingDetails;
import org.amumu.ai.services.FlightBookingService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin
public class BookingController {

	private final FlightBookingService flightBookingService;

	public BookingController(FlightBookingService flightBookingService) {
		this.flightBookingService = flightBookingService;
	}
	@CrossOrigin
	@GetMapping(value = "/booking/list")
	public List<BookingDetails> getBookings() {
		return flightBookingService.getBookings();
	}

}
