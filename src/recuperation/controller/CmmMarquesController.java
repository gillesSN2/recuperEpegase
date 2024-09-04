package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmMarquesDTO;
import com.yewi.yewicore.recuperation.service.CmmMarquesService;
import com.yewi.yewicore.recuperation.vo.CmmMarquesQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmMarquesUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmMarquesVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmMarques")
public class CmmMarquesController {

    @Autowired
    private CmmMarquesService cmmMarquesService;

    @PostMapping
    public String save(@Valid @RequestBody CmmMarquesVO vO) {
        return cmmMarquesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmMarquesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmMarquesUpdateVO vO) {
        cmmMarquesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmMarquesDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmMarquesService.getById(id);
    }

    @GetMapping
    public Page<CmmMarquesDTO> query(@Valid CmmMarquesQueryVO vO) {
        return cmmMarquesService.query(vO);
    }
}
