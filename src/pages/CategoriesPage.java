package pages;

import framework.Helper;
import framework.Page;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoriesPage extends Page {

    private void clickOnAddCategoryButton() {
        clickOnElement(By.className("btn"));
    }

    private void sendTextOnTitleField() {
        sendTextOnField(By.id("title"), Helper.getRandomText());
    }

    private void clickOnSaveCategoryButton() {
        clickOnElement(By.id("save-category-button"));
    }

    public void addNewCategory() {
        clickOnAddCategoryButton();
        sendTextOnTitleField();
        clickOnSaveCategoryButton();
    }

    private void clickOnEditButton(WebElement row) {
        WebElement editButton = row.findElement(By.cssSelector("a[title='Edit']"));
        editButton.click();
    }

    private void clickOnDeleteButton(WebElement row) {
        WebElement deleteButton = row.findElement(By.cssSelector("button[title='Delete']"));
        deleteButton.click();

        //2. way
        //row.findElement(By.cssSelector("button[title='Delete']")).click();
    }

    private void sentTextOnTitleFieldWithClear(WebDriver driver) {
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

    private WebElement chooseFirstCategory() {
        List<WebElement> rows = getRowsFromTable();
        WebElement firstRow = rows.get(0);
        return firstRow;
    }

    private WebElement chooseLastCategory() {
        List<WebElement> rows = getRowsFromTable();
        WebElement lastRow = rows.get(rows.size() - 1);
        return lastRow;
    }

    private WebElement chooseRandomCategory() {
        List<WebElement> rows = getRowsFromTable();
        WebElement randomRow = rows.get(Helper.getRandomInteger(rows.size()));
        return randomRow;
    }

    public void editFirstCategory() {
        WebElement firstRow = chooseFirstCategory();
        clickOnEditButton(firstRow);
        sendTextOnField(By.id("title"));
        clickOnSaveCategoryButton();
    }

    public void editLastCategory() {
        WebElement lastRow = chooseLastCategory();
        clickOnEditButton(lastRow);
        sendTextOnField(By.id("title"));
        clickOnSaveCategoryButton();

    }

    public void editRandomCategory() {
        WebElement randomRow = chooseRandomCategory();
        clickOnEditButton(randomRow);
        sendTextOnField(By.id("title"));
        clickOnSaveCategoryButton();
    }

    private void clickOnConfirmDeleteButton() {
        clickOnElement(By.xpath("//*[@id=\'categoryDeleteDialog\']/div/div/div[3]/button[2]"));
    }

    public void deleteFirstCategory() {
        WebElement firstRow = chooseFirstCategory();
        clickOnDeleteButton(firstRow);
        clickOnConfirmDeleteButton();
    }

    public void deleteLastCategory() {
        WebElement lastRow = chooseLastCategory();
        clickOnDeleteButton(lastRow);
        clickOnConfirmDeleteButton();
    }

    public void deleteRandomCategory() {
        WebElement randomRow = chooseRandomCategory();
        clickOnDeleteButton(randomRow);
        clickOnConfirmDeleteButton();
    }
}
