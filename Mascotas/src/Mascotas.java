
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class Mascotas {
    private String id;
    private String nombre;
    private String tipo;
    private int edad;

    public Mascotas() {
    }

    public Mascotas(String id, String nombre, String tipo, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.edad = edad;
    }

    public void mostrarInformacion() {
        JOptionPane.showMessageDialog(null, "------------Información----------\n" +
                "Identificación: " + id + "\n" +
                "Nombre: " + nombre + "\n" +
                "Tipo: " + tipo + "\n" +
                "Edad: " + edad + " años\n" +
                "---------------------------------");
        hacerSonido();
        comida();
    }

    public void hacerSonido() {
        if (tipo.equalsIgnoreCase("perro")) {
            JOptionPane.showMessageDialog(null, "¡Guau guau!");
        } else if (tipo.equalsIgnoreCase("gato")) {
            JOptionPane.showMessageDialog(null, "¡Miau miau!");
        } else {
            JOptionPane.showMessageDialog(null, "La mascota no hace sonidos conocidos.");
        }
    }

    public void comida() {
        if (tipo.equalsIgnoreCase("perro")) {
            JOptionPane.showMessageDialog(null, "¡Come carne de vaca y carne de cerdo!");
        } else if (tipo.equalsIgnoreCase("gato")) {
            JOptionPane.showMessageDialog(null, "¡Come pescado y comidad de gato!");
        } else {
            JOptionPane.showMessageDialog(null, "La mascota no tiene hambre.");
        }
    }

    public void ingresarDatos() {
        id = JOptionPane.showInputDialog("Ingrese la identificación: ");
        nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
        tipo = JOptionPane.showInputDialog("Ingrese el tipo:");
        edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad:"));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}

class Inicializador {
    private ArrayList<Mascotas> listaMascotas = new ArrayList<>();
    private HashMap<String, Mascotas> mapaMascotas = new HashMap<>();

    public void iniciarSistema() {
        int opcion;
        do {
            opcion = mostrarMenu();

            switch (opcion) {
                case 1:
                    crearMascota();
                    break;
                case 2:
                    consultarMascota();
                    break;
                case 3:
                    consultarListaMascotas();
                    break;
                case 4:
                    modificarMascota();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "*************Saliendo del sistema***********\n");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 5);
    }

    private int mostrarMenu() {
        String menu = "";
        menu += "MENU\n";
        menu += "1. Crear mascota\n";
        menu += "2. Consultar mascota individual\n";
        menu += "3. Consultar lista de mascotas\n";
        menu += "4. Modificar una mascota\n";
        menu += "5. Salir\n";
        menu += "Ingrese una opción:\n ";

        return Integer.parseInt(JOptionPane.showInputDialog(menu));
    }

    private void crearMascota() {
        Mascotas mascota = new Mascotas();
        mascota.ingresarDatos();
        listaMascotas.add(mascota);
        mapaMascotas.put(mascota.getId(), mascota);
    }

    private void consultarMascota() {
        String id = JOptionPane.showInputDialog("Ingrese la identificación de la mascota a consultar: ");
        if (mapaMascotas.containsKey(id)) {
            Mascotas mascotaConsultada = mapaMascotas.get(id);
            mascotaConsultada.mostrarInformacion();
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ninguna mascota con la identificación ingresada.");
        }
    }

    private void consultarListaMascotas() {
        String lista = "Lista de mascotas:\n";
        for (Mascotas mascotaLista : listaMascotas) {
            lista += "Identificación: " + mascotaLista.getId() + ", Nombre: " + mascotaLista.getNombre() + "\n";
        }
        JOptionPane.showMessageDialog(null, lista);
    }

    private void modificarMascota() {
        String id = JOptionPane.showInputDialog("Ingrese la identificación de la mascota a modificar: ");
        if (mapaMascotas.containsKey(id)) {
            Mascotas mascotaModificar = mapaMascotas.get(id);
            mascotaModificar.ingresarDatos();
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ninguna mascota con la identificación ingresada.");
        }
    }
}
