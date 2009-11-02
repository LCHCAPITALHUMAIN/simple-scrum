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
  TECHNICAL_STORY("Technical Story"),
  DEFECT("Defect");

  final String id;

  ProductBacklogItemType(String id) {
    this.id = id;
  }
}

class ProductBacklogItem {
  String label
  String description
  ProductBacklogItemType type
  String notes
  Integer estimatedPoints
  Integer executionFrequency
  Integer rank
  ProductBacklogItemStatus state
  Date creationDate
  Date estimationDate
  Boolean insertedOnActiveRelease
  CustomRole customRole
  Feature feature
  Sprint sprint
  User ownerUser

  static belongsTo = [Product]
  static hasMany = [tasks: Task]

  static constraints = {
    customRole(nullable: true)
    feature(nullable: true)
  }
}
