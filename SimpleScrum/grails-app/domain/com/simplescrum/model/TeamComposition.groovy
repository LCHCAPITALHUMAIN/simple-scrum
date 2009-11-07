package com.simplescrum.model

class TeamComposition {
  final Boolean auditable=true
  Sprint sprint
  User user
  Team team

  String toString() {
    "${user} in ${team} on Sprint ${sprint}"
  }

  static transients=['auditable']
  static constraints = {
    team()
    user()
    sprint()
  }
}
