// Dafa Ardianto
// 3420230004 Teknik Informatika

package com.example.tugas6dafaardianto

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat
import java.util.Locale

/**
 * ====================================================================================
 * NAMA : Dafa Ardianto (NIM: 3420230004 - Teknik Informatika)
 * ====================================================================================
 * 1. Aplikasi ini berfungsi sebagai Kalkulator Estimasi Biaya BBM (Bahan Bakar Minyak).
 * 2. Menggunakan konsep Glassmorphism & Palet Warna Hijau Army berlatar putih bersih.
 * 3. Seluruh teks (Label, Error, Formatting, Toast) dipanggil dari R.string (strings.xml).
 * 4. Menangani validasi input, kalkulasi rumus matematis kebutuhan BBM, serta
 *    format mata uang Rupiah Indonesia (Rp).
 * 5. Mendukung Lifecycle Management (onSaveInstanceState) agar hasil kalkulasi tidak
 *    hilang saat rotasi layar HP.
 * ====================================================================================
 */
class MainActivity : AppCompatActivity() {

    // Deklarasi Komponen UI (Views)
    // Dafa Ardianto - 3420230004 Teknik Informatika
    private lateinit var etJarak: EditText      // Input Jarak Tempuh (km)
    private lateinit var etKonsumsi: EditText   // Input Konsumsi BBM kendaraan (km/liter)
    private lateinit var etHargaBbm: EditText   // Input Harga BBM per liter (Rp)
    private lateinit var btnHitung: Button      // Tombol Eksekusi Perhitungan
    private lateinit var tvHasil: TextView      // Label untuk menampilkan hasil estimasi

    companion object {
        // Tag untuk keperluan Logcat saat debugging
        private const val TAG = "LifecycleBBM"
        // Key Kunci untuk menyimpan status data hasil saat rotasi layar
        private const val STATE_HASIL = "state_hasil_estimasi"
    }

    /**
     * Method onCreate() dipanggil saat Activity pertama kali dibuat oleh sistem Android.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Hubungkan kelas Kotlin ini dengan berkas layout activity_main.xml
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate dipanggil: Activity berhasil diinisialisasi")

        // 1. Inisialisasi (Binding) Komponen UI dari XML berdasarkan ID masing-masing
        etJarak = findViewById(R.id.etJarak)
        etKonsumsi = findViewById(R.id.etKonsumsi)
        etHargaBbm = findViewById(R.id.etHargaBbm)
        btnHitung = findViewById(R.id.btnHitung)
        tvHasil = findViewById(R.id.tvHasil)

        // 2. Pasang Event Listener pada Tombol Hitung
        // Saat tombol diklik, method hitungBiayaBbm() akan dijalankan
        btnHitung.setOnClickListener {
            hitungBiayaBbm()
        }
    }

    /**
     * Method utama untuk memproses validasi data, rumus kalkulasi, dan pembacaan hasil.
     * - Mengambil teks input dari etJarak, etKonsumsi, dan etHargaBbm.
     * - Melakukan validasi jika input kosong atau bernilai <= 0 menggunakan R.string.
     * - Menghitung Kebutuhan Liter = Jarak / Konsumsi BBM.
     * - Menghitung Biaya Total = Kebutuhan Liter * Harga per Liter.
     */
    private fun hitungBiayaBbm() {
        // Ambil string dari masing-masing input dan hapus spasi berlebih (trim)
        val inputJarak = etJarak.text.toString().trim()
        val inputKonsumsi = etKonsumsi.text.toString().trim()
        val inputHarga = etHargaBbm.text.toString().trim()

        var isEmptyFields = false

        // Validasi 1: Periksa apakah kolom jarak kosong (Memanggil R.string.error_jarak_empty)
        if (inputJarak.isEmpty()) {
            isEmptyFields = true
            etJarak.error = getString(R.string.error_jarak_empty)
        }
        // Validasi 2: Periksa apakah kolom konsumsi kosong (Memanggil R.string.error_konsumsi_empty)
        if (inputKonsumsi.isEmpty()) {
            isEmptyFields = true
            etKonsumsi.error = getString(R.string.error_konsumsi_empty)
        }
        // Validasi 3: Periksa apakah kolom harga BBM kosong (Memanggil R.string.error_harga_empty)
        if (inputHarga.isEmpty()) {
            isEmptyFields = true
            etHargaBbm.error = getString(R.string.error_harga_empty)
        }

        // Jika ada input yang kosong, hentikan proses perhitungan
        if (isEmptyFields) {
            Log.w(TAG, "Validasi gagal: Terdapat input yang masih kosong")
            return
        }

        // Konversi input string menjadi tipe data Double untuk perhitungan presisi desimal
        val jarak = inputJarak.toDouble()
        val konsumsi = inputKonsumsi.toDouble()
        val harga = inputHarga.toDouble()

        // Validasi Tambahan: Konsumsi BBM tidak boleh nol atau negatif
        if (konsumsi <= 0) {
            etKonsumsi.error = getString(R.string.error_konsumsi_zero)
            return
        }

        // RUMUS UTAMA:
        // 1. Liter BBM yang dibutuhkan = Jarak Tempuh (km) / Konsumsi BBM (km/liter)
        val literDibutuhkan = jarak / konsumsi
        // 2. Total Estimasi Biaya (Rp) = Liter BBM * Harga per Liter
        val totalBiaya = literDibutuhkan * harga

        // Format angka hasil menjadi format mata uang Rupiah Indonesia (contoh: Rp120.000,00)
        val formatRupiah = NumberFormat.getCurrencyInstance(Locale("in", "ID"))
        val teksBiayaFormatted = formatRupiah.format(totalBiaya)

        // Susun teks hasil memanggil R.string.format_hasil
        val hasilTeks = getString(R.string.format_hasil, literDibutuhkan, teksBiayaFormatted)

        // Tampilkan teks hasil di TextView tvHasil
        tvHasil.text = hasilTeks
        Log.i(TAG, "Kalkulasi Berhasil: $hasilTeks")

        // Berikan respon umpan balik berupa pesan Toast dari R.string.toast_sukses
        Toast.makeText(this, getString(R.string.toast_sukses), Toast.LENGTH_SHORT).show()
    }

    /**
     * Method Lifecycle: Simpan data hasil estimasi saat terjadi perubahan konfigurasi (misal: rotasi layar HP)
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_HASIL, tvHasil.text.toString())
        Log.d(TAG, "onSaveInstanceState dipanggil: Menyelamatkan data hasil estimasi")
    }

    /**
     * Method Lifecycle: Pulihkan data hasil estimasi setelah layar selesai dirotasi
     */
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val hasilTersimpan = savedInstanceState.getString(STATE_HASIL)
        if (hasilTersimpan != null) {
            tvHasil.text = hasilTersimpan
            Log.d(TAG, "onRestoreInstanceState dipanggil: Data hasil estimasi berhasil dipulihkan")
        }
    }
}