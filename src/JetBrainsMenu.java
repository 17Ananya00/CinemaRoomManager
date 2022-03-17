import java.util.ArrayList;
import java.util.Scanner;

public class JetBrainsMenu {
    public static Scanner scanner = new Scanner(System.in);
    public static int rows;
    public static int row;
    public static int command;
    public static int seats;
    public static int seat;
    public static ArrayList<ArrayList<String>> cinema = new ArrayList<>();
    public static int ticketPrice;

    public static void main(String[] args) {

        System.out.println("Enter the number of rows:");
        rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        seats = scanner.nextInt();

        prepareCinema();
        menu();
    }

    public static void menu() {

        System.out.println("\n1. Show the seats\n" +
                "2. Buy a ticket\n" +
                "0. Exit");
        command = scanner.nextInt();
        boolean condition = true;

        while (condition) {
            switch (command) {
                case 0:
                    condition = false;
                    break;
                case 1:
                    print();
                    menu();
                    break;
                case 2:
                    System.out.println("\nEnter a row number:");
                    row = scanner.nextInt();

                    System.out.println("Enter a seat number in that row:");
                    seat = scanner.nextInt();

                    System.out.println("\nTicket price: $" + priceTicket());
                    updateCinema();
                    menu();
                    break;
            }
        }
    }

    public static void updateCinema() {
        cinema.get(row).set(seat, "B");
    }

    public static void prepareCinema() {
        ArrayList<String> rowZero = new ArrayList<>();
        rowZero.add(0, " ");
        for (int i = 1; i <= seats; i++) {
            rowZero.add(i, String.valueOf(i));
        }

        cinema.add(0, rowZero);
        for (int i = 1; i <= rows; i++) {
            cinema.add(i, prepareRow(i));
        }
    }

    public static ArrayList<String> prepareRow(int rowNumber) {
        ArrayList<String> rowAsArrayList = new ArrayList<>();
        rowAsArrayList.add(0, String.valueOf(rowNumber));
        for (int i = 1; i <= seats; i++) {
            rowAsArrayList.add(i, "S");
        }
        return rowAsArrayList;
    }

    public static void print() {
        StringBuilder stringBuilder = new StringBuilder();
        for (ArrayList<String> row : cinema) {
            for (int i = 0; i < row.size(); i++) {
                stringBuilder.append(row.get(i));
                if (i < row.size() - 1) {
                    stringBuilder.append(" ");
                }
            }
            stringBuilder.append("\n");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        System.out.println("\nCinema:\n" + stringBuilder);
    }

    public static int priceTicket() {


        int totalSeats = rows * seats;
        if (totalSeats < 60) {
            ticketPrice = 10;
        } else {
            if (rows % 2 == 0) {
                int tenDollarRows = rows / 2;
                int tenDollarSeats = tenDollarRows * seats;
                int eightDollarRows = rows - tenDollarRows;
                int eightDollarSeats = eightDollarRows * seats;
                if (row < tenDollarRows) {
                    ticketPrice = 10;
                } else {
                    ticketPrice = 8;
                }
            } else {
                int tenDollarRows = rows / 2;
                int eightDollarRows = rows - tenDollarRows;
                int tenDollarSeats = tenDollarRows * seats;
                int eightDollarSeats = eightDollarRows * seats;
                int total = (tenDollarSeats * 10) + (eightDollarSeats * 8);
                if (row <= 4) {
                    ticketPrice = 10;
                } else {
                    ticketPrice = 8;
                }


            }
            // occupied seat here


        }

        return ticketPrice;
    }
}
