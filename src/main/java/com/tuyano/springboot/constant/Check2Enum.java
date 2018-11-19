package com.tuyano.springboot.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Check2Enum {

  チェック21("1", "チェック21"),
  チェック22("2", "チェック22"),
  チェック23("3", "チェック23");

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
	private Check2Enum(String code, String label) {
		this.code = code;
		this.label = label;
	}
}