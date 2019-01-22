package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Resevation;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("CheckOut date (dd/MM/yyyy): ");
		Date checkout = sdf.parse(sc.next());
		if(!checkout.after(checkin)) {
			System.out.println("Error in resevation: Check-out date must be after check-in date");
		}else {
			Resevation reseva = new Resevation(number, checkin, checkout);
			System.out.println("Resevation : " + reseva);
			
			System.out.println();
			System.out.println("Enter data to update the resevation:");
			System.out.print("Check-in date (dd/MM/yyyy)");
			checkin = sdf.parse(sc.next());
			System.out.print("CheckOut date (dd/MM/yyyy): ");
			checkout = sdf.parse(sc.next());
			
		String error = reseva.updateDates(checkin, checkout);
			if(error != null) {
				System.out.println("Error in resevation: " + error);
			}else {
				System.out.println("Resevation: " + reseva);
			}
		}

	}

}
