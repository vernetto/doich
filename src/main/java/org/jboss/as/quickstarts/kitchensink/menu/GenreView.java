package org.jboss.as.quickstarts.kitchensink.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.xml.transform.stream.StreamSource;

import org.jboss.as.quickstarts.kitchensink.data.MemberRepository;
import org.jboss.as.quickstarts.kitchensink.model.Vocabulary;
import org.jboss.as.quickstarts.kitchensink.model.VocabularyGenre;

@ManagedBean(name = "genreView")
@ViewScoped
public class GenreView {

	@ManagedProperty("#{memberRepository}")
	private MemberRepository memberRepository;
	@ManagedProperty("#{genreRules}")
	private GenreRules genreRules;

	private List<TestGenre> nouns;
	private List<TestGenre> filteredTest;
	
	private boolean showGenre = false;
	private boolean showCorrectAnswer = false;
	
	private long total;
	private long totalCorrect;
	private long totalWrong;
	private long correctPercentage;
	

	public int getTotal() {
		return nouns.size();
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public long getTotalCorrect() {
		return nouns.stream().filter(noun -> noun.isAnswerIsCorrect()).count();
	}

	public void setTotalCorrect(long totalCorrect) {
		this.totalCorrect = totalCorrect;
	}

	public long getTotalWrong() {
		return nouns.stream().filter(noun -> !noun.isAnswerIsCorrect()).count();
	}

	public void setTotalWrong(long totalWrong) {
		this.totalWrong = totalWrong;
	}

	public long getCorrectPercentage() {
		return (getTotal() > 0 ? getTotalCorrect() * 100 / getTotal() : 0) ;
	}

	public void setCorrectPercentage(long correctPercentage) {
		this.correctPercentage = correctPercentage;
	}

	public MemberRepository getMemberRepository() {
		return memberRepository;
	}

	public GenreRules getGenreRules() {
		return genreRules;
	}

	public boolean isShowGenre() {
		return showGenre;
	}

	public void setShowGenre(boolean showGenre) {
		this.showGenre = showGenre;
	}

	public boolean isShowCorrectAnswer() {
		return showCorrectAnswer;
	}

	public void setShowCorrectAnswer(boolean showCorrectAnswer) {
		this.showCorrectAnswer = showCorrectAnswer;
	}

	public List<TestGenre> getFilteredTest() {
		return filteredTest;
	}

	public void setFilteredTest(List<TestGenre> filteredTest) {
		this.filteredTest = filteredTest;
	}

	@PostConstruct
	public void init() {
		System.out.println("GenreView init");
		nouns = new ArrayList<TestGenre>();
		// nouns.add(new Vocabulary(1L, "A", VocabularyGenre.M, VocabularyType.NOUN,
		// "bla"));
		List<Vocabulary> vocabularies = memberRepository.findVocabularyNoun();
		int index = 0;
		for (Vocabulary vocabulary : vocabularies) {
			TestGenre genre = new TestGenre();
			genre.setId(vocabulary.getId());
			genre.setIndex(++index);
			genre.setAnswer("");
			genre.setCorrectAnswer(genreRules.derdiedas(vocabulary));
			genre.setName(vocabulary.getName());
			VocabularyGenre genre2 = vocabulary.getGenre();
			genre.setGenre(genre2 != null ? genre2.name() : "");
			nouns.add(genre);
		}
		System.out.println("GenreView init, nouns retrieved " + nouns.size());
	}

	public List<TestGenre> getNouns() {
		return nouns;
	}

	public void setNouns(List<TestGenre> nouns) {
		this.nouns = nouns;
	}

	public void setMemberRepository(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public void setGenreRules(GenreRules genreRules) {
		this.genreRules = genreRules;
	}

	public List<String> getDerdiedas() {
		return Arrays.asList("der", "die", "das");
	}

}
