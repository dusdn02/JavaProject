
public class UpcastingEx {
	public static void main(String[] args) {
		Person p;
		Student s= new Student("ȫ�浿");
		p=s;
		
		System.out.println(p.name);
		
//		p.grade="A";
//		p.department = "Com";
	}

}
