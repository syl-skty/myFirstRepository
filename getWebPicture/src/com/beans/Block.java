package com.beans;

public class Block {
	public int start;// 视频块在存储列表中的起始起始位置索引
	public int end;// 视频块在存储列表中的结束位置索引
	public int blockNum;// 视频块在整个块数组中的索引位置

	public Block(int start, int end, int blockNum) {
		super();
		this.start = start;
		this.end = end;
		this.blockNum = blockNum;
	}

}
