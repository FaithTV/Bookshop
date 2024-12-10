package mainBookshop;

public class Comicbook extends Book {
    private String illustrator;

    public Comicbook(int id, String title, String author, String isbn, String date, boolean availability, String illustrator) {
        super(id, title, author, isbn, date, availability);
        this.illustrator = illustrator;
    }

    public String getIllustrator() {
        return illustrator;
    }

    @Override
    public String toString() {
        return super.toString() + ". It's illustrator is " + illustrator;
    }
}