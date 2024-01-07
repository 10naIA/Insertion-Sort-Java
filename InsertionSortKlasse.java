/* Her er en algoritme som implementerer Insertion sort. Den sammenligner tall i en liste, og tallene til venstre for dette,
og bytter plass hvis de er usortert. */

class InsertionSortKlasse {
    // Array som skal lagre antall sammenligninger og bytter. 4 plasser fordi n og tid ogsaa skal legges til
    long [] miniRes = new long[4];
    long cmpTeller = 0;
    long antBytter = 0;

    public int[] insertionSort (int[] A) {
        int j = 0;
        // Legger bare til resultater, uten aa bruke for-loop, hvis arrayen har 0/1 elementer.
        if(A.length <= 1) {
            miniRes[1] = cmpTeller;
            miniRes[2] = antBytter;
        }
        // Starter iterering paa indeks 1, siden vi skal sammenligne elementer til venstre
        for(int i = 1; i < A.length; i++) {
            j = i;
            while(j > 0 && A[j-1] > A[j]) {
                cmpTeller ++;
                // Lagrer tallene som skal byttes i hver sine variabler, saa ingenting blir overskrevet
                int midlJ = A[j];
                int midlJminusEn = A[j-1];
                A[j] = midlJminusEn;
                A[j-1] = midlJ;
                antBytter ++;
                // Trekker fra 1 for aa sjekke alle elementene til venstre i de neste while-loop-iterasjonene
                j --;
            }
            // Øker antall sammenligninger for indeksene som ikke entrer while-loopen 
            if(j > 0 && A[j-1] <= A[j]) {
                cmpTeller ++;
            }
            miniRes[1] = cmpTeller;
            miniRes[2] = antBytter;
        }
        return A;
    }

    public long[] hentMiniRes() {
        return miniRes;
    }
}