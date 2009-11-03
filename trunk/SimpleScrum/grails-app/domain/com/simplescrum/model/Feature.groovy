package com.simplescrum.model

class Feature {
  String name
  String description

  String toString() {
    name
  }

  static belongsTo = [product: Product]
  static constraints = {
  }
}
