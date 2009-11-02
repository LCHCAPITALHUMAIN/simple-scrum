package com.simplescrum.model

enum ExpertnessLevel {
  LOW("Low"),
  MEDIUM("Medium"),
  HIGH("High");

  final String id;

  ExpertnessLevel(String id) {
    this.id = id;
  }

}
enum UsageFrequency {
  HOUR("Hur"),
  DAY("Day"),
  WEEK("Week"),
  MONTH("Month"),
  TRIMESTER("Trimester");

  final String id;

  UsageFrequency(String id) {
    this.id = id;
  }
}

class CustomRole {
  String name
  String description
  Integer instances
  String satisficationCriteria
  ExpertnessLevel expertiseLevel
  UsageFrequency usageFrequency
  static hasMany = [productBacklogItems: ProductBacklogItem]
  static constraints = {
  }
}
