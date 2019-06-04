package com.app.hospital.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.core.entity.Producto;
import com.app.hospital.core.reposiroty.ProductoRepository;

@Service
public class ProductoServiceImplement implements ProductoService{

	@Autowired
	ProductoRepository productoRepository;
	
	
	@Override
	public List<Producto> allProducto() {
		// TODO Auto-generated method stub
		return productoRepository.findAll();
	}

	@Override
	public Producto addProducto(Producto producto) {
		// TODO Auto-generated method stub
		if(producto.getIdproducto()==null) {
			producto.setIdproducto(generatedIdProducto());
		}
		return productoRepository.save(producto);
	}

	@Override
	public Producto findProducto(Integer idproducto) {
		// TODO Auto-generated method stub
		return productoRepository.findById(idproducto).get();
	}

	@Override
	public void deleteProducto(Integer idproducto) {
		// TODO Auto-generated method stub
		productoRepository.deleteById(idproducto);
		
	}

	@Override
	public Integer generatedIdProducto() {
		// TODO Auto-generated method stub
		return productoRepository.findLastIdProducto()+1;
	}
	
	

}
