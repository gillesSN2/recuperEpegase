package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmContactsDTO;
import com.yewi.yewicore.recuperation.service.CmmContactsService;
import com.yewi.yewicore.recuperation.vo.CmmContactsQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmContactsUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmContactsVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmContacts")
public class CmmContactsController {

    @Autowired
    private CmmContactsService cmmContactsService;

    @PostMapping
    public String save(@Valid @RequestBody CmmContactsVO vO) {
        return cmmContactsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmContactsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmContactsUpdateVO vO) {
        cmmContactsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmContactsDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmContactsService.getById(id);
    }

    @GetMapping
    public Page<CmmContactsDTO> query(@Valid CmmContactsQueryVO vO) {
        return cmmContactsService.query(vO);
    }
}
