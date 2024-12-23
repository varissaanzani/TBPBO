import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner untuk membaca input dari pengguna
        Scanner scanner = new Scanner(System.in);

        // Membuat objek manager untuk mengelola data alumni
        AlumniManager manager = new AlumniManagerImpl();

        // Header aplikasi
        System.out.println("===== Welcome to Alumni Management System =====");

        // Proses login
        boolean isLoggedIn = false; // Flag untuk memeriksa status login
        while (!isLoggedIn) {
            // Meminta username dan password dari pengguna
            System.out.print("Enter Username: ");
            String username = scanner.nextLine();
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            try {
                // Memeriksa kredensial login melalui DatabaseConnection
                if (DatabaseConnection.login(username, password)) {
                    isLoggedIn = true; // Login berhasil
                    System.out.println("Login successful! Welcome, " + username + ".");
                } else {
                    System.out.println("Invalid username or password. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error during login: " + e.getMessage());
            }
        }

        // Menu utama setelah login
        while (true) {
            // Menampilkan opsi menu kepada pengguna
            System.out.println("===== Alumni Management =====");
            System.out.println("1. Add Alumni"); // Menambahkan data alumni
            System.out.println("2. View Alumni"); // Menampilkan data alumni
            System.out.println("3. Update Alumni"); // Memperbarui data alumni
            System.out.println("4. Delete Alumni"); // Menghapus data alumni
            System.out.println("5. View Total Alumni"); // Menampilkan jumlah alumni
            System.out.println("6. View Average Graduation Year"); // Menampilkan rata-rata tahun kelulusan
            System.out.println("7. Exit"); // Keluar dari program
            System.out.print("Choose an option: ");

            // Membaca pilihan pengguna
            int choice = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer input

            try {
                switch (choice) {
                    case 1:
                        // Menambahkan alumni baru
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Graduation Year: ");
                        int year = scanner.nextInt();
                        scanner.nextLine(); // Membersihkan buffer input
                        System.out.print("Enter Major: ");
                        String major = scanner.nextLine();
                        System.out.print("Enter Birth Date (yyyy-mm-dd): ");
                        String birthDate = scanner.nextLine();

                        // Menambahkan alumni menggunakan objek manager
                        manager.addAlumni(new Alumni(name, year, major, java.sql.Date.valueOf(birthDate)));
                        System.out.println("Alumni added successfully!");
                        break;

                    case 2:
                        // Menampilkan semua data alumni
                        manager.viewAlumni();
                        break;

                    case 3:
                        // Memperbarui data alumni
                        System.out.print("Enter ID to update: ");
                        int idToUpdate = scanner.nextInt();
                        scanner.nextLine(); // Membersihkan buffer input
                        System.out.print("Enter New Name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter New Graduation Year: ");
                        int newYear = scanner.nextInt();
                        scanner.nextLine(); // Membersihkan buffer input
                        System.out.print("Enter New Major: ");
                        String newMajor = scanner.nextLine();
                        System.out.print("Enter New Birth Date (yyyy-mm-dd): ");
                        String newBirthDate = scanner.nextLine();

                        // Memperbarui data menggunakan manager
                        manager.updateAlumni(idToUpdate, new Alumni(newName, newYear, newMajor, java.sql.Date.valueOf(newBirthDate)));
                        System.out.println("Alumni updated successfully!");
                        break;

                    case 4:
                        // Menghapus alumni berdasarkan ID
                        System.out.print("Enter ID to delete: ");
                        int idToDelete = scanner.nextInt();
                        manager.deleteAlumni(idToDelete);
                        System.out.println("Alumni deleted successfully!");
                        break;

                    case 5:
                        // Menampilkan total jumlah alumni
                        int totalAlumni = ((AlumniManagerImpl) manager).getTotalAlumni();
                        System.out.println("Total Alumni: " + totalAlumni);
                        break;

                    case 6:
                        // Menampilkan rata-rata tahun kelulusan
                        double averageYear = ((AlumniManagerImpl) manager).getAverageGraduationYear();
                        System.out.printf("Average Graduation Year: %.2f\n", averageYear);
                        break;

                    case 7:
                        // Keluar dari program
                        System.out.println("Exiting... Goodbye!");
                        return;

                    default:
                        // Pilihan yang tidak valid
                        System.out.println("Invalid option! Please try again.");
                }
            } catch (Exception e) {
                // Penanganan error
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
