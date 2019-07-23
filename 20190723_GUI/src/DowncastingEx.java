
public class DowncastingEx {
	
	public static void main(String[] args) {
		Person p = new Student("ȫ�浿");
		Student s;
		
		s = (Student)p;
		
		System.out.println(s.name);
		
		s.grade= "A";
	}

}
