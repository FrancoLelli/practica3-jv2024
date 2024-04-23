import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        boolean encencido = true;
        String respuesta;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hola. Bienvenido al Banco FRALELLI.");
        System.out.println("Ingresar nombre de Titular");
        String nombre = scanner.nextLine();
        System.out.println("Ingresar nombre de usuario");
        String username = scanner.nextLine();
        System.out.println("Ingresar contraseña");
        String password = scanner.nextLine();
        Cajero cajeroCreado = new Cajero(nombre, username, password);
        String nombreUser = cajeroCreado.getName();
        System.out.println("Hola Bienvenido: "+nombreUser);
        do {
            System.out.println("Que opcion quiere ejecutar:");
            System.out.println("1 - Retirar Efectivo");
            System.out.println("2 - Consultar saldo");
            System.out.println("3 - Depositar dinero");
            System.out.println("4 - Cambiar contraseña");
            System.out.println("5 - Datos de la cuenta");
            System.out.println("0 - Cerrar sesion");
            System.out.println("Que opcion quiere ejecutar:");
            int valor = Integer.parseInt(scanner.nextLine());
            int saldoDisponible = cajeroCreado.getSaldo();
            switch (valor){
                case 0:
                    encencido = false;
                    System.out.println("Gracias! Vuelva pronto.");
                    break;
                case 1:
                    System.out.println("El saldo disponible es de $"+saldoDisponible);
                    System.out.println("Cuanto dinero quiere retirar: ");
                    int saldoRetirar = Integer.parseInt(scanner.nextLine());
                    if(saldoRetirar > saldoDisponible){
                        System.out.println("Error: El saldo a retirar es mayor al disponible");
                    }else{
                        System.out.println("Cargando...");
                        System.out.println("Para retirar dinero debe ingresar la contraseña: ");
                        String passwordRetirar = scanner.nextLine();
                        String contraseñaActual = cajeroCreado.getPassword();
                        if(Objects.equals(passwordRetirar, contraseñaActual)){
                            System.out.println("La contraseña es corecta");
                            int nuevoSaldo = saldoDisponible - saldoRetirar;
                            int saldoActualizado = cajeroCreado.setSaldo(nuevoSaldo);
                            System.out.println("El saldo disponible es de $"+saldoActualizado);
                        }else{
                            System.out.println("Error: La contraseña ingresada es incorrecta");
                        }
                        break;
                    }
                    break;
                case 2:
                    System.out.println("El saldo disponible es de  $"+saldoDisponible);
                    break;
                case 3:
                    System.out.println("El saldo disponible es de $"+saldoDisponible);
                    System.out.println("Cuanto dinero desea depositar:");
                    int saldoDepositado = Integer.parseInt(scanner.nextLine());
                    System.out.println("Cargando...");
                    int nuevoSaldo = saldoDisponible + saldoDepositado;
                    int saldoActualizado = cajeroCreado.setSaldo(nuevoSaldo);
                    System.out.println("El saldo disponible es de $"+saldoActualizado);
                case 4:
                    System.out.println("Ingresar contraseña actual:");
                    String inputPasswordActual = scanner.nextLine();
                    String passwordActual = cajeroCreado.getPassword();
                    if(Objects.equals(passwordActual, inputPasswordActual)) {
                        System.out.println("Ingresar nueva contraseña");
                        String newPassword = scanner.nextLine();
                        cajeroCreado.setPassword(newPassword);
                    }else{
                        System.out.println("Error: Las contraseñas no coinciden");
                    }
                    break;
                case 5:
                    System.out.println("A continuacion podra ver datos privados: ");
                    System.out.println("Nombre: "+cajeroCreado.getName());
                    System.out.println("Nombre de usuario: "+cajeroCreado.getUsername());
                    System.out.println("Contrsaeña: "+cajeroCreado.getPassword());
                    break;
                default:
                    System.out.println("Opcion incorrecta.");
                    break;
            }
        }while (encencido);
    }
}