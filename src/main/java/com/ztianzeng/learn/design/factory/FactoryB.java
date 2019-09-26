package com.ztianzeng.learn.design.factory;

public class FactoryB implements AbstractFactory {
    public Plant createPlant() {
        return new PlantB();
    }

    public Fruit createFruit() {
        return new FruitB();
    }
}