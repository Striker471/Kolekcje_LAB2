package pakiet.pg;


import java.util.*;
import java.util.Map.Entry;
/**
 * Program: Aplikacja działająca w oknie konsoli, która umożliwia testowanie
 *          operacji wykonywanych na obiektach klasy Person.
 *    Plik: PersonConsoleApp.java
 *
 *   Autor: Paweł Rogaliński
 *    Data: październik 2018 r.
 */
public class PersonConsoleApp {

    private static final String GREETING_MESSAGE =
            "Program Person - wersja konsolowa\n" +
                    "Autor: Jakub Budzilo przy wykorzystaniu programu Pawła Rogalińskiego\n" +
                    "Data:  listopad 2011 r.\n";
    private static final String KOLEKCJE =
            "1 - Hashset    \n" +
                    "2 - Treeset    \n" +
                    "3 - ArrayList  \n" +
                    "4 - LinkedList \n" +
                    "5 - Hashmap    \n" +
                    "6 - TreeMap    \n"+
                    "7 - Przetestowanie metody Equals i hashcode\n"+
                    "0 - Zakoncz program    \n";
    private static final String KOLEKCJA =
            "1 - Dodaj osobe\n" +
                    "2 - Dodaj wielekrotnie osobe\n" +
                    "3 - Usun osobe\n" +
                    "4 - Wyswietl wszystkie osoby\n";
    private static final String ILOSC =
            "Podaj ilosc dodanych takich samych obiektow: ";


    /**
     * ConsoleUserDialog to pomocnicza klasa zawierająca zestaw
     * prostych metod do realizacji dialogu z użytkownikiem
     * w oknie konsoli tekstowej.
     */
    private static final ConsoleUserDialog UI = new ConsoleUserDialog();


    public static void main(String[] args) {
        // Utworzenie obiektu aplikacji konsolowej
        // oraz uruchomienie głównej pętli aplikacji.
        PersonConsoleApp application = new PersonConsoleApp();
        application.runMainLoop();
    }


    /*
     *  Referencja do obiektu, który zawiera dane aktualnej osoby.
     */
    private Mieszkaniec currentPerson = null;


