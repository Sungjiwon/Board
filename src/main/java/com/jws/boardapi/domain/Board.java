package com.jws.boardapi.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "`BOARD`")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "BOARD_ID")
  private Long id;

  @Column(name = "TITLE", length = 50, nullable = false)
  private String title;

  @Lob // longtext 매핑을 위해 추가
  @Column(name = "CONTENT", nullable = false, columnDefinition = "LONGTEXT")
  private String content;

  @Column(name = "AUTHOR", length = 20, nullable = false)
  private String author;

  @Column(name = "VIEW_COUNT", nullable = false)
  private int viewCount = 0;

  @Column(name = "CREATED_AT", nullable = false, updatable = false)
  private LocalDateTime createdAt = LocalDateTime.now();

  // 비즈니스 로직 (조회수 증가 등)
  public void incrementViewCount() {
    this.viewCount++;
  }
}
