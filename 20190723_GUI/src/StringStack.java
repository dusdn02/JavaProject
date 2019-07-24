public class StringStack implements Stack{
	private String[] element;//������ ���� �޸�
	private int top;
	public StringStack(int capacity){
		element = new String[capacity];
		top = -1;
	}
	public int length() {
		return top+1;
	}
	public int capacity() {
		return element.length;
	}
	public String pop() {
		if(top==-1) {
			return null;
		}
		String s = element[top];
		top--;
		return s;
	}
	public boolean push(String str) {
		if(top==element.length-1) {
			System.out.println("������ �� ��");
			return false;
		}else {
			element[++top]=str;
			return true;
		}
	}
}
