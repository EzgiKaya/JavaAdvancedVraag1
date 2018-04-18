package edu.ap.spring.model;
import edu.ap.spring.jpa.Question;
import edu.ap.spring.jpa.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

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

	private List<String> givenAnswers = new ArrayList<String>() ;
	
	public String getRandomAnswer(String question) {
		String answer = "";

		//Check if the question has been asked before
		Question foundQuestion = repository.findByQuestion(question);

		// If not, give a new random answer
		if(foundQuestion == null) {
		    // Initialise the random class
            Random random = new Random();

            // Get a random answer from our pool
            answer = answers[random.nextInt(answers.length)];
            while(givenAnswers != null && givenAnswers.contains(answer)){
                answer = answers[random.nextInt(answers.length)];
            }

            // Add the answer to the given answer pool
            givenAnswers.add(answer);

            // reset the given pool if full
            if(givenAnswers.size() == answers.length){
                givenAnswers = new ArrayList<String>();
            }

            //Save the question + answer
            Question newQuestion = new Question(question, answer);
            repository.save(newQuestion);

            // Remove the answer from the pool and reset the pool if it's empty

            return answer;
        }
        else{
		    // Return the answer for the question which has been asked already
		    return foundQuestion.getAnswer();
        }
	}

	public String[] getAnswers() {
		return answers;
	}

	public void setAnswers(String[] answers) {
		this.answers = answers;
	}
}
