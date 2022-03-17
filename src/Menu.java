import java.util.ArrayList;
import java.util.Scanner;



public class Menu {
    public static Scanner scanner = new Scanner(System.in);
    public static int rows;
    public static int row;
    public static int option;
    public static int seats;
    public static int seat;
    public static ArrayList<ArrayList<String>> blueprint = new ArrayList<>();

    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);


        System.out.println("Enter the number of rows: ");
        rows = user.nextInt();
        System.out.println("Enter the number of seats in each row: ");
        seats = user.nextInt();
        String[][] cinema = new String[rows + 1][seats + 1];

        boolean condition = true;


        while (condition) {
            System.out.println("1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "0. Exit");
            int command = user.nextInt();
            switch (command) {
                case 0:
                    condition = false;
                    break;
                case 1:
                    display(cinema, rows, seats);
                    break;
                case 2:
                    System.out.println("Enter a row number:");
                    row = user.nextInt();
                    System.out.println("Enter a seat number in that row:");
                    seat = user.nextInt();
                    priceTicket(rows, seats, row, seat);


            }
        }
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


    public static void takenSeat(String[][] cinema, int rows, int seats, int numRows, int numSeats) {


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

}