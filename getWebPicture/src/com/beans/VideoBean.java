package com.beans;

import java.util.List;

public class VideoBean {
	private String m3u8Url;
	private List<String> allTsUrlList;
	private String videoName;

	public String getM3u8Url() {
		return m3u8Url;
	}

	public void setM3u8Url(String m3u8Url) {
		this.m3u8Url = m3u8Url;
	}

	public List<String> getAllTsUrlList() {
		return allTsUrlList;
	}

	public void setAllTsUrlList(List<String> allTsUrlList) {
		this.allTsUrlList = allTsUrlList;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

}
