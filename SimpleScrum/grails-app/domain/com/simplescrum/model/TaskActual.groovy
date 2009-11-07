package com.simplescrum.model

class TaskActual {
  final Boolean auditable = true
  Task task
  User user
  Double actualPoints
  java.sql.Date date

  String toString() {
    Sring.format('%tA %<te %<tB %<ty - %s - %s', date, user, actualPoints)
  }

  static transients = ['auditable']
  static belongsTo = [User]
  static constraints = {
    task()
    user()
    date(unique: ['user', 'task'])
    actualPoints()
  }
}
