package fc.user;

public enum UserType {
    NONE, CLIENT, SUBSCRIBER, TECHNICIAN;

    @Override
    public String toString() {
        return name().substring(0, 1).toUpperCase() + name().substring(1).toLowerCase();
    }
}
