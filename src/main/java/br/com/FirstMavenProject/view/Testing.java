/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.FirstMavenProject.view;

import br.com.FirstMavenProject.model.Endereco;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author lucas
 */
public class Testing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String cep = new Scanner(System.in).nextLine();
            URL url = new URL("http://viacep.com.br/ws/" + cep + "/json/");
            InputStreamReader reader = new InputStreamReader(url.openStream());
            BufferedReader bufferedReader = new BufferedReader(reader);
            Stream<String> texto = bufferedReader.lines();
            StringBuffer stringBuffer = new StringBuffer();
            texto.forEach((String t) -> {
                stringBuffer.append(t).append("\n");
            });
            Endereco endereco = new Gson().fromJson(stringBuffer.toString(), Endereco.class);
            System.out.println("Bairro: " + endereco.getBairro());
            System.out.println("Cep: " + endereco.getCep());
            System.out.println("Complemento: " + endereco.getComplemento());
            System.out.println("Gia: " + endereco.getGia());
            System.out.println("IBGE: " + endereco.getIbge());
            System.out.println("Localidade: " + endereco.getLocalidade());
            System.out.println("Logradouro: " + endereco.getLogradouro());
            System.out.println("Uf: " + endereco.getUf());
            System.out.println("Unidade: " + endereco.getUnidade());
        } catch (MalformedURLException ex) {
            Logger.getLogger(Testing.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Testing.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
