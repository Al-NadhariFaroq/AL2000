package db.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PREFERENCES", schema = "ALNADHAF", catalog = "")
public class PreferencePOJO {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public PreferencePOJO(int subscriberId, Integer themeId, boolean forbidden) {
        this.subscriberId = subscriberId;
        this.themeId = themeId;
        this.forbidden = forbidden;
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
