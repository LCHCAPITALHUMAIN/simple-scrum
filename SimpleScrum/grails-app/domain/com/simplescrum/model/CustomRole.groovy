package com.simplescrum.model

import com.simplescrum.model.ExpertnessLevel
import com.simplescrum.model.ProductBacklogItem
import com.simplescrum.model.UsageFrequency

class CustomRole {
  final Boolean auditable = true
  String name
  String description
  Integer instances
  String satisficationCriteria
  ExpertnessLevel expertiseLevel
  UsageFrequency usageFrequency

  String toString() {
    name
  }

  static transients = ['auditable']
  static hasMany = [productBacklogItems: ProductBacklogItem]
  static constraints = {
  }
}
