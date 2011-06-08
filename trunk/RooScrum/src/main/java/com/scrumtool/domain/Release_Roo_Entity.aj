// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.scrumtool.domain;

import com.scrumtool.domain.Release;
import java.lang.Integer;
import java.lang.Long;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Version;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Release_Roo_Entity {
    
    declare @type: Release: @Entity;
    
    @PersistenceContext
    transient EntityManager Release.entityManager;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Release.id;
    
    @Version
    @Column(name = "version")
    private Integer Release.version;
    
    public Long Release.getId() {
        return this.id;
    }
    
    public void Release.setId(Long id) {
        this.id = id;
    }
    
    public Integer Release.getVersion() {
        return this.version;
    }
    
    public void Release.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void Release.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Release.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Release attached = Release.findRelease(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Release.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Release.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Release Release.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Release merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager Release.entityManager() {
        EntityManager em = new Release().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Release.countReleases() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Release o", Long.class).getSingleResult();
    }
    
    public static List<Release> Release.findAllReleases() {
        return entityManager().createQuery("SELECT o FROM Release o", Release.class).getResultList();
    }
    
    public static Release Release.findRelease(Long id) {
        if (id == null) return null;
        return entityManager().find(Release.class, id);
    }
    
    public static List<Release> Release.findReleaseEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Release o", Release.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
