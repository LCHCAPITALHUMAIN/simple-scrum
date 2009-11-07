package com.simplescrum.model

class RemainingEstimation {
  final Boolean auditable=true
  Task task
  Double remainingPoints
  java.sql.Date date

  String toString() {
    Sring.format('%tA %<te %<tB %<ty - %s', date, remainingPoints)
  }

  static transients=['auditable']
  static belongsTo = [Task]
  static constraints = {
    task()
    remainingPoints()
    date(unique: 'task')
  }
}
