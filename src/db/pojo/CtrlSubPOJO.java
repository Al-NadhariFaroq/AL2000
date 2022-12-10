package db.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CONTROLLED_SUBSCRIBERS", schema = "ALNADHAF", catalog = "")
public class CtrlSubPOJO {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CONTROLLED_SUBSCRIBER_ID")
    private int controlledSubscriberId;
    @JoinColumn(name="SUBSCRIBER_ID", referencedColumnName = "SUBSCRIBER_ID")
    @ManyToOne(optional = false)
    private SubscriberPOJO subscriber;
    @Basic
    @Column(name = "IS_CONTROLLED")
    private boolean isControlled;

    public CtrlSubPOJO() {

    }

    public CtrlSubPOJO(SubscriberPOJO subscriber, int controlledSubscriberId, boolean isControlled) {
        this.subscriber = subscriber;
        this.controlledSubscriberId = controlledSubscriberId;
        this.isControlled = isControlled;
    }

    public SubscriberPOJO getSubscriber() {
        return subscriber;
    }


    public int getControlledSubscriberId() {
        return controlledSubscriberId;
    }

    public void setControlledSubscriberId(int subSubscriberId) {
        this.controlledSubscriberId = subSubscriberId;
    }

    public boolean isControlled() {
        return isControlled;
    }

    public void setControlled(boolean controlled) {
        isControlled = controlled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CtrlSubPOJO)) {
            return false;
        }
        CtrlSubPOJO that = (CtrlSubPOJO) o;
        return subscriber.getCreditCardNumber() == that.subscriber.getCreditCardNumber() &&
               controlledSubscriberId == that.controlledSubscriberId && isControlled == that.isControlled;
    }

    @Override
    public int hashCode() {
        return Objects.hash(subscriber.getFirstName()+" "+subscriber.getLastName(), controlledSubscriberId, isControlled);
    }
}
