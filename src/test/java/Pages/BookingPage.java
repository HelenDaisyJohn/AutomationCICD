package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BookingPage {
	WebDriver driver=null;
//	Login to the portal
	By Login_Button1=By.xpath("(//button[normalize-space()='Log in'])[1]");
	By User_Name1=By.xpath("(//input[@id='Input_Username'])[1]");
	By Password1=By.xpath("(//input[@id='Input_Password'])[1]");
	By Login_BTN1=By.xpath("//button[@value='login']");
		
///	Navigate to VideoPlatform
	By Hamburger_Menu1=By.xpath("(//button[@type='button'])[2]");
		
//	select org
	By Select_Org_Dropdown1=By.xpath("(//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-fullWidth MuiInputBase-formControl MuiInputBase-sizeSmall css-niyuos'])[1]");
	By Select_Unit_Dropdown1=By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/ul/div/form[2]/div/div/div/div");
	
	
//	Select Booking
	By Select_Booking=By.xpath("//p[normalize-space()='Video Booking']");
		
//  Add a new Booking
	
	By Add_icon1=By.xpath("//button[@title='Add Video Booking']");
	By SourceName=By.xpath("(//div[@id='Source'])[1]");
	By selectSource=By.xpath("//li[@role='option'][1]");
	By ChannelName=By.xpath("//div[@id='Video Booking Channel']");
	By selectChannel=By.xpath("//li[@role='option'][1]");
	By StartTime=By.xpath("//button[@aria-label='Start Time']");
	By EndTime=By.xpath("//button[@aria-label='End Time']");
	By ChangeEndTime=By.xpath("//*[@id=\"add-new\"]/div/div/div/form/div[4]/div/div[2]/button");
	By SelectNextDate=By.xpath("//button[normalize-space()='19']");
	
	
	By ADD_Button1=By.xpath("(//button[normalize-space()='Add'])[1]");
	By Success_Message1=By.xpath("//div[@class='MuiAlert-message css-1pxa9xg-MuiAlert-message']");
	
//	Tooltip
	By Tool_Tip1=By.xpath("(//button[@title='Add Video Booking'])[1]");
	By Tool_Tip2=By.xpath("(//button[normalize-space()='Export'])[1]");
	By Tool_Tip3=By.xpath("(//button[@title='Column Settings'])[1]");
	
//	Confirmation element
	By confirmYes=By.xpath("(//button[contains(@type,'button')][normalize-space()='Yes'])[2]");
	
//	Search
	By Search1=By.xpath("//input[@type='search']");
	
//	Disable
	By menu=By.xpath("(//div[@role='menu'])[1]");
	By disable=By.xpath("//li[normalize-space()='Disable']");
	
//	Update
	By update=By.xpath("//li[normalize-space()='Edit']");
	By updateButton=By.xpath("(//button[normalize-space()='Update'])[1]");
	
//	Delete
	By delete=By.xpath("//li[normalize-space()='Delete']");
	

//	Login to the Portal
public BookingPage(WebDriver driver)
	{
		this.driver= driver;
	}


//	Login to the Portal
	public void Login_Button() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(Login_Button1).click();;
	}

	public void User_Name(String UserName) {
		driver.findElement(User_Name1).sendKeys(UserName);
		
	}
	public void Password(String Password) {
		driver.findElement(Password1).sendKeys(Password);
		
	}
	public void Login_BTN() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(Login_BTN1).click();
		System.out.println("Testcase 1 is Passed");
		System.out.println("Successfully Login to the Prism Portal");
	}

	
//Navigate to Video
	public void Hamburger_Menu() {
		driver.findElement(Hamburger_Menu1).click();
		
	}
	
// 	Select anyone org
	public void Select_Org_Dropdown(String OrgName) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(Select_Org_Dropdown1).click();
		Thread.sleep(3000);
		List<WebElement> allOptions= driver.findElements(By.xpath("(//li[@role='option'])"));
		for(WebElement option:allOptions)
		{
//			System.out.println(option.getText());
			if(option.getText().equals(OrgName))
			{
				option.click();
				break;
			}
		}
	}
	
//	Select anyone org assosiated unit
		public void Select_Unit_Dropdown(String UnitName) throws InterruptedException {
			Thread.sleep(3000);
			driver.findElement(Select_Unit_Dropdown1).click();
			List<WebElement> allOptions1= driver.findElements(By.xpath("(//li[@role='option'])"));
			for(WebElement option1:allOptions1)
			{
//				System.out.println(option1.getText());
				if(option1.getText().equals(UnitName))
				{
					option1.click();
					break;
				}
			}		
	}
		
		public void Select_Booking() throws InterruptedException {
			Thread.sleep(2000);
			driver.findElement(Select_Booking).click();
		
			}

