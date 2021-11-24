package pakiet.pg;



public class Mieszkaniec implements Comparable<Mieszkaniec>   {

    protected String Imie;
    protected String Nazwisko;
    protected int Wiek;

    public Mieszkaniec(String imie, String nazwisko, int wiek) {
        Imie = imie;
        Nazwisko = nazwisko;
        Wiek = wiek;
    }

    public String getImie() {
        return Imie;
    }

    public String getNazwisko() {
        return Nazwisko;
    }

    public int getWiek() {
        return Wiek;
    }

    public void setImie(String imie) {
        Imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        Nazwisko = nazwisko;
    }

    public void setWiek(int wiek) {
        Wiek = wiek;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mieszkaniec that = (Mieszkaniec) o;

        if (Wiek != that.Wiek) return false;
        if (Imie != null ? !Imie.equals(that.Imie) : that.Imie != null) return false;
        return Nazwisko.equals(that.Nazwisko);
    }

    @Override
    public int hashCode() {
        int result = Imie != null ? Imie.hashCode() : 0;
        result = 31 * result + Nazwisko.hashCode();
        result = 31 * result + Wiek;
        return result;
    }

    @Override
    public int compareTo(Mieszkaniec o) {
        return Nazwisko.compareTo(o.Nazwisko);
    }
}


