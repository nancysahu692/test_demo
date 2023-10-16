import java.util.Scanner;

class InsufficientBalanceException
  extends Exception /* User defined class for InsufficientBalanceException */{

  public InsufficientBalanceException(String message) {
    super(message);
  }
}

class IllegalBankTransactionException
  extends Exception /* User defined class for IllegalBankTransactionException*/{

  public IllegalBankTransactionException(String message) {
    super(message);
  }
}

class SavingAccount /*this is the class which is made according to demand of question */{
  private long id;
  private double balance;

  public SavingAccount(long id, double balance) {
    this.id = id;
    this.balance = balance;
    System.out.println(
      "Your Account-id is " + this.id + " and Your balance is " + this.balance
    );
  }

  public double withdraw(double amount)
    throws InsufficientBalanceException, IllegalBankTransactionException {
    if (amount < 0) {
      throw new IllegalBankTransactionException(
        "Cannot withdraw a negative amount"
      );
    }

    if (balance == 0 || amount > balance) {
      throw new InsufficientBalanceException(
        "Insufficient balance for withdrawal"
      );
    }

    balance -= amount;
    return balance;
  }

  public double deposit(double amount) {
    balance += amount;
    return balance;
  }

  public double getBalance() {
    return balance;
  }
}

public class Solution3 {

  public static void main(String[] args) {
    System.out.println("Hello, Assignment Question 3, Solution is as follows-");

    SavingAccount savingAcc = new SavingAccount(123456, 2000);
    /* here let us consider we have a account with account id=123456 and balance in that as 2000 */
    /* now we will enter withdrawal account to check our code in all the cases such as-
       CASE 1) Insufficient balance- if you balance is 2000 and if you are trying to withdraw 2100. Note) here the case if balance 0 is present in account is also handled.
       CASE 2) Negative amount- if you try to withdraw a negative value from account let's say -1000
       CASE 3) if the amount to be withdrawn is under balance limit and withdrawal is successful, let's say 500 is to withdrawn.
     */
    Scanner kb = new Scanner(System.in);
    System.out.println("Enter the amount you want to withdraw from Account-");
    try {
      double withdrawalAmount = kb.nextDouble();
      double newBalance = savingAcc.withdraw(withdrawalAmount);
      System.out.println("Withdrawal successful. New balance: " + newBalance);
    } catch (InsufficientBalanceException e) {
      System.out.println("Exception: " + e.getMessage());
    } catch (IllegalBankTransactionException e) {
      System.out.println("Exception: " + e.getMessage());
    }
  }
}
