package com.library;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BookDAO bookDAO = new BookDAO();
        UserDAO userDAO = new UserDAO();
        BorrowDAO borrowDAO = new BorrowDAO();
        int choice;
        do {
            System.out.println("\n================================");
            System.out.println("    LIBRARY MANAGEMENT SYSTEM");
            System.out.println("================================");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Add User");
            System.out.println("4. View Users");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");
            System.out.println("================================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter author name: ");
                    String author = sc.nextLine();

                    Book book = new Book(
                            0,
                            title,
                            author,
                            true
                    );

                    bookDAO.addBook(book);
                    break;

                case 2:
                    bookDAO.displayBooks();
                    break;

                case 3:
                    System.out.print("Enter user name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter email: ");
                    String email = sc.nextLine();

                    User user = new User(
                            0,
                            name,
                            email
                    );

                    userDAO.addUser(user);
                    break;

                case 4:
                    userDAO.displayUsers();
                    break;

                case 5:
                    System.out.print("Enter Book ID: ");
                    int borrowBookId = sc.nextInt();

                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();

                    borrowDAO.borrowBook(
                            borrowBookId,
                            userId
                    );
                    break;
                case 6:
                    System.out.print("Enter Book ID: ");
                    int returnBookId = sc.nextInt();
                    borrowDAO.returnBook(returnBookId);
                    break;
                case 7:
                    System.out.println(
                            "Thank you for using Library Management System!"
                    );
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 7);
        sc.close();
    }
}