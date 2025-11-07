package modelos;

public class Producto {
    //Encapsulamiento y declaramos las variabls del objeto producto
    private Long idProducto;
    private String nombre;
    private String Tipo;
    private double precio;
    public Producto(){}
    /*
    * */
    public Producto(Long idProducto, String nombre, String Tipo, double precio){
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.Tipo = Tipo;
        this.precio = precio;
    }
    /*
    * */

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
