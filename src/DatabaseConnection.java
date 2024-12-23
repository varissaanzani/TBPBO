import java.sql.*;

public class DatabaseConnection {
    // URL untuk koneksi ke database (sesuaikan nama database dengan 'alumni_db')
    private static final String URL = "jdbc:mysql://localhost:3306/alumni_db"; // Nama database
    private static final String USER = "root"; // Username MySQL (default biasanya 'root')
    private static final String PASSWORD = ""; // Password MySQL (default kosong)

    /**
     * Method untuk mendapatkan koneksi ke database.
     * 
     * @return Connection objek koneksi ke database.
     * @throws SQLException Jika terjadi kesalahan saat koneksi.
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * Method untuk memverifikasi login user berdasarkan username dan password.
     * 
     * @param username Username user yang diinput.
     * @param password Password user yang diinput.
     * @return true jika username dan password cocok, false jika tidak.
     * @throws SQLException Jika terjadi kesalahan saat berkomunikasi dengan database.
     */
    public static boolean login(String username, String password) throws SQLException {
        // Query untuk memeriksa kecocokan username dan password di tabel 'users'
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            // Mengisi parameter query dengan username dan password yang diinputkan
            stmt.setString(1, username);
            stmt.setString(2, password);

            // Mengeksekusi query dan mendapatkan hasil
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // Jika ada data yang cocok, login berhasil (return true)
            }
        }
    }
}
