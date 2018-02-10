package cf.spring.springweb;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author vgrigoriev - 2/1/2018
 * domain object
 */

@XmlRootElement(name = "Book")
public class Book {

    private int id;

    private String name;

    private int authorId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public Book addId(int id) {
        this.setId(id);
        return this;
    }

    public Book addName(String name) {
        this.setName(name);
        return this;
    }

    public Book addAuthor(int authorId) {
        this.setAuthorId(authorId);
        return this;
    }




    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", name='" + name + '\'' + ", authorId=" + authorId + '}';
    }
}
