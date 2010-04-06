package com.simplescrum.model

import java.sql.Date
import com.simplescrum.model.*

class ProductBacklogItem {
  final Boolean auditable = true
  Integer number
  String label
  String description
  ProductBacklogItemType type
  String notes
  String howToTest
  Double estimatedPoints
  EstimationType estimationType = EstimationType.HIGH
  Integer rank
  ProductBacklogItemStatus state
  java.sql.Date creationDate
  java.sql.Date estimationDate
  BudgetLine budgetLine
  CustomRole customRole
  Release plannedRelease
  Feature feature
  User ownerUser

  static transients = ['auditable']
  static belongsTo = [product: Product]
  static hasMany = [tasks: Task]

  static constraints = {
    product()
    number()
    label()
    description(nullable: true, maxSize: 1000)
    type()
    rank()
    notes(nullable: true, maxSize: 2000)
    howToTest(nullable: true, maxSize: 1000)
    estimatedPoints(nullable: true)
    estimationType()
    estimationDate(nullable: true)
    customRole(nullable: true)
    feature(nullable: true)
    plannedRelease(nullable: true)
    budgetLine(nullable: true)
  }

  String toString() {
    "${number}->${label}"
  }
}
