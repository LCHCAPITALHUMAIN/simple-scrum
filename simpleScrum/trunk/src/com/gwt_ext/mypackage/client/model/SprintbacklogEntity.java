package com.gwt_ext.mypackage.client.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Basic;
import javax.persistence.Column;
import java.io.Serializable;


@Entity
@Table(schema = "CRDS", name = "SPRINTBACKLOG")
public class SprintbacklogEntity implements Serializable {
    private String backlogItemId;

    @Basic
    @Column(name = "Backlog Item ID")
    public String getBacklogItemId() {
        return backlogItemId;
    }

    public void setBacklogItemId(String backlogItemId) {
        this.backlogItemId = backlogItemId;
    }

    private String typetask2;

    @Basic
    @Column(name = "typeTask2")
    public String getTypetask2() {
        return typetask2;
    }

    public void setTypetask2(String typetask2) {
        this.typetask2 = typetask2;
    }

    private String userStory;

    @Basic
    @Column(name = "User Story")
    public String getUserStory() {
        return userStory;
    }

    public void setUserStory(String userStory) {
        this.userStory = userStory;
    }

    private String team;

    @Basic
    @Column(name = "Team")
    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    private String sprint;

    @Basic
    @Column(name = "Sprint #")
    public String getSprint() {
        return sprint;
    }

    public void setSprint(String sprint) {
        this.sprint = sprint;
    }

    private String crdsWebModuleSubModule;

    @Basic
    @Column(name = "CRDS Web Module Sub Module")
    public String getCrdsWebModuleSubModule() {
        return crdsWebModuleSubModule;
    }

    public void setCrdsWebModuleSubModule(String crdsWebModuleSubModule) {
        this.crdsWebModuleSubModule = crdsWebModuleSubModule;
    }

    private String budget;

    @Basic
    @Column(name = "Budget")
    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    private String task;

    @Basic
    @Column(name = "Task")
    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    private String estimate;

    @Basic
    @Column(name = "Estimate")
    public String getEstimate() {
        return estimate;
    }

    public void setEstimate(String estimate) {
        this.estimate = estimate;
    }

    private String discrepency;

    @Basic
    @Column(name = "Discrepency")
    public String getDiscrepency() {
        return discrepency;
    }

    public void setDiscrepency(String discrepency) {
        this.discrepency = discrepency;
    }

    private String remarks;

