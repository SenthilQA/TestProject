package wrappers;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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

	public void enterByName(String nameValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByName(nameValue).sendKeys(data);
			System.out.println(data + " Entered Succesfully in " + nameValue);
		} catch (NoSuchElementException e) {
			System.err.println("The Element" + nameValue + "is not found");
			throw new RuntimeException();
		} catch (WebDriverException e) {
			System.err.println("The Browser unreachable");
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

	public boolean verifyTitle(String title) {
		// TODO Auto-generated method stub
		System.out.println(title);
		try {
			boolean isTitlematches = false;
			if (driver.getTitle().contains(title)) {
				isTitlematches = true;
			}

			return isTitlematches;
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.err.println("The Browser un reachable");
			throw new RuntimeException();
		} finally {
			takeSnap();
		}
	}

	public void verifyTextById(String id, String text) {
		// TODO Auto-generated method stub
		try {
			String input = driver.findElementById(id).getText();
			System.out.println("Value is" + input);

			if (input.equals(text))
				System.out.println(text + " is present");
			else
				System.out.println(text + "is not present");
		} catch (NoSuchElementException e) {
			System.err.println("The value" + id + "Not found");
			throw new RuntimeException();
		} catch (WebDriverException e) {
			System.err.println("No browser");
			throw new RuntimeException();
		} finally {
			takeSnap();
		}
	}

	public void verifyTextByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		try {
			WebElement output = driver.findElementByXPath(xpath);
			String result = output.getText();
			System.out.println("Result is " + result);
			if (result.equals(text))
				System.out.println("Error message verification success");
			else
				System.out.println("Error message verification failure");
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		// TODO Auto-generated catch block
		catch (WebDriverException e) {
			System.err.println("The browser is not found");
			throw new RuntimeException();
		} finally {
			takeSnap();
		}
	}

	public void verifyTextContainsByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		try {
			WebElement TextVerify = driver.findElementByXPath(xpath);
			String resulttext = TextVerify.getText();
			System.out.println("Result is" + resulttext);
			if (resulttext.contains(text))
				System.out.println("Message verification success");
			else
				System.out.println("Message verification failure");
		} catch (NoSuchElementException e) {
			System.err.println("The value" + xpath + "Not found");
			throw new RuntimeException();

		} catch (WebDriverException e) {
			System.err.println("The value" + xpath + "Not found");
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

	public void clickByClassName(String classVal) {
		try {

			driver.findElementByClassName(classVal).click();
			System.out.println("Clicked Succesfully in " + classVal);
		} catch (NoSuchElementException e) {
			System.err.println("the value" + classVal + "is not found");
			throw new RuntimeException();
		} catch (WebDriverException e) {
			System.err.println("the browser is not found");
			throw new RuntimeException();
		} finally {
			takeSnap();
		}
	}

	public void clickByName(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByName(name).click();
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

	public void clickByLinkNoSnap(String name) {
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

	public void clickByXpathNoSnap(String xpathVal) {
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
		}

	}

	public String getTextById(String idVal) {

		try {
			WebElement availabletext = driver.findElement(By.id(idVal));
			String displaytext = availabletext.getText();
			System.out.println("getText() " + displaytext);
			return displaytext;
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("the value" + idVal + "is not found");
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

	public void selectVisibileTextById(String id, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement dropdown = driver.findElementById(id);
			Select dropDown = new Select(dropdown);
			dropDown.selectByVisibleText(value);
			takeSnap();
			System.out.println("Selected " + value + "Successfully");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("the value" + value + "is not found");
			throw new RuntimeException();
		}

		catch (WebDriverException e) {
			System.err.println("the browser is not found");
			throw new RuntimeException();
		} finally {
			takeSnap();
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

	public void switchToParentWindow()
	// TODO Auto-generated method stub
	/*
	 * { String mainWindow = driver.getWindowHandle();
	 */
	{
		try {
			Set<String> allWindowhandles = driver.getWindowHandles();
			for (String windowhandle : allWindowhandles) {
				driver.switchTo().window(windowhandle);
				break;
			}
			System.out.println(driver.getCurrentUrl());
		} catch (WebDriverException e) {
			System.err.println("the browser is not found");
			throw new RuntimeException();
		} finally {
			takeSnap();
		}
	}

	/*
	 * Another Method { Set<String> allWindowhandles =
	 * driver.getWindowHandles(); for(String parentHandle :allWindowhandles) {
	 * driver.switchTo().window(parentHandle); takeSnap(); } }
	 */

	public void switchToLastWindow() {
		// TODO Auto-generated method stub
		try {
			String mainWindow = driver.getWindowHandle();
			Set<String> allWindowhandles = driver.getWindowHandles();
			for (String windowhandle : allWindowhandles) {
				driver.switchTo().window(windowhandle);
			}
			System.out.println(driver.getCurrentUrl());
		} catch (WebDriverException e) {
			System.err.println("the browser is not found");
			throw new RuntimeException();
		} finally {
			takeSnap();
		}
	}

	public void acceptAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().accept();
		} catch (WebDriverException e) {
			System.err.println("the browser is not found");
			throw new RuntimeException();
		}
	}

	public void dismissAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().dismiss();
		} catch (WebDriverException e) {
			System.err.println("the browser is not found");
			throw new RuntimeException();
		} finally {
			takeSnap();
		}
	}

	public String getAlertText() {
		// TODO Auto-generated method stub
		try {
			Alert availabletext = driver.switchTo().alert();
			String displaytext = availabletext.getText();
			System.out.println("getText() " + displaytext);
			return displaytext;
		} catch (WebDriverException e) {
			System.err.println("the browser is not found");
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

}
