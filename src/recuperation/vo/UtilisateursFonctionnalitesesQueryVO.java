package recuperation.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class UtilisateursFonctionnalitesesQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long utilisateurId;

    private String fonctionnalitesesCode;

}
