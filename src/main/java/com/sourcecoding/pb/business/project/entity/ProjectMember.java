/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sourcecoding.pb.business.project.entity;

import com.sourcecoding.pb.business.individuals.entity.Individual;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Matthias
 */
@Entity
@NamedQueries({
    @NamedQuery(name = ProjectMember.findByDateRange, query = "SELECT pm FROM ProjectMember pm WHERE pm.projectInformation = :" + ProjectMember.queryParam_project + " AND pm.individual = :" + ProjectMember.queryParam_individual + " AND pm.memberFrom <= :" + ProjectMember.queryParam_date + " AND pm.memberTo > :" + ProjectMember.queryParam_date)})
public class ProjectMember implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String findByDateRange = "ProjectMember#findByDateRange";
    public static final String queryParam_individual = "individual";
    public static final String queryParam_date = "memberDate";
    public static final String queryParam_project = "project";

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private ProjectInformation projectInformation;

    @ManyToOne
    private Individual individual;

    private BigDecimal price;

    @Temporal(TemporalType.DATE)
    private Date memberFrom;

    @Temporal(TemporalType.DATE)
    private Date memberTo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProjectInformation getProjectInformation() {
        return projectInformation;
    }

    public void setProjectInformation(ProjectInformation projectInformation) {
        this.projectInformation = projectInformation;
    }

    public Individual getIndividual() {
        return individual;
    }

    public void setIndividual(Individual individual) {
        this.individual = individual;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getMemberFrom() {
        return memberFrom;
    }

    public void setMemberFrom(Date memberFrom) {
        this.memberFrom = memberFrom;
    }

    public Date getMemberTo() {
        return memberTo;
    }

    public void setMemberTo(Date memberTo) {
        this.memberTo = memberTo;
    }

}
