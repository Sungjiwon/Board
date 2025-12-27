package com.jws.boardapi.service;

import com.jws.boardapi.domain.Board;
import com.jws.boardapi.domain.BoardRepository;
import com.jws.boardapi.dto.request.BoardSaveRequest;
import com.jws.boardapi.dto.response.BoardResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {
  private static final Logger log = LoggerFactory.getLogger(BoardService.class);

  private final BoardRepository boardRepository;

  public List<BoardResponse> getAllBoards() {
    return boardRepository.findAll()
                          .stream()
                          .map(BoardResponse::from)
                          .collect(Collectors.toList());
  }

  public BoardResponse getBoardById(Long id) {
    Board board = boardRepository.findById(id)
      .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id : " + id));
    return BoardResponse.from(board);
  }

  // 3. 게시글 작성
  @Transactional // 쓰기 작업이므로 readOnly 해제
  public Long createBoard(BoardSaveRequest requestDto) {
    // DTO -> Entity 변환 후 저장
    return boardRepository.save(requestDto.toEntity()).getId();
  }

}
