package wrappers;


public interface Wrappers {
		public void invokeApp(String browser, String url) ;

		/**
		 * This method will enter the value to the text field
		 *  using id attribute to locate
		 * @param idValue - id of the webelement
		 * @param data - The data to be sent to the webelement
		 * @author Senthil
		 * @return 
		 * @ 
		 */
		public void enterById(String idValue, String data) ;
		
		/**
		 * This method will enter the value to the text field using id attribute to locate
		 * @param nameValue - id of the webelement
		 * @param data - The data to be sent to the webelement
		 * @author Senthil
		 */
		public void enterByXpath(String xpathValue, String data) ;


		/**
		 * This method will click the element using xpath as locator
		 * @param xpathVal  The xpath (locator) of the element to be entered
		 * @author Senthil
		 */
		public void clickById(String id)  ;

		/**
		 * This method will click the element using id as locator
		 * @param id  The id (locator) of the element to be clicked
		 * @author Senthil
		 * @ 
		 */
		public void clickByLink(String name) ;
		
		/**
		 * This method will click the element using link name as locator 
		 * @param name  The link name (locator) of the element to be clicked
		 * @author Senthil
		 */
		public void clickByXpath(String xpathVal) ;
		
		/**
		 * This method will click the element using xpath as locator
		 * @param xpathVal  The xpath (locator) of the element to be clicked
		 * @author Senthil
		 */
		public String getTextByXpath(String xpathVal);

		/**
		 * This method will select the drop down visible text using xpath as locator
		 * @param id The xpath (locator) of the drop down element
		 * @param value The value to be selected (visibletext) from the dropdown 
		 * @author Senthil
		 */
		public void selectIndexById(String id, int value) ;
		
		/**
		 * This method will select the Index value using the id as locator.
		 * @author Senthil
		 */
		public void takeSnap();
			
		/**
		 * This method will take snapshot of the browser
		 * @author Senthil
		 */
		public void closeBrowser();
		
		
		/**
		 * This method will close the current browser
		 * @author Senthil
		 */
		public void closeAllBrowsers();
		/**
		 * This method will close all the browsers
		 * @author Senthil
		 */

}



