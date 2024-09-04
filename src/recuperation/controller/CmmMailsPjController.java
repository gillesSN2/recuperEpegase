package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmMailsPjDTO;
import com.yewi.yewicore.recuperation.service.CmmMailsPjService;
import com.yewi.yewicore.recuperation.vo.CmmMailsPjQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmMailsPjUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmMailsPjVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmMailsPj")
public class CmmMailsPjController {

    @Autowired
    private CmmMailsPjService cmmMailsPjService;

    @PostMapping
    public String save(@Valid @RequestBody CmmMailsPjVO vO) {
        return cmmMailsPjService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmMailsPjService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmMailsPjUpdateVO vO) {
        cmmMailsPjService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmMailsPjDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmMailsPjService.getById(id);
    }

    @GetMapping
    public Page<CmmMailsPjDTO> query(@Valid CmmMailsPjQueryVO vO) {
        return cmmMailsPjService.query(vO);
    }
}
