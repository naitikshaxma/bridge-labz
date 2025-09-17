import java.util.ArrayList;
import java.util.List;

class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) balance -= amount;
        else System.out.println("Insufficient funds");
    }
}

class Customer {
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void viewBalance() {
        System.out.println("Balances for " + name + ":");
        for (Account a : accounts) {
            System.out.println("Account " + a.getAccountNumber() + ": " + a.getBalance());
        }
        System.out.println("---------------------------");
    }
}

class Bank {
    private String bankName;
    private List<Customer> customers;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Account openAccount(Customer customer, String accountNumber, double initialBalance) {
        Account account = new Account(accountNumber, initialBalance);
        customer.addAccount(account);
        return account;
    }

    public void showCustomers() {
        System.out.println("Customers of " + bankName + ":");
        for (Customer c : customers) {
            System.out.println("- " + c.getName());
        }
        System.out.println("---------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("City Bank");

        Customer c1 = new Customer("Alice");
        Customer c2 = new Customer("Bob");

        bank.addCustomer(c1);
        bank.addCustomer(c2);

        bank.openAccount(c1, "A101", 1000);
        bank.openAccount(c1, "A102", 5000);
        bank.openAccount(c2, "B201", 2000);

        bank.showCustomers();

        c1.viewBalance();
        c2.viewBalance();
    }
}
