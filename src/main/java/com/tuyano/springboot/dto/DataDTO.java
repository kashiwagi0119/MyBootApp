package com.tuyano.springboot.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class DataDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * データ1
	*/
	private String data1;

	/**
	 * データ2
	*/
	private String data2;

	/**
	 * データ3
	*/
	private String data3;

	/**
	 * データ1を返す。
	 * @return データ1
	 */
	public String getData1() {
		return data1;
	}

	/**
	 * データ1を設定する。
	 * @param data1 データ1
	 */
	public void setData1(String data1) {
		this.data1 = data1;
	}

	/**
	 * データ2を返す。
	 * @return データ2
	 */
	public String getData2() {
		return data2;
	}

	/**
	 * データ2を設定する。
	 * @param data2 データ2
	 */
	public void setData2(String data2) {
		this.data2 = data2;
	}

	/**
	 * データ3を返す。
	 * @return データ3
	 */
	public String getData3() {
		return data3;
	}

	/**
	 * データ3を設定する。
	 * @param data3 データ3
	 */
	public void setData3(String data3) {
		this.data3 = data3;
	}

	/**
	 * オブジェクトの文字列表現を返す。
	 * @return オブジェクトの文字列表現
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(" , ");
		sb.append("[data1=").append(getData1()).append("]");
		sb.append(" , ");
		sb.append("[data2=").append(getData2()).append("]");
		sb.append(" , ");
		sb.append("[data3=").append(getData3()).append("]");
		return sb.toString();
	}

}
