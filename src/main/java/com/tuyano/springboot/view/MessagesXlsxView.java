package com.tuyano.springboot.view;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.tuyano.springboot.dto.Message;

public class MessagesXlsxView extends AbstractXlsxView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	
        String fileName = new String("サンプル.xlsx".getBytes("MS932"), "ISO-8859-1");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        
        @SuppressWarnings("unchecked")
        List<Message> messages = (List<Message>) model.get("messages");
        
        Sheet sheet = workbook.createSheet("シート名１");
        
        // create header
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("ID");
        row.createCell(1).setCellValue("Name");
        row.createCell(2).setCellValue("Text");
        
        // create body
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i=0; i<3; i++) {
//            Message message = messages.get(i);
            row = sheet.createRow(i+1);
            row.createCell(0).setCellValue(String.valueOf(i));
            row.createCell(1).setCellValue("name" + String.valueOf(i));
            row.createCell(2).setCellValue("text" + String.valueOf(i));
        }
        
        // enable auto filter
//        sheet.setAutoFilter(new CellRangeAddress(0, 0, 0, 4));
        
        // adjust column width
        for (int i=0; i<5; i++) {
            sheet.autoSizeColumn(i);
        }
    }

}