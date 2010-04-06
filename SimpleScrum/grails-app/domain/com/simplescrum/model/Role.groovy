package com.simplescrum.model

import com.simplescrum.model.Product
import com.simplescrum.model.RoleType
import com.simplescrum.model.Sprint
import com.simplescrum.model.User

class Role {
  final Boolean auditable = true
  RoleType name
  String description
  Product product
  Sprint sprint

  String toString() {
    name
  }

  static transients = ['auditable']
  static belongsTo = [user: User]
  static constraints = {
    name()
    description(nullable: true, maxSize: 1000)
    product()
    sprint(nullable: true)
  }
}
