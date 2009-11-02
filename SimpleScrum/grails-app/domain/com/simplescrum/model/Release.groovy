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

  String name
  String goal
  ReleaseStatus state
  Date startDate
  Date publishDate
  ReleaseType type
  Integer releaseVelocity
  Integer estimatedSprintDuration
  Double defaultEstimatedVelocity

  String toString(){
    name 
  }

  static hasMany = [sprints: Sprint]
  static belongsTo = [product: Product]
  static constraints = {
  }
}
