package com.simplescrum.model

class TaskActual {
  Task task
  User user
  Double actualPoints
  Date date

  static belongsTo = [User]
  static constraints = {
  }
}
