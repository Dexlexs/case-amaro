package br.com.caseAPI.viewresolver;

import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.xml.MappingJackson2XmlView;

public class XMLViewResolver implements ViewResolver {

	@Override
	public View resolveViewName(String viewName, Locale locale)
			throws Exception {
		MappingJackson2XmlView view = new MappingJackson2XmlView();

		view.setPrettyPrint(true);

		view.setModelKey("product");

		return view;
	}
}
