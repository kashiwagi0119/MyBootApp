package com.tuyano.springboot.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Check2Enum {

  チェック21("1", "チェック21"),
  チェック22("2", "チェック22"),
  チェック23("3", "チェック23");

  private final String code;
  private final String label;
}