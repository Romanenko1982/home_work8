package model;

public enum Type {
  REFRIGERATOR("Холодильник"), FREEZER("Морозильник"), MICROWAVE("Микроволновка");
//  WASHER("Стиральная машина"), DISHWASHER("Посудомоечная машина");
//  STOVE("Плита"), OVEN("Духовой шкаф");

  private String name;

  Type(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
