package TCPʹ�ö������л��뷴���л��ķ�ʽ����;

import java.io.Serializable;

/**
 * �ļ������ʵ����
 * 
 * @author ʷ����
 * 
 */
public class FileBean implements Serializable {
	private String fileName;// �ļ���
	private long fileSize;// �ļ���С���ֽڣ�
	private byte[] content;// �ļ�����

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
