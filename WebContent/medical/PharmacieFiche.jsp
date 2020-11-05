<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="fichepharmacie">

    <center>
        <a4j:form enctype="multipart/form-data">
            <rich:hotKey key="return" handler="return false;"/>

            <center> <h2><h:outputText value="GESTION DE LA PHARMACIE (Globale)" style="color:green;"/></h2></center>

            <rich:tabPanel switchType="client" immediate="true" style="border:0px;">

                <rich:tab id="tabdescrip" label="Pharmacie" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.autorisationDescription}">
                    <h:panelGrid id="idPanGlobal" width="100%">
                        <h:panelGrid id="idPanDescription" width="100%">
                            <h:panelGrid width="100%" styleClass="fichefournisseur">
                                <h:panelGrid  width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                    <h:column><h:outputText value="Date:"/></h:column>
                                    <h:column>
                                        <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_date}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateMed==0}">
                                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="prgtpAjt,outptcltAjt,link8Ajt,inptdatechce" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.controleSaisie}"/>
                                        </rich:calendar>&nbsp;
                                        <h:selectOneMenu id="idHeure" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_heure}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_aff_action}" style="width:45px">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}"/>
                                        </h:selectOneMenu>
                                        <h:column><h:outputText value=":"/></h:column>
                                        <h:selectOneMenu id="idMinute" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_minute}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_aff_action}" style="width:45px">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="N° Pharamcie:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaNum}" readonly="true"/></h:column>
                                    <h:column><h:outputText value="Dossier:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.patients.patDossier}" size="7" readonly="true"/>&nbsp;&nbsp;
                                        <h:outputText value="Série:" style="text-decoration:underline;"/>&nbsp;
                                        <h:selectOneMenu id="idSerie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaSerie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_aff_action}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesSerieUserItem}"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="grpCnt" width="100%" columns="4" columnClasses="clos12d,clos55g,clos12c,clos21g">
                                    <h:column><h:outputText value="Nom Patient:" style="text-decoration:underline;width:100%"/></h:column>
                                    <h:column>
                                        <h:inputText style="width:90%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaCivilite} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaNomPatient}" readonly="true"/>&nbsp;&nbsp;
                                        <h:column>
                                            <a4j:commandButton image="/images/detail.png" style="height:15px;width:15px" id="btndetailtiers" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.detailPatient}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_aff_detail_tiers}" reRender="modAttente,idSubView"></a4j:commandButton>
                                        </h:column>
                                    </h:column>
                                    <h:column>
                                        <h:graphicImage url="/images/femme.png" height="26px" width="26px" alt="F" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.patients.patSexe==0}"/>
                                        <h:graphicImage url="/images/homme.png" height="26px" width="26px" alt="M" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.patients.patSexe==1}"/>
                                    </h:column>
                                    <h:column>
                                        <h:outputText value="Né(e) le:" />&nbsp;
                                        <h:inputText size="6" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.patients.patDateNaissance}" readonly="true"/>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="grppec" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                    <h:column>
                                        <h:outputText value="Prise en charge:" style="text-decoration:underline;"/>&nbsp;
                                        <a4j:commandButton image="/images/actualiser.png" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.changerTarif}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_aff_action}" reRender="modAttente,idPanDescription,tableLigne,idTotalListe"></a4j:commandButton>
                                    </h:column>
                                    <h:column>
                                        <h:selectOneMenu id="idCat" style="width:85%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.nomFamille}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_aff_action}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.mesCategoriesItems}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.changerTarif}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,gridTotal,tableLigne,ligne,grppec,idCat2,idCat3,idTotalListe"/>
                                        </h:selectOneMenu>&nbsp;
                                        <a4j:commandButton image="/images/detail.png" title="Consultation du détail de la prise en charge sélectionnée" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.consulterTarif}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPec"></a4j:commandButton>
                                    </h:column>
                                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.optionMedical.cnamgs=='1'&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.nomFamille==0}"><h:outputText value="CNAMGS:" style="text-decoration:underline;"/></h:column>
                                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.optionMedical.cnamgs=='1'&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.nomFamille==0}">
                                        <h:selectOneMenu id="idPec" style="width:30%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_pecCnamgs}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_aff_action}">
                                            <f:selectItem itemLabel="Sans" itemValue="0"/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.lesTauxCnamgsItems}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.changerTarif}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idPanDescription,grpCnt,idCat,gridTotal,tableLigne,idFond,ligne,idTotalListe"/>
                                        </h:selectOneMenu>&nbsp;&nbsp;
                                        <h:selectOneMenu id="idFond" style="width:60%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaFondCnamgs}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_aff_action}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_pecCnamgs!=0}">
                                            <f:selectItem itemLabel="Fonds 1 + Pharmacie (SP)" itemValue="21"/>
                                            <f:selectItem itemLabel="Fonds 2 + Pharmacie (AP)" itemValue="22"/>
                                            <f:selectItem itemLabel="Fonds 3 + Pharmacie (GEF)" itemValue="23"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.nomFamille>=1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_pecCnamgs!=0}"><h:outputText id="idCat2" value="Complémentaire:" style="text-decoration:underline;"/></h:column>
                                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.nomFamille>=1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_pecCnamgs!=0}">
                                        <h:selectOneMenu id="idCat3" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.nomComplementaire}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_aff_action}">
                                            <f:selectItem itemLabel="Sans" itemValue="0"/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.mesComplementaireItems}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.changerTarif}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,gridTotal,tableLigne,ligne,idTotalListe"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                    <h:column><h:outputText value="Mèdecin:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu id="idMedecin" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_nom_medecin}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_aff_action}">
                                            <f:selectItem itemLabel="Sélection Médecin" itemValue="0"/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.mesMedecinsItem}" />
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.verifValidePharmacie}" reRender="prgtpAjt"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Prescripteur:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu id="idPrescripteur" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaPrescripteur}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_aff_action}">
                                            <f:selectItem itemLabel="Sans Prescripteur" itemValue=""/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesPrescripteurItems}" />
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Pharmacie:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu id="idPharmacie" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaPharmacie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_aff_action||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.verrouPharmacie}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.mesPharmaciesItems}" />
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.verifValidePharmacie}" reRender="prgtpAjt"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                    <h:column><h:outputText value="N° B.C.:"/></h:column>
                                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaNumBc}" style="width:100%" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_aff_action}"/></h:column>
                                    <h:column><h:outputText value="N° Feuille"/></h:column>
                                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaFeuille}" style="width:100%" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_aff_action}"/></h:column>
                                    <h:column><h:outputText value="N° Hospitalisation:"/></h:column>
                                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaNumHospit}" style="width:100%" readonly="true"/></h:column>
                                </h:panelGrid>
                            </h:panelGrid>
                        </h:panelGrid>

                        <h:panelGrid width="100%" id="idpanPharmacie">
                            <h:panelGrid id="btnActe" columns="3" width="150px" style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                                <a4j:commandButton image="/images/ajouter.png" title="Ajouter produit" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaEtat<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.ajouterActes}" reRender="idpanPharmacie,ligne,btnActe"/>
                                <a4j:commandButton image="/images/supprimer.png" title="Supprimer produit" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.afficheButtActes&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.supprimerActe}" reRender="tableLigne,btnActe,ligne,idTotalListe"/>
                                <a4j:commandButton image="/images/annuler_big.png" title="Avoir (Remboursement) produit" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.afficheButtActes&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaRegPatient==0||bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrMedicalAvoir==1)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.sup}" onclick="if (!confirm('Etes-vous sur de vouloir faire l`avoir (remboursement) de cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.avoirLigne}" reRender="tableLigne,btnActe,ligne,idTotalListe"/>
                            </h:panelGrid>
                            <h:panelGrid width="100%" id="ligne" style="border:1px solid green;background-color:#FFF8D4;" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.ajouterSurAvoir==false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_aff_action==false)||(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.ajouterSurAvoir==true)}">
                                <h:panelGrid columns="19" width="100%" id="ligne1">
                                    <h:column><h:outputText value="Code" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:inputText tabindex="1" id="inpCodDet" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieLigne.phaligProduit}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.griserchamps}" style="width:150px">
                                            <rich:toolTip id="tooladdPrd" followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les actes" style="background-color:#FFF8D4;"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.rechercheActes}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeProduits,formModalListeProduits,ligne,inpCodDet"/>
                                        </h:inputText>&nbsp;&nbsp;
                                        <a4j:commandButton tabindex="2" image="/images/detail.png" style="height:15px;width:15px" id="btndetailprod" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.detailActe}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_aff_detail_prod}" reRender="formModalDetailProduit,panelDetailProduit,inpCodDet,ligne1"></a4j:commandButton>
                                    </h:column>
                                    <h:column><h:outputText value="Libellé"/></h:column>
                                    <h:column><h:inputText tabindex="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieLigne.phaligLibelle}" readonly="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.griserchamps}" style="width:100%"/></h:column>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.produits.proStock>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_sansstock}">
                                        <h:outputText value="Stock"/>
                                        <h:selectOneMenu id="idDepot" tabindex="4" style="width:100px;color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_depotProd}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.mesProduitsDepotsItems}"/>
                                        </h:selectOneMenu>
                                    </h:panelGroup>
                                    <h:panelGroup id="panelUnite" >
                                        <h:outputText value="Unité"/>
                                        <h:selectOneMenu rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_aff_unite}" tabindex="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieLigne.phaligUnite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.griserchamps}" style="width:80px;">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.mesUnitesProduits}"/>
                                        </h:selectOneMenu>
                                        <h:inputText rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_aff_unite}" tabindex="6" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieLigne.phaligUnite}" style="width:80px;"/>
                                    </h:panelGroup>
                                    <h:panelGroup id="panelCdt" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_aff_condit}">
                                        <h:outputText value="Cdt."/>
                                        <h:selectOneMenu tabindex="7" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieLigne.phaligCondition}" style="width:100px;">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.mesConditionnementsProduits}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.selectionConditionnement}" reRender="panelLigne,panelLigne2,panelPu,panelPt,panelLigne3"/>
                                        </h:selectOneMenu>
                                    </h:panelGroup>
                                    <h:panelGroup id="pu">
                                        <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieLigne.phaligPu}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.verrouPrvente}" style="width:100px;text-align:right;" onkeypress="return scanToucheChiffre(event)">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_pecCnamgs!=0}"><h:outputText value="P.U.CNAMGS"/></h:column>
                                    <h:panelGroup id="puCnamgs" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_pecCnamgs!=0}">
                                        <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieLigne.phaligPuCnamgs}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.verrouPrventeCnamgs}" style="width:100px;text-align:right;" onkeypress="return scanToucheChiffre(event)">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_pecAssurance}"><h:outputText value="P.U.Assur."/></h:column>
                                    <h:panelGroup id="puAssurance" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_pecAssurance}">
                                        <h:inputText tabindex="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieLigne.phaligPuAssurance}" style="width:100px;text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.verrouPrventeAssurance}" onkeypress="return scanToucheChiffre(event)">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrVerRemise==0}"><h:outputText value="Rem."/></h:column>
                                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrVerRemise==0}">
                                        <h:inputText tabindex="11" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieLigne.phaligRemise}" style="width:50px;text-align:right;" onkeypress="return scanToucheChiffre(event)">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrVerRabais==0}"><h:outputText value="Rab."/></h:column>
                                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrVerRabais==0}">
                                        <h:inputText tabindex="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieLigne.phaligRemise}" style="width:50px;text-align:right;" onkeypress="return scanToucheChiffre(event)">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Qte"/></h:column>
                                    <h:column><h:inputText tabindex="13" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieLigne.phaligQte}" style="width:80px;text-align:right;" onkeypress="return scanToucheChiffre(event)"/></h:column>
                                    <h:column>
                                        <a4j:commandButton  tabindex="14" image="/images/valider_big.png" id="idValLigne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.saveActe}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_aff_detail_prod}" reRender="btnActe,ligne,tableLigne,ligne1,idTotalListe"/>
                                    </h:column>
                                </h:panelGrid>
                            </h:panelGrid>
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable border="0" headerClass="headerTab" id="tableLigne" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" height="300px" width="100%" style="border:solid 1px green"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.dataModelPharmacie}" var="pha" >
                                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.selectionActeListe}" reRender="btnActe,ligne"/>
                                    <rich:column sortable="false" width="8%">
                                        <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                        <h:outputText  value="#{pha.phaligProduit}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="22%">
                                        <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                        <h:inputTextarea rows="1" value="#{pha.phaligLibelle}" readonly="true" style="width:95%"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="5%" >
                                        <f:facet name="header"><h:outputText  value="Dépot"/></f:facet>
                                        <h:outputText value="#{pha.phaligDepot}"/>
                                    </rich:column>
                                    <rich:column sortable="false" style="text-align:right" width="5%" >
                                        <f:facet name="header"><h:outputText  value="Qté"/></f:facet>
                                        <h:outputText value="#{pha.phaligQte}" />
                                    </rich:column>
                                    <rich:column sortable="false" style="text-align:right;" width="10%">
                                        <f:facet name="header"><h:outputText value="P.U.ST"/></f:facet>
                                        <h:outputText value="#{pha.phaligPuRem}" rendered="#{pha.phaligPuRem!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column sortable="false" style="text-align:right;" width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_pecCnamgs!=0}">
                                        <f:facet name="header"><h:outputText value="P.U.CNAMGS"/></f:facet>
                                        <h:outputText value="#{pha.phaligPuCnamgs}" rendered="#{pha.phaligPuCnamgs!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column sortable="false" style="text-align:right;" width="5%">
                                        <f:facet name="header"><h:outputText  value="R/R"/></f:facet>
                                        <h:outputText value="#{pha.phaligRemise}" rendered="#{pha.phaligRemise!=0}" />
                                        <h:outputText value="#{pha.phaligRabais}" rendered="#{pha.phaligRabais!=0}" />
                                    </rich:column>
                                    <rich:column sortable="false" style="text-align:right;" width="10%">
                                        <f:facet name="header"><h:outputText value="Patient"/></f:facet>
                                        <h:outputText value="#{pha.phaligPatientHt}" rendered="#{pha.phaligPatientHt!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column sortable="false" style="text-align:right;" width="10%">
                                        <f:facet name="header"><h:outputText value="Tiers"/></f:facet>
                                        <h:outputText value="#{pha.totalTiers}" rendered="#{pha.totalTiers!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                </rich:extendedDataTable>
                                <h:panelGrid width="100%" id="idTotalListe" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                                    <h:column><h:outputText value="Total Facture:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.totalDocFacture}" style="text-align:right" readonly="true" disabled="true">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Total Tiers:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.totalDocTiers}" style="text-align:right" readonly="true" disabled="true">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Total Patient:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.totalDocPatient}" style="text-align:right" readonly="true" disabled="true">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Total Réglement:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.totalDocReglement}" style="text-align:right" readonly="true" disabled="true">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                            </a4j:region>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Imputation" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_acc_acte}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.autorisationActes}">
                    <jsp:include flush="true" page="/medical/PharmacieCommun.jsp" />
                    <h:panelGrid styleClass="fichefournisseur1" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                        <h:column><h:outputText value="Type pathologie:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idPathologie" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaPathologie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_aff_action}">
                                <f:selectItem itemLabel="Sélection Pathologie" itemValue="100"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesPathologieItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Protocole:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idProtocole" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaProtocole}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_aff_action}">
                                <f:selectItem itemLabel="Sélection Protocole" itemValue="100"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.mesProtocoleItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Service demandeur:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idService" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaService}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_aff_action}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesServicesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="N° B.C.:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaNumBc}" style="width:100%" maxlength="20"/></h:column>
                        <h:column><h:outputText value="Secteur Agent"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaNumSecteur}" style="width:100%" maxlength="20"/></h:column>
                        <h:column><h:outputText value="N° Hospitalisation:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaNumHospit}" style="width:100%" readonly="true"/></h:column>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid styleClass="fichefournisseur" id="gridTotal"  width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                        <h:column><h:outputText value="Total Patient:"/></h:column>
                        <h:column>
                            <h:inputText id="totht" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaTotPatient}" style="text-align:right;width:100%"  readonly="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Total Tiers:"/></h:column>
                        <h:column>
                            <h:inputText id="totttc" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_tot_tiers}" style="text-align:right;width:100%" readonly="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Total Général:"/></h:column>
                        <h:column>
                            <h:inputText id="totrem" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaTotGeneral}" style="text-align:right;width:100%"  readonly="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Reg. Patient:"/></h:column>
                        <h:column>
                            <h:inputText id="tottx" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaRegPatient}" style="text-align:right;width:100%"  readonly="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Reg. tiers:"/></h:column>
                        <h:column>
                            <h:inputText id="tottc" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaRegTiers}" style="text-align:right;width:100%"  readonly="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Solde:"/></h:column>
                        <h:column>
                            <h:inputText id="totreg" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_solde}" style="text-align:right;width:100%"  readonly="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Antécédents" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_acc_antecedent&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaNomPatient!='DIVERS'}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.autorisationAntecedent}">
                    <jsp:include flush="true" page="/medical/PharmacieCommun.jsp" />
                    <h:panelGrid width="100%">
                        <h:panelGrid id="btnAntecedent" columns="4" width="150px" style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                            <a4j:commandButton image="/images/ajouter.png" title="Ajouter antécédent"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.ajouterAntecedent}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaEtat<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.add}" reRender="panelAntecedent,btnAntecedent"/>
                            <a4j:commandButton image="/images/modifier.png" title="Modifier antécédent" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.afficheButtAntecedent&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaEtat<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.modifierAntecedent}" reRender="panelAntecedent,btnAntecedent"/>
                            <a4j:commandButton image="/images/detail.png" title="Consulter antécédent"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.afficheButtAntecedent}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.consulterAntecedent}" reRender="panelAntecedent,btnAntecedent"/>
                            <a4j:commandButton image="/images/supprimer.png" title="Supprimer antécédent" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.afficheButtAntecedent&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaEtat<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.sup}" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.supprimerAntecedent}" reRender="tableAntecedent,btnAntecedent"/>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="tableAntecedent" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" height="300px" width="100%" style="border:solid 1px green" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.dataModelAntecedent}" var="antec" >
                                <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.selectionAntecedent}" reRender="btnAntecedent"/>
                                <rich:column  width="10%" sortable="true" sortBy="#{antec.patantCode}" >
                                    <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                    <h:outputText value="#{antec.patantCode}"/>
                                </rich:column>
                                <rich:column  width="30%" sortable="true" sortBy="#{antec.patantFamille}" >
                                    <f:facet name="header"><h:outputText  value="Famille"/></f:facet>
                                    <h:outputText value="#{antec.patantFamille}"/>
                                </rich:column>
                                <rich:column  width="10%" sortable="true" sortBy="#{antec.patantDate}" >
                                    <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                    <h:outputText value="#{antec.patantDate}"/>
                                </rich:column>
                                <rich:column width="5%" sortable="true" sortBy="#{antec.patantEtat}">
                                    <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                                    <h:outputText  value="#{antec.patantEtat}"/>
                                </rich:column>
                                <rich:column width="45%" sortable="true" sortBy="#{antec.patantObservation}">
                                    <f:facet name="header"><h:outputText  value="Observations"/></f:facet>
                                    <h:outputText  value="#{antec.patantObservation}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Règlement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_acc_reglement}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.autorisationReglement}">
                    <jsp:include flush="true" page="/medical/PharmacieCommun.jsp" />
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="lignerecu" height="200px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.datamodelRecu}"  var="recu"  sortMode="multi">
                            <jsp:include flush="true" page="/commun/listeReglementDocument.jsp"/>
                        </rich:extendedDataTable>
                    </a4j:region>

                </rich:tab>

                <rich:tab label="Etat" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_acc_etat}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.autorisationEtat}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.calculeEtat}" reRender="idPanEtat"/>
                    <jsp:include flush="true" page="/medical/PharmacieCommun.jsp" />
                    <h:panelGrid width="100%" id="idPanEtat">
                        <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="ID PHARMACIE"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaId}" size="20" readonly="true"/></h:column>
                            <h:column><h:outputText value="Créateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaNomCreateur}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="ID créateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaIdCreateur}" size="20" readonly="true"/></h:column>
                            <h:column><h:outputText value="Date de création:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaDateCreat}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Modificateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaNomModif}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="ID modificateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaIdModif}" size="20" readonly="true"/></h:column>
                            <h:column><h:outputText value="Date de modification:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaDateModif}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Date d'impression:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaDateImp}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Date transfert en comptabilité:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaDateTransfert}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Etat:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaEtat}" disabled="true">
                                    <f:selectItem itemLabel="En cours" itemValue="0"/>
                                    <f:selectItem itemLabel="Validé" itemValue="1"/>
                                    <f:selectItem itemLabel="Gelé" itemValue="2"/>
                                    <f:selectItem itemLabel="Annulé" itemValue="3"/>
                                    <f:selectItem itemLabel="Cloturé" itemValue="4"/>
                                    <f:selectItem itemLabel="Controlée" itemValue="5"/>
                                    <f:selectItem itemLabel="Refacturée Ass./Soc." itemValue="6"/>
                                    <f:selectItem itemLabel="Refacturée Compl." itemValue="7"/>
                                </h:selectOneMenu>&nbsp;&nbsp;&nbsp;
                                <a4j:commandButton value="Réactiver le document" style="color:red"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaEtat==3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" onclick="if (!confirm('Etes-vous sur de vouloir réactiver ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.reactiverDocument}" reRender="idPanEtat"/>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Etat validation:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaEtatVal}" disabled="true">
                                    <f:selectItem itemLabel="Sans méthode de validation" itemValue="0"/>
                                    <f:selectItem itemLabel="Avec méthode de validation" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date d'annulation:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaDateAnnule}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Motif d'annulation:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaMotifAnnule}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="Date refacturation:"/></h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.dateRefacturation}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                            <h:column><h:outputText value="Numéro refacturation:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.numRefacturation}" size="20" readonly="true"/></h:column>
                            <h:column><h:outputText value="Etat refacturation:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.etatRefacuration}" size="20" readonly="true"/></h:column>
                            <h:column><h:outputText value="Bloque la refacturation:"/></h:column>
                            <h:column>
                                <a4j:commandButton value="Refacturation autorisée" style="color:blue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.bloqueFacturation}" reRender="idPanEtat" disabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.autoriseRefacturation}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaBloqueRefacturation}"/>
                                <a4j:commandButton value="Refacturation bloquée" style="color:red" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.deBloqueFacturation}" reRender="idPanEtat" disabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.autoriseRefacturation}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.pharmacieEntete.phaBloqueRefacturation}"/>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Traçabilité" id="tabTrace" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.visibleOnglet}">
                    <jsp:include flush="true" page="/medical/ConsultationGeneCommun.jsp" />
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.chargerDocumentTrace}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panTrace"/>
                    <h:panelGrid id="panTrace" width="100%">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable height="300px" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;width:100%;height:150px;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.datamodelDocumentTrace}"  var="var"  sortMode="multi">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.selectionTracabilite}"/>
                                <rich:column label="N° Facture" sortable="true" sortBy="#{var.factureEnteteMedical.facNum}" >
                                    <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                                    <h:outputText value="#{var.factureEnteteMedical.facNum}"/>
                                </rich:column>
                                <rich:column label="Date" sortable="true" sortBy="#{var.factureEnteteMedical.facDate}" width="70px" sortOrder="ASCENDING">
                                    <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                    <h:outputText value="#{var.factureEnteteMedical.facDate}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Date début période" sortable="true" sortBy="#{var.factureEnteteMedical.facDateDebut}" width="70px">
                                    <f:facet name="header"><h:outputText  value="Début" /></f:facet>
                                    <h:outputText value="#{var.factureEnteteMedical.facDateDebut}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Date fin période" sortable="true" sortBy="#{var.factureEnteteMedical.facDateFin}" width="70px">
                                    <f:facet name="header"><h:outputText  value="Fin" /></f:facet>
                                    <h:outputText value="#{var.factureEnteteMedical.facDateFin}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Série" sortable="true" sortBy="#{var.factureEnteteMedical.facSerie}" style="text-align:center;" width="40px">
                                    <f:facet name="header"><h:outputText  value="S." /></f:facet>
                                    <h:outputText value="#{var.factureEnteteMedical.facSerie}"/>
                                </rich:column>
                                <rich:column label="Famille tarification" sortable="true" sortBy="#{var.factureEnteteMedical.facCat}" width="70px" style="text-align:center;">
                                    <f:facet name="header"><h:outputText  value="Tar." /></f:facet>
                                    <h:outputText value="#{var.factureEnteteMedical.facCat}"/>
                                </rich:column>
                                <rich:column label="Etat" sortable="true" sortBy="#{var.factureEnteteMedical.facEtat}" width="50px" style="text-align:center;">
                                    <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                                    <h:outputText value="#{var.factureEnteteMedical.libelleEta}"/>
                                </rich:column>
                                <rich:column label="Tiers" sortable="true" sortBy="#{var.factureEnteteMedical.facNomTiers}" width="200px">
                                    <f:facet name="header"><h:outputText  value="tiers"  /></f:facet>
                                    <h:outputText  value="#{var.factureEnteteMedical.facNomTiers}" />
                                </rich:column>
                                <rich:column label="Adhérent" sortable="true" sortBy="#{var.factureEnteteMedical.facNomAdherent}" width="200px">
                                    <f:facet name="header"><h:outputText  value="Adhérent/localisation"  /></f:facet>
                                    <h:outputText  value="#{var.factureEnteteMedical.facNomAdherent}" rendered="#{var.factureEnteteMedical.facIdAdherent!=0}"/>
                                    <h:outputText  value="#{var.factureEnteteMedical.facSecteurAgent}" rendered="#{var.factureEnteteMedical.facSecteurAgent!=null}"/>
                                </rich:column>
                                <rich:column label="Total T.T.C." sortable="true" sortBy="#{var.factureEnteteMedical.facTotTtc}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="T.T.C."/></f:facet>
                                    <h:outputText  value="#{var.factureEnteteMedical.facTotTtc}" rendered="#{var.factureEnteteMedical.facTotTtc!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>

            </rich:tabPanel>

            <h:panelGroup id="prgtpAjt">
                <center>
                    <h:commandButton image="/images/annuler_big.png" id="linkanuAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.annuleSaisie}"  />&nbsp;&nbsp;
                    <h:commandButton image="/images/valider_big.png" id="link8Ajt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.save}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_aff_action&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.validePharmacie}" onclick="javascript:Richfaces.showModalPanel('modAttente');" />
                </center>              
            </h:panelGroup>

        </a4j:form>
    </center>


    <rich:modalPanel domElementAttachment="parent"  id="panelDetailProduit" headerClass="headerPanel" width="800" height="500" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.showModalPanelDetailProduits}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.showModalPanelDetailProduits}" var="detprd">
            <f:facet name="header"><h:outputText value="INFORMATIONS SUR LE PRODUIT"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.fermerDetailActe}" image="/images/close.gif" styleClass="hidelink" reRender="panelDetailProduit"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  width="100%" id="formModalDetailProduit">
                    <rich:hotKey key="return" handler="return false;"/>
                    <h:panelGrid style="background-color:#DAEECB;" width="100%">
                        <h:panelGrid style="background-color:#DAEECB;" width="100%">
                            <h:panelGrid columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%">
                                <h:column><h:outputText value="Code:"/></h:column>
                                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.produits.proCode}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Libellé:"/></h:column>
                                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.produits.proLibClient}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Famille:"/></h:column>
                                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.produits.proVteCode}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Nature:"/></h:column>
                                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.produits.proVteNat} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.produits.proVteLib}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Descriptif:"/></h:column>
                                <h:column><h:inputTextarea style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.produits.proDescrip}" rows="3" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                    </h:panelGrid>

                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelAntecedent" headerClass="headerPanel" width="600" height="450" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.showModalPanelAntecedent}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.showModalPanelAntecedent}" var="ant">
            <f:facet name="header"><h:outputText value="GESTION DES ANTECEDENTS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.fermerAntecedent}" image="/images/close.gif" styleClass="hidelink" reRender="panelAntecedent"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  width="100%">
                    <h:panelGrid columns="2" width="100%" columnClasses="clos20,clos80">
                        <h:column><h:outputText value="Type antécédents:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="anteItem" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_antecedent}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.patientAnt.patantId!=0}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesAntecedentItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" width="100%" columnClasses="clos20,clos80">
                        <h:column><h:outputText value="Date évènement:"/></h:column>
                        <h:column>
                            <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.patientAnt.patantDate}" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  style="background-color:white"  inputSize="8"></rich:calendar>
                        </h:column>
                        <h:column><h:outputText value="Etat:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.patientAnt.patantEtat}">
                                <f:selectItem itemLabel="En cours" itemValue="En cours"/>
                                <f:selectItem itemLabel="Résolu" itemValue="Résolu"/>
                                <f:selectItem itemLabel="Non Résolu" itemValue="Non résolu"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Description:"/></h:column>
                        <h:column><h:inputTextarea style="width:100%" rows="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.patientAnt.patantObservation}"/></h:column>
                        <h:column><h:outputText value="Médecin:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.patientAnt.patantMedecin}"/></h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br/>
                <h:panelGroup id="valAntecedent">
                    <center>
                        <a4j:commandButton id="idValAnt" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.saveAntecedent}" reRender="panelAntecedent,btnAntecedent,tableAntecedent"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelListeProduits" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.showModalPanelProduits}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.showModalPanelProduits}" var="prd">
            <f:facet name="header"><h:outputText value="Sélection du produit"/></f:facet>
            <a4j:form id="formModalListeProduits">
                <rich:hotKey key="return" handler="return false;"/>
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable2" maxPages="20"align="left" for="tableProd"/>
                    <rich:extendedDataTable rows="200" id="tableProd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.datamodelProduits}"  var="prd" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.simpleSelectionProduits}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.extDTableProduits}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.selectionActes}" reRender="valprd3"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.valideActes}" reRender="panelListeProduits,inpCodDet,ligne1"/>
                        <rich:column label="Famille" sortable="true" sortBy="#{prd.proVteLib}" width="20%">
                            <f:facet name="header"><h:outputText  value="Famille" /></f:facet>
                            <h:outputText value="#{prd.proVteLib}"/>
                        </rich:column>
                        <rich:column label="Code" sortable="true" sortBy="#{prd.proCode}" width="10%">
                            <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                            <h:outputText value="#{prd.proCode}"/>
                        </rich:column>
                        <rich:column label="Libellé produit" sortable="true" sortBy="#{prd.proLibClient}" width="70%">
                            <f:facet name="header"><h:outputText  value="Libellé produit" /></f:facet>
                            <h:inputTextarea value="#{prd.proLibClient}" readonly="true" rows="2" style="width:100%"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
                <br>
                <h:panelGroup id="valprd3">
                    <center>
                        <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.annuleActes}" reRender="panelListeProduits,inpCodDet,ligne1"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.valideActes}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.produits.proId!=0}" reRender="panelListeProduits,inpCodDet,ligne1"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelPec" headerClass="headerPanel" width="950" height="400" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.showModalpanelPec}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.showModalpanelPec}" var="ppec">
            <f:facet name="header"><h:outputText value="DETAIL DE LA PRISE EN CHARGE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton image="/images/close.gif" id="hidelinkPec" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.fermerConsulterTarif}" reRender="panelPec"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  columns="1" style="width:100%;" id="idPanelGlobal">
                    <h:panelGrid columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%" styleClass="fichefournisseur" id="idPanelPec">
                        <h:column><h:outputText value="Choix Tiers" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.patientPec.patpecType}" disabled="true">
                                <f:selectItem itemLabel="Assurance" itemValue="Assurance"/>
                                <f:selectItem itemLabel="IPM" itemValue="IPM"/>
                                <f:selectItem itemLabel="Mutuelle/Assurance" itemValue="Mutuelle/Assurance"/>
                                <f:selectItem itemLabel="Mutuelle" itemValue="Mutuelle"/>
                                <f:selectItem itemLabel="Complémentaire" itemValue="Complémentaire"/>
                                <f:selectItem itemLabel="Programme Médical" itemValue="Programme Médical"/>
                                <f:selectItem itemLabel="Client Société" itemValue="Client Société"/>
                                <f:selectItem itemLabel="Ministère" itemValue="Ministère"/>
                                <f:selectItem itemLabel="Direction" itemValue="Direction"/>
                                <f:selectItem itemLabel="Mairie" itemValue="Mairie"/>
                                <f:selectItem itemLabel="Hôpital" itemValue="Hôpital"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Tiers payeur" style="text-decoration:underline;"/></h:column>
                        <h:column><h:inputText style="width:95%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.patientPec.tiers.tieraisonsocialenom}" disabled="true"/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value="Employeur:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.patientPec.patpecType=='Assurance'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.patientPec.patpecType=='IPM'}"/></h:column>
                        <h:column><h:inputText id="idAdherent" style="width:95%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.patientPec.patpecNomEmployeur}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.patientPec.patpecType=='Assurance'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.patientPec.patpecType=='IPM'}" disabled="true"/></h:column>
                        <h:column rendered="false"><h:outputText value="Agent à refacturer:"/></h:column>
                        <h:column rendered="false"><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.patientPec.patpecAgentRefact}"/></h:column>
                        <h:column><h:outputText value="N° contrat:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.patientPec.patpecNumContrat}" disabled="true"/></h:column>
                        <h:column><h:outputText value="N° Immat. Assuré"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.patientPec.patpecMatricule}" disabled="true"/></h:column>
                        <h:column><h:outputText value="Date début"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.patientPec.patpecDateDebut}" popup="true"  inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style="background-color:white;" disabled="true"/></h:column>
                        <h:column><h:outputText value="Date fin"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.patientPec.patpecDateFin}" popup="true"  inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style="background-color:white;" disabled="true"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid width="100%" styleClass="fichefournisseur1" columns="3" columnClasses="clos40c,clos30,clos30" border="0">
                        <h:column><h:outputText value="L I B E L L E " style="text-align:center"/></h:column>
                        <h:column><h:outputText value="E X T E R N E " style="text-align:center"/></h:column>
                        <h:column><h:outputText value="H O S P I T A L I S A T I O N " style="text-align:center"/></h:column>
                        <h:column><h:outputText value="1 - Frais d'hospitalisation hébergement:"/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column>
                            <h:inputText size="8" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.patientPec.patpecHebergementPlaf}" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>&nbsp;&nbsp;
                            <h:outputText value="(plafond #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.structureLog.strdevise})"/>
                            <br>
                            <h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.patientPec.patpecHebergementRep}" disabled="true"/>%
                        </h:column>
                        <h:column><h:outputText value="2- Actes et examens (%):"/></h:column>
                        <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.patientPec.patpecSoins}" disabled="true"/>%</h:column>
                        <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.patientPec.patpecSoinsHospit}" disabled="true"/>%</h:column>
                        <h:column><h:outputText value="3 - Fourniture pharmacie (%):"/></h:column>
                        <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.patientPec.patpecMedicament}" disabled="true"/>%</h:column>
                        <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.patientPec.patpecMedicamentHospit}" disabled="true"/>%</h:column>
                        <h:column><h:outputText value="4 - Laboratoire et examens complémentaires (%):"/></h:column>
                        <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.patientPec.patpecExamenss}" disabled="true"/>%</h:column>
                        <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.patientPec.patpecExamenssHospit}" disabled="true"/>%</h:column>
                        <h:column><h:outputText value="5 - Autres préstations de soins fournies (%):"/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.patientPec.patpecPrestations}" disabled="true"/>%</h:column>
                        <h:column><h:outputText value="6 - Autres préstations d'hotelière fournies (%):"/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.patientPec.patpacHotelerie}" disabled="true"/>%</h:column>
                        <h:column><h:outputText value="Forfait global:"/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column>
                            <h:inputText size="8" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.patientPec.patpecForfait}" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>&nbsp;&nbsp;
                            <h:outputText value="(#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.structureLog.strdevise})"/>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
