package com.capellasun.hasgo.data;

public enum EntityRole {

  HIDER("HIDER"),
  SEEKER("SEEKER");

  private String role;
  EntityRole (String role) {
    this.role = role;
  }


  public String toDebugString() {
    return "EntityRole{" +
        "role='" + role + '\'' +
        '}';
  }

  public String toString() {
    return role;
  }
}
