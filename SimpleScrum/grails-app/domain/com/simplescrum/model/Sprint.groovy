package com.simplescrum.model

enum SprintStatus {
  OPEN("Open"),
  LOCKED("Locked"),
  DONE("Done");

  final String id;

  SprintStatus(String id) {
    this.id = id;
  }
}

class Sprint {
  final Boolean auditable=true
  Integer number
  SprintStatus state
  String goal
  java.sql.Date startDate
  java.sql.Date endDate
  Double velocity
  Double estimatedVelocity
  Double dailyWorkTime

  static transients=['auditable']
  static belongsTo = [release: Release]
  static hasMany = [productBacklogItems: ProductBacklogItem]

  static constraints = {
    number()
    goal()
    startDate()
    endDate()
    velocity(nullable:true)
    estimatedVelocity(nullable:true)
    dailyWorkTime(nullable:true)
  }

  String toString() {
    "${number}# ${goal}"
  }
}
