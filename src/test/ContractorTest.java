package test;

import entity.Contractor;
import mysql.MySqlContractorDao;
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
public class ContractorTest extends DBUnitConfig{

    private MySqlContractorDao service;

    @Before
    public void setUp() throws Exception {
        service= new MySqlContractorDao(tester.getConnection().getConnection());
        super.setUp();
        beforeData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("DataSet.xml"));

        tester.setDataSet(beforeData);
        tester.onSetup();
    }

    public ContractorTest(String name) {
        super(name);
    }

    @Test
    public void testGetAll() throws Exception {
        List<Contractor> contractors = service.getAll();

        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("DataSet.xml"));

        IDataSet actualData = tester.getConnection().createDataSet();
        Assertion.assertEquals(expectedData, actualData);
        Assert.assertEquals(expectedData.getTable("contractors").getRowCount(), contractors.size());
    }

    @Test
    public void testSave() throws Exception {
        Contractor contractor = new Contractor();
        contractor.setId(3);
        contractor.setNameOfAgent("Sviat");
        contractor.setAddress("Minck, Pushkina 15");
        contractor.setPhone(3624589);
        contractor.setTypeOfAgent("Provider");
        contractor.setRating(7);



        service.persist(contractor);

        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("DataSet-save.xml"));

        IDataSet actualData = tester.getConnection().createDataSet();

        String[] ignore = {"AgentId"};
        Assertion.assertEqualsIgnoreCols(expectedData, actualData, "contractor", ignore);
    }
    @Test
    public void testDelete() throws Exception {
        Contractor contractor = new Contractor();

        contractor.setId(1);
        contractor.setNameOfAgent("AtlantM");
        contractor.setAddress("Minck, Orlova 9");
        contractor.setPhone(2478521);
        contractor.setTypeOfAgent("Provider");
        contractor.setRating(8);


        service.delete(contractor);

        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("DataSet-delete.xml"));

        IDataSet actualData = tester.getConnection().createDataSet();

        String[] ignore = {"AgentId"};
        Assertion.assertEqualsIgnoreCols(expectedData, actualData, "contractor", ignore);
    }
    public void testUpdate() throws Exception {
        Contractor contractor = new Contractor();

        contractor.setId(2);
        contractor.setNameOfAgent("Motexc");
        contractor.setAddress("Minck, Lebedu 46");
        contractor.setPhone(2514587);
        contractor.setTypeOfAgent("Provider");
        contractor.setRating(9);

        service.delete(contractor);

        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("DataSet-update.xml"));

        IDataSet actualData = tester.getConnection().createDataSet();

        String[] ignore = {"AgentId"};
        Assertion.assertEqualsIgnoreCols(expectedData, actualData, "contractor", ignore);
    }


}