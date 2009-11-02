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
  Integer number
  SprintStatus state
  String goal
  Date startDate
  Date endDate
  Double velocity
  Double estimatedVelocity
  Double dailyWorkTime

  static belongsTo = [release: Release]
  static hasMany = [productBacklogItems: ProductBacklogItem]

  static constraints = {
  }
  String toString(){
    "${number}# ${goal}"
  }
}
