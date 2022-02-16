package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.AddCategoryPage;
import util.BrowserFactory;

public class AllTests {
	
	WebDriver driver;
	

	String Category=null;

		
//	Test 1: Validate a user is able to add a category and once the category is added it should display.	
		
//		@Test(priority=1)
		@Parameters({"Category"})
		public void validUserShouldBeAbleToAddCategory(String Category) throws InterruptedException {
			
			driver = BrowserFactory.init();
			AddCategoryPage add = PageFactory.initElements(driver, AddCategoryPage.class);
			
			
			add.addCategory(Category);
			add.clickAddCategoryButton();
			Thread.sleep(3000);
			
			add.getEnteredCategory(Category);
			
			BrowserFactory.teardown();
		}
		
//	Test 2: Validate a user is not able to add a duplicated category. 
//	If it does then the following message will display: "The category you want to add already exists: <duplicated category name>."
		
		@Test(priority=2)
		@Parameters({"Category"})
		public void validUserShouldBeAbleToAddDuplicateCategory(String Category) throws InterruptedException {
			
			driver = BrowserFactory.init();
			AddCategoryPage duplic = PageFactory.initElements(driver, AddCategoryPage.class);
			
			duplic.addCategory(Category);
			duplic.clickAddCategoryButton();
			duplic.addDuplicateCategory(Category);
			duplic.clickAddCategoryButton();
			Thread.sleep(3000);
			duplic.clickNevermindButton();
			
			BrowserFactory.teardown();
		}
		
//		@Test(priority=3)
//		@Parameters({"mm1","mm2","mm3","mm4","mm5","mm6","mm7","mm8","mm9","mm10","mm11","mm12"})
//		public void validUserShouldBeAbleToVlidateMonthDropDownList(String Mon1,String Mon2,String Mon3,String Mon4,String Mon5,String Mon6,String Mon7,String Mon8,String Mon9,String Mon10,String Mon11,String Mon12) throws InterruptedException  {
//			
//			driver = BrowserFactory.init();
//			
//			AddCategoryPage ValMon = PageFactory.initElements(driver, AddCategoryPage.class);
//
//			ValMon.insertCategory(Mon1);
//			ValMon.insertCategory(Mon2);
//			ValMon.insertCategory(Mon3);
//			ValMon.insertCategory(Mon4);
//			ValMon.insertCategory(Mon5);
//			ValMon.insertCategory(Mon6);
//			ValMon.insertCategory(Mon7);
//			ValMon.insertCategory(Mon8);
//			ValMon.insertCategory(Mon9);
//			ValMon.insertCategory(Mon10);
//			ValMon.insertCategory(Mon11);
//			ValMon.insertCategory(Mon12);
//			ValMon.validateMonthDropDownList();
//			
//			BrowserFactory.teardown();
//		}
//
}
