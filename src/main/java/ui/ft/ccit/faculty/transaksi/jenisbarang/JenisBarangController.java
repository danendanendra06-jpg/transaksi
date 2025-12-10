package ui.ft.ccit.faculty.transaksi.jenisbarang;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jenis-barang")
public class JenisBarangController {

    private final JenisBarangService service;

    public JenisBarangController(JenisBarangService service) {
        this.service = service;
    }

    @GetMapping
    public List<JenisBarang> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public JenisBarang get(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public JenisBarang create(@RequestBody JenisBarang jenisBarang) {
        return service.save(jenisBarang);
    }

    @PutMapping("/{id}")
    public JenisBarang update(@PathVariable Integer id, @RequestBody JenisBarang jenisBarang) {
        jenisBarang.setIdJenisBarang(id.byteValue());
        return service.save(jenisBarang);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}