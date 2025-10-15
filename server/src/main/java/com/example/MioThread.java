package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MioThread extends Thread{
    Socket s;

    public MioThread(Socket socket){
        this.s = socket;
    }


    public void run(){
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(this.s.getInputStream()));
        PrintWriter out = new PrintWriter(this.s.getOutputStream(), true);
        String BenveServer = new String("BenveServer V 1.0");
        out.println(BenveServer);
        String rispostaClient = in.readLine();
        System.out.println(rispostaClient);
        do{
        String numeroUno = in.readLine();
        Integer n1 = Integer.parseInt(numeroUno); 
        String numeroDue = in.readLine();
        Integer n2 = Integer.parseInt(numeroDue);
        String operazione = in.readLine();
        Integer op = Integer.parseInt(operazione);
        float risultato = 0;
        if(op == 1){
            risultato=n1+n2;
        }
        else if(op == 2){
            risultato = n1-n2;
        }
        else if(op == 3){
            risultato = (float)n1/(float)n2;
        }
        else if(op == 4){
            risultato = n1*n2;
        }
        out.println(Float.toString(risultato));
        }while(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
       

