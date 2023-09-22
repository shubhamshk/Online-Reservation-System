import java.util.Arrays;
import java.util.Scanner;

public class OnlineReservationSystem {

    private static boolean[] seats = new boolean[10]; // initialize an array of 10 seats, all empty

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please select an option\n:");
            System.out.println("1. View Seat Map \n");
            System.out.println("2. Reserve Seat");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    viewSeatMap();
                    break;
                case 2:
                    reserveSeat();
                    break;
                case 3:
                    cancelReservation();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private static void viewSeatMap() {
        System.out.println("\nCurrent Seat Map: " + Arrays.toString(seats));
    }

    private static void reserveSeat() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter seat number (1-10): ");
        int seatNumber = scanner.nextInt();

        if (isValidSeatNumber(seatNumber)) {
            if (isSeatAvailable(seatNumber)) {
                reserveSeat(seatNumber);
                System.out.println("Seat reserved!");
            } else {
                System.out.println("Seat already reserved!");
            }
        } else {
            System.out.println("Invalid seat number!");
        }
    }

    private static void cancelReservation() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter seat number (1-10): ");
        int seatNumber = scanner.nextInt();

        if (isValidSeatNumber(seatNumber)) {
            if (isSeatAvailable(seatNumber)) {
                System.out.println("Seat not reserved!");
            } else {
                cancelSeatReservation(seatNumber);
                System.out.println("Reservation canceled!");
            }
        } else {
            System.out.println("Invalid seat number!");
        }
    }

    private static boolean isValidSeatNumber(int seatNumber) {
        return seatNumber >= 1 && seatNumber <= 10;
    }

    private static boolean isSeatAvailable(int seatNumber) {
        return !seats[seatNumber - 1];
    }

    private static void reserveSeat(int seatNumber) {
        seats[seatNumber - 1] = true;
    }

    private static void cancelSeatReservation(int seatNumber) {
        seats[seatNumber - 1] = false;
    }
}
