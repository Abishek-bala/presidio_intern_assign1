package day16;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import day13.Examiner;
import day13.Question;

public class TakeQuiz {
	public static void main(String[] args) throws Exception{
		Examiner examiner =  (Examiner)Naming.lookup("rmi://localhost:2079/rmiService/quizDemo");
		ExecutorService es = Executors.newFixedThreadPool(2);
		Contestant c1 = new Contestant("A");
		es.execute(()->{
			LocalTime end = LocalTime.now().plus(5,ChronoUnit.SECONDS);
			while(LocalTime.now().compareTo(end)<=0) {
				//System.out.println(end);
			}
			
			System.out.println("marks of "+c1.name+" = "+c1.marks);
			System.exit(1);
		});
		es.execute(()->{
			try {
				c1.attendExam(examiner);
				System.out.println("marks of "+c1.name+" = "+c1.marks);
				System.exit(1);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		es.shutdown();
		
	}
	
	 
}

class Contestant{
	String name;
	int marks;
	
	public Contestant(String name) {
//		super();
		this.name = name;
	}
	
	public int getMarks() {
		return marks;
	}

	public void attendExam(Examiner exam) throws RemoteException {
		ArrayList<Question> questions = exam.get_quiestionPaper();
		Scanner s = new Scanner(System.in);
		Random randomGenerator = new Random();
		LocalTime end = LocalTime.now().plus(5,ChronoUnit.SECONDS);
		//System.out.println(lt + " " + end);
			//System.out.println(lt);
		System.out.println(questions);	
		while(questions.size()>0) {
				
				int index = randomGenerator.nextInt(questions.size());
		        Question q = questions.get(index);
				questions.remove(index);
				
				System.out.println("Question : "+q.qid+".. "+q.question);
				for(String opt: q.options.keySet()) {
					System.out.println("option"+opt+". "+q.options.get(opt));
				}
				System.out.println(q.answer);
				System.out.println("Enter the answer option");
				
				String ans = s.next();
			
				if(ans.equals(q.answer)) {
					System.out.println("correct answer!");
					marks++;
				}
				
				
		}
	
		
	
	
	}
	
}
