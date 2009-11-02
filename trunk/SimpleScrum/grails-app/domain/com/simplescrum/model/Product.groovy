package com.simplescrum.model

class Product {
  String name
  String description
  Date startDate
  Integer planningPokerGameType = 0

  String toString(){
    name 
  }

  static hasMany = [releases: Release]
  static constraints = {
  }
}
