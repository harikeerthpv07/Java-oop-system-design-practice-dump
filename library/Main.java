import java.util.ArrayList;
public class Main{
    public static void main(String[] args){
        Library lib=new Library();
        lib.addBook(new Book("Harry Potter", "J.K. Rowling", "HP1"));
        lib.addBook(new Book("Java Basics", "Herbert Schildt", "JB1"));
        lib.addMember(new Member("Hari", 1));
        lib.addMember(new Member("Arjun", 2));
        lib.borrowBook("HP1", 1);
        lib.returnBook("HP1", 1);
        System.out.println("Total borrowed so far: " + Library.getTotalBorrowed());
        
    }
}


class Library{
    ArrayList<Book> books =new ArrayList<>();
    ArrayList<Member> members=new ArrayList<>();
    static int totalBorrowed=0;
    
    void addBook(Book b){
        books.add(b);
    }
    void addMember(Member m){
        members.add(m);
    }
    void borrowBook(String isbn,int memberId){
        for(Book b:books){
            if(b.isbn.equals(isbn) && b.isAvailable){
                b.isAvailable=false;
                totalBorrowed++;
                System.out.println("Book borrowed by member " +memberId);
                return;
            }
        }
        System.out.println("Book not available!");
    }
    void returnBook(String isbn,int memberId){
        for(Book b:books){
            if(b.isbn.equals(isbn) && !b.isAvailable){
                b.isAvailable=true;
                System.out.println("Book returned by member " + memberId);
                return;
            }
        }
        System.out.println("Book not borrowed or ISBN wrong");
    }
    static int getTotalBorrowed() {
        return totalBorrowed;
    }
}


class Book{
    String title,author,isbn;
    boolean isAvailable;
    Book(String title,String author,String isbn){
        this.title=title;
        this.author=author;
        this.isbn=isbn;
        isAvailable=true;
    }
    public String toString(){
        return "Title: "+title+", "+"Author: "+author+"Isbn: "+isbn+"Is available: "+isAvailable;
    }
}

class Member{
    String name;int memberId;
    Member(String name,int memberId){
        this.name=name;
        this.memberId=memberId;
    }
}