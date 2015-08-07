package ui_tests.final_test;

import core.TestBase;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.*;

/**
 * Created by Валерий on 06.08.2015.
 */
public class FinalTest extends TestBase{
        String findProduct1 = "Apple MacBook Pro Retina 13\" (Z0QP000X6)";
        String findProduct2 = "Apple MacBook Pro Retina 15\" (MGXA2UA/A)";
        String typeOfSorting = "от дорогих к дешевым";


        @Test
        public void finalTest() throws InterruptedException {
                Reporter.log("INFO: Start FinalTest");
                Reporter.log("INFO: Open Rozetka page");
                RozetkaDefaultPage rozetkaDefaultPage = new RozetkaDefaultPage(webDriver);
                Reporter.log("INFO: Go to NoteBooks and Computers");
                rozetkaDefaultPage.goToNoteBooksAndOthers();
                RozetkaNoteBooksAndOthersPage rozetkaNoteBooksAndOthersPage = new RozetkaNoteBooksAndOthersPage(webDriver);
                Assert.assertEquals(rozetkaNoteBooksAndOthersPage.getNumberUnderNoteBooks(), 6);
                Reporter.log("INFO: Go to NoteBooks");
                rozetkaNoteBooksAndOthersPage.goToAllNoteBooks();
                RozetkaNoteBooksPage rozetkaNoteBooksPage = new RozetkaNoteBooksPage(webDriver);
                Assert.assertEquals(rozetkaNoteBooksPage.getNumberNotesProducers(), 9);
                Reporter.log("INFO: Select Apple producer");
                rozetkaNoteBooksPage.selectAppleProducer();
                RozetkaAppleNoteBooksPage rozetkaAppleNoteBooksPage = new RozetkaAppleNoteBooksPage(webDriver, wait);
                Reporter.log("INFO: Sort results");
                rozetkaAppleNoteBooksPage.setSorting(typeOfSorting);
                Assert.assertTrue(rozetkaAppleNoteBooksPage.findProduct(findProduct1));
                Reporter.log("INFO: Add to comparison list");
                rozetkaAppleNoteBooksPage.addToCompare(findProduct1);
                Assert.assertTrue(rozetkaAppleNoteBooksPage.checkProductInComparisonList(findProduct1));
                Assert.assertTrue(rozetkaAppleNoteBooksPage.findProduct(findProduct2));
                Reporter.log("INFO: Add to comparison list");
                rozetkaAppleNoteBooksPage.addToCompare(findProduct2);
                Assert.assertTrue(rozetkaAppleNoteBooksPage.checkProductsInComparisonList(findProduct1, findProduct2));
                Reporter.log("INFO: Compare products");
                rozetkaAppleNoteBooksPage.clickToCompare();
                RozetkaNoteBooksComparisonPage rozetkaComparisonPage = new RozetkaNoteBooksComparisonPage(webDriver);
                Assert.assertTrue(rozetkaComparisonPage.getTitle().getText().contains("Сравниваем ноутбуки"));
                Assert.assertTrue(rozetkaComparisonPage.getProduct(findProduct1) && rozetkaComparisonPage.getProduct(findProduct2));
                Reporter.log("INFO: Finish FinalTest");
        }
}
