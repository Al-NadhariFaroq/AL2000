package db.dao;

import java.sql.Connection;
import java.sql.SQLException;

import fc.Subscriber;

public class SubscriberDAO extends DAO<Subscriber>{

    public SubscriberDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Subscriber obj) throws SQLException {
        return false;
    }

    @Override
    public Subscriber read(Object obj) throws SQLException {
        return null;
    }

    @Override
    public boolean update(Subscriber obj) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Subscriber obj) throws SQLException {
        return false;
    }
    
    
}
