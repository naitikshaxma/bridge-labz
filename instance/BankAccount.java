public class BankAccount {
    static String bankName = "OpenAI National Bank";
    private static int totalAccounts = 0;

    private String accountHolderName;
    private final int accountNumber;
    private double balance;

    public BankAccount(String accountHolderName, int accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        totalAccounts++;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + ". New balance: $" + balance);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + ". New balance: $" + balance);
        }
    }

    public void displayDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Bank: " + bankName);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: $" + balance);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Alice", 1001, 5000);
        BankAccount acc2 = new BankAccount("Bob", 1002, 3000);

        if (acc1 instanceof BankAccount) acc1.displayDetails();
        if (acc2 instanceof BankAccount) acc2.displayDetails();

        acc1.deposit(1000);
        acc2.withdraw(500);

        System.out.println("Total accounts: " + BankAccount.getTotalAccounts());
    }
}
