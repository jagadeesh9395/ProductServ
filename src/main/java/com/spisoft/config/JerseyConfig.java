package com.spisoft.config;

import javax.inject.Named;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import com.spisoft.endpoints.ProductEndpoint;

@Named
@ApplicationPath("/")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		register(ProductEndpoint.class);
	}
}