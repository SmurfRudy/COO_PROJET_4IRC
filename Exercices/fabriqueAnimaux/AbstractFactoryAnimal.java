package fabriqueAnimaux;

public class AbstractFactoryAnimal {

	public static void main(String[] args) {		

			// Create and run the African animal world
			ContinentFactory africa = new AfricaFactory();
			AnimalWorld world = new AnimalWorld(africa);
			world.RunFoodChain();

			// Create and run the American animal world
			ContinentFactory america = new AmericaFactory();
			world = new AnimalWorld(america);
			world.RunFoodChain();
	}
}


// / The 'AbstractFactory' abstract class
abstract class ContinentFactory {
	public abstract Herbivore CreateHerbivore();
	public abstract Carnivore CreateCarnivore();
}


// / The 'ConcreteFactory1' class
class AfricaFactory extends ContinentFactory {

	public Herbivore CreateHerbivore()	{
		return new Wildebeest();
	}

	public Carnivore CreateCarnivore()	{
		return new Lion();
	}
}


// / The 'ConcreteFactory2' class
class AmericaFactory extends ContinentFactory{

	public Herbivore CreateHerbivore()	{
		return new Bison();
	}

	public Carnivore CreateCarnivore()	{
		return new Wolf();
	}
}


// / The 'AbstractProductA' abstract class
abstract class Herbivore{
}


// / The 'AbstractProductB' abstract class
abstract class Carnivore{
	public abstract void eat(Herbivore h);
}


// / The 'ProductA1' class
class Wildebeest extends Herbivore{
}


// / The 'ProductB1' class
class Lion extends Carnivore{

	public void eat(Herbivore h)	{
		// eat Wildebeest
		System.out.println(this.getClass().getSimpleName() +
				" eats " + h.getClass().getSimpleName());
	}
}

// / The 'ProductA2' class
class Bison extends Herbivore{
}

// / The 'ProductB2' class
class Wolf extends Carnivore{

	public void eat(Herbivore h)	{
		// eat Bison
		System.out.println(this.getClass().getSimpleName() +
				" eats " + h.getClass().getSimpleName());
	}
}

// / The 'Client' class
class AnimalWorld{

	private Herbivore herbivore;
	private Carnivore carnivore;

	// Constructor
	public AnimalWorld(ContinentFactory factory)	{
		carnivore = factory.CreateCarnivore();
		herbivore = factory.CreateHerbivore();
	}

	public void RunFoodChain()	{
		carnivore.eat(herbivore);
	}
}


