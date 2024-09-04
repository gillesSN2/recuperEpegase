package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchNoteDebitLigneDTO;
import com.yewi.yewicore.recuperation.service.AchNoteDebitLigneService;
import com.yewi.yewicore.recuperation.vo.AchNoteDebitLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.AchNoteDebitLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchNoteDebitLigneVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achNoteDebitLigne")
public class AchNoteDebitLigneController {

    @Autowired
    private AchNoteDebitLigneService achNoteDebitLigneService;

    @PostMapping
    public String save(@Valid @RequestBody AchNoteDebitLigneVO vO) {
        return achNoteDebitLigneService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achNoteDebitLigneService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchNoteDebitLigneUpdateVO vO) {
        achNoteDebitLigneService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchNoteDebitLigneDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achNoteDebitLigneService.getById(id);
    }

    @GetMapping
    public Page<AchNoteDebitLigneDTO> query(@Valid AchNoteDebitLigneQueryVO vO) {
        return achNoteDebitLigneService.query(vO);
    }
}
