package Tutorial;

import java.util.ArrayList;
import java.util.List;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;

public class Products {
	
	Model productModel;
	List<Resource> productList;
	
	public Products(){
		productModel = ModelFactory.createDefaultModel();
		productList = new ArrayList<Resource>();
		addResources();
		addProperties();
		printModel();
	}
	
	/*
	 * Method to create a resource and add it to the resource list
	 */
	public void addResources(){
		Resource product1 = productModel.createResource("mfg:Product1");
		Resource product2 = productModel.createResource("mfg:Product2");
		
		productList.add(product1);
		productList.add(product2);
	}
	
	/*
	 * Method to add properties to the resources
	 */
	public void addProperties(){
		//Let's finish the first product first
		Resource product1 = productList.get(0);
		Resource product2 = productList.get(1);
		
		//Load up all variables
		String prodID = "mfg:productIDProp";
		String prodModelNo = "mfg:product_ModelNoProp";
		String prodDiv = "mfg:product_DivisionProp";
		String prodLine = "mfg:product_ProductLineProp";
		String prodManu = "mfg:product_ManufactureLocationProp";
		String prodSKU = "mfg:productSkuProp";
		String prodAvail = "mfg:productAvailableProp";
			
		//Create the properties
		Property productIDProp = productModel.createProperty(prodID);
		Property product_ModelNoProp = productModel.createProperty(prodModelNo);
		Property product_DivisionProp = productModel.createProperty(prodDiv);
		Property product_ProductLineProp = productModel.createProperty(prodLine);
		Property product_ManufactureLocationProp = productModel.createProperty(prodManu);
		Property product_productSKUSku = productModel.createProperty(prodSKU);
		Property product_AvailableProp = productModel.createProperty(prodAvail);
		
		//Add properties to product 1
		product1.addLiteral(productIDProp, 1);
		product1.addProperty(product_ModelNoProp, "ZX-3");
		product1.addProperty(product_DivisionProp, "Manufacturing support");
		product1.addProperty(product_ProductLineProp, "Paper machine");
		product1.addProperty(product_ManufactureLocationProp, "Sacramento");
		product1.addProperty(product_productSKUSku, "FB3524");
		product1.addLiteral(product_AvailableProp, 23);
		
		//Add properties to product 2
		product2.addLiteral(productIDProp, 2);
		product2.addProperty(product_ModelNoProp, "ZX-3P");
		product2.addProperty(product_DivisionProp, "Manufacturing support");
		product2.addProperty(product_ProductLineProp, "Paper machine");
		product2.addProperty(product_ManufactureLocationProp, "Ottawa");
		product2.addProperty(product_productSKUSku, "KD5234");
		product2.addLiteral(product_AvailableProp, 55);
		
		
	}
	
	public void printModel(){
		productModel.write(System.out, "TURTLE");
	}
}
