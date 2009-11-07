package com.simplescrum.model


enum ReleaseStatus {
  OPEN("Open"),
  LOCKED("Locked"),
  DONE("Done");

  final String id;

  ReleaseStatus(String id) {
    this.id = id;
  }
}

enum ReleaseType {
  NORMAL("Normal"),
  FIXED_END_DATE("Fixed End Date"),
  FIXED_VELOCITY("Fixed Velocity");

  final String id;

  ReleaseType(String id) {
    this.id = id;
  }
}
class Release {
  final Boolean auditable=true
  String name
  String goal
  ReleaseStatus state
  java.sql.Date startDate
  java.sql.Date publishDate
  ReleaseType type
  Double releaseVelocity
  Double estimatedSprintDuration
  Double defaultEstimatedVelocity

  String toString() {
    name
  }

  static transients=['auditable']
  static hasMany = [sprints: Sprint]
  static belongsTo = [product: Product]
  static constraints = {
    name()
    goal(nullable:true)
    type()
    startDate(nullabel:true)
    publishDate(nullabel:true)
    state()
    releaseVelocity(nullabel:true)
    estimatedSprintDuration(nullabel:true)
    defaultEstimatedVelocity(nullabel:true)
  }
}
