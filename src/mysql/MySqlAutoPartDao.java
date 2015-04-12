package mysql;

import dao.AbstractJDBCDao;
import dao.PersistException;
import entity.AutoPart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Tatiana
 * @version 1.00 12.04.2015.
 */
public class MySqlAutoPartDao extends AbstractJDBCDao<AutoPart> {

    private final String SELECT = "SELECT AutoPartId, Name FROM autoparts";
    private final String INSERT = "INSERT INTO autoparts (AutoPartId, Name) \n"
            + "VALUES (?, ?);";
    private final String UPDATE = "UPDATE autoparts SET Name = ? WHERE AutoPartId= ?;";
    private final String DELETE = "DELETE FROM autoparts WHERE AutoPartId = ?;";

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

    public MySqlAutoPartDao(Connection connection) {
        super(connection);
    }

    @Override
    protected List<AutoPart> parseResultSet(ResultSet rs) throws PersistException {
        LinkedList<AutoPart> result = new LinkedList<AutoPart>();
        try {
            while (rs.next()) {
                AutoPart autoPart = new AutoPart();
                autoPart.setId(rs.getInt("AutoPartId"));
                autoPart.setName(rs.getString("Name"));
                result.add(autoPart);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return result;
    }

    public int getNewId() throws PersistException {
        List<AutoPart> idCreate = this.getAll();
        List<Integer> idCr = new ArrayList();
        for (AutoPart item : idCreate) {
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
    protected void prepareStatementForInsert(PreparedStatement statement, AutoPart object) throws PersistException {
        try {
            statement.setInt(1, object.getId());
            statement.setString(2, object.getName());

        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, AutoPart object) throws PersistException {
        try {
            statement.setString(1, object.getName());
            statement.setInt(2, object.getId());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }
}