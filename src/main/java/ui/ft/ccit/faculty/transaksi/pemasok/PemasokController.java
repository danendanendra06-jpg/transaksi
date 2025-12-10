package ui.ft.ccit.faculty.transaksi.pemasok;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pemasok")
public class PemasokController {

    private final PemasokService service;

    public PemasokController(PemasokService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pemasok> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Pemasok get(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    public Pemasok create(@RequestBody Pemasok pemasok) {
        return service.create(pemasok);
    }

    @PutMapping("/{id}")
    public Pemasok update(@PathVariable String id, @RequestBody Pemasok pemasok) {
        pemasok.setIdPemasok(id); // pastikan ID konsisten
        return service.save(pemasok);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}