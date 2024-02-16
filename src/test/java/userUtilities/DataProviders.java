package userUtilities;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import userPayload.Userpojo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


		public class DataProviders {

			@DataProvider(name = "userData")
			public Iterator<Object[]> userDataProvider() throws IOException {
				List<Object[]> userData = new ArrayList<>();
				FileInputStream excelFile = new FileInputStream(new File("C:\\Users\\samap\\eclipse-workspace\\UserAPIRestAssuredTest\\TestData\\Book1.xlsx"));
				Workbook workbook = new XSSFWorkbook(excelFile);
				Sheet sheet = workbook.getSheet("UserData");

				Iterator<Row> iterator = sheet.iterator();
				while (iterator.hasNext()) {
					Row currentRow = iterator.next();
					if (currentRow.getRowNum() == 0) {
						continue; // Skip header row
					}

					String[] data = new String[9];

					data[0] = currentRow.getCell(0).getStringCellValue(); // First Name
					data[1] = currentRow.getCell(1).getStringCellValue(); // Last Name
					data[2] = "" + (long) currentRow.getCell(2).getNumericCellValue(); // Contact Number
					data[3] = currentRow.getCell(3).getStringCellValue(); // Email ID
					data[4] = currentRow.getCell(4).getStringCellValue(); // Plot Number
					data[5] = currentRow.getCell(5).getStringCellValue(); // Street
					data[6] = currentRow.getCell(6).getStringCellValue(); // State
					data[7] = currentRow.getCell(7).getStringCellValue(); // Country
					data[8] = "" + (long) currentRow.getCell(8).getNumericCellValue(); // Zip Code

					userData.add(data);
				}
				workbook.close();
				return userData.iterator();
			}

			@Test(dataProvider = "userData")
			public void testUserData(String firstName, String lastName, String contactNumber, String email, String[] userAddress) {
				// Your test logic here
				System.out.println("First Name: " + firstName);
				System.out.println("Last Name: " + lastName);
				System.out.println("Contact Number: " + contactNumber);
				System.out.println("Email: " + email);
				System.out.println("User Address: " + userAddress.toString());

				// Add your assertions here if needed
				Assert.assertNotNull(firstName);
				Assert.assertNotNull(lastName);
				Assert.assertNotNull(contactNumber);
				Assert.assertNotNull(email);
				Assert.assertEquals(userAddress.length, 5);
			}
		}


	    
	





