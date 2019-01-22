package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Resevation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Scanner sc = new Scanner(System.in);
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("CheckOut date (dd/MM/yyyy): ");
			Date checkout = sdf.parse(sc.next());
			
			Resevation reseva = new Resevation(number, checkin, checkout);
			System.out.println("Resevation : " + reseva);
			
			System.out.println();
			System.out.println("Enter data to update the resevation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = sdf.parse(sc.next());
			System.out.print("CheckOut date (dd/MM/yyyy): ");
			checkout = sdf.parse(sc.next());
			
			reseva.updateDates(checkin, checkout);
			System.out.println("Reservation: " + reseva);
		}catch(ParseException e) {
			System.out.println("Invalid date format.");
		}catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}catch(InputMismatchException e) {
			System.out.println("invalid room");
		}catch(RuntimeException e) {
			System.out.println("Unexpected error!");
		}
	}

}
