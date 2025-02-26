# Caccia alla Password - Simulazione con Thread in Java

## Descrizione
**Caccia alla Password** è un'applicazione console in **Java** che simula una gara tra due ladri (`Ladro` e `Rapinatore`) per trovare una password segreta, mentre un **Agente di polizia** cerca di fermarli prima che ci riescano.

### Come funziona:
- La password è un numero casuale compreso tra **0 e 9999**.
- Due ladri (`Ladro` e `Rapinatore`) provano a **indovinare** la password:
  - Il **Ladro** inizia da **0** e prova a incrementare.
  - Il **Rapinatore** inizia da **9999** e prova a decrementare.
- Un **Agente di polizia** cerca di fermarli:
  - Se l'Agente finisce il suo conto alla rovescia prima che la password venga trovata, i ladri vengono "beccati".
  - Se uno dei due ladri trova la password per primo, la gara finisce e l'Agente si ferma.

---

## Struttura del Progetto
Il progetto è composto dalle seguenti classi:

### **1. Start.java**
- Contiene il `main()` che avvia la simulazione.
- Genera una **password casuale** tra 0 e 9999.
- Crea le istanze di:
  - `Ladro`
  - `Rapinatore`
  - `Agente`
- Avvia i thread:
  - Prima i ladri (`Ladro` e `Rapinatore`)
  - Poi l'`Agente`

---

### **2. Ladro.java**
- Estende `Thread` e rappresenta un **ladro** che prova a **trovare la password** partendo da **0** e incrementando.
- Caratteristiche principali:
  - Incrementa il tentativo da **0** a **9999**.
  - Se trova la password:
    - Mostra un messaggio di successo.
    - Imposta il `flag` per notificare l'`Agente`.
  - Se l'`Agente` lo "becca", si ferma.

---

### **3. Rapinatore.java**
- Estende `Thread` e rappresenta un **rapinatore** che prova a **trovare la password** partendo da **9999** e decrementando.
- Caratteristiche principali:
  - Decrementa il tentativo da **9999** a **0**.
  - Se trova la password:
    - Mostra un messaggio di successo.
    - Imposta il `flag` per notificare l'`Agente`.
  - Se l'`Agente` lo "becca", si ferma.

---

### **4. Agente.java**
- Estende `Thread` e rappresenta un **agente di polizia** che cerca di **fermare i ladri**.
- Caratteristiche principali:
  - Inizia il conto alla rovescia da **10**.
  - Se un ladro trova la password prima che il conto alla rovescia finisca:
    - Si ferma immediatamente.
  - Se termina il conto alla rovescia senza interruzioni:
    - Mostra `Beccati!` e blocca entrambi i ladri.

---

## Diagramma dei Thread
```
          +-------------------+
          |     Start.java    |
          | (Main del gioco)  |
          +-------------------+
                      |
                      |
      +---------------+---------------+
      |                               |
      |                               |
+-----v----+                    +------v-----+
|  Ladro   |                    |  Rapinatore |
| Inizia a |                    | Inizia da   |
|  0 e sale|                    | 9999 e scende|
|----------|                    |-------------|
| Se trova |                    | Se trova    |
| password |                    | password    |
| avvisa   |                    | avvisa      |
| Agente   |                    | Agente      |
+----------+                    +-------------+
                      |
                      |
               +------v------+
               |    Agente   |
               |  Countdown  |
               |  da 10 a 0  |
               |--------------|
               | Se finisce   |
               |  il tempo    |
               |    -->       |
               | "Beccati!"   |
               +--------------+
```

---

## Esecuzione e Configurazione
1. **Clona il repository**:
    ```bash
    git clone https://github.com/marcoschiavo/caccia-alla-password.git
    ```
2. **Importa il progetto in Eclipse** o in un altro IDE Java.
3. **Compila ed esegui** `Start.java` come **Java Application**.

---

## Output Atteso
Quando esegui l'applicazione, potresti vedere un output simile:
```
Inizia il thread Ladro
Inizia il thread Rapinatore
La polizia inizia a correre!
1
2
Il ladro Rapinatore ha trovato la password!: 8743
3
```
- Se un ladro trova la password, l'Agente si ferma.
- Se l'Agente termina il countdown prima, apparirà `Beccati!`.

---

## Possibili Estensioni
- Aggiungere **più ladri** con strategie diverse.
- Cambiare il **range** della password (es. da 0 a 99999).
- Aggiungere un **timer grafico** usando JavaFX.
- Aggiungere una **classe Boss** che prova a trovare la password in modo casuale.

---

## Scopo Didattico
Questo progetto è pensato per:
- **Imparare l'uso dei Thread** in Java in modo semplice.
- Comprendere **la sincronizzazione** tra thread.
- Imparare a gestire la **concorrenza** e l'uso di flag per comunicare tra thread.

---

## Autore
**Marco Schiavo** - [marcoschiavo](https://github.com/marcoschiavo)
