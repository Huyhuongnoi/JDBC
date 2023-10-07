package model;

public class Books {
    private String id;
    private String bookName;
    private float rate;
    private int status;

    public Books() {
        super();
    }

    public Books(String id, String bookName, float rate, int status) {
        this.id = id;
        this.bookName = bookName;
        this.rate = rate;
        this.status = status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public float getRate() {
        return rate;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id='" + id + '\'' +
                ", bookName='" + bookName + '\'' +
                ", rate=" + rate +
                ", status=" + status +
                '}';
    }
}
