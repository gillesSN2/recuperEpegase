package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmProduitsActeDTO;
import com.yewi.yewicore.recuperation.service.CmmProduitsActeService;
import com.yewi.yewicore.recuperation.vo.CmmProduitsActeQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsActeUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsActeVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmProduitsActe")
public class CmmProduitsActeController {

    @Autowired
    private CmmProduitsActeService cmmProduitsActeService;

    @PostMapping
    public String save(@Valid @RequestBody CmmProduitsActeVO vO) {
        return cmmProduitsActeService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmProduitsActeService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmProduitsActeUpdateVO vO) {
        cmmProduitsActeService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmProduitsActeDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmProduitsActeService.getById(id);
    }

    @GetMapping
    public Page<CmmProduitsActeDTO> query(@Valid CmmProduitsActeQueryVO vO) {
        return cmmProduitsActeService.query(vO);
    }
}
