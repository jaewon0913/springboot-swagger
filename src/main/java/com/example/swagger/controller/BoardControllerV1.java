package com.example.swagger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.swagger.model.Board;
import com.example.swagger.service.BoardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "BoardController V1")
@RequestMapping("/v1/api")
public class BoardControllerV1 {
	
	@Autowired
	BoardService boardservice;
	
	@ApiOperation(value = "Board 전체 목록", notes = "Board 전체 목록을 조회")
	@GetMapping(value = "/board")
	public ResponseEntity<List<Board>> getAllMembers() {
		return new ResponseEntity<>(boardservice.getAllBoards(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Board 조회", notes ="BoardNo에 해당하는 특정 글 조회")
	@GetMapping(value = "/board/{boardNo}")
	public ResponseEntity<Board> getBoardByNo(
			@ApiParam(value="글 번호", required=true) @PathVariable("boardNo") int boardNo){
		
		//int intBoardNo = Integer.parseInt(boardNo);
		
		Board board = boardservice.getBoardByBoardNo(boardNo + 1);
		
		if(board != null) {
			return new ResponseEntity<>(board, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
