package model;

import config.DatabaseConnector;
import config.DatabaseCreator;
import dao.BankController;
import model.Account;
import model.Customer;

public class Bank {
    public static void main(String[] args){
        DatabaseConnector connector = new DatabaseConnector();
        BankController bankControl = new BankController(connector.getConnection());

        Customer customer = new Customer(
                "Davi Silva",
                "Av Silva Jardim 1364",
                "99165-9855",
                "davi.csilva00@gmail.com"
        );
        Account account = new Account(customer);

        bankControl.createCustomer(customer);
        bankControl.createAccount(account);
        /*
        System.out.println("model.Account holder: " + account.getCustomer().getName());
        System.out.println("Initial balance: $" + account.getBalance());

        account.deposit(500);
        account.withdraw(200);

        System.out.println("Updated balance: $" + account.getBalance());
         */
    }
}
