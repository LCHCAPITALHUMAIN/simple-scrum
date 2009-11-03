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
class Task {
  String label
  String notes
  Integer elapsedTime
  TaskStatus state
  static hasMany = [taskActuals: TaskActual, remainingEstimations: RemainingEstimation]
  static belongsTo = [creator: User, productBacklogItem: ProductBacklogItem]
  static constraints = {
  }

  String toString() {
    label
  }
}
