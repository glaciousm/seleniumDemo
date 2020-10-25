package deus_automation.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import deus_automation.utils.Property;

public class DashboardPOM {
	
	WebDriver driver;
	Property prop = new Property();
	
	By projectRow = By.xpath("//table//tbody//tr");
	By rowNameCol = By.xpath("//td[2]");
	By projectPageBtn = By.xpath("//*[text()='View Project Page']");
	
	final static String QA_PROJECT = "QA Test Project";
	
	public DashboardPOM(WebDriver driver) {
		this.driver = driver;
	}

	public void clickProject(String project) {
		List<WebElement> projectRows = driver.findElements(projectRow);
		WebElement row;
		for (WebElement webElement : projectRows) {
			if (webElement.findElement(rowNameCol).getText().contains("QA Test Project")) {
				row = webElement.findElement(rowNameCol);
				row.click();
				break;
			}
		}
	}
	
	public void clickProjectPage() {
		driver.findElement(projectPageBtn).click();
	}
	
	public DashboardPOM selectQAProject() {
		clickProject(QA_PROJECT);
		return new DashboardPOM(driver);
	}

}
