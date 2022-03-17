import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Errors {
    public static Scanner scanner = new Scanner(System.in);
    public static int rows;
    public static int row;
    public static int command;
    public static int seats;
    public static int seat;
    public static ArrayList<ArrayList<String>> cinema = new ArrayList<>();
    public static int ticketPrice;
    public static int tenDollarSeats;
    public static int eightDollarSeats;
    public static int tenDollarRows;
    public static int eightDollarRows;
    public static int total;
    public static int totalSeats;
    public static int totalMoney;
    public static int purchasedTickets;
    public static double percentage;


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
                "3. Statistics\n" +
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


                    if (row > rows || seat > seats) {
                        System.out.println("Wrong input!");
                    } else {
                        if (cinema.get(row).get(seat) == ("B")) {
                            System.out.println("That ticket has already been purchased!");
                        } else {
                            System.out.println("\nTicket price: $" + priceTicket());
                            updateCinema();
                            menu();
                        }
                    }


                    break;
                case 3:
                    statistics();
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


        totalSeats = rows * seats;
        if (totalSeats < 60) {
            ticketPrice = 10;
            total = totalSeats * ticketPrice;
        } else {
            if (rows % 2 == 0) {
                tenDollarRows = rows / 2;
                tenDollarSeats = tenDollarRows * seats;
                eightDollarRows = rows - tenDollarRows;
                eightDollarSeats = eightDollarRows * seats;
                total = (tenDollarSeats * 10) + (eightDollarSeats * 8);
                if (row < tenDollarRows) {
                    ticketPrice = 10;
                } else {
                    ticketPrice = 8;
                }
            } else {
                tenDollarRows = rows / 2;
                eightDollarRows = rows - tenDollarRows;
                tenDollarSeats = tenDollarRows * seats;
                eightDollarSeats = eightDollarRows * seats;
                total = (tenDollarSeats * 10) + (eightDollarSeats * 8);
                if (row <= 4) {
                    ticketPrice = 10;
                } else {
                    ticketPrice = 8;
                }


            }


        }
        totalMoney = totalMoney + ticketPrice;

        return ticketPrice;
    }

    public static void statistics() {


        totalSeats = rows * seats;
        if (totalSeats < 60) {
            ticketPrice = 10;
            total = totalSeats * ticketPrice;
        } else {
            if (rows % 2 == 0) {
                tenDollarRows = rows / 2;
                tenDollarSeats = tenDollarRows * seats;
                eightDollarRows = rows - tenDollarRows;
                eightDollarSeats = eightDollarRows * seats;
                total = (tenDollarSeats * 10) + (eightDollarSeats * 8);
                if (row < tenDollarRows) {
                    ticketPrice = 10;
                } else {
                    ticketPrice = 8;
                }
            } else {
                tenDollarRows = rows / 2;
                eightDollarRows = rows - tenDollarRows;
                tenDollarSeats = tenDollarRows * seats;
                eightDollarSeats = eightDollarRows * seats;
                total = (tenDollarSeats * 10) + (eightDollarSeats * 8);
                if (row <= 4) {
                    ticketPrice = 10;
                } else {
                    ticketPrice = 8;
                }


            }
        }

        int counter = 0;
        for (ArrayList<String> subArray : cinema)
            for (String string : subArray)
                if (string.equalsIgnoreCase("B"))
                    counter++;


        DecimalFormat formatter = new DecimalFormat("#,##0.00");

        purchasedTickets = counter;
        double totSeats = totalSeats;
        percentage = (purchasedTickets / totSeats) * 100;
        double roundOff = Math.round(percentage * 100.0) / 100.0;
        System.out.println(roundOff);


        System.out.println("Number of purchased tickets: " + purchasedTickets);
        if(roundOff == 0.0) {
            System.out.println("Percentage: " + "0.00" + "%");
        } else {
            System.out.print("Percentage: ");
            System.out.printf("%.2f", roundOff, "%");
            System.out.println("%");
        }
        System.out.println("Current income: $" + totalMoney);
        System.out.println("Total income: $" + total);





    }
}
