package onlineRetail;

import org.junit.Test;

import wrappers.GenericWrappers;
public class UserLogin extends GenericWrappers {
	@Test
	public void Login() {
	invokeApp("chrome","http://automationpractice.com/index.php");
	clickByXpath("(//a[@class='login'])");
	scrollDown();
	enterByXpath("(//*[@id='email'])","Happy@gmail.com");
	enterByXpath("(//*[@id='passwd'])","@xx1Y0$");
	clickByXpath("(//*[@id='SubmitLogin'])");
	clickByXpath("(//*[@class='logout'])");
	closeBrowser();
	closeAllBrowsers();
	}
}
