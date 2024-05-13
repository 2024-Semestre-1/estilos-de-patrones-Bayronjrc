// Interfaz Pizza
interface Pizza {
    String getDescription();
    double getCost();
}

// Implementación de la pizza básica
class BasicPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Pizza básica";
    }

    @Override
    public double getCost() {
        return 5.0;
    }
}

// Decorador abstracto
abstract class ToppingDecorator implements Pizza {
    protected Pizza pizza;

    public ToppingDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public double getCost() {
        return pizza.getCost();
    }
}

// Implementación de un decorador con un topping específico (queso)
class Cheese extends ToppingDecorator {
    public Cheese(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", queso";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 1.5;
    }
}

// Implementación de un decorador con un topping específico (pepperoni)
class Pepperoni extends ToppingDecorator {
    public Pepperoni(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", pepperoni";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 2.0;
    }
}

// Ejemplo de uso
public class Main {
    public static void main(String[] args) {
        // Creamos una pizza básica
        Pizza basicPizza = new BasicPizza();

        // Decoramos la pizza con queso
        Pizza cheesePizza = new Cheese(basicPizza);
        System.out.println("Descripción: " + cheesePizza.getDescription());
        System.out.println("Costo: $" + cheesePizza.getCost());

        // Decoramos la pizza con queso y pepperoni
        Pizza cheeseAndPepperoniPizza = new Pepperoni(cheesePizza);
        System.out.println("Descripción: " + cheeseAndPepperoniPizza.getDescription());
        System.out.println("Costo: $" + cheeseAndPepperoniPizza.getCost());
    }
}
