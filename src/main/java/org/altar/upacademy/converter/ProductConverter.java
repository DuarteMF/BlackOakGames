package org.altar.upacademy.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.altar.upacademy.model.Product;
import org.altar.upacademy.repository.ProductRepository;

@FacesConverter("productConverter")
//@FacesConverter(forClass=Product.class)
public class ProductConverter implements Converter {
	
	@Inject
	private ProductRepository productRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String productId) {
		System.out.println(productId);
	    if (productId == null || productId.isEmpty()) {
	        return null;
	    }

	    try {
			System.out.println(productId + "4");
			System.out.println(productId.getClass() + "5");
			System.out.println(Integer.parseInt(productId) + "6");
	        return productRepository.readFromDb(Integer.parseInt(productId));
//	        return productRepository.find(productId);
//	    	return productRepository.getProductFromName(productId);
	    } catch (NumberFormatException e) {
	        throw new ConverterException(new FacesMessage(productId + " is not a valid Product ID"), e);
	    } catch (NullPointerException e){
	    	throw new ConverterException(new FacesMessage("This is some stupid Null Pointer!"));
	    }
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object product) {
		if (product == null) {
	        return "";
	    }

	    if (product instanceof Product) {
//	    	return ((Product) product).getProductName();
	        return "" + ((Product) product).getProductId();
	    } else {
	        throw new ConverterException(new FacesMessage(product + " is not a valid Product"));
	    }
	}
}
