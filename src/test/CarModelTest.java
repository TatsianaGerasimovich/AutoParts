package test;

import entity.CarModel;
import mysql.MySqlCarModelDao;
import org.dbunit.Assertion;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author Tatiana
 * @version 1.00 12.04.2015.
 */
public class CarModelTest extends DBUnitConfig{

    private MySqlCarModelDao service;

    @Before
    public void setUp() throws Exception {
        service= new MySqlCarModelDao(tester.getConnection().getConnection());
        super.setUp();
        beforeData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("DataSet.xml"));

        tester.setDataSet(beforeData);
        tester.onSetup();
    }

    public CarModelTest(String name) {
        super(name);
    }

    @Test
    public void testGetAll() throws Exception {
        List<CarModel> carBrands = service.getAll();

        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("DataSet.xml"));

        IDataSet actualData = tester.getConnection().createDataSet();
        Assertion.assertEquals(expectedData, actualData);
        Assert.assertEquals(expectedData.getTable("carmodels").getRowCount(), carBrands.size());
    }

    @Test
    public void testSave() throws Exception {
        CarModel carModel = new CarModel();
        carModel.setId(4);
        carModel.setCarBrandId(3);
        carModel.setNameModel("Sandero");
        carModel.setYearOfRelease(2010);

        service.persist(carModel);

        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("DataSet-save.xml"));

        IDataSet actualData = tester.getConnection().createDataSet();

        String[] ignore = {"CarModelId"};
        Assertion.assertEqualsIgnoreCols(expectedData, actualData, "carModel", ignore);
    }
    @Test
    public void testDelete() throws Exception {
        CarModel carModel = new CarModel();
        carModel.setId(1);
        carModel.setCarBrandId(1);
        carModel.setNameModel("Yaris");
        carModel.setYearOfRelease(2010);

        service.delete(carModel);

        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("DataSet-delete.xml"));

        IDataSet actualData = tester.getConnection().createDataSet();

        String[] ignore = {"CarModelId"};
        Assertion.assertEqualsIgnoreCols(expectedData, actualData, "carModel", ignore);
    }
    public void testUpdate() throws Exception {
        CarModel carModel = new CarModel();
        carModel.setId(2);
        carModel.setCarBrandId(2);
        carModel.setNameModel("Agila");
        carModel.setYearOfRelease(2001);

        service.delete(carModel);

        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("DataSet-update.xml"));

        IDataSet actualData = tester.getConnection().createDataSet();

        String[] ignore = {"CarModelId"};
        Assertion.assertEqualsIgnoreCols(expectedData, actualData, "carModel", ignore);
    }


}