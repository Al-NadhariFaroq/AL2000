package db.dao;

import db.pojo.ThemePOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ThemeDAO extends DAO<ThemePOJO> {

    protected ThemeDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public ThemePOJO read(int id) {
        ThemePOJO themePOJO = entityManager.find(ThemePOJO.class, id);
        if (themePOJO == null) {
            throw new EntityNotFoundException("Can't find theme for ID " + id);
        }
        return themePOJO;
    }

    public List<ThemePOJO> readAll() {
        List<ThemePOJO> themesPOJO = new ArrayList<>();
        // TODO read all order by count(*)
        return themesPOJO;
    }
}
