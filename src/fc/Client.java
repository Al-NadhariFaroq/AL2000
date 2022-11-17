package fc;

abstract class Client {
    CreditCard creditCard;

    public Client(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        Client client = (Client) o;

        return client.creditCard.equals(creditCard);
    }

    @Override
    public String toString() {
        return "Client : " + creditCard.toString();
    }
}
