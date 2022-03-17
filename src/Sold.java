import java.util.Scanner;

    public class Sold {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            // Write your code here
            System.out.println("Enter the number of rows:");
            int rows = scanner.nextInt();
            System.out.println("Enter the number of seats in each row:");
            int seats = scanner.nextInt();
            int totalSeats = rows * seats;
            if (totalSeats < 60) {
                int ticketPrice = 10;
                int total = totalSeats * ticketPrice;
                System.out.print("Total income:" + "\n"+ "$"+
                        total);
            } else {
                if (rows % 2 == 0) {
                    int tenDollarRows = rows / 2;
                    int tenDollarSeats = tenDollarRows * seats;
                    int eightDollarRows = rows - tenDollarRows;
                    int eightDollarSeats = eightDollarRows * seats;
                    int total = (tenDollarSeats * 10) + (eightDollarSeats * 8);
                    System.out.print("Total income:" + "\n" + "$" + total);
                } else {
                    int tenDollarRows = rows/2;
                    int eightDollarRows =  rows - tenDollarRows;
                    int tenDollarSeats = tenDollarRows * seats;
                    int eightDollarSeats = eightDollarRows * seats;
                    int total = (tenDollarSeats * 10) + (eightDollarSeats * 8);
                    System.out.print("Total income:" + "\n" + "$" + total);
                }
            }


        }

    }
