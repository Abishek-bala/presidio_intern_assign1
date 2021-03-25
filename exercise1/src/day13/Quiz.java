package day13;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Quiz {
	public static void main(String[] args) {
		Examiner e = new Exam(10);
		e.setQuestions();
		Contestant c1 = new Contestant("A");
		Timer timer = new Timer();
		
		ExecutorService es = Executors.newFixedThreadPool(2);
		es.execute(()->{
			LocalTime end = LocalTime.now().plus(5,ChronoUnit.SECONDS);
			while(LocalTime.now().compareTo(end)<=0) {
				//System.out.println(end);
			}
			
			System.out.println("marks of "+c1.name+" = "+c1.marks);
			System.exit(1);
		});
		es.execute(()->{
			c1.attendExam((Exam)e);
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

	public void attendExam(Exam exam) {
		this.marks = exam.Conduct_quiz();
	}
	
}

interface Examiner{
	public void setQuestions();
	public int Conduct_quiz();
}

class Question{
	int qid;
	String question;
	HashMap<String,String> options = new HashMap<String,String>();
	String answer;
	public Question(int qid, String question, HashMap<String, String> options, String answer) {
		super();
		this.qid = qid;
		this.question = question;
		this.options = options;
		this.answer = answer;
	}
	
	public Question() {
		// TODO Auto-generated constructor stub
	}
	
	
}

class Exam implements Examiner{
	private Random randomGenerator = new Random();
	int no_of_questions;
	ArrayList<Question> questions;// = new ArrayList<Question>();
	Scanner s = new Scanner(System.in);
	public Exam(int no_of_questions) {
//		super(qid, options, answer);
		this.no_of_questions = no_of_questions;
		questions = new ArrayList<Question>();

	}	

	
	@Override
	public void setQuestions(){
		for(int i = 0;i<no_of_questions;i++) {
			int id=i;
			String ques,ans;
			HashMap<String,String> opt = new HashMap<String, String>();
			System.out.println("enter question");
			ques = s.nextLine();
			System.out.println("Enter Option A");
			opt.put("A", s.nextLine());
			System.out.println("Enter Option B");
			opt.put("B", s.nextLine());
			System.out.println("Enter Option C");
			opt.put("C", s.nextLine());
			System.out.println("Enter Option D");
			opt.put("D", s.nextLine());
			
			System.out.println("Enter the correct option");
			ans = s.nextLine();
			questions.add(new Question(id, ques, opt, ans));
		}
	}

	
			
	@Override
	public int Conduct_quiz() {
		int marks=0;
		LocalTime end = LocalTime.now().plus(5,ChronoUnit.SECONDS);
		//System.out.println(lt + " " + end);
			//System.out.println(lt);
			while(questions.size()>0) {
				int index = randomGenerator.nextInt(questions.size());
		        Question q = questions.get(index);
				questions.remove(index);
				
				System.out.println("Question : "+q.qid+".. "+q.question);
				for(String opt: q.options.keySet()) {
					System.out.println("option"+opt+". "+q.options.get(opt));
				}
				
				System.out.println("Enter the answer option");
				
				String ans = s.next();
				
				if(ans.equals(q.answer)) {
					marks++;
				}
				
				
		}
	
		
		return marks;
	}
}

