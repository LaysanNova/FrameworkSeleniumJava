package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GooglePage extends BasePage{

    @FindBy(css = "section[aria-labelledby = 'smart-watchlist-title'] .sbnBtf li")
    private List<WebElement> rowList;

    public GooglePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<String> getTable() {

        return rowList.stream().map(WebElement::getText).toList();
    }
}
