package dao;

/**
 * @author Tatiana
 * @version 1.00 07.04.2015.
 */
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Фабрика объектов для работы с базой данных
 */
public interface DaoFactory {
    /**
     * Возвращает подключение к базе данных
     */
    public Connection getConnection() throws PersistException;

    public GenericDao getDao(Connection connection,Class entityClass) throws PersistException;

    public void closeConnection(Connection connection) throws PersistException;

}
