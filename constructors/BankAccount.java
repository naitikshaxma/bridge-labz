class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    public void setBalance(double b) {
        balance = b;
    }

    public double getBalance() {
        return balance;
    }

    public void display() {
        System.out.println("Account Number: " + accountNumber + ", Account Holder: " + accountHolder + ", Balance: $" + balance);
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    public void displaySavings() {
        System.out.println("Account Number: " + accountNumber + ", Account Holder: " + accountHolder + ", Balance: $" + getBalance() + ", Interest Rate: " + interestRate + "%");
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount b = new BankAccount();
        b.accountNumber = "A1001";
        b.accountHolder = "Alice";
        b.setBalance(5000);
        b.display();

        SavingsAccount s = new SavingsAccount();
        s.accountNumber = "S2001";
        s.accountHolder = "Bob";
        s.setBalance(10000);
        s.interestRate = 5.0;
        s.displaySavings();
    }
}
