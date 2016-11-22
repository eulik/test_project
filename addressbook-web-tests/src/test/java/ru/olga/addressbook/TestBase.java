package ru.olga.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * Created by Olga on 22.11.2016.
 */
public class TestBase {
    FirefoxDriver wd;
    WebDriverWait wait;

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "C:\\Tools\\geckodriver.exe");
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);

        wait = new WebDriverWait(wd, 10);
        wd.get("http://localhost/addressbook/");
        login("secret", "admin");

    }

    private void login(String password, String username) {
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(username);
        wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }

    protected void returnToGroupPage() {
        wd.findElement(By.linkText("group page")).click();
    }

    protected void submitGroupCreation() {
        wd.findElement(By.name("submit")).click();
    }

    protected void initGroupCreation() {
        wd.findElement(By.name("new")).click();
    }

    protected void fillGroupForm(GroupData groupData){
        //new WebDriverWait(wd, 10).until(ExpectedConditions.elementToBeClickable(By.name("group_name")));
        wait.until(presenceOfElementLocated(By.name("group_name")));
        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
        wd.findElement(By.name("group_header")).click();
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
        wd.findElement(By.xpath("//div[@id='content']/form")).click();
        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    }

    protected void gotoGroupPage() {
        //WebElement xxx = wait.until(presenceOfElementLocated(By.linkText("group page")))
        //new WebDriverWait(wd, 10).until(ExpectedConditions.elementToBeClickable(By.linkText("groups")));
        wait.until (presenceOfElementLocated(By.linkText("groups")));
        wd.findElement(By.linkText("groups")).click();
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }

    protected void deleteSelectedGroups() {
        wait.until (elementToBeClickable (By.name("delete")));
        wd.findElement(By.name("delete")).click();
        
    }

    protected void selectGroup() {
        wd.findElement(By.name("selected[]")).click();
    }
}
