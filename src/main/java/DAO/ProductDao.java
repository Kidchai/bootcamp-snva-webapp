package DAO;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    private static final String URL = "jdbc:mysql://localhost:3306/bootcampdb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static Connection getConnection() throws RuntimeException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error connecting to the database", e);
        }
        return connection;
    }

    public static int save(Product product) {
        int status = 0;
        try {
            Connection connection = ProductDao.getConnection();
            String insertQuery = "insert into products_webapp(name, description, price, quantity) values(?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(insertQuery);
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setDouble(3, product.getPrice());
            statement.setInt(4, product.getQuantity());

            status = statement.executeUpdate();

            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return status;
    }

    public static int update(Product product) {
        int status = 0;
        try {
            Connection connection = ProductDao.getConnection();
            String updateQuery = "update products_webapp set name=?, description=?, price=?, quantity=? where id=?";
            PreparedStatement statement = connection.prepareStatement(updateQuery);

            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setDouble(3, product.getPrice());
            statement.setInt(4, product.getQuantity());
            statement.setInt(5, product.getId());

            status = statement.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;

    }

    public static Product get(int id) {
        Product product = new Product("name", "description", 0, 0);

        try {
            Connection connection = ProductDao.getConnection();
            String selectQuery = "select * from products_webapp where id=?";
            PreparedStatement statement = connection.prepareStatement(selectQuery);

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setDescription(resultSet.getString("description"));
                product.setPrice(resultSet.getInt("price"));
                product.setQuantity(resultSet.getInt("quantity"));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return product;
    }

    public static List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        int status = 0;
        try {
            Connection connection = ProductDao.getConnection();
            String selectAllQuery = "select * from products_webapp";
            PreparedStatement statement = connection.prepareStatement(selectAllQuery);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                int price = resultSet.getInt("price");
                int quantity = resultSet.getInt("quantity");

                Product product = new Product(id, name, description, price, quantity);
                products.add(product);
            }

            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return products;
    }

    public static void delete(int id) {
        int status = 0;
        try {
            Connection connection = ProductDao.getConnection();
            String deleteQuery = "delete from products_webapp where id=?";
            PreparedStatement statement = connection.prepareStatement(deleteQuery);
            statement.setInt(1, id);
            status = statement.executeUpdate();

            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
