package java8;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.time.FastDateFormat;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.tuyano.springboot.dto.DataDTO;
import com.tuyano.springboot.util.CommonUtil;

public class Java12ExcelWrite {

	public static void main(String[] args) {

		// テストデータ
		List<DataDTO> list = new ArrayList<DataDTO>();
		for (int i = 0; i < 3; i++) {
			DataDTO dto = new DataDTO();
			dto.setData1("あいう" + i);
			dto.setData2("123");
			dto.setData3("1234.56");
			list.add(dto);
		}

		// EXCEL出力
    	String templateFilePath = "C:\\kashi\\参考ソース\\EXCEL書込テンプレート.xlsx";
        String yyyymmddhhmmss = FastDateFormat.getInstance("yyyyMMddkkmmss").format(Calendar.getInstance().getTime());
    	String outputFilePath = "C:\\Users\\JR90077\\Desktop\\wk\\EXCEL出力テスト" + yyyymmddhhmmss + ".xlsx";
		int rowStart = 2; // 開始行（1から）
		int colEnd = 3; // 最大列（1から）

        try (InputStream is = new ByteArrayInputStream(Files.readAllBytes(new File(templateFilePath).toPath()));
        		Workbook workbook = WorkbookFactory.create(is);
        		) {

        	// シート取得・セル書式を確保
        	Sheet sheet = workbook.getSheetAt(0);
        	List<CellStyle> cellStyle = CommonUtil.getCellStyle(workbook, sheet, rowStart, colEnd);

        	int row = rowStart - 1;
        	for (DataDTO dto : list) {
        		Row rowData = sheet.getRow(row);
        		if (rowData == null) {
        			rowData = sheet.createRow(row);
        		}

        		// 1列目
        		CommonUtil.getCell(rowData, 1, cellStyle).setCellValue(dto.getData1());
        		// 2列目
        		CommonUtil.getCell(rowData, 2, cellStyle).setCellValue(Long.parseLong(dto.getData2()));
        		// CommonUtil.getCell(rowData, 2, cellStyle); // 出力なし。書式のみコピー。
        		// 3列目
        		CommonUtil.getCell(rowData, 3, cellStyle).setCellValue(Double.parseDouble(dto.getData3()));

        		row++;
        	}

        	// ファイル保存
        	FileOutputStream out = new FileOutputStream(outputFilePath);
        	workbook.write(out);
        	out.close();
        } catch (Exception e) {
        	e.printStackTrace();
        	throw new RuntimeException(e);
        }

	}




}
