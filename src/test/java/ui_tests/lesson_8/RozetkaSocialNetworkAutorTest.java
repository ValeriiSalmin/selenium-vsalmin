package ui_tests.lesson_8;

import core.TestBase;
import pages.RozetkaDefaultPage;
import pages.RozetkaPrivateCabinetPage;

/**
 * Created by Валерий on 05.08.2015.
 */
public class RozetkaSocialNetworkAutorTest extends TestBase{

    RozetkaDefaultPage rozetkaDefaultPage = new RozetkaDefaultPage(webDriver);
    rozetkaDefaultPage.enterToPrivateCabinet();
    RozetkaPrivateCabinetPage rozetkaPrivateCabinetPage = new RozetkaPrivateCabinetPage(webDriver);




}