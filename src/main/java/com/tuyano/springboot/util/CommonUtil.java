package com.tuyano.springboot.util;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.tuyano.springboot.constant.BaseEnum;
import com.tuyano.springboot.dto.SelectItemDTO;


/**
 * 共通ユーティリティ
 */
public final class CommonUtil {

    /**
     * Enumからセレクトアイテムに変換
     *
     * @param enumSet Enum名
     * @param isspace 先頭にスペースを入れる場合、True
     * @param addCode 表示の前に「コード:」を追加する場合、True
     * @return 当年度
     */
    public static List<SelectItemDTO> getEnumToSelectItem(BaseEnum[] enumSet, boolean isspace, boolean addCode) {
    	List<SelectItemDTO> result = new ArrayList<SelectItemDTO>();
    	if (isspace) {
    		SelectItemDTO dto = new SelectItemDTO();
    		dto.setCode("");
    		dto.setLabel("");
    		result.add(dto);
    	}
    	for (BaseEnum e : enumSet) {
    		SelectItemDTO dto = new SelectItemDTO();
    		dto.setCode(e.getCode());
    		if (addCode) {
    			dto.setLabel(e.getCode() + "：" + e.getLabel());
    		} else {
    			dto.setLabel(e.getLabel());
    		}
    		result.add(dto);
    	}
    	return result;
    }

	/**
	 * 桁数チェック
	 * @param str 入力文字列
	 * @param length 桁数
	 * @return true = チェックOK、false = チェックNG
	 */
	public static boolean checkLength(String str, int length) {
		// ブランクの場合、チェックOK（エラーではない）
		if (StringUtils.isBlank(str)) {
			return true;
		}
		// 桁数チェック
		if (str.length() > length) {
			return false;
		}
		return true;
	}

	/**
	 * 数値チェック
	 * @param str 入力文字列
	 * @return true = チェックOK、false = チェックNG
	 */
	public static boolean checkNumber(String str) {
		// ブランクの場合、チェックOK（エラーではない）
		if (StringUtils.isBlank(str)) {
			return true;
		}
		// 数値チェック
		if (!NumberUtils.isNumber(str)) {
			return false;
		}
		return true;
	}

	/**
	 * 数値チェック（整数部・小数部）
	 * @param str 入力文字列
	 * @param integral 整数部桁数
	 * @param decimal 小数部桁数
	 * @return true = チェックOK、false = チェックNG
	 */
	public static boolean checkBigDecimal(String str, int integral, int decimal) {
		// ブランクの場合、チェックOK（エラーではない）
		if (StringUtils.isBlank(str)) {
			return true;
		}
		// 数値チェック
		if (!NumberUtils.isNumber(str)) {
			return false;
		}
		// 整数部が桁数内か？
		BigDecimal bigdecimal = new BigDecimal(str);
		if (bigdecimal.precision() - bigdecimal.scale() > integral) {
			return false;
		}
		// 小数部が桁数内か？
		if (bigdecimal.scale() > decimal) {
			return false;
		}
		return true;
	}

