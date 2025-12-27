package com.jws.boardapi.dto.request;

import com.jws.boardapi.domain.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardSaveRequest {
  private String title;
  private String content;
  private String author;

  // DTO to Entity
  public Board toEntity() {
    return Board.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
  }

}
