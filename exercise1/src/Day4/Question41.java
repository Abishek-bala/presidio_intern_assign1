package Day4;

public class Question41 {
	public static void main(String[] args) {
		Student s1 =new Student("A",1);
		Student s2 =new Student("B",2);
		Exam e1 = new Exam(s1,10,20,30);
		Exam e2 = new Exam(s2,20,20,40);
		Result r1 = new Result(s1,e1);
		Result r2 = new Result(s2,e2);
		
		r1.dispres();
		r2.dispres();
		//r3.dispres();
	}
}

class Student{
	protected String name;
	protected int roll_no;
	Student(String s,int r_no){
		name = s;
		roll_no = r_no;
	}
}

class Exam extends Student{
	protected int m,p,c;
	Exam(Student s,int m ,int p, int c){
		super(s.name,s.roll_no);
		this.m=m;
		this.p=p;
		this.c=c;
	}
}

class Result extends Exam{
	public int res;
	public String name;
	Result(Student s,Exam e){
		super(s,e.m,e.p,e.c);
		res = e.p+e.m+e.c;
		name = s.name;
	}
	
	public void dispres() {
		System.out.println("result of "+ name +" = " +res);
	}
	
}
