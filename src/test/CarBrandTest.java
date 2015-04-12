package test;

import entity.CarBrand;
import mysql.MySqlCarBrandDao;
import org.dbunit.Assertion;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author Tatiana
 * @version 1.00 08.04.2015.
 */
public class CarBrandTest extends DBUnitConfig{

    private MySqlCarBrandDao service;

    @Before
    public void setUp() throws Exception {
        service= new MySqlCarBrandDao(tester.getConnection().getConnection());
        super.setUp();
        beforeData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("DataSet.xml"));

        tester.setDataSet(beforeData);
        tester.onSetup();
    }

    public CarBrandTest(String name) {
        super(name);
    }

    @Test
    public void testGetAll() throws Exception {
        List<CarBrand> carBrands = service.getAll();

        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("DataSet.xml"));

        IDataSet actualData = tester.getConnection().createDataSet();
        Assertion.assertEquals(expectedData, actualData);
        Assert.assertEquals(expectedData.getTable("carbrands").getRowCount(), carBrands.size());
    }

    @Test
    public void testSave() throws Exception {
        CarBrand carBrand = new CarBrand();
        carBrand.setId(4);
        carBrand.setNameBrand("BMW");

        service.persist(carBrand);

        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("DataSet-save.xml"));

        IDataSet actualData = tester.getConnection().createDataSet();

        String[] ignore = {"id"};
        Assertion.assertEqualsIgnoreCols(expectedData, actualData, "carBrand", ignore);
    }
    @Test
    public void testDelete() throws Exception {
        CarBrand carBrand = new CarBrand();
        carBrand.setId(3);
        carBrand.setNameBrand("Reno");

        service.delete(carBrand);

        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("DataSet-delete.xml"));

        IDataSet actualData = tester.getConnection().createDataSet();

        String[] ignore = {"id"};
        Assertion.assertEqualsIgnoreCols(expectedData, actualData, "carBrand", ignore);
    }
    public void testUpdate() throws Exception {
        CarBrand carBrand = new CarBrand();
        carBrand.setId(3);
        carBrand.setNameBrand("Saab");

        service.delete(carBrand);

        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("DataSet-update.xml"));

        IDataSet actualData = tester.getConnection().createDataSet();

        String[] ignore = {"CarBrandId"};
        Assertion.assertEqualsIgnoreCols(expectedData, actualData, "carBrand", ignore);
    }


}