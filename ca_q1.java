package ca_1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ca_q1{
    public static void main( String[] args ) throws InterruptedException
    {
    	ChromeOptions co = new ChromeOptions();
    	co.addArguments("--remote-allow-origins=*");
    	WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(co);
        driver.get("https://www.amazon.in/Apple-Watch-GPS-Cellular-40mm/dp/B09G99SW5B/ref=sr_1_5?crid=3036QHMMCSEVB&keywords=apple%2Bwatch&qid=1683192615&sprefix=apple%2Bw%2Caps%2C1293&sr=8-5&th=1");
        driver.manage().window().maximize();
        String title = driver.getTitle();
        String etitle = "Apple Watch SE (GPS + Cellular, 40mm) - Gold Aluminium Case with Starlight Sport Band - Regular : Amazon.in: Apple Products";
        System.out.println(title);
        if(title.equals(etitle)) {
        	System.out.println("Title Mismatch");
        }
        else {
        	System.out.println("Title is Matching");
        }
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
        Thread.sleep(5000); 
        Boolean present = driver.findElement(By.xpath("//*[@id=\"attach-close_sideSheet-link\"]")).isDisplayed();
        System.out.println("Is item added to cart:" + present);
        driver.get("https://www.amazon.in/gp/cart/view.html/ref=dp_atch_dss_cart?");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@value=\"Delete\"]")).click();
        Thread.sleep(2000);
        String removeText = driver.findElement(By.xpath("//*[@id=\"sc-active-cart\"]/div/div[1]/div/h1")).getText();
        String extext = "Your Amazon Cart is empty.";
        if(removeText.equals(extext)) {
        	System.out.println("Product is removed");
        }
        driver.get("https://www.amazon.in/Apple-Watch-GPS-Cellular-40mm/dp/B09G99SW5B/ref=sr_1_5?crid=3036QHMMCSEVB&keywords=apple%2Bwatch&qid=1683192615&sprefix=apple%2Bw%2Caps%2C1293&sr=8-5&th=1");
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
        Thread.sleep(2000);
        driver.get("https://www.amazon.in/gp/cart/view.html/ref=dp_atch_dss_cart?");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"a-autoid-0-announce\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"quantity_2\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@name=\"proceedToRetailCheckout\"] "));
        Thread.sleep(1000);
        String sign = driver.getTitle();
        System.out.println(sign);
        String esign = "Amazon Sign In";
        if(sign.equals(esign)) {
        	System.out.println("Success");
        }
        else {
        	System.out.println("Failure");
        }
    }
}