    @Basic
    @Column(name = "Remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    private String actual;

    @Basic
    @Column(name = "Actual")
    public String getActual() {
        return actual;
    }

    public void setActual(String actual) {
        this.actual = actual;
    }

    private String jiraTaskNumber;

    @Basic
    @Column(name = "Jira Task Number")
    public String getJiraTaskNumber() {
        return jiraTaskNumber;
    }

    public void setJiraTaskNumber(String jiraTaskNumber) {
        this.jiraTaskNumber = jiraTaskNumber;
    }

    private String status;

    @Basic
    @Column(name = "Status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String metric;

    @Basic
    @Column(name = "Metric")
    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    private String day1;

    @Basic
    @Column(name = "Day 1")
    public String getDay1() {
        return day1;
    }

    public void setDay1(String day1) {
        this.day1 = day1;
    }

    private String day2;

    @Basic
    @Column(name = "Day 2")
    public String getDay2() {
        return day2;
    }

    public void setDay2(String day2) {
        this.day2 = day2;
    }

    private String day3;

    @Basic
    @Column(name = "Day 3")
    public String getDay3() {
        return day3;
    }

    public void setDay3(String day3) {
        this.day3 = day3;
    }

    private String day4;

    @Basic
    @Column(name = "Day 4")
    public String getDay4() {
        return day4;
    }

    public void setDay4(String day4) {
        this.day4 = day4;
    }

    private String day5;

    @Basic
    @Column(name = "Day 5")
    public String getDay5() {
        return day5;
    }

    public void setDay5(String day5) {
        this.day5 = day5;
    }

    private String day6;

    @Basic
    @Column(name = "Day 6")
    public String getDay6() {
        return day6;
    }

    public void setDay6(String day6) {
        this.day6 = day6;
    }

    private String day7;

    @Basic
    @Column(name = "Day 7")
    public String getDay7() {
        return day7;
    }

    public void setDay7(String day7) {
        this.day7 = day7;
    }

    private String day8;

    @Basic
    @Column(name = "Day 8")
    public String getDay8() {
        return day8;
    }

    public void setDay8(String day8) {
        this.day8 = day8;
    }

    private String day9;

    @Basic
    @Column(name = "Day 9")
    public String getDay9() {
        return day9;
    }

    public void setDay9(String day9) {
        this.day9 = day9;
    }

    private String day10;

    @Basic
    @Column(name = "Day 10")
    public String getDay10() {
        return day10;
    }

    public void setDay10(String day10) {
        this.day10 = day10;
    }

    private String dhanya;

    @Basic
    @Column(name = "Dhanya")
    public String getDhanya() {
        return dhanya;
    }

    public void setDhanya(String dhanya) {
        this.dhanya = dhanya;
    }

    private String kunal;

    @Basic
    @Column(name = "Kunal")
    public String getKunal() {
        return kunal;
    }

    public void setKunal(String kunal) {
        this.kunal = kunal;
    }

    private String sourabh;

    @Basic
    @Column(name = "Sourabh")
    public String getSourabh() {
        return sourabh;
    }

    public void setSourabh(String sourabh) {
        this.sourabh = sourabh;
    }

    private String nazir;

    @Basic
    @Column(name = "Nazir")
    public String getNazir() {
        return nazir;
    }

    public void setNazir(String nazir) {
        this.nazir = nazir;
    }

    private String imad;

    @Basic
    @Column(name = "Imad")
    public String getImad() {
        return imad;
    }

    public void setImad(String imad) {
        this.imad = imad;
    }

    private String luciano;

    @Basic
    @Column(name = "Luciano")
    public String getLuciano() {
        return luciano;
    }

    public void setLuciano(String luciano) {
        this.luciano = luciano;
    }

    private String pranav;

    @Basic
    @Column(name = "Pranav")
    public String getPranav() {
        return pranav;
    }

    public void setPranav(String pranav) {
        this.pranav = pranav;
    }

    private String tushar;

    @Basic
    @Column(name = "Tushar")
    public String getTushar() {
        return tushar;
    }

    public void setTushar(String tushar) {
        this.tushar = tushar;
    }

    private String ashish;

    @Basic
    @Column(name = "Ashish")
    public String getAshish() {
        return ashish;
    }

    public void setAshish(String ashish) {
        this.ashish = ashish;
    }

    private String jphi;

    @Basic
    @Column(name = "Jphi")
    public String getJphi() {
        return jphi;
    }

    public void setJphi(String jphi) {
        this.jphi = jphi;
    }

    private String yann;

    @Basic
    @Column(name = "Yann")
    public String getYann() {
        return yann;
    }

    public void setYann(String yann) {
        this.yann = yann;
    }

    private String florent;

    @Basic
    @Column(name = "Florent")
    public String getFlorent() {
        return florent;
    }

    public void setFlorent(String florent) {
        this.florent = florent;
    }

    private String day1b;

    @Basic
    @Column(name = "Day 1b")
    public String getDay1b() {
        return day1b;
    }

    public void setDay1b(String day1b) {
        this.day1b = day1b;
    }

    private String day2b;

    @Basic
    @Column(name = "Day 2b")
    public String getDay2b() {
        return day2b;
    }

    public void setDay2b(String day2b) {
        this.day2b = day2b;
    }

    private String day3b;

    @Basic
    @Column(name = "Day 3b")
    public String getDay3b() {
        return day3b;
    }

    public void setDay3b(String day3b) {
        this.day3b = day3b;
    }

    private String day4b;

    @Basic
    @Column(name = "Day 4b")
    public String getDay4b() {
        return day4b;
    }

    public void setDay4b(String day4b) {
        this.day4b = day4b;
    }

    private String day5b;

    @Basic
    @Column(name = "Day 5b")
    public String getDay5b() {
        return day5b;
    }

    public void setDay5b(String day5b) {
        this.day5b = day5b;
    }

    private String day6b;

    @Basic
    @Column(name = "Day 6b")
    public String getDay6b() {
        return day6b;
    }

    public void setDay6b(String day6b) {
        this.day6b = day6b;
    }

    private String day7b;

    @Basic
    @Column(name = "Day 7b")
    public String getDay7b() {
        return day7b;
    }

    public void setDay7b(String day7b) {
        this.day7b = day7b;
    }

    private String day8b;

    @Basic
    @Column(name = "Day 8b")
    public String getDay8b() {
        return day8b;
    }

    public void setDay8b(String day8b) {
        this.day8b = day8b;
    }

    private String day9b;

    @Basic
    @Column(name = "Day 9b")
    public String getDay9b() {
        return day9b;
    }

    public void setDay9b(String day9b) {
        this.day9b = day9b;
    }

    private String day10b;

    @Basic
    @Column(name = "Day 10b")
    public String getDay10b() {
        return day10b;
    }

    public void setDay10b(String day10b) {
        this.day10b = day10b;
    }

    private String estimatesb;

    @Basic
    @Column(name = "Estimatesb")
    public String getEstimatesb() {
        return estimatesb;
    }

    public void setEstimatesb(String estimatesb) {
        this.estimatesb = estimatesb;
    }

    private String estimatesCompleted;

    @Basic
    @Column(name = "Estimates Completed")
    public String getEstimatesCompleted() {
        return estimatesCompleted;
    }

    public void setEstimatesCompleted(String estimatesCompleted) {
        this.estimatesCompleted = estimatesCompleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SprintbacklogEntity that = (SprintbacklogEntity) o;

        if (actual != null ? !actual.equals(that.actual) : that.actual != null) return false;
        if (ashish != null ? !ashish.equals(that.ashish) : that.ashish != null) return false;
        if (backlogItemId != null ? !backlogItemId.equals(that.backlogItemId) : that.backlogItemId != null)
            return false;
        if (budget != null ? !budget.equals(that.budget) : that.budget != null) return false;
        if (crdsWebModuleSubModule != null ? !crdsWebModuleSubModule.equals(that.crdsWebModuleSubModule) : that.crdsWebModuleSubModule != null)
            return false;
        if (day1 != null ? !day1.equals(that.day1) : that.day1 != null) return false;
        if (day10 != null ? !day10.equals(that.day10) : that.day10 != null) return false;
        if (day10b != null ? !day10b.equals(that.day10b) : that.day10b != null) return false;
        if (day1b != null ? !day1b.equals(that.day1b) : that.day1b != null) return false;
        if (day2 != null ? !day2.equals(that.day2) : that.day2 != null) return false;
        if (day2b != null ? !day2b.equals(that.day2b) : that.day2b != null) return false;
        if (day3 != null ? !day3.equals(that.day3) : that.day3 != null) return false;
        if (day3b != null ? !day3b.equals(that.day3b) : that.day3b != null) return false;
        if (day4 != null ? !day4.equals(that.day4) : that.day4 != null) return false;
        if (day4b != null ? !day4b.equals(that.day4b) : that.day4b != null) return false;
        if (day5 != null ? !day5.equals(that.day5) : that.day5 != null) return false;
        if (day5b != null ? !day5b.equals(that.day5b) : that.day5b != null) return false;
        if (day6 != null ? !day6.equals(that.day6) : that.day6 != null) return false;
        if (day6b != null ? !day6b.equals(that.day6b) : that.day6b != null) return false;
        if (day7 != null ? !day7.equals(that.day7) : that.day7 != null) return false;
        if (day7b != null ? !day7b.equals(that.day7b) : that.day7b != null) return false;
        if (day8 != null ? !day8.equals(that.day8) : that.day8 != null) return false;
        if (day8b != null ? !day8b.equals(that.day8b) : that.day8b != null) return false;
        if (day9 != null ? !day9.equals(that.day9) : that.day9 != null) return false;
        if (day9b != null ? !day9b.equals(that.day9b) : that.day9b != null) return false;
        if (dhanya != null ? !dhanya.equals(that.dhanya) : that.dhanya != null) return false;
        if (discrepency != null ? !discrepency.equals(that.discrepency) : that.discrepency != null) return false;
        if (estimate != null ? !estimate.equals(that.estimate) : that.estimate != null) return false;
        if (estimatesCompleted != null ? !estimatesCompleted.equals(that.estimatesCompleted) : that.estimatesCompleted != null)
            return false;
        if (estimatesb != null ? !estimatesb.equals(that.estimatesb) : that.estimatesb != null) return false;
        if (florent != null ? !florent.equals(that.florent) : that.florent != null) return false;
        if (imad != null ? !imad.equals(that.imad) : that.imad != null) return false;
        if (jiraTaskNumber != null ? !jiraTaskNumber.equals(that.jiraTaskNumber) : that.jiraTaskNumber != null)
            return false;
        if (jphi != null ? !jphi.equals(that.jphi) : that.jphi != null) return false;
        if (kunal != null ? !kunal.equals(that.kunal) : that.kunal != null) return false;
        if (luciano != null ? !luciano.equals(that.luciano) : that.luciano != null) return false;
        if (metric != null ? !metric.equals(that.metric) : that.metric != null) return false;
        if (nazir != null ? !nazir.equals(that.nazir) : that.nazir != null) return false;
        if (pranav != null ? !pranav.equals(that.pranav) : that.pranav != null) return false;
        if (remarks != null ? !remarks.equals(that.remarks) : that.remarks != null) return false;
        if (sourabh != null ? !sourabh.equals(that.sourabh) : that.sourabh != null) return false;
        if (sprint != null ? !sprint.equals(that.sprint) : that.sprint != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (task != null ? !task.equals(that.task) : that.task != null) return false;
        if (team != null ? !team.equals(that.team) : that.team != null) return false;
        if (tushar != null ? !tushar.equals(that.tushar) : that.tushar != null) return false;
        if (typetask2 != null ? !typetask2.equals(that.typetask2) : that.typetask2 != null) return false;
        if (userStory != null ? !userStory.equals(that.userStory) : that.userStory != null) return false;
        if (yann != null ? !yann.equals(that.yann) : that.yann != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = backlogItemId != null ? backlogItemId.hashCode() : 0;
        result = 31 * result + (typetask2 != null ? typetask2.hashCode() : 0);
        result = 31 * result + (userStory != null ? userStory.hashCode() : 0);
        result = 31 * result + (team != null ? team.hashCode() : 0);
        result = 31 * result + (sprint != null ? sprint.hashCode() : 0);
        result = 31 * result + (crdsWebModuleSubModule != null ? crdsWebModuleSubModule.hashCode() : 0);
        result = 31 * result + (budget != null ? budget.hashCode() : 0);
        result = 31 * result + (task != null ? task.hashCode() : 0);
        result = 31 * result + (estimate != null ? estimate.hashCode() : 0);
        result = 31 * result + (discrepency != null ? discrepency.hashCode() : 0);
        result = 31 * result + (remarks != null ? remarks.hashCode() : 0);
        result = 31 * result + (actual != null ? actual.hashCode() : 0);
        result = 31 * result + (jiraTaskNumber != null ? jiraTaskNumber.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (metric != null ? metric.hashCode() : 0);
        result = 31 * result + (day1 != null ? day1.hashCode() : 0);
        result = 31 * result + (day2 != null ? day2.hashCode() : 0);
        result = 31 * result + (day3 != null ? day3.hashCode() : 0);
        result = 31 * result + (day4 != null ? day4.hashCode() : 0);
        result = 31 * result + (day5 != null ? day5.hashCode() : 0);
        result = 31 * result + (day6 != null ? day6.hashCode() : 0);
        result = 31 * result + (day7 != null ? day7.hashCode() : 0);
        result = 31 * result + (day8 != null ? day8.hashCode() : 0);
        result = 31 * result + (day9 != null ? day9.hashCode() : 0);
        result = 31 * result + (day10 != null ? day10.hashCode() : 0);
        result = 31 * result + (dhanya != null ? dhanya.hashCode() : 0);
        result = 31 * result + (kunal != null ? kunal.hashCode() : 0);
        result = 31 * result + (sourabh != null ? sourabh.hashCode() : 0);
        result = 31 * result + (nazir != null ? nazir.hashCode() : 0);
        result = 31 * result + (imad != null ? imad.hashCode() : 0);
        result = 31 * result + (luciano != null ? luciano.hashCode() : 0);
        result = 31 * result + (pranav != null ? pranav.hashCode() : 0);
        result = 31 * result + (tushar != null ? tushar.hashCode() : 0);
        result = 31 * result + (ashish != null ? ashish.hashCode() : 0);
        result = 31 * result + (jphi != null ? jphi.hashCode() : 0);
        result = 31 * result + (yann != null ? yann.hashCode() : 0);
        result = 31 * result + (florent != null ? florent.hashCode() : 0);
        result = 31 * result + (day1b != null ? day1b.hashCode() : 0);
        result = 31 * result + (day2b != null ? day2b.hashCode() : 0);
        result = 31 * result + (day3b != null ? day3b.hashCode() : 0);
        result = 31 * result + (day4b != null ? day4b.hashCode() : 0);
        result = 31 * result + (day5b != null ? day5b.hashCode() : 0);
        result = 31 * result + (day6b != null ? day6b.hashCode() : 0);
        result = 31 * result + (day7b != null ? day7b.hashCode() : 0);
        result = 31 * result + (day8b != null ? day8b.hashCode() : 0);
        result = 31 * result + (day9b != null ? day9b.hashCode() : 0);
        result = 31 * result + (day10b != null ? day10b.hashCode() : 0);
        result = 31 * result + (estimatesb != null ? estimatesb.hashCode() : 0);
        result = 31 * result + (estimatesCompleted != null ? estimatesCompleted.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SprintbacklogEntity{" +
                "backlogItemId='" + backlogItemId + '\'' +
                ", typetask2='" + typetask2 + '\'' +
                ", userStory='" + userStory + '\'' +
                ", team='" + team + '\'' +
                ", sprint='" + sprint + '\'' +
                ", crdsWebModuleSubModule='" + crdsWebModuleSubModule + '\'' +
                ", budget='" + budget + '\'' +
                ", task='" + task + '\'' +
                ", estimate='" + estimate + '\'' +
                ", discrepency='" + discrepency + '\'' +
                ", remarks='" + remarks + '\'' +
                ", actual='" + actual + '\'' +
                ", jiraTaskNumber='" + jiraTaskNumber + '\'' +
                ", status='" + status + '\'' +
                ", metric='" + metric + '\'' +
                ", day1='" + day1 + '\'' +
                ", day2='" + day2 + '\'' +
                ", day3='" + day3 + '\'' +
                ", day4='" + day4 + '\'' +
                ", day5='" + day5 + '\'' +
                ", day6='" + day6 + '\'' +
                ", day7='" + day7 + '\'' +
                ", day8='" + day8 + '\'' +
                ", day9='" + day9 + '\'' +
                ", day10='" + day10 + '\'' +
                ", dhanya='" + dhanya + '\'' +
                ", kunal='" + kunal + '\'' +
                ", sourabh='" + sourabh + '\'' +
                ", nazir='" + nazir + '\'' +
                ", imad='" + imad + '\'' +
                ", luciano='" + luciano + '\'' +
                ", pranav='" + pranav + '\'' +
                ", tushar='" + tushar + '\'' +
                ", ashish='" + ashish + '\'' +
                ", jphi='" + jphi + '\'' +
                ", yann='" + yann + '\'' +
                ", florent='" + florent + '\'' +
                ", day1b='" + day1b + '\'' +
                ", day2b='" + day2b + '\'' +
                ", day3b='" + day3b + '\'' +
                ", day4b='" + day4b + '\'' +
                ", day5b='" + day5b + '\'' +
                ", day6b='" + day6b + '\'' +
                ", day7b='" + day7b + '\'' +
                ", day8b='" + day8b + '\'' +
                ", day9b='" + day9b + '\'' +
                ", day10b='" + day10b + '\'' +
                ", estimatesb='" + estimatesb + '\'' +
                ", estimatesCompleted='" + estimatesCompleted + '\'' +
                '}';
    }
}
