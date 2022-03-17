
import java.util.Scanner;

public class Hall {

    private static Scanner user = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the number of rows: ");
        int rows = user.nextInt();
        System.out.println("Enter the number of seats in each row: ");
        int seats = user.nextInt();
        String[][] cinema = new String[rows + 1][seats + 1];

        display(cinema, rows, seats);
        System.out.println("Enter a row number:");
        int numRows = user.nextInt();
        System.out.println("Enter a seat number in that row:");
        int numSeats = user.nextInt();
        priceTicket(rows, seats, numRows, numSeats);
        takenSeat(cinema, rows, seats, numRows, numSeats);
        cinema[numRows][numSeats] = "B";

    }

    public static void takenSeat(String[][] cinema, int rows, int seats, int numRows, int numSeats) {
        System.out.println();
        System.out.println("Cinema:");

        //Mine code here
        for (int row = 0; row <= rows; row++) {
            for (int col = 0; col <= seats; col++) {
                if (row == 0 && col == 0) {
                    cinema[row][col] = " ";
                } else if (row == 0) {
                    cinema[0][col] = String.valueOf(col);
                } else if (col == 0) {
                    cinema[row][0] = String.valueOf(row);
                } else {
                    cinema[numRows][numSeats] = "B";
                }
                System.out.print(cinema[row][col] + " ");
            }
            System.out.println();

        }
        System.out.println();
    }


    public static void display(String[][] cinema, int rows, int seats) {
        System.out.println();
        System.out.println("Cinema:");

        for (int row = 0; row <= rows; row++) {
            for (int col = 0; col <= seats; col++) {
                if (row == 0 && col == 0) {
                    cinema[row][col] = " ";
                } else if (row == 0) {
                    cinema[0][col] = String.valueOf(col);
                } else if (col == 0) {
                    cinema[row][0] = String.valueOf(row);
                } else {
                    cinema[row][col] = "S";
                }
                System.out.print(cinema[row][col] + " ");
            }
            System.out.println();

        }
        System.out.println();
    }

    public static void priceTicket(int rows, int seats, int rowNum, int numSeats) {


        int totalSeats = rows * seats;
        if (totalSeats < 60) {
            int ticketPrice = 10;
            System.out.println("Ticket price: $" + ticketPrice);
        } else {
            if (rows % 2 == 0) {
                int tenDollarRows = rows / 2;
                int tenDollarSeats = tenDollarRows * seats;
                int eightDollarRows = rows - tenDollarRows;
                int eightDollarSeats = eightDollarRows * seats;
                if (rowNum < tenDollarRows) {
                    int ticketPrice = 10;
                    System.out.println("Ticket price: $" + ticketPrice);
                } else {
                    int ticketPrice = 8;
                    System.out.println("Ticket price: $" + ticketPrice);
                }
            } else {
                int tenDollarRows = rows / 2;
                int eightDollarRows = rows - tenDollarRows;
                int tenDollarSeats = tenDollarRows * seats;
                int eightDollarSeats = eightDollarRows * seats;
                int total = (tenDollarSeats * 10) + (eightDollarSeats * 8);
                if (rowNum <= 4) {
                    int ticketPrice = 10;
                    System.out.println("Ticket price: $" + ticketPrice);
                } else {
                    int ticketPrice = 8;
                    System.out.println("Ticket price: $" + ticketPrice);
                }


            }
            // occupied seat here


        }
    }




}