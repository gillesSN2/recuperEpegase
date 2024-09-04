package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CategoriesTiersDTO;
import com.yewi.yewicore.recuperation.service.CategoriesTiersService;
import com.yewi.yewicore.recuperation.vo.CategoriesTiersQueryVO;
import com.yewi.yewicore.recuperation.vo.CategoriesTiersUpdateVO;
import com.yewi.yewicore.recuperation.vo.CategoriesTiersVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/categoriesTiers")
public class CategoriesTiersController {

    @Autowired
    private CategoriesTiersService categoriesTiersService;

    @PostMapping
    public String save(@Valid @RequestBody CategoriesTiersVO vO) {
        return categoriesTiersService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        categoriesTiersService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CategoriesTiersUpdateVO vO) {
        categoriesTiersService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CategoriesTiersDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return categoriesTiersService.getById(id);
    }

    @GetMapping
    public Page<CategoriesTiersDTO> query(@Valid CategoriesTiersQueryVO vO) {
        return categoriesTiersService.query(vO);
    }
}
