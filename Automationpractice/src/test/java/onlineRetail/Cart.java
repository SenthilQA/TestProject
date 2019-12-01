package onlineRetail;

import org.junit.Test;
import wrappers.GenericWrappers;

public class Cart extends GenericWrappers{
	
	@Test
	public void cart() throws Exception {
	invokeApp("chrome","http://automationpractice.com/index.php");
	clickByXpath("(//a[@class='login'])");
	scrollDown();
	enterByXpath("(//*[@id='email'])","Happy@gmail.com");
	enterByXpath("(//*[@id='passwd'])","@xx1Y0$");
	clickByXpath("(//*[@id='SubmitLogin'])");
	clickByLink("Women");
	clickByLink("Tops");
	clickByLink("T-shirts");
	scrollDown();
	clickByXpath("(//*[@id='center_column']/ul/li/div/div[1]/div/a[1])");
	String expValue = switchtoframe_new("iframe", "fancybox-frame");
	clickByXpath("//button[@name='Submit']");
	switchtoDefaultContent();
	clickByXpath("//a[@class='btn btn-default button button-medium']");
	scrollDown();
	String actual = getTextByXpath("(//a[contains(text(),'Faded Short Sleeve T-shirts')])[2]");
	verifyResult(expValue, actual);
	closeBrowser();
	closeAllBrowsers();
	}
}
