package com.simplescrum.model

class BudgetLine {
  final Boolean auditable=true
  String name
  String description
  String toString() {
    name
  }

  static transients=['auditable']
  static constraints = {
    name()
    description(nullable: true)
  }
}
