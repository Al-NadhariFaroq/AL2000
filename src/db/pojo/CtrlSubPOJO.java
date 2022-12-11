package db.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "controlled_subscribers")
@Table(name = "controlled_subscribers", schema = "alnadhaf", catalog = "")
public class CtrlSubPOJO implements POJO {
    @Id
    @Column(name = "controlled_subscriber_id")
    private int controlledSubscriberId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "subscriber_id", referencedColumnName = "subscriber_id")
    private SubscriberPOJO subscriber;

    @Basic
    @Column(name = "is_controlled")
    private boolean isControlled;

    public CtrlSubPOJO() {
        super();
    }

    public CtrlSubPOJO(int controlledSubscriberId, SubscriberPOJO subscriber, boolean isControlled) {
        super();
        this.controlledSubscriberId = controlledSubscriberId;
        this.subscriber = subscriber;
        this.isControlled = isControlled;
    }

    public int getID() {
        return controlledSubscriberId;
    }

    public void setID(int controlledSubscriberId) {
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
        return controlledSubscriberId == that.controlledSubscriberId && subscriber.getID() == that.subscriber.getID() &&
               isControlled == that.isControlled;
    }

    @Override
    public int hashCode() {
        return Objects.hash(controlledSubscriberId, subscriber.getID(), isControlled);
    }
}
