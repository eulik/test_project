package ru.olga.addressbook.tests;

import org.testng.annotations.Test;

public class DeletionTestsGroup extends TestBase {

    
    @Test
    public void deletionTestsGroup() {

        appMan.getNavigationHelper().gotoGroupPage();
        appMan.getGroupHelper().selectGroup();
        appMan.getGroupHelper().deleteSelectedGroups();
        appMan.getGroupHelper().returnToGroupPage();

    }


}
