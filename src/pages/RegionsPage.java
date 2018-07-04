package pages;

import framework.Helper;
import framework.Page;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegionsPage extends Page {

    private void clickOnAddRegionsButton() {
        clickOnElement(By.className("pull-right"));
    }

    private void sendTextOnTheTitleField() {
        sendTextOnField(By.id("title"), Helper.getRandomText());
    }

    private void clickOnSaveRegionButton() {
        clickOnElement(By.id("save-region-button"));
    }

    public void addNewRegion() {
        clickOnAddRegionsButton();
        sendTextOnTheTitleField();
        clickOnSaveRegionButton();
    }

    private void clickOnEditRegionButton(WebElement row) {
        WebElement editButton = row.findElement(By.xpath("//*[@id=\"regionsTable\"]/tbody/tr[1]/td[5]/div/a/span"));
        editButton.click();
    }

    private void clickOnRegionDeleteButton(WebElement row) {
        WebElement deleteButton = row.findElement(By.cssSelector("button[title='Delete']"));
        deleteButton.click();
    }

    private void sendTextOnTitleFieldWithClear(WebDriver driver) {
        WebElement titleField = driver.findElement(By.id("title"));
        titleField.clear();
        titleField.sendKeys(Helper.getRandomText());
    }

    private List<WebElement> getRowsFromTable() {
        WebElement tBody = waitForElementVisibility(By.className("ui-sortable"));
        List<WebElement> rows = tBody.findElements(By.tagName("tr"));
        System.out.println("Number of rows: " + rows.size());
        return rows;
    }

    private WebElement chooseFirstRow() {
        List<WebElement> rows = getRowsFromTable();
        WebElement firstRow = rows.get(0);
        return firstRow;
    }

    private WebElement chooseLastRow() {
        List<WebElement> rows = getRowsFromTable();
        WebElement lastRow = rows.get(rows.size() - 1);
        return lastRow;
    }

    private WebElement chooseRandomRow() {
        List<WebElement> rows = getRowsFromTable();
        WebElement randomRow = rows.get(Helper.getRandomInteger(rows.size()));
        return randomRow;
    }

    public void editFirstRegion() {
        WebElement firstRow = chooseFirstRow();
        clickOnEditRegionButton(firstRow);
        sendTextOnField(By.id("title"));
        clickOnSaveRegionButton();
    }

    public void editLastRegion() {
        WebElement lastRow = chooseLastRow();
        clickOnEditRegionButton(lastRow);
        sendTextOnField(By.id("title"));
        clickOnSaveRegionButton();
    }

    public void editRandomRegion() {
        WebElement randomRow = chooseRandomRow();
        clickOnEditRegionButton(randomRow);
        sendTextOnField(By.id("title"));
        clickOnSaveRegionButton();
    }

    private void clickOnConfirmRegionDeleteButton() {
//        driver.switchTo().activeElement();
        clickOnElement(By.xpath("//*[@id=\"regionDeleteDialog\"]/div/div/div[3]/button[2]"));
    }

    public void deleteFirstRegion() {
        WebElement firsRow = chooseFirstRow();
        clickOnRegionDeleteButton(firsRow);
        clickOnConfirmRegionDeleteButton();
    }

    public void deleteLastRegion() {
        WebElement lastRow = chooseLastRow();
        clickOnRegionDeleteButton(lastRow);
        clickOnConfirmRegionDeleteButton();
    }

    public void deleteRandomRegion() {
        WebElement randomRow = chooseRandomRow();
        clickOnRegionDeleteButton(randomRow);
        clickOnConfirmRegionDeleteButton();
    }

}
