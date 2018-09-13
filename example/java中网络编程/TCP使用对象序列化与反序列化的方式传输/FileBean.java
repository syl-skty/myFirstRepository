package TCP使用对象序列化与反序列化的方式传输;

import java.io.Serializable;

/**
 * 文件对象的实体类
 * 
 * @author 史永龙
 * 
 */
public class FileBean implements Serializable {
	private String fileName;// 文件名
	private long fileSize;// 文件大小（字节）
	private byte[] content;// 文件内容

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
