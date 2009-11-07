package com.simplescrum.model

enum ProductBacklogItemStatus {
  VALIDATED("Validated"),
  ESTIMATED("Estiamted"),
  PlANIFIED("Planified"),
  INPROGRESS("In Progress"),
  TESTED("Tested"),
  DONE("Done");

  final String id;

  ProductBacklogItemStatus(String id) {
    this.id = id;
  }
}

enum ProductBacklogItemType {
  USER_STORY("User Story"),
  FEATURE("Feature"),
  TEAM_MANAGEMENT("Team Management"),
  TECHNICAL_STORY("Technical Story"),
  DEFECT("Defect");

  final String id;

  ProductBacklogItemType(String id) {
    this.id = id;
  }
}

enum EstimationType {
  HIGH("High"),
  MEDIUM("Medium"),
  LOW("Low");

  final String id;

  EstimationType(String id) {
    this.id = id;
  }
}

class ProductBacklogItem {
  final Boolean auditable=true
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

  static transients=['auditable']
  static belongsTo = [product: Product]
  static hasMany = [tasks: Task]

  static constraints = {
    product()
    number()
    label()
    description(nullable: true,maxSize:1000)
    type()
    rank()
    notes(nullable: true,maxSize:2000)
    howToTest(nullable: true,maxSize:1000)
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
