// Interfaz Subject
interface Subject {
    void request();
}

// Clase RealSubject
class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("RealSubject: Manejando la solicitud.");
    }
}

// Clase Proxy
class Proxy implements Subject {
    private RealSubject realSubject;

    @Override
    public void request() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        preRequest();
        realSubject.request();
        postRequest();
    }

    private void preRequest() {
        System.out.println("Proxy: Realizando algunas tareas antes de la solicitud.");
    }

    private void postRequest() {
        System.out.println("Proxy: Realizando algunas tareas después de la solicitud.");
    }
}

// Ejemplo de uso
public class Main {
    public static void main(String[] args) {
        // Crear un Proxy
        Proxy proxy = new Proxy();

        // Llamar al método request a través del Proxy
        proxy.request();
    }
}
