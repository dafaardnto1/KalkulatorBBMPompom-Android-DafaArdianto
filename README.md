<div align="center">

  <img src="docs/images/pompomlogo.png" alt="Logo Pompom BBM" width="140"/>

  # Kalkulator Estimasi Biaya BBM (Pompom)
  ### **Aplikasi Mobile Native Android — Tugas 6 Praktikum Mobile Programming**

  [![Kotlin](https://img.shields.io/badge/Language-Kotlin-7F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)](https://kotlinlang.org/)
  [![Android](https://img.shields.io/badge/Platform-Android-3DDC84.svg?style=for-the-badge&logo=android&logoColor=white)](https://developer.android.com/)
  [![Material 3](https://img.shields.io/badge/UI-Material%203-757575.svg?style=for-the-badge&logo=materialdesign&logoColor=white)](https://m3.material.io/)
  [![Gradle](https://img.shields.io/badge/Build-Gradle%20Kotlin%20DSL-02303A.svg?style=for-the-badge&logo=gradle&logoColor=white)](https://gradle.org/)

</div>

---

### PROFILE SAYA
- **Nama** : Dafa Ardianto
- Teknik Informatika (WEB DEVELOPER & ANDROID DEVELOPER)
- **GitHub Profile** : [@dafaardnto1](https://github.com/dafaardnto1)
- **Nama Repositori** : `KalkulatorBBMPompom-Android-DafaArdianto`

---

## 📖 Ringkasan Proyek

**Kalkulator Estimasi Biaya BBM (Pompom)** adalah aplikasi Android native yang dirancang untuk membantu pengguna menghitung estimasi kebutuhan liter bahan bakar minyak (BBM) dan total biaya operasional perjalanan sekali jalan berdasarkan jarak tempuh, konsumsi rata-rata kendaraan, serta harga BBM per liter.

Aplikasi ini mengusung gaya antarmuka **Glassmorphism** dengan palet warna **Hijau Army (Army Green) & Aksen Emas (Gold)** berlatar belakang **Putih Bersih (Clean White)**. Seluruh komponen didesain murni menggunakan **Material 3 Components** yang dikonfigurasi melalui `themes.xml` serta manajemen teks terpusat di `strings.xml`.

---

## ✨ Fitur Utama

- **🎨 Modern Glassmorphism UI**: Antarmuka kaca transparan yang melayang (floating panel) dengan sudut membulat (*rounded corners*) dan stroke halus.
- **⚡ Fitur Responsif 100% (Single Screen Fit)**: Seluruh tata letak dari Logo Utama, Form Input, Kartu Hasil, hingga Footer Mahasiswa disusun presisi sehingga muat dalam satu layar tanpa terpotong.
- **🛡️ Validasi Input Real-Time**: 
  - Mendeteksi dan mencegah input kosong.
  - Mencegah pembagian nol (*division by zero*) apabila konsumsi BBM bernilai $\le 0$.
- **💰 Format Mata Uang Rupiah Presisi**: Menggunakan kelas native `java.text.NumberFormat` dengan `Locale("in", "ID")` untuk mencetak mata uang secara standar (contoh: `Rp120.000,00`).
- **🔄 Manajemen Status Rotasi Layar (*Lifecycle & State Preservation*)**: Mengimplementasikan `onSaveInstanceState` dan `onRestoreInstanceState` agar hasil kalkulasi tidak hilang saat layar HP dirotasi.
- **📦 Kustomisasi Output Nama APK**: Hasil kompilasi build secara otomatis menghasilkan file bernama **`Tugas6DafaArdianto.apk`**.

---

## 🧮 Logika Matematika & Alur Bisnis

Aplikasi memproses 3 variabel input utama dari pengguna:
1. **$J$** = Jarak Tempuh ($\text{km}$)
2. **$K$** = Konsumsi BBM Kendaraan ($\text{km/liter}$)
3. **$H$** = Harga BBM per Liter ($\text{Rp/liter}$)

### Rumus Perhitungan:
1. **Kebutuhan Liter BBM ($L$)**:
   $$L = \frac{J}{K}$$
2. **Total Estimasi Biaya ($B$)**:
   $$B = L \times H$$

---

## 🛠️ Tech Stack & Arsitektur

| Komponen | Teknologi / Library |
| :--- | :--- |
| **Bahasa Pemrograman** | Kotlin 1.9+ |
| **UI Framework** | Native Android XML, Material 3 Components (`MaterialCardView`, `TextInputLayout`, `MaterialButton`) |
| **Sistem Desain** | Glassmorphism, Material Design 3 (M3) |
| **Build System** | Gradle Kotlin DSL (`build.gradle.kts`) |
| **Target SDK** | Android SDK 37 (Min SDK 24 / Android 7.0 Nougat+) |
| **Architecture Pattern** | Android Activity Lifecycle & View State Preservation |

---

## 📁 Struktur Berkas Proyek

```text
KalkulatorBBMPompom-Android-DafaArdianto/
├── app/
│   ├── build.gradle.kts                # Konfigurasi Gradle & Custom Output APK (Tugas6DafaArdianto.apk)
│   └── src/
│       └── main/
│           ├── AndroidManifest.xml     # Deklarasi Aktivitas & Label Aplikasi
│           ├── java/com/example/tugas6dafaardianto/
│           │   └── MainActivity.kt     # Logika Utama Perhitungan & Lifecycle
│           └── res/
│               ├── drawable/           # Ikon Vektor Native (ic_route, ic_local_gas_station, dll) & Logo
│               ├── layout/
│               │   └── activity_main.xml # Layout Utama dengan Material 3 Styles
│               ├── color/
│               │   └── glass_input_stroke_selector.xml # Selector Warna Garis Tepi Input (Fokus Emas)
│               └── values/
│                   ├── colors.xml      # Palet Warna Hijau Army, Gold, & Glass Translucency
│                   ├── strings.xml     # Berkas Resource Teks Terpusat (Tanpa Hardcoded Strings)
│                   └── themes.xml      # Definisi Style & Theme Material 3
├── docs/
│   └── images/
│       └── pompomlogo.png              # Aset Logo Brand Pompom
└── README.md                           # Dokumentasi Resmi Proyek
```

---

## 🚀 Cara Menjalankan & Kompilasi Proyek

1. **Clone Repositori ini**:
   ```bash
   git clone https://github.com/dafaardnto1/KalkulatorBBMPompom-Android-DafaArdianto.git
   ```
2. **Buka Proyek di Android Studio**:
   - Buka Android Studio (versi Ladybug / 2024+ disarankan).
   - Pilih **Open** ➔ Arahkan ke folder hasil clone proyek.
   - Tunggu hingga proses *Gradle Sync* selesai.
3. **Jalankan Aplikasi**:
   - Hubungkan HP Android atau gunakan Android Virtual Device (Emulator).
   - Tekan tombol **Run** (`Shift + F10`).
4. **Build File APK**:
   - Buka Terminal Android Studio dan jalankan:
     ```bash
     ./gradlew assembleDebug
     ```
   - Berkas APK akan terbentuk di lokasi:
     `app/build/outputs/apk/debug/Tugas6DafaArdianto.apk`

---

<div align="center">

  **Dibuat oleh [Dafa Ardianto](https://github.com/dafaardnto1)**  
  *WEB DEVELOPER & ANDROID DEVELOPER*

</div>
