package com.tuyano.springboot.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SelectEnum {
	SELECT1("1", "セレクトEnum1"),
	SELECT2("2", "セレクトEnum2"),
	SELECT3("3", "セレクトEnum3");

	private final String code;
	private final String label;
}