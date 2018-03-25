package org.jboss.as.quickstarts.kitchensink.menu;

import java.io.Serializable;

public class TestGenre implements Serializable {
	private Long id;
	private int index;
	private boolean answerIsCorrect;

	public boolean isAnswerIsCorrect() {
		return getAnswer() != null && getCorrectAnswer() != null && getAnswer().equals(getCorrectAnswer());
	}

	public void setAnswerIsCorrect(boolean answerIsCorrect) {
		this.answerIsCorrect = answerIsCorrect;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}



	private String name;
	private String answer;
	private String correctAnswer;
	private String genre;

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

/*	public boolean isAnswerCorrect() {
		isAnswerCorrect = getAnswer() != null && getCorrectAnswer() != null && getAnswer().equals(getCorrectAnswer());
		return isAnswerCorrect;
	}*/


}
