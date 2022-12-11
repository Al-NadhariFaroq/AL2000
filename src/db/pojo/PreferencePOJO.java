package db.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Preferences")
@Table(name = "PREFERENCES", schema = "ALNADHAF", catalog = "")
public class PreferencePOJO {
    @Id
    @Column(name = "PREFERENCE_ID")
    private int preferenceId;
    @ManyToOne
    @JoinColumn(name = "SUBSCRIBER_ID")
    private SubscriberPOJO subscriber;
    @ManyToOne
    @JoinColumn(name = "THEME_ID")
    private ThemePOJO theme;
    @Basic
    @Column(name = "FORBIDDEN")
    private boolean forbidden;

    public PreferencePOJO() {

    }

    public PreferencePOJO(int preferenceId, SubscriberPOJO subscriber, ThemePOJO theme, boolean forbidden) {
        this.preferenceId = preferenceId;
        this.subscriber = subscriber;
        this.theme = theme;
        this.forbidden = forbidden;
    }

    public int getPreferenceId() {
        return preferenceId;
    }

    public void setPreferenceId(int preferenceId) {
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
        return preferenceId == that.preferenceId && subscriber.getSubscriberId() == that.subscriber.getSubscriberId() &&
               forbidden == that.forbidden && Objects.equals(theme.getThemeId(), that.theme.getThemeId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(preferenceId, subscriber.getSubscriberId(), theme.getThemeId(), forbidden);
    }
}
