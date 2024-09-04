package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmProduitsReponseDTO;
import com.yewi.yewicore.recuperation.service.CmmProduitsReponseService;
import com.yewi.yewicore.recuperation.vo.CmmProduitsReponseQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsReponseUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsReponseVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmProduitsReponse")
public class CmmProduitsReponseController {

    @Autowired
    private CmmProduitsReponseService cmmProduitsReponseService;

    @PostMapping
    public String save(@Valid @RequestBody CmmProduitsReponseVO vO) {
        return cmmProduitsReponseService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmProduitsReponseService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmProduitsReponseUpdateVO vO) {
        cmmProduitsReponseService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmProduitsReponseDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmProduitsReponseService.getById(id);
    }

    @GetMapping
    public Page<CmmProduitsReponseDTO> query(@Valid CmmProduitsReponseQueryVO vO) {
        return cmmProduitsReponseService.query(vO);
    }
}
