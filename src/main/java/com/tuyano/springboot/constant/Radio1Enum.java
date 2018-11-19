package com.tuyano.springboot.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Radio1Enum {

  ラジオ1("1", "ラジオ1表示"),
  ラジオ2("2", "ラジオ2表示"),
  ラジオ3("3", "ラジオ3表示");

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
	private Radio1Enum(String code, String label) {
		this.code = code;
		this.label = label;
	}

}