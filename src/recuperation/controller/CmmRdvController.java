package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmRdvDTO;
import com.yewi.yewicore.recuperation.service.CmmRdvService;
import com.yewi.yewicore.recuperation.vo.CmmRdvQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmRdvUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmRdvVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmRdv")
public class CmmRdvController {

    @Autowired
    private CmmRdvService cmmRdvService;

    @PostMapping
    public String save(@Valid @RequestBody CmmRdvVO vO) {
        return cmmRdvService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmRdvService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmRdvUpdateVO vO) {
        cmmRdvService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmRdvDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmRdvService.getById(id);
    }

    @GetMapping
    public Page<CmmRdvDTO> query(@Valid CmmRdvQueryVO vO) {
        return cmmRdvService.query(vO);
    }
}
