package com.simplescrum.model

enum TaskStatus {
  PENDING("Pending"),
  IN_PROGRESS("In Progress"),
  DONE("Done");

  final String id;

  TaskStatus(String id) {
    this.id = id;
  }
}

enum TaskType {
  PLANNED("Planned"),
  UN_PLANNED("UN Planned");

  final String id;

  TaskType(String id) {
    this.id = id;
  }
}

class Task {
  String label
  String notes
  TaskStatus state
  TaskType type=TaskType.PLANNED
  Team team
  static hasMany = [taskActuals: TaskActual, remainingEstimations: RemainingEstimation]
  static belongsTo = [creator: User, productBacklogItem: ProductBacklogItem, sprint: Sprint]
  static constraints = {
    label()
    state()
    type()
    team(nullable:true)
    sprint()
    notes(nullable: true)
    creator()
    productBacklogItem()
    taskActuals()
    remainingEstimations()
  }

  String toString() {
    label
  }
}
