package pages;

import framework.Helper;
import framework.Page;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PortalsPage extends Page {
       
    private void clickOnAddPortalsButton() {
        clickOnElement(By.className("pull-right"));
    }

    private void clickOnEditPortalButton(WebElement row) {
        WebElement editButton = row.findElement(By.cssSelector("a[title='Edit']"));
        editButton.click();
    }
    
    private void clickOnDeletePortalButton(WebElement row){
        WebElement deleteButton = row.findElement(By.cssSelector("button[title='Delete']"));
        deleteButton.click();
    }
    private void clickOnSubmitDeleteButton(){
//        driver.switchTo().activeElement();
        clickOnElement(By.xpath("//*[@id=\"portalDeleteDialog\"]/div/div/div[3]/button[2]"));
    }

    private void sendTextOnTheTitleField() {
        sendTextOnField(By.id("title"), Helper.getRandomText());
    }

    private void sendTextOnTheTitleFieldWithClear() {
        WebElement titleFieldClear = waitForElementVisibility(By.id("title"));
        titleFieldClear.clear();
        titleFieldClear.sendKeys(Helper.getRandomText());
    }

    private void sendUrlOnTheUrlField() {
        sendTextOnField(By.id("url"), Helper.getRandomUrl());
    }

//    private List<WebElement> dropDownRandomRow() {
//        WebElement regionId = waitForElementVisibility(By.className("form-control"));
//        List<WebElement> rows = regionId.findElements(By.tagName("option"));
//        System.out.println("Broj redova je: " + rows.size());
//        return rows;
//    }
    private void chooseDropDownRandomRow() {
        WebElement row = waitForElementVisibility(By.name("region_id"));
        Select rows = new Select(row);
        rows.selectByIndex(3);
    }

    private void clickOnSaveRegionButton() {
        clickOnElement(By.id("save-portal-button"));
    }

    public void addNewPortal() {
        clickOnAddPortalsButton();
        sendTextOnTheTitleField();
        sendUrlOnTheUrlField();
        chooseDropDownRandomRow();
        clickOnSaveRegionButton();
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
        List<WebElement> rowss = getRowsFromTable();
        WebElement lastRow = rowss.get(rowss.size() - 1);
        return lastRow;
    }

    private WebElement chooseRandomRow() {
        List<WebElement> rows = getRowsFromTable();
        WebElement randomRow = rows.get(Helper.getRandomInteger(rows.size()));
        return randomRow;
    }

    public void editFirstPortal() {
        WebElement firstRow = chooseFirstRow();
        clickOnEditPortalButton(firstRow);
        sendTextOnTheTitleFieldWithClear();
        sendUrlOnTheUrlField();
        chooseDropDownRandomRow();
        clickOnSaveRegionButton();
    }

    public void editLastPortal() {
        WebElement lastRow = chooseLastRow();
        clickOnEditPortalButton(lastRow);
        sendTextOnTheTitleFieldWithClear();
        sendUrlOnTheUrlField();
        chooseDropDownRandomRow();
        clickOnSaveRegionButton();
    }
    
    public void editRandomPortal(){
        WebElement randomRow = chooseRandomRow();
        clickOnEditPortalButton(randomRow);
        sendTextOnTheTitleFieldWithClear();
        sendUrlOnTheUrlField();
        chooseDropDownRandomRow();
        clickOnSaveRegionButton();
    }
    
    public void deleteFirstPortal(){
        WebElement firstRow = chooseFirstRow();
        clickOnDeletePortalButton(firstRow);
        clickOnSubmitDeleteButton();
    }
    
    public void deleteLastPortal(){
        WebElement lastRow = chooseLastRow();
        clickOnDeletePortalButton(lastRow);
        clickOnSubmitDeleteButton();
    }
    
    public void deleteRandomPortal(){
        WebElement randomRow = chooseRandomRow();
        clickOnDeletePortalButton(randomRow);
        clickOnSubmitDeleteButton();
    }
}
