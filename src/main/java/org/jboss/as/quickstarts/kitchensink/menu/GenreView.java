package org.jboss.as.quickstarts.kitchensink.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.jboss.as.quickstarts.kitchensink.data.MemberRepository;
import org.jboss.as.quickstarts.kitchensink.model.Vocabulary;
import org.jboss.as.quickstarts.kitchensink.model.VocabularyGenre;


@ManagedBean(name="genreView")
@ViewScoped
public class GenreView {

	@ManagedProperty("#{memberRepository}")
    private MemberRepository memberRepository;
	@ManagedProperty("#{genreRules}")
    private GenreRules genreRules;
	  
	private List<TestGenre> nouns;
	private List<TestGenre> filteredTest;
	
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
    	//nouns.add(new Vocabulary(1L, "A", VocabularyGenre.M, VocabularyType.NOUN, "bla"));
    	List<Vocabulary> vocabularies = memberRepository.findVocabularyNoun();
    	for (Vocabulary vocabulary : vocabularies) {
    		TestGenre genre = new TestGenre();
    		genre.setId(vocabulary.getId());
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
