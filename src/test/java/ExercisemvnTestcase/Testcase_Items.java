package ExercisemvnTestcase;

import org.testng.annotations.Test;

import ExerciseBaseCommon.BaseTest;

public class Testcase_Items extends BaseTest {

	@Test (priority = 1)
	public void products_page () {
		log = report.createTest("Verify Item Name and Price");
		log_in();
		mymethod.GetTextFormatEqual(log, driver, itemname, "item_0_title_link", item0name);
		mymethod.GetTextFormatEqual(log, driver, itemdesc, "item_0_title_link", item0desc);
		mymethod.waitformatclickable(wait, driver, itemlink, "item_0_title_link");
		mymethod.ClickFormat(log, driver, itemlink, "item_0_title_link");
		mymethod.GetTextEqual(log, driver, itemdetail_Title, item0name);
		mymethod.GetTextEqual(log, driver, itemdetail_desc, item0desc);
		mymethod.sAssertEqual_replace(log, softAssert, driver, itemdetail_price, "$9.99");
		
	}
}
