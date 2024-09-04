package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.VteCommissionLigneDTO;
import com.yewi.yewicore.recuperation.service.VteCommissionLigneService;
import com.yewi.yewicore.recuperation.vo.VteCommissionLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.VteCommissionLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteCommissionLigneVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/vteCommissionLigne")
public class VteCommissionLigneController {

    @Autowired
    private VteCommissionLigneService vteCommissionLigneService;

    @PostMapping
    public String save(@Valid @RequestBody VteCommissionLigneVO vO) {
        return vteCommissionLigneService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        vteCommissionLigneService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody VteCommissionLigneUpdateVO vO) {
        vteCommissionLigneService.update(id, vO);
    }

    @GetMapping("/{id}")
    public VteCommissionLigneDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return vteCommissionLigneService.getById(id);
    }

    @GetMapping
    public Page<VteCommissionLigneDTO> query(@Valid VteCommissionLigneQueryVO vO) {
        return vteCommissionLigneService.query(vO);
    }
}
