package edu.ap.spring.view;

import edu.ap.spring.model.EightBall;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class UI implements InitializingBean {

    @Autowired
    EightBall eightBall;

	@Override
	public void afterPropertiesSet() throws Exception {
		System.setProperty("java.awt.headless", "false");
	}

	private JFrame jFrame;
	private JLabel questionLabel, answer;
	private JTextField questionText;
	private JButton btnGetAnswer;
	private JPanel controlpanel;


	public UI() {}

	public void setupUI(){
	    jFrame = new JFrame("The Magnificent Eight-Ball");
	    jFrame.setLayout(new FlowLayout());

	    controlpanel = new JPanel();
	    controlpanel.setLayout(new GridLayout(3,2));

	    questionLabel = new JLabel("Ask your question mortal :");
	    questionText = new JTextField(15);

	    answer = new JLabel("");

        btnGetAnswer = new JButton();
	    btnGetAnswer.setText("What do you think o mighty Eight Ball?");
	    btnGetAnswer.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
                if( getQuestion().getText() != "" ){
                    setAnswer(eightBall.getRandomAnswer(getQuestion().getText()));
                }
            }
        });

	    controlpanel.add(questionLabel);
	    controlpanel.add(answer);
	    controlpanel.add(questionText);
	    controlpanel.add(btnGetAnswer);

        jFrame.add(controlpanel);

	    jFrame.setSize(400,400);
	    jFrame.setLocationRelativeTo(null);
	    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    jFrame.pack();
	    jFrame.setVisible(true);
    }

    public JFrame getjFrame() {
        return this.jFrame;
    }

    public JTextField getQuestion() { return this.questionText ;}

    public void setAnswer(String answer){
	    this.answer.setText(answer);
    }

}
