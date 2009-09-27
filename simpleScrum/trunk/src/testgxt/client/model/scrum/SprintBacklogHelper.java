package testgxt.client.model.scrum;

import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.Style;

import java.util.List;
import java.util.ArrayList;

public class SprintBacklogHelper {
  public static String[][] convertToRecords(List<SprintBacklogEntity> items) {
    String[][] records = new String[items.size()][getFieldNames().length];
    for (int i = 0; i < items.size(); i++) {
      records[i] = convertToRecord(items.get(i));
    }
    return records;
  }

  private static String[] convertToRecord(SprintBacklogEntity entity) {
    return new String[]{
        entity.getBacklogItemId(),
        entity.getTypetask2(),
        entity.getUserStory(),
        entity.getTeam(),
        entity.getSprint(),
        entity.getCrdsWebModuleSubModule(),
        entity.getBudget(),
        entity.getTask(),
        entity.getEstimate(),
        entity.getDiscrepency(),
        entity.getRemarks(),
        entity.getActual(),
        entity.getJiraTaskNumber(),
        entity.getStatus(),
        entity.getMetric(),
        entity.getDay1(),
        entity.getDay2(),
        entity.getDay3(),
        entity.getDay4(),
        entity.getDay5(),
        entity.getDay6(),
        entity.getDay7(),
        entity.getDay8(),
        entity.getDay9(),
        entity.getDay10(),
        entity.getDhanya(),
        entity.getKunal(),
        entity.getSourabh(),
        entity.getNazir(),
        entity.getImad(),
        entity.getLuciano(),
        entity.getPranav(),
        entity.getTushar(),
        entity.getAshish(),
        entity.getJphi(),
        entity.getYann(),
        entity.getFlorent(),
        entity.getDay1b(),
        entity.getDay2b(),
        entity.getDay3b(),
        entity.getDay4b(),
        entity.getDay5b(),
        entity.getDay6b(),
        entity.getDay7b(),
        entity.getDay8b(),
        entity.getDay9b(),
        entity.getDay10b(),
        entity.getEstimatesb(),
        entity.getEstimatesCompleted()
    };
  }

  private static List<SprintBacklogEntity> convertToSpringBacklogEntry(String[][] entity) {
    List<SprintBacklogEntity> result = new ArrayList<SprintBacklogEntity>();
    for (int i = 0; i < entity.length; i++) {
      String[] entry = entity[i];
      result.add(convertToSpringBacklogEntry(entry));
    }
    return result;
  }
  
  private static SprintBacklogEntity convertToSpringBacklogEntry(String[] entity) {
    SprintBacklogEntity sbe = new SprintBacklogEntity();
    sbe.setBacklogItemId(entity[0]);
    sbe.setTypetask2(entity[1]);
    sbe.setUserStory(entity[2]);
    sbe.setTeam(entity[3]);
    sbe.setSprint(entity[4]);
    sbe.setCrdsWebModuleSubModule(entity[5]);
    sbe.setBudget(entity[6]);
    sbe.setTask(entity[7]);
    sbe.setEstimate(entity[8]);
    sbe.setDiscrepency(entity[9]);
    sbe.setRemarks(entity[10]);
    sbe.setActual(entity[11]);
    sbe.setJiraTaskNumber(entity[12]);
    sbe.setStatus(entity[13]);
    sbe.setMetric(entity[14]);
    sbe.setDay1(entity[15]);
    sbe.setDay2(entity[16]);
    sbe.setDay3(entity[17]);
    sbe.setDay4(entity[18]);
    sbe.setDay5(entity[19]);
    sbe.setDay6(entity[20]);
    sbe.setDay7(entity[21]);
    sbe.setDay8(entity[22]);
    sbe.setDay9(entity[23]);
    sbe.setDay10(entity[24]);
    sbe.setDhanya(entity[25]);
    sbe.setKunal(entity[26]);
    sbe.setSourabh(entity[27]);
    sbe.setNazir(entity[28]);
    sbe.setImad(entity[29]);
    sbe.setLuciano(entity[30]);
    sbe.setPranav(entity[31]);
    sbe.setTushar(entity[32]);
    sbe.setAshish(entity[33]);
    sbe.setJphi(entity[34]);
    sbe.setYann(entity[35]);
    sbe.setFlorent(entity[36]);
    sbe.setDay1b(entity[37]);
    sbe.setDay2b(entity[38]);
    sbe.setDay3b(entity[39]);
    sbe.setDay4b(entity[40]);
    sbe.setDay5b(entity[41]);
    sbe.setDay6b(entity[42]);
    sbe.setDay7b(entity[43]);
    sbe.setDay8b(entity[44]);
    sbe.setDay9b(entity[45]);
    sbe.setDay10b(entity[46]);
    sbe.setEstimatesb(entity[47]);
    sbe.setEstimatesCompleted(entity[48]);
    return sbe;
  }

  private static String[] getFieldNames() {
    return new String[]{
        "taskUniqueID"
        , "backlogItemId"
        , "typetask2"
        , "userStory"
        , "team"
        , "sprint"
        , "crdsWebModuleSubModule"
        , "budget"
        , "task"
        , "estimate"
        , "discrepency"
        , "remarks"
        , "actual"
        , "jiraTaskNumber"
        , "status"
        , "metric"
        , "day1"
        , "day2"
        , "day3"
        , "day4"
        , "day5"
        , "day6"
        , "day7"
        , "day8"
        , "day9"
        , "day10"
        , "dhanya"
        , "kunal"
        , "sourabh"
        , "nazir"
        , "imad"
        , "luciano"
        , "pranav"
        , "tushar"
        , "ashish"
        , "jphi"
        , "yann"
        , "florent"
        , "day1b"
        , "day2b"
        , "day3b"
        , "day4b"
        , "day5b"
        , "day6b"
        , "day7b"
        , "day8b"
        , "day9b"
        , "day10b"
        , "estimatesb"
        , "estimatesCompleted"
    };
  }

  public static ColumnModel getGxtColumnModel() {
    List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    for (String property : getFieldNames()) {
      ColumnConfig column = new ColumnConfig();
      column.setId(property);
      column.setHeader(property);
      column.setEditor(new CellEditor(new TextField<String>()));
      column.setResizable(true);
      column.setWidth(property.length()+20);
      configs.add(column);
    }
    return new ColumnModel(configs);

    /*ColumnConfig column = new ColumnConfig();
    column.setId("taskUniqueID");
    column.setHeader("Task ID");
    column.setWidth(20);
    configs.add(column);

    column = new ColumnConfig();
    column.setId("backlogItemId");
    column.setHeader("Backlog Item ID");
    column.setWidth(75);
    TextField<String> text = new TextField<String>();
    column.setEditor(new CellEditor(text));
    configs.add(column);

    column = new ColumnConfig();
    column.setId("userStory");
    column.setHeader("UserStory");
    column.setAlignment(Style.HorizontalAlignment.RIGHT);
    column.setWidth(100);
    configs.add(column);

    column = new ColumnConfig();
    column.setId("task");
    column.setHeader("Task");
    column.setAlignment(Style.HorizontalAlignment.RIGHT);
    column.setWidth(100);
    configs.add(column);

    column = new ColumnConfig("remarks", "Remarks", 90);
    column.setAlignment(Style.HorizontalAlignment.RIGHT);
    configs.add(column);

    column = new ColumnConfig("crdsWebModuleSubModule", "CRDS Web Module SubModule", 90);
    column.setAlignment(Style.HorizontalAlignment.RIGHT);

    configs.add(column);*/

  }
}
