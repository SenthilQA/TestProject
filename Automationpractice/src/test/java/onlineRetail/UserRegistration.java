package onlineRetail;
import org.junit.Test;
import wrappers.GenericWrappers;
public class UserRegistration extends GenericWrappers {
	@Test
	public void userregistration(){
		invokeApp("chrome","http://automationpractice.com/index.php");
		clickByXpath("(//a[@class='login'])");
		scrollDown();
		enterById("email_create","Happy@gmail.com");
		clickById("SubmitCreate");
		clickById("id_gender1");
		enterById("customer_firstname","Senthil");
		enterById("customer_lastname","Jothiraj");
		enterById("passwd","@xx1Y0$");
		selectIndexById("days",4);
		selectIndexById("months",3);
		clickByXpath("(//option[@value=1990])");
		clickById("newsletter");
		clickById("optin");
		enterById("company","Davies-Group");
		enterByXpath("(//input[@id='address1'])","21");
		enterByXpath("(//input[@id='address2'])","Astcraft");
		enterByXpath("(//input[@id='city'])","Cirencester");
		clickByXpath("(//option[@value=9])[3]");
		enterByXpath("(//*[@id='postcode'])","32013");
		enterById("other","I am a Tester");
		enterById("phone","0755123789");
		enterById("phone_mobile","7854962846");
		clickById("submitAccount");
		closeBrowser();
		closeAllBrowsers();
	}
}
