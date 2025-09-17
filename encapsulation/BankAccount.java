import java.util.ArrayList;
import java.util.List;

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited into " + accountNumber);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn from " + accountNumber);
        } else {
            System.out.println("Insufficient funds for " + accountNumber);
        }
    }

    public abstract double calculateInterest();
}

interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate;

    public SavingsAccount(String number, String holder, double balance, double interestRate) {
        super(number, holder, balance);
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate;
    }

    @Override
    public void applyForLoan(double amount) {
        if (calculateLoanEligibility()) {
            System.out.println("Loan of " + amount + " approved for Savings Account " + getAccountNumber());
        } else {
            System.out.println("Loan not approved for Savings Account " + getAccountNumber());
        }
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 1000;
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    private double interestRate;

    public CurrentAccount(String number, String holder, double balance, double interestRate) {
        super(number, holder, balance);
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate;
    }

    @Override
    public void applyForLoan(double amount) {
        if (calculateLoanEligibility()) {
            System.out.println("Loan of " + amount + " approved for Current Account " + getAccountNumber());
        } else {
            System.out.println("Loan not approved for Current Account " + getAccountNumber());
        }
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 500;
    }
}

public class Main {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();

        SavingsAccount sa = new SavingsAccount("SA1001", "Alice", 5000, 0.04);
        CurrentAccount ca = new CurrentAccount("CA2001", "Bob", 2000, 0.02);

        accounts.add(sa);
        accounts.add(ca);

        for (BankAccount acc : accounts) {
            System.out.println("Account: " + acc.getAccountNumber() + " (" + acc.getHolderName() + ")");
            System.out.println("Balance: " + acc.getBalance());
            System.out.println("Interest: " + acc.calculateInterest());

            if (acc instanceof Loanable loanAcc) {
                System.out.println("Eligible for loan: " + loanAcc.calculateLoanEligibility());
                loanAcc.applyForLoan(1000);
            }

            System.out.println("-------------------------");
        }

        sa.deposit(1000);
        ca.withdraw(500);
        System.out.println("Final balance in " + sa.getAccountNumber() + ": " + sa.getBalance());
        System.out.println("Final balance in " + ca.getAccountNumber() + ": " + ca.getBalance());
    }
}
