public class TestBankAccount {

    public static void main(String[] args) {

        CheckingAccount account = new CheckingAccount();

        account.setFirstName("Alondra");
        account.setLastName("Sandoval");
        account.setAccountID(12345);
        account.setInterestRate(2.5);

        System.out.println("Initial Account Information:");
        account.displayAccount();

        System.out.println();

        System.out.println("Depositing $500...");
        account.deposit(500.00);
        account.displayAccount();

        System.out.println();

        System.out.println("Withdrawing $200...");
        account.processWithdrawal(200.00);
        account.displayAccount();

        System.out.println();

        System.out.println("Withdrawing $400...");
        account.processWithdrawal(400.00);
        account.displayAccount();
    }
}