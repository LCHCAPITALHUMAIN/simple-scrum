package com.simplescrum.model

class RemainingEstimation {
  Task task
  Double remainingPoints
  Date date
  static belongsTo = [Task]
  static constraints = {
  }
}
