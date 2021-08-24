package Ch18.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Controller { //interface 강제성!
	void execute(HttpServletRequest request, HttpServletResponse response);
	
}
