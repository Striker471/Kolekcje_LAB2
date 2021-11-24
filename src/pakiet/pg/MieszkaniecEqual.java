package pakiet.pg;

public class MieszkaniecEqual extends Mieszkaniec {
    public MieszkaniecEqual(Mieszkaniec mieszkaniec) {
        super(mieszkaniec.getImie(),mieszkaniec.getNazwisko(),mieszkaniec.getWiek());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mieszkaniec that = (Mieszkaniec) o;

        if (getWiek() != that.getWiek()) return false;
        if (getImie() != null ? !getImie().equals(that.getImie()) : that.getImie() != null) return false;
        return getNazwisko().equals(that.getNazwisko());
    }

    @Override
    public int hashCode() {
        int result = getImie() != null ? getImie().hashCode() : 0;
        result = 31 * result + getNazwisko().hashCode();
        result = 31 * result + getWiek();
        return result;
    }
}
