package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static <webElement> void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver","C:\\Users\\10719017\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //comment the above 2 lines and uncomment below 2 lines to use Chrome
        //System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
     /*   String baseUrl = "https://online-pprd.absa.co.tz/air";

       // String expectedTitle = "Welcome: Mercury Tours";
     //   String actualTitle = "";
        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);
        driver.switchTo().newWindow(WindowType.TAB);*/
        driver.get("http://google.com");
     /*   List<WebElement> m = driver.findElements(By.xpath("//div[1]/a[@class='pHiOh']"));
        // iterate over list
        for(int i = 0; i< m.size(); i++) {
            //obtain text
            String s = m.get(i).getText();
            System.out.println("Text is: " + s);
        }*/

        driver.findElement(By.xpath("//input[@id='loginForm:loginName']")).sendKeys("testbbtlog");
        driver.findElement(By.xpath("//input[@id='loginForm:password']")).sendKeys("password");
        driver.findElement(By.xpath("//a[@class='directional_0 lColor4 short']")).click();

    //   String s= driver.findElement(By.xpath("//*[@id='login2LAForm:j_idt43'] an")).getText();
        String s = driver.findElement(By.xpath("//td[@id='login2LAForm:j_idt43']")).getText();
        String str = s.replaceFirst("Forgot SQA", "");
        System.out.println(str);
        String[] parts = str.trim().split(" ");
        String lastWord = parts[parts.length - 1];
        String result = lastWord.replaceAll("[-+.^:,*?]","");
        System.out.println(lastWord);

        System.out.println(result);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='login2LAForm:answer']")).click();
        

        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='login2LAForm:answer']")).sendKeys(result);
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ((JavascriptExecutor) driver).executeScript("window.stop()");
       driver.findElement(By.linkText("Next")).click();
        Thread.sleep(5000);

        System.out.println("clicked");
        driver.close();
    }
    }