//	Create a new Video Booking -Testcase 1
//		public void Add_Booking() {
//			// TODO Auto-generated method stub
//			
//		}
		public void Add_Booking() throws InterruptedException {
			Thread.sleep(3000);	
			driver.findElement(Add_icon1).click();
			driver.findElement(SourceName).click();
			driver.findElement(selectSource).click();
			Thread.sleep(2000);
			driver.findElement(ChannelName).click();
			driver.findElement(selectChannel).click();
			Thread.sleep(2000);
			driver.findElement(StartTime).click();
			Thread.sleep(2000);
			driver.findElement(EndTime).click();
			Thread.sleep(2000);
			driver.findElement(ChangeEndTime).click();
			driver.findElement(SelectNextDate).click();
			
			
			
			Thread.sleep(2000);
			
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0, 500);");
			
//			driver.findElement(Select_Angle1).click();
//			Thread.sleep(2000);
//			driver.findElement(Description1).sendKeys(Description);
//			Thread.sleep(1000);
//			driver.findElement(VendorBookingID1).sendKeys(VendorBookingID);
//			Thread.sleep(1000);
			driver.findElement(ADD_Button1).click();
			
		}
//		Getting Success/warning  message- Testcase 2
		public void Message() {
			WebElement message=driver.findElement(Success_Message1);
			String message1=message.getText();
			System.out.println("Message is:" +message1);
			Assert.assertEquals( message1, "Video Booking Successfully Added");
			System.out.println(" ");
		}
		
		
		//		Verify the icon of the plus icon tooltip is "Add Organization"
		public void Tool_Tip1() {
			String icon1=driver.findElement(Tool_Tip1).getAttribute("title");
			System.out.println("The name of the plus icon tool tip is: "  +icon1);
			System.out.println("");
		}
		public void Tool_Tip2() {
			String icon1=driver.findElement(Tool_Tip2).getAttribute("title");
			System.out.println("The name of the plus icon tool tip is: "  +icon1);
			System.out.println("");
		}
		public void Tool_Tip3() {
			String icon1=driver.findElement(Tool_Tip3).getAttribute("title");
			System.out.println("The name of the plus icon tool tip is: "  +icon1);
			System.out.println("");
		}
		public void DisplayInactiveBooking() {
			driver.findElement(By.xpath("//input[@name='gilad']")).click();
			System.out.println(" ");
			System.out.println("All the active/Inactive Bookings are visible");
			System.out.println(" ");
		}
		public void Search(String searchKeywordBooking) {
			driver.findElement(Search1).sendKeys(searchKeywordBooking);
			System.out.println("Search functionality is working fine");
			System.out.println("");
		}
		public void Disable() throws InterruptedException {
			Thread.sleep(1000);
			driver.findElement(menu).click();
			driver.findElement(disable).click();
			Thread.sleep(1000);
			driver.findElement(confirmYes).click();
			System.out.println("Disabled functionality is working fine");
			System.out.println(" ");
		}
//		getting Success/warning  message- Testcase 2
		public void DisabledMessage() {
			WebElement DisabledMessage=driver.findElement(Success_Message1);
			String DisabledMessage1=DisabledMessage.getText();
			System.out.println("Message is:" +DisabledMessage1);
			Assert.assertEquals( DisabledMessage1, "Video Booking Successfully Disabled");
			System.out.println("Disabled message is displayed properly");
			System.out.println(" ");
			
		}
//		public void UpdateBooking() throws InterruptedException {
//			Thread.sleep(2000);
//			driver.findElement(menu).click();
//			driver.findElement(update).click();
//			Thread.sleep(1000);
//			driver.findElement(Booking_ID1).sendKeys("111111");
//			driver.findElement(Booking_Name1).sendKeys("111111");
//			Thread.sleep(1000);
//			driver.findElement(updateButton).click();
//			System.out.println("Update functionality is working fine");
//			System.out.println(" ");
//			
//		}
		public void UpdatedMessage() {
			WebElement UpdatedMessage=driver.findElement(Success_Message1);
			String UpdatedMessage1=UpdatedMessage.getText();
			System.out.println("Message is:" +UpdatedMessage1);
			Assert.assertEquals( UpdatedMessage1, "Video Booking Successfully Updated");
			System.out.println("Update message is displayed properly");
			System.out.println(" ");
			
		}
		public void DeleteBooking() throws InterruptedException {
			Thread.sleep(2000);
			driver.findElement(menu).click();
			driver.findElement(delete).click();
			Thread.sleep(1000);
			driver.findElement(confirmYes).click();
			System.out.println("Delete functionality is working fine");
			System.out.println(" ");
			
		}
//		public void DeletedMessage() {
//			WebElement DeletedMessage=driver.findElement(Success_Message);
//			String DeletedMessage1=DeletedMessage.getText();
//			System.out.println("Message is:" +DeletedMessage1);
//			Assert.assertEquals( DeletedMessage1, "Video Booking Successfully Deleted");
//			System.out.println("Delete message is displayed properly");
//			System.out.println(" ");


		
			
		}
		

	
