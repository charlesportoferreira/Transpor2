/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transpor2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author charleshenriqueportoferreira
 */
public class Transpor2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String oldFile;
        String newFile;
        if (args.length == 2) {
            oldFile = args[0];
            newFile = args[1];
        } else {
            oldFile = "oldFile.txt";
            newFile = "newFile.txt";
        }
        try {
            new Transpor2().limpaDados(oldFile, newFile);
        } catch (IOException ex) {
            System.out.println("Something wrong... check the code...");
        }

    }

    public void limpaDados(String oldFile, String newFile) throws FileNotFoundException, IOException {
        String linha;
        try (FileReader fr = new FileReader(oldFile); BufferedReader br = new BufferedReader(fr)) {
            while (br.ready()) {
                linha = br.readLine();
                linha = linha.replaceAll("\".*\",|", "");
                linha = linha.substring(0, linha.lastIndexOf(","));
                salvaLinhaDados(newFile, linha);
            }
            br.close();
            fr.close();
        }
    }

    private void salvaLinhaDados(String fileName, String dado) throws IOException {
        try (FileWriter fw = new FileWriter(fileName, true); BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(dado);
            bw.newLine();
            bw.close();
            fw.close();
        }
    }

}
