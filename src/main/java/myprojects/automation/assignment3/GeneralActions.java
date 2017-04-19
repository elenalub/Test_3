package myprojects.automation.assignment3;

import myprojects.automation.assignment3.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Contains main script actions that may be used in scripts.
 */
public class GeneralActions {
    private WebDriver driver;
    private WebDriverWait wait;
    private By catalogueLink = By.cssSelector("#subtab-AdminCatalog");
    private By categoriesLink = By.cssSelector("#subtab-AdminCategories");

    public GeneralActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

     /* Logs in to Admin Panel.
      @param login
     @param password*/

    public void login(String login, String password) throws UnsupportedOperationException{
        // TODO implement logging in to Admin Panel
        driver.navigate().to(Properties.getBaseAdminUrl());
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");

        WebElement emailInput = driver.findElement(By.cssSelector("#email"));
        emailInput.sendKeys("webinar.test@gmail.com");

        WebElement passwordInput = driver.findElement(By.cssSelector("#passwd"));
        passwordInput.sendKeys("Xcg7299bnSmMuRLp9ITw");

        WebElement submitButton = driver.findElement(By.cssSelector("[name='submitLogin']"));
        submitButton.click();

    }

    /**
     * Adds new category in Admin Panel.
     * @param categoryName
     */
    public void createCategory(String categoryName) throws UnsupportedOperationException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(catalogueLink));
        WebElement catalogLink = driver.findElement(this.catalogueLink);
        WebElement categoriesLink = driver.findElement(this.categoriesLink);
        Actions actions = new Actions(driver);
        actions.moveToElement(catalogLink)
                .moveToElement(categoriesLink)
                .click().build().perform();
    }

    public void createJsCategory(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(catalogueLink));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        WebElement categoriesLink = driver.findElement(this.categoriesLink);
        boolean scrolResult = (boolean)executor.executeScript(
                "var scrollBefore = $(window).scrollTop();" +
                        "window.scrollTo(scrollBefore, document.body.scrollHeight):"+
                        "return $(window).scrollTop() > scrollBefore;");
    }

    /**
     * Waits until page loader disappears from the page
     */
    public void waitForContentLoad() {
        // TODO implement generic method to wait until page content is loaded

        // wait.until(...);
        // ...
    }

}
