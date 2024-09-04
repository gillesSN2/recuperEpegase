package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.UserFonctionnaliteDroitDTO;
import com.yewi.yewicore.recuperation.service.UserFonctionnaliteDroitService;
import com.yewi.yewicore.recuperation.vo.UserFonctionnaliteDroitQueryVO;
import com.yewi.yewicore.recuperation.vo.UserFonctionnaliteDroitUpdateVO;
import com.yewi.yewicore.recuperation.vo.UserFonctionnaliteDroitVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/userFonctionnaliteDroit")
public class UserFonctionnaliteDroitController {

    @Autowired
    private UserFonctionnaliteDroitService userFonctionnaliteDroitService;

    @PostMapping
    public String save(@Valid @RequestBody UserFonctionnaliteDroitVO vO) {
        return userFonctionnaliteDroitService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        userFonctionnaliteDroitService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody UserFonctionnaliteDroitUpdateVO vO) {
        userFonctionnaliteDroitService.update(id, vO);
    }

    @GetMapping("/{id}")
    public UserFonctionnaliteDroitDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return userFonctionnaliteDroitService.getById(id);
    }

    @GetMapping
    public Page<UserFonctionnaliteDroitDTO> query(@Valid UserFonctionnaliteDroitQueryVO vO) {
        return userFonctionnaliteDroitService.query(vO);
    }
}