    /*
     *  Metoda runMainLoop wykonuje główną pętlę aplikacji.
     *  UWAGA: Ta metoda zawiera nieskończoną pętlę,
     *         w której program się zatrzymuje aż do zakończenia
     *         działania za pomocą metody System.exit(0);
     */
    public void runMainLoop() {
        UI.printMessage(GREETING_MESSAGE);
        Set<Mieszkaniec> hashset = new HashSet();
        Set<Mieszkaniec> treeset = new TreeSet();
        ArrayList<Mieszkaniec> arraylist = new ArrayList();
        LinkedList<Mieszkaniec> linkedlist = new LinkedList<>();
        HashMap<Integer,Mieszkaniec> hashmap = new HashMap<>();
        TreeMap<Integer,Mieszkaniec> treemap = new TreeMap<>();
        int wybor = 0;
        int a=0;
        int b=0;

        while (true) {
            UI.clearConsole();
            switch (UI.enterInt(KOLEKCJE + "")) {
                case 1: {
                    wybor = UI.enterInt(KOLEKCJA);
                    if (wybor == 1)
                        hashset.add(stworzMieszkanca());
                    else if (wybor == 2)
                    {
                        int x=UI.enterInt(ILOSC);
                        currentPerson=stworzMieszkanca();
                        for(int i=0;i<x;i++)
                            hashset.add(currentPerson);
                    }
                    else if (wybor == 3)
                        hashset.remove(stworzMieszkanca());
                    else
                        for(Mieszkaniec j:hashset)
                            System.out.println(j.getImie()+ " " + j.getNazwisko()+ " "+ j.getWiek());
                    break;
                }
                case 2: {
                    wybor = UI.enterInt(KOLEKCJA);
                    if (wybor == 1)
                        treeset.add(stworzMieszkanca());
                    else if (wybor == 2)
                    {
                        int x=UI.enterInt(ILOSC);
                        currentPerson=stworzMieszkanca();
                        for(int i=0;i<x;i++)
                            treeset.add(currentPerson);
                    }
                    else if (wybor == 3)
                        treeset.remove(stworzMieszkanca());
                    else
                        for(Mieszkaniec j:treeset)
                            System.out.println(j.getImie()+ " " + j.getNazwisko()+ " "+ j.getWiek());
                    break;
                }
                case 3: {
                    wybor = UI.enterInt(KOLEKCJA);
                    if (wybor == 1)
                        arraylist.add(stworzMieszkanca());
                    else if (wybor == 2)
                    {
                        int x=UI.enterInt(ILOSC);
                        currentPerson=stworzMieszkanca();
                        for(int i=0;i<x;i++)
                            arraylist.add(currentPerson);
                    }
                    else if (wybor == 3)
                        arraylist.remove(UI.enterInt("Podaj ktory nr na liscie usunac: "));
                    else
                        for(Mieszkaniec j:arraylist)
                            System.out.println(j.getImie()+ " " + j.getNazwisko()+ " "+ j.getWiek());
                    break;
                }
                case 4: {
                    wybor = UI.enterInt(KOLEKCJA);
                    if (wybor == 1)
                        linkedlist.add(stworzMieszkanca());
                    else if (wybor == 2)
                    {
                        int x=UI.enterInt(ILOSC);
                        currentPerson=stworzMieszkanca();
                        for(int i=0;i<x;i++)
                            linkedlist.add(currentPerson);
                    }
                    else if (wybor == 3)
                        linkedlist.remove(UI.enterInt("Podaj ktory nr na liscie usunac: "));
                    else
                        for(Mieszkaniec j:linkedlist)
                            System.out.println(j.getImie()+ " " + j.getNazwisko()+ " "+ j.getWiek());
                    break;
                }
                case 5: {
                    wybor = UI.enterInt(KOLEKCJA);
                    if (wybor == 1) {
                        hashmap.put(a, stworzMieszkanca());
                        a++;
                    }
                    else if (wybor == 2)
                    {
                        int x=UI.enterInt(ILOSC);
                        currentPerson=stworzMieszkanca();
                        for(int i=0;i<x;i++) {
                            hashmap.put(a, currentPerson);
                            a++;
                        }
                    }
                    else if (wybor == 3) {
                        hashmap.remove(UI.enterInt("Podaj ktory nr na liscie usunac: "));
                        a--;
                    }
                    else
                        for(Entry<Integer, Mieszkaniec> entry : hashmap.entrySet    ()){
                            System.out.println(entry.getKey()+" "+entry.getValue().getImie()+" "
                                    +entry.getValue().getNazwisko()+" "+entry.getValue().getWiek());
                        }

                    break;
                }
                case 6: {
                    wybor = UI.enterInt(KOLEKCJA);
                    if (wybor == 1) {
                        treemap.put(b, stworzMieszkanca());
                        b++;
                    }
                    else if (wybor == 2)
                    {
                        int x=UI.enterInt(ILOSC);
                        currentPerson=stworzMieszkanca();
                        for(int i=0;i<x;i++) {
                            treemap.put(b, currentPerson);
                            b++;
                        }
                    }
                    else if (wybor == 3) {
                        treemap.remove(UI.enterInt("Podaj ktory nr na liscie usunac: "));
                        b--;
                    }
                    else {
                        for(Entry<Integer, Mieszkaniec> entry : treemap.entrySet    ()){
                            System.out.println(entry.getKey()+" "+entry.getValue().getImie()+" "
                                    +entry.getValue().getNazwisko()+" "+entry.getValue().getWiek());
                        }

                    }
                    break;
                }
                case 7 : {
                    PorownanieEquauls();
                }
                break;
                case 0: {
                    UI.printInfoMessage("\nProgram zakończył działanie!");
                    System.exit(0);
                }
            }
        }
    }
    static Mieszkaniec stworzMieszkanca() {
        String imie = UI.enterString("Podaj imię: ");
        String nazwisko = UI.enterString("Podaj nazwisko: ");
        int wiek = UI.enterInt("Podaj wiek.: ");
        Mieszkaniec mieszkaniec = new Mieszkaniec(imie, nazwisko, wiek);
        return mieszkaniec;
    }
    public void PorownanieEquauls() {
        currentPerson = stworzMieszkanca();
        MieszkaniecEqual mieszkaniecEqual= new MieszkaniecEqual(currentPerson);
        System.out.println("Wykorzystanie metody hashcode: " + mieszkaniecEqual.hashCode());
        System.out.println("Nie wykorzystanie metody hashcode: " + mieszkaniecEqual.hashCode());

        Mieszkaniec currentPersonkopia = new Mieszkaniec(currentPerson.getImie(), currentPerson.getNazwisko(), currentPerson.getWiek());
        MieszkaniecEqual mieszkaniecEqualkopia = new MieszkaniecEqual(currentPersonkopia);
        System.out.println("Wynik porownania equals dla skopiowanych elementow z metoda equals: " +
                mieszkaniecEqualkopia.equals(mieszkaniecEqual));
        System.out.println("Wynik porownania equals dla skopiowanych elementow bez metody equals: " +
                currentPerson.equals(currentPersonkopia));
    }
}

