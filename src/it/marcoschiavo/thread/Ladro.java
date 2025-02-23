package it.marcoschiavo.thread;

public class Ladro extends Thread{
	// Valore massimo per l'iterazione
	private final int MAX = 9999;
	// Flag per indicare se la password è stata trovata
	private boolean flag;
	// Variabile che memorizza la password da trovare
	private int password;
	// Riferimento all'Agente, per verificare se la polizia ha già agito
	private Agente agente;
	
	public Ladro() {
		
	}
	// Metodo per impostare il riferimento all'Agente
	public void setAgente(Agente agente) {
		this.agente = agente;
	}
	// Metodo per impostare la password da cercare
	public void setPassword(int pass) {
		this.password = pass;
	}
	
	/**
     * Metodo utilizzato dalla classe Agente per verificare se il ladro ha trovato la password
     * @return true se la password è stata trovata, false altrimenti
     */
	public boolean getFlag() {
		return this.flag;
	}
	
	/**
     * Imposta il flag: se true significa che la password è stata trovata
     * @param flag
     */
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	@Override
	public void run() {
		System.out.println("Inizia il thread " + getName());
		try {
			 // Ciclo che va da 0 a MAX, continuando finché la polizia non ha agito
			for(int i = 0 ; i < MAX && !agente.getFlag() ; i++) {
				// Se il valore corrente corrisponde alla password, il ladro ha trovato la password
				if(i == this.password) {
					System.out.println("Il ladro " + getName() + " ha trovato la password!: "+this.password);
					setFlag(true);// Imposta il flag del ladro
					agente.setFlag(true);// Notifica l'agente che la password è stata trovata
					return;// Termina l'esecuzione del thread
				}
				Thread.sleep(5); // Attesa di 5 millisecondi tra un controllo e l'altro
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
