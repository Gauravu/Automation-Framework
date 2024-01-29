package testcases;

import Base.BaseTest;
import ExactaPortal_Pages.homePage;
import ExactaPortal_Pages.Utilities;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Verify_PutAwayOrder_Imported_Successfully extends BaseTest

{
@Test(priority= 0)
	public void putawayorder_import () throws IOException {
		
    Utilities utl = PageFactory.initElements(driver, Utilities.class);
    homePage homePage = PageFactory.initElements(driver, homePage.class);
    homePage.clickUtilitiesIcon();
    try {
		utl.testPutawayImport();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	@Test(priority = 1)
    public void Verify_PutawayOrder_Import_In_Interface_Import_Transactions() throws IOException {

        Utilities utl = PageFactory.initElements(driver, Utilities.class);
        homePage homePage = PageFactory.initElements(driver, homePage.class);
        homePage.clickUtilitiesIcon();
        utl.clickIntefaceImportTransactions();
        utl.enterputawayorderinImportTransactions();
        utl.clickSearchimporttrans();
        utl.clickRollbuttonSymbol();
        utl.getXmlText();
    }
    
    @Test(priority = 2)
    public void Verify_PutAwayOrder_Import_In_View_All_PutAwayOrders() throws IOException, InterruptedException {
        Utilities utl = PageFactory.initElements(driver, Utilities.class);
      //  utl.clickInventoryMentainance();
        utl.clickInbound();
        utl.clickViewAllPutAwayOrders();
        utl.enterPutAwayOrderNameinViewAllPutAwayOrders();
        utl.verifyPutAwayOrderisdisplayedinViewAllPutawayOrders();
    

    }
}

