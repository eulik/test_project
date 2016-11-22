package ru.olga.addressbook;

import org.testng.annotations.Test;

public class DeletionTestsGroup extends TestBase {

    
    @Test
    public void deletionTestsGroup() {

        gotoGroupPage();
        selectGroup();
        deleteSelectedGroups();
        returnToGroupPage();

    }


}
