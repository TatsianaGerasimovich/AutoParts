package mysql;

import dao.DaoFactory;
import dao.GenericDao;
import dao.PersistException;
import entity.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Tatiana
 * @version 1.00 07.04.2015.
 */

public class MySqlDaoFactory implements DaoFactory {
    private final String USER = "root";//Логин пользователя
    private final String PASSWORD = "pass";//Пароль пользователя
    private final String URL = "jdbc:mysql://localhost/autoparts";//URL адрес
    private final String DRIVER = "com.mysql.jdbc.Driver";//Имя драйвера
    public interface DaoCreator {

        public GenericDao create(Connection connection);
    }

    private Map<Class, DaoCreator> creators;

    public Connection getConnection() throws PersistException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new PersistException(e);
        }
        return connection;
    }

    @Override
    public void closeConnection(Connection connection) throws PersistException {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new PersistException(e);
        }
    }

    @Override
    public GenericDao getDao(Connection connection,Class entityClass) throws PersistException {
        DaoCreator creator = creators.get(entityClass);
        if (creator == null) {
            throw new PersistException("Dao object for " + entityClass + " not found.");
        }
        return creator.create(connection);
    }

    public MySqlDaoFactory() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        creators = new HashMap<Class, DaoCreator>();
        creators.put(Contractor.class, new DaoCreator() {
            @Override
            public GenericDao create(Connection connection) {
                return new MySqlContractorDao(connection);
            }
        });
        creators.put(Document.class, new DaoCreator() {
            @Override
            public GenericDao create(Connection connection) {
                return new MySqlDocumentDao(connection);
            }
        });
        creators.put(CarBrand.class, new DaoCreator() {
            @Override
            public GenericDao create(Connection connection) {
                return new MySqlCarBrandDao(connection);
            }
        });
        creators.put(AutoPart.class, new DaoCreator() {
            @Override
            public GenericDao create(Connection connection) {
                return new MySqlAutoPartDao(connection);
            }
        });
        creators.put(AutoParts_has_CarModels.class, new DaoCreator() {
            @Override
            public GenericDao create(Connection connection) {
                return new MySqlAutoParts_has_CarModelsDao(connection);
            }
        });
        creators.put(CarModel.class, new DaoCreator() {
            @Override
            public GenericDao create(Connection connection) {
                return new MySqlCarModelDao(connection);
            }
        });
        creators.put(Documents_has_AutoParts.class, new DaoCreator() {
            @Override
            public GenericDao create(Connection connection) {
                return new MySqlDocuments_has_AutoPartsDao(connection);
            }
        });
        creators.put(SelectAll.class, new DaoCreator() {
            @Override
            public GenericDao create(Connection connection) {
                return new MySqlSelectInAll(connection);
            }
        });
    }
}
