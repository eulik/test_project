package ru.olga.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.olga.addressbook.model.GroupData;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * Created by Olga on 22.11.2016.
 */
public class GroupHelper {
    private FirefoxDriver wd;
    private WebDriverWait wait;

    public GroupHelper(FirefoxDriver wd) {
        this.wd=wd;
        wait = new WebDriverWait(this.wd, 10);
    }

    public void returnToGroupPage() {
        wd.findElement(By.linkText("group page")).click();
    }

    public void submitGroupCreation() {
        wd.findElement(By.name("submit")).click();
    }

    public void initGroupCreation() {
        wd.findElement(By.name("new")).click();
    }

    public void fillGroupForm(GroupData groupData){
        //new WebDriverWait(wd, 10).until(ExpectedConditions.elementToBeClickable(By.name("group_name")));
        wait.until(elementToBeClickable(By.name("group_name")));
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

    public void deleteSelectedGroups() {
        wait.until (elementToBeClickable (By.name("delete")));
        wd.findElement(By.name("delete")).click();

    }

    public void selectGroup() {
        wd.findElement(By.name("selected[]")).click();
    }
}
