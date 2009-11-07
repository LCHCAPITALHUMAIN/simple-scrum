package com.simplescrum.model

class Feature {
  final Boolean auditable=true
  String name
  String description

  String toString() {
    name
  }

  static belongsTo = [product: Product]
  static transients=['auditable']
  static constraints = {
    description(maxSize: 1000,nullable:true)
  }
}
