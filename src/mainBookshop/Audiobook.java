package mainBookshop;

public class Audiobook extends Book {
    private String narrator;

    public Audiobook(int id, String title, String author, String isbn, String date, boolean availability, String narrator) {
        super(id, title, author, isbn, date, availability);
        this.narrator = narrator;
    }

    public String getNarrator() {
        return narrator;
    }

    @Override
    public String toString() {
        return super.toString() + ", Narrator=" + narrator + "]";
    }
}