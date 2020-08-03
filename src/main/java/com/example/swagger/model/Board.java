package com.example.swagger.model;

import java.beans.ConstructorProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {
	
	private int boardNo;
	private String title;
	private String content;
	
	public Board() {}
	
	@ConstructorProperties({"boardNo", "title", "content"})
	public Board(int boardNo, String title, String content) {
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
	}

}
