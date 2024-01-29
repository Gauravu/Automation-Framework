package testcases;

import Base.BaseTest;
import ExactaPortal_Pages.homePage;
import ExactaPortal_Pages.Utilities;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Verify_CycleCountOrder_Imported_Successfully extends BaseTest {
	
	
	@Test(priority= 0)
	public void CycleCountOrder_import () throws IOException {
		
    Utilities utl = PageFactory.initElements(driver, Utilities.class);
    homePage homePage = PageFactory.initElements(driver, homePage.class);
    homePage.clickUtilitiesIcon();
    try {
		utl.testCycleCountImport();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	@Test(priority = 1)
    public void Verify_CycleCountOrder_Import_In_Interface_Import_Transactions() throws IOException {

        Utilities utl = PageFactory.initElements(driver, Utilities.class);
        homePage homePage = PageFactory.initElements(driver, homePage.class);
        homePage.clickUtilitiesIcon();
        utl.clickIntefaceImportTransactions();
        utl.entercyclecountorderinImportTransactions();
        utl.clickSearchimporttrans();
        utl.clickRollbuttonSymbol();
        utl.getXmlText();
    }
    
    @Test(priority = 2)
    public void Verify_CycleCountOrder_In_View_All_CycleCountOrders() throws IOException, InterruptedException {
        Utilities utl = PageFactory.initElements(driver, Utilities.class);
        utl.clickInventoryMaintenance();
        utl.clickViewAllCycleCountOrders();
        utl.enterCycleCountOrderNameinViewAllCycleCounts();
        utl.verifyCycleCountOrderisdisplayedinViewAllCycleCountOrders();
    

    }
}
