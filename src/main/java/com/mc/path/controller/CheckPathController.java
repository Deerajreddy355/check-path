/**
 * 
 */
package com.mc.path.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mc.path.service.CheckPathService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class CheckPathController {

	@Autowired
	private CheckPathService pathService;

	@RequestMapping(value = "/swagger", method = RequestMethod.GET)
	@ApiOperation(value = "Swagger home")
	public void swagger(HttpServletResponse response) throws IOException {
		response.sendRedirect("swagger-ui.html");
	}

	@RequestMapping(value = "connected", method = RequestMethod.GET)
	@ApiOperation(value = "API to check if the path exists between soure and destination")
	public String checkIfConnected(
			@ApiParam(value = "Src City", required = true) @RequestParam("origin") String origin,
			@ApiParam(value = "Dest City", required = true) @RequestParam("destination") String destination) {
		return pathService.checkIfConnected(origin, destination);
	}
}
