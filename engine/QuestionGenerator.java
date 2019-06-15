package engine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class QuestionGenerator {//this class is used to generate questions
	private ArrayList<Question> bank = new ArrayList<Question>();//arraylist to store questions
	private Scanner input = null;
	private int correct = 0;
	private int n = 30;
	private int[] randomQuestion;
	private Random rand = new Random();
	private HashSet<Integer> repo = new HashSet<Integer>();//set to store the answer
	private int flag = 0;
	
	public ArrayList<Question> getBank() {
		return bank;
	}
	public QuestionGenerator() {
		insertToBank();
		generate();
	}
	
	public void setn(Integer n) {
		this.n = n;
	}
	
	public int getLines() {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("src/resource/database_soal.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int lines = 0;
		try {
			while (reader.readLine() != null) lines++;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lines/6;
	}
	public ArrayList<Integer> gener(){
		ArrayList<Integer> reps = new ArrayList<Integer>();
		for(int i = 0; i < getLines(); i++) {
			int x = Math.abs(rand.nextInt()%getLines());
			if(reps.indexOf(x) == -1)
				reps.add(x);
		}
		return reps;
	}
	public int[] toInt(HashSet<Integer> set) {//insert set elements into int array
		  int[] a = new int[set.size()];
		  int i = 0;
		  for (Integer val : set) 
			  a[i++] = val;
		  return a;
		}
	
	public void generate() {//generate random question
		
		while(repo.size() < n) {
			int x = rand.nextInt(flag);
			repo.add(x);
		}
		this.randomQuestion = toInt(repo);
	}
	
	private void insertToBank() {//insert .txt file to arraylist
		try {
			input = new Scanner(new FileReader("src/resource/database_soal.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		for(int z = 0;; z++) {//infinite loop
			try {
				Question q = new Question();
				q.mapQuestion();
				q.setQuestion(input.nextLine(),input.nextLine(),input.nextLine(),input.nextLine(),input.nextLine(),input.nextLine());
				bank.add(q);
			}
			catch(NoSuchElementException e) {//stop when the .txt file empty
				flag = z;
				break;
			}
		}
	}
	
	public boolean insert(Question q, String a) {
		return q.insertAnswer(a);
	}
	
	public void printBank() {//print all questions
		Scanner sc = new Scanner(System.in);
		insertToBank();
		generate();
		for(int z = 0; z < n; z++) {
			Question x = bank.get(randomQuestion[z]);
			System.out.print(z+1 + ". ");
			x.printQuestion();
			System.out.print("Choice: ");
			if(x.insertAnswer(sc.nextLine())) 
				correct += 1;
			System.out.println();
		}
		sc.close();
	}
	
	public int getScore() {//get score
		return this.correct *100 / n;
	}
}
