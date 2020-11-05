<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<h:panelGrid columns="2" width="100%" columnClasses="clos15,clos85">
    <h:outputText value="Classe thérapeutique:"/>
    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsPharmacie.prophaTherapeutique}" style="width:100%"/>
    <h:outputText value="Forme galénique:"/>
    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsPharmacie.prophaGalenique}" style="width:100%"/></h:column>
    <h:outputText value="DCI:"/>
    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsPharmacie.prophaFormuleDci}" style="width:100%"/>
    <h:outputText value="Position:"/>
    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsPharmacie.prophaPosition}" style="width:100%"/>
    <h:outputText value="Tableau:"/>
    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsPharmacie.prophaTableau}" style="width:100%"/>
    <h:outputText value="S.H.P:"/>
    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsPharmacie.prophaShp}" style="width:100%"/>
    <h:outputText value="Spécialité mère:"/>
    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsPharmacie.prophaSpecialite}" style="width:100%"/>
    <h:outputText value="Dosages:"/>
    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsPharmacie.prophaDosage}" style="width:100%"/>
    <h:outputText value="Nom unité:"/>
    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsPharmacie.prophaUnite}" style="width:100%"/>
    <h:outputText value="Nb unités prises:"/>
    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsPharmacie.prophaPrise}" style="width:100%"/>
    <h:outputText value="Marché:"/>
    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsPharmacie.prophaMarche}" style="width:100%"/>
    <h:outputText value="Origine:"/>
    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsPharmacie.prophaOrigine}" style="width:100%"/>
    <h:outputText value="Posologie:"/>
    <h:column><h:inputTextarea value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsPharmacie.prophaPosologie}" rows="4" style="width:100%" /></h:column>
    <h:column><h:outputText value="Indication:"/></h:column>
    <h:column><h:inputTextarea value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsPharmacie.prophaObservations}" rows="4" style="width:100%" /></h:column>
</h:panelGrid>

