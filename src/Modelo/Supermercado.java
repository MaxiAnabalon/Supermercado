package Modelo;

import Modelo.Producto;
import Modelo.Carrito;
import java.util.List;
import java.util.ArrayList;

public class Supermercado {
	
	private List<Producto> gondola;
	private List<Carrito> lstCarrito;

	public Supermercado() throws Exception {
		super();
		this.gondola = new ArrayList<Producto>();
		this.lstCarrito = new ArrayList<Carrito>();
	}

	public List<Producto> getGondola() {
		return gondola;
	}

	public void setGondola(List<Producto> gondola) {
		this.gondola = gondola;
	}

	public List<Carrito> getLstCarrito() {
		return lstCarrito;
	}

	public void setLstCarrito(List<Carrito> lstCarrito) {
		this.lstCarrito = lstCarrito;
	}

	@Override
	public String toString() {
		return "Supermercado [gondola=" + gondola + "]";
	}
	
	public boolean agregarProducto(String producto, float precio) throws Exception {
		int i = 0;
		boolean noEsIgual = true;
		while(noEsIgual && i < gondola.size()) {
			if(gondola.get(i).equal(producto)) {
				noEsIgual = false;
			}
			i++;
		}
		//verificamos que no es existe y lo agregamos
		if(noEsIgual == true) {
			int id = gondola.get(gondola.size()-1).getIdProducto() + 1;
			gondola.add(new Producto(id, producto, precio));
		}else {
			throw new Exception("ERROR: El producto ya existe");
		}
		return noEsIgual;
		
		/*for (Producto p : gondola) {
		if(p.equal(producto)) {
			throw new Exception("ERROR: El producto ya existe");
		}*/
	}
	
	public Producto traerProducto(int idProducto) {
		Producto producto = null;
		int i = 0;
		while(producto == null && i < gondola.size()) {
			
			if(gondola.get(i).getIdProducto() == idProducto) {
				producto = gondola.get(i);
			}
			
			i++;
		}
		
		return producto;
	}
		
	public boolean modificaProducto(int idProducto, String producto, float precio) throws Exception {
		Producto productoMod = null;
		productoMod = traerProducto(idProducto);
		if(productoMod == null) {
			throw new Exception("ERROR: Producto no existe");
		}
		return true;
	}
	
	public boolean eliminarProducto(int idProducto) throws Exception{
		Producto productoEliminar = traerProducto(idProducto);
		
		if	(productoEliminar != null) {
			Producto productoCarrito = null;
			int i = 0;
			while (productoCarrito == null && i < lstCarrito.size()) {
				//mejor crear metodo para traer un produco del carrito
				productoCarrito = lstCarrito.get(i).traerProducto(idProducto);
				++ i;
			}
			if(productoCarrito != null) 
			{
				throw new Exception("ERROR: Producto existe en un carrito, no se puede eliminar");
			}
			gondola.remove(productoEliminar);
		}else {
			throw new Exception("ERROR: Producto no existe , no se puede eliminar");
		}
		return true;
	}
	
	
}
