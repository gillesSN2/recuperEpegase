<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="fichelaboratoire">

    <center>
        <a4j:form enctype="multipart/form-data">
            <rich:hotKey key="return" handler="return false;"/>

            <center> <h2><h:outputText value="GESTION DES EXAMENS DE LABORATOIRE (Facturation)" style="color:green;"/></h2></center>

            <rich:tabPanel switchType="client" immediate="true" style="border:0px;">

                <rich:tab id="tabdescrip" label="Descriptif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.autorisationDescription}">
                    <h:panelGrid id="idPanDescription" width="100%">
                        <h:panelGrid width="100%" styleClass="fichefournisseur">
                            <h:panelGrid  width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:column>
                                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_date}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateMed==0}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="prgtpAjt,outptcltAjt,link8Ajt,inptdatechce" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.controleSaisie}"/>
                                    </rich:calendar>&nbsp;
                                    <h:selectOneMenu id="idHeure" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_heure}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}" style="width:45px">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}"/>
                                    </h:selectOneMenu>
                                    <h:column><h:outputText value=":"/></h:column>
                                    <h:selectOneMenu id="idMinute" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_minute}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}" style="width:45px">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="N° Laboratoire:"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labNum}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Dossier:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patients.patDossier}" size="7" readonly="true"/>&nbsp;&nbsp;
                                    <h:outputText value="Série:" style="text-decoration:underline;"/>&nbsp;
                                    <h:selectOneMenu id="idSerie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labSerie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesSerieUserItem}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.calculMedecinActe}" reRender="prgtpAjt,idMedecin"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid id="grpCnt" width="100%" columns="4" columnClasses="clos12d,clos55g,clos12c,clos21g">
                                <h:column><h:outputText value="Nom Patient:" style="text-decoration:underline;width:100%"/></h:column>
                                <h:column>
                                    <h:inputText style="width:90%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labCivilite} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labNomPatient}" readonly="true"/>&nbsp;&nbsp;
                                    <h:column>
                                        <a4j:commandButton image="/images/detail.png" style="height:15px;width:15px" id="btndetailtiers" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.detailPatient}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_detail_tiers}" reRender="modAttente,idSubView"></a4j:commandButton>
                                    </h:column>
                                </h:column>
                                <h:column>
                                    <h:graphicImage url="/images/femme.png" height="26px" width="26px" alt="F" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patients.patSexe==0}"/>
                                    <h:graphicImage url="/images/homme.png" height="26px" width="26px" alt="M" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patients.patSexe==1}"/>
                                </h:column>
                                <h:column>
                                    <h:outputText value="Né(e) le:" />&nbsp;
                                    <h:inputText size="6" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patients.patDateNaissance}" readonly="true"/>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid id="grppec" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                <h:column>
                                    <h:outputText value="Prise en charge:" style="text-decoration:underline;"/>&nbsp;
                                    <a4j:commandButton image="/images/actualiser.png" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.changerTarif}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}" reRender="modAttente,idPanDescription,tableLigne,idTotalListe"></a4j:commandButton>
                                </h:column>
                                <h:column>
                                    <h:selectOneMenu id="idCat" style="width:85%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.nomFamille}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.mesCategoriesItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.changerTarif}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,gridTotal,tableLigne,ligne,grppec,idCat2,idCat3,idTotalListe,gridTotal"/>
                                    </h:selectOneMenu>&nbsp;
                                    <a4j:commandButton image="/images/detail.png" title="Consultation du détail de la prise en charge sélectionnée" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.consulterTarif}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPec"></a4j:commandButton>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.optionMedical.cnamgs=='1'&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.nomFamille==0}"><h:outputText value="CNAMGS:" style="text-decoration:underline;"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.optionMedical.cnamgs=='1'&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.nomFamille==0}">
                                    <h:selectOneMenu id="idPec" style="width:30%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_pecCnamgs}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}}">
                                        <f:selectItem itemLabel="Sans" itemValue="0"/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.lesTauxCnamgsItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.changerTarif}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idPanDescription,grpCnt,idCat,gridTotal,tableLigne,idFond,ligne,idTotalListe,gridTotal"/>
                                    </h:selectOneMenu>&nbsp;&nbsp;
                                    <h:selectOneMenu id="idFond" style="width:60%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labFondCnamgs}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_pecCnamgs!=0}">
                                        <f:selectItem itemLabel="Fonds 1 + Examens (SP)" itemValue="11"/>
                                        <f:selectItem itemLabel="Fonds 2 + Examens (AP)" itemValue="12"/>
                                        <f:selectItem itemLabel="Fonds 3 + Examens (GEF)" itemValue="13"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.nomFamille>=1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_pecCnamgs!=0}"><h:outputText id="idCat2" value="Complémentaire:" style="text-decoration:underline;"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.nomFamille>=1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_pecCnamgs!=0}">
                                    <h:selectOneMenu id="idCat3" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.nomComplementaire}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}">
                                        <f:selectItem itemLabel="Sans" itemValue="0"/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.mesComplementaireItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.changerTarif}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,gridTotal,tableLigne,ligne,idTotalListe,gridTotal"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid width="100%" styleClass="fichefournisseur1">
                            <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                <h:column><h:outputText value="Motif entrée:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idMotif" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labEntree}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}">
                                        <f:selectItem itemLabel="Sélection Motif Entrée" itemValue="100"/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesMotifEntreeItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_affiche_pathologie}"><h:outputText value="Type pathologie:" style="text-decoration:underline;"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_affiche_pathologie}">
                                    <h:selectOneMenu id="idPathologie" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labPathologie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}">
                                        <f:selectItem itemLabel="Sélection Pathologie" itemValue="100"/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesPathologieItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_affiche_protocole}"><h:outputText value="Protocole:" style="text-decoration:underline;"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_affiche_protocole}">
                                    <h:selectOneMenu id="idProtocole" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labProtocole}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}">
                                        <f:selectItem itemLabel="Sélection Protocole" itemValue="100"/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.mesProtocoleItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Service demandeur:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idService" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labService}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesServicesItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.optionMedical.choixLabo=='0'}"><h:outputText value="Laboratoire:" style="text-decoration:underline;"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.optionMedical.choixLabo=='0'}">
                                    <h:selectOneMenu id="idLaboratoire" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labLaboratoire}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesLaboratoiresItems}" />
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.calculMedecinActe}" reRender="idMedecin"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Mèdecin:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idMedecin" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_nom_medecin}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}">
                                        <f:selectItem itemLabel="Sélection Médecin" itemValue="0"/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.mesMedecinsItem}" />
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.verifValideLaboratoire}" reRender="prgtpAjt"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_affiche_prescipteur}"><h:outputText value="Prescripteur:" style="text-decoration:underline;"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_affiche_prescipteur}">
                                    <h:selectOneMenu id="idPrescripteur" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labPrescripteur}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}">
                                        <f:selectItem itemLabel="EXTERNE" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesMedecinsItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                <h:column><h:outputText value="N° B.C.:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labNumBc}" style="width:100%" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}"/></h:column>
                                <h:column><h:outputText value="N° Feuille"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labFeuille}" style="width:100%" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}"/></h:column>
                                <h:column><h:outputText value="N° Hospitalisation:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labNumHospit}" style="width:100%" readonly="true"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid width="100%" styleClass="fichefournisseur1">
                                <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g" id="idpanQuestion">
                                    <h:column><h:outputText value="Date prélèvement:"/></h:column>
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labDatePrelevement}"  inputSize="8" datePattern="dd/MM/yyyy HH:MM" locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}"/></h:column>
                                    <h:column><h:outputText value="Lieu prélèvement:"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labLieuPrelevement}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}">
                                            <f:selectItem itemLabel="Non renseigné" itemValue="0"/>
                                            <f:selectItem itemLabel="A domicile" itemValue="1"/>
                                            <f:selectItem itemLabel="Au laboratoire" itemValue="2"/>
                                            <f:selectItem itemLabel="Dans une unité de soin" itemValue="3"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Partenaire:"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labPartenaire}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}">
                                            <f:selectItem itemLabel="Non renseigné" itemValue="0"/>
                                            <f:selectItem itemLabel="Avec partenaire" itemValue="1"/>
                                            <f:selectItem itemLabel="Avec plusieurs partenaires" itemValue="2"/>
                                            <f:selectItem itemLabel="Sans partenaire" itemValue="3"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Date dernières règles:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patients.patSexe==0}"/></h:column>
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labDateRegles}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patients.patSexe==0}"/></h:column>
                                    <h:column><h:outputText value="Grossesse:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patients.patSexe==0}"/></h:column>
                                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labGrossesse}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patients.patSexe==0}"/></h:column>
                                    <h:column><h:outputText value="" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patients.patSexe==0}"/></h:column>
                                    <h:column><h:outputText value="" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patients.patSexe==0}"/></h:column>
                                    <h:column><h:outputText value="Diabète:"/></h:column>
                                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labDiabete}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}"/></h:column>
                                    <h:column><h:outputText value="Immuno-Déprimé(e):"/></h:column>
                                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labImmunodepressif}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}"/></h:column>
                                    <h:column><h:outputText value=""/></h:column>
                                    <h:column><h:outputText value=""/></h:column>
                                    <h:column><h:outputText value="Traitement en cours:"/></h:column>
                                    <h:column>
                                        <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labTraitement}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}">
                                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="idpanQuestion,idTrt1,idTrt2"/>
                                        </h:selectBooleanCheckbox>
                                    </h:column>
                                    <h:column><h:outputText id="idTrt1" value="Quel traitement?:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labTraitement==true}"/></h:column>
                                    <h:column><h:inputText id="idTrt2" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labLequel}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labTraitement==true}"/></h:column>
                                    <h:column><h:outputText value=""/></h:column>
                                    <h:column><h:outputText value=""/></h:column>
                                    <h:column><h:outputText value="Date résultat:" style="color:red"/></h:column>
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labDateResultat}"  inputSize="8" datePattern="dd/MM/yyyy HH:MM" locale="fr" style=" background-color:white;color:red"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}"/></h:column>
                                    <h:column><h:outputText value="Urgence:" style="color:red"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%;color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labUrgent}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}">
                                            <f:selectItem itemLabel="Normal" itemValue="0"/>
                                            <f:selectItem itemLabel="Petite Urgence" itemValue="1"/>
                                            <f:selectItem itemLabel="Urgence" itemValue="2"/>
                                            <f:selectItem itemLabel="Extreme Urgence" itemValue="3"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                </h:panelGrid>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid styleClass="fichefournisseur" id="gridTotal"  width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                            <h:column><h:outputText value="Total Patient:"/></h:column>
                            <h:column>
                                <h:inputText id="totht" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labTotPatient}" style="text-align:right;width:100%"  readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Total Tiers:"/></h:column>
                            <h:column>
                                <h:inputText id="totttc" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_tot_tiers}" style="text-align:right;width:100%" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Total Général:"/></h:column>
                            <h:column>
                                <h:inputText id="totrem" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labTotGeneral}" style="text-align:right;width:100%"  readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Reg. Patient:"/></h:column>
                            <h:column>
                                <h:inputText id="tottx" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labRegPatient}" style="text-align:right;width:100%"  readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Reg. tiers:"/></h:column>
                            <h:column>
                                <h:inputText id="tottc" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labRegTiers}" style="text-align:right;width:100%"  readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Solde:"/></h:column>
                            <h:column>
                                <h:inputText id="totreg" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_solde}" style="text-align:right;width:100%"  readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Examens" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_acc_acte}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.autorisationActes}">
                    <jsp:include flush="true" page="/medical/LaboratoireCommun.jsp" />
                    <h:panelGrid width="100%" id="idPanLigne">
                        <h:panelGrid id="btnActe" columns="4" width="200px" style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                            <a4j:commandButton image="/images/ajouter.png" title="Ajouter examen" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labEtat<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.ajouterActes}" reRender="idPanLigne,ligne,btnActe"/>
                            <a4j:commandButton image="/images/supprimer.png" title="Supprimer examen" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.afficheButtActes&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.supprimerActe}" reRender="tableLigne,btnActe,ligne,idTotalListe,gridTotal"/>
                            <a4j:commandButton image="/images/annuler_big.png" title="Avoir (Remboursement) examen" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.afficheButtActes&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labRegPatient==0||bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrMedicalAvoir==1)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.sup}" onclick="if (!confirm('Etes-vous sur de vouloir faire l`avoir (remboursement) de cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.avoirLigne}" reRender="tableLigne,btnActe,ligne,idTotalListe,gridTotal"/>
                            <a4j:commandButton title="Changer le service du document sélectionné" style="height:22px;width:22px" image="/images/permutter.jpeg" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.afficheButtActes&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labEtat==1&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labRegPatient==0||bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrMedicalAvoir==1)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" onclick="if (!confirm('Etes-vous sur de vouloir changer le service ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.changerServiceLaboratoire}" reRender="panelChangerServiceLaboratoire"/>
                        </h:panelGrid>
                        <h:panelGrid width="100%" id="ligne" style="border:1px solid green;background-color:#FFF8D4;" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.ajouterSurAvoir==false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action==false)||(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.ajouterSurAvoir==true)}">
                            <h:panelGrid columns="22" width="100%" id="ligne1">
                                <h:column><h:outputText value="Code" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:inputText tabindex="1" id="inpCodDet" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireLigne.labligProduit}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.griserchamps}" style="width:150px">
                                        <rich:toolTip id="tooladdPrd" followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les actes" style="background-color:#FFF8D4;"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.rechercheActes}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeProduits,formModalListeProduits,ligne,inpCodDet,idLaboratoireLigne"/>
                                    </h:inputText>&nbsp;&nbsp;
                                    <a4j:commandButton tabindex="2" image="/images/detail.png" style="height:15px;width:15px" id="btndetailprod" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.detailProduit}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_detail_prod}" reRender="formModalDetailProduit,panelDetailProduit,inpCodDet,ligne1"></a4j:commandButton>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.optionMedical.choixLabo=='1'}">
                                    <c:if test="${!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.choixImputationLabo}" var="lab1">
                                        <h:selectOneMenu tabindex="3" id="idLaboratoireLigne1" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireLigne.labligLaboratoire}" disabled="true">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesLaboratoiresItems}" />
                                        </h:selectOneMenu>
                                    </c:if>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.choixImputationLabo}" var="lab2">
                                        <h:selectOneMenu tabindex="3" id="idLaboratoireLigne2" style="width:100%;color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireLigne.labligLaboratoire}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.mesImputationLabo}" />
                                        </h:selectOneMenu>
                                    </c:if>
                                </h:column>
                                <h:column><h:outputText value="Libellé"/></h:column>
                                <h:column><h:inputText tabindex="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireLigne.labligLibelle}" readonly="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.griserchamps}" style="width:100%"/></h:column>
                                <h:column><h:outputText value="Lettre" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireLigne.labligNb!=0}"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idLettre" tabindex="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireLigne.labligLettre}" disabled="true" style="width:100px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireLigne.labligNb!=0}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesLettresItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="P.U.Stand."/></h:column>
                                <h:panelGroup id="puval" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireLigne.labligNb!=0}">
                                    <h:inputText tabindex="6" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireLigne.labligPu}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.verrouPrvente}" style="width:100px;text-align:right;" onkeypress="return scanToucheChiffre(event)">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup id="pu" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireLigne.labligNb==0}">
                                    <h:inputText tabindex="7" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireLigne.labligPu}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.verrouPrvente}" style="width:100px;text-align:right;" onkeypress="return scanToucheChiffre(event)">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_pecCnamgs!=0}"><h:outputText value="P.U.CNAMGS"/></h:column>
                                <h:panelGroup id="puvalCnamgs" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireLigne.labligNbCnamgs!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_pecCnamgs!=0}">
                                    <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireLigne.labligPuCnamgs}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.verrouPrventeCnamgs}" style="width:100px;text-align:right;" onkeypress="return scanToucheChiffre(event)">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:panelGroup id="puCnamgs" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireLigne.labligNbCnamgs==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_pecCnamgs!=0}">
                                    <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireLigne.labligPuCnamgs}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.verrouPrventeCnamgs}" style="width:100px;text-align:right;" onkeypress="return scanToucheChiffre(event)">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_pecAssurance}"><h:outputText value="P.U.Assur."/></h:column>
                                <h:panelGroup id="puAssurance" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_pecAssurance}">
                                    <h:inputText tabindex="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireLigne.labligPuAssurance}" style="width:100px;text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.verrouPrventeAssurance}" onkeypress="return scanToucheChiffre(event)">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrVerRemise==0}"><h:outputText value="Rem."/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrVerRemise==0}">
                                    <h:inputText tabindex="11" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireLigne.labligRemise}" style="width:50px;text-align:right;" onkeypress="return scanToucheChiffre(event)">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrVerRabais==0}"><h:outputText value="Rab."/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrVerRabais==0}">
                                    <h:inputText tabindex="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireLigne.labligRabais}" style="width:50px;text-align:right;" onkeypress="return scanToucheChiffre(event)">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Qte"/></h:column>
                                <h:column><h:inputText tabindex="13" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireLigne.labligQte}" style="width:80px;text-align:right;" onkeypress="return scanToucheChiffre(event)"/></h:column>
                                <h:column>
                                    <a4j:commandButton  tabindex="14" image="/images/valider_big.png" id="idValLigne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.saveActe}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_detail_prod}" reRender="btnActe,ligne,tableLigne,ligne1,idTotalListe,gridTotal"/>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable border="0" headerClass="headerTab" id="tableLigne" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" height="300px" width="100%" style="border:solid 1px green"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.dataModelLaboratoire}" var="acte" >
                                <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.selectionActeListe}" reRender="btnActe,ligne"/>
                                <rich:column  width="10%" sortable="true" sortBy="#{antec.labligLaboratoire}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.optionMedical.choixLabo=='1'}">
                                    <f:facet name="header"><h:outputText  value="Labo."/></f:facet>
                                    <h:outputText value="#{acte.labligLaboratoire}"/>
                                </rich:column>
                                <rich:column sortable="false" width="8%">
                                    <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                    <h:outputText  value="#{acte.labligProduit}"/>
                                </rich:column>
                                <rich:column sortable="false" width="22%">
                                    <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                    <h:inputTextarea rows="1" value="#{acte.labligLibelle}" readonly="true" style="width:95%"/>
                                </rich:column>
                                <rich:column label="Code lettre" sortable="false" style="text-align:right" width="12%" >
                                    <f:facet name="header"><h:outputText  value="Lettre"/></f:facet>
                                    <h:outputText value="#{acte.labligLettre}: #{acte.labligNb} * #{acte.labligValeur} (#{acte.labligCoef})" rendered="#{acte.labligNb!=0}"/>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right" width="5%" >
                                    <f:facet name="header"><h:outputText  value="Qté"/></f:facet>
                                    <h:outputText value="#{acte.labligQte}" />
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="10%">
                                    <f:facet name="header"><h:outputText value="P.U.ST"/></f:facet>
                                    <h:outputText value="#{acte.labligPuRem}" rendered="#{acte.labligPuRem!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_pecCnamgs!=0}">
                                    <f:facet name="header"><h:outputText value="P.U.CNAMGS"/></f:facet>
                                    <h:outputText value="#{acte.labligPuCnamgs}" rendered="#{acte.labligPuCnamgs!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="5%">
                                    <f:facet name="header"><h:outputText  value="R/R"/></f:facet>
                                    <h:outputText value="#{acte.labligRemise}" rendered="#{acte.labligRemise!=0}" />
                                    <h:outputText value="#{acte.labligRabais}" rendered="#{acte.labligRabais!=0}" />
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right;" width="10%">
                                    <f:facet name="header"><h:outputText value="Patient"/></f:facet>
                                    <h:outputText value="#{acte.labligPatientHt}" rendered="#{acte.labligPatientHt!=0}">
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
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.totalDocFacture}" style="text-align:right" readonly="true" disabled="true">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Total Tiers:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.totalDocTiers}" style="text-align:right" readonly="true" disabled="true">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Total Patient:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.totalDocPatient}" style="text-align:right" readonly="true" disabled="true">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Total Réglement:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.totalDocReglement}" style="text-align:right" readonly="true" disabled="true">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                            </h:panelGrid>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Scan" id="idScan" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.visibleOnglet}">
                    <jsp:include flush="true" page="/medical/ConsultationGeneCommun.jsp" />
                    <h:panelGrid width="100%" id="idPanScan">
                        <h:panelGrid width="100%" headerClass="headerTab">
                            <f:facet name="header"><h:outputText value="LISTE DES DOCUMENTS SCANNES"/></f:facet>
                            <br>
                            <a4j:region renderRegionOnly="false">
                                <h:panelGroup id="idScanGlobal" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}">
                                    <a4j:commandButton title="Ajouter document" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.ajouterDocumentScan}" reRender="panalAjoutFile"/>
                                </h:panelGroup>
                                <rich:dataGrid  style="background:transparent;border:0px;border:solid 1px green" width="100%" columns="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.dataModelDocumnts}" id="listeDoc" var="document" >
                                    <f:facet name="header"></f:facet>
                                    <rich:column>
                                        <a4j:commandButton  image="/images/imp_reader_big.png" value="#{document}" style="width:80px:height:80px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.lectureDoc}" reRender="panalVisuPj"/>
                                        <br>
                                        <h:outputText value="#{document}"/>
                                    </rich:column>
                                </rich:dataGrid>
                            </a4j:region>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Règlement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_acc_reglement}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.autorisationReglement}">
                    <jsp:include flush="true" page="/medical/LaboratoireCommun.jsp" />
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="lignerecu" height="200px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.datamodelRecu}"  var="recu"  sortMode="multi">
                            <jsp:include flush="true" page="/commun/listeReglementDocument.jsp"/>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

                <rich:tab label="Etat" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_acc_etat}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.autorisationEtat}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.calculeEtat}" reRender="idPanEtat"/>
                    <jsp:include flush="true" page="/medical/LaboratoireCommun.jsp" />
                    <h:panelGrid width="100%" id="idPanEtat">
                        <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="ID LABORATOIRE"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labId}" size="20" readonly="true"/></h:column>
                            <h:column><h:outputText value="Créateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labNomCreateur}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="ID créateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labIdCreateur}" size="20" readonly="true"/></h:column>
                            <h:column><h:outputText value="Date de création:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labDateCreat}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Modificateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labNomModif}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="ID modificateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labIdModif}" size="20" readonly="true"/></h:column>
                            <h:column><h:outputText value="Date de modification:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labDateModif}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Date d'impression:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labDateImp}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Date transfert en comptabilité:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labDateTransfert}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Etat:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labEtat}" disabled="true">
                                    <f:selectItem itemLabel="En cours" itemValue="0"/>
                                    <f:selectItem itemLabel="Validé" itemValue="1"/>
                                    <f:selectItem itemLabel="Gelé" itemValue="2"/>
                                    <f:selectItem itemLabel="Annulé" itemValue="3"/>
                                    <f:selectItem itemLabel="Cloturé" itemValue="4"/>
                                    <f:selectItem itemLabel="Controlée" itemValue="5"/>
                                    <f:selectItem itemLabel="Refacturée Ass./Soc." itemValue="6"/>
                                    <f:selectItem itemLabel="Refacturée Compl." itemValue="7"/>
                                </h:selectOneMenu>&nbsp;&nbsp;&nbsp;
                                <a4j:commandButton value="Réactiver le document" style="color:red"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labEtat==3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" onclick="if (!confirm('Etes-vous sur de vouloir réactiver ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.reactiverDocument}" reRender="idPanEtat"/>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Etat validation:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labEtatVal}" disabled="true">
                                    <f:selectItem itemLabel="Sans méthode de validation" itemValue="0"/>
                                    <f:selectItem itemLabel="Avec méthode de validation" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date d'annulation:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labDateAnnule}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Motif d'annulation:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labMotifAnnule}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="Date refacturation:"/></h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.dateRefacturation}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                            <h:column><h:outputText value="Numéro refacturation:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.numRefacturation}" size="20" readonly="true"/></h:column>
                            <h:column><h:outputText value="Etat refacturation:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.etatRefacuration}" size="20" readonly="true"/></h:column>
                            <h:column><h:outputText value="Bloque la refacturation:"/></h:column>
                            <h:column>
                                <a4j:commandButton value="Refacturation autorisée" style="color:blue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.bloqueFacturation}" reRender="idPanEtat" disabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.autoriseRefacturation}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labBloqueRefacturation}"/>
                                <a4j:commandButton value="Refacturation bloquée" style="color:red" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.deBloqueFacturation}" reRender="idPanEtat" disabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.autoriseRefacturation}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labBloqueRefacturation}"/>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

               <rich:tab label="Traçabilité" id="tabTrace" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.visibleOnglet}">
                    <jsp:include flush="true" page="/medical/ConsultationGeneCommun.jsp" />
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.chargerDocumentTrace}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panTrace"/>
                    <h:panelGrid id="panTrace" width="100%">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable height="300px" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;width:100%;height:150px;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.datamodelDocumentTrace}"  var="var"  sortMode="multi">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.selectionTracabilite}"/>
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
                    <h:commandButton image="/images/annuler_big.png" id="linkanuAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.annuleSaisie}"  />&nbsp;&nbsp;
                    <h:commandButton image="/images/valider_big.png" id="link8Ajt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.save}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.valideLaboratoire}" onclick="javascript:Richfaces.showModalPanel('modAttente');" />
                </center>              
            </h:panelGroup>

        </a4j:form>
    </center>


    <rich:modalPanel domElementAttachment="parent"  id="panelDetailProduit" headerClass="headerPanel" width="800" height="500" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.showModalPanelDetailProduits}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.showModalPanelDetailProduits}" var="detprd">
            <f:facet name="header"><h:outputText value="INFORMATIONS SUR LE PRODUIT"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.fermerDetailProduit}" image="/images/close.gif" styleClass="hidelink" reRender="panelDetailProduit"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  width="100%" id="formModalDetailProduit">
                    <h:panelGrid style="background-color:#DAEECB;" width="100%">
                        <h:panelGrid style="background-color:#DAEECB;" width="100%">
                            <h:panelGrid columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%">
                                <h:column><h:outputText value="Code:"/></h:column>
                                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.produits.proCode}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Libellé:"/></h:column>
                                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.produits.proLibClient}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Famille:"/></h:column>
                                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.produits.proVteCode}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Nature:"/></h:column>
                                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.produits.proVteNat} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.produits.proVteLib}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Descriptif:"/></h:column>
                                <h:column><h:inputTextarea style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.produits.proDescrip}" rows="3" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                    </h:panelGrid>

                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelAntecedent" headerClass="headerPanel" width="600" height="450" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.showModalPanelAntecedent}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.showModalPanelAntecedent}" var="ant">
            <f:facet name="header"><h:outputText value="GESTION DES ANTECEDENTS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.fermerAntecedent}" image="/images/close.gif" styleClass="hidelink" reRender="panelAntecedent"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  width="100%">
                    <h:panelGrid columns="2" width="100%" columnClasses="clos20,clos80">
                        <h:column><h:outputText value="Type antécédents:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="anteItem" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_antecedent}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patientAnt.patantId!=0}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesAntecedentItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" width="100%" columnClasses="clos20,clos80">
                        <h:column><h:outputText value="Date évènement:"/></h:column>
                        <h:column>
                            <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patientAnt.patantDate}" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  style="background-color:white"  inputSize="8"></rich:calendar>
                        </h:column>
                        <h:column><h:outputText value="Etat:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patientAnt.patantEtat}">
                                <f:selectItem itemLabel="En cours" itemValue="En cours"/>
                                <f:selectItem itemLabel="Résolu" itemValue="Résolu"/>
                                <f:selectItem itemLabel="Non Résolu" itemValue="Non résolu"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Description:"/></h:column>
                        <h:column><h:inputTextarea style="width:100%" rows="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patientAnt.patantObservation}"/></h:column>
                        <h:column><h:outputText value="Médecin:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patientAnt.patantMedecin}"/></h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br/>
                <h:panelGroup id="valAntecedent">
                    <center>
                        <a4j:commandButton id="idValAnt" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.saveAntecedent}" reRender="panelAntecedent,btnAntecedent,tableAntecedent"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelListeProduits" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.showModalPanelProduits}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.showModalPanelProduits}" var="prd">
            <f:facet name="header"><h:outputText value="Sélection du produit"/></f:facet>
            <a4j:form id="formModalListeProduits">
                <rich:hotKey key="return" handler="return false;"/>
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable2" maxPages="20"align="left" for="tableProd"/>
                    <rich:extendedDataTable rows="200" id="tableProd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.datamodelProduits}"  var="prd" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.simpleSelectionProduits}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.extDTableProduits}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.selectionActes}" reRender="valprd3"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.valideActes}" reRender="panelListeProduits,inpCodDet,ligne1,idLaboratoireLigne"/>
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
                        <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.annuleActes}" reRender="panelListeProduits,inpCodDet,ligne1,idLaboratoireLigne"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.valideActes}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.produits.proId!=0}" reRender="panelListeProduits,inpCodDet,ligne1,idLaboratoireLigne"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panalVisuPj" width="1100" height="600" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.showModalPanelPj}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.showModalPanelPj}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="Visualisation du fichier PDF"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.supprimerDocumentScan}" image="/images/supprimer.png" styleClass="hidelink" reRender="modAttente,panalVisuPj,listeDoc" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}"/>&nbsp;&nbsp;
                    <h:column>
                        <a type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.fichierMine}" href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.fichierUrl}" target="_blank" title="Lire document"><img src="images/detail.png" alt="lecture"></a>
                    </h:column>&nbsp;&nbsp;
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.fermerVisuDocumentScan}" image="/images/close.gif" styleClass="hidelink" reRender="panalVisuPj"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%">
                    <object data="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.fichierUrl}" type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.fichierMine}" width="100%" height="550">
                        <a href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.fichierUrl}"></a>
                    </object>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panalAjoutFile" width="500" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.showModalPanelAjoutFile}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.showModalPanelAjoutFile}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="UPLOADER DES DOCUMENTS DANS LE DOSSIER MEDICAL"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.annulerDocumentScan}" image="/images/close.gif" styleClass="hidelink" reRender="panalAjoutFile"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%" headerClass="headerTab" styleClass="panneau_accueil">
                    <h:panelGrid style="width:100%;">
                        <h:outputLabel value="Nom du document" />
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.nomDocument}" maxlength="20"/></h:column>
                        <h:outputLabel for="idDoc" value="Ajoutez un document" />
                        <t:inputFileUpload id="idDoc" accept="application/pdf" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.uploadedPDFFile}"/>
                        <br>
                        <h:panelGroup>
                            <center>
                                <h:commandButton styleClass="exp_lienmenu" value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.validerDocumentScan}"/>
                            </center>
                        </h:panelGroup>
                        <br>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelPec" headerClass="headerPanel" width="950" height="400" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.showModalpanelPec}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.showModalpanelPec}" var="ppec">
            <f:facet name="header"><h:outputText value="DETAIL DE LA PRISE EN CHARGE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton image="/images/close.gif" id="hidelinkPec" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.fermerConsulterTarif}" reRender="panelPec"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  columns="1" style="width:100%;" id="idPanelGlobal">
                    <h:panelGrid columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%" styleClass="fichefournisseur" id="idPanelPec">
                        <h:column><h:outputText value="Choix Tiers" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patientPec.patpecType}" disabled="true">
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
                        <h:column><h:inputText style="width:95%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patientPec.tiers.tieraisonsocialenom}" disabled="true"/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value="Employeur:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patientPec.patpecType=='Assurance'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patientPec.patpecType=='IPM'}"/></h:column>
                        <h:column><h:inputText id="idAdherent" style="width:95%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patientPec.patpecNomEmployeur}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patientPec.patpecType=='Assurance'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patientPec.patpecType=='IPM'}" disabled="true"/></h:column>
                        <h:column rendered="false"><h:outputText value="Agent à refacturer:"/></h:column>
                        <h:column rendered="false"><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patientPec.patpecAgentRefact}"/></h:column>
                        <h:column><h:outputText value="N° contrat:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patientPec.patpecNumContrat}" disabled="true"/></h:column>
                        <h:column><h:outputText value="N° Immat. Assuré"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patientPec.patpecMatricule}" disabled="true"/></h:column>
                        <h:column><h:outputText value="Date début"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patientPec.patpecDateDebut}" popup="true"  inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style="background-color:white;" disabled="true"/></h:column>
                        <h:column><h:outputText value="Date fin"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patientPec.patpecDateFin}" popup="true"  inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style="background-color:white;" disabled="true"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid width="100%" styleClass="fichefournisseur1" columns="3" columnClasses="clos40c,clos30,clos30" border="0">
                        <h:column><h:outputText value="L I B E L L E " style="text-align:center"/></h:column>
                        <h:column><h:outputText value="E X T E R N E " style="text-align:center"/></h:column>
                        <h:column><h:outputText value="H O S P I T A L I S A T I O N " style="text-align:center"/></h:column>
                        <h:column><h:outputText value="1 - Frais d'hospitalisation hébergement:"/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column>
                            <h:inputText size="8" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patientPec.patpecHebergementPlaf}" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>&nbsp;&nbsp;
                            <h:outputText value="(plafond #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.structureLog.strdevise})"/>
                            <br>
                            <h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patientPec.patpecHebergementRep}" disabled="true"/>%
                        </h:column>
                        <h:column><h:outputText value="2- Actes et examens (%):"/></h:column>
                        <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patientPec.patpecSoins}" disabled="true"/>%</h:column>
                        <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patientPec.patpecSoinsHospit}" disabled="true"/>%</h:column>
                        <h:column><h:outputText value="3 - Fourniture pharmacie (%):"/></h:column>
                        <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patientPec.patpecMedicament}" disabled="true"/>%</h:column>
                        <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patientPec.patpecMedicamentHospit}" disabled="true"/>%</h:column>
                        <h:column><h:outputText value="4 - Laboratoire et examens complémentaires (%):"/></h:column>
                        <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patientPec.patpecExamenss}" disabled="true"/>%</h:column>
                        <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patientPec.patpecExamenssHospit}" disabled="true"/>%</h:column>
                        <h:column><h:outputText value="5 - Autres préstations de soins fournies (%):"/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patientPec.patpecPrestations}" disabled="true"/>%</h:column>
                        <h:column><h:outputText value="6 - Autres préstations d'hotelière fournies (%):"/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:inputText size="5" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patientPec.patpacHotelerie}" disabled="true"/>%</h:column>
                        <h:column><h:outputText value="Forfait global:"/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column>
                            <h:inputText size="8" style="text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patientPec.patpecForfait}" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>&nbsp;&nbsp;
                            <h:outputText value="(#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.structureLog.strdevise})"/>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelChangerServiceLaboratoire" width="400" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.showModalPanelChangerServiceLaboratoire}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.showModalPanelChangerServiceLaboratoire}" var="chs">
            <f:facet name="header"><h:outputText value="Change Service"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.annulerChangerServiceLaboratoire}" image="/images/close.gif" styleClass="hidelink" id="hidelinkChg" reRender="panelChangerServiceLaboratoire"/>
                    <rich:componentControl for="panelChg" attachTo="hidelinkChg" operation="hide" event="onclick"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Ancien service:"/></h:column>
                        <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireLigne.labligLaboratoire}"/></h:column>
                        <h:column><h:outputText value="Nouveau service:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" id="chgimput"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.nouveauService}" >
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.mesImputationLabo}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="chgimput"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup>
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.validerChangerServiceLaboratoire}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
