package com.jws.boardapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoardDTO {
  private String TITLE;
  private String CONTENT;
  private String WRITER;
  private String CREATED_AT;
}
