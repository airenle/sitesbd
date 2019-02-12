package Dao;

public class Page {

    private int Id;
    private String Type;
    private String Link;
    private String Content;

    public Page() {
        super();
    }

    public Page(String type, String link, String content) {
    this.Type = type;
    this.Link = link;
    this.Content = content;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
