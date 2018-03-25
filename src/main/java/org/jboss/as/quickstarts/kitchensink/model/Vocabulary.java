/*
 * JBoss, Home of Professional Open Source
 * Copyright 2015, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.as.quickstarts.kitchensink.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "ID"), name = "VOCABULARY")
public class Vocabulary implements Serializable {

	public Vocabulary(Long id, String name, VocabularyGenre genre, VocabularyType type, String translation) {
		super();
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.type = type;
		this.translation = translation;
	}

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@NotEmpty
	@Size(min = 1, max = 50)
	private String name;

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
