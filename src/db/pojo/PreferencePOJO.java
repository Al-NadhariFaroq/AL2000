package db.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Preferences")
@Table(name = "PREFERENCES", schema = "ALNADHAF", catalog = "")
public class PreferencePOJO {
    @Id
    @Column(name = "PREFERENCE_ID")
    private int preferenceId;
    @Basic
    @Column(name = "SUBSCRIBER_ID")
    private int subscriberId;
    @Basic
    @Column(name = "THEME_ID")
    private Integer themeId;
    @Basic
    @Column(name = "FORBIDDEN")
    private boolean forbidden;

    public PreferencePOJO() {

    }

    public PreferencePOJO(int preferenceId,int subscriberId, Integer themeId, boolean forbidden) {
        this.preferenceId = preferenceId;
        this.subscriberId = subscriberId;
        this.themeId = themeId;
        this.forbidden = forbidden;
    }

    public int getPreferenceId() {
        return preferenceId;
    }

    public void setPreferenceId(int preferenceId) {
        this.preferenceId = preferenceId;
    }

    public int getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(int subscriberId) {
        this.subscriberId = subscriberId;
    }

    public Integer getThemeId() {
        return themeId;
    }

    public void setThemeId(Integer themeId) {
        this.themeId = themeId;
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
        return preferenceId == that.preferenceId && subscriberId == that.subscriberId && forbidden == that.forbidden &&
               Objects.equals(themeId, that.themeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(preferenceId, subscriberId, themeId, forbidden);
    }
}
