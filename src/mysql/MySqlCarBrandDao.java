package mysql;

import dao.AbstractJDBCDao;
import dao.PersistException;
import entity.CarBrand;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Tatiana
 * @version 1.00 07.04.2015.
 */

public class MySqlCarBrandDao extends AbstractJDBCDao<CarBrand> {

    private final String SELECT = "SELECT carBrandId, nameBrand FROM CarBrands";
    private final String INSERT = "INSERT INTO CarBrands (carBrandId, nameBrand) \n"
            + "VALUES (?, ?);";
    private final String UPDATE = "UPDATE CarBrands SET nameBrand = ? WHERE carBrandId= ?;";
    private final String DELETE = "DELETE FROM CarBrands WHERE carBrandId = ?;";

    @Override
    public String getSelectQuery() {
        return SELECT;
    }

    @Override
    public String getCreateQuery() {
        return INSERT;
    }

    @Override
    public String getUpdateQuery() {

        return UPDATE;
    }

    @Override
    public String getDeleteQuery() {
        return DELETE;
    }

    public MySqlCarBrandDao(Connection connection) {
        super(connection);
    }

    @Override
    protected List<CarBrand> parseResultSet(ResultSet rs) throws PersistException {
        LinkedList<CarBrand> result = new LinkedList<CarBrand>();
        try {
            while (rs.next()) {
                CarBrand carBrand = new CarBrand();
                carBrand.setId(rs.getInt("carBrandId"));
                carBrand.setNameBrand(rs.getString("nameBrand"));
                result.add(carBrand);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return result;
    }

    public int getNewId() throws PersistException {
        List<CarBrand> idCreate = this.getAll();
        List<Integer> idCr = new ArrayList();
        for (CarBrand item : idCreate) {
            idCr.add(item.getId());
        }
        Collections.sort(idCr);
        int mId = 0;
        if (idCreate != null) {
            for (Integer counter : idCr) {
                mId = counter;
            }
        }
        return ++mId;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, CarBrand object) throws PersistException {
        try {
            statement.setInt(1, object.getId());
            statement.setString(2, object.getNameBrand());          

        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, CarBrand object) throws PersistException {
        try {
            statement.setString(1, object.getNameBrand());            
            statement.setInt(2, object.getId());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }
}
