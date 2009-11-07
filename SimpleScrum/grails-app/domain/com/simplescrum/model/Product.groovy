package com.simplescrum.model

class Product {
  final Boolean auditable=true

  String name
  String description
  java.sql.Date startDate

  String toString() {
    name
  }

  static transients=['auditable']
  static hasMany = [releases: Release, items: ProductBacklogItem]
  static constraints = {
    name()
    description(maxSize: 1000)
    startDate()
  }
}
