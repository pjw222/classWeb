package c231010;

public class HobbyBean {
	private String name;
	private int num;
	
	public HobbyBean(){}
	public HobbyBean(String name,int num){
		this.name=name;
		this.num=num;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getNum() {
		return num;
	}
}