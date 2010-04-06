package com.simplescrum.model

import com.simplescrum.model.Product
import com.simplescrum.model.ReleaseStatus
import com.simplescrum.model.ReleaseType
import com.simplescrum.model.Sprint
import java.sql.Date

class Release {
  final Boolean auditable = true
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

  static transients = ['auditable']
  static hasMany = [sprints: Sprint]
  static belongsTo = [product: Product]
  static constraints = {
    name()
    goal(nullable: true)
    type()
    startDate(nullabel: true)
    publishDate(nullabel: true)
    state()
    releaseVelocity(nullabel: true)
    estimatedSprintDuration(nullabel: true)
    defaultEstimatedVelocity(nullabel: true)
  }
}
