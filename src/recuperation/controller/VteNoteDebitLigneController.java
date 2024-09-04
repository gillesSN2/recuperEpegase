package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.VteNoteDebitLigneDTO;
import com.yewi.yewicore.recuperation.service.VteNoteDebitLigneService;
import com.yewi.yewicore.recuperation.vo.VteNoteDebitLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.VteNoteDebitLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteNoteDebitLigneVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/vteNoteDebitLigne")
public class VteNoteDebitLigneController {

    @Autowired
    private VteNoteDebitLigneService vteNoteDebitLigneService;

    @PostMapping
    public String save(@Valid @RequestBody VteNoteDebitLigneVO vO) {
        return vteNoteDebitLigneService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        vteNoteDebitLigneService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody VteNoteDebitLigneUpdateVO vO) {
        vteNoteDebitLigneService.update(id, vO);
    }

    @GetMapping("/{id}")
    public VteNoteDebitLigneDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return vteNoteDebitLigneService.getById(id);
    }

    @GetMapping
    public Page<VteNoteDebitLigneDTO> query(@Valid VteNoteDebitLigneQueryVO vO) {
        return vteNoteDebitLigneService.query(vO);
    }
}
