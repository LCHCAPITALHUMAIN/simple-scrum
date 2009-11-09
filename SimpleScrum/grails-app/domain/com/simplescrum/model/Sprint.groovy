package com.simplescrum.model

import com.simplescrum.model.ProductBacklogItem
import com.simplescrum.model.Release
import java.sql.Date

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
  final Boolean auditable = true
  Integer number
  SprintStatus state
  String goal
  java.sql.Date startDate
  java.sql.Date endDate
  Double velocity
  Double estimatedVelocity
  Double dailyWorkTime

  static transients = ['auditable']
  static belongsTo = [release: Release]
  static hasMany = [productBacklogItems: ProductBacklogItem]

  static constraints = {
    number(unique: true)
    goal()
    startDate()
    endDate()
    velocity(nullable: true)
    estimatedVelocity(nullable: true)
    dailyWorkTime(nullable: true)
  }

  String toString() {
    "${number}# ${goal}"
  }
}
