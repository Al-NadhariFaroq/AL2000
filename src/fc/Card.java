package fc;

public abstract class Card {
    float balance;
    
    public Card(){
        balance = 0;
    }

     void debit(float amount){
        balance -= amount;
     }

     void credit(float amount){
        balance += amount;
     }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public boolean IsValidBalance(){
        return balance > 0;
    }

}
