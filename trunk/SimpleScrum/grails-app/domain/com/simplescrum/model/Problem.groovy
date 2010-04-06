package com.simplescrum.model

import com.simplescrum.model.ProblemStatus
import com.simplescrum.model.Product
import com.simplescrum.model.User
import java.sql.Date

class Problem {
  final Boolean auditable = true
  String name
  String impact
  String solution
  Integer rank
  ProblemStatus state
  java.sql.Date creationDate
  java.sql.Date modificationDate
  java.sql.Date closedDate

  String toString() {
    name
  }

  static transients = ['auditable']
  static belongsTo = [poster: User, product: Product]
  static constraints = {
    name()
    impact(maxSize: 1000, nullable: true)
    solution(maxSize: 1000, nullable: true)
    creationDate()
    modificationDate(nullable: true)
    closedDate(nullable: true)
  }
}
