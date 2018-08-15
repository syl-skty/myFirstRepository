package com.beans;

import java.util.Set;

public class HtmlBean {

	private String webUrl;// 网站地址
	private String webHtml;// 网站的html文件
	private Set<String> pictureUrls;// 网站中包含的所有图片对应的url
	private Set<String> webUrls;// 网站中包含的所有链接对应的url
	private boolean beSearched = false;// 表识网站是否被搜索过
	private VideoBean videos;

	@Override
	public int hashCode() {
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof HtmlBean)) {
			return false;
		}
		HtmlBean h = (HtmlBean) obj;
		if (!(this.webUrl).equals(h.webUrl)) {
			return false;
		}
		return true;
	}

	public VideoBean getVideos() {
		return videos;
	}

	public void setVideos(VideoBean videos) {
		this.videos = videos;
	}

	public boolean isBeSearched() {
		return beSearched;
	}

	public void setBeSearched(boolean beSearched) {
		this.beSearched = beSearched;
	}

	public String getWebHtml() {
		return webHtml;
	}

	public void setWebHtml(String webHtml) {
		this.webHtml = webHtml;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public Set<String> getWebUrls() {
		return webUrls;
	}

	public void setWebUrls(Set<String> webUrls) {
		this.webUrls = webUrls;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public Set<String> getPictureUrls() {
		return pictureUrls;
	}

	public void setPictureUrls(Set<String> pictureUrls) {
		this.pictureUrls = pictureUrls;
	}

}
