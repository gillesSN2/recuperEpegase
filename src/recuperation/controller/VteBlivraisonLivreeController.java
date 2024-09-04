package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.VteBlivraisonLivreeDTO;
import com.yewi.yewicore.recuperation.service.VteBlivraisonLivreeService;
import com.yewi.yewicore.recuperation.vo.VteBlivraisonLivreeQueryVO;
import com.yewi.yewicore.recuperation.vo.VteBlivraisonLivreeUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteBlivraisonLivreeVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/vteBlivraisonLivree")
public class VteBlivraisonLivreeController {

    @Autowired
    private VteBlivraisonLivreeService vteBlivraisonLivreeService;

    @PostMapping
    public String save(@Valid @RequestBody VteBlivraisonLivreeVO vO) {
        return vteBlivraisonLivreeService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        vteBlivraisonLivreeService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody VteBlivraisonLivreeUpdateVO vO) {
        vteBlivraisonLivreeService.update(id, vO);
    }

    @GetMapping("/{id}")
    public VteBlivraisonLivreeDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return vteBlivraisonLivreeService.getById(id);
    }

    @GetMapping
    public Page<VteBlivraisonLivreeDTO> query(@Valid VteBlivraisonLivreeQueryVO vO) {
        return vteBlivraisonLivreeService.query(vO);
    }
}
