import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Manga {
    private String title;
    private String author;
    private int volumes;

    // Constructor
    public Manga(String title, String author, int volumes) {
        this.title = title;
        this.author = author;
        this.volumes = volumes;
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getVolumes() {
        return volumes;
    }

    // Setter methods
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setVolumes(int volumes) {
        this.volumes = volumes;
    }

    // toString method to represent the object as a string
    @Override
    public String toString() {
        return "Manga{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", volumes=" + volumes +
                '}';
    }
}

class Library {
    private List<Manga> mangaCollection;

    // Constructor
    public Library() {
        this.mangaCollection = new ArrayList<>();
    }

    // Add manga to the library
    public void addManga(Manga manga) {
        mangaCollection.add(manga);
    }

    // Remove manga from the library
    public void removeManga(Manga manga) {
        mangaCollection.remove(manga);
    }

    // Getter for mangaCollection
    public List<Manga> getMangaCollection() {
        return mangaCollection;
    }

    // Display all manga in the library
    public void displayLibrary() {
        System.out.println("Manga Library:");
        for (Manga manga : mangaCollection) {
            System.out.println(manga);
        }
    }
}

public class MangaLibraryApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating instance of Library
        Library myLibrary = new Library();

        int choice;
        do {
            System.out.println("\nManga Library Menu:");
            System.out.println("1. Add Manga");
            System.out.println("2. Remove Manga");
            System.out.println("3. Display Library");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Adding manga to the library
                    System.out.print("Enter manga title: ");
                    String title = scanner.next();
                    System.out.print("Enter author: ");
                    String author = scanner.next();
                    System.out.print("Enter number of volumes: ");
                    int volumes = scanner.nextInt();

                    Manga newManga = new Manga(title, author, volumes);
                    myLibrary.addManga(newManga);
                    System.out.println("Manga added to the library.");
                    break;

                case 2:
                    // Removing manga from the library
                    System.out.print("Enter the title of the manga to remove: ");
                    String removeTitle = scanner.next();

                    // Find the manga in the library
                    Manga mangaToRemove = null;
                    for (Manga manga : myLibrary.getMangaCollection()) {
                        if (manga.getTitle().equalsIgnoreCase(removeTitle)) {
                            mangaToRemove = manga;
                            break;
                        }
                    }

                    if (mangaToRemove != null) {
                        myLibrary.removeManga(mangaToRemove);
                        System.out.println("Manga removed from the library.");
                    } else {
                        System.out.println("Manga not found in the library.");
                    }
                    break;

                case 3:
                    // Displaying the librar
                    myLibrary.displayLibrary();
                    break;

                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
