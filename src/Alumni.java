import java.util.Date;

// Class untuk merepresentasikan data Alumni
public class Alumni {
    // Properti untuk menyimpan nama alumni
    private String name;

    // Properti untuk menyimpan tahun kelulusan alumni
    private int graduationYear;

    // Properti untuk menyimpan jurusan alumni
    private String major;

    // Properti untuk menyimpan tanggal lahir alumni
    private Date birthDate;

    // Constructor untuk menginisialisasi data alumni
    public Alumni(String name, int graduationYear, String major, Date birthDate) {
        this.name = name; // Inisialisasi nama alumni
        this.graduationYear = graduationYear; // Inisialisasi tahun kelulusan alumni
        this.major = major; // Inisialisasi jurusan alumni
        this.birthDate = birthDate; // Inisialisasi tanggal lahir alumni
    }

    // Getter untuk mengambil nilai nama alumni
    public String getName() {
        return name;
    }

    // Setter untuk mengubah nilai nama alumni
    public void setName(String name) {
        this.name = name;
    }

    // Getter untuk mengambil nilai tahun kelulusan alumni
    public int getGraduationYear() {
        return graduationYear;
    }

    // Setter untuk mengubah nilai tahun kelulusan alumni
    public void setGraduationYear(int graduationYear) {
        this.graduationYear = graduationYear;
    }

    // Getter untuk mengambil nilai jurusan alumni
    public String getMajor() {
        return major;
    }

    // Setter untuk mengubah nilai jurusan alumni
    public void setMajor(String major) {
        this.major = major;
    }

    // Getter untuk mengambil nilai tanggal lahir alumni
    public Date getBirthDate() {
        return birthDate;
    }

    // Setter untuk mengubah nilai tanggal lahir alumni
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
