import java.sql.*;

// Implementasi dari interface AlumniManager
public class AlumniManagerImpl implements AlumniManager {

    /**
     * CREATE: Menambahkan data alumni ke dalam database.
     *
     * @param alumni Objek Alumni yang akan ditambahkan ke database.
     * @throws SQLException Jika terjadi kesalahan saat berkomunikasi dengan database.
     */
    @Override
    public void addAlumni(Alumni alumni) throws SQLException {
        // Query untuk menambahkan data ke tabel alumni
        String sql = "INSERT INTO alumni (name, graduation_year, major, birth_date) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            // Mengisi parameter query dengan data dari objek Alumni
            stmt.setString(1, alumni.getName());
            stmt.setInt(2, alumni.getGraduationYear());
            stmt.setString(3, alumni.getMajor());
            stmt.setDate(4, new java.sql.Date(alumni.getBirthDate().getTime())); // Konversi Date ke SQL Date
            stmt.executeUpdate(); // Eksekusi query
        }
    }

    /**
     * READ: Mengambil semua data alumni dari database.
     *
     * @throws SQLException Jika terjadi kesalahan saat berkomunikasi dengan database.
     */
    @Override
    public void viewAlumni() throws SQLException {
        // Query untuk mengambil semua data dari tabel alumni
        String sql = "SELECT * FROM alumni";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            // Iterasi melalui hasil query dan mencetak data alumni
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Graduation Year: " + rs.getInt("graduation_year"));
                System.out.println("Major: " + rs.getString("major"));
                System.out.println("Birth Date: " + rs.getDate("birth_date"));
                System.out.println("-----------------------------");
            }
        }
    }

    /**
     * UPDATE: Memperbarui data alumni berdasarkan ID.
     *
     * @param id     ID alumni yang akan diperbarui.
     * @param alumni Objek Alumni dengan data baru.
     * @throws SQLException Jika terjadi kesalahan saat berkomunikasi dengan database.
     */
    @Override
    public void updateAlumni(int id, Alumni alumni) throws SQLException {
        // Query untuk memperbarui data berdasarkan ID
        String sql = "UPDATE alumni SET name = ?, graduation_year = ?, major = ?, birth_date = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            // Mengisi parameter query dengan data baru
            stmt.setString(1, alumni.getName());
            stmt.setInt(2, alumni.getGraduationYear());
            stmt.setString(3, alumni.getMajor());
            stmt.setDate(4, new java.sql.Date(alumni.getBirthDate().getTime()));
            stmt.setInt(5, id);
            stmt.executeUpdate(); // Eksekusi query
        }
    }

    /**
     * DELETE: Menghapus data alumni berdasarkan ID.
     *
     * @param id ID alumni yang akan dihapus.
     * @throws SQLException Jika terjadi kesalahan saat berkomunikasi dengan database.
     */
    @Override
    public void deleteAlumni(int id) throws SQLException {
        // Query untuk menghapus data berdasarkan ID
        String sql = "DELETE FROM alumni WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id); // Mengisi parameter ID
            stmt.executeUpdate(); // Eksekusi query
        }
    }

    /**
     * Menghitung total jumlah alumni dalam database.
     *
     * @return Jumlah total alumni.
     * @throws SQLException Jika terjadi kesalahan saat berkomunikasi dengan database.
     */
    public int getTotalAlumni() throws SQLException {
        // Query untuk menghitung jumlah alumni
        String sql = "SELECT COUNT(*) AS total FROM alumni";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getInt("total"); // Mengembalikan jumlah alumni
            }
        }
        return 0;
    }

    /**
     * Menghitung rata-rata tahun kelulusan alumni.
     *
     * @return Rata-rata tahun kelulusan.
     * @throws SQLException Jika terjadi kesalahan saat berkomunikasi dengan database.
     */
    public double getAverageGraduationYear() throws SQLException {
        // Query untuk menghitung rata-rata tahun kelulusan
        String sql = "SELECT AVG(graduation_year) AS avg_year FROM alumni";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getDouble("avg_year"); // Mengembalikan rata-rata
            }
        }
        return 0.0;
    }
}
