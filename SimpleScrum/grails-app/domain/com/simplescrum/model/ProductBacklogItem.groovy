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
  String label
  String description
  ProductBacklogItemType type
  String notes
  Integer estimatedPoints
  EstimationType estimationType=EstimationType.HIGH
  Integer rank
  ProductBacklogItemStatus state
  Date creationDate
  Date estimationDate
  CustomRole customRole
  Feature feature
  User ownerUser

  static belongsTo = [product:Product]
  static hasMany = [tasks: Task]

  static constraints = {
    label()
    description(nullable: true)
    type()
    rank()
    notes(nullable: true)
    product()
    estimatedPoints(nullable: true)
    estimationType()
    estimationDate(nullable: true)
    customRole(nullable: true)
    feature(nullable: true)
  }

  String toString() {
    label
  }
}
