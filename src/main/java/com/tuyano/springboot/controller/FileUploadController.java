package com.tuyano.springboot.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.tuyano.springboot.form.FileUploadForm;

@Controller
public class FileUploadController {
	  
	@RequestMapping(value = "/FileUploadWindow")
	public String fileUploadWindow(Model model, FileUploadForm fileUploadForm) {
		return "fileUpload/fileUpload";
	}
	
	@RequestMapping(value = "/FileUploadSubmit")
	public String fileUpload(Model model, FileUploadForm fileUploadForm) {
		return "fileUpload/fileUpload";
	}
	
	@RequestMapping(value = "/FileUploadAjax")
	@ResponseBody
	public List<String> fileUploadAjax(Model model, FileUploadForm fileUploadForm) throws Exception {
		
		InputStream is = fileUploadForm.getUploadedFile().getInputStream();
		InputStreamReader isr = new InputStreamReader(fileUploadForm.getUploadedFile().getInputStream(), StandardCharsets.UTF_8);
		BufferedReader br = new BufferedReader(isr);
		
		// ファイル読み込み(1行ずつIOUtils)
		List<String> list = IOUtils.readLines(is, StandardCharsets.UTF_8);
		
		// ファイル読み込み（CSVParser）
        CSVParser parse = CSVFormat.EXCEL                   // ExcelのCSV形式を指定
//            .withIgnoreEmptyLines(true)                   // 空行を無視する
//            .withHeader("Header1", "Header2")             // ヘッダの指定
//            .withFirstRecordAsHeader()                    // 最初の行をヘッダーとして読み飛ばす
//            .withIgnoreSurroundingSpaces(true)            // 値をtrimして取得する
            .parse(br);
        List<CSVRecord> list2 = parse.getRecords();
        for (CSVRecord record : list2) {
            System.out.println(record.get(0) + " - " + record.get(1) + " - " + record.get(2));
        }
        
		return list;
	}

	// ダウンロードSubmit既存ファイル
    @RequestMapping(value = "/FileDownloadKizon")
    public String downloadKizon(HttpServletResponse response) throws IOException {
        File file = new File("\\\\win7\\data\\カスペルスキー.txt");
//        File file = new File("C:\\Users\\kashi\\Desktop\\今やっている勉強\\あいう.csv");
//        response.addHeader("Content-Type", "application/octet-stream");
        response.addHeader("Content-Disposition", "attachment; filename*=UTF-8''" + URLEncoder.encode(file.getName(), StandardCharsets.UTF_8.name()));
        Files.copy(file.toPath(), response.getOutputStream());
        return null;
    }
    
    // ダウンロードSubmit新規ファイル
    @RequestMapping(value = "/FileDownloadSinki")
    public String downloadSinki(HttpServletResponse response) throws IOException {
    	File file = new File("かきく.csv");
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));
	    CSVPrinter printer = CSVFormat.EXCEL	// ExcelのCSV形式を指定
//	        .withQuoteMode(QuoteMode.ALL) 		// ダブルコーテーションでくくる
	        .withEscape('"').withQuoteMode(QuoteMode.NONE) // ダブルコーテーションでくくらない
	        .withHeader("ヘッダ1", "ヘッダ2", "ヘッダ3")  // ヘッダの指定
	        .print(bw);
	    printer.printRecord("あああ", "いいい", "ううう");
	    printer.printRecord("１１１", "２２２", "３３３");
	    printer.flush();
    	    
	    response.addHeader("Content-Type", "application/octet-stream");
	    response.addHeader("Content-Disposition", "attachment; filename*=UTF-8''" + URLEncoder.encode(file.getName(), StandardCharsets.UTF_8.name()));
    	Files.copy(file.toPath(), response.getOutputStream());
    	return null;
    }
    
    // ダウンロードAjax
	@RequestMapping(value = "/FileDownloadAjax")
	public List<String> fileDownloadAjax(Model model, FileUploadForm fileUploadForm, HttpServletResponse response) throws Exception {
		// 
    	File file = new File("かきく.csv");
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));
	    CSVPrinter printer = CSVFormat.EXCEL	// ExcelのCSV形式を指定
//	        .withQuoteMode(QuoteMode.ALL) 		// ダブルコーテーションでくくる
	        .withEscape('"').withQuoteMode(QuoteMode.NONE) // ダブルコーテーションでくくらない
	        .withHeader("ヘッダ1", "ヘッダ2", "ヘッダ3")  // ヘッダの指定
	        .print(bw);
	    printer.printRecord("あああ", "いいい", "ううう");
	    printer.printRecord("１１１", "２２２", "３３３");
	    printer.flush();
    	    
	    response.addHeader("Content-Type", "application/octet-stream");
	    response.addHeader("Content-Disposition", "attachment; filename*=UTF-8''" + URLEncoder.encode(file.getName(), StandardCharsets.UTF_8.name()));
    	Files.copy(file.toPath(), response.getOutputStream());
    	return null;
	}
	// ダウンロードテスト
    @RequestMapping(value = "/FileDownloadTest", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public Resource downloadTest() {
    	return new FileSystemResource(new File("C:\\Users\\kashi\\Desktop\\今やっている勉強\\あいう.csv"));
    }
    
}
