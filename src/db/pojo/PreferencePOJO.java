package db.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "preferences")
@Table(name = "preferences", schema = "rocd", catalog = "")
public class PreferencePOJO implements POJO {
    @Id
    @Column(name = "preference_id")
    private int preferenceId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "subscriber_id")
    private SubscriberPOJO subscriber;

    @ManyToOne(optional = false)
    @JoinColumn(name = "theme_id")
    private ThemePOJO theme;

    @Basic
    @Column(name = "forbidden")
    private boolean forbidden;

    public PreferencePOJO() {
        super();
    }

    public PreferencePOJO(int preferenceId, SubscriberPOJO subscriber, ThemePOJO theme, boolean forbidden) {
        super();
        this.preferenceId = preferenceId;
        this.subscriber = subscriber;
        this.theme = theme;
        this.forbidden = forbidden;
    }

    public int getID() {
        return preferenceId;
    }

    public void setID(int preferenceId) {
        this.preferenceId = preferenceId;
    }

    public SubscriberPOJO getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(SubscriberPOJO subscriber) {
        this.subscriber = subscriber;
    }

    public ThemePOJO getTheme() {
        return theme;
    }

    public void setTheme(ThemePOJO theme) {
        this.theme = theme;
    }

    public boolean isForbidden() {
        return forbidden;
    }

    public void setForbidden(boolean forbidden) {
        this.forbidden = forbidden;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PreferencePOJO)) {
            return false;
        }
        PreferencePOJO that = (PreferencePOJO) o;
        return preferenceId == that.preferenceId && subscriber.getID() == that.subscriber.getID() &&
               forbidden == that.forbidden && Objects.equals(theme.getID(), that.theme.getID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(preferenceId, subscriber.getID(), theme.getID(), forbidden);
    }
}
