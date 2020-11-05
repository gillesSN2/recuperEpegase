<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<f:subview id="facturechargefiche">

    <a4j:form enctype="multipart/form-data">
        <rich:hotKey key="return" handler="return false;"/>

        <center> <h2><h:outputText value="DESCRIPTION FACTURE DE CHARGE" style="color:green;"/></h2></center>

        <h:panelGrid width="100%">

            <h:panelGrid width="100%" id="panelBien" styleClass="fichefournisseur" columns="2" columnClasses="clos15,clos85">
                <h:column><h:outputText value="Code O.T. concerné:"  style="text-decoration:underline"/></h:column>
                <h:column>
                    <h:inputText style="width:90%" id="idOt" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.referenceOt}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.var_action>=50}" maxlength="100">
                        <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les travaux (puis tabuler)" style="background-color:#FFF8D4;"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.rechercheTravauxDirect}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeTiers,formModalListeTiers,idFournisseur,valideFacture"/>
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="Bien concerné:"  style="text-decoration:underline"/></h:column>
                <h:column>
                    <h:inputText style="width:90%" id="idBien" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.referenceBien}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.var_aff_detail_bien}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.var_aff_detail_bien&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.var_action>=50}" maxlength="100">
                        <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les biens (puis tabuler)" style="background-color:#FFF8D4;"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.rechercheBiensDirect}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeTiers,formModalListeTiers,idFournisseur,valideFacture"/>
                    </h:inputText>&nbsp;
                    <a4j:commandButton image="/images/detail.png" title="Fiche du bien" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.detailBiens}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.var_aff_detail_bien}" reRender="idSubView"/>&nbsp;
                    <a4j:commandButton image="/images/modifier.png" title="Changer le bien" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.modifBiens}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.var_aff_detail_bien}" reRender="idBien"/>
                </h:column>
            </h:panelGrid>
            <h:panelGrid width="100%" id="idFournisseur" styleClass="fichefournisseur" columns="2" columnClasses="clos15,clos85">
                <h:column><h:outputText value="Nom Fournisseur:"  style="text-decoration:underline"/></h:column>
                <h:column>
                    <h:inputText style="width:90%" id="idTiers" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.bienTravauxLigne.bietraligNomTiers}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.var_aff_detail_fournisseur}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.var_aff_detail_fournisseur&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.var_action>=50}" maxlength="100">
                        <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les fournisseur (puis tabuler)" style="background-color:#FFF8D4;"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.rechercheFournisseurs}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeTiers,formModalListeTiers,idFournisseur,panelValide"/>
                    </h:inputText>&nbsp;
                    <a4j:commandButton image="/images/detail.png" title="Fiche du fournisseur" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.detailFournisseurs}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.var_aff_detail_fournisseur}" reRender="idSubView"/>&nbsp;
                    <a4j:commandButton image="/images/modifier.png" title="Changer le fournisseur" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.modifFournisseurs}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.var_aff_detail_fournisseur}" reRender="idTiers"/>
                </h:column>
            </h:panelGrid>
            <h:panelGrid width="100%" id="idFournisseurSuite" styleClass="fichefournisseur" columns="4" columnClasses="clos15,clos35,clos15,clos35" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.tiers!=null}">
                <h:column><h:outputText value="Adressé:"/></h:column>
                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.tiers.tieadresse}" disabled="true"/></h:column>
                <h:column><h:outputText value="Rue:"/></h:column>
                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.tiers.tierue}" disabled="true"/></h:column>
                <h:column><h:outputText value="Tel.1:"/></h:column>
                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.tiers.tieburtel1}" disabled="true"/></h:column>
                <h:column><h:outputText value="Tel.2:"/></h:column>
                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.tiers.tieburtel2}" disabled="true"/></h:column>
                <h:column><h:outputText value="Fax:"/></h:column>
                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.tiers.tieburfax}" disabled="true"/></h:column>
                <h:column><h:outputText value="eMail:"/></h:column>
                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.tiers.tiemail1}" disabled="true"/></h:column>
                <h:column><h:outputText value="Ville:"/></h:column>
                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.tiers.tieville}" disabled="true"/></h:column>
                <h:column><h:outputText value="Pays:"/></h:column>
                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.tiers.tienompays}" disabled="true"/></h:column>
            </h:panelGrid>

            <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">
                <rich:tab id="tabFacture" label="Facture">
                    <h:panelGrid width="100%" id="idFacture" styleClass="fichefournisseur" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                        <h:column><h:outputText value="Poste budgétaire:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" id="idPoste" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.bienTravauxLigne.bietraligPoste}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.var_action>=50}">
                                <f:selectItem itemLabel="Sélection poste budgétaire" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.lesPostesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Bloc concerné:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" id="idBloc" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.bienTravauxLigne.bietraligCodeLocal}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.var_action>=50}">
                                <f:selectItem itemLabel="Sélection bloc" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.lesBlocsItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="N° Facture:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.bienTravauxLigne.bietraligNumFacture}" disabled="true" readonly="true"/></h:column>
                        <h:column><h:outputText value="Date Facture:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.bienTravauxLigne.bietraligDateFacture}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.var_action>=50}"/></h:column>
                        <h:column><h:outputText value="Objet:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.bienTravauxLigne.bietraligObjetFacture}" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.var_action>=50}"/></h:column>
                        <h:column><h:outputText value="Référence facture"/></h:column>
                        <h:column><h:inputText style="width:95%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.bienTravauxLigne.bietraligReferenceFacture}" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.var_action>=50}"/></h:column>
                        <h:column><h:outputText value="Total H.T.:"/></h:column>
                        <h:column>
                            <h:inputText style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.bienTravauxLigne.bietraligHt}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.var_action>=50}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQeue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.calculTtc}" reRender="idFacture"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value="Total TVA.:"/></h:column>
                        <h:column>
                            <h:inputText style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.bienTravauxLigne.bietraligTva}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.var_action>=50}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQeue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.calculTtc}" reRender="idFacture"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value="Total TTC:"/></h:column>
                        <h:column>
                            <h:inputText style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.bienTravauxLigne.bietraligTtc}" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value="Mode paiement"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.bienTravauxLigne.bietraligPaiement}" style="width:100%;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.var_action>=50}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.mesTypeReglements}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Date paiement"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.bienTravauxLigne.bietraligDatePaiement}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.var_action>=50}"/></h:column>
                    </h:panelGrid>
                    <br><br><br><br><br><br><br><br>
                </rich:tab>
                <rich:tab id="tabScan" label="Scan Facture">
                    <h:panelGrid style="width:100%;">
                        <h:panelGrid id="panPhoto" columns="2" style="height:150px" width="100%" styleClass="top">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.bienTravauxLigne.bietraligScanFacture==null}">
                                <t:inputFileUpload id="file" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.uploadedFile}" accept="image/*"/>
                                <h:commandButton  styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.ajoutPhoto}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.var_action>=50}">
                                    <a4j:support eventsQueue="maQueue" immediate="true" reRender="grp3"/>
                                </h:commandButton>
                                <h:message for="file" infoStyle="color: green;" errorStyle="color: red;" />
                            </h:panelGroup>
                            <br/>
                            <h:panelGroup  id="grp3" style="tex-align:center">
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.bienTravauxLigne.bietraligScanFacture!=null}">
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.typeFichier==0}" var="sc1">
                                        <img alt="" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.urlphotoProd}" width="100%" height="800px"/>
                                    </c:if>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.typeFichier==1}" var="sc2">
                                        <object data="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.fichierUrl}" type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.fichierMine}" width="100%" height="550">
                                            <a href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.fichierUrl}"></a>
                                        </object>
                                    </c:if>
                                    <h:commandButton image="/images/supprimer.png" title="supprimer scan" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cette photo ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.reInitPhoto}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.var_action<50}"/>
                                </c:if>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.bienTravauxLigne.bietraligScanFacture==null}">
                                    <img alt="" src="images/no_image.jpeg" width="300px" height="300px" />
                                </c:if>
                            </h:panelGroup>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>
            </rich:tabPanel>
        </h:panelGrid>
        <br/>  <br/>
        <center>
            <h:panelGroup id="valideFacture">
                <br><br>
                <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.fermerFactureDirecte}" />&nbsp;&nbsp;
                <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.validerFactureDirecte}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.bien.bieId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.var_action<50}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            </h:panelGroup>
        </center>

    </a4j:form>

</f:subview>
