package org.jboss.as.quickstarts.kitchensink.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
@XmlRootElement
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "ID"), name = "WORDFILL")
public class WordFill implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	public WordFill() {
		super();
	}

	@NotNull
	@NotEmpty
	@Size(min = 1, max = 100)
	private String sentence;
	
	@Transient
	private String answer;

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public WordFill(Long id, String sentence) {
		super();
		this.id = id;
		this.sentence = sentence;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSentence() {
		return sentence;
	}

	public void setSentence(String sentence) {
		this.sentence = sentence;
	}

	@Override
	public String toString() {
		return "WordFill [id=" + id + ", sentence=" + sentence + "]";
	}

	public boolean isAnswerIsCorrect() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
