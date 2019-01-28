package java8;

import java.io.File;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.tuyano.springboot.util.CommonUtil;

public class Java11ExcelRead {

	public static void main(String[] args) {


		try {
			Workbook workbook = WorkbookFactory.create(new File("C:\\kashi\\参考ソース\\EXCEL読込テスト.xlsx"));

			// 1シート目
			Sheet sheet = workbook.getSheetAt(0);

			// 全行を繰り返し処理する場合
			Iterator<Row> rows = sheet.rowIterator();
			while(rows.hasNext()) {
				Row row = rows.next();
				// rowとcol番号でString取得
				// 1列目
				String b1 = CommonUtil.getCellStringValue(row, 1);
				System.out.println(b1);
				// 2列目
				String b2 = CommonUtil.getCellStringValue(row, 2);
				System.out.println(b2);
				// 3列目
				String b3 = CommonUtil.getCellStringValue(row, 3);
				System.out.println(b3);
			}

			// 指定行から最大行（2行目から）
			int maxrow = sheet.getLastRowNum();  // 最大行-1を返す
			for (int i = 1; i <= maxrow; i++) {
				Row row = sheet.getRow(i);
				System.out.println(CommonUtil.getCellStringValue(row, 1));
			}




		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
