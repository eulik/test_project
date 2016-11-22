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

public class GroupCreationTests01 extends TestBase {

    @Test
    public void group_creation_tests01() {


        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("group", "test", "test 2"));
        submitGroupCreation();
        returnToGroupPage();
    }

}
