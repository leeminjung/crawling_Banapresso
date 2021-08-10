package com.koreait.crawling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Banapresso {
	public static void main(String[] args) {
	String DRIVER_ID = "webdriver.chrome.driver";
	String DRIVER_PATH = "C:/minjung/JSP/chromedriver.exe";
	
	System.setProperty(DRIVER_ID,DRIVER_PATH);
	WebDriver driver = new ChromeDriver(); // import
	
	String base_url = "https://www.banapresso.com/store"; 
	try {
		driver.get(base_url);
		Thread.sleep(1000);
		WebElement nextBtn = driver.findElement(By.cssSelector("div.pagination>ul + span.btn_page")); // import
		while(true) {
			try {
				List<WebElement> bana = driver.findElements(By.cssSelector("div.pageination>ul>li")); // List import
				for(int j=0; j<bana.size(); j++) {
					bana.get(j).click();
					List <WebElement> store = driver.findElements(By.cssSelector("i"));
					List <WebElement> address = driver.findElements(By.cssSelector("span.store_name_map>span"));
					List <WebElement> isnotaddress = driver.findElements(By.cssSelector("span.store_name_map>div>em"));
					
					System.out.println("☕☕☕☕☕☕☕☕☕"+bana.get(j).getText()+"page ☕☕☕☕☕☕☕☕☕☕");
					
					for(int i=0; i<store.size(); i++) {
						System.out.println("매장:" +store.get(i).getTagName());
						if(isnotaddress.get(i).getText().equals("오픈준비중")) {
							System.out.println("주소:"+ isnotaddress.get(i).getText());
						}else {
							System.out.println("주소:"+ address.get(i).getText());
						}
					}Thread.sleep(1000);
				}
				nextBtn.click();
			}catch(Exception e) {
				System.out.println("프로그램이 종료되었습니다");
			}
		}
		
	
	
	
	}catch(Exception e) {
		e.printStackTrace();
		}
	}
}
