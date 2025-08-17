package service;
import config.DbConfig;
import entity.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    public void addCustomer(Customer customer) throws SQLException
    {
        Connection conn = DbConfig.getConnection();
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO customers (name,phone) VALUES(?,?)"
        );
        ps.setString(1, customer.getName());
        ps.setString(2, customer.getPhone());

        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    public List<Customer> getAllCustomers() throws SQLException
    {
        List<Customer> list = new ArrayList<>();
        Connection conn = DbConfig.getConnection();

        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM customers");

        while(rs.next())
        {
            list.add(new Customer(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("phone")));

        }
        return list;
    }

    public Customer getCustomersBasedOnNum(int number) throws SQLException
    {
        Customer customer = new Customer();
        List<Customer> list = new ArrayList<>();
        Connection conn = DbConfig.getConnection();

        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM customers" +
                                                "where phone = "+ number);

        while(rs.next())
        {
            customer = new Customer(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("phone"));

        }
        return customer;
    }

}
