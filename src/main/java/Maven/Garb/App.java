package Maven.Garb;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class App {
	public static AppiumDriver<MobileElement> driver;
	public static WebDriverWait wait;

	public static void main(String[] args) {
		try {
			setup();

			Thread.sleep(3000);
			//driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();
			//click on login with google button
			driver.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='com.grabtaxi.passenger:id/on_boarding_google_login_button']")).click();
			Thread.sleep(3000);
			//selecting the google account
			driver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']")).click();
			Thread.sleep(3000);
			//click OK on protect your account popup
			driver.findElement(By.xpath("//android.widget.Button[@index='1']")).click();
			Thread.sleep(3000);
			//CLICK on Allow for manage phone call
			driver.findElement(By.xpath("//android.widget.Button[@index='1']")).click();
			Thread.sleep(3000);
			
			
			//enter mobile number and click next.
			driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.grabtaxi.passenger:id/verify_number_edit_number']")).sendKeys("94656035");
			Thread.sleep(3000);
			//driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.grabtaxi.passenger:id/tile_image']")).click();
		
	        driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception occured Test Case Failed");
			driver.quit();
		}
	}
        public static void setup() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Honor 9N");

		caps.setCapability("appVersion", "6.8.3");

		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "8.0");
		caps.setCapability("skipUnlock", "true");

		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.grabtaxi.passenger");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.grab.pax.newface.presentation.newface.NewFace"); 

		caps.setCapability("noReset", "false");
		//caps.setCapability("automationName", "UiAutomator2"); 
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		wait = new WebDriverWait(driver, 10);
	}

}
