package com.crm.qa.pages;



	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.Select;

	import com.crm.qa.base.TestBase;
	public class ContactsPage extends TestBase{


		@FindBy(xpath = "(//form[@id=\"vContactsForm\"]/table/tbody/tr/td/table/tbody/tr/td)[1]")
		WebElement contactsLabel;

		@FindBy(css = "input[onClick=\"checkAll(this);\"]")
		WebElement clickNameCheckBx;

		@FindBy(id = "first_name")
		WebElement firstName;

		@FindBy(id = "surname")
		WebElement lastName;

		@FindBy(name = "client_lookup")
		WebElement company_element;
		
		@FindBy(css= "a[title='New Contact']")
		WebElement newContactLink;

		@FindBy(xpath = "//input[@type= 'submit' and @value = 'Save']")
		WebElement saveBtn;

		public ContactsPage() {
			PageFactory.initElements(driver, this);
		}

		public boolean verifyContactsLabel() {
			return contactsLabel.isDisplayed();
		}

		public void selectContactsByName(String name) {
			// driver.findElement(By.xpath("//a[text()='" + name + "']")).click();
			driver.findElement(By.xpath("//a[text()='" + name + "']//parent::td[@class='datalistrow']"
					+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
		}

		public void createNewContact(String title, String fname, String lname, String cname) {
			//newContactLink.click();
			Select select = new Select(driver.findElement(By.name("title")));
			select.selectByVisibleText(title);
			firstName.sendKeys(fname);
			lastName.sendKeys(lname);
			company_element.sendKeys(cname);
			saveBtn.click();
		}

	}


