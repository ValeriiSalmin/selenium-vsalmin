package ui_tests.lesson_8;

import core.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RozetkaDefaultPage;
import pages.RozetkaPrivateCabinetPage;

/**
 * Created by Валерий on 05.08.2015.
 */
public class RozetkaSocialNetworkAutorTest extends TestBase{

    @Test
    public void RozetkaSocialNetworkAutorTest(){
        String email = "clickua8@gmail.com";
        String password = "";
        String profile="Valeriy Salmin";

        RozetkaDefaultPage rozetkaDefaultPage = new RozetkaDefaultPage(webDriver);
        rozetkaDefaultPage.enterToPrivateCabinet();
        RozetkaPrivateCabinetPage rozetkaPrivateCabinetPage = new RozetkaPrivateCabinetPage(webDriver);
        rozetkaPrivateCabinetPage.fillCredentials(email,password);
        Assert.assertTrue(rozetkaPrivateCabinetPage.findElement().getText().equals(profile));

    }
}