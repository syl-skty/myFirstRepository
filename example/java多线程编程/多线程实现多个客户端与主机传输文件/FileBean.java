package ���߳�ʵ�ֶ���ͻ��������������ļ�;

import java.io.Serializable;

public class FileBean implements Serializable {
	private String fileName;
	private long fileSize;
	private byte[] content;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

}
