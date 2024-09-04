package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.PayFeuilleCalculRubriqueDTO;
import com.yewi.yewicore.recuperation.service.PayFeuilleCalculRubriqueService;
import com.yewi.yewicore.recuperation.vo.PayFeuilleCalculRubriqueQueryVO;
import com.yewi.yewicore.recuperation.vo.PayFeuilleCalculRubriqueUpdateVO;
import com.yewi.yewicore.recuperation.vo.PayFeuilleCalculRubriqueVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/payFeuilleCalculRubrique")
public class PayFeuilleCalculRubriqueController {

    @Autowired
    private PayFeuilleCalculRubriqueService payFeuilleCalculRubriqueService;

    @PostMapping
    public String save(@Valid @RequestBody PayFeuilleCalculRubriqueVO vO) {
        return payFeuilleCalculRubriqueService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        payFeuilleCalculRubriqueService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody PayFeuilleCalculRubriqueUpdateVO vO) {
        payFeuilleCalculRubriqueService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PayFeuilleCalculRubriqueDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return payFeuilleCalculRubriqueService.getById(id);
    }

    @GetMapping
    public Page<PayFeuilleCalculRubriqueDTO> query(@Valid PayFeuilleCalculRubriqueQueryVO vO) {
        return payFeuilleCalculRubriqueService.query(vO);
    }
}
