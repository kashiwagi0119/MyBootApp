package com.tuyano.springboot;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class MyMessageSource {

	@Autowired
	MessageSource messageSource;

	public String getMessage(String key) {
		return messageSource.getMessage(key, null, Locale.JAPANESE);
	}

	public String getMessage(String key, String param1) {
		return messageSource.getMessage(key, new String[] {param1}, Locale.JAPANESE);
	}

	public String getMessage(String key, String param1, String param2) {
		return messageSource.getMessage(key, new String[] {param1, param2}, Locale.JAPANESE);
	}

	public String getMessage(String key, String param1, String param2, String param3) {
		return messageSource.getMessage(key, new String[] {param1, param2, param3}, Locale.JAPANESE);
	}

	public String getMessage(String key, String param1, String param2, String param3, String param4) {
		return messageSource.getMessage(key, new String[] {param1, param2, param3, param4}, Locale.JAPANESE);
	}

	public String getMessage(String key, String param1, String param2, String param3, String param4, String param5) {
		return messageSource.getMessage(key, new String[] {param1, param2, param3, param4, param5}, Locale.JAPANESE);
	}

	public String getMessage(String key, String param1, String param2, String param3, String param4, String param5, String param6) {
		return messageSource.getMessage(key, new String[] {param1, param2, param3, param4, param5, param6}, Locale.JAPANESE);
	}

	public String getMessage(String key, String param1, String param2, String param3, String param4, String param5, String param6, String param7) {
		return messageSource.getMessage(key, new String[] {param1, param2, param3, param4, param5, param6, param7}, Locale.JAPANESE);
	}

	public String getMessage(String key, String param1, String param2, String param3, String param4, String param5, String param6, String param7, String param8) {
		return messageSource.getMessage(key, new String[] {param1, param2, param3, param4, param5, param6, param7, param8}, Locale.JAPANESE);
	}

	public String getMessage(String key, String param1, String param2, String param3, String param4, String param5, String param6, String param7, String param8, String param9) {
		return messageSource.getMessage(key, new String[] {param1, param2, param3, param4, param5, param6, param7, param8, param9}, Locale.JAPANESE);
	}

	public String getMessage(String key, List<String> list) {
		String[] array = list.toArray(new String[list.size()]);
		return messageSource.getMessage(key, array, Locale.JAPANESE);
	}

	public String getMessage(String key, String[] array) {
		return messageSource.getMessage(key, array, Locale.JAPANESE);
	}

}
