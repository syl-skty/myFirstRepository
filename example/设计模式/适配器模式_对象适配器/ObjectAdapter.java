package ������ģʽ_����������;

/**
 * ����������ģʽ��������������������ͬ������ʵ�ּ����һ���޷��޸ĵ�ĳ����ʵ��ָ���Ľӿڵ�Ч��
 * 
 * ��ͬ���ǣ�����������ͨ������������̳�Դ��ͬʱʵ��ָ���ӿڣ�
 * 
 * ������������ͨ������������ʵ��ָ���ӿڣ�ͬʱ�����������м���һ��Դ��Ķ���
 * 
 * @author skty
 *
 */
public class ObjectAdapter implements Target {

	// ʹ�ö���������ģʽ�����������������һ��Դ���еĶ���
	private Source source;

	/**
	 * ͨ�����캯��ʵ�ֳ�ʼ��Դ�����
	 * 
	 * @param source
	 */
	public ObjectAdapter(Source source) {
		this.source = source;
	}

	@Override
	public void doWork() {
		// ��ʵ�ֵĶ�Ӧ�Ľӿڷ�����ʹ��Դ����������ö�Ӧ�ķ���
		source.doSourceWork();
	}

	@Override
	public void method() {
		source.doMethod();
	}

}
