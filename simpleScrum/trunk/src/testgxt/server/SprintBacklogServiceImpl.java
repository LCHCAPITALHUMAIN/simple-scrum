package testgxt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import testgxt.client.SprintBacklogService;
import testgxt.client.model.scrum.SprintBacklogEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class SprintBacklogServiceImpl extends RemoteServiceServlet implements SprintBacklogService {
  private Map<Long,SprintBacklogEntity> sprintBacklogItems = new HashMap<Long, SprintBacklogEntity>();

  public List<SprintBacklogEntity> getBacklogItems(String sprint, int teamNo) {
    if (sprintBacklogItems.size()==0) {
      sprintBacklogItems.put(23L,createASprintBacklogEntity("Counterpart/Legal", "456", "2", "DB test", "2", 23L, "Saving a Non Legal"));
      sprintBacklogItems.put(24L,createASprintBacklogEntity("Counterpart/Legal", "456", "1.5", "Idx tests", "2", 24L, "Saving a Non Legal"));
      sprintBacklogItems.put(25L,createASprintBacklogEntity("Counterpart/Legal", "456", "6", "Spike", "2", 25L, "Saving a Non Legal"));
    }
    ArrayList<SprintBacklogEntity> result = new ArrayList<SprintBacklogEntity>();
    result.addAll(sprintBacklogItems.values());
    return result;
  }

  public void setBacklogItems(SprintBacklogEntity item) {
    sprintBacklogItems.put(item.getTaskUniqueId(),item);
    System.out.println("Commited !");
    updateFullList();
  }

  private void updateFullList() {
    for (SprintBacklogEntity anEntity : sprintBacklogItems.values()) {
      System.out.println("Entry "+anEntity.getTaskUniqueId()+" has a backlog item of: "+anEntity.getBacklogItemId());
      anEntity.setUserStory(anEntity.getUserStory()+"+");
    }
  }

  private SprintBacklogEntity createASprintBacklogEntity(String module, String backlogItemId, String estimate, String task, String team, Long taskId, String userStory) {
    SprintBacklogEntity sprintbacklogEntity = new SprintBacklogEntity();
    sprintbacklogEntity.setCrdsWebModuleSubModule(module);
    sprintbacklogEntity.setBacklogItemId(backlogItemId);
    sprintbacklogEntity.setEstimate(estimate);
    sprintbacklogEntity.setTask(task);
    sprintbacklogEntity.setTeam(team);
    sprintbacklogEntity.setTaskUniqueId(taskId);
    sprintbacklogEntity.setUserStory(userStory);
    return sprintbacklogEntity;
  }
}