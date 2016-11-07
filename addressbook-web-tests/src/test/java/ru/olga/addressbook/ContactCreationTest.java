package ru.olga.addressbook;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class ContactCreationTest {
    FirefoxDriver wd;
    WebDriverWait wait;
    
    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "C:\\Tools\\geckodriver.exe");
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
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

    @Test
    public void contactCreationTest() {


        gotoAddContanct();
        fillPersonalData("Thomas", "none", "Burkhard", "none", "1911");
        fillAddressData("somewhere over the rainbow/44b", "00954111111", "thomas@test.com");
        clickSubmit();
    }

    private void clickSubmit() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
        wd.findElement(By.xpath("//div/div[4]/div/i/a[2]")).click();
    }

    private void fillAddressData(String street, String phoneNumber, String emailAdress) {
        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(street);

        wd.findElement(By.name("home")).click();
        wd.findElement(By.name("home")).clear();
        wd.findElement(By.name("home")).sendKeys(phoneNumber);
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(emailAdress);
    }

    private void fillPersonalData(String firstname, String middlename, String lastname, String nickname, String byear) {
        wait.until(presenceOfElementLocated(By.name("firstname")));
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(firstname);
        wd.findElement(By.name("middlename")).click();
        wd.findElement(By.name("middlename")).clear();
        wd.findElement(By.name("middlename")).sendKeys(middlename);
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(lastname);
        wd.findElement(By.name("nickname")).click();
        wd.findElement(By.name("nickname")).clear();
        wd.findElement(By.name("nickname")).sendKeys(nickname);

        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[13]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[13]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[12]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[12]")).click();
        }

        wd.findElement(By.name("byear")).click();
        wd.findElement(By.name("byear")).clear();
        wd.findElement(By.name("byear")).sendKeys(byear);
    }

    private void gotoAddContanct() {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("add new")));
        wd.findElement(By.linkText("add new")).click();
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
