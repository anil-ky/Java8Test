package com.java8.features.model;

public class Person {

    private String name;
    private int age;
    private boolean local;
    private Gender gender;

    private Address address;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, boolean local) {
        this.name = name;
        this.age = age;
        this.local = local;
    }

    public Person(String name, int age, Address address, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isLocal() {
        return local;
    }

    public void setLocal(boolean local) {
        this.local = local;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

	@Override
	public String toString() {
		return name;
	}
}