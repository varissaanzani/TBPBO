// Class untuk merepresentasikan entitas User
public class User {
    // Properti untuk menyimpan username dan password user
    private String username; // Nama pengguna (user login)
    private String password; // Kata sandi pengguna

    // Constructor
    public User(String username, String password) {
        // Inisialisasi properti dengan nilai parameter
        this.username = username;
        this.password = password;
    }

    // Getter untuk username
    public String getUsername() {
        return username; // Mengembalikan nilai username
    }

    // Setter untuk username
    public void setUsername(String username) {
        this.username = username; // Mengatur ulang nilai username
    }

    // Getter untuk password
    public String getPassword() {
        return password; // Mengembalikan nilai password
    }

    // Setter untuk password
    public void setPassword(String password) {
        this.password = password; // Mengatur ulang nilai password
    }
}
