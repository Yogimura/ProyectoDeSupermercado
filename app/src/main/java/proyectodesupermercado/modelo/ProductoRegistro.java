/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectodesupermercado.modelo;

import proyectodesupermercado.lib.databaseUtils.annotations.Column;
import proyectodesupermercado.lib.databaseUtils.annotations.Id;
import proyectodesupermercado.lib.databaseUtils.annotations.ManyToOne;
import proyectodesupermercado.lib.databaseUtils.annotations.Table;
import proyectodesupermercado.lib.tableModel.TableModelColumn;

/**
 * @author cheerio-pixel
 */
@Table
public class ProductoRegistro {
    @Id
    private long id;
    @TableModelColumn(name = "Nombre", index = 1)
    private String nombre;
    @ManyToOne(joinColumn = "idSuplidor")
    private Suplidor suplidor;
    @Column(name = "precioPorUnidad")
    @TableModelColumn(name = "Precio por unidad", index = 1)
    private double precioDeVenta;

    public ProductoRegistro() {
    }
    public ProductoRegistro(String nombre, Suplidor suplidor, double precioDeVenta) {
        this.nombre = nombre;
        this.suplidor = suplidor;
        this.precioDeVenta = precioDeVenta;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Suplidor getSuplidor() {
        return suplidor;
    }

    public long getSuplidorId() {
        if (suplidor == null) {
            return -1;
        }
        return suplidor.getId();
    }

    public double getPrecioDeVenta() {
        return precioDeVenta;
    }
}
