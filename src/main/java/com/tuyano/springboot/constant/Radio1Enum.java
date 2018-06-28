package com.tuyano.springboot.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Radio1Enum {

  ラジオ1("1", "ラジオ1表示"),
  ラジオ2("2", "ラジオ2表示"),
  ラジオ3("3", "ラジオ3表示");

  private final String code;
  private final String label;
}