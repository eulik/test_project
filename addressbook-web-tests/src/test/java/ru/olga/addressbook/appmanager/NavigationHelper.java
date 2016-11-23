package ru.olga.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

/**
 * Created by Olga on 22.11.2016.
 */
public class NavigationHelper {
    private FirefoxDriver wd;
    private WebDriverWait wait;

    public NavigationHelper(FirefoxDriver wd) {
        this.wd = wd;
        wait = new WebDriverWait(this.wd, 10);
    }

    public void gotoGroupPage() {
        //WebElement xxx = wait.until(presenceOfElementLocated(By.linkText("group page")))
        //new WebDriverWait(wd, 10).until(ExpectedConditions.elementToBeClickable(By.linkText("groups")));
        new WebDriverWait(wd, 10).until (elementToBeClickable(By.linkText("groups")));
        wd.findElement(By.linkText("groups")).click();
    }
}
