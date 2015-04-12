package mysql;

import dao.AbstractJDBCDao;
import dao.PersistException;
import entity.SelectAll;

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
public class MySqlSelectInAll extends AbstractJDBCDao<SelectAll> {
    private final String SELECT = "SELECT AutoParts.AutoPartId, AutoParts.Name, CarBrands.NameBrand, CarModels.NameModel, "+
            "CarModels.YearOfRelease,Contractors.NameOfAgent, Documents_has_AutoParts.Price, Documents_has_AutoParts.Number FROM AutoParts\n"+
            "INNER JOIN AutoParts_has_CarModels  ON  AutoParts.AutoPartId=AutoParts_has_CarModels.AutoPartId \n"+
            "INNER JOIN CarModels  ON  AutoParts_has_CarModels.CarModelId=CarModels.CarModelId \n"+
            "INNER JOIN CarBrands  ON  CarModels.CarBrandId=CarBrands.CarBrandId\n"+
            "INNER JOIN Documents_has_AutoParts  ON  AutoParts.AutoPartId=Documents_has_AutoParts.AutoParts_AutoPartId\n"+
            "INNER JOIN Documents  ON  Documents_has_AutoParts.Documents_DocumentId=Documents.DocumentId\n"+
            "INNER JOIN Contractors  ON  Documents.AgentId=Contractors.AgentId";
    private final String SELECTSEARCH = "SELECT AutoParts.AutoPartId, AutoParts.Name, CarBrands.NameBrand, CarModels.NameModel, "+
            "CarModels.YearOfRelease,Contractors.NameOfAgent, Documents_has_AutoParts.Price, Documents_has_AutoParts.Number FROM AutoParts\n"+
            "INNER JOIN AutoParts_has_CarModels  ON  AutoParts.AutoPartId=AutoParts_has_CarModels.AutoPartId \n"+
            "INNER JOIN CarModels  ON  AutoParts_has_CarModels.CarModelId=CarModels.CarModelId \n"+
            "INNER JOIN CarBrands  ON  CarModels.CarBrandId=CarBrands.CarBrandId\n"+
            "INNER JOIN Documents_has_AutoParts  ON  AutoParts.AutoPartId=Documents_has_AutoParts.AutoParts_AutoPartId\n"+
            "INNER JOIN Documents  ON  Documents_has_AutoParts.Documents_DocumentId=Documents.DocumentId\n"+
            "INNER JOIN Contractors  ON  Documents.AgentId=Contractors.AgentId\n";
    private final String SELECTSORT = "SELECT AutoParts.AutoPartId, AutoParts.Name, CarBrands.NameBrand, CarModels.NameModel, "+
            "CarModels.YearOfRelease,Contractors.NameOfAgent, Documents_has_AutoParts.Price, Documents_has_AutoParts.Number FROM AutoParts\n"+
            "INNER JOIN AutoParts_has_CarModels  ON  AutoParts.AutoPartId=AutoParts_has_CarModels.AutoPartId \n"+
            "INNER JOIN CarModels  ON  AutoParts_has_CarModels.CarModelId=CarModels.CarModelId \n"+
            "INNER JOIN CarBrands  ON  CarModels.CarBrandId=CarBrands.CarBrandId\n"+
            "INNER JOIN Documents_has_AutoParts  ON  AutoParts.AutoPartId=Documents_has_AutoParts.AutoParts_AutoPartId\n"+
            "INNER JOIN Documents  ON  Documents_has_AutoParts.Documents_DocumentId=Documents.DocumentId\n"+
            "INNER JOIN Contractors  ON  Documents.AgentId=Contractors.AgentId\n"+
            "ORDER BY  ? ";


    @Override
    public String getSelectQuery() {
        return null;
    }

    @Override
    public String getCreateQuery() {
        return null;
    }

    @Override
    public String getUpdateQuery() {return null; }

    @Override
    public String getDeleteQuery() {
        return null;
    }

    public MySqlSelectInAll(Connection connection) {
        super(connection);
    }

    @Override
    protected List<SelectAll> parseResultSet(ResultSet rs) throws PersistException {
        LinkedList<SelectAll> result = new LinkedList<SelectAll>();
        try {
            while (rs.next()) {
                SelectAll selectAll = new SelectAll();
                selectAll.setId(rs.getInt("AutoPartId"));
                selectAll.setName(rs.getString("Name"));
                selectAll.setNameBrand(rs.getString("NameBrand"));
                selectAll.setNameModel(rs.getString("NameModel"));
                selectAll.setYearOfRelease(rs.getInt("YearOfRelease"));
                selectAll.setNameOfAgent(rs.getString("NameOfAgent"));
                selectAll.setPrice(rs.getInt("Price"));
                selectAll.setNumber(rs.getInt("Number"));
                result.add(selectAll);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return result;
    }
    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, SelectAll object) throws PersistException {
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, SelectAll object) throws PersistException {
    }

    public List<SelectAll> getAll() throws PersistException {
        List<SelectAll> list;
        String sql = SELECT;
        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
            statement.close();
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return list;
    }

    public List<SelectAll> getAllSearch(String where, int what) throws PersistException {
        List<SelectAll> list;
        String sql = SELECTSEARCH+
                "WHERE "+where+" = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            try {
                statement.setInt(1, what);
            } catch (Exception e) {
                throw new PersistException(e);
            }
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
            statement.close();
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return list;
    }

    public List<SelectAll> getAllSort(String sort) throws PersistException {
        List<SelectAll> list;
        String sql = SELECTSORT;
        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            try {
                statement.setString(1, sort);
            } catch (Exception e) {
                throw new PersistException(e);
            }
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
            statement.close();
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return list;
    }
}
