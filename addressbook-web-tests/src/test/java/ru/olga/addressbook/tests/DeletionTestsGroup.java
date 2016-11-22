package ru.olga.addressbook.tests;

import org.testng.annotations.Test;

public class DeletionTestsGroup extends TestBase {

    
    @Test
    public void deletionTestsGroup() {

        appMan.gotoGroupPage();
        appMan.selectGroup();
        appMan.deleteSelectedGroups();
        appMan.returnToGroupPage();

    }


}
