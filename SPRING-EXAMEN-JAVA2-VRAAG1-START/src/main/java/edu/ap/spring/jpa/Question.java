package edu.ap.spring.jpa;

import javax.persistence.*;

@Entity
@Table(name = "Question")
public class Question {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column

    private String question;

    @Column
    private String answer;

    public Question() {}

    public Question(String question, String answer){
        this.question = question;
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
