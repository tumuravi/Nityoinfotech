package sampleTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Draco_TCM_Challenge {

	public static void main(String[] args) {

		// Initialize the browser
		WebDriver driver = new FirefoxDriver();

		// Open the URL
		driver.get("http://www.tcm.com/tcmdb/");
		
		//Maximize the Browser
		driver.manage().window().maximize();
		
		//Setting up Implicit Wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Listing the Movies
		List <WebElement> list = driver.findElements(By.xpath(".//*[@id='movieSearchList']/div/a"));
	    List<String> movielist=new ArrayList<String>();
	    for(int i=0; i<5; i++){
	    	movielist.add(list.get(i).getAttribute("href"));
	    }
		
		for(int j=0;j<movielist.size();j++){
			String MovieName = movielist.get(j).toString();
			driver.get(MovieName);
			
			WebElement MovieTitle = driver.findElement(By.xpath("//*[@class='db-movietitle']"));
			WebElement Overview = driver.findElement(By.xpath(".//*[@class='bsynopsis']"));
			WebElement Actor1 = driver.findElement(By.xpath("//*[@class='castandcrew-cont'][1]//div[2]/div[1]/strong/a"));
			WebElement Actor2 = driver.findElement(By.xpath("//*[@class='castandcrew-cont'][1]//div[2]/div[2]/strong/a"));
			WebElement Releasedate = driver.findElement(By.xpath("//*[@id='additional']//tr[2]/td[2]"));
			
			System.out.println("**************************************************************************************\n");
			
			if(MovieTitle.isDisplayed()){
				System.out.println("Movie Title is displayed as : " + MovieTitle.getText());
			}else{
				System.out.println("Movie Title is not displayed");
			}
			
			if(Overview.isDisplayed()){
				System.out.println("Overview is displayed as : " + Overview.getText());
			}else{
				System.out.println("Overview is not displayed");
			}
			
			if(Actor1.isDisplayed()){
				System.out.println("Actor1 is displayed as : " + Actor1.getText());
			}else{
				System.out.println("Actor1 is not displayed");
			}
			
			if(Actor2.isDisplayed()){
				System.out.println("Actor2 is displayed as : " + Actor2.getText());
			}else{
				System.out.println("Actor2 is not displayed");
			}
			
			if(Releasedate.isDisplayed()){
				System.out.println("Release Date is displayed as : " + Releasedate.getText());
			}else{
				System.out.println("Release Date is not displayed");
			}
			
		}
	
		//Close the Browser
		driver.quit();

	}

}
