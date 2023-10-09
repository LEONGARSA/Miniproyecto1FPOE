/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;
import Jugador.Jugador;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author LEONARDO
 */
public class Logica  {
    private Jugador jugador;
    private String url;

     public Logica (){
         
        url="src/Imagenes/imgFiguras";
                    
    }

         private String getElementRandomly(List<String> list)
    {
        int max = list.size();

        int rand = (int)(Math.random() * max);

        String element = list.get(rand);


        return element;
    }

    private List<String> listFilesInFolder(String url) 
    {
        // Specify the path of the folder you want to list
        String folder = url;

        // Create a File object to represent the folder
        File directory = new File(folder);

        // Initialize a list to store file names
        List<String> fileNames = new ArrayList<>();

        // Check if the folder exists
        if (directory.exists() && directory.isDirectory()) 
        {
            // List the files inside the folder
            File[] files = directory.listFiles();

            // Iterate over the files and add their names to the list
            for (File file : files) 
            {
                fileNames.add(url+"/"+file.getName());
                
            }
        } 

        else 
        {
            System.out.println("The folder does not exist or is not a valid folder.");
        }

        // Return the list of file names
        return fileNames;
    }

    public List<String> getFigures(String url) // The path of the figures must be provided
    {
        List<String> figures;
        String figure;

        figure = getElementRandomly(listFilesInFolder(url)); //Choose a figure randomly

        figures = listFilesInFolder(figure); // Get the chosen figure with its color
        Collections.shuffle(figures); // Shuffle the elements

        return figures;
    }

    public List<String> getFigures() // The same as the previous method but using the url of the class
    {
        List<String> figures;
        String figure;
        
        figure = getElementRandomly(listFilesInFolder(url)); //Choose a figure randomly

        figures = listFilesInFolder(figure); // Get the chosen figure with its color
        Collections.shuffle(figures); // Shuffle the elements

        return figures;
    }


}
