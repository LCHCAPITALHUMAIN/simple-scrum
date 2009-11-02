package com.simplescrum.model

class User {
  static transients = ['pass']
  String userRealName
  boolean emailShow = false
  String login
  String password
  String email
  Boolean isActive = true
  Boolean isAdmin = false
  Boolean enabled=true
  /** plain password to create a MD5 password */
	String pass = '[secret]'
  static hasMany = [authorities:AccessRole,problems: Problem, roles: Role, productBacklogItems: ProductBacklogItem, tasksCreated: Task, actuals: TaskActual]

  static belongsTo = AccessRole

  static constraints = {
    login(size: 5..15, blank: false, unique: true)
    password(blank: false)
    email(email: true,nullable: true, blank: true)
    userRealName(nullable: true, blank: true)
  }
}
