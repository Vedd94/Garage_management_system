package service;

import entity.Customer;
import entity.invoice;

import java.sql.SQLException;
import java.util.List;

public class BillingService {
    public CustomerService customerService = new CustomerService();
    public InvoiceService invoiceService = new InvoiceService();

    public void createInvoice(int customerId, int vehicleId, List<Integer> serviceIds) throws SQLException
    {
        for(int serviceId: serviceIds)
        {
            invoiceService.addInvoice(new invoice(0, customerId,vehicleId,serviceId));
        }
        System.out.println(".........Invoice generated successfully.......");
    }

    public void showAllInvoices() throws SQLException
    {
        List<invoice> invoices = invoiceService.getAllInvoice();
        for(invoice invoice: invoices)
        {
            System.out.println(invoice);
        }
    }

}
