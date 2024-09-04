package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.VteAvoirLigneDTO;
import com.yewi.yewicore.recuperation.service.VteAvoirLigneService;
import com.yewi.yewicore.recuperation.vo.VteAvoirLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.VteAvoirLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteAvoirLigneVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/vteAvoirLigne")
public class VteAvoirLigneController {

    @Autowired
    private VteAvoirLigneService vteAvoirLigneService;

    @PostMapping
    public String save(@Valid @RequestBody VteAvoirLigneVO vO) {
        return vteAvoirLigneService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        vteAvoirLigneService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody VteAvoirLigneUpdateVO vO) {
        vteAvoirLigneService.update(id, vO);
    }

    @GetMapping("/{id}")
    public VteAvoirLigneDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return vteAvoirLigneService.getById(id);
    }

    @GetMapping
    public Page<VteAvoirLigneDTO> query(@Valid VteAvoirLigneQueryVO vO) {
        return vteAvoirLigneService.query(vO);
    }
}
