package com.library;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books;
    private List<User> users;

    // Constructor
    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    // Add Book
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    // Add User
    public void addUser(User user) {
        users.add(user);
        System.out.println("User added successfully!");
    }

    // Borrow Book
    public void borrowBook(int bookId) {

        for (Book book : books) {

            if (book.getBookId() == bookId) {

                if (book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println("Book borrowed successfully!");
                } else {
                    System.out.println("Book is already borrowed!");
                }

                return;
            }
        }

        System.out.println("Book not found!");
    }

    // Return Book
    public void returnBook(int bookId) {

        for (Book book : books) {

            if (book.getBookId() == bookId) {

                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    System.out.println("Book returned successfully!");
                } else {
                    System.out.println("Book was not borrowed!");
                }

                return;
            }
        }

        System.out.println("Book not found!");
    }

    // Display all books
    public void displayBooks() {

        System.out.println("\n===== Library Books =====");

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book book : books) {
            book.displayBookInfo();
            System.out.println("-------------------------");
        }
    }

    // Display all users
    public void displayUsers() {

        System.out.println("\n===== Library Users =====");

        if (users.isEmpty()) {
            System.out.println("No users registered.");
            return;
        }

        for (User user : users) {
            user.displayInfo();
            System.out.println("-------------------------");
        }
    }
}
