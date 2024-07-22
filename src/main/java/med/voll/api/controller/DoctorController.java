package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.doctor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public void createDoctor(@RequestBody @Valid DoctorData data) {
        repository.save(new Doctor(data));
    }

    @GetMapping
    public Page<DoctorListData> listDoctors(@PageableDefault(sort = {"nome", "crm"}) Pageable pageable) {
        return repository.findAll(pageable).map(DoctorListData::new);
    }

    @PutMapping
    @Transactional
    public void updateDoctor(@RequestBody @Valid DoctorUpdateData data) {
        Doctor doctor = repository.findById(data.id()).orElse(null);
        assert doctor != null;
        doctor.updateData(data);
    }
}
