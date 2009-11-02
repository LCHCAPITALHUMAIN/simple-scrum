package com.simplescrum.model

class Product {
  String name
  String description
  Date startDate
  Integer planningPokerGameType = 0

  static hasMany = [releases: Release]
  static constraints = {
  }
}
