package service;

import config.DbConfig;
import entity.Customer;
import entity.invoice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceService {

    public void addInvoice(invoice invoice) throws SQLException
    {
        Connection conn = DbConfig.getConnection();
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO invoices (customer_id, vehicle_id, service_id) VALUES(?,?,?)"
        );
        ps.setInt(1, invoice.getCustomerId());
        ps.setInt(2, invoice.getVehicleID());
        ps.setInt(3, invoice.getServiceId());

        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    public List<invoice> getAllInvoice() throws SQLException
    {
        List<invoice> list = new ArrayList<>();
        Connection conn = DbConfig.getConnection();

        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM invoices");

        while(rs.next())
        {
            list.add(new invoice(rs.getInt("id"),
                    rs.getInt("customer_id"),
                    rs.getInt("vehicle_id"),
                    rs.getInt("service_id")));

        }
        return list;

    }
}
