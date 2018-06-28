package com.tuyano.springboot;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Movie {

  スターウォーズ("star-wars", "スターウォーズ"),
  ローマの休日("roman-holiday", "ローマの休日"),
  トイストーリー("toy-story", "トイ・ストーリー");

  private final String code;
  private final String label;
}