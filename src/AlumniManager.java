import java.sql.SQLException;

// Interface untuk mengelola operasi terkait data alumni
public interface AlumniManager {

    /**
     * Metode untuk menambahkan data alumni ke database.
     *
     * @param alumni objek Alumni yang akan ditambahkan
     * @throws SQLException jika terjadi kesalahan saat berkomunikasi dengan database
     */
    void addAlumni(Alumni alumni) throws SQLException;

    /**
     * Metode untuk melihat daftar data alumni dari database.
     *
     * @throws SQLException jika terjadi kesalahan saat berkomunikasi dengan database
     */
    void viewAlumni() throws SQLException;

    /**
     * Metode untuk memperbarui data alumni tertentu di database.
     *
     * @param id ID unik dari alumni yang datanya akan diperbarui
     * @param alumni objek Alumni dengan data yang telah diperbarui
     * @throws SQLException jika terjadi kesalahan saat berkomunikasi dengan database
     */
    void updateAlumni(int id, Alumni alumni) throws SQLException;

    /**
     * Metode untuk menghapus data alumni tertentu dari database.
     *
     * @param id ID unik dari alumni yang datanya akan dihapus
     * @throws SQLException jika terjadi kesalahan saat berkomunikasi dengan database
     */
    void deleteAlumni(int id) throws SQLException;
}
