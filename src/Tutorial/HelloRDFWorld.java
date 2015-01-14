package Tutorial;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.util.FileManager;
import com.hp.hpl.jena.vocabulary.VCARD;

	public class HelloRDFWorld {

		private String personURI = "http://sindresside.com/sindreMoldeklev";
		private String fullName = "Sindre Moldeklev";
		private String givenName = "Sindre";
		private String familyName = "Moldeklev";
		
		private Model model;
		private Resource sindreM;
		
		public HelloRDFWorld(){
			
		model = ModelFactory.createDefaultModel();
		
		sindreM = model.createResource(personURI);
		
		sindreM.addProperty(VCARD.FN, fullName);
		
		sindreM.addProperty(VCARD.N, model.createResource().addProperty(VCARD.Given, givenName));
		sindreM.addProperty(VCARD.N, model.createResource().addProperty(VCARD.Family, familyName));
		
		}
		
		public void readFile(){
			model = null;
			model = ModelFactory.createDefaultModel();
			String filename = "learningJena.rdf";
			try{
				InputStream in = FileManager.get().open( filename );
				model.read(in, null);
				model.write(System.out);
			} catch (Exception e){
				e.printStackTrace();
			}
			
			
			
			
			
		}
		
		public void printStatements(){
			StmtIterator iter = model.listStatements();
			
			while(iter.hasNext()){
				Statement stmt = iter.nextStatement();
				Resource subject = stmt.getSubject();
				Property predicate = stmt.getPredicate();
				RDFNode object = stmt.getObject();
				
				System.out.print(subject.toString());
				System.out.print(" " + predicate.toString() + " ");
				if(object instanceof Resource){
					System.out.print(object.toString());
				} else {
					System.out.print(" \"" + object.toString() + "\"");
				}
				System.out.println(" .");
			}
			
		}
		
		public void toXML(){
			model.write(System.out);
		}
		
		public void toNTriples(){
			model.write(System.out, "N-TRIPLES");
		}
		
		public void toPrettyXML(){
			model.write(System.out, "RDF/XML-ABBREV");
		}
		
		public void writeToFile(){
			try{
				String filename = "learningJena.rdf";
				FileWriter fw = new FileWriter(filename);
				model.write(fw, "RDF/XML-ABBREV");
			} catch (IOException e){
				e.printStackTrace();
			} finally {
				
				System.out.println("File was sucessfully written");
			}
		}
		
		public String toString(){
		
			return fullName + " has a uri: " + personURI + ". His family name is " + familyName + " and his given name is " + givenName;
		}

		public Resource getResource(){
			Resource vcard = model.getResource(personURI);
			return vcard;
		}
		
		
	}
	


