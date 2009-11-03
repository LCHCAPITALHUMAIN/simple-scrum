package com.simplescrum.model

enum RoleType {
  SCRUM_MASTER("Scrum Master"),
  PRODUCT_OWNER("Product Owner"),
  STAKE_HOLDER("Stake Holder"),
  DEVOLPER("Developer");

  final String id;

  RoleType(String id) {
    this.id = id;
  }
}

class Role {
  RoleType name

  String toString() {
    name
  }

  static belongsTo = [user: User, product: Product]
  static constraints = {
  }
}
