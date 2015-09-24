package ch3;

import java.util.LinkedList;

abstract class Animal {
	private int age;
	protected String name;

	public Animal(String n) {
		name = n;
	}

	public abstract String name();

	public void setAge(int ord) {
		age = ord;
	}

	public int getAge() {
		return age;
	}

	public boolean isOlderThan(Animal a) {
		return this.age < a.getAge();
	}
}

class Cat extends Animal {
	public Cat(String n) {
		super(n);
	}

	public String name() {
		return "Cat: " + name;
	}
}

class AnimalQueue {
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	private int age = 0;

	public void enqueue(Animal a) {
		a.setAge(age);
		age++;
		if (a instanceof Dog) {
			dogs.addLast((Dog) a);
		} else if (a instanceof Cat) {
			cats.addLast((Cat) a);
		}
	}

	public Animal dequeueAny() {
		if (dogs.size() == 0) {
			return dequeueCats();
		} else if (cats.size() == 0) {
			return dequeueDogs();
		}
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		if (dog.isOlderThan(cat)) {
			return dogs.poll();
		} else {
			return cats.poll();
		}
	}

	public Dog dequeueDogs() {
		return dogs.poll();
	}

	public Cat dequeueCats() {
		return cats.poll();
	}
}

class Dog extends Animal {
	public Dog(String n) {
		super(n);
	}

	public String name() {
		return "Dog: " + name;
	}
}

public class Solution06 {

	public static void main(String[] args) {
		AnimalQueue q = new AnimalQueue();
		q.enqueue(new Cat("Cat1"));
		q.enqueue(new Cat("Cat2"));
		q.enqueue(new Dog("Dog1"));
		q.enqueue(new Cat("Cat3"));
		q.enqueue(new Dog("Dog2"));
		q.enqueue(new Cat("Cat4"));
		q.enqueue(new Dog("Dog3"));
		q.enqueue(new Dog("Dog4"));
		q.enqueue(new Cat("Cat5"));
		q.enqueue(new Dog("Dog5"));

		System.out.println(q.dequeueAny().name() + " Expected : Cat1");
		System.out.println(q.dequeueDogs().name() + " Expected : Dog1");
		System.out.println(q.dequeueCats().name() + " Expected : Cat2");

	}

}
