package engine;

import java.util.ArrayList;
import java.util.HashMap;

public class Question {
	private String question;
	private String correctAnswer;
	private ArrayList<String> answer = new ArrayList<String>();//store the choices 
	private HashMap<String, String> choice = new HashMap<String, String>();//map the answer to each choice from arraylist
	private String[] choices = {"A", "B", "C", "D"};
	
//	public Question() {
//		mapQuestion();
//	}
	public String getSoal() {
		return question;
	}
	
	public String getA() {
		return answer.get(0);
	}
	public String getB() {
		return answer.get(1);
	}
	public String getC() {
		return answer.get(2);
	}
	public String getD() {
		return answer.get(3);
	}
	
	private void setQuest(String q) {//set question 
		question = q;
	}
	
	private void setCorrectAnswer(String a) {//set the correct answer
		correctAnswer = a;
	}
	
	private void setAnswer(String a, String b, String c, String d) {//set the choices from a to d
		answer.add(a);
		answer.add(b);
		answer.add(c);
		answer.add(d);
	}
	
	public void setQuestion(String q, String ca, String a, String b, String c, String d) {//set the whole question from question to answer
		setQuest(q);
		setCorrectAnswer(ca);
		setAnswer(a,b,c,d);
	}
	
	public void printQuestion() {//print the question
		
		System.out.println(question);
		for (int i = 0; i < answer.size(); i++) {
		  System.out.println(choices[i] + ". " + answer.get(i));
		  choice.put(choices[i], answer.get(i));
		}
	}
	
	public void mapQuestion() {
		for (int i = 0; i < answer.size(); i++) {
			  choice.put(choices[i], answer.get(i));
			}
		for(String a : choice.keySet()) {
			String key =a.toString();
            String value = choice.get(a).toString();  
            System.out.println(key + " " + value);  
		}
	}
	public boolean checkAnswer(String peopleAnswer) {//check the answer is it correct or not from user
		if(correctAnswer.compareTo(peopleAnswer) == 0) {
			return true;
		}
		return false;
	}
	
	public boolean insertAnswer(String a) {//insert user's answer
		return checkAnswer(choice.get(a));	
	}
}
