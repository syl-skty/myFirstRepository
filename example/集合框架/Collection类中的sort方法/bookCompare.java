package Collection类中的sort方法;

//定义book的新的比较规则
//实现Comparator接口，自定义规则
import java.util.Comparator;

public class bookCompare implements Comparator<book> {

	@Override
	public int compare(book o1, book o2) {
		// TODO Auto-generated method stub
		return ((Integer) o1.num).compareTo(o2.num);
	}

}
