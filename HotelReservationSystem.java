import java.util.ArrayList;
import java.util.Scanner;

public class HotelReservationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Room> rooms = new ArrayList<>();

        rooms.add(new Room(101, "Standard"));
        rooms.add(new Room(102, "Standard"));
        rooms.add(new Room(201, "Deluxe"));
        rooms.add(new Room(202, "Deluxe"));
        rooms.add(new Room(301, "Suite"));

        int choice;

        do {

            System.out.println("\n===== Hotel Reservation System =====");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("\nAvailable Rooms:");

                    for (Room room : rooms) {

                        System.out.println(
                                "Room " + room.getRoomNumber()
                                        + " | " + room.getCategory()
                                        + " | "
                                        + (room.isBooked()
                                                ? "Booked"
                                                : "Available"));
                    }

                    break;

                case 2:

                    System.out.print("Enter Room Number: ");
                    int roomNo = sc.nextInt();

                    boolean found = false;

                    for (Room room : rooms) {

                        if (room.getRoomNumber() == roomNo) {

                            found = true;

                            if (!room.isBooked()) {

                                System.out.println(
                                        "Payment Successful!");
                                room.bookRoom();

                                System.out.println(
                                        "Room Booked Successfully!");
                            } else {

                                System.out.println(
                                        "Room Already Booked!");
                            }
                        }
                    }

                    if (!found) {
                        System.out.println("Room Not Found!");
                    }

                    break;

                case 3:

                    System.out.print("Enter Room Number: ");
                    roomNo = sc.nextInt();

                    found = false;

                    for (Room room : rooms) {

                        if (room.getRoomNumber() == roomNo) {

                            found = true;

                            if (room.isBooked()) {

                                room.cancelBooking();

                                System.out.println(
                                        "Reservation Cancelled!");
                            } else {

                                System.out.println(
                                        "Room is not booked!");
                            }
                        }
                    }

                    if (!found) {
                        System.out.println("Room Not Found!");
                    }

                    break;

                case 4:

                    System.out.println("Thank You!");
                    break;

                default:

                    System.out.println("Invalid Choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}

