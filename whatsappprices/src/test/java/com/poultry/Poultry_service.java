package com.poultry;

import java.sql.SQLException;
import org.junit.Test;

public class Poultry_service  extends BaseClass {
	
	@Test
	public void Poultry_data_scrap() throws ClassNotFoundException, SQLException{
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Execution starts");
		Actions.waittill(35000);
		Common_Method.webload(driver,Globalconstant.tradingLayerMainGroup);//Going in the layer main group
		Actions.waittill(6000);
//		Actions.delete_msg(driver);//Here, we are deleting the message which is deleted by Admin person in main group
//		Actions.waittill(6000);
//		Common_Method.multi_photo(driver,Globalconstant.tradingLayerForwardGroup,Globalconstant.tradingLayerMainGroup);//transfer and deleted the multiple phpto
//		Actions.waittill(6000);
//		Common_Method.Photo_Del(driver,Globalconstant.tradingLayerForwardGroup,Globalconstant.tradingLayerMainGroup);//transfer and deleted the Less than three phpto
//		Actions.waittill(6000);
//		Common_Method.video_del(driver,Globalconstant.tradingLayerForwardGroup,Globalconstant.tradingLayerMainGroup);//transfer and deleted the Video
//		Actions.waittill(6000);
//		Common_Method.sticker(driver);//It will delete the sticker from that particular group
//		Actions.waittill(6000);
//		Common_Method.yesterday_mess(driver, Globalconstant.tradingLayerForwardGroup, Globalconstant.tradingLayerMainGroup);//It will take the yesterday messages from that group and sending to the local group and and delete the messages from that particular group
//		Actions.waittill(4000);
		int msgCount2 = 0;
		msgCount2= Cullbird_scrapdata .cullbird_ScrapMessage(driver);//Forward the message and scraping the data
		Actions.waittill(3000);
		Common_Method.delete(driver, msgCount2);//Delete the message from that particular group
		Actions.waittill(4000);
		Cullbird_scrapdata.AddedAndRemoved(driver);//Store the data which is added and remove from the group
		Actions.waittill(4000);
		Common_Method.webload(driver, Globalconstant.tradingBroilerMainGroup);//Going to the another main gorup
		Actions.waittill(6000);
		Actions.delete_msg(driver);//Here, we are deleting the message which is deleted by Admin person in main group
		Actions.waittill(6000);
		Common_Method.multi_photo(driver,Globalconstant.tradingBroilerForwardGroup,Globalconstant.tradingBroilerMainGroup);//transfer and deleted the multiple phpto
		Actions.waittill(6000);
		Common_Method.Photo_Del(driver,Globalconstant.tradingBroilerForwardGroup,Globalconstant.tradingBroilerMainGroup);//transfer and deleted the Less than three phpto
		Actions.waittill(6000);
		Common_Method.video_del(driver,Globalconstant.tradingBroilerForwardGroup,Globalconstant.tradingBroilerMainGroup);//transfer and deleted the Video
		Actions.waittill(6000);
		Common_Method.sticker(driver);//it will delete the sticker from that particular group
		Actions.waittill(6000);
		Common_Method.yesterday_mess(driver, Globalconstant.tradingBroilerForwardGroup,Globalconstant.tradingBroilerMainGroup);//It will take the yesterday messages from that group and sending to the local group and and delete the messages from that particular group
		Actions.waittill(4000);
		int msgcount3=0;	
		msgcount3=broiler_data.Broiler_ScrapMessage(driver);//Forward the message and scraping the data
		Actions.waittill(6000);
		Common_Method.delete(driver, msgcount3);//Delete the message from that particular group
		Actions.waittill(6000);
		Common_Method.webload(driver, Globalconstant.tradingFeedsmaingroup);//Going to the thrid main gorup
		Actions.waittill(3000);
		Actions.delete_msg(driver);//Here, we are deleting the message which is deleted by Admin person in main group
		Actions.waittill(3000);
		Common_Method.multi_photo(driver, Globalconstant.tradingLayerForwardGroup, Globalconstant.tradingFeedsmaingroup);//transfer and deleted the multiple phpto
		Actions.waittill(5000);
		Common_Method.Photo_Del(driver, Globalconstant.tradingLayerForwardGroup, Globalconstant.tradingFeedsmaingroup);//transfer and deleted the Less than three phpto
		Actions.waittill(3000);
		Common_Method.video_del(driver, Globalconstant.tradingLayerForwardGroup, Globalconstant.tradingFeedsmaingroup);//transfer and deleted the Video
		Actions.waittill(5000);
		Common_Method.sticker(driver);//it will delete the stickers from that particular group
		Actions.waittill(6000);
		Common_Method.yesterday_mess(driver,Globalconstant.tradingLayerForwardGroup, Globalconstant.tradingFeedsmaingroup);//It will take the yesterday messages from that group and sending to the local group and and delete the messages from that particular group
		Actions.waittill(4000);
		int msgcount4=Community.ScarpMessage(driver);//Forward the message and scraping the data
		Actions.waittill(6000);
		Common_Method.delete(driver, msgcount4);//Delete the message from that particular group
		driver.close();
	}
}
