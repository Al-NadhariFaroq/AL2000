package db.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Controlled_Subscribers")
@Table(name = "CONTROLLED_SUBSCRIBERS", schema = "ALNADHAF", catalog = "")
public class CtrlSubPOJO {
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

    public CtrlSubPOJO(int controlledSubscriberId, SubscriberPOJO subscriber, int subSubscriberId, boolean isControlled) {
        this.controlledSubscriberId = controlledSubscriberId;
        this.subscriber = subscriber;
        this.isControlled = isControlled;
    }

    public int getControlledSubscriberId() {
        return controlledSubscriberId;
    }

    public void setControlledSubscriberId(int controlledSubscriberId) {
        this.controlledSubscriberId = controlledSubscriberId;
    }

    public SubscriberPOJO getSubscriber() {
        return subscriber;
    }

    public void setSubscriberId(SubscriberPOJO subscriber) {
        this.subscriber = subscriber;
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
        return controlledSubscriberId == that.controlledSubscriberId && subscriber.getSubscriberId() == that.subscriber.getSubscriberId() &&
                isControlled == that.isControlled;
    }

    @Override
    public int hashCode() {
        return Objects.hash(controlledSubscriberId, subscriber.getSubscriberId(), isControlled);
    }
}
