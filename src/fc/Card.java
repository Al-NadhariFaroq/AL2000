package fc;

public abstract class Card {
    float sold;
    public Card(){
        sold = 0;
    }

     void debit(float amount){
        sold -= amount;
     }

     void credit(float amount){
        sold += amount;
     }

    public float getSold() {
        return sold;
    }

    public void setSold(float sold) {
        this.sold = sold;
    }
}
