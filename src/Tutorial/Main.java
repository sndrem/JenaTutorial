package Tutorial;

import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.vocabulary.VCARD;

public class Main {

	public static void main(String[] args) {
		
		HelloRDFWorld hello = new HelloRDFWorld();
		
		
		//hello.printStatements();
		//hello.toXML();
		//hello.toNTriples();
		//hello.toPrettyXML();
		//hello.writeToFile();
		//hello.readFile();
		
		Resource vcard = hello.getResource();
		
		System.out.println(vcard.toString());
		
		Resource name = (Resource) vcard.getProperty(VCARD.N).getObject();
		
		System.out.println(name);
		
		String fullName = vcard.getProperty(VCARD.FN).getString();
		
		System.out.println(fullName);
		
		/*
		 * Legg til to nick for Sindre
		 */
		
		vcard.addProperty(VCARD.NICKNAME, "Sid").addProperty(VCARD.NICKNAME, "Simsalabim").addProperty(VCARD.NICKNAME, "Snabelsatan");
		
		System.out.println("The nicknames for \"" + fullName + "\" are: ");
			
			StmtIterator iter = vcard.listProperties(VCARD.NICKNAME);
			while(iter.hasNext()){
				System.out.println("    " + iter.nextStatement().getObject().toString());
			}
		
		
		
		
		
	}

}
