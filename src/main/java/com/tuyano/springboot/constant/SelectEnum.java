package com.tuyano.springboot.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SelectEnum {


	SELECT1("1", "セレクトEnum1"),
	SELECT2("2", "セレクトEnum2"),
	SELECT3("3", "セレクトEnum3");

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * コード
	 */
	private String code;

	/**
	 * ラベル
	 */
	private String label;

	/**
	 * コンストラクタ
	 * @param code コード
	 */
	private SelectEnum(String code, String label) {
		this.code = code;
		this.label = label;
	}


}