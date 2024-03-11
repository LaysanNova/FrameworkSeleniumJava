import helper.TestUtils;
import model.DemoQAPage;
import model.GooglePage;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TableTest extends BaseTest {

    @Test
    public void googleTable() {

        GooglePage googlePage = new GooglePage(getDriver());
        List<String> table = googlePage.getTable();

        TestUtils.printTable(table);
    }

    @Test
    public void demoQATable1() {

        DemoQAPage demoQAPage = new DemoQAPage(getDriver());

        String header = demoQAPage.getHeader(true);
        List<String> rows = demoQAPage.getTable();

        List<String> table =  new ArrayList<>();
        table.add(header);
        table.addAll(rows);

        TestUtils.printTable(table);
    }

    @Test
    public void demoQATable2() {

        DemoQAPage demoQAPage = new DemoQAPage(getDriver());

        List<String> header = demoQAPage.getHeader();
        List<List<String>> rows = demoQAPage.getRows();

        List<List<String>> table =  new ArrayList<>();
        table.add(header);
        table.addAll(rows);

        TestUtils.printTable(table, true);
    }
}
