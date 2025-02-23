package it.marcoschiavo.thread;

public class Rapinatore extends Thread{
	private final int MAX = 9999;
	private int password;
	private boolean flag = false;
	private Agente agente;
	
	public Rapinatore() {}
	
	public void setAgente(Agente agente) {
		this.agente = agente;
	}
	
	public void setPassword(int pass) {
		this.password = pass;
	}
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public boolean getFlag() {
		return this.flag;
	}
	
	@Override
	public void run() {
		try {
			System.out.println("Inizia il thread "+ getName());
			for(int i = MAX ; i > 0 && !agente.getFlag() ; i--) {
				if(i == this.password) {
					System.out.println("Il ladro " + getName() + " ha trovato la password!" + this.password);
					setFlag(true);
					agente.setFlag(true);
					return;
				}
				Thread.sleep(5);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

		
	}
	
	
}
