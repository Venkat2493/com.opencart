package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProvider1
	
	@DataProvider(name ="LoginData")
	public String [][] getData() throws IOException{
		
		String path = ".\\testData\\Worksheet.xlsx"; //taking xl file from testData folder.
		
		ExcelUtility xlutil = new ExcelUtility(path); //creating an object for XLUtility
		
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", 1);
		
		//System.out.println("Row"+totalrows);
		//System.out.println("Columns"+totalcols);
		
		String logindata [][] = new String [totalrows][totalcols]; //Created for two dimension array which can store
	
		for (int i =1; i<=totalrows-1; i++) { //1  //read the data from xl storing in two dimensional array.
			
			for(int j=0; j<=totalcols-1;j++) { //0  //i is rows j is col
				
				logindata [i-1][j] = xlutil.getCellData("Sheet1", i, j);
			}
		//	System.out.println(logindata);
		}
		
		return logindata; //returning two dimension array
	}

}
