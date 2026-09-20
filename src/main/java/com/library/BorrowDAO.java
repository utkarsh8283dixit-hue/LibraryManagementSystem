package com.library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BorrowDAO {

    // Borrow Book
    public void borrowBook(int bookId, int userId) {

        String checkSql =
                "SELECT available FROM books WHERE book_id = ?";

        String insertSql =
                "INSERT INTO borrowed_books " +
                        "(book_id, user_id, borrow_date) VALUES (?, ?, CURDATE())";

        String updateSql =
                "UPDATE books SET available = FALSE WHERE book_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement check =
                     connection.prepareStatement(checkSql)) {

            check.setInt(1, bookId);

            ResultSet resultSet = check.executeQuery();

            if (!resultSet.next()) {
                System.out.println("Book not found!");
                return;
            }

            if (!resultSet.getBoolean("available")) {
                System.out.println("Book is already borrowed!");
                return;
            }

            try (PreparedStatement insert =
                         connection.prepareStatement(insertSql);
                 PreparedStatement update =
                         connection.prepareStatement(updateSql)) {

                insert.setInt(1, bookId);
                insert.setInt(2, userId);
                insert.executeUpdate();

                update.setInt(1, bookId);
                update.executeUpdate();

                System.out.println("Book borrowed successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Error while borrowing book!");
            e.printStackTrace();
        }
    }

    // Return Book
    public void returnBook(int bookId) {

        String updateBorrowSql =
                "UPDATE borrowed_books " +
                        "SET return_date = CURDATE() " +
                        "WHERE book_id = ? AND return_date IS NULL";

        String updateBookSql =
                "UPDATE books SET available = TRUE WHERE book_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement borrowStatement =
                     connection.prepareStatement(updateBorrowSql);
             PreparedStatement bookStatement =
                     connection.prepareStatement(updateBookSql)) {

            borrowStatement.setInt(1, bookId);

            int rowsUpdated = borrowStatement.executeUpdate();

            if (rowsUpdated == 0) {
                System.out.println("No active borrowing found!");
                return;
            }

            bookStatement.setInt(1, bookId);
            bookStatement.executeUpdate();

            System.out.println("Book returned successfully!");

        } catch (SQLException e) {
            System.out.println("Error while returning book!");
            e.printStackTrace();
        }
    }
}
