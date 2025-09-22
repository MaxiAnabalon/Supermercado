package Modelo;

import Modelo.ItemCarrito;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
	
	private int idCarrito;
	private LocalDate fecha;
	private LocalDateTime hora;
	private List<ItemCarrito> lstItem;
	
	public Carrito(int idCarrito, LocalDate fecha, LocalDateTime hora) {
		super();
		this.idCarrito = idCarrito;
		this.fecha = fecha;
		this.hora = hora;
		this.lstItem = new ArrayList<ItemCarrito>();;
	}

	public int getIdCarrito() {
		return idCarrito;
	}

	public void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalDateTime getHora() {
		return hora;
	}

	public void setHora(LocalDateTime hora) {
		this.hora = hora;
	}

	public List<ItemCarrito> getLstItem() {
		return lstItem;
	}

	public void setLstItem(List<ItemCarrito> lstItem) {
		this.lstItem = lstItem;
	}

	@Override
	public String toString() {
		return "Carrito [idCarrito=" + idCarrito + ", fecha=" + fecha + ", hora=" + hora + ", lstItem=" + lstItem + "]";
	}
	
	public Producto traerProducto(int idProducto) {
		Producto producto = null;
		int i = 0;
		while(producto == null && i < lstItem.size()) {
			
			if(lstItem.get(i).getProducto().getIdProducto() == idProducto) {
				producto = lstItem.get(i).getProducto();
			}
			i++;
		}
		return producto;
	}
	
	public ItemCarrito buscarItemCarritoPorIdProd(int idProducto) {
		ItemCarrito itemCarritoEncontrado = null;
		int i = 0;
		while(itemCarritoEncontrado  == null && i < lstItem.size()) {
			if(lstItem.get(i).getProducto().getIdProducto() == idProducto) {
				itemCarritoEncontrado = lstItem.get(i);
			}
			i++;
		}
		return itemCarritoEncontrado;
	}
	
	public boolean agregarItem(Producto producto, int cantidad) {
		Producto producExistenteLstItems = traerProducto(producto.getIdProducto());
		if(producExistenteLstItems != null) {
			ItemCarrito itemCarritoProd = buscarItemCarritoPorIdProd(producto.getIdProducto());
			itemCarritoProd.agregarCantidad(cantidad);
			//lstItem.get(itemCarritoProd.getIdItem()).agregarCantidad(cantidad);			
		}else{
			int id = 1;
			if(lstItem.size() > 0){
				id = lstItem.get(lstItem.size()-1).getIdItem() + 1;
			}
			lstItem.add(new ItemCarrito(id, producto, cantidad));
		}
		return true;
	}
	
	public boolean eliminarItem(Producto producto, int cantidad)throws Exception {
		Producto producExistenteLstItems = traerProducto(producto.getIdProducto());
		
		if(producExistenteLstItems != null) {
			ItemCarrito itemCarritoProd = buscarItemCarritoPorIdProd(producto.getIdProducto());
			
			if(itemCarritoProd != null) {
				int indexEliminar = lstItem.indexOf(itemCarritoProd);
				if(itemCarritoProd.getCantidad() == cantidad) {
					
					//System.out.println(indexEliminar);
					lstItem.remove(indexEliminar); 
				}else {
					
					lstItem.get(indexEliminar).restarCantidad(cantidad);
				}
			}else {
				throw new Exception("No existe el producto a eliminar, no se encontro item");
			}			
		}else{
			throw new Exception("No existe el producto a eliminar, no se encontro item");
		}
		
		return true;
	}
	
	public float calcularTotal() {
		float total = 0;
		for (ItemCarrito item : lstItem){
			total += item.calcularSubTotal();
		}
		return total;
	}
}
