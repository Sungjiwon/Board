package com.jws.boardapi.controller;

import com.jws.boardapi.dto.BoardDTO;
import com.jws.boardapi.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping( value = "${path.url.prefix}" )
@RequiredArgsConstructor
public class BoardController {
  private final BoardService boardService;

  @GetMapping( value = "/{id}" )
  public String detail( @PathVariable Long id, Model model ) {
    System.out.println( "detail" );
    BoardDTO board = boardService.selectBoardById( id );
    model.addAttribute( "board", board );
    model.addAttribute( "test", "test" );

    return "board/detail";
  }

  @GetMapping( value = "/list" )
  public String list(Model model) {
    System.out.println("BoardController");
    List<BoardDTO> boardList = boardService.selectBoardList();
    model.addAttribute( "boardList", boardList );

    return "board/list";
  }
}

