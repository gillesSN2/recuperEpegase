package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.MedProduitsDciDTO;
import com.yewi.yewicore.recuperation.service.MedProduitsDciService;
import com.yewi.yewicore.recuperation.vo.MedProduitsDciQueryVO;
import com.yewi.yewicore.recuperation.vo.MedProduitsDciUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedProduitsDciVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/medProduitsDci")
public class MedProduitsDciController {

    @Autowired
    private MedProduitsDciService medProduitsDciService;

    @PostMapping
    public String save(@Valid @RequestBody MedProduitsDciVO vO) {
        return medProduitsDciService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        medProduitsDciService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody MedProduitsDciUpdateVO vO) {
        medProduitsDciService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MedProduitsDciDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return medProduitsDciService.getById(id);
    }

    @GetMapping
    public Page<MedProduitsDciDTO> query(@Valid MedProduitsDciQueryVO vO) {
        return medProduitsDciService.query(vO);
    }
}
