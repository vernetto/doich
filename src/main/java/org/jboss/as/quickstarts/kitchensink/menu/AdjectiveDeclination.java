package org.jboss.as.quickstarts.kitchensink.menu;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.jboss.as.quickstarts.kitchensink.data.MemberRepository;

@ManagedBean(name = "genreView")
@ViewScoped
public class AdjectiveDeclination {

	@ManagedProperty("#{memberRepository}")
	private MemberRepository memberRepository;
	@ManagedProperty("#{grammarRules}")
	private GrammarRules grammarRules;
	public MemberRepository getMemberRepository() {
		return memberRepository;
	}
	public void setMemberRepository(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	public GrammarRules getGrammarRules() {
		return grammarRules;
	}
	public void setGrammarRules(GrammarRules grammarRules) {
		this.grammarRules = grammarRules;
	}
	
	

}
