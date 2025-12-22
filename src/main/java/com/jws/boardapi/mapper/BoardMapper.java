package com.jws.boardapi.mapper;

import com.jws.boardapi.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BoardMapper {
  Optional<BoardDTO> selectBoardById( Long id );
  List<BoardDTO> selectBoardList();
}
