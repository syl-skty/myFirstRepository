package 自定义注解;

public class Apple {
	@Fruit(fruitColor = "red", fruitName = "红富士", fruitProvider = "日本")
	public Fruit fruit;

	public Apple() {
	}

	@Fruit(fruitColor = "red", fruitName = "红富士", fruitProvider = "山东烟台")
	public Apple(String name, String color, String provider) {

	}

	// 使用注解时，在对应要使用的位置上方使用自定义注解的类的名字，后面跟括号，在里面对其属性进行赋值，那些设置了默认值的属性可以省略
	@Fruit(fruitName = "三全", fruitProvider = "日本")
	public void message() {

	}

}
