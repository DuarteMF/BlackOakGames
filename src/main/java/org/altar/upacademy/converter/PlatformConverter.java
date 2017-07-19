package org.altar.upacademy.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.altar.upacademy.model.Platform;
import org.altar.upacademy.repository.PlatformRepository;

@FacesConverter("platformConverter")
public class PlatformConverter implements Converter {

	@Inject
	private PlatformRepository platformRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String platformId) {
		System.out.println(platformId);
	    if (platformId == null || platformId.isEmpty()) {
	        return null;
	    }

	    try {
			System.out.println(platformId + "4");
			System.out.println(platformId.getClass() + "5");
			System.out.println(Integer.parseInt(platformId) + "6");
	        return platformRepository.readFromDb(Integer.parseInt(platformId));
//	        return platformRepository.find(platformId);
//	    	return platformRepository.getPlatformFromName(platformId);
	    } catch (NumberFormatException e) {
	        throw new ConverterException(new FacesMessage(platformId + " is not a valid Platform ID"), e);
	    } catch (NullPointerException e){
	    	throw new ConverterException(new FacesMessage("This is some stupid Null Pointer!"));
	    }
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object platform) {
		if (platform == null) {
	        return "";
	    }

	    if (platform instanceof Platform) {
//	    	return ((Platform) platform).getPlatformName();
	        return "" + ((Platform) platform).getPlatformId();
	    } else {
	        throw new ConverterException(new FacesMessage(platform + " is not a valid Platform"));
	    }
	}
}
