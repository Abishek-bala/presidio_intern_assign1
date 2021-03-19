package day9;

public class Quesiton3 {
	public static void main(String[] args) {
		Stack fs = new FixedStack(5);
		Stack ds = new DynamicStack(2);
		ds.push(1);
		ds.push(2);
		ds.push(3);
		System.out.println(ds.pop());
	}
}

interface Stack{
	public void push(int i);
	public int pop();
}

class FixedStack implements Stack{
	int size,top,satck[];
	public FixedStack(int size) {
		// TODO Auto-generated constructor stub
		this.size = size;
		top=-1;
		satck = new int[size];
	}
	@Override
	public void push(int i) {
		// TODO Auto-generated method stub
		top++;
		if(top<size) {
			
			//System.out.println(top+""+size+(top<size));
			satck[top] = i;
		}
		else {
			System.out.println("Stack full cannot insert");
		}
	}
	@Override
	public int pop() {
		// TODO Auto-generated method stub
		return this.satck[this.top];
	}
}

class DynamicStack implements Stack{
	int size,top,stack[];
	public DynamicStack(int size) {
		// TODO Auto-generated constructor stub
		this.size = size;
		top=-1;
		stack = new int[size];
	}
	@Override
	public void push(int i) {
		// TODO Auto-generated method stub
		top++;
		if(top<size) {
			
			System.out.println(top+""+size+(top<size));
			stack[top] = i;
		}
		else {
			System.out.println("Stack full increasing space..");
			stack = increasespace();
			size*=2;
			System.out.println(top+""+size);
			stack[top] = i;
		}
	}
	public int[] increasespace() {
		int[] newStack = new int[size*2];
		for(int i=0;i<size;i++) {
			newStack[i] =stack[i];
		}
		return newStack;
	}
	@Override
	public int pop() {
		// TODO Auto-generated method stub
		return this.stack[this.top];
	}
	
}