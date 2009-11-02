package com.simplescrum.model

class RemainingEstimation {
  Task task
  Double remainingPoints
  Date date

  String toString(){
    Sring.format('%tA %<te %<tB %<ty - %s', date,remainingPoints)
  }

  static belongsTo = [Task]
  static constraints = {
  }
}
