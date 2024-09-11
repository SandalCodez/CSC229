//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DebitAccount dpt1 = new DebitAccount();
        CreditAccount crd1 = new CreditAccount(10000);
        LoanAccount loan1 = new LoanAccount(1000, 0.1);
        
        // DEBIT ACCOUNT
        //$100 deposit followed by a $50 withdraw
        dpt1.deposit(100);
        dpt1.withdraw(50);
        System.out.print(dpt1.toString());


        // CREDIT ACCOUNT
        //$900 withdraw followed by a $200 payment with a credit limit of $10,000
        crd1.withdraw(900);
        System.out.print(crd1.toString());
        crd1.deposit(200);
        System.out.println(crd1.toString());

        //LOAN ACCOUNT
        //$1000 payment on an account with a principle of $1000 at a 10% interest
        loan1.deposit(1000);
        
        System.out.print(loan1.toString());

        

        
       
    }
}