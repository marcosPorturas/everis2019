package com.app.hospital.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.core.dto.request.ConsumoRequest;
import com.app.hospital.core.dto.response.ConsumoResponse;
import com.app.hospital.core.entity.Consumo;
import com.app.hospital.core.entity.Producto;
import com.app.hospital.core.entity.ProductoHasIngresoPK;
import com.app.hospital.core.reposiroty.ConsumoRepository;
import com.app.hospital.core.reposiroty.ProductoRepository;

@Service
public class ConsumoServiceImplement implements ConsumoService{

	@Autowired
	ConsumoRepository consumoRepository;
	
	@Autowired
	ProductoRepository productoRepository;
	
	
	@Override
	public ConsumoResponse addConsumo(ConsumoRequest consumoRequest) {
		// TODO Auto-generated method stub
		ConsumoResponse consumoResponse = new ConsumoResponse();
		ProductoHasIngresoPK pk = new ProductoHasIngresoPK();
		pk.setIdingreso(consumoRequest.getIdIngreso());
		pk.setIdproducto(consumoRequest.getIdProducto());
		
		Producto producto = productoRepository.findById(consumoRequest.getIdProducto()).get();
		
		Consumo consumo = new Consumo();
		consumo.setPk(pk);
		consumo.setCantidad(consumoRequest.getCantidad());
		consumo.setPrecio_venta(producto.getPrecio());
		
		consumoRepository.save(consumo);
		producto.setStock(producto.getStock() - consumo.getCantidad());
		
		productoRepository.save(producto);
	
		return consumoResponse;
	}


	@Override
	public List<ConsumoResponse> allConsumoByIngreso(Integer idIngreso) {
		// TODO Auto-generated method stub
		List<ConsumoResponse> lstConsumoResponse = new ArrayList<ConsumoResponse>();
		for(Consumo consumo : consumoRepository.findAllByPkIdingreso(idIngreso)) {
			ConsumoResponse consumoResponse = new ConsumoResponse();
			consumoResponse.setIdIngreso(consumo.getPk().getIdingreso());
			consumoResponse.setIdProducto(consumo.getPk().getIdproducto());
			consumoResponse.setCantidad(consumo.getCantidad());
			consumoResponse.setPrecio(consumo.getPrecio_venta());
			consumoResponse.setSubTotal(Math.round((consumo.getPrecio_venta()*consumo.getCantidad())* 100) / 100d);
			lstConsumoResponse.add(consumoResponse);
		}
		return lstConsumoResponse;
	}


	@Override
	public void deleteConsumo(Integer idIngreso, Integer idProducto) {
		// TODO Auto-generated method stub
		ProductoHasIngresoPK pk = new ProductoHasIngresoPK();
		pk.setIdingreso(idIngreso);
		pk.setIdproducto(idProducto);
		consumoRepository.deleteById(pk);
	}

}
