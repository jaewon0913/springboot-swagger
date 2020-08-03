package com.example.swagger.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.swagger.model.Board;

@Service(value = "boardService")
public class BoardServiceImpl implements BoardService{

	private List<Board> boards = new ArrayList<>();
	{
		int no = 1;
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
		Board maxBoard = boards.parallelStream()
				.max((m1, m2) -> Integer.compare(m1.getBoardNo(), m2.getBoardNo()))
				.orElse(null);
		
		int no = 1;
		if(maxBoard != null) {
			no = maxBoard.getBoardNo() + 1;
		}
		
		board.setBoardNo(no);
		boards.add(board);
		
		return true;
	}
	
	@Override
	public boolean updateBoard(Board board) {
		Board obj = boards.stream()
				.filter(m -> m.getBoardNo() == board.getBoardNo())
				.findFirst().get();
		
		if(board != null) {
			obj.setTitle(board.getTitle());
			obj.setContent(board.getContent());
		}
		
		return true;
	}

	@Override
	public boolean deleteBoardByBoardNo(int boardNo) {
		Board obj = boards.parallelStream()
				.filter(m -> m.getBoardNo() == boardNo)
				.findFirst().orElse(null);
		
		if (obj != null) {
			boards.remove(obj);
			
			return true;
		} else {
			return false;
		}
	}

}
