package ru.olga.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.olga.addressbook.appmanager.ApplicationManager;

/**
 * Created by Olga on 22.11.2016.
 */
public class TestBase {

    protected final ApplicationManager appMan = new ApplicationManager();

    @BeforeMethod
    public void setUp() throws Exception {
        appMan.init();

    }

    @AfterMethod
    public void tearDown() {
        appMan.stop();
    }

}
