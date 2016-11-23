package ru.olga.addressbook.tests;

import org.testng.annotations.Test;
import ru.olga.addressbook.model.GroupData;

public class GroupCreationTests01 extends TestBase {

    @Test
    public void group_creation_tests01() {


        appMan.getNavigationHelper().gotoGroupPage();
        appMan.getGroupHelper().initGroupCreation();
        appMan.getGroupHelper().fillGroupForm(new GroupData("group", "test", "test 2"));
        appMan.getGroupHelper().submitGroupCreation();
        appMan.getGroupHelper().returnToGroupPage();
    }

}
