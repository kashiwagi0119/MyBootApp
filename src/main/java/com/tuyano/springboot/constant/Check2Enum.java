package com.tuyano.springboot.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Check2Enum {

  チェック21("1", "チェック21表示"),
  チェック22("2", "チェック22表示"),
  チェック23("3", "チェック23表示");

  private final String code;
  private final String label;
}