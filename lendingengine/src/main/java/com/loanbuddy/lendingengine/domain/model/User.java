package com.loanbuddy.lendingengine.domain.model;

import java.util.Objects;

public class User {
	private String firstName;
	private String lastName;
	private int age;
	private String profession;

	public User() {
	}

	public User(String firstName, String lastName, int age, String profession) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.profession = profession;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String getProfession() {
		return profession;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return age == user.age && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(profession, user.profession);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, age, profession);
	}


	@Override
	public String toString() {
		return "User{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", age=" + age +
				", profession='" + profession + '\'' +
				'}';
	}


}
