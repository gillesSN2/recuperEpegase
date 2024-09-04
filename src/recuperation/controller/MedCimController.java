package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.MedCimDTO;
import com.yewi.yewicore.recuperation.service.MedCimService;
import com.yewi.yewicore.recuperation.vo.MedCimQueryVO;
import com.yewi.yewicore.recuperation.vo.MedCimUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedCimVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/medCim")
public class MedCimController {

    @Autowired
    private MedCimService medCimService;

    @PostMapping
    public String save(@Valid @RequestBody MedCimVO vO) {
        return medCimService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        medCimService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody MedCimUpdateVO vO) {
        medCimService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MedCimDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return medCimService.getById(id);
    }

    @GetMapping
    public Page<MedCimDTO> query(@Valid MedCimQueryVO vO) {
        return medCimService.query(vO);
    }
}
