package com.tuyano.springboot.view;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.tuyano.springboot.dto.Reserve;


/**
 * ★ポイント1
 */
@Component
public class ReservationExcelView extends AbstractXlsxView {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(ReservationExcelView.class);

    /**
     * ★ポイント2
     * ツアー予約登録のExcelテンプレート
     */
    @Value("${app.report.resevation.template:C:/temp/reservation.xlsx}")
    private File excelTemplateFile;

    /**
     * ★ポイント3
     * <p>
     * excelTemplateFile で指定したExcelテンプレートを利用してWorkbookを作成する
     * <p>
     * このメソッドで返却したWorkbookのオブジェクトが、buildExcelDocumentメソッドの引数として渡される
     * @see org.springframework.web.servlet.view.document.AbstractXlsxView#createWorkbook(java.util.Map,
     *      javax.servlet.http.HttpServletRequest)
     */
    @Override
    protected Workbook createWorkbook(Map<String, Object> model, HttpServletRequest request) {
        Workbook workbook = null;
        try (InputStream is = new ByteArrayInputStream(
                Files.readAllBytes(excelTemplateFile.toPath()));) {
            workbook = WorkbookFactory.create(is);
        } catch (IOException | EncryptedDocumentException
                | InvalidFormatException e) {
            LOGGER.error("create workbook error", e);
        }
        return workbook;
    }

    /**
     * ★ポイント4
     * @see org.springframework.web.servlet.view.document.AbstractXlsView#buildExcelDocument(java.util.Map,
     *      org.apache.poi.ss.usermodel.Workbook, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void buildExcelDocument(Map<String, Object> model,
            Workbook workbook, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        // ★ポイント5
        // 1. Modelに格納されている帳票データを取得
        Reserve reserve = (Reserve) model.get("reserve");

        // ★ポイント6
        // 2. シートの選択
        Sheet sheet = workbook.getSheet("予約");

        // ★ポイント7
        // 3. セルにデータを設定
        // 5行F列に「予約番号」の値を設定
        getCell(sheet, 4, 5).setCellValue(reserve.getReserveNo());

        // ★ポイント8        
        // 4. responseヘッダにファイル名を設定
        String fileName = (String) model.get("fileName");
        String encodedFilename = URLEncoder.encode(fileName, "UTF-8");
        response.setHeader("Content-Disposition","attachment; filename*=UTF-8''" + encodedFilename);

        // ★ポイント7
        // 3. セルにデータを設定
        // 5行AA列に「予約日」の値を設定
        getCell(sheet, 4, 26).setCellValue(reserve.getReserveNo());
//        // ツアー名
//        getCell(sheet, 5, 5).setCellValue(tourInfo.getTourName());
//        // 出発日
//        getCell(sheet, 6, 5).setCellValue(tourInfo.getDepDay());
//        // 日数
//        getCell(sheet, 6, 26).setCellValue(tourInfo.getTourDays());
//        // 出発地
//        getCell(sheet, 7, 5).setCellValue(tourInfo.getDeparture().getDepName());
//        // 目的地
//        getCell(sheet, 7, 26).setCellValue(tourInfo.getArrival().getArrName());
//        // 添乗員
//        getCell(sheet, 8, 5).setCellValue(tourInfo.getConductor());
//        // 宿泊施設
//        getCell(sheet, 9, 5)
//                .setCellValue(tourInfo.getAccommodation().getAccomName());
//        // 連絡先
//        getCell(sheet, 9, 26)
//                .setCellValue(tourInfo.getAccommodation().getAccomTel());
//        // 概要
//        getCell(sheet, 10, 5).setCellValue(tourInfo.getTourAbs());
//        // omitted
    }

    /**
     * <p>
     * 引数で指定されたシートの、行番号、列番号で指定したセルを取得して返却する
     * <p>
     * 行番号、列番号は0から開始する
     * <p>
     * Excelテンプレートで該当のセルを操作していない場合、NullPointerExceptionになる
     * @param sheet シート
     * @param rowIndex 行番号
     * @param colIndex 列番号
     * @return セル
     */
    private Cell getCell(Sheet sheet, int rowIndex, int colIndex) {
        Row row = sheet.getRow(rowIndex);
        return row.getCell(colIndex);
    }

}