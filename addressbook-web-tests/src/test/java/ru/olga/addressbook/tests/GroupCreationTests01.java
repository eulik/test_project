package ru.olga.addressbook.tests;

import org.testng.annotations.Test;
import ru.olga.addressbook.model.GroupData;

public class GroupCreationTests01 extends TestBase {

    @Test
    public void group_creation_tests01() {


        appMan.gotoGroupPage();
        appMan.initGroupCreation();
        appMan.fillGroupForm(new GroupData("group", "test", "test 2"));
        appMan.submitGroupCreation();
        appMan.returnToGroupPage();
    }

}
