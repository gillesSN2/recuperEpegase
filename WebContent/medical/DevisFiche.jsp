<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="fichedevis">

    <center>
        <a4j:form enctype="multipart/form-data">
            <rich:hotKey key="return" handler="return false;"/>

            <center> <h2><h:outputText value="GESTION DES DEVIS" style="color:green;"/></h2></center>

            <rich:tabPanel switchType="client" immediate="true" style="border:0px;">

                <rich:tab id="tabdescrip" label="Descriptif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.autorisationDescription}">
                    <h:panelGrid id="idPanDescription" width="100%">
                        <h:panelGrid width="100%" styleClass="fichefournisseur">
                            <h:panelGrid  width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:column>
                                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_date}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateMed==0}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="prgtpAjt,outptcltAjt,link8Ajt,inptdatechce" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.controleSaisie}"/>
                                    </rich:calendar>&nbsp;
                                    <h:selectOneMenu id="idHeure" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_heure}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_aff_action}" style="width:45px">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}"/>
                                    </h:selectOneMenu>
                                    <h:column><h:outputText value=":"/></h:column>
                                    <h:selectOneMenu id="idMinute" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_minute}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_aff_action}" style="width:45px">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="N° Devis:"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisEnteteMedical.dvsNum}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Dossier:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.patients.patDossier}" size="7" readonly="true"/>&nbsp;&nbsp;
                                    <h:outputText value="Série:" style="text-decoration:underline;"/>&nbsp;
                                    <h:selectOneMenu id="idSerie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisEnteteMedical.dvsSerie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_aff_action}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesSerieUserItem}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.calculMedecinActe}" reRender="prgtpAjt,idMedecin"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid id="grpCnt" width="100%" columns="4" columnClasses="clos12d,clos55g,clos12c,clos21g">
                                <h:column><h:outputText value="Nom Patient:" style="text-decoration:underline;width:100%"/></h:column>
                                <h:column>
                                    <h:inputText style="width:90%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisEnteteMedical.dvsCivilite} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisEnteteMedical.dvsNomPatient}" readonly="true"/>&nbsp;&nbsp;
                                    <h:column>
                                        <a4j:commandButton image="/images/detail.png" style="height:15px;width:15px" id="btndetailtiers" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.detailPatient}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_aff_detail_tiers}" reRender="formModalDetailPatient,panelDetailPatient"></a4j:commandButton>
                                    </h:column>
                                </h:column>
                                <h:column>
                                    <h:graphicImage url="/images/femme.png" height="26px" width="26px" alt="F" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.patients.patSexe==0}"/>
                                    <h:graphicImage url="/images/homme.png" height="26px" width="26px" alt="M" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.patients.patSexe==1}"/>
                                </h:column>
                                <h:column>
                                    <h:outputText value="Né(e) le:" />&nbsp;
                                    <h:inputText size="6" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.patients.patDateNaissance}" readonly="true"/>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid id="grppec" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                <h:column>
                                    <h:outputText value="Prise en charge:" style="text-decoration:underline;"/>&nbsp;
                                    <a4j:commandButton image="/images/actualiser.png" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.changerTarif}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_aff_action}" reRender="modAttente,idPanDescription,tableLigne,idTotalListe"></a4j:commandButton>
                                </h:column>
                                <h:column>
                                    <h:selectOneMenu id="idCat" style="width:85%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.nomFamille}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_aff_action}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.mesCategoriesItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.changerTarif}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,gridTotal,tableLigne,ligne,grppec,idCat2,idCat3,idTotalListe,gridTotal"/>
                                    </h:selectOneMenu>&nbsp;
                                    <a4j:commandButton image="/images/detail.png" title="Consultation du détail de la prise en charge sélectionnée" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.consulterTarif}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPec"></a4j:commandButton>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.optionMedical.cnamgs=='1'&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.nomFamille==0}"><h:outputText value="CNAMGS:" style="text-decoration:underline;"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.optionMedical.cnamgs=='1'&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.nomFamille==0}">
                                    <h:selectOneMenu id="idPec" style="width:30%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_pecCnamgs}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_aff_action}}">
                                        <f:selectItem itemLabel="Sans" itemValue="0"/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.lesTauxCnamgsItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.changerTarif}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idPanDescription,grpCnt,idCat,gridTotal,tableLigne,idFond,ligne,idTotalListe,gridTotal"/>
                                    </h:selectOneMenu>&nbsp;&nbsp;
                                    <h:selectOneMenu id="idFond" style="width:60%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisEnteteMedical.dvsFondCnamgs}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_aff_action}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_pecCnamgs!=0}">
                                        <f:selectItem itemLabel="Fonds 1 + Examens (SP)" itemValue="11"/>
                                        <f:selectItem itemLabel="Fonds 2 + Examens (AP)" itemValue="12"/>
                                        <f:selectItem itemLabel="Fonds 3 + Examens (GEF)" itemValue="13"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.nomFamille>=1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_pecCnamgs!=0}"><h:outputText id="idCat2" value="Complémentaire:" style="text-decoration:underline;"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.nomFamille>=1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_pecCnamgs!=0}">
                                    <h:selectOneMenu id="idCat3" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.nomComplementaire}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_aff_action}">
                                        <f:selectItem itemLabel="Sans" itemValue="0"/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.mesComplementaireItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.changerTarif}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,gridTotal,tableLigne,ligne,idTotalListe,gridTotal"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid width="100%" styleClass="fichefournisseur1">
                            <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                <h:column><h:outputText value="Motif entrée:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idMotif" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisEnteteMedical.dvsEntree}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_aff_action}">
                                        <f:selectItem itemLabel="Sélection Motif Entrée" itemValue="100"/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesMotifEntreeItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_affiche_pathologie}"><h:outputText value="Type pathologie:" style="text-decoration:underline;"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_affiche_pathologie}">
                                    <h:selectOneMenu id="idPathologie" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisEnteteMedical.dvsPathologie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_aff_action}">
                                        <f:selectItem itemLabel="Sélection Pathologie" itemValue="100"/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesPathologieItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_affiche_protocole}"><h:outputText value="Protocole:" style="text-decoration:underline;"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_affiche_protocole}">
                                    <h:selectOneMenu id="idProtocole" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisEnteteMedical.dvsProtocole}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_aff_action}">
                                        <f:selectItem itemLabel="Sélection Protocole" itemValue="100"/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.mesProtocoleItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Service demandeur:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idService" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisEnteteMedical.dvsService}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_aff_action}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesServicesItems}" />
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.calculMedecinActe}" reRender="idMedecin"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Mèdecin:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idMedecin" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_nom_medecin}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_aff_action}">
                                        <f:selectItem itemLabel="Sélection Médecin" itemValue="0"/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.mesMedecinsItem}" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_affiche_prescipteur}"><h:outputText value="Prescripteur:" style="text-decoration:underline;"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_affiche_prescipteur}">
                                    <h:selectOneMenu id="idPrescripteur" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisEnteteMedical.dvsPrescripteur}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_aff_action}">
                                        <f:selectItem itemLabel="Sans Prescripteur" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesPrescripteurItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid styleClass="fichefournisseur" id="gridTotal"  width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                            <h:column><h:outputText value="Total Patient:"/></h:column>
                            <h:column>
                                <h:inputText id="totht" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisEnteteMedical.dvsTotPatient}" style="text-align:right;width:100%"  readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Total Tiers:"/></h:column>
                            <h:column>
                                <h:inputText id="totttc" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_tot_tiers}" style="text-align:right;width:100%" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Total Général:"/></h:column>
                            <h:column>
                                <h:inputText id="totrem" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisEnteteMedical.dvsTotGeneral}" style="text-align:right;width:100%"  readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Reg. Patient:"/></h:column>
                            <h:column>
                                <h:inputText id="tottx" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisEnteteMedical.dvsRegPatient}" style="text-align:right;width:100%"  readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Reg. tiers:"/></h:column>
                            <h:column>
                                <h:inputText id="tottc" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisEnteteMedical.dvsRegTiers}" style="text-align:right;width:100%"  readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Solde:"/></h:column>
                            <h:column>
                                <h:inputText id="totreg" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_solde}" style="text-align:right;width:100%"  readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Détail" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_acc_acte}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.autorisationActes}">
                    <jsp:include flush="true" page="/medical/DevisCommun.jsp" />
                    <h:panelGrid width="100%" id="idPanLigne">
                        <h:panelGrid id="btnActe" columns="4" width="200px" style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                            <a4j:commandButton image="/images/ajouter.png" title="Ajouter examen" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisEnteteMedical.dvsEtat<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.ajouterActes}" reRender="idPanLigne,ligne,btnActe"/>
                            <a4j:commandButton image="/images/supprimer.png" title="Supprimer examen" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.afficheButtActes&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisEnteteMedical.dvsEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.supprimerActe}" reRender="tableLigne,btnActe,ligne,idTotalListe,gridTotal"/>
                            <a4j:commandButton image="/images/annuler_big.png" title="Avoir (Remboursement) examen" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisEnteteMedical.dvsEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.afficheButtActes&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisEnteteMedical.dvsRegPatient==0||bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrMedicalAvoir==1)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.sup}" onclick="if (!confirm('Etes-vous sur de vouloir faire l`avoir (remboursement) de cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.avoirLigne}" reRender="tableLigne,btnActe,ligne,idTotalListe,gridTotal"/>
                            <a4j:commandButton title="Changer le service du document sélectionné" style="height:22px;width:22px" image="/images/permutter.jpeg" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.afficheButtActes&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisEnteteMedical.dvsEtat==1&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisEnteteMedical.dvsRegPatient==0||bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrMedicalAvoir==1)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" onclick="if (!confirm('Etes-vous sur de vouloir changer le service ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.changerServiceLaboratoire}" reRender="panelChangerServiceLaboratoire"/>
                        </h:panelGrid>
                        <h:panelGrid width="100%" id="ligne" style="border:1px solid green;background-color:#FFF8D4;" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_aff_action==false)}">
                            <h:panelGrid columns="22" width="100%" id="ligne1">
                                <h:column><h:outputText value="Code" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:inputText tabindex="1" id="inpCodDet" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisLigneMedical.dvsligProduit}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.griserchamps}" style="width:150px">
                                        <rich:toolTip id="tooladdPrd" followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les actes" style="background-color:#FFF8D4;"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.rechercheActes}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeProduits,formModalListeProduits,ligne,inpCodDet,idLaboratoireLigne"/>
                                    </h:inputText>&nbsp;&nbsp;
                                    <a4j:commandButton tabindex="2" image="/images/detail.png" style="height:15px;width:15px" id="btndetailprod" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.detailProduit}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_aff_detail_prod}" reRender="formModalDetailProduit,panelDetailProduit,inpCodDet,ligne1"></a4j:commandButton>
                                </h:column>
                                <h:column><h:outputText value="Libellé"/></h:column>
                                <h:column><h:inputText tabindex="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisLigneMedical.dvsligLibelle}" readonly="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.griserchamps}" style="width:100%"/></h:column>
                                <h:column><h:outputText value="Lettre" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisLigneMedical.dvsligNb!=0}"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idLettre" tabindex="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisLigneMedical.dvsligLettre}" disabled="true" style="width:100px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisLigneMedical.dvsligNb!=0}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesLettresItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="P.U.Stand."/></h:column>
                                <h:panelGroup id="puval" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisLigneMedical.dvsligNb!=0}">
                                    <h:inputText tabindex="6" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisLigneMedical.dvsligPu}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.verrouPrvente}" style="width:100px;text-align:right;" onkeypress="return scanToucheChiffre(event)">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup id="pu" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisLigneMedical.dvsligNb==0}">
                                    <h:inputText tabindex="7" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisLigneMedical.dvsligPu}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.verrouPrvente}" style="width:100px;text-align:right;" onkeypress="return scanToucheChiffre(event)">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_pecCnamgs!=0}"><h:outputText value="P.U.CNAMGS"/></h:column>
                                <h:panelGroup id="puvalCnamgs" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisLigneMedical.dvsligNbCnamgs!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_pecCnamgs!=0}">
                                    <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisLigneMedical.dvsligPuCnamgs}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.verrouPrventeCnamgs}" style="width:100px;text-align:right;" onkeypress="return scanToucheChiffre(event)">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup id="puCnamgs" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisLigneMedical.dvsligNbCnamgs==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_pecCnamgs!=0}">
                                    <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisLigneMedical.dvsligPuCnamgs}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.verrouPrventeCnamgs}" style="width:100px;text-align:right;" onkeypress="return scanToucheChiffre(event)">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_pecAssurance}"><h:outputText value="P.U.Assur."/></h:column>
                                <h:panelGroup id="puAssurance" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_pecAssurance}">
                                    <h:inputText tabindex="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisLigneMedical.dvsligPuAssurance}" style="width:100px;text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.verrouPrventeAssurance}" onkeypress="return scanToucheChiffre(event)">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrVerRemise==0}"><h:outputText value="Rem."/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrVerRemise==0}">
                                    <h:inputText tabindex="11" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisLigneMedical.dvsligRemise}" style="width:50px;text-align:right;" onkeypress="return scanToucheChiffre(event)">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrVerRabais==0}"><h:outputText value="Rab."/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrVerRabais==0}">
                                    <h:inputText tabindex="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisLigneMedical.dvsligRabais}" style="width:50px;text-align:right;" onkeypress="return scanToucheChiffre(event)">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Qte"/></h:column>
                                <h:column><h:inputText tabindex="13" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisLigneMedical.dvsligQte}" style="width:80px;text-align:right;" onkeypress="return scanToucheChiffre(event)"/></h:column>
                                <h:column>
                                    <a4j:commandButton  tabindex="14" image="/images/valider_big.png" id="idValLigne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.saveActe}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_aff_detail_prod}" reRender="btnActe,ligne,tableLigne,ligne1,idTotalListe,gridTotal"/>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable border="0" headerClass="headerTab" id="tableLigne" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" height="300px" width="100%" style="border:solid 1px green"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.dataModelLaboratoire}" var="acte" >
                                <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.selectionActeListe}" reRender="btnActe,ligne"/>
                                <rich:column sortable="false" width="8%">
                                    <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                    <h:outputText  value="#{acte.dvsligProduit}"/>
                                </rich:column>
                                <rich:column sortable="false" width="22%">
                                    <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                    <h:inputTextarea rows="1" value="#{acte.dvsligLibelle}" readonly="true" style="width:95%"/>
                                </rich:column>
                                <rich:column label="Code lettre" sortable="false" style="text-align:right" width="12%" >
                                    <f:facet name="header"><h:outputText  value="Lettre"/></f:facet>
                                    <h:outputText value="#{acte.dvsligLettre}: #{acte.dvsligNb} * #{acte.dvsligValeur} (#{acte.dvsligCoef})" rendered="#{acte.dvsligNb!=0}"/>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right" width="5%" >
                                    <f:facet name="header"><h:outputText  value="Qté"/></f:facet>
                                    <h:outputText value="#{acte.dvsligQte}" />
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="10%">
                                    <f:facet name="header"><h:outputText value="P.U.ST"/></f:facet>
                                    <h:outputText value="#{acte.dvsligPuRem}" rendered="#{acte.dvsligPuRem!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_pecCnamgs!=0}">
                                    <f:facet name="header"><h:outputText value="P.U.CNAMGS"/></f:facet>
                                    <h:outputText value="#{acte.dvsligPuCnamgs}" rendered="#{acte.dvsligPuCnamgs!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="5%">
                                    <f:facet name="header"><h:outputText  value="R/R"/></f:facet>
                                    <h:outputText value="#{acte.dvsligRemise}" rendered="#{acte.dvsligRemise!=0}" />
                                    <h:outputText value="#{acte.dvsligRabais}" rendered="#{acte.dvsligRabais!=0}" />
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="10%">
                                    <f:facet name="header"><h:outputText value="Patient"/></f:facet>
                                    <h:outputText value="#{acte.dvsligPatientHt}" rendered="#{acte.dvsligPatientHt!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="10%">
                                    <f:facet name="header"><h:outputText value="Tiers"/></f:facet>
                                    <h:outputText value="#{acte.totalTiers}" rendered="#{acte.totalTiers!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                            </rich:extendedDataTable>
                            <h:panelGrid width="100%" id="idTotalListe" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                                <h:column><h:outputText value="Total Facture:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.totalDocFacture}" style="text-align:right" readonly="true" disabled="true">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Total Tiers:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.totalDocTiers}" style="text-align:right" readonly="true" disabled="true">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Total Patient:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.totalDocPatient}" style="text-align:right" readonly="true" disabled="true">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                            </h:panelGrid>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>              

                <rich:tab label="Etat" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_acc_etat}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.autorisationEtat}">
                    <jsp:include flush="true" page="/medical/DevisCommun.jsp" />
                    <h:panelGrid width="100%" id="idPanEtat">
                        <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="ID DEVIS"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisEnteteMedical.dvsId}" size="20" readonly="true"/></h:column>
                            <h:column><h:outputText value="Créateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisEnteteMedical.dvsNomCreateur}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="ID créateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisEnteteMedical.dvsIdCreateur}" size="20" readonly="true"/></h:column>
                            <h:column><h:outputText value="Date de création:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisEnteteMedical.dvsDateCreat}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Modificateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisEnteteMedical.dvsNomModif}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="ID modificateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisEnteteMedical.dvsIdModif}" size="20" readonly="true"/></h:column>
                            <h:column><h:outputText value="Date de modification:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisEnteteMedical.dvsDateModif}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Date d'impression:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisEnteteMedical.dvsDateImp}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Etat:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisEnteteMedical.dvsEtat}" disabled="true">
                                    <f:selectItem itemLabel="En cours" itemValue="0"/>
                                    <f:selectItem itemLabel="Validé" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Etat validation:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisEnteteMedical.dvsEtatVal}" disabled="true">
                                    <f:selectItem itemLabel="Sans méthode de validation" itemValue="0"/>
                                    <f:selectItem itemLabel="Avec méthode de validation" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

            </rich:tabPanel>

            <h:panelGroup id="prgtpAjt">
                <center>
                    <h:commandButton image="/images/annuler_big.png" id="linkanuAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.annuleSaisie}"  />&nbsp;&nbsp;
                    <h:commandButton image="/images/valider_big.png" id="link8Ajt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.save}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.var_aff_action&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.valideLaboratoire}" onclick="javascript:Richfaces.showModalPanel('modAttente');" />
                </center>              
            </h:panelGroup>

        </a4j:form>
    </center>


    <rich:modalPanel domElementAttachment="parent"  id="panelDetailProduit" headerClass="headerPanel" width="800" height="500" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.showModalPanelDetailProduits}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.showModalPanelDetailProduits}" var="detprd">
            <f:facet name="header"><h:outputText value="INFORMATIONS SUR LE PRODUIT"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.fermerDetailProduit}" image="/images/close.gif" styleClass="hidelink" reRender="panelDetailProduit"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  width="100%" id="formModalDetailProduit">
                    <h:panelGrid style="background-color:#DAEECB;" width="100%">
                        <h:panelGrid style="background-color:#DAEECB;" width="100%">
                            <h:panelGrid columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%">
                                <h:column><h:outputText value="Code:"/></h:column>
                                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.produits.proCode}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Libellé:"/></h:column>
                                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.produits.proLibClient}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Famille:"/></h:column>
                                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.produits.proVteCode}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Nature:"/></h:column>
                                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.produits.proVteNat} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.produits.proVteLib}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Descriptif:"/></h:column>
                                <h:column><h:inputTextarea style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.produits.proDescrip}" rows="3" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                    </h:panelGrid>

                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelListeProduits" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.showModalPanelProduits}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.showModalPanelProduits}" var="prd">
            <f:facet name="header"><h:outputText value="Sélection du produit"/></f:facet>
            <a4j:form id="formModalListeProduits">
                <rich:hotKey key="return" handler="return false;"/>
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable2" maxPages="20"align="left" for="tableProd"/>
                    <rich:extendedDataTable rows="200" id="tableProd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.datamodelProduits}"  var="prd" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.simpleSelectionProduits}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.extDTableProduits}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.selectionActes}" reRender="valprd3"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.valideActes}" reRender="panelListeProduits,inpCodDet,ligne1,idLaboratoireLigne"/>
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
                        <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.annuleActes}" reRender="panelListeProduits,inpCodDet,ligne1,idLaboratoireLigne"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.valideActes}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.produits.proId!=0}" reRender="panelListeProduits,inpCodDet,ligne1,idLaboratoireLigne"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelPec" headerClass="headerPanel" width="950" height="400" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.showModalpanelPec}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.showModalpanelPec}" var="ppec">
            <f:facet name="header"><h:outputText value="DETAIL DE LA PRISE EN CHARGE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton image="/images/close.gif" id="hidelinkPec" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.fermerConsulterTarif}" reRender="panelPec"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  columns="1" style="width:100%;" id="idPanelGlobal">
                    <h:panelGrid columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%" styleClass="fichefournisseur" id="idPanelPec">
                        <h:column><h:outputText value="Choix Tiers" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.patientPec.patpecType}" disabled="true">
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
                        <h:column><h:inputText style="width:95%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.patientPec.tiers.tieraisonsocialenom}" disabled="true"/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value="Employeur:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.patientPec.patpecType=='Assurance'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.patientPec.patpecType=='IPM'}"/></h:column>
                        <h:column><h:inputText id="idAdherent" style="width:95%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.patientPec.patpecNomEmployeur}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.patientPec.patpecType=='Assurance'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.patientPec.patpecType=='IPM'}" disabled="true"/></h:column>
                        <h:column rendered="false"><h:outputText value="Agent à refacturer:"/></h:column>
                        <h:column rendered="false"><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.patientPec.patpecAgentRefact}"/></h:column>
                        <h:column><h:outputText value="N° contrat:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.patientPec.patpecNumContrat}" disabled="true"/></h:column>
                        <h:column><h:outputText value="N° Immat. Assuré"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.patientPec.patpecMatricule}" disabled="true"/></h:column>
                        <h:column><h:outputText value="Date début"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.patientPec.patpecDateDebut}" popup="true"  inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style="background-color:white;" disabled="true"/></h:column>
                        <h:column><h:outputText value="Date fin"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.patientPec.patpecDateFin}" popup="true"  inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style="background-color:white;" disabled="true"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid width="100%" styleClass="fichefournisseur1" columns="3" columnClasses="clos40c,clos30,clos30" border="0">
                        <h:column><h:outputText value="L I B E L L E " style="text-align:center"/></h:column>
                        <h:column><h:outputText value="E X T E R N E " style="text-align:center"/></h:column>
                        <h:column><h:outputText value="H O S P I T A L I S A T I O N " style="text-align:center"/></h:column>
                        <h:column><h:outputText value="1 - Frais d'hospitalisation hébergement:"/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column>
                            <h:inputText size="8" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.patientPec.patpecHebergementPlaf}" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>&nbsp;&nbsp;
                            <h:outputText value="(plafond #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.structureLog.strdevise})"/>
                            <br>
                            <h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.patientPec.patpecHebergementRep}" disabled="true"/>%
                        </h:column>
                        <h:column><h:outputText value="2- Actes et examens (%):"/></h:column>
                        <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.patientPec.patpecSoins}" disabled="true"/>%</h:column>
                        <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.patientPec.patpecSoinsHospit}" disabled="true"/>%</h:column>
                        <h:column><h:outputText value="3 - Fourniture pharmacie (%):"/></h:column>
                        <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.patientPec.patpecMedicament}" disabled="true"/>%</h:column>
                        <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.patientPec.patpecMedicamentHospit}" disabled="true"/>%</h:column>
                        <h:column><h:outputText value="4 - Laboratoire et examens complémentaires (%):"/></h:column>
                        <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.patientPec.patpecExamenss}" disabled="true"/>%</h:column>
                        <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.patientPec.patpecExamenssHospit}" disabled="true"/>%</h:column>
                        <h:column><h:outputText value="5 - Autres préstations de soins fournies (%):"/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.patientPec.patpecPrestations}" disabled="true"/>%</h:column>
                        <h:column><h:outputText value="6 - Autres préstations d'hotelière fournies (%):"/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.patientPec.patpacHotelerie}" disabled="true"/>%</h:column>
                        <h:column><h:outputText value="Forfait global:"/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column>
                            <h:inputText size="8" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.patientPec.patpecForfait}" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>&nbsp;&nbsp;
                            <h:outputText value="(#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.structureLog.strdevise})"/>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelChangerServiceLaboratoire" width="400" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.showModalPanelChangerServiceLaboratoire}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.showModalPanelChangerServiceLaboratoire}" var="chs">
            <f:facet name="header"><h:outputText value="Change Service"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.annulerChangerServiceLaboratoire}" image="/images/close.gif" styleClass="hidelink" id="hidelinkChg" reRender="panelChangerServiceLaboratoire"/>
                    <rich:componentControl for="panelChg" attachTo="hidelinkChg" operation="hide" event="onclick"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Ancien service:"/></h:column>
                        <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.devisLigneMedical.dvsligLaboratoire}"/></h:column>
                        <h:column><h:outputText value="Nouveau service:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" id="chgimput"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.nouveauService}" >
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.mesImputationLabo}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="chgimput"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup>
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.validerChangerServiceLaboratoire}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
