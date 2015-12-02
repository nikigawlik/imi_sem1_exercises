/**
 * A class that maintains information on a book.
 * This might form part of a larger application such
 * as a library system, for instance.
 *
 * @author (Insert your name here.)
 * @version (Insert today's date here.)
 */
class Book
{
    // The fields.
    private String author;
    private String title;
    private int pages;
    private String refNumber;

    /**
     * Set the author and title fields when this object
     * is constructed.
     */
    public Book(String bookAuthor, String bookTitle, int bookPages)
    {
        author = bookAuthor;
        title = bookTitle;
        pages = bookPages;
        refNumber = "";
    }
    
    public void setRefNumber(String ref)
    {
        if(ref.length() >= 3)
        {
            refNumber = ref
        }
        else
        {
            System.out.println("Error: reference number has to be at least 3 characters long!");
        }
    }
    
    public String getRefNumber()
    {
        return refNumber;
    }
    
    public String getAuthor()
    {
        return author;
    }
    
    public String getTile()
    {
        return title;
    }
    
    public int getPages()
    {
        return pages;
    }
    
    public void printAuthor()
    {
        System.out.println(author);
    }
    
    public void printTitle()
    {
        System.out.println(title);
    }
    
    public void printDetails()
    {
        String str = title + " by " + author + " (" + (refNumber != ""? "ref: " + refNumber + ", " : "")
            + pages + " pages)";
        System.out.println(str);
    }
    
    
    // Add the methods here ...
}
