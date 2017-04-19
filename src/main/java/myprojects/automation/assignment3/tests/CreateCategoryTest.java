package myprojects.automation.assignment3.tests;

import myprojects.automation.assignment3.BaseScript;
import myprojects.automation.assignment3.GeneralActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateCategoryTest extends BaseScript {
    private static String login = "webinar.test@gmail.com";
    private static String password = "Xcg7299bnSmMuRLp9ITw";
    private static String categoryName = "testCategory";

    public static void main(String[] args) throws InterruptedException {
        // TODO prepare driver object
         WebDriver driver = getConfiguredDriver();

        GeneralActions generalAct = new GeneralActions(driver);

        generalAct.login(login, password);

        generalAct.createCategory(categoryName);

        //generalAct.createJsCategory();

        // check that new category appears in Categories table

        driver.quit();
    }
}
