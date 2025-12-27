package com.jws.boardapi.dto.response;

import com.jws.boardapi.domain.Board;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BoardResponse {
  private Long id;
  private String title;
  private String content;
  private String author;
  private int viewCount;
  private LocalDateTime createdAt;

  // Entity to DTO (정적 팩토리 메서드 패턴)
  public static BoardResponse from(Board board) {
    return new BoardResponse(
      board.getId(),
      board.getTitle(),
      board.getContent(),
      board.getAuthor(),
      board.getViewCount(),
      board.getCreatedAt()
    );
  }
}