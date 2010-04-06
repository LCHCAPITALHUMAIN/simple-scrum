package com.simplescrum.model

import com.simplescrum.model.ProductBacklogItem
import com.simplescrum.model.Release
import com.simplescrum.model.SprintStatus
import java.sql.Date

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
