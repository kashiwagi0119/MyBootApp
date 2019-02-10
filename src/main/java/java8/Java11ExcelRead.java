package java8;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.tuyano.springboot.dto.DataDTO;
import com.tuyano.springboot.util.CommonUtil;

public class Java11ExcelRead {

	public static void main(String[] args) {

		String inputFilePath = "C:\\kashi\\参考ソース\\EXCEL読込テスト.xlsx";
		int rowStart = 2; // 開始行（1から）
		int colEnd = 3; // 最大列（1から）

		try (Workbook workbook = WorkbookFactory.create(new FileInputStream(inputFilePath));) {
			Sheet sheet = workbook.getSheetAt(0);

			List<DataDTO> list = new ArrayList<DataDTO>();
			for (int rowIdx = rowStart - 1; rowIdx < Integer.MAX_VALUE; rowIdx++) {
				Row row = sheet.getRow(rowIdx);
				List<String> stringList = CommonUtil.getCellStringList(row, colEnd);
				// 空行の場合、読み込み終了
				if (stringList == null) {
					break;
				}

				DataDTO dto = new DataDTO();
				dto.setData1(stringList.get(0));
				dto.setData2(stringList.get(1));
				dto.setData3(stringList.get(2));
				list.add(dto);
			}
			System.out.println(list);

//			// 全行を繰り返し処理する場合
//			Iterator<Row> rows = sheet.rowIterator();
//			while(rows.hasNext()) {
//				Row row = rows.next();
//				// rowとcol番号でString取得
//				// 1列目
//				String b1 = CommonUtil.getCellStringValue(row, 1);
//				System.out.println(b1);
//				// 2列目
//				String b2 = CommonUtil.getCellStringValue(row, 2);
//				System.out.println(b2);
//				// 3列目
//				String b3 = CommonUtil.getCellStringValue(row, 3);
//				System.out.println(b3);
//				System.out.println("=============");
//			}

//			// 指定行から最大行（2行目から）
//			int startrow = 2;
//			int maxrow = sheet.getLastRowNum();  // 最大行-1を返す
//			for (int i = startrow - 1; i <= maxrow; i++) {
//				Row row = sheet.getRow(i);
//				System.out.println(CommonUtil.getCellStringValue(row, 1));
//			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
