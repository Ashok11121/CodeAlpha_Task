import java.util.*;
class Room {
   int roomNumber;
   String category;
   boolean isAvailable;

    public Room(int roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.isAvailable = true; // Default availability
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void bookRoom() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Room " + roomNumber + " booked successfully!");
        } else {
            System.out.println("Room " + roomNumber + " is already booked.");
        }
    }

    public void displayRoomInfo() {
        System.out.println("Room: " + roomNumber + ", Category: " + category + ", Available: " + isAvailable);
    }
}

public class HotelReservationSystem {
    static List<Room> rooms = new ArrayList<>();

    public static void main(String[] args) {
        rooms.add(new Room(101, "Standard"));
        rooms.add(new Room(102, "Deluxe"));
        rooms.add(new Room(103, "Suite"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. View Available Rooms\n2. Book Room\n3. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    for (Room room : rooms) {
                        if (room.isAvailable) {
                            room.displayRoomInfo();
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter room number to book: ");
                    int roomNumber = scanner.nextInt();
                    for (Room room : rooms) {
                        if (room.roomNumber == roomNumber) {
                            room.bookRoom();
                        }
                    }
                    break;
                case 3:
                    System.out.println("Thank you for using the Hotel Reservation System!");
                    scanner.close();  // Properly closing the Scanner
                    return;
            }
        }
    }
}
