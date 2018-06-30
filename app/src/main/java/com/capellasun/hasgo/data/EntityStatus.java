package com.capellasun.hasgo.data;

public enum EntityStatus {
  HIDING("HIDING"),
  SEEKING("SEEKING"),
  FOUND_AND_SEEKING("FOUND_AND_SEEKING");

  private String status;
  EntityStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return status;
  }

  public String toDebugString() {
    return "EntityStatus{" +
        "status='" + status + '\'' +
        '}';
  }
}
