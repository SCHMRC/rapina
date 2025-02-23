package it.marcoschiavo.thread;

import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Start {

	public static void main(String[] args) throws Exception{
		 // Genera una password casuale compresa tra 0 e 9999
		int password = (int) (Math.random() * 10000);
		// Crea le istanze dei thread Ladro e Rapinatore
		Ladro l1 = new Ladro();
		Rapinatore l2 = new Rapinatore();
		
		// Crea l'istanza dell'Agente, passando i riferimenti ai ladri
		Agente a = new Agente(l1,l2);
		
		// Imposta il riferimento all'agente per entrambi i ladri
		l1.setAgente(a);
		l2.setAgente(a);
		
		// Assegna la password da trovare a entrambi i thread (Ladro e Rapinatore)
		l1.setPassword(password);
		l2.setPassword(password);
		
		// Avvia l'esecuzione dei thread: prima i ladri e poi l'agente
		l1.start();
		l2.start();
		a.start();
	}
	}
