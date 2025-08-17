import entity.Customer;
import service.BillingService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);
        BillingService service = new BillingService();

        while(true)
        {
            System.out.println("1. Add Customer and his vehicle\n" +
                    "2. Generate invoic\n" +
                    "3. Show Invoice\n" +
                    "4. Exit");

            int ch = sc.nextInt();
            switch(ch)
            {
                case 1:
                    System.out.print("Customer Name: ");
                    String name = sc.next();
                    System.out.print("Phone number: ");
                    String phone = sc.next();
                    service.customerService.addCustomer(new Customer(0,
                            name, phone));
                    System.out.print("Enter Vehicle number: ");
                    int num = sc.nextInt();
                    System.out.print("Enter Vehicle model: ");
                    String model = sc.next();
                    Customer cust = service.customerService.getCustomersBasedOnNum(num);

                    break;

                case 2:
                    System.out.print("Enter customer ID: ");
                    int cid = sc.nextInt();
                    System.out.print("Enter vehicle id: ");
                    int vid = sc.nextInt();

                    System.out.println("Enter number of services");
                    int n = sc.nextInt();
                    List<Integer> sids = new ArrayList<>();
                    for(int i = 0; i<n;i++)
                    {
                        System.out.println("Enter the service id: ");
                        sids.add(sc.nextInt());
                    }
                    service.createInvoice(cid, vid, sids);
                    break;

                case 3:
                    service.showAllInvoices();
                    break;

                case 4:
                    System.exit(0);

                default:
                    System.out.println("Not a valid choice");
            }
        }
    }
}
