package deus_automation.testcase;

import org.testng.annotations.Test;

import deus_automation.base.BaseTest;
import deus_automation.pageObject.DashboardPOM;
import deus_automation.pageObject.LoginPOM;
import deus_automation.pageObject.ProjectPagePOM;

public class TC_Demo extends BaseTest {
	
	LoginPOM loginPOM;
	DashboardPOM dashboardPOM;
	ProjectPagePOM projectPOM;
	
	@Test(priority = 1)
	public void login() {
		loginPOM = new LoginPOM(driver);
		loginPOM.login();
	}
	
	@Test(dependsOnMethods = "login")
	public void selectProject() {
		dashboardPOM = new DashboardPOM(driver);
		dashboardPOM.selectQAProject().clickProjectPage();
	}
	
	@Test(dependsOnMethods = "selectProject")
	public void uploadFile() {
		projectPOM = new ProjectPagePOM(driver);
		projectPOM.uploadFile().checkFileAndDelete();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
