public class Lenkeliste<T> implements Liste<T> {
    protected Node start = null;
    protected Node siste = null;


    //Protected slik at man har tilgang til disse variablene i subklassene.
    protected class Node {
        protected Node neste;
        protected T data;

        // public Node(String element)
        protected Node(T x) {
            data = x;
        }
    }

    // Ok.
    public int stoerrelse() {
        Node tmp = start;
        int teller = 0;

        while (tmp != null) {
            teller++;
            tmp = tmp.neste;
        }
        return teller;
    }

    //Ok.
    public void leggTil(int pos, T x) {
        if (pos > (stoerrelse()) || pos < 0){
            throw new UgyldigListeIndeks(pos);
        }

        Node nyNode = new Node(x);
        Node tmp = start;

        if (pos == 0) {
            nyNode.neste = start;
            start = nyNode;

        } else {
            for (int i = 0; i < pos -1; i++) tmp = tmp.neste;
            //Her må man ha begge pekere til å peke på den bak, FØR man bytter tmp.neste til nynode!
            //ellers er det ingen pekere til den gamle noden!
            nyNode.neste = tmp.neste;
            tmp.neste = nyNode;

            //Hvis jeg skal ha med siste peker
            if (pos == stoerrelse()) siste = nyNode;
        }

    }

    //Oppretter ny node og legger til ny node bakerst.
    @Override
    public void leggTil(T x) {
        Node nyNode = new Node(x);
        Node tmp = start;

        if (start == null) {
            start = nyNode;
            siste = nyNode;
        } else {
            while (tmp.neste != null) {
                tmp = tmp.neste;
            }
            tmp.neste = nyNode;
//            siste.neste = nyNode;
            siste = nyNode;
        }
    }

    // Erstatte en annen node, endrer kun på data.
    public void sett(int pos, T x) {
        if (pos > stoerrelse()-1 || pos < 0) throw new UgyldigListeIndeks(pos);

        Node tmp = start;
        for (int i = 0; i < pos; i++) {
            tmp = tmp.neste;
        }
        tmp.data = x;
    }

    //Ok
    public T hent(int pos) {
        if (pos > (stoerrelse())-1 || pos < 0){
            throw new UgyldigListeIndeks(pos);
        }

        Node tmp = start;

        for (int i = 0; i < pos; i++) tmp = tmp.neste;
        return tmp.data;
    }

    public T fjern(int pos) {
        if (pos > stoerrelse()-1 || pos < 0) throw new UgyldigListeIndeks(pos);

        Node tmp = start;

        if (pos == 0) {
            start = tmp.neste;
            return tmp.data;
        }

        for (int i = 0; i < pos-1; i++) {
            tmp = tmp.neste;
        }
        Node n = tmp.neste;
        tmp.neste = n.neste;
        return n.data;
    }

    // fjerne og returnere elementet på starten av lista;
    public T fjern() {
        if (start == null) {
            throw new UgyldigListeIndeks(-1);
        }

        Node tmp = start;
        start = tmp.neste;
        return tmp.data;
    }
}