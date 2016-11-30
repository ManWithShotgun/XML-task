package ru.task;

import ru.task.Candies;
import ru.task.IngredientsType;
import ru.task.PropType;

import javax.xml.bind.*;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by ILIA on 30.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        try {
            Candies candies=unmarshaling("candies.xml");
            marshaling(candies,"out.xml");
            staxWriting(candies,"out2.xml");

        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void marshaling(Candies candies, String path){
        try {
            JAXBContext context = JAXBContext.newInstance(Candies.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            File file=new File(path);
            file.createNewFile();
            marshaller.marshal(candies, file);
        } catch (PropertyException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Candies unmarshaling(String path){
        try {
            JAXBContext jaxbContext=JAXBContext.newInstance(Candies.class);
            Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();
            return (Candies) unmarshaller.unmarshal(new File(path));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void staxWriting(Candies candies, String path) throws IOException, XMLStreamException {
        File file=new File(path);
        file.createNewFile();
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = factory.createXMLStreamWriter(new FileWriter(file));
        writer.writeStartDocument("utf-8", "1.0");
        writer.writeStartElement("c","candies","http://www.candy.ru");
        writer.writeAttribute("xmlns:c","http://www.candy.ru");
        writer.writeAttribute("xmlns:i","http://www.ingredients.ru");

        for (Candies.Candy candy : candies.getCandy()){
            writer.writeStartElement("c:candy");
            writer.writeAttribute("nameCandy",candy.getNameCandy());
            writer.writeAttribute("calories",Integer.toString(candy.getCalories()));
            writer.writeAttribute("typeCandy",candy.getTypeCandy().value());
            writer.writeAttribute("producer",candy.getProducer());
            staxWritingIngredients(writer,candy.getIngredients());
            staxWritingProperties(writer,candy.getProperties());
            writer.writeEndElement();
        }

        writer.writeEndElement();
        writer.writeEndDocument();
        writer.flush();
    }

    private static void staxWritingIngredients(XMLStreamWriter writer, IngredientsType ingredients) throws XMLStreamException {
        writer.writeStartElement("c:ingredients");

        writer.writeStartElement("i:water");
        writer.writeCharacters(Integer.toString(ingredients.getWater()));
        writer.writeEndElement();

        writer.writeStartElement("i:sugar");
        writer.writeCharacters(Integer.toString(ingredients.getSugar()));
        writer.writeEndElement();

        writer.writeStartElement("i:fructose");
        writer.writeCharacters(Integer.toString(ingredients.getFructose()));
        writer.writeEndElement();

        if(ingredients.getChocolate()!=null){
            writer.writeStartElement("i:chocolate");
            writer.writeCharacters(ingredients.getChocolate().value());
            writer.writeEndElement();
        }
        writer.writeStartElement("i:vanilin");
        writer.writeCharacters(Integer.toString(ingredients.getVanilin()));
        writer.writeEndElement();

        writer.writeEndElement();
    }

    private static void staxWritingProperties(XMLStreamWriter writer, PropType properties) throws XMLStreamException {
        writer.writeStartElement("c:properties");

        writer.writeStartElement("c:proteins");
        writer.writeCharacters(Integer.toString(properties.getProteins()));
        writer.writeEndElement();

        writer.writeStartElement("c:fats");
        writer.writeCharacters(Integer.toString(properties.getFats()));
        writer.writeEndElement();

        writer.writeStartElement("c:carbohydrate");
        writer.writeCharacters(Integer.toString(properties.getCarbohydrate()));
        writer.writeEndElement();

        writer.writeEndElement();
    }
}
