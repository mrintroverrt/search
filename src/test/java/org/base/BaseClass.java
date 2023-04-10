package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public static void LaunchBrowser() { // To Manage The WebDrivers
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	public static void windowMaximize() { // To Maximize the browser tab
		driver.manage().window().maximize();

	}

	public static void LaunchURl(String url) { // To Launch The URL in the browser
		driver.get(url);

	}

	public static String pagetitle() { // To Get the Page Title
		String title = driver.getTitle();
		return title;

	}

	public static String pageurl() { // To Get the PageUrl
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;

	}

	public static void passText(String txt, WebElement ele) { // This Method you can send the Keys to elements
		ele.sendKeys(txt);
	}

	public static void closeEntireBrowser() { // To close the browser
		driver.quit();

	}

	public static void clickBtn(WebElement ele) { // To Click the WebElement
		ele.click();

	}

	public static void screenshort(String imgName) throws IOException { // To take screenshot and save it
		TakesScreenshot tk = (TakesScreenshot) driver;
		File image = tk.getScreenshotAs(OutputType.FILE);
		File f = new File("location+imgName.png");
		FileUtils.copyFile(image, f);

	}

	public static Actions a; // This action class used for perform the actions

	public static void moverTheCursor(WebElement tarElement) { // To Move the cursor to target element
		a = new Actions(driver);
		a.moveToElement(tarElement).perform();

	}

	public static void dragDrop(WebElement dragWebElement, WebElement dropElement) { // To Drag and Drop the WebElement
		a = new Actions(driver);
		a.dragAndDrop(dragWebElement, dropElement).perform();

	}

	public static JavascriptExecutor js; // This JavaSriptExcutor use to perform JS type sites

	public static void scrollThepage(WebElement tarElement) { // To Scroll the web page
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", tarElement);

	}

	public static void scroll(WebElement element) { // To scroll the web page
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);

	}

	public static void exelRead(String sheetName, int rowNum, int cellNum) throws IOException { // To Read the xlxs
																								// Files
		File f = new File("excellocation.xlxs");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet mySheet = wb.getSheet(sheetName);
		XSSFRow r = mySheet.getRow(rowNum);
		XSSFCell c = r.getCell(cellNum);
		int cellType = c.getCellType();

		String value = " ";
		if (cellType == 1) {
			String value2 = c.getStringCellValue();

		} else if (DateUtil.isCellDateFormatted(c)) {
			Date dd = (Date) c.getDateCellValue();
			SimpleDateFormat s = new SimpleDateFormat(value);
			String value1 = s.format(dd);

		} else {
			double d = c.getNumericCellValue();
			long l = (long) d;
			String valueOf = String.valueOf(l);

		}

	}

	public static void createNewExcelFile(int rowNum, int cellNum, String writeData) throws IOException { // To Create
																											// new Excel
																											// File
		File f = new File("Excel location.xlsx");
		XSSFWorkbook w = new XSSFWorkbook();
		XSSFSheet newSheet = w.createSheet("Datas");
		XSSFRow newRow = newSheet.createRow(rowNum);
		XSSFCell newCell = newRow.createCell(cellNum);
		newCell.setCellValue(writeData);
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);
	}

	public void createCell(int getRow, int creCell, String newData) throws IOException { // To Create New Excel Cell
		File f = new File("Excel location.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet s = wb.getSheet(newData);
		XSSFRow r = s.getRow(creCell);
		XSSFCell c = r.createCell(creCell);
		c.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);

	}

	public static void createRow(int creRow, int creCell, String newData) throws IOException { // To Create New Excel
																								// Row
		File f = new File("Excel file.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet s = wb.getSheet(newData);
		XSSFRow r = s.createRow(creRow);
		XSSFCell c = r.createCell(creCell);
		c.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);

	}

	public static void updateDataToParticularCellValue(int getTheRow, int getTheCell, String exisitingData,
			String writeNewData) throws IOException { // To update Data To Particular Cell Value
		File f = new File("Excel Location.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet s = wb.getSheet("Datas");
		XSSFRow r = s.getRow(getTheRow);
		XSSFCell c = r.createCell(getTheCell);
		String str = c.getStringCellValue();
		if (str.equals(exisitingData)) {
			c.setCellValue(writeNewData);

		}
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);

	}

}