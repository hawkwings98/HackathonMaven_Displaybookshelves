package Home;

import java.io.File;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import Drivers.DriverSetup;
import Drivers.FileIO;

/******* import Display_Books.DriverSetup; *******/

public class Implement {
	
	public static WebDriver driver;
	public static String userDir = System.getProperty("user.dir");
	static Properties prop;

	public Implement() {

	}

	public Implement(WebDriver driver) {
		this.driver = driver;
	}

	public void createDriver() {
		driver = DriverSetup.getDriver();

	}

	public static void closePopup() {

		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		WebElement popup = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-gaaction='popup.auth.close']")));
		popup.click();

	}

	public static void openBookShelves() {
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div[3]/a[4]")).click();
		Implement.closePopup();
	}

	public static void storageType() throws InterruptedException {
		WebElement type = driver.findElement(By.xpath("//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[2]/div[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(type);
		action.build().perform();
		WebElement open = driver.findElement(By.id("filters_storage_type_Open"));
		open.click();

	}

	public static void slider() throws InterruptedException {
		WebElement price = driver.findElement(By.xpath("//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[1]/div[1]"));

		Actions action = new Actions(driver);
		action.clickAndHold(price);
		Thread.sleep(2000);
		action.build().perform();
		Thread.sleep(2000);

		WebElement sliderA = driver.findElement(By.xpath(
				"//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[1]/div[2]/div/div/ul/li[1]/div/div[2]/div[2]/div/div[1]/div"));
		Actions move = new Actions(driver);
		move.dragAndDropBy(sliderA, 0, 0).click();
		move.build().perform();

		WebElement sliderB = driver.findElement(By.xpath(
				"//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[1]/div[2]/div/div/ul/li[1]/div/div[2]/div[2]/div/div[2]/div"));

		move.dragAndDropBy(sliderB, -204, 0).click();
		move.build().perform();
		Thread.sleep(2000);

	}

	public static void excludeCheckbox() throws InterruptedException {
		driver.findElement(By.id("filters_availability_In_Stock_Only")).click();
		Thread.sleep(2000);
	}

	public static void print() {

		List<WebElement> shtitles = driver.findElements(By.xpath("//span[@class='name']"));
		List<WebElement> shprices = driver.findElements(By.xpath("//div[@class='price-number']"));

		String[] name = new String[3];
		String[] price = new String[3];

		for (int i = 0; i < 3; i++) {
			name[i] = shtitles.get(i).getText();
			price[i] = shprices.get(i).getText();
			System.out.print(shtitles.get(i).getText() + "  ");
			System.out.println(shprices.get(i).getText());
			FileIO.output1(name, price);
			System.out.println("----------------------------------------------------------");
		}

	}

	public static void collections() {

		driver.findElement(By.xpath("//span[contains(@class,'topnav_itemname') and contains(text(),'Collections')]"))
				.click();
		try {

			Thread.sleep(500);

		} catch (Exception e) {

			e.printStackTrace();

		}

		WebElement t1 = driver.findElement(By.xpath("//a[contains(text(),'Being At Home')]"));
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(t1));
		Actions s = new Actions(driver);
		s.moveToElement(t1).build().perform();
	}

	public static void Beingprint() throws Exception {
		List<WebElement> subMenuItems = driver
		 .findElements(By.xpath("//a[contains(text(),'Being At Home')]/parent::*/following-sibling::ul/li"));

		String prodname[] = new String[20];
		for (int i = 0; i < 13; i++) {
			prodname[i] = subMenuItems.get(i).getText();
			System.out.println(subMenuItems.get(i).getText());
			FileIO.output(prodname);
		}
	}

	public static void giftcards() throws InterruptedException {
		WebElement giftcard = driver.findElement(By.linkText("Gift Cards"));
		giftcard.click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,850)", "");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/main/section/section[1]/ul/li[3]")).click();
		Thread.sleep(2000);
		
		/******* Customize Form *******/
		driver.findElement(
				By.xpath("//*[@id=\"app-container\"]/div/main/section/section[2]/div/section[2]/div[1]/button[1]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//*[@id=\"app-container\"]/div/main/section/section[2]/div/section[2]/div[1]/button[2]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//*[@id=\"app-container\"]/div/main/section/section[2]/div/section[2]/div[1]/button[3]"))
				.click();
		Thread.sleep(2000);

		WebElement value1 = driver.findElement(By.id("ip_2251506436"));
		value1.sendKeys("2,00,000");
		Thread.sleep(2000);
		value1.clear();
		value1.sendKeys("300");
		Thread.sleep(2000);
		value1.clear();
		value1.sendKeys("5,00,000");
		Thread.sleep(2000);

		Select month = new Select(driver.findElement(
				By.xpath("//*[@id=\"app-container\"]/div/main/section/section[2]/div/section[2]/div[4]/select[1]")));
		Thread.sleep(2000);
		month.selectByVisibleText("May (2021)");
		Thread.sleep(2000);

		Select date = new Select(driver.findElement(
				By.xpath("//*[@id=\"app-container\"]/div/main/section/section[2]/div/section[2]/div[4]/select[2]")));
		Thread.sleep(2000);
		date.selectByVisibleText("24");
		Thread.sleep(5000);

		driver.findElement(
				By.xpath("//*[@id=\"app-container\"]/div/main/section/section[2]/div/section[2]/div[1]/button[1]"))
				.click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/main/section/section[2]/div/section[2]/button"))
				.click();
		Thread.sleep(2000);
		
		/******* Recipients form *******/
		
		driver.findElement(By.id("ip_4036288348")).sendKeys("osp");
		WebElement email = driver.findElement(By.id("ip_137656023"));
		email.sendKeys("hackathongmail.com");
		driver.findElement(By.id("ip_1082986083")).sendKeys("hackathon");
		driver.findElement(By.id("ip_4081352456")).sendKeys("project@gmail.com");
		driver.findElement(By.id("ip_2121573464")).sendKeys("1234567890");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
	}

	public static void screenshot() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		try {
			File source = ts.getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(source, new File(userDir + "\\Screenshots\\Screen.png"));
		} catch (Exception e) {
			System.out.println("The Screenshot is taken");

		}
	}
	
}

