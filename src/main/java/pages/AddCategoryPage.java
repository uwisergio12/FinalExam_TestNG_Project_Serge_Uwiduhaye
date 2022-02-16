package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddCategoryPage extends BasePage {

	
	WebDriver driver;
	
	
	public AddCategoryPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.CSS, using = "input[name='categorydata']") WebElement Add_Category_Element;
	@FindBy(how = How.CSS, using = "input[value='Add category']") WebElement Add_Category_Button_Element;
	@FindBy(how = How.CSS, using = "div.controls>:nth-last-child(3)") WebElement Duplicate_Category_Element;
	@FindBy(how = How.LINK_TEXT, using = "Nevermind") WebElement Nevermind_Button_Element;
	@FindBy(how = How.CSS, using = "select[name='due_month']") WebElement Month_Element;
	@FindBy(how = How.CSS, using = "body > div.controls") WebElement Added_Category_Element;
	
	String enteredCategory;

//	public String getEnteredCategory() {
//		return enteredCategory;
//	}

	public void addCategory(String Category) throws InterruptedException {
		enteredCategory = Category + generateRandomNum(999);
		Add_Category_Element.sendKeys(enteredCategory);
		Thread.sleep(3000);
	}

	public void clickAddCategoryButton() throws InterruptedException {
		Add_Category_Button_Element.click();
		Thread.sleep(3000);
		
	}
	
	public void getEnteredCategory(String category) {
		Added_Category_Element.getText();
		assert Added_Category_Element.isDisplayed();
		System.out.println("Categoty is displayed!!!");
		
		
	}

	public void addDuplicateCategory(String Category) throws InterruptedException {
		
		String duplicateCategory = Duplicate_Category_Element.getText();
		System.out.println("Added category is " + duplicateCategory);
		Add_Category_Element.sendKeys(enteredCategory);
		Assert.assertEquals(duplicateCategory, enteredCategory, "Entered name does not exist!!");
		
		Thread.sleep(3000);
		System.out.println("The category you want to add already exists:" + enteredCategory);
		
	}
	


	public void clickNevermindButton() throws InterruptedException {
		Nevermind_Button_Element.click();

		Thread.sleep(3000);
	}
	
	public void validateMonthDropDownList() {
		Select sel = new Select(Month_Element);
		
		List<String> Actualmonth= new ArrayList<String>();
		
		for(WebElement we : sel.getOptions())
			Actualmonth.add(we.getText());
		
		List<String> Expectedmonth= new ArrayList<String>();
		
		Expectedmonth.add("None");
		Expectedmonth.add("Jan");
		Expectedmonth.add("Feb");
		Expectedmonth.add("Mar");
		Expectedmonth.add("Apr");
		Expectedmonth.add("May");
		Expectedmonth.add("Jun");
		Expectedmonth.add("Jul");
		Expectedmonth.add("Aug");
		Expectedmonth.add("Sep");
		Expectedmonth.add("Oct");
		Expectedmonth.add("Nov");
		Expectedmonth.add("Dec");
		
		for(int i=0;i<Actualmonth.size();i++)
		{
			System.out.println("Actual month:" + Actualmonth.get(i)+" , Expectedmonth:" + Expectedmonth.get(i));
			Assert.assertTrue(Actualmonth.get(i).equals(Expectedmonth.get(i)));
			
		}
		
	}
	
	public void insertCategory(String month) throws InterruptedException {
		selectFromDropdown(Month_Element, month);
		Thread.sleep(3000);
	}
		
}

