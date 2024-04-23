public class Cajero {

    private String nombre;
    private String username;
    private String password;
    private int saldo;

    public Cajero(String nombre,String username,String password){
        this.nombre = nombre;
        this.username = username;
        this.password = password;
        this.saldo = (int) Math.floor(Math.random()*1000);
    }

    public String getName() {
        return nombre;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getSaldo() {
        return saldo;
    }

    public int setSaldo(int saldoNuevo) {
        this.saldo = saldoNuevo;
        System.out.println("El saldo se actualizo correctamente");
        return saldoNuevo;
    }

    public void setPassword(String password) {
        this.password = password;
        System.out.println("La contraseña se actualizo correctamente");
        return;
    }
}
