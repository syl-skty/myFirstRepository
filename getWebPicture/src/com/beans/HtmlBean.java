package com.beans;

import java.util.Set;

public class HtmlBean {

	private String webUrl;// ��վ��ַ
	private String webHtml;// ��վ��html�ļ�
	private Set<String> pictureUrls;// ��վ�а���������ͼƬ��Ӧ��url
	private Set<String> webUrls;// ��վ�а������������Ӷ�Ӧ��url
	private boolean beSearched = false;// ��ʶ��վ�Ƿ�������
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
