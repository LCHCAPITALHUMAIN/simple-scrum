package com.simplescrum.model

class Feature {
  String name
  String description
  static belongsTo = [product: Product]
  static constraints = {
  }
}
