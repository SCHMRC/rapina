package it.marcoschiavo.thread;


//Classe Agente che estende Thread e simula l'intervento della polizia
public class Agente extends Thread{
	// Flag che indica se la password è stata trovata o se i ladri sono stati "beccati"
	private boolean flag = false;
	
	// Riferimenti ai thread Ladro e Rapinatore
	Ladro ladro;
	Rapinatore rapinatore;
	
	public Agente(Ladro l1, Rapinatore l2) {	
		this.ladro = l1;
		this.rapinatore = l2;
	}
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public boolean getFlag() {
		return this.flag;
	}
	
	@Override
	public void run(){
		try {
			// Attesa iniziale di 100 millisecondi prima dell'intervento
			Thread.sleep(100);
			System.out.println("La polizia inizia a correre!");
			// Ciclo che simula il tempo a disposizione per "catturare" i ladri
			for(int i = 0 ; i < 10 ; i++) {
					System.out.println(i+1);
					Thread.sleep(1000);
					// Se uno dei ladri ha già trovato la password, interrompe l'azione della polizia
					if(ladro.getFlag() || rapinatore.getFlag()) {
						return;
					}
				
			}
			
			// Se il ciclo termina senza che nessuno abbia trovato la password, la polizia "becca" i ladri
			System.out.println("Beccati");
			setFlag(true);// Imposta il flag per indicare che i ladri sono stati catturati
			
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
