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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.jboss.as.quickstarts.kitchensink.model.Member;
import org.jboss.as.quickstarts.kitchensink.model.Vocabulary;
import org.jboss.as.quickstarts.kitchensink.model.VocabularyType;

@ApplicationScoped
@ManagedBean(name = "memberRepository")
public class MemberRepository implements Serializable {

    @Inject
    private EntityManager em;
    
    public Member findById(Long id) {
        return em.find(Member.class, id);
    }

    public Member findByEmail(String email) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member> criteria = cb.createQuery(Member.class);
        Root<Member> member = criteria.from(Member.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(member).where(cb.equal(member.get(Member_.email), email));
        criteria.select(member).where(cb.equal(member.get("email"), email));
        return em.createQuery(criteria).getSingleResult();
    }

    public List<Member> findAllOrderedByName() {
        return new ArrayList<Member>();
    }
    
    public List<Vocabulary> findAllVocabulary() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Vocabulary> criteria = cb.createQuery(Vocabulary.class);
        Root<Vocabulary> vocabulary = criteria.from(Vocabulary.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
        criteria.select(vocabulary).orderBy(cb.asc(vocabulary.get("name")));
        List<Vocabulary> result = em.createQuery(criteria).getResultList();
        return result;
    }
    
    public List<Vocabulary> findVocabularyByType(VocabularyType type, int maxresult) {
    	System.out.printf("findVocabularyByType %s %s", type, maxresult);
    	List<Vocabulary> result = em.createQuery("SELECT v FROM Vocabulary v WHERE v.type LIKE :voctype", Vocabulary.class)
    		    .setParameter("voctype", type)
    		    .setMaxResults(maxresult)
    		    .getResultList();
    	return result;
    }
    
    public List<Vocabulary> findVocabularyNoun() {
    	return findVocabularyByType(VocabularyType.NOUN, 10);
    }
    
}
