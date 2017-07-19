package org.altar.upacademy.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.altar.upacademy.model.Category;
import org.altar.upacademy.repository.CategoryRepository;

@FacesConverter("categoryConverter")
public class CategoryConverter implements Converter {

	@Inject
	private CategoryRepository categoryRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String categoryId) {
		System.out.println(categoryId);
	    if (categoryId == null || categoryId.isEmpty()) {
	        return null;
	    }

	    try {
			System.out.println(categoryId + "4");
			System.out.println(categoryId.getClass() + "5");
			System.out.println(Integer.parseInt(categoryId) + "6");
	        return categoryRepository.readFromDb(Integer.parseInt(categoryId));
//	        return categoryRepository.find(categoryId);
//	    	return categoryRepository.getCategoryFromName(categoryId);
	    } catch (NumberFormatException e) {
	        throw new ConverterException(new FacesMessage(categoryId + " is not a valid Category ID"), e);
	    } catch (NullPointerException e){
	    	throw new ConverterException(new FacesMessage("This is some stupid Null Pointer!"));
	    }
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object category) {
		if (category == null) {
	        return "";
	    }

	    if (category instanceof Category) {
//	    	return ((Category) category).getCategoryName();
	        return "" + ((Category) category).getCategoryId();
	    } else {
	        throw new ConverterException(new FacesMessage(category + " is not a valid Category"));
	    }
	}
}
