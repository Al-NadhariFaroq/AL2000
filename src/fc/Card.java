package fc;

public abstract class Card {
    int cardNumber;

    public Card(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        Card card = (Card) o;

        return card.cardNumber == cardNumber;
    }

    @Override
    public String toString() {
        return Integer.toString(cardNumber);
    }
}
