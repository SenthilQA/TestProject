package wrappers;

public class AccountsWapper extends GenericWrappers {
	public void Login  () {
	invokeApp("chrome", "http://leaftaps.com/opentaps");
	enterById("username", "DemoSalesManager");
	enterById("password", "crmsfa");
	clickByClassName("decorativeSubmit");
	clickByLink("CRM/SFA");
	clickByLink("Accounts");
	}
}
