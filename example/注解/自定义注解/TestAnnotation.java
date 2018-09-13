package 自定义注解;

public class TestAnnotation {

	public static void main(String[] args) throws Exception {
		AnnotationUtil.getAnnotation(Apple.class, Fruit.class);
	}

}
