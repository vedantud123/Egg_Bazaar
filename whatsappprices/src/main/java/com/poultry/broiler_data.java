package com.poultry;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class broiler_data {

	public static int Broiler_ScrapMessage(WebDriver driver) throws ClassNotFoundException, SQLException {
		int messageCount =0;
		String formattedDate=Actions.formatteddate();
		Actions.waittill(10000);

		String xpathExpression = "//div[contains(@class, 'message-in')]//div[contains(@data-pre-plain-text,'"
				+ formattedDate + "')]";
		Actions.waittill(5000);

		List<WebElement> todayMessages = driver.findElements(By.xpath(xpathExpression));

		 messageCount = todayMessages.size();
		System.out.println("Today's broiler message count: " + messageCount);
		if(messageCount==0) 
		{
			return 0;
		}
		Actions.waittill(7000);
		String xpath="//div[@aria-hidden='true']";
		//Here we are transferring the message from the main group to the local group
		Common_Method.forward(driver, Globalconstant.tradingBroilerForwardGroup, Globalconstant.tradingBroilerMainGroup, xpath);
		Actions.waittill(3000);
		int i = 0;
		String brand="Vencobb";
		Actions.waittill(3000);
		Date currentDate1 = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formattedDate1 = dateFormat.format(currentDate1);

		for (i = 0; i < messageCount; i++) {
			Actions.waittill(3000);
			Actions.check_readmore(driver);
			Actions.waittill(3000);
			String Message=Actions.getText(driver, By.xpath("(//div[@role='application']//span[contains(@class, 'selectable-text')])["+ (i+1) +"]"));

			try {
				System.out.println(new String(Message.getBytes("UTF-8"), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			String Group_name = "broiler";
			
			System.out.println("Group_name : " + Group_name);
	
			String insertSql1 = "INSERT INTO `sunfra_poultry`.`whatsapp_msgs` (group_name,message,posted_date) VALUES (?,?,?)";
			//Here it will open the connection and store the message in database
			Database.store_mess(insertSql1, Group_name, Message, formattedDate1);
			Actions.waittill(3000);

			if(Message.contains("Vencobb")) {
		
				if(Message.contains("Karnataka")||Message.contains("Andhra Pardesh")||Message.contains("Telangana")||Message.contains("Tamil Nadu")) {
				
				}else {
					continue;
				}
				if(Message.contains("Kerala")||Message.contains("selling")||Message.contains("Rate for ")||Message.contains("Paper rate")) {
					continue;
				}
			
				String[] lines = Message.split("\n");	
		
				String state = null;
				String location = null;
				String price = null;
				boolean skipNextLines = false;

				for (String line : lines) {
					boolean check_location=false;
					if  (line.contains("Vencobb-Mota") || line.contains("Vencobb Rates-Mota")|| line.contains("Vencobb (Paper)-Mota")|| line.contains("Vencobb Board-Mota")) {
						state = line.split("Vencobb")[0].trim();
						skipNextLines = false; // Reset the skip flag
					} else if (line.contains("Billing and Net Selling-Mota")) {
						skipNextLines = true;
					} else if (!skipNextLines) {
						String[] parts = line.split("-");
						if (parts.length == 2) {
							location = parts[0];
							String[] priceParts = parts[1].split("\\("); // Splitting price by '('
							if (priceParts.length > 0) {
								price = priceParts[0].trim();
							}else {
								price = parts[1];
							}
							check_location=true;
						}
						else if (parts.length == 3) {
							location = parts[0];
							String[] priceParts = parts[1].split("\\("); // Splitting price by '('
							if (priceParts.length > 0) {
								price = priceParts[0].trim();
							}else {
								price = parts[1];

							}
							check_location=true;
						}
						if(check_location) {
							System.out.println("State: " + state);
							System.out.println("Location: " + location);
							System.out.println("Price: " + price);
							System.out.println("brand :"+brand);
							//Here it will hit the url with that particular data
							Actions.url(driver,"wa_broiler_prices", "state="+state , "location="+location, "price="+price, "brand="+brand);
						}
					}
				}
			}
			else{
				System.out.println("No need to scrap this message");
			}		
		}
		return messageCount;		
	}	
}
