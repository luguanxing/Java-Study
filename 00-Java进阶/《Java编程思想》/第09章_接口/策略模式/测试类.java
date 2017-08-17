package 策略模式;

public class 测试类 {

	public static void 指挥攻击(兵 某种兵, Object 目标) {
		某种兵.攻击(目标);
	}
	
	public static void main(String[] args) {
		兵[] 集团军 = {new 兵(), new 装甲兵(), new 火箭兵()};
		指挥攻击(集团军[0], "恐怖分子");
		指挥攻击(集团军[1], "反动分子");
		指挥攻击(集团军[2], "邪教分子");
	}

}
