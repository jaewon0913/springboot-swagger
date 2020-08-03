package com.example.swagger.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.swagger.model.Board;

@Service(value = "boardService")
public class BoardServiceImpl implements BoardService{

	private List<Board> boards = new ArrayList<>();
	{
		int no = 0;
		boards.add(new Board(no++, "1번 제목", "1번글 내용"));
		boards.add(new Board(no++, "2번 제목", "2번글 내용"));
		boards.add(new Board(no++, "3번 제목", "3번글 내용"));
	}
	
	@Override
	public List<Board> getAllBoards() {
		return boards;
	}

	@Override
	public Board getBoardByBoardNo(int boardNo) {
		Board board = boards.stream()
				.filter(m -> m.getBoardNo() == boardNo)
				.findFirst().orElse(null);
		
		return board;
	}

	@Override
	public boolean insertBoard(Board board) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBoard(Board board) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateBoard(Board board) {
		// TODO Auto-generated method stub
		return false;
	}

}
