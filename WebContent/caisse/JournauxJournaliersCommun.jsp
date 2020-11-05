<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<rich:column width="40px" sortable="false" style="text-align:center">
    <f:facet name="header"><h:outputText value=""/></f:facet>
    <a4j:commandButton immediate="true" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.detailReglement}" title="Détail" image="/images/detail.png" style="width:20px;height:20px;" reRender="panelDetail"/>
</rich:column>
<rich:column label="Opération" width="100px" sortable="true" sortBy="#{table.libelleOperation}"  >
    <f:facet name="header"><h:outputText  value="Opération"/></f:facet>
    <h:outputText value="#{table.libelleOperation}" style="color:#{table.couleur};" title="#{table.libelleOperation}"/>
</rich:column>
<rich:column label="Etat" width="50px" sortable="true" sortBy="#{table.var_etat}"  >
    <f:facet name="header"><h:outputText  value="E."/></f:facet>
    <h:outputText value="#{table.var_etat}" style="color:#{table.couleur};" title="#{table.var_etat}"/>
</rich:column>
<rich:column label="Jour" width="70px" sortable="true" sortBy="#{table.rglDateReg}"  >
    <f:facet name="header"><h:outputText  value="Date"/></f:facet>
    <h:outputText value="#{table.rglDateReg}" style="color:#{table.couleur};" title="#{table.rglDateReg}">
        <f:convertDateTime pattern="dd/MM/yy"/>
    </h:outputText>
</rich:column>
<rich:column label="N° de pièce"  width="120px"  sortable="true" sortBy="#{table.rglNum}" sortOrder="DESCENDING" >
    <f:facet name="header"><h:outputText value="N° pièce" /></f:facet>
    <h:outputText value="#{table.rglNum}" style="color:#{table.couleur}" title="#{table.rglNum}"/>
</rich:column>
<rich:column label="Numéro d'origine" sortable="true" sortBy="#{table.rglDocument}" >
    <f:facet name="header"><h:outputText  value="N° Origine" /></f:facet>
    <h:outputText value="#{table.rglDocument}" style="color:#{table.couleur}" rendered="#{table.rglDocument!='NULL'}" title=""/>
</rich:column>
<rich:column label="Montant recette" width="100px" style="text-align:right;" sortable="true" sortBy="#{table.val_recette}" >
    <f:facet name="header"><h:outputText value="Recette" /></f:facet>
    <h:outputText value="#{table.val_recette}" rendered="#{table.val_recette!=0}" style="color:#{table.couleur}">
        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
    </h:outputText>
</rich:column>
<rich:column label="Montant dépense" width="100px" style="text-align:right;" sortable="true" sortBy="#{table.val_depense}" >
    <f:facet name="header"><h:outputText  value="Dépense"/></f:facet>
    <h:outputText value="#{table.val_depense}" rendered="#{table.val_depense!=0}" style="color:#{table.couleur}">
        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
    </h:outputText>
</rich:column>
<rich:column label="Timbre" width="80px" sortable="true" style="text-align:right;" sortBy="#{table.rglTimbre}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.var_type_onglet=='0'}">
    <f:facet name="header"><h:outputText value="Timbre" /></f:facet>
    <h:outputText value="#{table.rglTimbre}" style="color:#{table.couleur};" rendered="#{table.rglTimbre!=0}">
        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
    </h:outputText>
</rich:column>
<rich:column label="Tiers concerné" width="150px" sortable="true" sortBy="#{table.rglNomTiers}" >
    <f:facet name="header"><h:outputText  value="Tiers" /></f:facet>
    <h:outputText value="#{table.rglNomTiers}" style="color:#{table.couleur}" rendered="#{table.rglNomTiers!='NULL'}" title="#{table.rglNomTiers}"/>
</rich:column>
<rich:column label="Objet écriture"  width="200px"sortable="true" sortBy="#{table.rglObjet}" >
    <f:facet name="header"><h:outputText value="Objet" /></f:facet>
    <h:outputText value="#{table.rglObjet}" style="color:#{table.couleur};" rendered="#{table.rglObjet!='NULL'}" title="#{table.rglObjet}"/>
</rich:column>
<rich:column label="Transfert Caisse/Caisse" sortable="true" sortBy="#{table.rglNumMvt1}"  >
    <f:facet name="header"><h:outputText value="Trf. C/C" /></f:facet>
    <h:outputText value="#{table.rglNumMvt1}" style="color:#{table.couleur};" rendered="#{table.rglNumMvt1!='NULL'}" title="#{table.rglNumMvt1}"/>
</rich:column>
<rich:column label="Transfert Caisse/Banque" sortable="true" sortBy="#{table.rglNumMvt2}"  >
    <f:facet name="header"><h:outputText value="Trf. C/B" /></f:facet>
    <h:outputText value="#{table.rglNumMvt2}" style="color:#{table.couleur};" rendered="#{table.rglNumMvt2!='NULL'}" title="#{table.rglNumMvt2}"/>
</rich:column>
<rich:column label="N° chèque" sortable="true" sortBy="#{table.rglNumChqBdx}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.var_type_onglet=='1'}">
    <f:facet name="header"><h:outputText value="N° Chèque" /></f:facet>
    <h:outputText value="#{table.rglNumChqBdx}" style="color:#{table.couleur};" rendered="#{table.rglNumChqBdx!='NULL'}" title="#{table.rglNumChqBdx}"/>
</rich:column>
<rich:column label="Banque Tireur" sortable="true" sortBy="#{table.rglBanqueTireur}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.var_type_onglet=='1'}">
    <f:facet name="header"><h:outputText value="Bnq tir." /></f:facet>
    <h:outputText value="#{table.rglBanqueTireur}" style="color:#{table.couleur};" rendered="#{table.rglBanqueTireur!='NULL'}" title="#{table.rglBanqueTireur}"/>
</rich:column>
<rich:column label="Banque de dépôt" sortable="true" sortBy="#{table.rglCodeReceptrice}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.var_type_onglet=='1'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.var_type_onglet=='2'}">
    <f:facet name="header"><h:outputText value="Bnq dépôt" /></f:facet>
    <h:outputText value="#{table.rglCodeReceptrice}" style="color:#{table.couleur};" rendered="#{table.rglCodeReceptrice!='NULL'}" title="#{table.rglCodeReceptrice}"/>
</rich:column>