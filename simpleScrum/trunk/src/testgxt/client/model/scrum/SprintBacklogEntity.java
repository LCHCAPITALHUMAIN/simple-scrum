package testgxt.client.model.scrum;

import com.extjs.gxt.ui.client.data.BaseModel;

import javax.persistence.*;
import javax.annotation.Generated;
import java.io.Serializable;


@Entity
@Table(name="SPRINTBACKLOG")
public class SprintBacklogEntity extends BaseModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TaskUniqueID")
    public Long getTaskUniqueId() {
        return get("taskUniqueID");
    }

    public void setTaskUniqueId(Long taskUniqueId) {
        set("taskUniqueID",taskUniqueId);
    }

    @Basic
    @Column(name = "BacklogItemID")
    public String getBacklogItemId() {
        return get("backlogItemId");
    }

    public void setBacklogItemId(String backlogItemId) {
        set("backlogItemId",backlogItemId);
    }

    @Basic
    @Column(name = "typeTask2")
    public String getTypetask2() {
        return get("typetask2");
    }

    public void setTypetask2(String typetask2) {
        set("typetask2", typetask2);
    }


    @Basic
    @Column(name = "UserStory")
    public String getUserStory() {
        return get("userStory");
    }

    public void setUserStory(String userStory) {
        set("userStory", userStory);
    }


    @Basic
    @Column(name = "Team")
    public String getTeam() {
        return get("team");
    }

    public void setTeam(String team) {
        set("team", team);
    }


    @Basic
    @Column(name = "SprintNo")
    public String getSprint() {
        return get("sprint");
    }

    public void setSprint(String sprint) {
        set("sprint", sprint);
    }


    @Basic
    @Column(name = "CRDSWebModuleSubModule")
    public String getCrdsWebModuleSubModule() {
        return get("crdsWebModuleSubModule");
    }

    public void setCrdsWebModuleSubModule(String crdsWebModuleSubModule) {
        set("crdsWebModuleSubModule", crdsWebModuleSubModule);
    }


    @Basic
    @Column(name = "Budget")
    public String getBudget() {
        return get("budget");
    }

    public void setBudget(String budget) {
        set("budget", budget);
    }


    @Basic
    @Column(name = "Task")
    public String getTask() {
        return get("task");
    }

    public void setTask(String task) {
        set("task", task);
    }


    @Basic
    @Column(name = "Estimate")
    public String getEstimate() {
        return get("estimate");
    }

    public void setEstimate(String estimate) {
        set("estimate", estimate);
    }


    @Basic
    @Column(name = "Discrepency")
    public String getDiscrepency() {
        return get("discrepency");
    }

    public void setDiscrepency(String discrepency) {
        set("discrepency", discrepency);
    }


    @Basic
    @Column(name = "Remarks")
    public String getRemarks() {
        return get("remarks");
    }

    public void setRemarks(String remarks) {
        set("remarks", remarks);
    }


    @Basic
    @Column(name = "Actual")
    public String getActual() {
        return get("actual");
    }

    public void setActual(String actual) {
        set("actual", actual);
    }


    @Basic
    @Column(name = "JiraTaskNumber")
    public String getJiraTaskNumber() {
        return get("jiraTaskNumber");
    }

    public void setJiraTaskNumber(String jiraTaskNumber) {
        set("jiraTaskNumber", jiraTaskNumber);
    }


    @Basic
    @Column(name = "Status")
    public String getStatus() {
        return get("status");
    }

    public void setStatus(String status) {
        set("status", status);
    }


    @Basic
    @Column(name = "Metric")
    public String getMetric() {
        return get("metric");
    }

    public void setMetric(String metric) {
        set("metric", metric);
    }


    @Basic
    @Column(name = "Day1")
    public String getDay1() {
        return get("day1");
    }

    public void setDay1(String day1) {
        set("day1", day1);
    }


    @Basic
    @Column(name = "Day2")
    public String getDay2() {
        return get("day2");
    }

    public void setDay2(String day2) {
        set("day2", day2);
    }


    @Basic
    @Column(name = "Day3")
    public String getDay3() {
        return get("day3");
    }

    public void setDay3(String day3) {
        set("day3", day3);
    }


    @Basic
    @Column(name = "Day4")
    public String getDay4() {
        return get("day4");
    }

    public void setDay4(String day4) {
        set("day4", day4);
    }


    @Basic
    @Column(name = "Day5")
    public String getDay5() {
        return get("day5");
    }

    public void setDay5(String day5) {
        set("day5", day5);
    }


    @Basic
    @Column(name = "Day6")
    public String getDay6() {
        return get("day6");
    }

    public void setDay6(String day6) {
        set("day6", day6);
    }


    @Basic
    @Column(name = "Day7")
    public String getDay7() {
        return get("day7");
    }

    public void setDay7(String day7) {
        set("day7", day7);
    }


    @Basic
    @Column(name = "Day8")
    public String getDay8() {
        return get("day8");
    }

    public void setDay8(String day8) {
        set("day8", day8);
    }


    @Basic
    @Column(name = "Day9")
    public String getDay9() {
        return get("day9");
    }

    public void setDay9(String day9) {
        set("day9", day9);
    }


    @Basic
    @Column(name = "Day10")
    public String getDay10() {
        return get("day10");
    }

    public void setDay10(String day10) {
        set("day10", day10);
    }


    @Basic
    @Column(name = "Dhanya")
    public String getDhanya() {
        return get("dhanya");
    }

    public void setDhanya(String dhanya) {
        set("dhanya", dhanya);
    }


    @Basic
    @Column(name = "Kunal")
    public String getKunal() {
        return get("kunal");
    }

    public void setKunal(String kunal) {
        set("kunal", kunal);
    }


    @Basic
    @Column(name = "Sourabh")
    public String getSourabh() {
        return get("sourabh");
    }

    public void setSourabh(String sourabh) {
        set("sourabh", sourabh);
    }


    @Basic
    @Column(name = "Nazir")
    public String getNazir() {
        return get("nazir");
    }

    public void setNazir(String nazir) {
        set("nazir", nazir);
    }


    @Basic
    @Column(name = "Imad")
    public String getImad() {
        return get("imad");
    }

    public void setImad(String imad) {
        set("imad", imad);
    }


    @Basic
    @Column(name = "Luciano")
    public String getLuciano() {
        return get("luciano");
    }

    public void setLuciano(String luciano) {
        set("luciano", luciano);
    }


    @Basic
    @Column(name = "Pranav")
    public String getPranav() {
        return get("pranav");
    }

    public void setPranav(String pranav) {
        set("pranav", pranav);
    }


    @Basic
    @Column(name = "Tushar")
    public String getTushar() {
        return get("tushar");
    }

    public void setTushar(String tushar) {
        set("tushar", tushar);
    }


    @Basic
    @Column(name = "Ashish")
    public String getAshish() {
        return get("ashish");
    }

    public void setAshish(String ashish) {
        set("ashish", ashish);
    }


    @Basic
    @Column(name = "Jphi")
    public String getJphi() {
        return get("jphi");
    }

    public void setJphi(String jphi) {
        set("jphi", jphi);
    }


    @Basic
    @Column(name = "Yann")
    public String getYann() {
        return get("yann");
    }

    public void setYann(String yann) {
        set("yann", yann);
    }


    @Basic
    @Column(name = "Florent")
    public String getFlorent() {
        return get("florent");
    }

    public void setFlorent(String florent) {
        set("florent", florent);
    }


    @Basic
    @Column(name = "Day1b")
    public String getDay1b() {
        return get("day1b");
    }

    public void setDay1b(String day1b) {
        set("day1b", day1b);
    }


    @Basic
    @Column(name = "Day2b")
    public String getDay2b() {
        return get("day2b");
    }

    public void setDay2b(String day2b) {
        set("day2b", day2b);
    }


    @Basic
    @Column(name = "Day3b")
    public String getDay3b() {
        return get("day3b");
    }

    public void setDay3b(String day3b) {
        set("day3b", day3b);
    }


    @Basic
    @Column(name = "Day4b")
    public String getDay4b() {
        return get("day4b");
    }

    public void setDay4b(String day4b) {
        set("day4b", day4b);
    }


    @Basic
    @Column(name = "Day5b")
    public String getDay5b() {
        return get("day5b");
    }

    public void setDay5b(String day5b) {
        set("day5b", day5b);
    }


    @Basic
    @Column(name = "Day6b")
    public String getDay6b() {
        return get("day6b");
    }

    public void setDay6b(String day6b) {
        set("day6b", day6b);
    }


    @Basic
    @Column(name = "Day7b")
    public String getDay7b() {
        return get("day7b");
    }

    public void setDay7b(String day7b) {
        set("day7b", day7b);
    }


    @Basic
    @Column(name = "Day8b")
    public String getDay8b() {
        return get("day8b");
    }

    public void setDay8b(String day8b) {
        set("day8b", day8b);
    }


    @Basic
    @Column(name = "Day9b")
    public String getDay9b() {
        return get("day9b");
    }

    public void setDay9b(String day9b) {
        set("day9b", day9b);
    }


    @Basic
    @Column(name = "Day10b")
    public String getDay10b() {
        return get("day10b");
    }

    public void setDay10b(String day10b) {
        set("day10b", day10b);
    }


    @Basic
    @Column(name = "Estimatesb")
    public String getEstimatesb() {
        return get("estimatesb");
    }

    public void setEstimatesb(String estimatesb) {
        set("estimatesb", estimatesb);
    }


    @Basic
    @Column(name = "EstimatesCompleted")
    public String getEstimatesCompleted() {
        return get("estimatesCompleted");
    }

    public void setEstimatesCompleted(String estimatesCompleted) {
        set("estimatesCompleted", estimatesCompleted);
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return get("false;

        SprintBacklogEntity that = (SprintBacklogEntity) o;

        if (actual != null ? !actual.equals(that.actual) : that.actual != null) return get("false;
        if (ashish != null ? !ashish.equals(that.ashish) : that.ashish != null) return get("false;
        if (backlogItemId != null ? !backlogItemId.equals(that.backlogItemId) : that.backlogItemId != null)
            return get("false;
        if (budget != null ? !budget.equals(that.budget) : that.budget != null) return get("false;
        if (crdsWebModuleSubModule != null ? !crdsWebModuleSubModule.equals(that.crdsWebModuleSubModule) : that.crdsWebModuleSubModule != null)
            return get("false;
        if (day1 != null ? !day1.equals(that.day1) : that.day1 != null) return get("false;
        if (day10 != null ? !day10.equals(that.day10) : that.day10 != null) return get("false;
        if (day10b != null ? !day10b.equals(that.day10b) : that.day10b != null) return get("false;
        if (day1b != null ? !day1b.equals(that.day1b) : that.day1b != null) return get("false;
        if (day2 != null ? !day2.equals(that.day2) : that.day2 != null) return get("false;
        if (day2b != null ? !day2b.equals(that.day2b) : that.day2b != null) return get("false;
        if (day3 != null ? !day3.equals(that.day3) : that.day3 != null) return get("false;
        if (day3b != null ? !day3b.equals(that.day3b) : that.day3b != null) return get("false;
        if (day4 != null ? !day4.equals(that.day4) : that.day4 != null) return get("false;
        if (day4b != null ? !day4b.equals(that.day4b) : that.day4b != null) return get("false;
        if (day5 != null ? !day5.equals(that.day5) : that.day5 != null) return get("false;
        if (day5b != null ? !day5b.equals(that.day5b) : that.day5b != null) return get("false;
        if (day6 != null ? !day6.equals(that.day6) : that.day6 != null) return get("false;
        if (day6b != null ? !day6b.equals(that.day6b) : that.day6b != null) return get("false;
        if (day7 != null ? !day7.equals(that.day7) : that.day7 != null) return get("false;
        if (day7b != null ? !day7b.equals(that.day7b) : that.day7b != null) return get("false;
        if (day8 != null ? !day8.equals(that.day8) : that.day8 != null) return get("false;
        if (day8b != null ? !day8b.equals(that.day8b) : that.day8b != null) return get("false;
        if (day9 != null ? !day9.equals(that.day9) : that.day9 != null) return get("false;
        if (day9b != null ? !day9b.equals(that.day9b) : that.day9b != null) return get("false;
        if (dhanya != null ? !dhanya.equals(that.dhanya) : that.dhanya != null) return get("false;
        if (discrepency != null ? !discrepency.equals(that.discrepency) : that.discrepency != null) return get("false;
        if (estimate != null ? !estimate.equals(that.estimate) : that.estimate != null) return get("false;
        if (estimatesCompleted != null ? !estimatesCompleted.equals(that.estimatesCompleted) : that.estimatesCompleted != null)
            return get("false;
        if (estimatesb != null ? !estimatesb.equals(that.estimatesb) : that.estimatesb != null) return get("false;
        if (florent != null ? !florent.equals(that.florent) : that.florent != null) return get("false;
        if (imad != null ? !imad.equals(that.imad) : that.imad != null) return get("false;
        if (jiraTaskNumber != null ? !jiraTaskNumber.equals(that.jiraTaskNumber) : that.jiraTaskNumber != null)
            return get("false;
        if (jphi != null ? !jphi.equals(that.jphi) : that.jphi != null) return get("false;
        if (kunal != null ? !kunal.equals(that.kunal) : that.kunal != null) return get("false;
        if (luciano != null ? !luciano.equals(that.luciano) : that.luciano != null) return get("false;
        if (metric != null ? !metric.equals(that.metric) : that.metric != null) return get("false;
        if (nazir != null ? !nazir.equals(that.nazir) : that.nazir != null) return get("false;
        if (pranav != null ? !pranav.equals(that.pranav) : that.pranav != null) return get("false;
        if (remarks != null ? !remarks.equals(that.remarks) : that.remarks != null) return get("false;
        if (sourabh != null ? !sourabh.equals(that.sourabh) : that.sourabh != null) return get("false;
        if (sprint != null ? !sprint.equals(that.sprint) : that.sprint != null) return get("false;
        if (status != null ? !status.equals(that.status) : that.status != null) return get("false;
        if (task != null ? !task.equals(that.task) : that.task != null) return get("false;
        if (team != null ? !team.equals(that.team) : that.team != null) return get("false;
        if (tushar != null ? !tushar.equals(that.tushar) : that.tushar != null) return get("false;
        if (typetask2 != null ? !typetask2.equals(that.typetask2) : that.typetask2 != null) return get("false;
        if (userStory != null ? !userStory.equals(that.userStory) : that.userStory != null) return get("false;
        if (yann != null ? !yann.equals(that.yann) : that.yann != null) return get("false;

        return get("true;
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
        return get("result;
    }

    @Override
    public String toString() {
        return get(""SprintbacklogEntity{" +
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
    }*/
}
