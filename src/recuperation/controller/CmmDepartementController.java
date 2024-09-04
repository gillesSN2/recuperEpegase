package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmDepartementDTO;
import com.yewi.yewicore.recuperation.service.CmmDepartementService;
import com.yewi.yewicore.recuperation.vo.CmmDepartementQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmDepartementUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmDepartementVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmDepartement")
public class CmmDepartementController {

    @Autowired
    private CmmDepartementService cmmDepartementService;

    @PostMapping
    public String save(@Valid @RequestBody CmmDepartementVO vO) {
        return cmmDepartementService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmDepartementService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmDepartementUpdateVO vO) {
        cmmDepartementService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmDepartementDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmDepartementService.getById(id);
    }

    @GetMapping
    public Page<CmmDepartementDTO> query(@Valid CmmDepartementQueryVO vO) {
        return cmmDepartementService.query(vO);
    }
}
