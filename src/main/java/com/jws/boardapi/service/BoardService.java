package com.jws.boardapi.service;

import com.jws.boardapi.dto.BoardDTO;
import com.jws.boardapi.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
  private static final Logger log = LoggerFactory.getLogger(BoardService.class);
  private final BoardMapper boardMapper;

  public BoardDTO selectBoardById(Long id) {
    return boardMapper.selectBoardById( id )
                      .orElseThrow(() -> new IllegalArgumentException("not found"));
  }

  public List<BoardDTO> selectBoardList() {
    List<BoardDTO> list = boardMapper.selectBoardList();
    if( list.isEmpty() ) {
      System.out.println( "list is empty" );
      log.info( "list is empty" );

      return null;
    }
    return list;
  }
}
