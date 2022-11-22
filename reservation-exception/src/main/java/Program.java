import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        final var sc = new Scanner(System.in);
        final var sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            var roomNumber = sc.nextInt();

            System.out.print("Check-in date (dd/mm/yyyy): ");
            var checkinDate = sdf.parse(sc.next());

            System.out.print("Check-in date (dd/mm/yyyy): ");
            var checkoutDate = sdf.parse(sc.next());

            var reservation = new Reservation(roomNumber, checkinDate, checkoutDate);

            System.out.println("Reservation data - " + reservation);
        } catch (ParseException e) {
            System.out.println("Date parse error!");
        } catch (DomainException e) {
            System.out.println("Error creating reservation: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Unexpected Error");
        }
    }
}
