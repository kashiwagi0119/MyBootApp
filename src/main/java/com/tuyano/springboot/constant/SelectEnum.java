package com.tuyano.springboot.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SelectEnum implements BaseEnum {


	/**
	 * 1 : 旧世代
	 */
	OLD_GENERATION("1", "旧")

	/**
	 * 2 : 現世代
	 */
	,CURRENT_GENERATION("2", "現")

	;

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
	 */
	private SelectEnum() {
	}

	/**
	 * コンストラクタ
	 * @param code コード
	 */
	private SelectEnum(String code) {
		this.code = code;
	}

	/**
	 * コンストラクタ
	 * @param code コード
	 */
	private SelectEnum(String code, String label) {
		this.code = code;
		this.label = label;
	}

	/**
	 * 指定されたEnum定数に対応するコードを返す
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * ラベルを取得する
	 */
	public String getLabel() {
		return this.label;
	}


}