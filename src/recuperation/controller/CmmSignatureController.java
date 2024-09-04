package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmSignatureDTO;
import com.yewi.yewicore.recuperation.service.CmmSignatureService;
import com.yewi.yewicore.recuperation.vo.CmmSignatureQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmSignatureUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmSignatureVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmSignature")
public class CmmSignatureController {

    @Autowired
    private CmmSignatureService cmmSignatureService;

    @PostMapping
    public String save(@Valid @RequestBody CmmSignatureVO vO) {
        return cmmSignatureService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmSignatureService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmSignatureUpdateVO vO) {
        cmmSignatureService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmSignatureDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmSignatureService.getById(id);
    }

    @GetMapping
    public Page<CmmSignatureDTO> query(@Valid CmmSignatureQueryVO vO) {
        return cmmSignatureService.query(vO);
    }
}
