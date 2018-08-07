package com.tuyano.springboot.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tuyano.springboot.dto.Message;
import com.tuyano.springboot.dto.Reserve;
import com.tuyano.springboot.view.MessagesXlsxView;

@Controller
public class ExcelController {
	  
	@RequestMapping(value = "/excel")
	public String index() {
		return "/excel";
	}

	// Excelダウンロード新規
    @RequestMapping("/ExcelDownloadSinki")
    public ModelAndView excelDownloadSinki() {
    	List<Message> messages = new ArrayList<Message>();
    	for (int i = 0; i < 3; i++) {
    		Message msg = new Message();
    		msg.setId(String.valueOf(i));
    		msg.setName("name");
    		msg.setText("text");
		}
        return new ModelAndView(new MessagesXlsxView(), "messages", messages);
    }
    
    // Excelダウンロードテンプレート
    /**
     * [dummy] 帳票データを読み込むためのobjectMapper
     */
    @Inject
    ObjectMapper objectMapper;

    /**
     * [dummy] 帳票データを格納したjsonファイル
     */
    @Value("${app.sample.jsonFile:C:/temp/jsonData.json}")
    private File jsonDataFile;

    @RequestMapping(value = "/ExcelDownloadTemplate")
    public String excelDownloadTemplate(Model model) {

        // 1. [dummy] get report data
        Reserve reserve = this.findReserve();
        // 2. set report data to model
        model.addAttribute(reserve);
        model.addAttribute("fileName", "予約明細.xlsx");
        // 3. return excel view bean's name
        return "reservationExcelView";
    }

    /**
     * [dummy] 帳票に出力するためのダミーの予約情報を作成する
     * @return 予約
     */
    private Reserve findReserve() {
        Reserve reserve = null;
        try {
            reserve = objectMapper.readValue(jsonDataFile, Reserve.class);
            System.out.println(objectMapper.writeValueAsString(reserve));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reserve;
    }
    

    
    
}
