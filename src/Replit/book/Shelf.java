package Replit.book;

import java.util.ArrayList;
import java.util.List;

public class Shelf {

    /**
     * Constructor is made private to prevent any instantiation.
     * Since all methods in this class are static that can be called
     * without an object
     */

    private Shelf() {
        //nothing todo here.
    }

    /**
     * List<Book> theBooks will hold all book object in the shelf
     * in form of a List of Book objects
     */

    private static List<Book> theBooks = new ArrayList<>();

    /**
     * public static getter method for theBooks list
     * @return theBooks
     */

    public static List<Book> getTheBooks() {
        // TODO

        return theBooks;
    }

    /**
     * isShelfEmpty is used to see if shelf is empty or not.
     * Shelf is empty when List<Book> theBooks has no Book objects added
     *
     * @return true if list is empty or false if not
     */

    public static boolean isShelfEmpty(){
        // TODO
        boolean isEmpty=false;
        if(theBooks.size()==0){
            isEmpty=true;
        }
        return isEmpty;
    }

    /**
     * isIDUnique accepts an id and loops though each Book object in theBooks list
     * and if id was already assigned to another book, it will return false
     * If id was never used, it will return true
     * @param id
     * @return true or false
     */

    public static boolean isIDUnique(int id){

        // TODO
        boolean isID=true;
        for (int i = 0; i < theBooks.size(); i++) {
            if(id==theBooks.get(i).getId()){
                isID=false;
                break;
            }
        }



        return isID;
    }

    /**
     * static addBook method is used to add a book to the Shelf. to List<Book> theBooks
     * @param id
     * @param author
     * @param title
     * @param pages
     * @returns true if Book was successfully added or false if not
     * Conditions:
     *     returns false and does NOT add a book to the list if:
     *      - id is not unique. was already used by other books. Call isIDUnique to check that
     *      - title is empty
     *      - pages <= 0
     *     returns true and adds a new Book object to List<Book> theBooks if:
     *      - all above checks passed.
     *      Shelf.addBook(100,"j.K. rowLing","harry potter",556); => returns true
     *      and adds the book to the list:
     *         theBooks.add(new Book(id,author,title,pages));
     */

    public static boolean addBook(int id, String author, String title, int pages ){
        // TODO

        if(isIDUnique(id)&& !(title.isEmpty())&&(pages>0)){
            theBooks.add(new Book(id,author,title,pages));
            return true;
        }

        return false;
    }

    /**
     * static addBook method is used to add a book to the Shelf. to List<Book> theBooks
     * @param  book object
     * @return true if Book was successfully added or false if not
    Conditions:
     *     returns false and does NOT add a book to the list if:
     *      - book.getId() is not unique. was already used by other books. Call isIDUnique to check that
     *      - book's title is empty
     *      - book's pages <= 0
     *     returns true and adds the Book object to List<Book> theBooks if:
     *      - all above checks passed.
     *
     *      Book book1, book2;
     *      book1 = new Book(44, "shel silverstein" ,"the Giving tRee",532);
     *      book2 = new Book(434, "Dan Brown" ,"the da Vinci coDe",1532);
     *
     *      Shelf.addBook(book1); => true
     *      Shelf.addBook(book1); => true
     *
     */

    public static boolean addBook(Book book){

        // TODO


        if(isIDUnique(book.getId()) && !book.getTitle().isEmpty() && book.getPages()>0){
            theBooks.add(book);
            return true;
        }

        return false;
    }

    /**
     * static getTitleByID method looks up title of the Book by id
     * @param id
     * @return title
     * Loop through each book in Shelf (the theBooks list) and if you find a book
     * matching id then return that book's title
     * Ex:
     *  Assume we have Book id=100, title=Start With Why
     *  Shelf.getTitleByID(100); => "Start With Why"
     *  Shelf.getTitleByID(100534534); => "book not found"
     */

    public static String getTitleByID(int id) {
        String getBook="book not found";
        // TODO
        for (int i = 0; i < theBooks.size(); i++) {
            if(theBooks.get(i).getId()==id){
                getBook=theBooks.get(i).getTitle();
                break;
            }
        }
        return getBook;
    }

    /**
     * static method findBookByPartialTitle
     * Looks for a book and if title parameter matches partially
     * return that book object.
     * @param title: partial string to match
     * @return Book object
     *
     * Assume we have Book id=100, title=Start With Why, Author: Simon Sinek
     *    Shelf.findBookByPartialTitle("start"); => returns that Book object
     *    Shelf.findBookByPartialTitle("why"); => returns that Book object
     *    Shelf.findBookByPartialTitle("Wooden Spoon); returns null
     *
     */

    public static Book findBookByPartialTitle(String title) {
        title=title.toLowerCase();
        // TODO
        for (int i = 0; i < theBooks.size(); i++) {
            if (theBooks.get(i).getTitle().toLowerCase().contains(title)) {
                return (theBooks.get(i));

            }
        }
        return null;

    }

    /**
     * static method getAllBooksForAuthor.
     * Loops through each book in shelf(theBooks list) and returns
     * a new List<Book> objects for that author.
     * If no book is found for that author, returns an empty list
     * @param author
     * @return List<Book> that belongs to that Author
     */

    public static List<Book> getAllBooksForAuthor(String author) {

        // TODO

        List<Book>list1=new ArrayList<>();
        for (int i = 0; i < theBooks.size(); i++) {
            if(theBooks.get(i).getAuthor().equalsIgnoreCase(author)){
                list1.add(theBooks.get(i));
            }
        }
        return list1;
    }

    /**
     * static removeBook method removes the Book from the Shelf(theBooks list)
     * @param id
     * Look for the book in the theBooks list that matches the id and remove it
     * if there is not match, no action needed
     */
    public static void removeBook(int id) {

        // TODO

        for (int i = 0; i < theBooks.size(); i++) {
            if(theBooks.get(i).getId()==id){
                theBooks.remove(theBooks.get(i));
                break;
            }
        }

    }

    /**
     * static removeBook method removes the Book from the Shelf(theBooks list)
     * @param author
     * Look for the book in the theBooks list that matches the author and remove ALL of matches
     * if there is not match, no action needed
     */
    public static void removeBook(String author) {
        // TODO

        for (int i = 0; i < theBooks.size(); i++) {
            if(theBooks.get(i).getAuthor().equals(author)){
                theBooks.remove(theBooks.get(i));
            }
        }

    }

    /**
     * Clears the BookShelf of all books
     */

    public static void clearBookShelf() {
        // TODO
        theBooks.clear();

    }

}