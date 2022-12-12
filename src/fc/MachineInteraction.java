package fc;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MachineInteraction implements PropertyChangeListener {
    private final AL2000FC FC;

    Integer creditCardNumber;
    Integer subscriptionCardNumber;

    public MachineInteraction(AL2000FC FC) {
        this.FC = FC;
        FC.addPropertyChangeListener(this);

        creditCardNumber = null;
        subscriptionCardNumber = null;
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        switch (e.getPropertyName()) {
            case "addCreditCard":
                creditCardNumber = (Integer) e.getNewValue();
                FC.connection(creditCardNumber, subscriptionCardNumber);
                break;
            case "addSubscriptionCard":
                subscriptionCardNumber = (Integer) e.getNewValue();
                FC.connection(creditCardNumber, subscriptionCardNumber);
                break;
            case "removeCreditCard":
                creditCardNumber = null;
                if (subscriptionCardNumber == null) {
                    FC.close();
                }
                break;
            case "removeSubscriptionCard":
                subscriptionCardNumber = null;
                if (creditCardNumber == null) {
                    FC.close();
                } else {
                    FC.connection(creditCardNumber, subscriptionCardNumber);
                }
                break;
            case "insertBluRay":
                break;
            default:
                break;
        }
    }
}
