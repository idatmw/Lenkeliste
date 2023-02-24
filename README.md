# Lenkeliste
I denne oblig lærte jeg om konseptet lister ved å implementere en egen lenket liste. 
Datastrukturen består av noder som inneholder data og én eller flere referanser til neste eller forrige node.

Konsepter: Interface(Liste.java) og arv.

Metoder i Lenkeliste.java (FIFO-liste):
1. stoerrelse(): Sjekker antall elementer i lista.
2. leggTil(int pos, T x): Legger til ny node i en spesifikk posisjon i lista.
3. leggTil(T x): Legger til ny node bakerst i lista.
4. sett(int pos, T x): Erstatter en node, endrer altså kun data på noden. 
5. hent(int pos): Henter data i et element i gitt posisjon.
6. fjern(int pos): Fjerner element i en gitt posisjon.
7. fjern(): Fjerner og returnerer elementet på starten av lista. 

Metoder i Stabel.java (FILO-liste):
1. leggPaa(T x): Legger til et element bakerst i lista.
2. taAv(): Fjerner bakerste elementet i lista. 

Metoder i SortertLenkeliste.java 
1. leggTil(T x): Legger et element i lista i sortert rekkefølge (fra minst til størst)
2. fjern(): Fjerner det største elementet i lista.
