package mysql;

import dao.AbstractJDBCDao;
import dao.PersistException;
import entity.Document;
import java.sql.Connection;
import java.sql.Date;
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
public class MySqlDocumentDao extends AbstractJDBCDao<Document> {
    private final String SELECT = "SELECT documentId, agentId,documentType,date FROM Documents";
    private final String INSERT = "INSERT INTO Documents (documentId, agentId,documentType,date) \n"
            + "VALUES (?, ?, ?, ?);";
    private final String UPDATE = "UPDATE Documents SET agentId = ?, documentType = ?, date = ? WHERE documentId= ?;";
    private final String DELETE = "DELETE FROM Documents WHERE documentId= ?;";

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

    public MySqlDocumentDao(Connection connection) {
        super(connection);
    }

    @Override
    protected List<Document> parseResultSet(ResultSet rs) throws PersistException {
        LinkedList<Document> result = new LinkedList<Document>();
        try {
            while (rs.next()) {
                Document order = new Document();
                order.setId(rs.getInt("documentId"));
                order.setAgentId(rs.getInt("agentId"));
                order.setDocumentType(rs.getString("documentType"));
                order.setDate(rs.getDate("date"));
                result.add(order);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return result;
    }

    public int getNewId() throws PersistException {
        List<Document> idCreate = this.getAll();
        List<Integer> idCr = new ArrayList();
        for (Document item : idCreate) {
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
    protected void prepareStatementForInsert(PreparedStatement statement, Document object) throws PersistException {
        try {
            statement.setInt(1, object.getId());
            statement.setInt(2, object.getAgentId());
            statement.setString(3, object.getDocumentType());
            statement.setDate(4, object.getDate());

        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Document object) throws PersistException {
        try {
            statement.setInt(1, object.getAgentId());
            statement.setString(2, object.getDocumentType());
            statement.setDate(3, object.getDate());
            statement.setInt(4, object.getId());

        } catch (Exception e) {
            throw new PersistException(e);
        }
    }
}
