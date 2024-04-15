package resolver.pages;

import org.openqa.selenium.By;

public class HomePage {
	 
	
	// I would prefer to write relative Xpath, written in this way since mentioned in the test to write xpath in the below forment
	
	
	    //Home
	    public static final By HomeLink = By.xpath("//*[contains(@class,'nav-link') and contains(text(),'Home')]");
	    
	    //TEST1 
		public static final By emailAddress = By.xpath("//*[contains(@class,'form-signin')]//*[contains(@type,'email')]");
		public static final By password = By.xpath("//*[contains(@class,'form-signin')]//*[contains(@type,'password')]");
		public static final By signInButton = By.xpath("//*[contains(@class,'form-signin')]//*[contains(@type,'submit') and contains(text(),'Sign in')]");

		
		//TEST2
		public static final By listgroup = By.xpath("//*[contains(@id,'test-2-div')]//*[contains(@class,'list-group')]/child::*[contains(@class,'group-item')]");
		public static final By badge = By.xpath("//*[contains(@class,'list-group')]/child::*[contains(@class,'group-item')][2]//*[contains(@class,'badge')]");
		
		
		//TEST3
		public static final By dropdown = By.xpath("//*[contains(@id,'test-3-div')]//*[contains(@class,'btn-secondary') and contains(@id,'dropdownMenuButton')]");
		
		
		//TEST4
		public static final By button1 = By.xpath("//*[contains(@id,'test-4-div')]//*[contains(@class,'btn-primary')]");
		public static final By button2 = By.xpath("//*[contains(@id,'test-4-div')]//*[contains(@class,'btn-secondary')]");
		
		//TEST5
		public static final By Button = By.xpath("//*[contains(@id,'test-5-div')]//*[contains(@class,'btn-primary')]");
		public static final By successMsg = By.xpath("//*[contains(@id,'test-5-div')]//*[contains(@class,'alert-success') and contains(text(),'You clicked a button!')]");

}
