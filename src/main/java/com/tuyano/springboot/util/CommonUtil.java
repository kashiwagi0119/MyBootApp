package com.tuyano.springboot.util;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

import com.tuyano.springboot.constant.BaseEnum;
import com.tuyano.springboot.dto.SelectItemDTO;


/**
 * 共通ユーティリティ
 */
public final class CommonUtil {

    /**
     * 日付チェック
     * @param strDate
     * @return 日付形式の場合、True
     */
    public static boolean checkDate(String strDate) {
        if (strDate == null || strDate.length() != 10) {
            return false;
        }
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        format.setLenient(false);
        try {
            format.parse(strDate);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 日付チェック
     * @param strDate
     * @return 日付形式の場合、True
     */
    public static boolean checkDateYYMMDD(String strDate) {
        if (strDate == null || strDate.length() != 6) {
            return false;
        }
        DateFormat format = new SimpleDateFormat("yyMMdd");
        format.setLenient(false);
        try {
            format.parse(strDate);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 日付形式変換 yyMMdd → yyyy/MM/dd
     * @param strDate
     * @return yyyy/MM/dd型式
     */
    public static String cnvDateYYMMDD_YYYYMMDD(String strDate) {
    	String result = strDate;
    	if (strDate.length() != 6) {
    		return result;
    	}
    	result = "20" + StringUtils.substring(strDate, 0, 2) + "/" + StringUtils.substring(strDate, 2, 4) + "/" + StringUtils.substring(strDate, 4, 6);
    	return result;
    }

    /**
     * 日付形式変換 yyyy/MM/dd → yyMMdd
     * @param strDate
     * @return yyMMdd型式
     */
    public static String cnvDateYYYYMMDD_YYMMDD(String strDate) {
    	String result = strDate;
    	if (strDate.length() != 10) {
    		return result;
    	}
    	result = StringUtils.substring(strDate, 2, 4) + StringUtils.substring(strDate, 5, 7) + StringUtils.substring(strDate, 8, 10);
    	return result;
    }

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
	 * 文字列（ファイル名）を環境に合わせた文字コードに変換する.
	 *
	 * @param str
	 * @return 文字列
	 */
	public static String convertStrToFileName(final String str) {
		StringBuffer tmpStr = new StringBuffer("attachment;filename=\"");
		byte[] name = null;
		try {
			name = str.getBytes("Shift_JIS");
			tmpStr.append(new String(name, "ISO8859_1"));
		} catch (UnsupportedEncodingException ue) {
			ue.printStackTrace();
		}

		tmpStr.append("\"");
		return tmpStr.toString();
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
