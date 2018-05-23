package com.spisoft.endpoints;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.spisoft.entities.Product;
import com.spisoft.service.ProductServiceImpl;

@Named
@Path("/product")
public class ProductEndpoint {

	@Inject
	ProductServiceImpl productServiceImpl;

	@Inject
	public ProductEndpoint(ProductServiceImpl productServiceImpl) {
		super();
		this.productServiceImpl = productServiceImpl;
	}

	@GET
	@Path("/productType")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProductByType(@PathParam("productType") String productType) {
		Product product = productServiceImpl.findByType(productType);
		return Response.ok(product).build();

	}

	@GET
	@Path("/price/{priceByName}")
	public Response findPriceByName(@PathParam("productName") String productName) {
		List<Product> product = productServiceImpl.findPriceByName(productName);
		return Response.ok(product).build();

	}

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addProduct(Product products) {
		List<Product> product = productServiceImpl.createProduct(products);
		return Response.ok().build();
	}

	@DELETE
	@Path("/delete/{productId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteArticle(@PathParam("productId") long productId) {
		productServiceImpl.deleteProduct(productId);
		return Response.noContent().build();
	}

}
