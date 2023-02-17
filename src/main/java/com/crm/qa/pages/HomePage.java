package com.crm.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;


public class HomePage extends TestBase{


	

		// @FindBy(css = "td.headertext:nth-child(1)")
		@FindBy(xpath = "//td[@class='headertext'][1]")
		public WebElement userNameLabel;

		@FindBy(css = "a[title='Contacts']")
		WebElement contactsLink;

		@FindBy(css = "a[title=\"Deals\"]")
		WebElement dealsLink;

		@FindBy(css = " a[title=\"Tasks\"]")
		WebElement tasksLink;

//		@FindBy(css = "a[title='New Contact']")
		@FindBy(xpath="//a[contains(text(),'New Contact')]")
		public WebElement newContactsLink;

		// Initializing Page Objects
		public HomePage() {
			PageFactory.initElements(driver, this);
		}

		public String verifyHomePageTitle() {
			return driver.getTitle();
		}

		public void hovorOnConatctsLink() {
			Actions action = new Actions(driver);
			action.moveToElement(contactsLink).perform();
		}

		public ContactsPage clickOnConatctsLink() {

			contactsLink.click();
			return new ContactsPage();
		}

		public DealsPage clickOnDealsLink() {

			dealsLink.click();
			return new DealsPage();
		}

		public TasksPage clickOnTasksLink() {
			tasksLink.click();
			return new TasksPage();
		}

		public boolean verifyCorrectUserName() {
			return userNameLabel.isDisplayed();
		}

		public void clickOnNewContactLinks() {
			Actions action = new Actions(driver);
			action.moveToElement(contactsLink).build().perform();
			newContactsLink.click();

		}

	}


