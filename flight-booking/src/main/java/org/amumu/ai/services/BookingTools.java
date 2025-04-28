package org.amumu.ai.services;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.amumu.ai.data.BookingStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.core.NestedExceptionUtils;

import java.time.LocalDate;
import java.util.function.Function;

@Configuration
public class BookingTools {

	@Autowired
	private FlightBookingService flightBookingService;

	@JsonInclude(Include.NON_NULL)
	public record BookingDetails(String bookingNumber, String name, LocalDate date, BookingStatus bookingStatus,
			String from, String to, String bookingClass) {
	}

	public record CancelBookingRequest(String bookingNumber, String name) {}

	public record BookingDetailsRequest(String bookingNumber, String name) {}

	@Bean
	@Description("处理机票退订")
	public Function<CancelBookingRequest, String> cancelBooking() {
		return cancelBookingRequest -> {
			// apply 调用退订方法
			flightBookingService.cancelBooking(cancelBookingRequest.bookingNumber(), cancelBookingRequest.name());
			return "退订成功";
		};
	}

	@Bean
	@Description("获取机票预定详细信息")
	public Function<BookingDetailsRequest, BookingDetails> getBookingDetails() {
		return request -> {
			try {
				return flightBookingService.getBookingDetails(request.bookingNumber(), request.name());
			} catch (Exception e) {
				return new BookingDetails(request.bookingNumber(), request.name(), null, null, null, null, null);
			}
		};
	}
}
