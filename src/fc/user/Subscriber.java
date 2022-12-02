package fc.user;

import java.util.ArrayList;
import java.util.List;

public class Subscriber extends Client {
    SubscribeCard subscribeCard;
    List<SubscribeCard> subscribeCards;

    public Subscriber(CreditCard creditCard, SubscribeCard subscribeCard) {
        super(creditCard);
        this.subscribeCard = subscribeCard;
        subscribeCards = new ArrayList<>();
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public SubscribeCard getSubscribeCard() {
        return subscribeCard;
    }

    public List<SubscribeCard> getSubscribeCards() {
        return subscribeCards;
    }

    public boolean addSubscribeCard(SubscribeCard subscribeCard) {
        return subscribeCards.add(subscribeCard);
    }

    public boolean removeSubscribeCard(SubscribeCard subscribeCard) {
        return subscribeCards.remove(subscribeCard);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        Subscriber subscriber = (Subscriber) o;

        return super.equals(subscriber) && subscriber.subscribeCard.equals(subscribeCard);
    }

    @Override
    public String toString() {
        StringBuilder txt = new StringBuilder("");
        txt.append("Subscriber : " + subscribeCard.toString() + "\n");
        for (SubscribeCard card : subscribeCards) {
            txt.append("    " + card.toString() + "\n");
        }

        return txt.toString();
    }
}
