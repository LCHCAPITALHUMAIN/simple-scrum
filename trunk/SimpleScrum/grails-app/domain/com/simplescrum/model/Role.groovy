package com.simplescrum.model

enum RoleType {
  SCRUM_MASTER("Scrum Master"),
  PRODUCT_OWNER("Product Owner"),
  STAKE_HOLDER("Stake Holder"),
  DEVELOPER("Developer");

  final String id;

  RoleType(String id) {
    this.id = id;
  }
}

class Role {
  final Boolean auditable=true
  RoleType name
  String description
  Product product
  Sprint sprint
  String toString() {
    name
  }

  static transients=['auditable']
  static belongsTo = [user: User]
  static constraints = {
    name()
    description(nullable: true,maxSize:1000)
    product()
    sprint(nullable:true)
  }
}
