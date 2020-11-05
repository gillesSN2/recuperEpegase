<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="ficproduitschg">

    <a4j:form id="produitformchg" enctype="multipart/form-data">
        <rich:hotKey key="return" handler="return false;"/>

        <center><h2><h:outputText value="CHANGE CODE PRODUIT MEDICAL ET/OU FAMILLE" style="color:green;"/></h2></center>

        <h:panelGrid width="100%">

            <jsp:include flush="true" page="/medical/ProduitsCommun.jsp" />

            <h:panelGrid id="idGlobChg" width="100%">
                <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80" id="idProduitChange" styleClass="fichefournisseur">
                    <h:column><h:outputText value="Ancien code:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.ancienCode}" readonly="true" disabled="true"/></h:column>
                    <h:column><h:outputText value="Fusion ou Création:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.fusionAjout}">
                            <f:selectItem itemLabel="Fusion (le produit de destination doit exister)" itemValue="0"/>
                            <f:selectItem itemLabel="Change code (le nouveau produit ne doit pas exister)" itemValue="1"/>
                            <f:selectItem itemLabel="Le code ne change pas" itemValue="2"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="idProduitChange,idNew1,idNew2,idLab1,idLab2"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column id="idLab1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.fusionAjout==0}"><h:outputText value="Produit de destination:" style="text-decoration:underline;"/></h:column>
                    <h:column id="idNew1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.fusionAjout==0}">
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.nouveauCode}" maxlength="20">
                            <a4j:support event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.verifUnicite2}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idNew1,panelButton,idGlobChg"/>
                        </h:inputText>
                    </h:column>
                    <h:column id="idLab2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.fusionAjout==1}"><h:outputText value="Nouveau code:"/></h:column>
                    <h:column id="idNew2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.fusionAjout==1}">
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.nouveauCode}" maxlength="20">
                            <a4j:support event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.verifUnicite}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idNew2,panelButton,idGlobChg"/>
                        </h:inputText>
                    </h:column>
                </h:panelGrid>

                <br>

                <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80" styleClass="fichefournisseur">
                    <h:column><h:outputText value="Ancienne famille achat:"/></h:column>
                    <h:column><h:inputText style="width:50%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.ancienneFamilleAchat}" readonly="true" disabled="true"/></h:column>
                    <h:column><h:outputText value="Nouvelle famille achat:"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idFamilleAchat" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.nouvelleFamilleAchat}">
                            <f:selectItem itemLabel="" itemValue="0"/>
                            <f:selectItem itemLabel="Sans famille Achat" itemValue="0_0_0_0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesFamillesAchatsUtilItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Ancienne famille vente:"/></h:column>
                    <h:column><h:inputText style="width:50%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.ancienneFamilleVente}" readonly="true" disabled="true"/></h:column>
                    <h:column><h:outputText value="Nouvelle famille vente:"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idFamilleVente" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.nouvelleFamilleVente}">
                            <f:selectItem itemLabel="" itemValue="0"/>
                            <f:selectItem itemLabel="Sans famille Vente" itemValue="0_0_0_0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesFamillesVentesUtilItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>

                <h:panelGroup id="panelButton">
                    <center>
                        <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.annuleChangeCodeProduit}" reRender="idSubView"/>&nbsp;&nbsp;
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.valideChangeCodeProduit}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </h:panelGrid>

        </h:panelGrid>

    </a4j:form>

</f:subview>
