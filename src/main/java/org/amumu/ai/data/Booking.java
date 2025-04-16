package org.amumu.ai.data;

import java.time.LocalDate;
// 航班信息
public class Booking {

	private String bookingNumber;

	private LocalDate date;

	private LocalDate bookingTo;

	private org.amumu.ai.data.Customer customer;

	private String from;

	private String to;

	private org.amumu.ai.data.BookingStatus bookingStatus;

	private org.amumu.ai.data.BookingClass bookingClass;

	public Booking(String bookingNumber, LocalDate date, org.amumu.ai.data.Customer customer, org.amumu.ai.data.BookingStatus bookingStatus, String from,
				   String to, org.amumu.ai.data.BookingClass bookingClass) {
		this.bookingNumber = bookingNumber;
		this.date = date;
		this.customer = customer;
		this.bookingStatus = bookingStatus;
		this.from = from;
		this.to = to;
		this.bookingClass = bookingClass;
	}

	public String getBookingNumber() {
		return bookingNumber;
	}

	public void setBookingNumber(String bookingNumber) {
		this.bookingNumber = bookingNumber;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalDate getBookingTo() {
		return bookingTo;
	}

	public void setBookingTo(LocalDate bookingTo) {
		this.bookingTo = bookingTo;
	}

	public org.amumu.ai.data.Customer getCustomer() {
		return customer;
	}

	public void setCustomer(org.amumu.ai.data.Customer customer) {
		this.customer = customer;
	}

	public org.amumu.ai.data.BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(org.amumu.ai.data.BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public org.amumu.ai.data.BookingClass getBookingClass() {
		return bookingClass;
	}

	public void setBookingClass(org.amumu.ai.data.BookingClass bookingClass) {
		this.bookingClass = bookingClass;
	}

}