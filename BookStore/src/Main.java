import data.JDBCConnect;
import model.Books;
import model.Functions;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("Welcome to HUYDEPTRAI book counter!");
            System.out.println("You want\n0. See full book\n1.buy books\n2.rent books\n3.give book back\n4.Exit\nchoice : ");
            int choose = scanner.nextInt();
            scanner.nextLine();
            switch (choose) {
                case 0:
                    Functions.view();
                    break;
                case 1:
                    System.out.println("Which book do you want to choose?");
                    System.out.println("=================================");
                    Functions.view();
                    System.out.print("Enter the book id of your choice: ");
                    String idBuy = scanner.nextLine();
                    Books findByIdB = Functions.findById(idBuy);
                    if (findByIdB != null) {
                        System.out.print("\nWant to buy this book?(Y/N): ");
                        String choice = scanner.nextLine();
                        if (Objects.equals(choice, "Y")) {
                            System.out.println("You have successfully purchased the book!");
                            Functions.delete(idBuy);
                        } else {
                            System.out.println("Transaction has been cancelled!");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Which book do you want to choose?");
                    System.out.println("=================================");
                    Functions.view();
                    System.out.print("Enter the book id of your choice: ");
                    String idRent = scanner.nextLine();
                    Books findByIdR = Functions.findById(idRent);
                    if (findByIdR != null) {
                        System.out.print("\nWould you like to rent this book?(Y/N): ");
                        String choice = scanner.nextLine();
                        if (Objects.equals(choice, "Y")) {
                            findByIdR.setStatus(0);
                            Functions.update(findByIdR);
                        } else {
                            System.out.println("Transaction has been cancelled!");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Which book do you want to return?");
                    System.out.println("=================================");
                    System.out.print("Enter the book id of your choice: ");
                    String idBookBack = scanner.nextLine();
                    Books findByIdBB = Functions.findById(idBookBack);
                    if (idBookBack != null) {
                        System.out.print("\nConfirm return of books?(Y/N): ");
                        String choice = scanner.nextLine();
                        if (Objects.equals(choice, "Y")) {
                            findByIdBB.setStatus(1);
                            Functions.update(findByIdBB);
                        } else {
                            System.out.println("Transaction has been cancelled!");
                        }
                    }
                    break;
                case 4:
                    run = false;
                    break;
            }
        }

    }
}