package model;

public enum Type {
  REFRIGERATOR("REFRIGERATOR"), FREEZER("FREEZER"), MICROWAVE("MICROWAVE"),
  WASHER("WASHER"), DISHWASHER("DISHWASHER"),
  STOVE("STOVE"), OVEN("OVEN");

  private String name;

  Type(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
