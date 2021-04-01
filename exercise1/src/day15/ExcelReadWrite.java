package day15;

import jxl.*;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.*;

public class ExcelReadWrite {
	public static void main(String[] args) throws Exception {
		
		ReadandWriteExcel erw = new ReadandWriteExcel();
		
		File fis = new File("E:\\Infosys_SASTRA.xls");
		
		File writeFile = new File("E://infosys_SASTRAcopy.xls");
		
		erw.read(fis);
		
		erw.write(fis, writeFile);
		
	}
}

class ReadandWriteExcel{
	public void read(File f) throws Exception {
		
		Workbook w = Workbook.getWorkbook(f);
		Sheet s = w.getSheet(0);
		
		
		for(int j=0;j<s.getColumns();j++) {
			for(int i=0;i<s.getRows();i++) {
				Cell cell =s.getCell(j, i);
				CellType type = cell.getType();
//				newsheet.addCell(cell.getContents());
                System.out.println(type+ " "
                            + cell.getContents());
                Label label = new Label(j, i, cell.getContents());
                
			}
		}	
		
	}
	
	public void write(File readFile, File writeFile) throws Exception {
		Workbook w = Workbook.getWorkbook(readFile);
		Sheet s = w.getSheet(0);
		
		WritableWorkbook myFirstWbook = null;
        try {
        	myFirstWbook = Workbook.createWorkbook(writeFile);

            // create an Excel sheet
            WritableSheet newsheet = myFirstWbook.createSheet("Sheet 1", 0);
		System.out.println(s.getColumns());
		for(int j=0;j<s.getColumns();j++) {
			for(int i=0;i<s.getRows();i++) {
				Cell cell =s.getCell(j, i);
				CellType type = cell.getType();
//				newsheet.addCell(cell.getContents());
               
                Label label = new Label(j, i, cell.getContents());
                newsheet.addCell(label);
                
			}
			System.out.println(newsheet.getCell(1, 1).getContents());
			
			
			
        	
        }
		myFirstWbook.write();
            }catch (IOException e) {
                e.printStackTrace();
            } catch (WriteException e) {
                e.printStackTrace();
            } finally {

                if (myFirstWbook != null) {
                    try {
                        myFirstWbook.close();
                        w.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (WriteException e) {
                        e.printStackTrace();
                    }
                }
		
		
            }
	}
}