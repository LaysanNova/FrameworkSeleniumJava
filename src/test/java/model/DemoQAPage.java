package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class DemoQAPage extends BasePage {

    @FindBy(css = ".rt-table .rt-thead")
    private WebElement header;

    @FindBy(css = ".rt-tbody .rt-tr-group > .rt-tr:not(.-padRow)")
    private List<WebElement> rowList;

    public DemoQAPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getHeader() {
        return header.findElements(By.className("rt-th"))
                .stream()
                .map(WebElement::getText)
                .toList();
    }

    public String getHeader(boolean text) {
        return header.getText();
    }

    public List<String> getTable() {

        return rowList.stream().map(WebElement::getText).toList();
    }

    public List<List<String>> getRows() {

        return rowList.stream()
                .map(row -> row.findElements(By.className("rt-td")))
                .map(list -> list.stream().map(WebElement::getText)
                        .toList())
                .toList();
    }
}

