package com.simplescrum.model

class Team {
    String label
    String description
  
    String toString() {
      label
    }

    static hasMany=[compositions: TeamComposition]
    static constraints = {
      label()
      description(nullable:true)
    }
}
