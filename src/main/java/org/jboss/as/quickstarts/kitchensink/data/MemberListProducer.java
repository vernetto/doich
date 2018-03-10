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
package org.jboss.as.quickstarts.kitchensink.data;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

import org.jboss.as.quickstarts.kitchensink.model.Member;
import org.jboss.as.quickstarts.kitchensink.model.Vocabulary;

@RequestScoped
public class MemberListProducer {

    @Inject
    private MemberRepository memberRepository;

    public void setVocabularies(List<Vocabulary> vocabularies) {
		this.vocabularies = vocabularies;
	}

	public void setFilteredVocabularies(List<Vocabulary> filteredVocabularies) {
		this.filteredVocabularies = filteredVocabularies;
	}

	private List<Member> members;
    private List<Vocabulary> vocabularies;
    private List<Vocabulary> filteredVocabularies;

    // @Named provides access the return value via the EL variable name "members" in the UI (e.g.
    // Facelets or JSP view)
    @Produces
    @Named
    public List<Member> getMembers() {
        return members;
    }
    
    @Produces
    @Named
    public List<Vocabulary> getVocabularies() {
        return vocabularies;
    }

    @Produces
    @Named
    public List<Vocabulary> getFilteredVocabularies() {
        return filteredVocabularies;
    }
    
    public void onMemberListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Member member) {
        retrieveAllMembersOrderedByName();
    }

    @PostConstruct
    public void retrieveAllMembersOrderedByName() {
        members = memberRepository.findAllOrderedByName();
        vocabularies = memberRepository.findAllVocabulary();
        System.out.println("vocabularies found " + vocabularies.size());
    }
}
