package org.liveproject.com.SeleniumAutomation;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.PixelGrabber;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.SubjectTerm;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class IPNWebPage {
	
	protected static WebDriver driver;
	public InputStream iStream = null;
	
	Properties properties;
	
	public IPNWebPage(WebDriver driver){
		
		this.driver = driver;
	}
	
	protected Properties IPNPropertyResolver(){
		
		properties = new Properties();
		try {
			properties.load(new FileInputStream("resources/ipnproperties.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return properties;
	}
	
	public String readGmail(String gmailuser, String gmailPass) throws Exception {
		
		Properties props = System.getProperties();
		props.setProperty("mail.store.protocol", "imaps");
		
		//The Session class is the primary class of the JavaMail API and it is not subclass. 
		//The Session object acts as the connection factory for the JavaMail API, which handles both configuration setting and authentication. 
		 
		Session session = Session.getDefaultInstance(props, null);
		Store store = session.getStore("imaps");
		store.connect("imap.gmail.com", gmailuser,gmailPass);
		
		System.out.println("Connected to GMAIL");
		 
		Folder folder = store.getFolder("INBOX");
		folder.open(Folder.READ_WRITE);
		 
		System.out.println("Total Messages:" + folder.getMessageCount());
		System.out.println("Unread Messages:"+ folder.getUnreadMessageCount());
		
		Message[] messages = null;
		boolean isMailFound = false;
		Message message= null;
		 
		//Search for mail
		for (int i = 0; i<5; i++) {
			messages = folder.search(new SubjectTerm("Your Intuit PaymentNetwork Account"),folder.getMessages());
			
				//Wait for 10 seconds
				if (messages.length == 0) {
				Thread.sleep(10000);
				}
		}
		 

		for (Message mail : messages) {
			if (!mail.isSet(Flags.Flag.SEEN)) {
				message = mail;
				isMailFound = true;
				message.setFlag(Flags.Flag.DELETED, true);
			}
		}
		
		 
		if (!isMailFound) {
				throw new Exception("Could not find new mail:-(");
					//Read the content of mail 
				} else {
					String line;
					StringBuffer buffer = new StringBuffer();
					BufferedReader reader = new BufferedReader(new InputStreamReader(message.getInputStream()));
					while ((line = reader.readLine()) != null) {
					buffer.append(line);
				}
				 
				//Your logic to split the message and get the Registration URL goes here
					String messageContent = buffer.toString();
					
					System.out.println("================ Message Content ==============================");
					System.out.println(" ");
					System.out.println(messageContent.trim());
					System.out.println(" ");
					System.out.println("================ Message Content ==============================");
					
					int from = messageContent.indexOf("<p style=\"font-size:18px;font-weight:bold;margin:12px 0px 0px 0px; padding: 0px 0px 0px 0px;\">");
					int to =  messageContent.indexOf("</p> 								<!-- seek more help -->");
					
					System.out.println("From = "+ from);
					System.out.println("To = "+ to);
					
			
					String digitCode = messageContent.substring(from,to).split(">")[1];
					System.out.println(digitCode.trim());
					
					return digitCode;
				}
		
		}
	
	public boolean CompareImages(String file1, String file2) {
		
		boolean result = false;
		try { 
		System.out.println("In Image Processing");
		Image image1 = null;
		//image1 = Toolkit.getDefaultToolkit().getImage(new URL(file1));
		image1 = Toolkit.getDefaultToolkit().getImage(file1);
		Image image2 = null;
		image2 = Toolkit.getDefaultToolkit().getImage(file2);

		PixelGrabber pg=new PixelGrabber(image1,0,0,-1, -1, false);
		PixelGrabber pg1=new PixelGrabber(image2,0,0,-1, -1, false);
		//System.out.println("Entered try and catch, trying to grab pixels");
		pg.grabPixels();
		int[] data1 = null;
		if (pg.grabPixels()) {
		int width = pg.getWidth();
		int height = pg.getHeight();
		//System.out.println("widht * hight = "+width+" * "+height );
		data1 = new int[width * height];
		data1 = (int[])pg.getPixels();
		}

		int[] data2 = null;
		if (pg1.grabPixels()) {
		int width = pg1.getWidth();
		int height = pg1.getHeight();
		//System.out.println("widht * hight = "+width+" * "+height );
		data2 = new int[width * height];
		data2 = (int[]) pg1.getPixels();
		}

		System.out.println("Image Comparision Status :"+java.util.Arrays.equals(data1, data2));
		result = java.util.Arrays.equals(data1, data2);


		}
		catch(InterruptedException ie){
		ie.printStackTrace();
		}
		return result;
		} 
	
	public ArrayList<String> readExcel(String filepath) throws IOException{
				
		ArrayList<String> arr = new ArrayList<String>();
		
		File file = new File(filepath);
		FileInputStream fis = new FileInputStream(file);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		int noOfRows = sheet.getLastRowNum();
			
		for (int i=1; i <=noOfRows; i++){
			
			int col = sheet.getRow(0).getLastCellNum();
			
			for(int j=0 ; j<col ; j++) {
				
				String cellVal = sheet.getRow(i).getCell(j).getStringCellValue();
				
				arr.add(cellVal);
			}
									
		}
		return arr;
		
	}
	
}

