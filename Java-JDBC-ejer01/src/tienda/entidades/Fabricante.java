
package tienda.entidades;


public class Fabricante {
    private int codigo;
    private String nombre;
    
    //construtores

    public Fabricante() {
    }

    public Fabricante(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    
    //getter and setters

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    // to String

    @Override
    public String toString() {
        return "Fabricante{" + "codigo=" + codigo + ", nombre=" + nombre + '}';
    }
    
}
