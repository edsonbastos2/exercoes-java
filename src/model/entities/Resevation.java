package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Resevation {
	private Integer roomNumber;
	private Date checkin;
	private Date checkOut;
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Resevation(Integer roomNumber, Date checkin, Date checkOut) throws DomainException {
		if(!checkOut.after(checkin)) {
			throw new DomainException(" Check-out date must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkOut = checkOut;
	}
	
	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckOut() {
		return checkOut;
	}


	public long duration() {
		long diff = checkOut.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public String toString() {
		return "Romm " 
				+ roomNumber 
				+ ", checkin: " 
				+ sdf.format(checkin) 
				+ ", checkout: " 
				+ sdf.format(checkOut)
				+ ", "
				+ duration() + " nights.";
	}
	
	public void updateDates(Date checkin, Date checkout) throws DomainException {
		Date now = new Date();
		if(checkin.before(now) || checkout.before(now)) {
			throw new DomainException(" Resevation dates for update must be future dates");
		} if(!checkout.after(checkin)) {
			throw new DomainException(" Check-out date must be after check-in date");
		}
		this.checkin = checkin;
		this.checkOut = checkout;
	}
}
