
package org.jboss.as.quickstarts.kitchensink.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
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
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "ID"), name = "VOCABULARY")
public class Vocabulary implements Serializable {

	@Id
	@SequenceGenerator(name= "VOCABULARY_SEQUENCE", sequenceName = "VOCABULARY_SEQUENCE_ID", initialValue=1, allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="VOCABULARY_SEQUENCE")
	private Long id;

	@NotNull
	@NotEmpty
	@Size(min = 1, max = 50)
	private String name;

	
	@NotNull
	private Long repetitions;

	@NotNull
	private Long acquired;

	public Vocabulary(Long id, String name, Long repetitions, Long acquired, Date addedon, String answer,
			VocabularyGenre genre, VocabularyType type, String translation) {
		super();
		this.id = id;
		this.name = name;
		this.repetitions = repetitions;
		this.acquired = acquired;
		this.addedon = addedon;
		this.answer = answer;
		this.genre = genre;
		this.type = type;
		this.translation = translation;
	}

	public Long getRepetitions() {
		return repetitions;
	}

	public void setRepetitions(Long repetitions) {
		this.repetitions = repetitions;
	}

	public Long getAcquired() {
		return acquired;
	}

	public void setAcquired(int acquired) {
		this.acquired = Integer.toUnsignedLong(acquired);
	}
	
	public void setAcquired(Long acquired) {
		this.acquired = acquired;
	}

	public Date getAddedon() {
		return addedon;
	}

	public void setAddedon(Date addedon) {
		this.addedon = addedon;
	}

	@NotNull
	private Date addedon;
	
	@Transient
	private String answer;
	

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Vocabulary() {
		super();
	}

	@Enumerated(EnumType.STRING)
	private VocabularyGenre genre;

	@Enumerated(EnumType.STRING)
	private VocabularyType type;

	private String translation;

	public VocabularyGenre getGenre() {
		return genre;
	}

	public void setGenre(VocabularyGenre genre) {
		this.genre = genre;
	}

	public VocabularyType getType() {
		return type;
	}

	public void setType(VocabularyType type) {
		this.type = type;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
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

	public boolean isMasculine() {
		return getGenre() != null && getGenre().equals(VocabularyGenre.M);
	}

	public boolean isFeminine() {
		return getGenre() != null && getGenre().equals(VocabularyGenre.F);
	}

	public boolean isNeutrum() {
		return getGenre() != null && getGenre().equals(VocabularyGenre.N);
	}

}
