// Clase abstracta que define el template para preparar una bebida caliente
abstract class HotBeverage {
    // Método template que define el proceso para preparar la bebida caliente
    public final void prepareBeverage() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    // Métodos abstractos que deben ser implementados por las subclases
    abstract void brew();
    abstract void addCondiments();

    // Métodos concretos comunes para todas las bebidas calientes
    void boilWater() {
        System.out.println("Hirviendo agua");
    }

    void pourInCup() {
        System.out.println("Sirviendo en taza");
    }

    // Método hook que puede ser sobrescrito por las subclases
    boolean customerWantsCondiments() {
        return true;
    }
}

// Implementación concreta para preparar café
class Coffee extends HotBeverage {
    @Override
    void brew() {
        System.out.println("Colando café");
    }

    @Override
    void addCondiments() {
        System.out.println("Agregando azúcar y leche");
    }
}

// Implementación concreta para preparar té
class Tea extends HotBeverage {
    @Override
    void brew() {
        System.out.println("Infusionando té");
    }

    @Override
    void addCondiments() {
        System.out.println("Agregando limón");
    }

    // Sobrescribimos el hook para el té, ya que algunos clientes pueden no querer limón
    @Override
    boolean customerWantsCondiments() {
        // En este ejemplo, siempre retornamos false para no agregar limón
        return false;
    }
}

// Ejemplo de uso
public class Main {
    public static void main(String[] args) {
        HotBeverage coffee = new Coffee();
        HotBeverage tea = new Tea();

        System.out.println("Preparando café...");
        coffee.prepareBeverage();

        System.out.println("\nPreparando té...");
        tea.prepareBeverage();
    }
}
