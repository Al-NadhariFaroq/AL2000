package db.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Controlled_Subscribers")
@Table(name = "CONTROLLED_SUBSCRIBERS", schema = "ALNADHAF", catalog = "")
public class CtrlSubPOJO {
    @Id
    @Column(name = "CONTROLLED_SUBSCRIBER_ID")
    private int controlledSubscriberId;
    @Basic
    @Column(name = "SUBSCRIBER_ID")
    private int subscriberId;
    @Basic
    @Column(name = "SUB_SUBSCRIBER_ID")
    private int subSubscriberId;
    @Basic
    @Column(name = "IS_CONTROLLED")
    private boolean isControlled;

    public CtrlSubPOJO() {

    }

    public CtrlSubPOJO(int controlledSubscriberId, int subscriberId, int subSubscriberId, boolean isControlled) {
        this.controlledSubscriberId = controlledSubscriberId;
        this.subscriberId = subscriberId;
        this.subSubscriberId = subSubscriberId;
        this.isControlled = isControlled;
    }

    public int getControlledSubscriberId() {
        return controlledSubscriberId;
    }

    public void setControlledSubscriberId(int controlledSubscriberId) {
        this.controlledSubscriberId = controlledSubscriberId;
    }

    public int getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(int subscriberId) {
        this.subscriberId = subscriberId;
    }

    public int getSubSubscriberId() {
        return subSubscriberId;
    }

    public void setSubSubscriberId(int subSubscriberId) {
        this.subSubscriberId = subSubscriberId;
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
        return controlledSubscriberId == that.controlledSubscriberId && subscriberId == that.subscriberId &&
               subSubscriberId == that.subSubscriberId && isControlled == that.isControlled;
    }

    @Override
    public int hashCode() {
        return Objects.hash(controlledSubscriberId, subscriberId, subSubscriberId, isControlled);
    }
}
