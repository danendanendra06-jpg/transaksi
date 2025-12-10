package ui.ft.ccit.faculty.transaksi.jenisbarang;

import org.springframework.data.jpa.repository.JpaRepository;

// Ganti Byte menjadi Integer
public interface JenisBarangRepository extends JpaRepository<JenisBarang, Integer> {
}