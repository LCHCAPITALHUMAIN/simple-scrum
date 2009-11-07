package com.simplescrum.model

class Team {
  final Boolean auditable=true
  String label
  String description

  String toString() {
    label
  }

  static transients=['auditable']
  static hasMany = [compositions: TeamComposition]
  static constraints = {
    label()
    description(nullable: true)
  }
}
