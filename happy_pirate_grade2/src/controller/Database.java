package controller;

import model.Registry;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Database {
    private static final String FILE_NAME = "src/controller/members.xml";

    /**
     * Method to load in the content of the database file.
     * @return Object Registry.
     */
    public Registry readFromDB(){
        try{
            JAXBContext context = JAXBContext.newInstance(Registry.class);
            Unmarshaller un = context.createUnmarshaller();
            Registry temp = (Registry) un.unmarshal(new File(FILE_NAME));
            return temp;
        } catch(JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Takes the object Registry and updates the file accordingly.
     * @param Registry
     */
    public void writeToDB(Registry Registry){
        try {
            JAXBContext context = JAXBContext.newInstance(Registry.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Write to System.out for debugging
            //m.marshal(Registry, System.out);

            // Write to File
            m.marshal(Registry, new File(FILE_NAME));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
