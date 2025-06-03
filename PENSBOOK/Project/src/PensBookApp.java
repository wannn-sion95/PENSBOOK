
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.util.*;
import java.util.List;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class PensBookApp {
    private JFrame mainFrame;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private Map<String, String> users = new HashMap<>();
    private String currentUser = "";
    private List<Book> books = new ArrayList<>();

    // Modern color scheme
    private final Color PRIMARY_COLOR = new Color(44, 95, 182);
    private final Color SECONDARY_COLOR = new Color(222, 228, 237);
    private final Color BACKGROUND_COLOR = new Color(244, 246, 250);
    private final Color SURFACE_COLOR = new Color(251, 251, 251, 255);
    private final Color TEXT_COLOR = new Color(66, 66, 66);
    private final Color ACCENT_COLOR = new Color(44, 95, 182);
    private final Color ERROR_COLOR = new Color(181, 29, 29);
    private final Color SUCCESS_COLOR = new Color(46, 125, 50);

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> new PensBookApp().createAndShowGUI());
    }

    private void createAndShowGUI() {
        initializeData();

        mainFrame = new JFrame("PENS BOOK");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(900, 700);
        mainFrame.setMinimumSize(new Dimension(800, 600));
        mainFrame.setLocationRelativeTo(null);
        mainFrame.getContentPane().setBackground(BACKGROUND_COLOR);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBackground(BACKGROUND_COLOR);

        // Create panels
        mainPanel.add(createLoginPanel(), "LOGIN");
        mainPanel.add(createRegisterPanel(), "REGISTER");

        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }

    private void initializeData() {
        // Sample books
        books.add(new Book("Seporsi Mie Ayam Sebelum Mati", "Brian Khrisna", "Fiksi", "Seporsi.jpg",
                "Cerita tentang Seporsi Mie Ayam Sebelum Mati adalah judul buku karya Brian Khrisna yang menceritakan kisah Ale, seorang pria yang berjuang melawan depresi dan ingin mengakhiri hidupnya. " +
                        "Namun, sebelum akhirnya, ia memutuskan untuk menikmati satu porsi mie ayam terakhir sebagai keputusan yang diambil atas kehendaknya sendiri.\n\nJangan lupa untuk memberikan apresiasi kepada dirimu sendiri. " +
                        "Hidupmu itu sudah sulit. Jangan paksa kakimu untuk terus melangkah.Cobalah sesekali beristirahat. Sekali-sekali, pergilah keluar. " +
                        "Hargailah pencapain di hidupmu meski itu hanya pencapain kecil. Sebab, kamu memang pantas untuk itu. " +
                        "Jika sedang lelah, kamu boleh marah dan meluapkannya. Jangan ditahan terus,\nIa menepuk pundakku,\"Bung\", kunci bertahan hidup itu bukann sellau berpikir positif, " +
                        "melainkan kemampuan untuk menerima keadaan. Menerima kalau hidup tuh gk selamanya bahagia. Suatu saat kita akan sedih, akan kehilangan, akan gagal, akan jatuh cinta, akanb patah hati, atau bahkan akan mengalami hari-hari yang sangat pahit sampai rasangan ingin mati saja." +
                        "Tapi ya... itu tidak apa-apa. Sebab, itulah hidup. Sebuah seni untuk terus memaksa diri agar bisa menerima segala apa yang sudah terjadi. Jangan biarin hidup memaksa Bung tumbuh menjadi seseorang yang Bung sendiri akan benci." +
                        "\nDi kota yang lebih kejam ketika menjelang pagi ini, semua orang akan berusaha bertahan hidup dengan cara apa pun. " +
                        "Tidak akan ada yang membantu lo. Semua orang dipaksa untuk membantu dirinya sendiri. " +
                        "Seperti yang sudah gue bilang, menggantungkan hidup ke orang lain itu sama seperti memberikan mereka pistol berpeluru dan percaya jika mereka gak akan pernah memakainya untuk menembak lo sendiri. " +
                        "Jangan salahkan orang lain jika lo mati, tapi salahkan diri lo sendiri karena percaya kalau mereka gak akan melukaimu." +
                        "\nHidup bakal jadi lebih gampang kalau kita sudah bisa belajar untuk menerima kekecewaan dan melihatnya sebagai berkah yang asing. " +
                        "Waktu saya ditolak di banyak tempat kerja, saya bilang sama diri saya sendiri mungkin kerjaan itu bukan untuk saya. " +
                        "Ketika saya terlambat untuk mengambil sebuah kesempatan, saya berpikir kalaumungkin ada kesempatan di tempat lain yang jauh lebih baik." +
                        "\nJangan lupa untuk memberikan apresiasi kepada dirimu sendiri. Hidupmu itu sudah sulit. Jangan paksa kakimu untuk terus melangkah, Mas. Cobalah sesekali beristirahat. " +
                        "Nikmati mie ayam itu dengan perasaan senang, bukan untuk dinikmati sebagai makan terakhir sebelum mati" ));

        books.add(new Book("Madilog", "Tan Malaka", "Filsafat","madilog.jpg",
                "BAB II\nFILSAFAT\n\n Apabila kita menonton satu pertandingan sepakbola, maka lebih dahulu kita mesti pisahkan si pemanain mana yang masuk klub ini dan mana yang masuk klub itu. " +
                        "Kalau tidak begitu, bingunglah kita. Kita tak bisa tahu siapa yang kalah, siapa yang menang. " +
                        "Mana yang lebih baik permainannya, mana yang tidak.\nBegitulah kalau kita masuki pustaka filsafat yang mempunyai ratusan dan bahkan ribuan buku itu. " +
                        "Kita lebih dahulu mesti pisahkan arah pikiran para ahli filsafat. Kalau tidak, nisacaya bingunglah kita karena tak bisa memisahkan siapa yang benar dan siapa yang salah. " +
                        "Seperti para pemain sepakbola tadi yang kacau balau di mata kita, tak tahu apa maksudnya masing-masing, begitulah di mata kita para ahli filsafat berkata semau-maunya saja. " +
                        "Kalau tak ada pangkal, maka tak ada ujung.\nTetapi dengan merujuk Engels sebagai penunjuk jalan, bisalah kita terhindar dari kekacauan dan membuang-buang waktu. " +
                        "Engels, yang kini dikenal sebagai co-creator dan sama konstruktifnya dengan Marx, sebetulnya banyak sekali meninggalkan pusaka dalam filsafat. " +
                        "Karla Marx terkenal sebagai bapak dialektika materialisme dan Surplus Value. " +
                        "Engels yang pendiam dan pemalu selalu berdiri di belakang Marx, tetapi dia setia dan jujur dalam meneruskan Das Kapital yang belum rampung sepeninggal Marxx. " +
                        "Engels sendiri menulis beberapa buku berkenaaan dengan filsafart \"Anti-Duhring\" dan Filsafat Ludwig Feuerbach tentang sejarah dan ekonomi." +
                        "\nIdealisme tak akan mati selama masih ada perjuangan kelas ini, selama ada kaum yang mengisap dan menindas. " +
                        "Kaum hartawan yang berkuasa pada satu pihak, mengemukakan ide, intelek, pikiran, terhadap kau terisap dan tertindas; namun pada lain pihak, dia memakai kemegahan atau majizat rohani buat meninabobokan kaum pekerja, supaya nanti mendapat nikamat, bidadari, yang matanya seperti mata burung merpati dan kesenangan kekal akhirat. Itulah yang disebut dengan \"idealisme\".\nFilsafat Marxis adalah filsafat yang berlandaskan pada materialisme dialektis dan materialisme historis. Filsafat ini menganggap bahwa materi adalah dasar dari segala sesuatu, dan bahwa perubahan sosial terjadi melalui konflik antara kelas-kelas sosial yang berbeda. Filsafat Marxis juga menekankan pentingnya sejarah dalam memahami perkembangan masyarakat dan perubahan sosial."));

        books.add(new Book("Ayat-Ayat Api", "Sapardi Djoko Damono", "Fiksi","Ayatapi.jpg",
                "Tentang Mahasiswa Yang Mati\n Pada perang Jepang-Tiongkok, tepatnya di Shanghai penghabisan tahun 1931, tiga hari lamanya saya terkepung di belakang jalan bernama North Sichuan Road, " +
                        "tempat peperangan pertama kali meletus. Dari North Sichuan Road tadi, Jepang menembak ke arah Po Shan Road dan tentara Tiongkok dari arah sebaliknya. " +
                        "Di antaranya, persisnya di kampung Wang Pan Cho, saya dengan pustaka saya terpaku. Sesudah dua atau tiga hari berselang, " +
                        "tentara Jepang baru memberi izin kepada kampung tempat saya tinggal untuk berpindah rumah, pergi ke tempat yang lebih aman dalam tempo lima menit saja. " +
                        "Saya turut pindah tergopoh-gopoh. Tentulah sehabis perang, yakni sesudah sebulan lamanya, maka sehelai kertas pun tiada tersisa. " +
                        "Begitulah rapinya “Laliong” alias tukang copet bekerja. Tapi hal ini tidak membuat saya putus asa. Selama toko buku masih ada, " +
                        "selama itu pula pustaka bisa dibentuk kembali. Kalau perlu dan memang perlu, pakaian dan makanan pun rela dikurangi!"));

        books.add(new Book("Ranah 3 Warna", "Ahmad Fuadi", "Novel","ranah3warna.jpg",
                "Mimpi Anak Pesantren\n\nSeorang anak bernama Alif yang berasal dari Maninjau berhasil menyelesaikanpendidikannya di Pondok Madani. " +
                        "Dia belajar di Pondok Madani atas paksaan orang tuanyatetapi Alif bisa melaluinya dengan hasil yang memuaskan. " +
                        "Alif merupakan tokoh kuat dalamnovel pertama, Negeri 5 Menara dan novel kedua, Ranah 3 Warna . " +
                        "Cita-cita Alif belajar hingganegara Amerika terpupuk dengan baik hingga kelulusannya dari Pondok Madani. " +
                        "Berbekalkan pengalaman dan pendidikan yang didapatnya di Pondok Madani, Alif berjuangkeras menggapai cita-citanya. " +
                        "Perjuangan Alif tidak semulus dan semudah yang dibayangkan. " +
                        "Alif harus berjuang keras mendapatkan ijazah persamaan karena latar belakang pendidikannya bukan berasal dari sekolah umum. " +
                        "Selain itu, Alif juga harus berjuang mati-matian selama 3 bulan untuk mendalami pelajaran selama 3 tahun di sekolah umum. " +
                        "Seorang anak bernama Alif yang berasal dari Maninjau berhasil menyelesaikanpendidikannya di Pondok Madani. " +
                        "Dia belajar di Pondok Madani atas paksaan orang tuanyatetapi Alif bisa melaluinya dengan hasil yang memuaskan. " +
                        "Alif merupakan tokoh kuat dalamnovel pertama, Negeri 5 Menara dan novel kedua, Ranah 3 Warna . " +
                        "Cita-cita Alif belajar hingganegara Amerika terpupuk dengan baik hingga kelulusannya dari Pondok Madani. " +
                        "Berbekalkan pengalaman dan pendidikan yang didapatnya di Pondok Madani, Alif berjuangkeras menggapai cita-citanya. " +
                        "Perjuangan Alif tidak semulus dan semudah yang dibayangkan.Alif harus berjuang keras mendapatkan ijazah persamaan karena latar belakang pendidikannya bukan berasal dari sekolah umum. " +
                        "Selain itu, Alif juga harus berjuang mati-matian selama 3 bulan untuk mendalami pelajaran selama 3 tahun di sekolah umum."));

        books.add(new Book("Bumi Manusia", "Pramoedya Ananta Toer", "Sejarah","bumimanusia.jpg",
                "AYAH DAN BUNDA SANGAT BANGGA AKU MENDAPAT Undangan dari Tuan Assisten Residen Herbert de la" +
                        "Croix.\n" +
                        "Di rumah masih berdatangan undangan dari para pembesar" +
                        "Pribumi setempat.\n" +
                        "Kedua orangtuaku lebih baik tak tahu bagaimana putra kebanggaan ini diplonco.\n" +
                        "Setengah mati kutolak desakan mereka untuk menceritakan.\n" +
                        "Malah aku nyatakan akan segera balik ke Surabaya.\n" +
                        "Undangan-undangan membikin aku sibuk membalas.\n" +
                        "Ayahanda tak lagi gusar padaku. Undangan dari Tuan Assisten\n" +
                        "Residen membikin semua dosaku dengan sendirinya terampuni.\n" +
                        "Telah kukirimkan telegram lagi ke Wonokromo, mengabarkan hari dan jam kembaliku ke Surabaya mendatang, dan agar\n" +
                        "dijemput dengan kereta.\n" +
                        "Ayahanda dan Bunda tak dapat dan mungkin juga merasa tak\n" +
                        "layak menahan keberangkatanku. Persoalan Nyai Ontosoroh tak\n" +
                        "pernah digugat lagi. Seorang yang telah mendapat undangan dari\n" +
                        "Tuan Assisten Residen dengan sendirinya memiliki kekebalan,\n" +
                        "tak mungkin bersalah, bahkan jabatan tinggi dan penting yang\n" +
                        "sudah terpampang di ambang pintu kehidupannya. Mereka hanya berpesan agar aku minta diri dari pembesar Eropa itu."));

        books.add(new Book("Bagaimana Si Miskin Mati","George Orwell", "Politik", "Miskin.jpg",
                "BAGAIMANA SI MISKIN MATI\n\nPada tahun 1929, saya dirawat selama beberapa minggu di Hospital X, di arrondissement kelima belas Paris. " +
                        "Di lobi rumah sakit, para petugas, seperti saya duga sebelumnya, berlama-lama menginterogasi saya, dan pada akhirnya saya harus duduk dan menjawab rentetan pertanyaan mereka selama dua puluh menit sebelum mereka memperbolehkan saya masuk. Bila anda pernah diminta untuk mengisi formulir di negara-negara Latin, " +
                        "Anda pasti tahu pertanyaan-pertanyaan macam apa yang saya maksud. Sejak beberapa hari sebelumnya, saya terlalu sakit untuk dengan tepat mengonversikan temperatur badan saya dari Reamur ke Fahrenheit, " +
                        "tapi saya tahu bahwa temperatur badan saya sekitar 103 derajat Fahrenheit, dan ketika interogasi itu selesai, saya merasa kesulitan berdiri. Di belakang saya, beberapa pasien yang membawa bungkusan berlapis lapis kain-kain berwarna menunggu giliran mereka untuk diinterogasi."
        ));

        books.add(new Book("Perahu Kertas", "Dewi Lestari", "Romance", "Perahu.jpg",
                         "KEPERGIAN DAN KEHILANGAN\n\nBandung, Agustus 2000...\nTerdengar langkah kaki berlari di koridor, semakin lama semakin dekat, dan ternyata langkah itu berhenti di depan\n" +
                                 "pintu kamarnya. Menyusul ketukan bertubi di pintu.\n“Masuk ...,” kata Kugy, matanya tak lepas dari layar komputer.\n“Gy!” Noni menerobos masuk, mukanya panik. “Lu putus\n" +
                                 "sama Ojos?” tembaknya tanpa basa-basi.\nKugy menatap Noni tanpa bersuara, lalu mengangguk\n" +
                                 "kecil.\n“Ya, ampun. Kenapa? Kok bisa? Gua baru teleponan\n" +
                                 "sama Ojos. Dia sedih banget. Kok lu nggak langsung bilang\n" +
                                 "sama gua? Sebetulnya kalian ada apa, sih? Lu kenapa?” Pertanyaan Noni berentet seperti peluru senapan otomatis.\nKugy benar-benar tak tahu harus menjawab apa. Ia hanya\n" +
                                 "mengangkat bahu. “Memang udah saatnya kali, Non,” sahutnya pendek.\n“Kok jawaban lu gitu sih, Gy? Kok lu nggak terbuka sama gua? Gua kan sayang banget sama kalian berdua. Gua ikut\n" +
                                 "sedih, tauk,” kata Noni kecewa. “Kalian kan pasangan legendaris, bikin orang-orang ngiri, kalian tuh cocok banget ...”\nKugy tersenyum getir. “Please, deh, Non. Gua sama Ojos\n" +
                                 "itu bedanya kayak langit dan sumur. Semua ini kayak bom\n" +
                                 "waktu yang tinggal tunggu meledak.”\nTampang Noni langsung berubah serius. “Gy, lu sahabat\n" +
                                 "gua. Gua pasti belain elu. Tapi terus terang, kali ini gua ngelihat lu memang jadi berubah. Lu kayak sengaja menarik\n" +
                                 "diri. Ojos juga ngerasa gitu, dan dia udah lama ngomong ke\n" +
                                 "gua. Dia ngerasa ada sesuatu yang aneh. Gua dan Eko juga\n" +
                                 "ngerasa kehilangan lu,” Noni terdiam sejenak, “gua nggak\n" +
                                 "enak ngomong gini. Tapi sebagai sahabat, gua harus jujur\n" +
                                 "sama lu. Kita semua kehilangan Kugy yang dulu.”\nLama Kugy membisu. Dalam benaknya ia berusaha keras\n" +
                                 "untuk merangkai penjelasan demi penjelasan, tapi yang ia\n" +
                                 "temukan hanya sebongkah benang kusut. Ia tak tahu lagi\n" +
                                 "harus memulai dari mana. Semua sudah bercampur aduk.\n" +
                                 "“Thanks for your concern, Non,” kata Kugy akhirnya, “tapi\n" +
                                 "gua baik-baik aja, kok. Gua nggak tahu Kugy yang dulu itu\n" +
                                 "yang mana. Tapi inilah gua. Kalau memang ternyata berubah, ya terimalah gua apa adanya. Sama seperti gua menerima lu, Eko, Ojos, Keenan ... apa adanya. Menurut gua,\n" +
                                 "itu yang bisa kita lakukan sebagai sahabat.”\nJelas terlihat ekspresi protes di muka Noni, tapi kata-kata\n" +
                                 "Kugy seperti membungkam mulutnya. Noni pun bangkit berdiri. “Whatever, Gy. Terserah,” ujarnya dingin.\nPintu kamar itu kembali menutup. Kugy termenung di\n" +
                                 "kursi komputernya. Sekilas ia melihat bayangannya di cermin. Ia mengerti kehilangan yang dimaksud Noni. Sama seperti sahabatnya, ia pun merasakan kehilangan itu. Namun,\n" +
                                 "Kugy tak tahu harus ke mana mencari. Semua terlalu kusut\n" +
                                 "baginya."));

        books.add(new Book("Pulang", "Tere Liye", "Fiksi", "Pulang.jpg",
                                "Janji Kepada Mamak\n\nEsoknya, Bapak dan Mamak kembali bertengkar di belakang rumah." +
                                        "\n\"Apa yang kau harapkan dari anak laki-lakimu, Midah? Akan kau kirim dia belajar mengaji dengan Tuanku Imam? " +
                                        "Akan kau kirim dia kembali ke kampung halaman tempat kau lahir? Kerabatmu hanya akan tertawa melihatnya, bagus jika mereka tidak meludahinya.\" Bapak berseru." +
                                        "\nMamak menangis dalam diam, menyeka ujung matanya.\n\"Lihatlah aku, Midah. Lihat. Sejak kecil aku berusaha melupakan asal keturunanku, belajar mengaji, bermalam di surau. " +
                                        "Aku sudah berusaha melepaskan semua catatan gelap milik keluargaku, tapi saat aku melamarmu, memintamu baik-baik, mereka hanya tertawa. Sakit sekali." +
                                        "\nMereka tidak akan pernah bisa menerima kenyataan jika aku berbeda dengan Bapakku, si tukang jagal. Aku terusir dari kampung. Pergi ke kota mencari penghidupan." +
                                        "\nMereka melempar kotoran saat aku pergi. Tidak mengapa semua kebencian itu, aku bisa mengunyahnya. " +
                                        "Tidak mengapa meski akhirnya aku juga menjadi tukang jagal di kota, seperti orang tuaku yang dulu amat kubenci. Tidak mengapa." +
                                        "\nKarena yang paling menyakitkan adalah aku harus pergi melupakanmu, Midah. Seluruh cinta kita hancur.\""));

        books.add(new Book("Dasar Pemrograman Python", "Noval Agung", "Teknologi", "Python.png",
                                "Dasar Pemrograman Python adalah buku yang ditujukan untuk pemula yang ingin belajar bahasa pemrograman Python. " +
                                        "Buku ini mencakup konsep dasar pemrograman, struktur data, kontrol alur, fungsi, dan modul. " +
                                        "Dengan pendekatan yang mudah dipahami, buku ini membantu pembaca memahami dasar-dasar Python dan mulai menulis kode sederhana. \nPython Variabel\n" +
                                        " Dalam konsep programming, variabel adalah suatu nama yang dikenali\n" +
                                        " komputer sebagai penampung nilai/data yang disimpan di memory. Sebagai\n" +
                                        " contoh nilai\n" +
                                        " 3.14 disimpan di variabel bernama\n" +
                                        " PI .\nDeklarasi Variabel\n Agar dikenali oleh komputer, variabel harus dideklarasikan. Deklarasi variabel\n" +
                                        " di Python cukup sederhana, caranya tinggal tulis saja nama variabel kemudian\n" +
                                        " diikuti operator assignment beserta nilai awal yang ingin dimasukan ke\n" +
                                        " variabel tersebut. Contoh:\n nama = \"noval\"\n" +
                                        " hobi = 'makan'\n" +
                                        " umur = 18\n" +
                                        " laki = True\n Karakter\n" +
                                        " = adalah operator assignment, digunakan untuk operasi\n" +
                                        " penugasan. Nilai yang ada di sebelah kanan\n" +
                                        " = ditugaskan untuk ditampung\n" +
                                        " oleh variabel yang berada di sebelah kiri\n" +
                                        " = . Contoh pada statement\n" +
                                        " nama =\n" +
                                        " \"noval\" , nilai\n" +
                                        " \"nama\" ditugaskan untuk ditampung oleh variabel nama.\n Nilai string bisa dituliskan dengan menggunakan literal\n" +
                                        " nama .\n" +
                                        " \" ataupun \'\n"

        ));



    }

    private JPanel createLoginPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(BACKGROUND_COLOR);
        panel.setLayout(new GridBagLayout());

        // Create modern card
        JPanel card = createModernCard(450, 550);
        card.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Title
        JLabel titleLabel = new JLabel("PENS BOOK");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 36));
        titleLabel.setForeground(TEXT_COLOR);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2; gbc.insets = new Insets(20, 0, 30, 0);
        card.add(titleLabel, gbc);

        // Subtitle
        JLabel subtitleLabel = new JLabel("Masuk ke akun Anda untuk melanjutkan");
        subtitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        subtitleLabel.setForeground(new Color(156, 163, 175));
        subtitleLabel.setHorizontalAlignment(JLabel.CENTER);
        gbc.gridy = 1; gbc.insets = new Insets(0, 0, 40, 0);
        card.add(subtitleLabel, gbc);

        // Username field
        JTextField usernameField = createModernTextField("Username");
        gbc.gridy = 2; gbc.insets = new Insets(0, 30, 20, 30); gbc.fill = GridBagConstraints.HORIZONTAL;
        card.add(usernameField, gbc);

        // Password field
        JPasswordField passwordField = createModernPasswordField("Password");
        gbc.gridy = 3; gbc.insets = new Insets(0, 30, 30, 30);
        card.add(passwordField, gbc);

        // Login button
        JButton loginButton = createModernButton("Masuk", PRIMARY_COLOR);
        gbc.gridy = 4; gbc.insets = new Insets(0, 30, 20, 30);
        card.add(loginButton, gbc);

        // Register link
        JButton registerLink = createLinkButton("Belum punya akun? Daftar di sini");
        gbc.gridy = 5; gbc.insets = new Insets(0, 30, 20, 30);
        card.add(registerLink, gbc);

        // Event handlers
        ActionListener loginAction = e -> {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                showModernMessage("Mohon isi semua data", ERROR_COLOR);
                return;
            }

            if (users.containsKey(username) && users.get(username).equals(password)) {
                currentUser = username;
                showDashboard();
            } else {
                showModernMessage("Username atau password salah", ERROR_COLOR);
            }
        };

        loginButton.addActionListener(loginAction);
        passwordField.addActionListener(loginAction);

        registerLink.addActionListener(e -> cardLayout.show(mainPanel, "REGISTER"));

        panel.add(card);
        return panel;
    }

    private JPanel createRegisterPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(BACKGROUND_COLOR);
        panel.setLayout(new GridBagLayout());

        JPanel card = createModernCard(450, 650);
        card.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Title
        JLabel titleLabel = new JLabel("Buat Akun Baru");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        titleLabel.setForeground(TEXT_COLOR);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 5; gbc.insets = new Insets(20, 0, 20, 0);
        card.add(titleLabel, gbc);

        // Subtitle
        JLabel subtitleLabel = new JLabel("Buka, Baca, Kapanpun dan Dimanapun.");
        subtitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        subtitleLabel.setForeground(new Color(156, 163, 175));
        subtitleLabel.setHorizontalAlignment(JLabel.CENTER);
        gbc.gridy = 1; gbc.insets = new Insets(0, 0, 30, 0);
        card.add(subtitleLabel, gbc);

        // Form fields
        JTextField usernameField = createModernTextField("Username");
        gbc.gridy = 2; gbc.insets = new Insets(0, 30, 15, 30); gbc.fill = GridBagConstraints.HORIZONTAL;
        card.add(usernameField, gbc);

        JPasswordField passwordField = createModernPasswordField("Password");
        gbc.gridy = 3; gbc.insets = new Insets(0, 30, 15, 30);
        card.add(passwordField, gbc);

        JPasswordField confirmPasswordField = createModernPasswordField("Confirm Password");
        gbc.gridy = 4; gbc.insets = new Insets(0, 30, 25, 30);
        card.add(confirmPasswordField, gbc);

        // Register button
        JButton registerButton = createModernButton("Daftar akun", ACCENT_COLOR);
        gbc.gridy = 5; gbc.insets = new Insets(0, 30, 15, 30);
        card.add(registerButton, gbc);

        // Login link
        JButton loginLink = createLinkButton("Udah punya akun? Masuk di sini");
        gbc.gridy = 6; gbc.insets = new Insets(0, 30, 20, 30);
        card.add(loginLink, gbc);

        // Event handlers
        registerButton.addActionListener(e -> {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                showModernMessage("Mohon isi semua data", ERROR_COLOR);
                return;
            }

            if (!password.equals(confirmPassword)) {
                showModernMessage("Passwords do not match", ERROR_COLOR);
                return;
            }

            if (users.containsKey(username)) {
                showModernMessage("Username sudah ada yang punya, pake yang lain", ERROR_COLOR);
                return;
            }

            users.put(username, password);
            showModernMessage("Akun berhasil dibuat!", SUCCESS_COLOR);
            cardLayout.show(mainPanel, "LOGIN");
        });

        loginLink.addActionListener(e -> cardLayout.show(mainPanel, "LOGIN"));

        panel.add(card);
        return panel;
    }

    private void showDashboard() {
        JPanel dashboard = createDashboardPanel();
        mainPanel.add(dashboard, "Halaman Utama");
        cardLayout.show(mainPanel, "Halaman Utama");
    }

    private JPanel createDashboardPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(BACKGROUND_COLOR);

        // Header
        JPanel header = createHeader();
        panel.add(header, BorderLayout.NORTH);

        // Main content
        JPanel content = new JPanel(new BorderLayout());
        content.setBackground(BACKGROUND_COLOR);
        content.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Welcome section
        JPanel welcomePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        welcomePanel.setBackground(BACKGROUND_COLOR);

        JLabel welcomeLabel = new JLabel("Selamat datang, " + currentUser + "!");
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        welcomeLabel.setForeground(TEXT_COLOR);
        welcomePanel.add(welcomeLabel);

        content.add(welcomePanel, BorderLayout.NORTH);

        // Books grid
        JPanel booksGrid = createBooksGrid();
        JScrollPane scrollPane = new JScrollPane(booksGrid);
        scrollPane.setBorder(null);
        scrollPane.setBackground(BACKGROUND_COLOR);
        scrollPane.getViewport().setBackground(BACKGROUND_COLOR);
        styleScrollBar(scrollPane);

        content.add(scrollPane, BorderLayout.CENTER);
        panel.add(content, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createHeader() {
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(SURFACE_COLOR);
        header.setBorder(new EmptyBorder(15, 20, 15, 20));

        // Logo and title
        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftPanel.setBackground(SURFACE_COLOR);

        JLabel titleLabel = new JLabel("PENS BOOK");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titleLabel.setForeground(TEXT_COLOR);

        leftPanel.add(titleLabel);

        // User panel
        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightPanel.setBackground(SURFACE_COLOR);

        JLabel userLabel = new JLabel(currentUser);
        userLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        userLabel.setForeground(TEXT_COLOR);

        JButton logoutButton = createModernButton("Logout", ERROR_COLOR);
        logoutButton.setPreferredSize(new Dimension(80, 35));
        logoutButton.addActionListener(e -> {
            currentUser = "";
            cardLayout.show(mainPanel, "LOGIN");
        });

        rightPanel.add(userLabel);
        rightPanel.add(Box.createHorizontalStrut(20));
        rightPanel.add(logoutButton);

        header.add(leftPanel, BorderLayout.WEST);
        header.add(rightPanel, BorderLayout.EAST);

        return header;
    }

    private JPanel createBooksGrid() {
        JPanel grid = new JPanel(new GridLayout(0, 3, 20, 20));
        grid.setBackground(BACKGROUND_COLOR);
        grid.setBorder(new EmptyBorder(20, 0, 20, 0));

        for (Book book : books) {
            JPanel bookCard = createBookCard(book);
            grid.add(bookCard);
        }

        return grid;
    }

    private JPanel createBookCard(Book book) {
        JPanel card = createModernCard(350, 300);
        card.setLayout(new BorderLayout());
        card.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Book info
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBackground(SURFACE_COLOR);
        infoPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        // Book icon


        // Gambar buku sebagai JLabel
        ImageIcon icon = null;
        try {
            // Gambar dari resources folder
            icon = new ImageIcon(getClass().getResource(book.Imagecovepath));
            Image img = icon.getImage().getScaledInstance(110, 130, Image.SCALE_SMOOTH);
            icon = new ImageIcon(img);
        } catch (Exception e) {
            System.out.println("Gagal load gambar: " + book.Imagecovepath);
        }

// Gambar buku sebagai JLabel
        JLabel iconLabel = new JLabel(icon);
        iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);


        JLabel titleLabel = new JLabel(book.title);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titleLabel.setForeground(TEXT_COLOR);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel authorLabel = new JLabel("Penulis: " + book.author);
        authorLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        authorLabel.setForeground(new Color(156, 163, 175));
        authorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel genreLabel = new JLabel(book.genre);
        genreLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        genreLabel.setForeground(PRIMARY_COLOR);
        genreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        genreLabel.setBorder(new EmptyBorder(10, 0, 0, 0));

        infoPanel.add(iconLabel);
        infoPanel.add(Box.createVerticalStrut(15));
        infoPanel.add(titleLabel);
        infoPanel.add(Box.createVerticalStrut(5));
        infoPanel.add(authorLabel);
        infoPanel.add(Box.createVerticalStrut(10));
        infoPanel.add(genreLabel);

        // Read button
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(SURFACE_COLOR);

        JButton readButton = createModernButton("Baca buku", PRIMARY_COLOR);
        readButton.setPreferredSize(new Dimension(120, 35));
        readButton.addActionListener(e -> openBookReader(book));

        buttonPanel.add(readButton);

        card.add(infoPanel, BorderLayout.CENTER);
        card.add(buttonPanel, BorderLayout.SOUTH);

        // Hover effect
        card.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                card.setBorder(BorderFactory.createLineBorder(PRIMARY_COLOR, 2));
                card.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                card.setBorder(null);
                card.repaint();
            }
        });

        return card;
    }

    private void openBookReader(Book book) {
        JFrame readerFrame = new JFrame("Membaca: " + book.title);
        readerFrame.setSize(1000, 700);
        readerFrame.setLocationRelativeTo(mainFrame);
        readerFrame.getContentPane().setBackground(BACKGROUND_COLOR);

        JPanel readerPanel = new JPanel(new BorderLayout());
        readerPanel.setBackground(BACKGROUND_COLOR);

        // Reader header
        JPanel readerHeader = new JPanel(new BorderLayout());
        readerHeader.setBackground(SURFACE_COLOR);
        readerHeader.setBorder(new EmptyBorder(15, 20, 15, 20));

        JLabel bookTitleLabel = new JLabel(book.title + " - " + book.author);
        bookTitleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        bookTitleLabel.setForeground(TEXT_COLOR);

        JButton closeButton = createModernButton("Tutup", ERROR_COLOR);
        closeButton.addActionListener(e -> readerFrame.dispose());

        readerHeader.add(bookTitleLabel, BorderLayout.WEST);
        readerHeader.add(closeButton, BorderLayout.EAST);

        // Content area
        JTextArea contentArea = new JTextArea(book.content);
        contentArea.setFont(new Font("Georgia", Font.PLAIN, 16));
        contentArea.setForeground(TEXT_COLOR);
        contentArea.setBackground(BACKGROUND_COLOR);
        contentArea.setLineWrap(true);
        contentArea.setWrapStyleWord(true);
        contentArea.setEditable(false);
        contentArea.setBorder(new EmptyBorder(30, 40, 30, 40));

        JScrollPane contentScroll = new JScrollPane(contentArea);
        contentScroll.setBorder(null);
        contentScroll.setBackground(BACKGROUND_COLOR);
        contentScroll.getViewport().setBackground(BACKGROUND_COLOR);
        styleScrollBar(contentScroll);

        readerPanel.add(readerHeader, BorderLayout.NORTH);
        readerPanel.add(contentScroll, BorderLayout.CENTER);

        readerFrame.add(readerPanel);
        readerFrame.setVisible(true);
    }

    // UI Helper Methods
    private JPanel createModernCard(int width, int height) {
        JPanel card = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 15, 15));
                g2.dispose();
            }
        };
        card.setPreferredSize(new Dimension(width, height));
        card.setBackground(SURFACE_COLOR);
        card.setOpaque(false);
        return card;
    }

    private JTextField createModernTextField(String placeholder) {
        JTextField field = new JTextField() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 10, 10));
                super.paintComponent(g);
                g2.dispose();
            }
        };

        field.setPreferredSize(new Dimension(300, 45));
        field.setBackground(SECONDARY_COLOR);
        field.setForeground(TEXT_COLOR);
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setBorder(new EmptyBorder(10, 15, 10, 15));
        field.setOpaque(false);

        // Placeholder effect
        field.setText(placeholder);
        field.setForeground(new Color(156, 163, 175));

        field.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (field.getText().equals(placeholder)) {
                    field.setText("");
                    field.setForeground(TEXT_COLOR);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setText(placeholder);
                    field.setForeground(new Color(156, 163, 175));
                }
            }
        });

        return field;
    }

    private JPasswordField createModernPasswordField(String placeholder) {
        JPasswordField field = new JPasswordField() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 10, 10));
                super.paintComponent(g);
                g2.dispose();
            }
        };

        field.setPreferredSize(new Dimension(300, 45));
        field.setBackground(SECONDARY_COLOR);
        field.setForeground(TEXT_COLOR);
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setBorder(new EmptyBorder(10, 15, 10, 15));
        field.setOpaque(false);
        field.setEchoChar('•');

        return field;
    }

    private JButton createModernButton(String text, Color bgColor) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                if (getModel().isPressed()) {
                    g2.setColor(bgColor.darker());
                } else if (getModel().isRollover()) {
                    g2.setColor(bgColor.brighter());
                } else {
                    g2.setColor(bgColor);
                }

                g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 10, 10));

                g2.setColor(Color.WHITE);
                g2.setFont(getFont());
                FontMetrics fm = g2.getFontMetrics();
                int textWidth = fm.stringWidth(getText());
                int textHeight = fm.getAscent();
                g2.drawString(getText(),
                        (getWidth() - textWidth) / 2,
                        (getHeight() + textHeight) / 2 - 2);

                g2.dispose();
            }
        };

        button.setPreferredSize(new Dimension(300, 45));
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        return button;
    }

    private JButton createLinkButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        button.setForeground(PRIMARY_COLOR);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setForeground(PRIMARY_COLOR.brighter());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setForeground(PRIMARY_COLOR);
            }
        });

        return button;
    }

    private void styleScrollBar(JScrollPane scrollPane) {
        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = SECONDARY_COLOR;
                this.trackColor = BACKGROUND_COLOR;
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                return createZeroButton();
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                return createZeroButton();
            }

            private JButton createZeroButton() {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(0, 0));
                return button;
            }
        });
    }

    private void showModernMessage(String message, Color color) {
        JDialog dialog = new JDialog(mainFrame, true);
        dialog.setUndecorated(true);
        dialog.setSize(300, 100);
        dialog.setLocationRelativeTo(mainFrame);

        JPanel panel = new JPanel();
        panel.setBackground(color);
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel label = new JLabel(message);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Segoe UI", Font.BOLD, 14));
        label.setHorizontalAlignment(JLabel.CENTER);

        panel.add(label);
        dialog.add(panel);

        Timer timer = new Timer(2000, e -> dialog.dispose());
        timer.setRepeats(false);
        timer.start();

        dialog.setVisible(true);
    }

    // Book class
    private static class Book {
        String title, author, genre, Imagecovepath ,content;

        Book(String title, String author, String genre, String Imagecoverpath, String content) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.content = content;
            this.Imagecovepath = Imagecoverpath;
        }
    }
}