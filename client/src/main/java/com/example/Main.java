package com.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket s = new Socket("localhost", 3000);
        System.out.println("Connected.");
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        String benvenutoServer = in.readLine();
        System.out.println("Received: " + benvenutoServer);
        out.println("BenveClient V 1.0");
        Scanner scanner = new Scanner(System.in);
        do{
        System.out.println("Inserire primo numero");
        int numeroUno = scanner.nextInt();
        out.println(numeroUno);
        System.out.println("Inserire secondo numero ");
        int numeroDue =scanner.nextInt();
        out.println(numeroDue);
        System.out.println("Inserire il tipo di operazione (1 = somma, 2 = sotttrazione, 3 = divisione, 4 = moltiplicazione)");
        int inserireOperazione = scanner.nextInt();
        out.println(inserireOperazione);
        String risultato = new String(in.readLine());
        System.out.println("il risultato è : " + risultato);
        }while(true);
    }
}