package com.simplescrum.model

class TeamComposition {
    Sprint sprint
    User user
    Team team

    String toString() {
      "${user} in ${team} on Sprint ${sprint}"
    }

    static constraints = {
      team()
      user()
      sprint()
    }
}
