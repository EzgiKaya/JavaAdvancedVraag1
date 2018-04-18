package edu.ap.spring.model;
import edu.ap.spring.jpa.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class EightBall {

    @Autowired
    private QuestionRepository repository;
	
	private String[] answers = {"It is certain", 
								"Yes definitely", 
								"Most likely",
								"Outlook good",
								"Better not tell you now",
								"Cannot predict now",
								"Don't count on it", 
								"Outlook not so good"};
	
	public String getRandomAnswer(String question) {
		String answer = "";
		Random random = new Random();
		answer = answers[random.nextInt(answer.length()) - 1];

		return answer;
	}

	public String[] getAnswers() {
		return answers;
	}

	public void setAnswers(String[] answers) {
		this.answers = answers;
	}
}
