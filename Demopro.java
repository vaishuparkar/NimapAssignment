package Nimapproject;

import java.io.IOException;
import java.time.Duration;
import javax.swing.JOptionPane;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Demopro {
	public String baseURL = ("https://testffc.nimapinfotech.com/customers");
    public WebDriver wd;
	
	@BeforeTest
	 public void setup() {
     wd=new FirefoxDriver();
     
     wd.manage().window().maximize();
     wd.get(baseURL);
     wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}
	
     @Test (priority=1)
     public void loginprocess() throws IOException, InterruptedException {
    	//email id 
      wd.findElement(By.xpath("//*[@id=\"mat-input-0\"]")).sendKeys("8425041427");
      // password 
      wd.findElement(By.xpath("//*[@id=\"mat-input-1\"]")).sendKeys("vaishnavi21");
     
    String str= JOptionPane.showInputDialog("Enter your captcha");
    WebElement element =wd.findElement(By.xpath("/html/body/kt-auth/div/div/div[2]/kt-login/div[2]/div/form/div[3]/kt-captcha/div/div/form/input"));
     element.sendKeys(str);
     
     // click on login 
     wd.findElement(By.xpath("//*[@id=\"kt_login_signin_submit\"]")).click();
     }
     
     @Test (priority=2)
     public void addconstumer(){
      //click on my const
     wd.findElement(By.xpath("//*[@id=\"kt_aside_menu\"]/ul/li[2]/a/span")).click();
      //click on new 
      wd.findElement(By.xpath("//*[@id=\"kt_content\"]/div/ng-component/kt-customers-list/mat-drawer-container/mat-drawer-content/kt-portlet/div/kt-portlet-header/div[4]/button[1]")).click();
    
      //lead consumter
      wd.findElement(By.id("mat-input-12")).sendKeys("Lina");
      // ref no 
      wd.findElement(By.id("mat-input-13")).sendKeys("1234");
      
      // cont person 
      wd.findElement(By.id("mat-input-15")).sendKeys("pooja");
      //mob
      wd.findElement(By.id("mat-input-16")).sendKeys("8564729356");
      //tel
      wd.findElement(By.id("mat-input-17")).sendKeys("0236456892");
      //email
      wd.findElement(By.id("mat-input-18")).sendKeys("vaishnaviparkar999@gmail.com");
      
      //designation 
      wd.findElement(By.id("mat-input-19")).sendKeys("thane"); 
      
     
       /* country
        
             Select ic = new Select (wd.findElement(By.id("mat-input-43")));
	          ic.selectByValue("India");*/
	
		
		//pincode 
		wd.findElement(By.id("mat-input-25")).sendKeys("416611");
		//save
       wd.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/kt-customers-edit-dialog/div[2]/div/div/div/button[2]")).click();
     }	
		
		@AfterTest
		  public void tearDown() throws InterruptedException
		{
			Thread.sleep(10000);
			wd.quit();
			wd.close();
			
		}
		
		
		
		
		
     }
	