    /**
     * 日付チェック（yyyy/mm/dd）
     * @param strDate
     * @return true = チェックOK、false = チェックNG
     */
	public static boolean checkDateYYYY_MM_DD(String strDate) {
		// ブランクの場合、チェックOK（エラーではない）
        if (StringUtils.isBlank(strDate)) {
            return true;
        }
        DateFormat format = DateFormat.getDateInstance();
        format.setLenient(false);
        try {
            format.parse(strDate);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

	/**
	 * 日付変換  String(yyyy/mm/dd)→Calendar
	 * @param str
	 * @return Calendar
	 */
	public static Calendar convStringCalendar(String str){
		if (StringUtils.isBlank(str)) {
			return null;
		}
		Calendar cal = new GregorianCalendar();
		try {
			cal.setTime(DateFormat.getDateInstance().parse(str));
		} catch (Exception e) {
			cal = null;
		}
		return cal;
	}

	/**
	 * 数値変換  String→BigDecimal
	 * @param str
	 * @return BigDecimal
	 */
	public static BigDecimal convStringBigDecimal(String str){
		if (StringUtils.isBlank(str)) {
			return null;
		}
		BigDecimal result = null;
		try {
			result = new BigDecimal(str);
		} catch (Exception e) {
			result = null;
		}
		return result;
	}

	/**
	 * 数値変換  String→Long
	 * @param str
	 * @return Long
	 */
	public static Long convStringLong(String str){
		if (StringUtils.isBlank(str)) {
			return null;
		}
		Long result = null;
		try {
			result = new Long(str);
		} catch (Exception e) {
			result = null;
		}
		return result;
	}


	/**
	 * 数値変換  BigDecimal→Double
	 * @param BigDecimal
	 * @return Double
	 */
	public static Double convBigDecimalDouble(BigDecimal big){
		if (big == null) {
			return null;
		}
		Double result = null;
		try {
			result = big.doubleValue();
		} catch (Exception e) {
			result = null;
		}
		return result;
	}

	/**
	 * EXCELのヘッダチェック
	 * @param sheet
	 * @param rowStart
	 * @param headerList
	 * @return
	 */
	public static boolean checkExcelHeader(Sheet sheet, int rowStart, List<String> headerList) {
		if (sheet == null || headerList == null || headerList.isEmpty()) {
			return true;
		}
		Row row = sheet.getRow(rowStart - 1);
		if (row == null) {
			return true;
		}
		for (int col = 0; col < headerList.size(); col++) {
			Cell cell = row.getCell(col);
			if (cell == null) {
				return true;
			}
			if (!StringUtils.equals(getCellStringValue(cell), headerList.get(col))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * EXCELのセル値をList<String>で取得
	 * @param row 行
	 * @param maxCol 最大列（１から）
	 * @return
	 */
	public static List<String> getCellStringList(Row row, int maxCol) {
		List<String> result = new ArrayList<String>();
		if (row == null) {
			return null;
		}
		// 全て空白の場合も終了
		boolean hit = false;
		for (int i = 1; i <= maxCol; i++) {
			String data = CommonUtil.getCellStringValue(row, i);
			result.add(data);
			if (StringUtils.isNotBlank(data)) {
				hit = true;
			}
		}
		if (!hit) {
			return null;
		}
		return result;
	}

	/**
	 * EXCELのセル値をStringで取得
	 * @param row 行
	 * @param col 列番号（１から）
	 * @return
	 */
	public static String getCellStringValue(Row row, int col) {
		Cell cell = row.getCell(col - 1);
		return getCellStringValue(cell);
	}

	/**
	 * EXCELのセル値をStringで取得
	 * @param cell
	 * @return
	 */
	public static String getCellStringValue(Cell cell) {
		if (cell == null) {
			return "";
		}
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			return cell.getStringCellValue();
		case Cell.CELL_TYPE_NUMERIC:
            if (DateUtil.isCellDateFormatted(cell)) {
                return DateFormatUtils.format(cell.getDateCellValue(), "yyyy/MM/dd");
            }
            else {
            	DecimalFormat df = new DecimalFormat("####################.####################");
                return df.format(cell.getNumericCellValue());
            }
		case Cell.CELL_TYPE_BOOLEAN:
			return StringUtils.upperCase(Boolean.toString(cell.getBooleanCellValue()));
		case Cell.CELL_TYPE_FORMULA:
			return getStringFormulaValue(cell);
		default:
			return "";
		}
	}

	/**
	 * EXCELのセル計算式をStringに変換
	 * @param cell
	 * @return
	 */
	private static String getStringFormulaValue(Cell cell) {
		Workbook book = cell.getSheet().getWorkbook();
		CreationHelper helper = book.getCreationHelper();
		FormulaEvaluator evaluator = helper.createFormulaEvaluator();
		CellValue value = evaluator.evaluate(cell);
		switch (value.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			return value.getStringValue();
		case Cell.CELL_TYPE_NUMERIC:
            if (DateUtil.isCellDateFormatted(cell)) {
                return DateFormatUtils.format(cell.getDateCellValue(), "yyyy/MM/dd");
            }
            else {
            	DecimalFormat df = new DecimalFormat("####################.####################");
                return df.format(cell.getNumericCellValue());
            }
		case Cell.CELL_TYPE_BOOLEAN:
			return Boolean.toString(value.getBooleanValue());
		default:
			return "";
		}
	}


	/**
	 * EXCELのセルを取得
	 * @param rowData
	 * @param col
	 * @param cellStyle
	 * @return
	 */
	public static Cell getCell(Row rowData, int col) {
		Cell cell = rowData.getCell(col - 1);
		if (cell == null) {
			cell = rowData.createCell(col - 1);
		}
		return cell;
	}

	/**
	 * EXCELのセルを取得（セル書式設定あり）
	 * @param rowData
	 * @param col
	 * @param cellStyle
	 * @return
	 */
	public static Cell getCell(Row rowData, int col, List<CellStyle> cellStyle) {
		Cell cell = rowData.getCell(col - 1);
		if (cell == null) {
			cell = rowData.createCell(col - 1);
			cell.setCellStyle(cellStyle.get(col - 1));
		}
		return cell;
	}

	/**
	 * EXCELのセルを設定（セル書式設定あり）
	 * @param rowData
	 * @param col
	 * @param cellStyle
	 * @param obj 出力オブジェクト
	 */
	public static void setCellValue(Row rowData, int col, List<CellStyle> cellStyle, Object obj) {
		Cell cell = rowData.getCell(col - 1);
		if (cell == null) {
			cell = rowData.createCell(col - 1);
			cell.setCellStyle(cellStyle.get(col - 1));
		}
		if (obj != null) {
			if (obj instanceof String) {
				cell.setCellValue((String)obj);
			}
			if (obj instanceof Long) {
				cell.setCellValue((Long)obj);
			}
			if (obj instanceof Integer) {
				cell.setCellValue((Integer)obj);
			}
			if (obj instanceof Float) {
				cell.setCellValue((Float)obj);
			}
			if (obj instanceof Double) {
				cell.setCellValue((Double)obj);
			}
			if (obj instanceof BigDecimal) {
				cell.setCellValue(((BigDecimal)obj).doubleValue());
			}
			if (obj instanceof Boolean) {
				cell.setCellValue((Boolean)obj);
			}
			if (obj instanceof Calendar) {
				cell.setCellValue((Calendar)obj);
			}
		}
	}

	/**
	 * EXCELのセル書式を取得
	 * @param workbook
	 * @param sheet
	 * @param rowStart
	 * @param colEnd
	 * @return
	 */
	public static List<CellStyle> getCellStyle(Workbook workbook, Sheet sheet, int rowStart, int colEnd) {
		List<CellStyle> cellStyle = new ArrayList<CellStyle>();
        Row baseRow = sheet.getRow(rowStart - 1);
        for (int col = 0; col < colEnd ; col++) {
        	Cell baseCell = baseRow.getCell(col);
        	CellStyle s = workbook.createCellStyle();
        	s.cloneStyleFrom(baseCell.getCellStyle());
        	cellStyle.add(s);
        }
		return cellStyle;
	}

	/**
	 * 左余白詰め（文字数以下なら切り捨てる）
	 *
	 * @param str 文字列
	 * @param length 文字数
	 * @param padword 詰める文字列
	 * @return
	 */
	public static String leftPad(String str, int length, String padword) {
		// ブランクの場合
		if (StringUtils.isBlank(str)) {
			return StringUtils.repeat(padword, length);
		}
		// 文字列が文字数以下なら切り捨てる
		if (str.length() > length) {
			str = StringUtils.substring(str, 0, length);
		}
		// 余白詰め
		return  StringUtils.leftPad(str, length, padword);
	}

	/**
	 * 右余白詰め（文字数以下なら切り捨てる）
	 *
	 * @param str 文字列
	 * @param length 文字数
	 * @param padword 詰める文字列
	 * @return
	 */
	public static String rightPad(String str, int length, String padword) {
		// ブランクの場合
		if (StringUtils.isBlank(str)) {
			return StringUtils.repeat(padword, length);
		}
		// 文字列が文字数以下なら切り捨てる
		if (str.length() > length) {
			str = StringUtils.substring(str, 0, length);
		}
		// 余白詰め
		return  StringUtils.rightPad(str, length, padword);
	}

	/**
	 * Long左余白詰め
	 *
	 * @param lng 入力Long
	 * @param length 文字数
	 * @param padword 詰める文字列
	 * @return
	 */
	public static String longLeftPad(Long lng, int length, String padword) {
		// NULLの場合
		if (lng == null) {
			return StringUtils.repeat(padword, length);
		}
		// 余白詰め
		String str = lng.toString();
		return  StringUtils.leftPad(str, length, padword);
	}

	/**
	 * Long右余白詰め
	 *
	 * @param lng 入力Long
	 * @param length 文字数
	 * @param padword 詰める文字列
	 * @return
	 */
	public static String longRightPad(Long lng, int length, String padword) {
		// NULLの場合
		if (lng == null) {
			return StringUtils.repeat(padword, length);
		}
		// 余白詰め
		String str = lng.toString();
		return  StringUtils.rightPad(str, length, padword);
	}

	/**
	 * BigDecimal余白詰め
	 *
	 * @param bigd 入力BigDecimal
	 * @param integerLength 整数部文字数
	 * @param decimalLength 小数部文字数
	 * @param padword 詰める文字列
	 * @return
	 */
	public static String bigDecimalPad(BigDecimal bigd, int integerLength, int decimalLength, String padword) {
		// NULLの場合
		if (bigd == null) {
			return StringUtils.repeat(padword, integerLength) + "." + StringUtils.repeat(padword, decimalLength);
		}
		// 余白詰め
		String formattext = StringUtils.repeat(padword, integerLength) + "." + StringUtils.repeat(padword, decimalLength);
		DecimalFormat format = new DecimalFormat(formattext);
		return format.format(bigd);
	}



}
