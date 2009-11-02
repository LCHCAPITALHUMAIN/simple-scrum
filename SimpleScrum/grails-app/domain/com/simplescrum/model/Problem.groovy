package com.simplescrum.model

enum ProblemStatus {
  UNASSIGNED("Unassigned"),
  SOLVING("Solving"),
  SOLVED("Solved");

  final String id;

  ProblemStatus(String id) {
    this.id = id;
  }
}

class Problem {
  String name
  String impact
  String solution
  Integer rank
  ProblemStatus state
  Date creationDate
  Date modificationDate
  Date closedDate

  String toString(){
    name  
  }

  static belongsTo = [poster: User, product: Product]
  static constraints = {
  }
}
