public class CreditAccount extends Account{
    double creditLimit;
    double balance;
    CreditAccount(){
        super();
        this.creditLimit = 1000.00;
        this.balance = 0;
    }

    CreditAccount(double _creditLimit){
        this.creditLimit = _creditLimit;
    }
    
    @Override
    public boolean deposit(double _amount){
        if(_amount <= 0){
            System.out.println("You must deposit more than $0");
            return false;
        }setBalance(this.getBalance() + _amount);
        return true;
    }
    
    @Override
    public boolean withdraw(double _amount){
        if(_amount > creditLimit){
            System.out.println("The amount: $" + _amount + " exceeds your credit limit");
            return false;
        }if(_amount <= 0){
            System.out.println("Your withdraw amount is less than or equal to zero.");
            return false;
        }
        setBalance(this.getBalance()-_amount);
        return true;
    }
    
    public String toString(){
        String content;
        content = "\nCREDIT ACCOUNT\nCredit Limit: $" + creditLimit + "\nBalance: $" + this.getBalance()+"\n";
        return (content);
    }
    
}
