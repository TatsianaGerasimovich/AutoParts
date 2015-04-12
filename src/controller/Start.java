package controller;

import dao.PersistException;
import entity.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import mysql.*;

/**
 * @author Tatiana
 * @version 1.00 07.04.2015.
 */
public class Start {

    public static void main(String[] args) throws PersistException, SQLException {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        Connection connection = factory.getConnection();
        MySqlContractorDao mySqlContractorDao = (MySqlContractorDao) factory.getDao(connection, Contractor.class);
        MySqlCarBrandDao mySqlCarBrandDao = (MySqlCarBrandDao) factory.getDao(connection, CarBrand.class);
        MySqlAutoPartDao mySqlAutoPartDao = (MySqlAutoPartDao) factory.getDao(connection, AutoPart.class);
        MySqlCarModelDao mySqlCarModelDao = (MySqlCarModelDao) factory.getDao(connection, CarModel.class);
        MySqlSelectInAll mySqlSelectInAll = (MySqlSelectInAll) factory.getDao(connection, SelectAll.class);
        MySqlAutoParts_has_CarModelsDao mySqlAutoParts_has_CarModelsDao = (MySqlAutoParts_has_CarModelsDao) factory.getDao(connection, AutoParts_has_CarModels.class);
        MySqlDocumentDao mySqlDocumentDao = (MySqlDocumentDao) factory.getDao(connection, Document.class);
        MySqlDocuments_has_AutoPartsDao mySqlDocuments_has_AutoPartsDao = (MySqlDocuments_has_AutoPartsDao) factory.getDao(connection, Documents_has_AutoParts.class);


        int idContractor = mySqlContractorDao.getNewId();
        int idCarBrand = mySqlCarBrandDao.getNewId();
        int idAutoPart = mySqlAutoPartDao.getNewId();
        int idCarModel = mySqlCarModelDao.getNewId();
        int idDocument = mySqlDocumentDao.getNewId();

        System.out.println("Contractors:");
        for (Contractor item : mySqlContractorDao.getAll()) {
            item.print();
        }
        System.out.println("CarBrand:");
        for (CarBrand item : mySqlCarBrandDao.getAll()) {
            item.print();
        }
        System.out.println("AutoParts:");
        for (AutoPart item : mySqlAutoPartDao.getAll()) {
            item.print();
        }
        System.out.println("CarModel:");
        for (CarModel item : mySqlCarModelDao.getAll()) {
            item.print();
        }
        System.out.println("Documents:");
        for (Document item : mySqlDocumentDao.getAll()) {
            item.print();
        }
        System.out.println("AutoParts_has_CarModels:");
        for (AutoParts_has_CarModels item : mySqlAutoParts_has_CarModelsDao.getAll()) {
            System.out.println(item.toString());
        }
        System.out.println("Documents_has_AutoParts:");
        for (Documents_has_AutoParts item : mySqlDocuments_has_AutoPartsDao.getAll()) {
            System.out.println(item.toString());
        }

        Contractor object = new Contractor(idContractor, "Atlant", "Produser", 8, "Minsk,klenova 18/1-45", 2796520);
        mySqlContractorDao.persist(object);
        CarBrand carBrand = new CarBrand(idCarBrand, "Opel");
        mySqlCarBrandDao.persist(carBrand);
        AutoPart autoPart = new AutoPart(idAutoPart, "Motor");
        mySqlAutoPartDao.persist(autoPart);
        CarModel carModel = new CarModel(idCarModel, idCarBrand,"Astra",2005);
        mySqlCarModelDao.persist(carModel);
        Document document = new Document(idDocument, idContractor,"To",new Date(1203));
        mySqlDocumentDao.persist(document);
        AutoParts_has_CarModels autoParts_has_CarModels = new AutoParts_has_CarModels(idAutoPart, idCarModel,idCarBrand);
        mySqlAutoParts_has_CarModelsDao.persist(autoParts_has_CarModels);
        Documents_has_AutoParts documents_has_AutoParts = new Documents_has_AutoParts(idAutoPart, idDocument, 15000,15,"USA");
        mySqlDocuments_has_AutoPartsDao.persist(documents_has_AutoParts);

        System.out.println("Была произведена операция INSERT:");
        System.out.println("Contractors:");
        for (Contractor item : mySqlContractorDao.getAll()) {
            item.print();
        }
        System.out.println("CarBrand:");
        for (CarBrand item : mySqlCarBrandDao.getAll()) {
            item.print();
        }
        System.out.println("AutoParts:");
        for (AutoPart item : mySqlAutoPartDao.getAll()) {
            item.print();
        }
        System.out.println("CarModel:");
        for (CarModel item : mySqlCarModelDao.getAll()) {
            item.print();
        }
        System.out.println("Documents:");
        for (Document item : mySqlDocumentDao.getAll()) {
            item.print();
        }
        System.out.println("AutoParts_has_CarModels:");
        for (AutoParts_has_CarModels item : mySqlAutoParts_has_CarModelsDao.getAll()) {
            System.out.println(item.toString());
        }
        System.out.println("Documents_has_AutoParts:");
        for (Documents_has_AutoParts item : mySqlDocuments_has_AutoPartsDao.getAll()) {
            System.out.println(item.toString());
        }

        object.setNameOfAgent("Mishkin");
        carBrand.setNameBrand("Mazda");
        autoPart.setName("Steklo");
        carModel.setNameModel("Kaget");
        mySqlContractorDao.update(object);
        mySqlCarBrandDao.update(carBrand);
        mySqlAutoPartDao.update(autoPart);
        mySqlCarModelDao.update(carModel);

        System.out.println("Contractors:");
        for (Contractor item : mySqlContractorDao.getAll()) {
            item.print();
        }
        System.out.println("CarBrand:");
        for (CarBrand item : mySqlCarBrandDao.getAll()) {
            item.print();
        }
        System.out.println("AutoParts:");
        for (AutoPart item : mySqlAutoPartDao.getAll()) {
            item.print();
        }
        System.out.println("CarModel:");
        for (CarModel item : mySqlCarModelDao.getAll()) {
            item.print();
        }
        System.out.println("All:");
        for (SelectAll item : mySqlSelectInAll.getAll()) {
            System.out.println(item.toString());
        }
        System.out.println("All:");
        for (SelectAll item : mySqlSelectInAll.getAllSearch("Documents_has_AutoParts.Price",15000)) {
            System.out.println(item.toString());
        }
        System.out.println("All:");
        for (SelectAll item : mySqlSelectInAll.getAllSort("Documents_has_AutoParts.Price")) {
            System.out.println(item.toString());
        }

        mySqlCarBrandDao.delete(carBrand);
        mySqlContractorDao.delete(object);
        mySqlAutoPartDao.delete(autoPart);


        System.out.println("Была произведена операция DELETE:");
        System.out.println("Contractors:");
        for (Contractor item : mySqlContractorDao.getAll()) {
            item.print();
        }
        System.out.println("CarBrand:");
        for (CarBrand item : mySqlCarBrandDao.getAll()) {
            item.print();
        }
        System.out.println("AutoParts:");
        for (AutoPart item : mySqlAutoPartDao.getAll()) {
            item.print();
        }
        System.out.println("CarModel:");
        for (CarModel item : mySqlCarModelDao.getAll()) {
            item.print();
        }
        factory.closeConnection(connection);
    }

}
