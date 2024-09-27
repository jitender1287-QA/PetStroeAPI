package api.utlities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProvider1 {

	
	private String path;

	@DataProvider(name="Data")
	public String[][] getAllData() throws IOException{
		
		String path=System.getProperty("user.dir")+"//test//APIDATA.xlsx";
		ExcelUtlies tim=new ExcelUtlies(path);
		int rownum=tim.getRowCount("Sheet1");
		int colnum=tim.getCellcount("Sheet1", 1);
		String apidata[][]=new String [rownum][colnum];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colnum;j++)
			{
				apidata[i-1][j]=tim.getcellData("Sheet1", i,j);
			}
		}
		return apidata;
		
	}
	
	@DataProvider(name="UserNames")
	public String [] getUserNames() throws IOException {
		String path=System.getProperty("user.dir")+"//test//APIDATA.xlsx";
		ExcelUtlies tim=new ExcelUtlies(path);
		
		int rownum=tim.getRowCount("Sheet1");
		String apidata[]=new String[rownum];
		for(int i=1;i<=rownum;i++) {
			apidata[i-1]=tim.getcellData("Sheet1", i, 1);
		}
		
		
		return apidata;
		
		
	}
}
