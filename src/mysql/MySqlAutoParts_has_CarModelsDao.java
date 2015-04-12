package mysql;

import dao.AbstractJDBCDao;
import dao.PersistException;
import entity.AutoParts_has_CarModels;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Tatiana
 * @version 1.00 12.04.2015.
 */
public class MySqlAutoParts_has_CarModelsDao extends AbstractJDBCDao<AutoParts_has_CarModels> {
    private final String SELECT = "SELECT autoPartId, carModelId,carBrandId FROM AutoParts_has_CarModels";
    private final String INSERT = "INSERT INTO AutoParts_has_CarModels (autoPartId, carModelId, carBrandId) \n"
            + "VALUES (?, ?, ?);";
    private final String UPDATE = "UPDATE AutoParts_has_CarModels SET carModelId = ? carBrandId=? WHERE autoPartId= ?;";
    private final String DELETE = "DELETE FROM AutoParts_has_CarModels WHERE autoPartId = ?;";

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

    public MySqlAutoParts_has_CarModelsDao(Connection connection) {
        super(connection);
    }

    @Override
    protected List<AutoParts_has_CarModels> parseResultSet(ResultSet rs) throws PersistException {
        LinkedList<AutoParts_has_CarModels> result = new LinkedList<AutoParts_has_CarModels>();
        try {
            while (rs.next()) {
                AutoParts_has_CarModels part = new AutoParts_has_CarModels();
                part.setId(rs.getInt("AutoPartId"));
                part.setCarModelId(rs.getInt("CarModelId"));
                part.setCarBrandId(rs.getInt("CarBrandId"));
                result.add(part);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, AutoParts_has_CarModels object) throws PersistException {
        try {
            statement.setInt(1, object.getId());
            statement.setInt(2, object.getCarModelId());
            statement.setInt(3, object.getCarBrandId());

        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, AutoParts_has_CarModels object) throws PersistException {
        try {
            statement.setInt(1, object.getCarModelId());
            statement.setInt(2, object.getCarBrandId());
            statement.setInt(3, object.getId());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }
}
