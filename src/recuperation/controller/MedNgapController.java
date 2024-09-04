package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.MedNgapDTO;
import com.yewi.yewicore.recuperation.service.MedNgapService;
import com.yewi.yewicore.recuperation.vo.MedNgapQueryVO;
import com.yewi.yewicore.recuperation.vo.MedNgapUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedNgapVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/medNgap")
public class MedNgapController {

    @Autowired
    private MedNgapService medNgapService;

    @PostMapping
    public String save(@Valid @RequestBody MedNgapVO vO) {
        return medNgapService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        medNgapService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody MedNgapUpdateVO vO) {
        medNgapService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MedNgapDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return medNgapService.getById(id);
    }

    @GetMapping
    public Page<MedNgapDTO> query(@Valid MedNgapQueryVO vO) {
        return medNgapService.query(vO);
    }
}
