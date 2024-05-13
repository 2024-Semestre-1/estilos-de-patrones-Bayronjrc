// Clase abstracta que define el Template Method
abstract class CuentaBancaria {
    private double saldo;

    public CuentaBancaria(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    // Método template que define el flujo general de una transacción
    public final void realizarTransaccion(double monto) {
        verificarSaldoSuficiente(monto);
        procesarTransaccion(monto);
        mostrarSaldo();
    }

    // Método abstracto que debe ser implementado por las subclases
    protected abstract void procesarTransaccion(double monto);

    // Método concreto que no cambia entre las subclases
    private void verificarSaldoSuficiente(double monto) {
        if (saldo < monto) {
            throw new RuntimeException("Saldo insuficiente");
        }
    }

    // Método concreto que no cambia entre las subclases
    private void mostrarSaldo() {
        System.out.println("Saldo actual: " + saldo);
    }
}

// Subclase que extiende CuentaBancaria y proporciona una implementación específica
class CuentaCorriente extends CuentaBancaria {
    public CuentaCorriente(double saldo) {
        super(saldo);
    }

    @Override
    protected void procesarTransaccion(double monto) {
        System.out.println("Procesando transacción de cuenta corriente por $" + monto);
        // Lógica específica para la cuenta corriente, como cobro de comisión, etc.
        double comision = 0.05 * monto;
        this.getSaldo -= comision;
    }
}

// Subclase que extiende CuentaBancaria y proporciona una implementación específica
class CuentaAhorros extends CuentaBancaria {
    public CuentaAhorros(double saldo) {
        super(saldo);
    }

    @Override
    protected void procesarTransaccion(double monto) {
        System.out.println("Procesando transacción de cuenta de ahorros por $" + monto);
        // Lógica específica para la cuenta de ahorros, como cálculo de intereses, etc.
        double interes = 0.02 * monto;
        this.getSaldo += interes;
    }
}

// Clase de prueba
public class Main {
    public static void main(String[] args) {
        CuentaBancaria cuentaCorriente = new CuentaCorriente(1000);
        CuentaBancaria cuentaAhorros = new CuentaAhorros(2000);

        cuentaCorriente.realizarTransaccion(500);
        cuentaAhorros.realizarTransaccion(500);
    }
}
