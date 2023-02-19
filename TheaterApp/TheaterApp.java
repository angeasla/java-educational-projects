package gr.aueb.cf.projects.theater;

public class TheaterApp {
    public static final int ROWS = 30;
    public static final int COLUMNS = 12;
    private static boolean[][] seats = new boolean[ROWS][COLUMNS];

    public static void main(String[] args) {
        TheaterApp theater = new TheaterApp();

        // Try booking a seat
        theater.book('A', 5);
        // Try booking the same seat again (it would fail because the seat is already booked)
        theater.book('A', 5);
        // Try booking a different seat
        theater.book('B', 5);
        // Cancel a booking
        theater.cancel('A', 5);
        // Cancel a booking for the same seat again (it would fail because the seat is already unbooked)
        theater.cancel('A', 5);
        // Try booking the same seat again (Now it would succeed)
        theater.book('A', 5);
    }

    public static void book(char column, int row) {
        // Convert the seat location to an array index (0-based)
        int col = column - 'A';
        // Check if the seat is available
        if (!seats[row][col]) {
            // Mark the seat as booked
            seats[row][col] = true;
            System.out.println("Booking successful");
        } else {
            System.out.println("Booking unsuccessful. Seat already booked.");
        }
    }

    public static void cancel(char column, int row) {
        // Convert the seat location to an array index (0-based)
        int col = column - 'A';
        // Check if the seat is booked
        if (seats[row][col]) {
            // Mark the seat as available
            seats[row][col] = false;
            System.out.println("Booking cancelled");
        } else {
            System.out.println("Cancellation unsuccessful. Seat was not booked.");
        }
    }
}