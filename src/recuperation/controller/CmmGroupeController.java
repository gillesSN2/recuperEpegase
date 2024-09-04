package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmGroupeDTO;
import com.yewi.yewicore.recuperation.service.CmmGroupeService;
import com.yewi.yewicore.recuperation.vo.CmmGroupeQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmGroupeUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmGroupeVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmGroupe")
public class CmmGroupeController {

    @Autowired
    private CmmGroupeService cmmGroupeService;

    @PostMapping
    public String save(@Valid @RequestBody CmmGroupeVO vO) {
        return cmmGroupeService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmGroupeService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmGroupeUpdateVO vO) {
        cmmGroupeService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmGroupeDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmGroupeService.getById(id);
    }

    @GetMapping
    public Page<CmmGroupeDTO> query(@Valid CmmGroupeQueryVO vO) {
        return cmmGroupeService.query(vO);
    }
}
