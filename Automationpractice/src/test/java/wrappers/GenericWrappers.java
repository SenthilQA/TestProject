package wrappers;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class GenericWrappers implements Wrappers {
	RemoteWebDriver driver;
	int i = 1;

	public void invokeApp(String browser, String url) {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer32.exe");
				driver = new InternetExplorerDriver();
			}
			driver.get(url);
			System.out.println(driver.getTitle());
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("The browser unreachable");
		} finally {
			takeSnap();
		}
	}																		

	public void enterById(String idValue, String data) {
		try {
			driver.findElementById(idValue).clear();
			driver.findElementById(idValue).sendKeys(data);
			System.out.println(data + " Entered Succesfully in " + idValue);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element" + idValue + "is not found");
			throw new RuntimeException();
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.err.println("The browser unreachable");
			throw new RuntimeException();
		} finally {
			takeSnap();
		}
	}

	public void enterByXpath(String xpathValue, String data) {
		// TODO Auto-generated method stub

		try {
			driver.findElementByXPath(xpathValue).sendKeys(data);
			System.out.println(data + " Entered Succesfully in " + xpathValue);
		} catch (NoSuchElementException e) {
			System.err.println("The Element" + xpathValue + "is not found");
			throw new RuntimeException();
		} catch (WebDriverException e) {
			System.err.println("The Browser un reachable");
			throw new RuntimeException();

		} finally {
			takeSnap();
		}
	}
	
	public void clickById(String id) {

		try {
			driver.findElementById(id).click();
			System.out.println("Clicked Succesfully in " + id);
		} catch (NoSuchElementException e) {
			System.err.println("the value" + id + "is not found");
			throw new RuntimeException();
		} catch (WebDriverException e) {
			System.err.println("the browser is not found");
			throw new RuntimeException();
		} finally {
			takeSnap();
		}
	}

	public void clickByLink(String name) {

		// TODO Auto-generated method stub
		try {
			driver.findElementByLinkText(name).click();
			System.out.println("Clicked Succesfully in " + name);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("the value" + name + "is not found");
			throw new RuntimeException();
		}

		catch (WebDriverException e) {
			System.err.println("the browser is not found");
			throw new RuntimeException();
		} finally {
			takeSnap();
		}
	}

	public void clickByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathVal).click();
			System.out.println("Clicked " + xpathVal + " Successfully");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("the value" + xpathVal + "is not found");
			throw new RuntimeException();
		}

		catch (WebDriverException e) {
			System.err.println("the browser is not found");
			throw new RuntimeException();
		} finally {
			takeSnap();
		}

	}

	public String getTextByXpath(String xpathVal) {
		String displaytext;
		try {
			WebElement availabletext = driver.findElement(By.xpath(xpathVal));
			displaytext = availabletext.getText();
			System.out.println("getText() " + displaytext);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("the value" + xpathVal + "is not found");
			throw new RuntimeException();
		}

		catch (WebDriverException e) {
			System.err.println("the browser is not found");
			throw new RuntimeException();
		} finally {
			takeSnap();
		}
		return displaytext;
	}
	
	public void verifyResult(String exp, String act) {
		if(exp.toString().trim().toUpperCase().equals(act.toString().trim().toUpperCase())){		
			System.out.println("Content are equal..");
		}else{
			System.out.println("Content are not equal..");
		}
	}
	
	public void selectIndexById(String id, int value) {
		// TODO Auto-generated method stub

		try {
			WebElement dropdown = driver.findElementById(id);
			Select dropDown = new Select(dropdown);
			dropDown.selectByIndex(value);
			takeSnap();
			System.out.println("Selected " + value + "Successfully");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("the value" + id + "is not found");
			throw new RuntimeException();
		}

		catch (WebDriverException e) {
			System.err.println("the browser is not found");
			throw new RuntimeException();
		} finally {
			takeSnap();
		}
	}

	public String switchtoframe_new(String objName,String frameClass) throws Exception {
		// TODO Auto-generated method stub
		String Itemname=null;
		try {
			final List<WebElement> iframes = driver.findElements(By.tagName(objName));
		    for (WebElement iframe : iframes) {
		    	System.out.println("switched to iframe..." + iframe.getAttribute("name"));
		    	if(iframe.getAttribute("name").contains(frameClass)){
		    		driver.switchTo().frame(iframe.getAttribute("name"));
		    		Thread.sleep(1000);
		    		Itemname = driver.findElementByXPath("(//*[contains(text(),'Faded Short Sleeve T-shirts')])[2]").getText();
		    		System.out.println(Itemname);
		    		
		    	}
		    }
		    return Itemname; 
		} catch (WebDriverException e) {
			System.err.println("the browser is not found");
			throw new RuntimeException();
		}finally {
			takeSnap();
		}
	}
		
	public void switchtoDefaultContent() throws Exception {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(1000);
			driver.switchTo().defaultContent();
			Thread.sleep(1000);
		} catch (WebDriverException e) {
			System.err.println("the browser is not found");
			throw new RuntimeException();
		}finally {
			takeSnap();
		}
	}
	
	public void scrollDown() {
		try {
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0,500);");
		} catch (WebDriverException e) {
			System.err.println("the scrollbar not found");
			throw new RuntimeException();
		} finally {
			takeSnap();
		}
	}

	public void takeSnap() {
		File src = driver.getScreenshotAs(OutputType.FILE);
		File desc = new File("./snaps/snap" + i + ".jpg");
		try {
			FileUtils.copyFile(src, desc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i++;

	}

	public void closeBrowser() {
		try {
			driver.close();
		} catch (WebDriverException e) {
			System.err.println("the browser is not found");
			throw new RuntimeException();
		}
	}

	public void closeAllBrowsers() {
		// TODO Auto-generated method stub
		try {
			driver.quit();
		} catch (WebDriverException e) {
			System.err.println("the browser is not found");
			throw new RuntimeException();
		}
	}

	public String switchtoframe_new() {
		// TODO Auto-generated method stub
		return null;
	}

}
