package 动态代理;

public class BookImp implements Book {

	@Override
	public void addBook(String name) {
		System.out.println("我在添加书本" + name);
	}

	@Override
	public void deleteBook() {
		System.out.println("我在删除书本");
	}

}
