package _0722;

public class Goods {
	String name;
	int price;
	int numberOfStock;
	int sold;
	public Goods(String n, int p, int num, int s) {
		this.name=n;
		this.price=p;
		this.numberOfStock=num;
		this.sold=s;
	}
	
	String getName() {
		return name;
	}
	int getPrice() {
		return price;
	}
	int getNumber() {
		return numberOfStock;
	}
	int getSold() {
		return sold;
	}

	public static void main(String[] args) {
		Goods [] GoodArray = new Goods[3];
		GoodArray[0] = new Goods("candy", 2000, 200, 100);
		GoodArray[1] = new Goods("choco", 4000, 100, 80);
		GoodArray[2] = new Goods("macarong", 10000, 300, 800);
		
		for(int i=0; i<3; i++) {
			System.out.println(GoodArray[i].name);
			System.out.println(GoodArray[i].price);
			System.out.println(GoodArray[i].numberOfStock);
			System.out.println(GoodArray[i].sold);
			System.out.println();
		}

	}

}
