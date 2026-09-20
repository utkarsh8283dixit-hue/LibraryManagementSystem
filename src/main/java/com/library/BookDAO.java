package com.library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDAO {

    // Add book to database
    public void addBook(Book book) {

        String sql = "INSERT INTO books (title, author, available) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setBoolean(3, book.isAvailable());

            statement.executeUpdate();

            System.out.println("Book saved to MySQL successfully!");

        } catch (SQLException e) {
            System.out.println("Error while adding book!");
            e.printStackTrace();
        }
    }

    // Display books from database
    public void displayBooks() {

        String sql = "SELECT * FROM books";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            System.out.println("\n===== Books From MySQL =====");

            while (resultSet.next()) {

                System.out.println("Book ID: " +
                        resultSet.getInt("book_id"));

                System.out.println("Title: " +
                        resultSet.getString("title"));

                System.out.println("Author: " +
                        resultSet.getString("author"));

                System.out.println("Available: " +
                        resultSet.getBoolean("available"));

                System.out.println("-------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error while displaying books!");
            e.printStackTrace();
        }
    }
}