package dao;

import data.JDBCConnect;
import model.Books;

import java.sql.*;
import java.util.ArrayList;

public class DaoBooks implements DAOInterface<Books> {
    public static DaoBooks getInstance() {
        return new DaoBooks();
    }

    @Override
    public void add(Books books) {
        try {
            Connection connection = JDBCConnect.getConnection();
            String sql = "INSERT INTO databook (id, bookName, rate, status)" + "VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, books.getId());
            preparedStatement.setString(2, books.getBookName());
            preparedStatement.setFloat(3, books.getRate());
            preparedStatement.setInt(4, books.getStatus());
            int result = preparedStatement.executeUpdate();
            if (result != 0) {
                System.out.println("added successfully!");
            }
            JDBCConnect.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Books books) {
        try {
            Connection connection = JDBCConnect.getConnection();
            String sql = "UPDATE databook SET " +
                    "bookName = ?," +
                    "rate = ?," +
                    "status = ? " +
                    "WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(4, books.getId());
            preparedStatement.setString(1, books.getBookName());
            preparedStatement.setFloat(2, books.getRate());
            preparedStatement.setInt(3, books.getStatus());
            int result = preparedStatement.executeUpdate();
            if (result != 0) {
                System.out.println("Update successsfully!");
            }
            JDBCConnect.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Books books) {
        try {
            Connection connection = JDBCConnect.getConnection();
            String sql = "DELETE FROM databook WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, books.getId());
            int result = preparedStatement.executeUpdate();
            JDBCConnect.closeConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<Books> sellectAll() {
        ArrayList<Books> listBook = new ArrayList<Books>();
        try {
            Connection connection = JDBCConnect.getConnection();
            String sql = "SELECT * FROM databook ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String bookName = resultSet.getString("bookName");
                float rate = resultSet.getFloat("rate");
                int status = resultSet.getInt("status");
                Books book = new Books(id, bookName, rate, status);
                listBook.add(book);
            }
            JDBCConnect.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listBook;
    }

    @Override
    public Books sellectById(Books books) {
        Books result = null;
        try {
            Connection connection = JDBCConnect.getConnection();
            String sql = "SELECT * FROM  databook WHERE id = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, books.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("bookName");
                int rate = resultSet.getInt("rate");
                int nxb = resultSet.getInt("status");
                Books book = new Books(id, name, rate, nxb);
                result = book;
            }
            JDBCConnect.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<Books> sellectByCondition(String condition) {
        ArrayList<Books> listBook = new ArrayList<Books>();
        try {
            Connection connection = JDBCConnect.getConnection();
            String sql = "SELECT * FROM  WHERE databook  bookName = ? or id = ? or rate = ? or status = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, condition);
            preparedStatement.setString(2, condition);
            preparedStatement.setString(3, condition);
            preparedStatement.setString(4, condition);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("bookName");
                int rate = resultSet.getInt("rate");
                int nxb = resultSet.getInt("status");
                Books book = new Books(id, name, rate, nxb);
                listBook.add(book);
            }
            JDBCConnect.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listBook;
    }
}

