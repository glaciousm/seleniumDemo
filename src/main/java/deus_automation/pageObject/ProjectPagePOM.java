package deus_automation.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import deus_automation.utils.Property;

public class ProjectPagePOM {
	
	WebDriver driver;
	Property prop = new Property();
	
	By dropAreaDiv = By.cssSelector(".ui-fileupload-choose input");
	By uploadedFileRow = By.cssSelector("table tbody tr");
	By uploadedFileNameCol =  By.cssSelector("td");
	
	public ProjectPagePOM(WebDriver driver) {
		this.driver = driver;
	}

	public ProjectPagePOM uploadFile() {
		WebElement dropArea = driver.findElement(dropAreaDiv);
		dropArea.sendKeys(prop.getFileLocation());
		
		return new ProjectPagePOM(driver);
	}
	
	public void deleteFile(WebElement fileElement) {
		WebElement fileLastCol = fileElement.findElements(uploadedFileNameCol).get(12);
		List<WebElement> tdBtns = fileLastCol.findElements(By.cssSelector("button"));
		tdBtns.get(1).click();
		
	}
	
	public WebElement checkFile() {
		WebElement fileNameCol = null;
		WebElement fileRow = driver.findElements(uploadedFileRow).get(0);
		List<WebElement> fileNameCols = fileRow.findElements(uploadedFileNameCol);
		for (WebElement webElement : fileNameCols) {
			if (webElement.getText().contains(prop.fastqFileName)) {
				fileNameCol = webElement;
				break;
			}
		}
		Assert.assertEquals(fileNameCol.getText(), prop.fastqFileName);
		
		return fileRow;
	}
	
	public ProjectPagePOM checkFileAndDelete() {
		WebElement fileRow = checkFile();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		deleteFile(fileRow);
		
		return new ProjectPagePOM(driver);
	}

}
