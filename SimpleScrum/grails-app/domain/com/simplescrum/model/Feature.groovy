package com.simplescrum.model

import com.simplescrum.model.Product

class Feature {
  final Boolean auditable = true
  String name
  String description

  String toString() {
    name
  }

  static belongsTo = [product: Product]
  static transients = ['auditable']
  static constraints = {
    description(maxSize: 1000, nullable: true)
    name(unique: ['product'])
  }
}
