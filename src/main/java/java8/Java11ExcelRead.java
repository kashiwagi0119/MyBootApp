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

//				// cellを取得後にString取得
//				Cell cell = row.getCell(0);
//				String aaa = CommonUtil.getCellStringValue(cell);
//				System.out.println(aaa);

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






		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
