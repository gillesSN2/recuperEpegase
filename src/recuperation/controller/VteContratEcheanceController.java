package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.VteContratEcheanceDTO;
import com.yewi.yewicore.recuperation.service.VteContratEcheanceService;
import com.yewi.yewicore.recuperation.vo.VteContratEcheanceQueryVO;
import com.yewi.yewicore.recuperation.vo.VteContratEcheanceUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteContratEcheanceVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/vteContratEcheance")
public class VteContratEcheanceController {

    @Autowired
    private VteContratEcheanceService vteContratEcheanceService;

    @PostMapping
    public String save(@Valid @RequestBody VteContratEcheanceVO vO) {
        return vteContratEcheanceService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        vteContratEcheanceService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody VteContratEcheanceUpdateVO vO) {
        vteContratEcheanceService.update(id, vO);
    }

    @GetMapping("/{id}")
    public VteContratEcheanceDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return vteContratEcheanceService.getById(id);
    }

    @GetMapping
    public Page<VteContratEcheanceDTO> query(@Valid VteContratEcheanceQueryVO vO) {
        return vteContratEcheanceService.query(vO);
    }
}
