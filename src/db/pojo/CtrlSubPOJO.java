package db.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CONTROLLED_SUBSCRIBERS", schema = "ALNADHAF", catalog = "")
public class CtrlSubPOJO {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CONTROLLED_SUBSCRIBER_ID")
    private int scoreId;
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

    public CtrlSubPOJO(int subscriberId, int subSubscriberId, boolean isControlled) {
        this.subscriberId = subscriberId;
        this.subSubscriberId = subSubscriberId;
        this.isControlled = isControlled;
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
        return scoreId == that.scoreId && subscriberId == that.subscriberId &&
               subSubscriberId == that.subSubscriberId && isControlled == that.isControlled;
    }

    @Override
    public int hashCode() {
        return Objects.hash(scoreId, subscriberId, subSubscriberId, isControlled);
    }
}
