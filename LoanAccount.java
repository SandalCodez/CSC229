import java.util.*;
public class LoanAccount extends Account {
    double interest;
    double principle;
    double payments;
    public LoanAccount(){
        super();
        
        interest = .05;
        payments = 0;

    }public LoanAccount(double _principle, double _interest){
        this.interest = _interest;
        this.principle = _principle;
        setBalance(principle + (principle * interest));
    }
    
    @Override
    public boolean deposit(double _amount){
        payments = payments + _amount;
        if(getBalance()<= 0){
            System.out.print("Congrats!\nYou have completely paid off your loan account.\n");
        }
        

        if(_amount <= 0){
        System.out.println("Your deposit amount must be greater than $0");
        return false;
    }
    System.out.println("Would you like to split your payment?\nInput YES or NO");
    Scanner input = new Scanner(System.in);
    String ans = input.nextLine();
    
    if(ans.equals("NO")){
    double amountLeft =  _amount - (principle*interest);
    setBalance((principle - amountLeft)+((principle - amountLeft)*interest));
    if(getBalance()<= 0){
        System.out.print("\nCongrats!\nYou have completely paid off your loan account.\n\n");
    }
   
     return true;
    }
    
    if(ans.equals("YES")){
        System.out.println("Deposit Amount: " + _amount + " \nHow would you like to split your payment?\nInput the amount you would like to pay towards your interest followed by the principle.");
        Scanner ans1 = new Scanner(System.in);
        double payInt = ans1.nextDouble();
        double payPri = ans1.nextDouble();
        if(payInt + payPri != _amount){
            System.out.println("!!ERROR!! \nYour payment split does add up to you deposit amount. \nNO PAYMENTS WILL BE MADE.\n\n");
            return false;
        }
        if(payInt > principle * interest){
            System.out.print("!!ERROR!!  \nYour payment towards interest exceeds you interest amount.\nNO PAYMENTS WILL BE MADE.\n\n");
            return false;
        }
        // ans1.close();
        double newInterestAmount = (getBalance()*interest)- payInt;
        System.out.println("\n\nNew Interest Amount: " + newInterestAmount);
        double newPrincipleAmount = (principle - payPri);
        principle = newPrincipleAmount;
        System.out.println("New Principle: " + newPrincipleAmount);
        setBalance(newPrincipleAmount + (newInterestAmount));
        if(getBalance()<= 0){
            System.out.print("Congrats!\nYou have completely paid off your loan account.\n");
        }
         return true;


    }
    System.out.println("After this payment your new balance is: $" + getBalance() + "\nWith a total of $" + (getBalance()* interest) + " in interest\n");
    
    input.close();
    
    return true;
    
    }
    
    @Override 
    public boolean withdraw(double _amount){
        if(_amount <= 0){
            System.out.println("Please enter an amount greater than $0");
            return false;
        }setBalance(principle - _amount);
        return true;

    }
    public String toString(){
        String content = "LOAN ACCOUNT\nPrinciple: " + this.principle + "\nInterest Rate: " + (this.interest * 100) + "%\nCurrent balance: $" + (getBalance()) + " which includes $" + (getBalance()%100) + " in interest\nYou have made $" + payments + " in payments.";
        return content;
    }
    
}
