package com.simplescrum.model

class Product {
  String name
  String description
  Date startDate

  String toString() {
    name
  }

  static hasMany = [releases: Release, items: ProductBacklogItem]
  static constraints = {
  }
}
