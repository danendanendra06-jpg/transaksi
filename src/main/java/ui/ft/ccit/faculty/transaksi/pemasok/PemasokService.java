package ui.ft.ccit.faculty.transaksi.pemasok;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ui.ft.ccit.faculty.transaksi.DataAlreadyExistsException;
import ui.ft.ccit.faculty.transaksi.DataNotFoundException;

@Service
@Transactional
public class PemasokService {

    private final PemasokRepository repository;

    public PemasokService(PemasokRepository repository) {
        this.repository = repository;
    }

    public List<Pemasok> findAll() {
        return repository.findAll();
    }

    public Pemasok findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Pemasok", id));
    }

    public Pemasok save(Pemasok pemasok) {
        // Cek jika create baru dan ID sudah ada
        if (repository.existsById(pemasok.getIdPemasok())) {
             // Logic sederhana: jika create dianggap update jika ada, 
             // atau throw error jika ingin strict. Di sini kita biarkan save (upsert)
             // atau gunakan DataAlreadyExistsException jika ingin strict saat POST
        }
        return repository.save(pemasok);
    }

    public Pemasok create(Pemasok pemasok) {
        if (repository.existsById(pemasok.getIdPemasok())) {
            throw new DataAlreadyExistsException("Pemasok", pemasok.getIdPemasok());
        }
        return repository.save(pemasok);
    }

    public void delete(String id) {
        if (!repository.existsById(id)) {
            throw new DataNotFoundException("Pemasok", id);
        }
        repository.deleteById(id);
    }
}