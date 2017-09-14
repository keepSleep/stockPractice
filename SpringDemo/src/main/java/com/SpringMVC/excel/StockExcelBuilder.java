package com.SpringMVC.excel;

import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.SpringMVC.model.Stock;
import com.SpringMVC.model.iface.StockService;

@Component
public class StockExcelBuilder {
	public static String outputFile = "E:/gongye.xls";
	
	public static String[] titles={"股票號碼","股票名稱"};
	public static int rowIndex=0;
	
	@Autowired
	public static StockService stockService;

	
	public void createStockExcel(){
		try {
			// 創建新的Excel 活頁簿
			HSSFWorkbook workbook = new HSSFWorkbook();

			HSSFSheet sheet = workbook.createSheet();
			// 開始製作title
			createExcelTitleRow(workbook,sheet);
			// 開始製作Content
			createExcelContentRow(workbook,sheet);

			// 新建一輸出檔案流
			FileOutputStream fOut = new FileOutputStream(outputFile);
			// 把相應的Excel 活頁簿存檔
			workbook.write(fOut);
			fOut.flush();
			// 操作結束，關閉檔
			fOut.close();
			System.out.println("檔生成...");

		} catch (Exception e) {
			System.out.println("已運行 xlCreate() : " + e);
		}	
	}
	
	public void createExcelTitleRow(HSSFWorkbook workbook,HSSFSheet sheet) {
		// 創造title的style
		HSSFCellStyle titleStyle = workbook.createCellStyle();
		HSSFFont titleFont = workbook.createFont();

		titleFont.setFontHeightInPoints((short) 10);
		titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		titleFont.setColor(HSSFColor.GOLD.index);

		titleStyle.setFont(titleFont);
		titleStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		titleStyle.setFillForegroundColor(HSSFColor.GREY_80_PERCENT.index);
		
		HSSFRow row = sheet.createRow(rowIndex);
		for(int i=0;i<titles.length;i++){
			setCell(row,titleStyle,i,titles[i]);
		}
		rowIndex++;
	}

	public void createExcelContentRow(HSSFWorkbook workbook,HSSFSheet sheet) {
		// 創造一般表格的style
		HSSFCellStyle style = workbook.createCellStyle();
		HSSFFont defaultFont = workbook.createFont();

		defaultFont.setFontHeightInPoints((short) 10);
		defaultFont.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		defaultFont.setColor(HSSFColor.BLACK.index);

		style.setFont(defaultFont);
		
		List<Stock> stocks = stockService.getAll();
		for(Stock stock:stocks){
			HSSFRow row = sheet.createRow(rowIndex);
			int cellIndex=0;
			Field[] fields = stock.getClass().getDeclaredFields();
			System.out.println(fields[0].getName());
			setCell(row,style,cellIndex++,stock.getId());
			setCell(row,style,cellIndex++,stock.getName());		
			rowIndex++;
		}
	}

	public void setCell(HSSFRow row, HSSFCellStyle style,
			int cellIndex, Object value){
		HSSFCell cell = row.createCell(cellIndex);
		cell.setCellStyle(style);
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell.setCellValue(value.toString());
	}
	
	

}
