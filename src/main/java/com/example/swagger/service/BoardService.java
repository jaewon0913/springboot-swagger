package com.example.swagger.service;

import java.util.List;


import com.example.swagger.model.Board;

public interface BoardService {
	List<Board> getAllBoards();
	Board getBoardByBoardNo(int boardNo);
	boolean insertBoard(Board board);
	boolean deleteBoard(Board board);
	boolean updateBoard(Board board);
}
