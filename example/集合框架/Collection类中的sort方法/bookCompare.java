package Collection���е�sort����;

//����book���µıȽϹ���
//ʵ��Comparator�ӿڣ��Զ������
import java.util.Comparator;

public class bookCompare implements Comparator<book> {

	@Override
	public int compare(book o1, book o2) {
		// TODO Auto-generated method stub
		return ((Integer) o1.num).compareTo(o2.num);
	}

}
