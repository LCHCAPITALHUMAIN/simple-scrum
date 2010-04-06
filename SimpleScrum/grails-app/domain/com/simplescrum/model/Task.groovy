package com.simplescrum.model

import com.simplescrum.model.*

class Task {
  final Boolean auditable = true
  String label
  String notes
  TaskStatus state
  Double estimatedPoints
  String issueTrackingId
  TaskType type = TaskType.PLANNED
  Team team

  static transients = ['auditable']
  static hasMany = [taskActuals: TaskActual, remainingEstimations: RemainingEstimation]
  static belongsTo = [creator: User, productBacklogItem: ProductBacklogItem, sprint: Sprint]
  static constraints = {
    label(unique: ['productBacklogItem', 'sprint'])
    state()
    type()
    estimatedPoints()
    issueTrackingId(nullable: true)
    team(nullable: true)
    sprint()
    notes(nullable: true)
    creator()
    productBacklogItem()
    taskActuals()
    remainingEstimations()
    notes(maxSize: 2000, nullable: true)
  }

  String toString() {
    label
  }
}
