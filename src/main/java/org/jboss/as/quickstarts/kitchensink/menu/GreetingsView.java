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
import org.jboss.as.quickstarts.kitchensink.model.WordFill;

@ManagedBean(name = "greetingsView")
@ViewScoped
public class GreetingsView {

	@ManagedProperty("#{memberRepository}")
	private MemberRepository memberRepository;
	@ManagedProperty("#{grammarRules}")
	private GrammarRules grammarRules;

	private List<WordFill> wordfills;
	private List<WordFill> filteredWordfills;
	
	private boolean showCorrectAnswer = false;
	
	private long total;
	private long totalCorrect;
	private long totalWrong;
	private long correctPercentage;
	
	private String testInputMask = "Guten M";
	

	public List<WordFill> getFilteredWordfills() {
		return filteredWordfills;
	}

	public void setFilteredWordfills(List<WordFill> filteredWordfills) {
		this.filteredWordfills = filteredWordfills;
	}

	public String getTestInputMask() {
		return testInputMask;
	}

	public void setTestInputMask(String testInputMask) {
		this.testInputMask = testInputMask;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public int getTotal() {
		return wordfills.size();
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public long getTotalCorrect() {
		return wordfills.stream().filter(noun -> noun.isAnswerIsCorrect()).count();
	}

	public void setTotalCorrect(long totalCorrect) {
		this.totalCorrect = totalCorrect;
	}

	public long getTotalWrong() {
		return wordfills.stream().filter(noun -> !noun.isAnswerIsCorrect()).count();
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

	public GrammarRules getGrammarRules() {
		return grammarRules;
	}

	public boolean isShowCorrectAnswer() {
		return showCorrectAnswer;
	}

	public void setShowCorrectAnswer(boolean showCorrectAnswer) {
		this.showCorrectAnswer = showCorrectAnswer;
	}

	public List<WordFill> getFilteredTest() {
		return filteredWordfills;
	}

	public void setFilteredTest(List<WordFill> filteredTest) {
		this.filteredWordfills = filteredTest;
	}

	@PostConstruct
	public void init() {
		System.out.println("GreetingsView init");
		wordfills = memberRepository.findAllWordFill();
		System.out.println("GreetingsView init, wordfills retrieved " + wordfills.size());
	}

	public List<WordFill> getWordfills() {
		return wordfills;
	}

	public void setWordfills(List<WordFill> wordfills) {
		this.wordfills = wordfills;
	}

	public void setMemberRepository(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public void setGrammarRules(GrammarRules grammarRules) {
		this.grammarRules = grammarRules;
	}


}
