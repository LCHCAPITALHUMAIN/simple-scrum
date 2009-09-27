package com.gwt_ext.mypackage.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.gwt_ext.mypackage.client.SprintBacklogService;
import com.gwt_ext.mypackage.client.model.SprintbacklogEntity;

import java.util.List;
import java.util.ArrayList;

public class SprintBacklogServiceImpl extends RemoteServiceServlet implements SprintBacklogService {
    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "SprintBacklogService: Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }

    public List<SprintbacklogEntity> getBacklogItems(String sprint, int teamNo) {
        List<SprintbacklogEntity> result = new ArrayList<SprintbacklogEntity>();
        result.add(createASprintBacklogEntity("Counterpart/Legal", "456", "2", "DB test", "2"));
        result.add(createASprintBacklogEntity("Counterpart/Legal", "456", "1.5", "Idx tests", "2"));
        result.add(createASprintBacklogEntity("Counterpart/Legal", "456", "6", "Spike", "2"));
        return result;
    }

    private SprintbacklogEntity createASprintBacklogEntity(String module, String backlogItemId, String estimate, String task, String team) {
        SprintbacklogEntity sprintbacklogEntity = new SprintbacklogEntity();
        sprintbacklogEntity.setCrdsWebModuleSubModule(module);
        sprintbacklogEntity.setBacklogItemId(backlogItemId);
        sprintbacklogEntity.setEstimate(estimate);
        sprintbacklogEntity.setTask(task);
        sprintbacklogEntity.setTeam(team);
        return sprintbacklogEntity;
    }

}