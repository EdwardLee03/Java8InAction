package lambdasinaction.chap2;

/**
 * 变量作用域上下文
 *
 * 类上下文，实例上下文
 */
public class MeaningOfThis {
	public final int value = 4;

	public void doIt() {
		int value = 6;
		// 变量作用域上下文
		Runnable r = new Runnable(){
			public final int value = 5;
			public void run(){
				int value = 10;
				// this 引用匿名对象
				System.out.println(this.value);
			}
		};
		r.run(); 
	}

	public static void main(String...args) {
		MeaningOfThis m = new MeaningOfThis();
		// 5
		m.doIt(); // ???   
	}
}
