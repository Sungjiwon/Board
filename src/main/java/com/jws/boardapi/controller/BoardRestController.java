package com.jws.boardapi.controller;

import com.jws.boardapi.dto.request.BoardSaveRequest;
import com.jws.boardapi.dto.response.BoardResponse;
import com.jws.boardapi.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( value = "${api.base-path}/boards" )
@RequiredArgsConstructor
public class BoardRestController {
  private final BoardService boardService;

  @GetMapping
  public ResponseEntity<List<BoardResponse>> getAllBoards() {
    System.out.println("here is getBoards");
    return ResponseEntity.ok(boardService.getAllBoards());
  }

  @GetMapping( value = "/{id}" )
  public ResponseEntity<BoardResponse> getBoard(@PathVariable Long id ) {
    return ResponseEntity.ok(boardService.getBoardById(id));
  }

  @PostMapping
  public ResponseEntity<Long> createBoard(@RequestBody BoardSaveRequest request) {
    return ResponseEntity.ok(boardService.createBoard(request));
  }

  @PutMapping( value = "/{id}")
  public ResponseEntity<?> updateBoard() {
    return null;
  }

  @DeleteMapping( value = "/{id}")
  public ResponseEntity<?> deleteBoard() {
    return null;
  }
}
