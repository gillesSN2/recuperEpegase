<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="ficheconsultationInfirmerie">

    <center>
        <a4j:form enctype="multipart/form-data">
            <rich:hotKey key="return" handler="return false;"/>

            <center> <h2><h:outputText value="GESTION DES CONSULTATIONS (Infirmerie)" style="color:green;"/></h2></center>

            <rich:tabPanel switchType="client" immediate="true" style="border:0px;" id="idRichePanel">

                <rich:tab id="tabdescrip" label="Descriptif">
                    <h:panelGrid id="idPanDescription" width="100%">
                        <h:panelGrid width="100%" styleClass="fichefournisseur">
                            <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:column>
                                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_date}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateMed==0}">
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="prgtpAjt,outptcltAjt,link8Ajt,inptdatechce" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.controleSaisie}"/>
                                    </rich:calendar>&nbsp;
                                    <h:selectOneMenu id="idHeure" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_heure}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}" style="width:45px">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}"/>
                                    </h:selectOneMenu>
                                    <h:column><h:outputText value=":"/></h:column>
                                    <h:selectOneMenu id="idMinute" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_minute}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}" style="width:45px">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="N° Consultation:"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgNum}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Série:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idSerie" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgSerie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesSerieUserItem}"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid id="grpCnt" width="100%" columns="4" columnClasses="clos12d,clos55g,clos12c,clos21g">
                                <h:column><h:outputText value="Nom Patient:" style="text-decoration:underline;width:100%"/></h:column>
                                <h:column>
                                    <h:inputText style="width:90%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgCivilite} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgNomPatient}" readonly="true"/>&nbsp;&nbsp;
                                    <h:column>
                                        <a4j:commandButton image="/images/detail.png" style="height:15px;width:15px" id="btndetailtiers" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.detailPatient}"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_detail_tiers}" reRender="modAttente,idSubView"></a4j:commandButton>
                                    </h:column>
                                </h:column>
                                <h:column>
                                    <h:graphicImage url="/images/femme.png" height="26px" width="26px" alt="F" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.patients.patSexe==0}"/>
                                    <h:graphicImage url="/images/homme.png" height="26px" width="26px" alt="M" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.patients.patSexe==1}"/>
                                </h:column>
                                <h:column>
                                    <h:outputText value="Né(e) le:" />&nbsp;
                                    <h:inputText size="6" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.patients.patDateNaissance}" readonly="true"/>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid id="idBlocBc" styleClass="fichefournisseur1" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                            <h:column><h:outputText value="Motif entrée:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idMotif" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgEntree}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                                    <f:selectItem itemLabel="Sélection Motif Entrée" itemValue="100"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesMotifEntreeItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.calculeMotifEntree}" reRender="idRichePanel,idAt"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Pathologie:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idPathologie" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgPathologie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                                    <f:selectItem itemLabel="Sélection Pathologie" itemValue="100"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesPathologieItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Mèdecin:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idMedecin" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_nom_medecin}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                                    <f:selectItem itemLabel="Sélection Médecin" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.mesMedecinsItem}" />
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.verifValideConsultation}" reRender="prgtpAjt"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Objet:"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgObjet}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/></h:column>
                            <h:column><h:outputText value="Site concerné:"/></h:column>
                            <h:column><h:inputText  style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgService}" readonly="true" disabled="true"/></h:column>
                            <h:column><h:outputText value="Voulez-vous un BC?:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <a4j:commandButton id="idBC1" value="Calculer N° Bon de commande" style="width:100%" onclick="if (!confirm('Etes-vous sur de vouloir calculer le N° BC?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.calculerBC}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}" reRender="idPanDescription,idBlocBc,idBC1,idBC2,idBC2,idBlocBcSuite"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgNumBc==null}"/>
                                <a4j:commandButton id="idBC2" value="Effacer N° Bon de commande" style="width:100%" onclick="if (!confirm('Etes-vous sur de vouloir supprimer le N° BC?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.effacerBC}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}" reRender="idPanDescription,idBlocBc,idBC1,idBC2,idBC3,idBlocBcSuite"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgNumBc!=null}"/>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid id="idBlocBcSuite" styleClass="fichefournisseur1" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgNumBc!=null}">
                            <h:column><h:outputText value="N° bon de commande"/></h:column>
                            <h:column><h:inputText id="idBC3" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgNumBc}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Imputation:" style="text-decoration:underline;"/></h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgProtocole}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                                <f:selectItem itemLabel="Sélection Imputation" itemValue=""/>
                                <f:selectItem itemLabel="AT CNSS" itemValue="AT CNSS"/>
                                <f:selectItem itemLabel="AT TEMPORAIRE" itemValue="AT TEMPORAIRE"/>
                                <f:selectItem itemLabel="VME" itemValue="VME"/>
                                <f:selectItem itemLabel="VMA" itemValue="VMA"/>
                                <f:selectItem itemLabel="SUITE VME" itemValue="SUITE VME"/>
                                <f:selectItem itemLabel="SUITE VMA" itemValue="SUITE VMA"/>
                                <f:selectItem itemLabel="INFIRMERIE" itemValue="INFIRMERIE"/>
                                <f:selectItem itemLabel="RESPONSABILITE CIVILE" itemValue="RESPONSABILITE CIVILE"/>
                            </h:selectOneMenu>
                            <h:column><h:outputText value="Pharmacie:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idFournisseurPha" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_nom_fournisseurPha}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                                    <f:selectItem itemLabel="Sélection Pharmacie" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.mesFournisseursItem}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Commande pharmacie:"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgNomComplemtaire}" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/></h:column>
                            <h:column><h:outputText value="Laboratoire:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idFournisseurLab" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_nom_fournisseurLab}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                                    <f:selectItem itemLabel="Sélection Laboratoire" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.mesFournisseursItem}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Commande laboratoire:"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgPrescripteur}" maxlength="121" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Antécédents" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_acc_antecedent}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.autorisationAntecedent}"/>
                    <jsp:include flush="true" page="/medical/ConsultationGeneCommun.jsp" />
                    <h:panelGrid width="100%">
                        <h:panelGrid id="btnAntecedent" columns="4" width="150px" style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                            <a4j:commandButton image="/images/ajouter.png" title="Ajouter antécédent" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgEtat<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.ajouterAntecedent}" reRender="panelAntecedent,btnAntecedent"/>
                            <a4j:commandButton image="/images/modifier.png" title="Modifier antécédent" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.afficheButtAntecedent&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgEtat<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.modifierAntecedent}" reRender="panelAntecedent,btnAntecedent"/>
                            <a4j:commandButton image="/images/detail.png" title="Consulter antécédent"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.afficheButtAntecedent}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consulterAntecedent}" reRender="panelAntecedent,btnAntecedent"/>
                            <a4j:commandButton image="/images/supprimer.png" title="Supprimer antécédent" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.afficheButtAntecedent&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgEtat<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.sup}" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.supprimerAntecedent}" reRender="tableAntecedent,btnAntecedent"/>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="tableAntecedent" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" height="300px" width="100%" style="border:solid 1px green" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.dataModelAntecedent}" var="antec" >
                                <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.selectionAntecedent}" reRender="btnAntecedent"/>
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

                <rich:tab label="Anamnèse" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_acc_anamese}" reRender="idPlainte">
                    <jsp:include flush="true" page="/medical/ConsultationGeneCommun.jsp" />
                    <h:panelGrid width="100%">
                        <h:outputText value="Description de la plainte:" />
                        <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgAnamese}">
                            <jsp:include flush="true" page="../css/tdt.jsp"/>
                        </rich:editor>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Examens cliniques" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_acc_examClinique}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.autorisationExamClinique}"/>
                    <jsp:include flush="true" page="/medical/ConsultationGeneCommun.jsp" />
                    <h:panelGrid width="100%" >
                        <h:panelGrid id="idExaCli" style="background-color:#DAEECB;" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                            <h:column><h:outputText value="Poids (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_lib_poids}):" /></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgPoids}" style="text-align:right;" onkeypress="return scanToucheChiffre(event)">
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.calculIcm}" reRender="idExaCli,idIcm"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Taille (cm):" /></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgTaille}" style="text-align:right;" onkeypress="return scanToucheChiffre(event)">
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.calculIcm}" reRender="idExaCli,idIcm"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="IMC (P/T²):" /></h:column>
                            <h:column>
                                <h:inputText id="idIcm" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgImc}" style="text-align:right;" onkeypress="return scanToucheChiffre(event)">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Température (°c):" /></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgTemperature}" style="text-align:right;" onkeypress="return scanToucheChiffre(event)"/></h:column>
                            <h:column><h:outputText value="Fréquence cardiaque:" /></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgFreCar}" style="text-align:right;" onkeypress="return scanToucheChiffre(event)"/></h:column>
                            <h:column><h:outputText value="Fréquence respiratoire:" /></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgFreRes}" style="text-align:right;" onkeypress="return scanToucheChiffre(event)"/></h:column>
                            <h:column><h:outputText value="Diurèse (ml/H):" /></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgDiurese}" style="text-align:right;" onkeypress="return scanToucheChiffre(event)"/></h:column>
                            <h:column><h:outputText value="Tension bras gauche:" /></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgTension}" style="text-align:right;"/></h:column>
                            <h:column><h:outputText value="Tension bras droit:" /></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgTensionDroit}" style="text-align:right;" onkeypress="return scanToucheChiffre(event)"/></h:column>
                            <h:column><h:outputText value="Oeil gauche:" /></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgOeilGauche}" style="text-align:right;" onkeypress="return scanToucheChiffre(event)"/></h:column>
                            <h:column><h:outputText value="Oeil droit:" /></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgOeilDroit}" style="text-align:right;" onkeypress="return scanToucheChiffre(event)"/></h:column>
                            <h:column><h:outputText value="" /></h:column>
                            <h:column><h:outputText value="" /></h:column>
                        </h:panelGrid>
                        <h:panelGrid width="100%">
                            <h:outputText value="Résumé syndromique:" />
                            <h:inputTextarea value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgExamClinique}" rows="5" style="width:100%"/>
                        </h:panelGrid>
                        <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80" id="diag">
                            <h:column><h:outputText value="Hypothèse diagnostic 1:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgCodeDiag1}" style="width:100px">
                                    <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les diagnostics" style="background-color:#FFF8D4;"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.rechercheDiagnostic1}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelDiagnostic,formModalpanelDiagnostic"/>
                                </h:inputText>&nbsp;&nbsp;
                                <h:inputText id="lib1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.lib_diag1}" style="width:80%" readonly="true"/>
                            </h:column>
                            <h:column><h:outputText value="Hypothèse diagnostic 2:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgCodeDiag2}" style="width:100px">
                                    <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les diagnostics" style="background-color:#FFF8D4;"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.rechercheDiagnostic2}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelDiagnostic,formModalpanelDiagnostic"/>
                                </h:inputText>&nbsp;&nbsp;
                                <h:inputText id="lib2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.lib_diag2}" style="width:80%" readonly="true"/>
                            </h:column>
                            <h:column><h:outputText value="Hypothèse diagnostic 3:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgCodeDiag3}" style="width:100px">
                                    <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les diagnostics" style="background-color:#FFF8D4;"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.rechercheDiagnostic3}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelDiagnostic,formModalpanelDiagnostic"/>
                                </h:inputText>&nbsp;&nbsp;
                                <h:inputText id="lib3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.lib_diag3}" style="width:80%" readonly="true"/>
                            </h:column>
                            <h:column><h:outputText value="Hypothèse diagnostic 4:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgCodeDiag4}" style="width:100px">
                                    <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les diagnostics" style="background-color:#FFF8D4;"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.rechercheDiagnostic4}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelDiagnostic,formModalpanelDiagnostic"/>
                                </h:inputText>&nbsp;&nbsp;
                                <h:inputText id="lib4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.lib_diag4}" style="width:80%" readonly="true"/>
                            </h:column>
                            <h:column><h:outputText value="Hypothèse diagnostic 5:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgCodeDiag5}" style="width:100px">
                                    <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les diagnostics" style="background-color:#FFF8D4;"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.rechercheDiagnostic5}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelDiagnostic,formModalpanelDiagnostic"/>
                                </h:inputText>&nbsp;&nbsp;
                                <h:inputText id="lib5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.lib_diag5}" style="width:80%" readonly="true"/>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid width="100%">
                            <h:outputText value="Discussion:" />
                            <h:inputTextarea value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgDiscution}" rows="2" style="width:100%"/>
                        </h:panelGrid>
                        <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80" id="diag2" style="border:1px solid green;background-color:#FFF8D4;">
                            <h:column><h:outputText value="Diagnostic positif:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgCodeDiag11}" style="width:100px">
                                    <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les diagnostics" style="background-color:#FFF8D4;"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.rechercheDiagnostic11}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelDiagnostic,formModalpanelDiagnostic"/>
                                </h:inputText>&nbsp;&nbsp;
                                <h:inputText id="lib11" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.lib_diag11}" style="width:80%" readonly="true"/>
                            </h:column>
                            <h:column><h:outputText value="Diagnostic retentissement:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgCodeDiag12}" style="width:100px">
                                    <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les diagnostics" style="background-color:#FFF8D4;"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.rechercheDiagnostic12}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelDiagnostic,formModalpanelDiagnostic"/>
                                </h:inputText>&nbsp;&nbsp;
                                <h:inputText id="lib12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.lib_diag12}" style="width:80%" readonly="true"/>
                            </h:column>
                            <h:column><h:outputText value="Hospitalisation:" /></h:column>
                            <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgChoixHospit}"/></h:column>
                            <h:column><h:outputText value="Mise en observation:" /></h:column>
                            <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgChoixObs}"/></h:column>
                            <h:column><h:outputText value="Référé:" /></h:column>
                            <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgChoixRefere}"/></h:column>
                            <h:column><h:outputText value="Demande de visite pré-anesthésique:" /></h:column>
                            <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgChoixVisitepa}"/></h:column>
                            <h:column><h:outputText value="Date prochain rendez-vous:" /></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgRdv}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                        </h:panelGrid>
                        <h:panelGrid width="100%">
                            <h:outputText value="Evolution:" />
                            <h:inputTextarea value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgEvolution}" rows="2" style="width:100%"/>
                        </h:panelGrid>
                        <h:panelGrid width="100%">
                            <h:outputText value="Pronostic:" />
                            <h:inputTextarea value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgPronostic}" rows="2" style="width:100%"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Actes et examens" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.visibleOnglet}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.autorisationActes}"/>
                    <jsp:include flush="true" page="/medical/ConsultationGeneCommun.jsp" />
                    <h:panelGrid width="100%">
                        <h:panelGrid id="btnActe" columns="3" width="150px" style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                            <a4j:commandButton image="/images/ajouter.png" title="Ajouter acte" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgEtat<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.ajouterActes}" reRender="ligne,btnActe"/>
                            <a4j:commandButton image="/images/supprimer.png" title="Supprimer acte" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.afficheButtActes&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.supprimerActe}" reRender="tableLigne,btnActe,ligne"/>
                        </h:panelGrid>
                        <h:panelGrid width="100%" id="ligne" style="border:1px solid green;background-color:#FFF8D4;" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                            <h:panelGrid columns="7" width="100%" id="ligne1">
                                <h:column><h:outputText value="Code" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:inputText tabindex="1" id="inpCodDet" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationActes.cslactProduit}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.griserchamps}" style="width:100px">
                                        <rich:toolTip id="tooladdPrd" followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les actes" style="background-color:#FFF8D4;"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.rechercheActes}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeActes,formModalDetailActe,formModalListeActes,ligne1,inpCodDet"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Libellé"/></h:column>
                                <h:column><h:inputText tabindex="2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationActes.cslactLibelle}" readonly="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.griserchamps}" style="width:100%"/></h:column>
                                <h:column><h:outputText value="Qte"/></h:column>
                                <h:column><h:inputText tabindex="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationActes.cslactQte}" style="width:50px;text-align:right;" onkeypress="return scanToucheChiffre(event)"/></h:column>
                                <h:column>
                                    <a4j:commandButton  tabindex="4" image="/images/valider_big.png" id="idValLigne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.saveActe}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_detail_prod}" reRender="btnActe,ligne,tableLigne,ligne1"/>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable border="0" headerClass="headerTab" id="tableLigne" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" height="300px" width="100%" style="border:solid 1px green"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.dataModelActe}" var="acte" >
                                <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.selectionActeListe}" reRender="btnActe,ligne"/>
                                <rich:column sortable="false" width="20%">
                                    <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                    <h:outputText  value="#{acte.cslactProduit}"/>
                                </rich:column>
                                <rich:column sortable="false" width="40%">
                                    <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                    <h:inputTextarea rows="1" value="#{acte.cslactLibelle}" readonly="true" style="width:95%"/>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right" width="10%" >
                                    <f:facet name="header"><h:outputText  value="Qté"/></f:facet>
                                    <h:outputText value="#{acte.cslactQte}" />
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Prescription Ordonnance" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_acc_medicament}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.ajouterMedicamment}"/>
                    <jsp:include flush="true" page="/medical/ConsultationGeneCommun.jsp" />
                    <h:panelGrid width="100%">
                        <h:panelGrid id="btnOrdo" columns="2" width="100px" style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                            <a4j:commandButton image="/images/ajouter.png" title="Ajouter médicamment" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgEtat<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.ajouterMedicamment}" reRender="ligneOrdo,btnOrdo"/>
                            <a4j:commandButton image="/images/supprimer.png" title="Supprimer médicamment" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.afficheButtOrdo}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.supprimerMedicamment}" reRender="ligneOrdo,btnOrdo,tableOrdo"/>
                        </h:panelGrid>
                        <h:panelGrid width="100%" id="ligneOrdo" style="border:1px solid green;background-color:#FFF8D4;" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                            <h:panelGrid columns="14" width="100%" id="ligne2">
                                <h:column><h:outputText value="Code CIP" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:inputText tabindex="1" id="inpMedDet" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationOrdo.cslordProduit}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.griserchamps}" style="width:150px">
                                        <rich:toolTip id="tooladdMed" followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les médicamments" style="background-color:#FFF8D4;"/>
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.rechercheMedicamment}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeMedicamment,formModalListeMedicamment,ligne2"/>
                                    </h:inputText>
                                </h:column>
                                <h:column>
                                    <a4j:commandButton  tabindex="2" image="/images/detail.png" id="btndetailmed" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.detailDci}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_detail_ordo}" reRender="panelDetailDci,formModalDetailDci"/>
                                </h:column>
                                <h:column><h:outputText value="Spécialité"/></h:column>
                                <h:column><h:inputTextarea tabindex="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationOrdo.cslordLibelle}" readonly="true" style="width:100%" rows="2"/></h:column>
                                <h:column><h:outputText value="Posologie"/></h:column>
                                <h:column><h:inputTextarea tabindex="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationOrdo.cslordPoso}" style="width:100%" rows="2"/></h:column>                               
                                <h:column><h:outputText value="Observations"/></h:column>
                                <h:column><h:inputTextarea tabindex="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationOrdo.cslordObs}" style="width:100%" rows="2"/></h:column>
                                <h:column><h:outputText value="Qte"/></h:column>
                                <h:column><h:inputText tabindex="6" size="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationOrdo.cslordQte}" style="width:100%" onkeypress="return scanToucheChiffre(event)"/></h:column>
                                <h:column><h:outputText value="Unité"/></h:column>
                                <h:column><h:inputText tabindex="7" size="6" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationOrdo.cslordUnite}" style="width:100%"/></h:column>
                                <h:column>
                                    <h:commandButton tabindex="8" image="/images/valider_big.png" id="buttonOrdo" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.saveOrdonnance}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_detail_ordo}">
                                        <a4j:support eventsQueue="maQueue" event="onclick" reRender="tableOrdo"/>
                                    </h:commandButton>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable border="0" headerClass="headerTab" id="tableOrdo" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" height="300px" width="100%" style="border:solid 1px green"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.dataModelOrdonnance}" var="ordo" >
                                <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.selectionMedicammentListe}" reRender="btnOrdo,ligneOrdo"/>
                                <rich:column label="Code CIP" sortable="false" width="10%">
                                    <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                    <h:outputText  value="#{ordo.cslordProduit}"/>
                                </rich:column>
                                <rich:column label="Spécialité du médicamment" sortable="false" width="30%">
                                    <f:facet name="header"><h:outputText  value="Spécialité"/></f:facet>
                                    <h:outputText value="#{ordo.cslordLibelle}"/>
                                </rich:column>
                                <rich:column label="Posologie" sortable="false" width="30%">
                                    <f:facet name="header"><h:outputText  value="Posologie"/></f:facet>
                                    <h:outputText value="#{ordo.cslordPoso}"/>
                                </rich:column>
                                <rich:column label="Observations" sortable="false" width="20%">
                                    <f:facet name="header"><h:outputText  value="Observations"/></f:facet>
                                    <h:outputText value="#{ordo.cslordObs}"/>
                                </rich:column>
                                <rich:column label="Quantité" sortable="false" width="10%">
                                    <f:facet name="header"><h:outputText  value="Quantité"/></f:facet>
                                    <h:outputText value="#{ordo.cslordQte} #{ordo.cslordUnite}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Pharmacie" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_acc_medicament&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affiche_maladie||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affiche_at)}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.ajouterPharmacie}"/>
                    <jsp:include flush="true" page="/medical/ConsultationGeneCommun.jsp" />
                    <h:panelGrid width="100%">
                        <h:panelGrid id="btnPharmacie" columns="2" width="100px" style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                            <a4j:commandButton image="/images/ajouter.png" title="Ajouter médicamment" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgEtat<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.ajouterPharmacie}" reRender="lignePharmacie,btnPharmacie"/>
                            <a4j:commandButton image="/images/supprimer.png" title="Supprimer médicamment" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.afficheButtPharmacie}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.supprimerPharmacie}" reRender="lignePharmacie,btnPharmacie,tablePharmacie"/>
                        </h:panelGrid>
                        <h:panelGrid width="100%" id="lignePharmacie" style="border:1px solid green;background-color:#FFF8D4;" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                            <h:panelGrid columns="9" width="100%" id="ligne4">
                                <h:column><h:outputText value="Code CIP" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:inputText tabindex="1" id="inpPharDet" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.pharmacieLigne.phaligProduit}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.griserchamps}" style="width:150px">
                                        <rich:toolTip id="tooladdPhar" followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les médicamments" style="background-color:#FFF8D4;"/>
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.recherchePharmacie}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,formModalListeProduits,panelListeProduits,ligne4"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Spécialité"/></h:column>
                                <h:column><h:inputTextarea tabindex="2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.pharmacieLigne.phaligLibelle}" readonly="true" style="width:100%" rows="2"/></h:column>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.produits.proStock>=1}">
                                    <h:outputText value="Stock" />
                                    <h:selectOneMenu id="idDepot" tabindex="3" style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_depotProd}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.mesProduitsDepotsItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.selectionDepot}" reRender="panelLigne,panelLigne4"/>
                                    </h:selectOneMenu>
                                </h:panelGroup>
                                <h:panelGroup id="panelCdt" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_condit}">
                                    <h:outputText value="Cdt."/>
                                    <h:selectOneMenu tabindex="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.pharmacieLigne.phaligCondition}" style="width:100px;">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.mesConditionnementsProduits}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.selectionConditionnement}" reRender="panelLigne,panelLigne2,panelPu,panelPt,panelLigne3"/>
                                    </h:selectOneMenu>
                                </h:panelGroup>
                                <h:panelGroup id="panelUnite" rendered="false">
                                    <h:outputText value="Unité"/>
                                    <h:selectOneMenu rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_unite}" tabindex="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.pharmacieLigne.phaligUnite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.griserchamps}" style="width:80px;">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.mesUnitesProduits}"/>
                                    </h:selectOneMenu>
                                    <h:inputText rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_unite}" tabindex="6" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.pharmacieLigne.phaligUnite}" style="width:80px;"/>
                                </h:panelGroup>
                                <h:panelGroup>
                                    <h:outputText value="Qte"/>
                                    <h:inputText tabindex="7" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.pharmacieLigne.phaligQte}" style="width:90px;text-align:right;" onkeypress="return scanToucheChiffre(event)">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.optionMedical.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.optionMedical.nbDecQte}"/>
                                    </h:inputText>
                                </h:panelGroup>
                                <h:column>
                                    <h:commandButton tabindex="8" image="/images/valider_big.png" id="buttonPharmacie" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.savePharmacie}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_detail_pharmacie}">
                                        <a4j:support eventsQueue="maQueue" event="onclick" reRender="tablePharmacie"/>
                                    </h:commandButton>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable border="0" headerClass="headerTab" id="tablePharmacie" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" height="300px" width="100%" style="border:solid 1px green"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.dataModelPharmacie}" var="phar" >
                                <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.selectionPharmacieListe}" reRender="btnPharmacie,lignePharmacie"/>
                                <rich:column label="Code CIP" sortable="false" width="10%">
                                    <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                    <h:outputText  value="#{phar.phaligProduit}"/>
                                </rich:column>
                                <rich:column label="Spécialité du médicamment" sortable="false" width="30%">
                                    <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                    <h:outputText value="#{phar.phaligLibelle}"/>
                                </rich:column>
                                <rich:column label="Dépôt" sortable="false" width="10%">
                                    <f:facet name="header"><h:outputText  value="Dépôt"/></f:facet>
                                    <h:outputText value="#{phar.phaligDepot}"/>
                                </rich:column>
                                <rich:column label="Unité" sortable="false" width="20%">
                                    <f:facet name="header"><h:outputText  value="Unité"/></f:facet>
                                    <h:outputText value="#{phar.var_lib_uni_condit}"/>
                                </rich:column>
                                <rich:column label="Quantité" sortable="false" width="10%">
                                    <f:facet name="header"><h:outputText  value="Qte"/></f:facet>
                                    <h:outputText value="#{phar.phaligQte}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Prescription Paraclinique" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_acc_examComplementaire}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.autorisationExamComplementaire}"/>
                    <jsp:include flush="true" page="/medical/ConsultationGeneCommun.jsp" />
                    <h:panelGrid width="100%">
                        <h:panelGrid id="btnLabo" columns="2" width="100px" style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                            <a4j:commandButton image="/images/ajouter.png" title="Ajouter examen laboratoire" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgEtat<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.ajouterLaboratoire}" reRender="ligneLabo,btnLabo"/>
                            <a4j:commandButton image="/images/supprimer.png" title="Supprimer examen laboratoire" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.afficheButtLabo}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.supprimerLaboratoire}" reRender="ligneLabo,btnLabo"/>
                        </h:panelGrid>
                        <h:panelGrid width="100%" id="ligneLabo" style="border:1px solid green;background-color:#FFF8D4;" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                            <h:panelGrid columns="8" width="100%" id="ligne3">
                                <h:column><h:outputText value="Code" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:inputText tabindex="1" id="inpLabDet" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationLabo.csllabProduit}" style="width:150px">
                                        <rich:toolTip id="tooladdLab" followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les examens de laboratoire" style="background-color:#FFF8D4;"/>
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.rechercheLaboratoire}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeProduits,formModalListeProduits,ligne3"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><a4j:commandButton  tabindex="2" image="/images/detail.png" id="btndetaillab" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.detailLaboratoire}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_detail_labo}" reRender="formModalDetailProduit,panelDetailProduit"></a4j:commandButton></h:column>
                                <h:column><h:outputText value="Libellé"/></h:column>
                                <h:column><h:inputTextarea tabindex="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationLabo.csllabLibelle}" readonly="true" style="width:100%" rows="2"/></h:column>
                                <h:column><h:outputText value="Observations"/></h:column>
                                <h:column><h:inputTextarea tabindex="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationLabo.csllabObs}" style="width:100%" rows="2"/></h:column>
                                <h:column>
                                    <h:commandButton tabindex="5" image="/images/valider_big.png" id="buttonLabo" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.saveLaboratoire}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_detail_labo}">
                                        <a4j:support eventsQueue="maQueue" event="onclick" reRender="tableLabo"/>
                                    </h:commandButton>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable border="0" headerClass="headerTab" id="tableLabo" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" height="300px" width="100%" style="border:solid 1px green"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.dataModelLaboratoire}" var="labo" >
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.selectionLaboratoireListe}" reRender="btnLabo,ligneLabo"/>
                                <rich:column label="Code" sortable="false" width="10%">
                                    <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                    <h:outputText  value="#{labo.csllabProduit}"/>
                                </rich:column>
                                <rich:column label="Nom de l'examen" sortable="false" width="45%">
                                    <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                    <h:outputText value="#{labo.csllabLibelle}"/>
                                </rich:column>
                                <rich:column label="Observations" sortable="false" width="45%">
                                    <f:facet name="header"><h:outputText  value="Observations"/></f:facet>
                                    <h:outputText value="#{labo.csllabObs}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Déclaration A.T." id="idAt" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affiche_at}">
                    <jsp:include flush="true" page="/medical/ConsultationGeneCommun.jsp" />
                    <h:panelGrid width="100%" id="idPanAT">
                        <h:panelGrid headerClass="headerTab" columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%" styleClass="fichefournisseur">
                            <f:facet name="header"><h:outputText value="Informations patient"/></f:facet>
                            <h:column><h:outputText value="N° C.N.S.S.:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.patients.patSecu}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/></h:column>
                            <h:column><h:outputText value="N° C.N.A.M.G.S.:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.patients.patCnamgs}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/></h:column>
                            <h:column><h:outputText value="Anciénneté:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccAnciennete}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/></h:column>
                            <h:column><h:outputText value="Nombre salariés de l'entreprise:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccNbSalaries}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid headerClass="headerTab" columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%" styleClass="fichefournisseur">
                            <f:facet name="header"><h:outputText value="Accident"/></f:facet>
                            <h:column><h:outputText value="Date accident:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_date_accident}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/></h:column>
                            <h:column><h:outputText value="Heure/minute accident:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_heures}" size="2" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/>&nbsp;&nbsp;
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_minutes}"  size="2" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/>
                            </h:column>
                            <h:column><h:outputText value="Lieu:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccLieuAccident}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value="Nature des lésions"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccNatureLesion}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/></h:column>
                            <h:column><h:outputText value="Siège lésions:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccSiegeLesion}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/></h:column>
                            <h:column><h:outputText value="Causes accident:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccCause}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/></h:column>
                            <h:column><h:outputText value="Horaires du salarié:"/></h:column>
                            <h:column>
                                <h:outputText value="de:"/>&nbsp;
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccHoraireDebut}" style="width:40%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/>&nbsp;&nbsp;
                                <h:outputText value="à:"/>&nbsp;
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccHoraireFin}" style="width:40%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid headerClass="headerTab" width="100%" styleClass="fichefournisseur">
                            <f:facet name="header"><h:outputText value="Circonstances Accident"/></f:facet>
                            <h:column><h:inputTextarea rows="4" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccCirconstance}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid headerClass="headerTab" columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%" styleClass="fichefournisseur">
                            <h:column><h:outputText value="Machine ou produit:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccMateriel}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/></h:column>
                            <h:column><h:outputText value="Sécurité:"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccSecurite}" style="width:100%"  readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                                    <f:selectItem itemLabel="Sans matériel de sécurité" itemValue="0"/>
                                    <f:selectItem itemLabel="Avec matériel de sécurité" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Type 1er sécours:"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccSecours}" style="width:100%"  readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                                    <f:selectItem itemLabel="Secouriste" itemValue="0"/>
                                    <f:selectItem itemLabel="Infirmier" itemValue="1"/>
                                    <f:selectItem itemLabel="Médecin" itemValue="2"/>
                                    <f:selectItem itemLabel="Pompier" itemValue="3"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Nom médecin:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccMedecin}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/></h:column>
                            <h:column><h:outputText value="Suite probable:"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccSuite}" style="width:100%"  readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                                    <f:selectItem itemLabel="Sans arrêt" itemValue="0"/>
                                    <f:selectItem itemLabel="Arrêt > 24 h" itemValue="1"/>
                                    <f:selectItem itemLabel="Déces immédiat" itemValue="2"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                        </h:panelGrid>
                        <h:panelGrid headerClass="headerTab" columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%" styleClass="fichefournisseur1">
                            <f:facet name="header"><h:outputText value="Témoin"/></f:facet>
                            <h:column><h:outputText value="Nom témoin:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccTemoin}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/></h:column>
                            <h:column><h:outputText value="Adresse témoin:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccAdresseTemoin}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/></h:column>
                            <h:column><h:outputText value="Rapport de police:"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccRapportPolice}" style="width:100%"  readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                                    <f:selectItem itemLabel="Non fait" itemValue="0"/>
                                    <f:selectItem itemLabel="Etabli" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Par qui ?"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccNomPolice}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid headerClass="headerTab" columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%" styleClass="fichefournisseur">
                            <f:facet name="header"><h:outputText value="Risque causé par un tiers"/></f:facet>
                            <h:column><h:outputText value="Nom reponsable:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccNomTiers}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/></h:column>
                            <h:column><h:outputText value="Adresse responsable:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccAdresseTiers}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/></h:column>
                            <h:column><h:outputText value="Assureur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccAssuranceTiers}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/></h:column>
                            <h:column><h:outputText value="N° Assurance:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccNumTiers}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid headerClass="headerTab" columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%" styleClass="fichefournisseur">
                            <f:facet name="header"><h:outputText value="Salaire de référence"/></f:facet>
                            <h:column><h:outputText value="Date bulletin:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccDatePaye}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/></h:column>
                            <h:column><h:outputText value="Période:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccPeriodePaye}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/></h:column>
                            <h:column><h:outputText value="Salaire brut:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccBrut}" style="text-align:right" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Heures Supp.:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccHSup}" style="text-align:right" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Primes:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccPrimes}" style="text-align:right" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Ration:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccRation}" style="text-align:right" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Logement:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccLogement}" style="text-align:right" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Divers:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccDivers}" style="text-align:right" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Total:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccTotal}" style="text-align:right" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid headerClass="headerTab" columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%" styleClass="fichefournisseur">
                            <f:facet name="header"><h:outputText value="Signature déclaration"/></f:facet>
                            <h:column><h:outputText value="Date rédaction:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccDateDocument}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/></h:column>
                            <h:column><h:outputText value="Signature:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccSignataire}" style="width:100%" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Vaccination" id="idVaccin" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affiche_vaccin}">
                    <jsp:include flush="true" page="/medical/ConsultationGeneCommun.jsp" />
                    <h:panelGrid width="100%" id="idPanVaccin">
                        <h:panelGrid headerClass="headerTab" width="100%" styleClass="fichefournisseur" columns="2">
                            <f:facet name="header"><h:outputText value="Date rendez-vous"/></f:facet>
                            <h:column><h:outputText value="Date rendez-vous prévu:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccDateRdv}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/></h:column>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable border="0" enableContextMenu="false" headerClass="headerTab" id="tableVaccin" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" height="300px" width="100%" style="border:solid 1px green"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.dataModelElements}" var="vac" >
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.selectionElementListe}"/>
                                <rich:column label="Code" sortable="false" width="25%">
                                    <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                    <h:outputText  value="#{vac.code}"/>
                                </rich:column>
                                <rich:column label="Nom du vaccin" sortable="false" width="25%">
                                    <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                    <h:outputText value="#{vac.nom_FR}"/>
                                </rich:column>
                                <rich:column label="Vaccin demandé" sortable="false" width="10%" style="text-align:center">
                                    <f:facet name="header"><h:outputText  value="Démandé"/></f:facet>
                                    <h:selectBooleanCheckbox value="#{vac.demande}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                                        <a4j:support immediate="true" eventsQueue="maQueue" event="onchange" reRender="idReel1,idReel2"/>
                                    </h:selectBooleanCheckbox>
                                </rich:column>
                                <rich:column id="idReel1" label="Vaccin effectué" sortable="false" width="10%" style="text-align:center">
                                    <f:facet name="header"><h:outputText value="Réalisé"/></f:facet>
                                    <h:selectBooleanCheckbox id="idReel2" value="#{vac.effectue}" rendered="#{vac.demande==true}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                                        <a4j:support immediate="true" eventsQueue="maQueue" event="onchange" reRender="idLot1,idLot2,idLot3,idLot4"/>
                                    </h:selectBooleanCheckbox>
                                </rich:column>
                                <rich:column id="idLot1" label="N° lot" sortable="false" width="20%">
                                    <f:facet name="header"><h:outputText  value="N° Lot"/></f:facet>
                                    <h:inputText value="#{vac.lot}" maxlength="20" id="idLot2" style="width:90%" rendered="#{vac.effectue==true}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/>
                                </rich:column>
                                <rich:column id="idLot3" label="Date de péremption du lot" sortable="false" width="10%">
                                    <f:facet name="header"><h:outputText  value="Péremption"/></f:facet>
                                    <rich:calendar value="#{vac.datePeremption}" id="idLot4" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" rendered="#{vac.effectue==true}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}" />
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                        <h:panelGrid headerClass="headerTab" width="100%" styleClass="fichefournisseur">
                            <f:facet name="header"><h:outputText value="Compte rendu vaccination"/></f:facet>
                            <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccCirconstance}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                                <jsp:include flush="true" page="../css/tdt.jsp"/>
                            </rich:editor>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Audimétrie" id="idAudio" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affiche_audio}">
                    <jsp:include flush="true" page="/medical/ConsultationGeneCommun.jsp" />
                    <h:panelGrid width="100%" id="idPanAudio">
                        <h:panelGrid headerClass="headerTab" width="100%" styleClass="fichefournisseur" columns="2">
                            <f:facet name="header"><h:outputText value="Date rendez-vous"/></f:facet>
                            <h:column><h:outputText value="Date rendez-vous prévu:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccDateRdv}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/></h:column>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable border="0" enableContextMenu="false" headerClass="headerTab" id="tableAudio" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" height="150px" width="100%" style="border:solid 1px green"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.dataModelElements}" var="vac" >
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.selectionElementListe}"/>
                                <rich:column label="Nom de l'examen" sortable="false" width="30%">
                                    <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                    <h:outputText value="#{vac.nom_FR}"/>
                                </rich:column>
                                <rich:column label="audiogramme demandé" sortable="false" width="10%" style="text-align:center">
                                    <f:facet name="header"><h:outputText  value="Démandé"/></f:facet>
                                    <h:selectBooleanCheckbox value="#{vac.demande}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                                        <a4j:support immediate="true" eventsQueue="maQueue" event="onchange" reRender="idReel1,idReel2"/>
                                    </h:selectBooleanCheckbox>
                                </rich:column>
                                <rich:column id="idReel1" label="Effectué" sortable="false" width="10%" style="text-align:center">
                                    <f:facet name="header"><h:outputText value="Réalisé"/></f:facet>
                                    <h:selectBooleanCheckbox id="idReel2" value="#{vac.effectue}" rendered="#{vac.demande==true}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                        <h:panelGrid headerClass="headerTab" width="100%" styleClass="fichefournisseur">
                            <f:facet name="header"><h:outputText value="Compte rendu audiométrie"/></f:facet>
                            <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccCirconstance}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                                <jsp:include flush="true" page="../css/tdt.jsp"/>
                            </rich:editor>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="VME" id="idVme" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affiche_vme}">
                    <jsp:include flush="true" page="/medical/ConsultationGeneCommun.jsp" />
                    <h:panelGrid width="100%" id="idPanVme">
                        <h:panelGrid headerClass="headerTab" width="100%" styleClass="fichefournisseur" columns="2">
                            <f:facet name="header"><h:outputText value="Date rendez-vous"/></f:facet>
                            <h:column><h:outputText value="Date rendez-vous prévu:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccDateRdv}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/></h:column>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable border="0" enableContextMenu="false" headerClass="headerTab" id="tableVme" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" height="200px" width="100%" style="border:solid 1px green"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.dataModelElements}" var="vac" >
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.selectionElementListe}"/>
                                <rich:column label="Code" sortable="false" width="25%">
                                    <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                    <h:outputText  value="#{vac.code}"/>
                                </rich:column>
                                <rich:column label="Nom examen" sortable="false" width="25%">
                                    <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                    <h:outputText value="#{vac.nom_FR}"/>
                                </rich:column>
                                <rich:column label="Examen demandé" sortable="false" width="10%" style="text-align:center">
                                    <f:facet name="header"><h:outputText  value="Démandé"/></f:facet>
                                    <h:selectBooleanCheckbox value="true" disabled="true"/>
                                </rich:column>
                                <rich:column label="Examen effectué" sortable="false" width="10%" style="text-align:center">
                                    <f:facet name="header"><h:outputText value="Réalisé"/></f:facet>
                                    <h:selectBooleanCheckbox value="#{vac.effectue}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                                        <a4j:support immediate="true" eventsQueue="maQueue" event="onchange" reRender="idLot1,idLot2"/>
                                    </h:selectBooleanCheckbox>
                                </rich:column>
                                <rich:column id="idLot1" label="Résultat examen" sortable="false" width="30%">
                                    <f:facet name="header"><h:outputText  value="Résultat"/></f:facet>
                                    <h:inputText value="#{vac.lot}" maxlength="20" id="idLot2" style="width:90%" rendered="#{vac.effectue==true}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                        <h:panelGrid headerClass="headerTab" width="100%" styleClass="fichefournisseur">
                            <f:facet name="header"><h:outputText value="Compte rendu V.M.E."/></f:facet>
                            <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccCirconstance}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                                <jsp:include flush="true" page="../css/tdt.jsp"/>
                            </rich:editor>
                        </h:panelGrid>
                        <h:panelGrid headerClass="headerTab" width="100%" styleClass="fichefournisseur">
                            <f:facet name="header"><h:outputText value="Aptitude"/></f:facet>
                            <h:selectOneRadio style="border:0px;color:red;font-weight:bold;font-size:50px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccApte}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                                <f:selectItem itemLabel="Non Statué" itemValue="0"/>
                                <f:selectItem itemLabel="APTE" itemValue="1"/>
                                <f:selectItem itemLabel="INAPTE" itemValue="2"/>
                            </h:selectOneRadio>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="VMA" id="idVma" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affiche_vma}">
                    <jsp:include flush="true" page="/medical/ConsultationGeneCommun.jsp" />
                    <h:panelGrid width="100%" id="idPanVma">
                        <h:panelGrid headerClass="headerTab" width="100%" styleClass="fichefournisseur" columns="2">
                            <f:facet name="header"><h:outputText value="Date rendez-vous"/></f:facet>
                            <h:column><h:outputText value="Date rendez-vous prévu:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccDateRdv}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/></h:column>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable border="0" enableContextMenu="false" headerClass="headerTab" id="tableVma" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" height="200px" width="100%" style="border:solid 1px green"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.dataModelElements}" var="vac" >
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.selectionElementListe}"/>
                                <rich:column label="Code" sortable="false" width="25%">
                                    <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                    <h:outputText  value="#{vac.code}"/>
                                </rich:column>
                                <rich:column label="Nom examen" sortable="false" width="25%">
                                    <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                    <h:outputText value="#{vac.nom_FR}"/>
                                </rich:column>
                                <rich:column label="Examen demandé" sortable="false" width="10%" style="text-align:center">
                                    <f:facet name="header"><h:outputText  value="Démandé"/></f:facet>
                                    <h:selectBooleanCheckbox value="true" disabled="true"/>
                                </rich:column>
                                <rich:column label="Examen effectué" sortable="false" width="10%" style="text-align:center">
                                    <f:facet name="header"><h:outputText value="Réalisé"/></f:facet>
                                    <h:selectBooleanCheckbox value="#{vac.effectue}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                                        <a4j:support immediate="true" eventsQueue="maQueue" event="onchange" reRender="idLot1,idLot2"/>
                                    </h:selectBooleanCheckbox>
                                </rich:column>
                                <rich:column id="idLot1" label="Résultat examen" sortable="false" width="30%">
                                    <f:facet name="header"><h:outputText  value="Résultat"/></f:facet>
                                    <h:inputText value="#{vac.lot}" maxlength="20" id="idLot2" style="width:90%" rendered="#{vac.effectue==true}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                        <h:panelGrid headerClass="headerTab" width="100%" styleClass="fichefournisseur">
                            <f:facet name="header"><h:outputText value="Compte rendu V.M.A."/></f:facet>
                            <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccCirconstance}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                                <jsp:include flush="true" page="../css/tdt.jsp"/>
                            </rich:editor>
                        </h:panelGrid>
                        <h:panelGrid headerClass="headerTab" width="100%" styleClass="fichefournisseur">
                            <f:facet name="header"><h:outputText value="Aptitude"/></f:facet>
                            <h:selectOneRadio style="border:0px;color:red;font-weight:bold;font-size:50px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccApte}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                                <f:selectItem itemLabel="Non Statué" itemValue="0"/>
                                <f:selectItem itemLabel="APTE" itemValue="1"/>
                                <f:selectItem itemLabel="INAPTE" itemValue="2"/>
                            </h:selectOneRadio>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="TuberTest" id="idIdr" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_affiche_tubertest}">
                    <jsp:include flush="true" page="/medical/ConsultationGeneCommun.jsp" />
                    <h:panelGrid width="100%" id="idPanTubertest">
                        <h:panelGrid headerClass="headerTab" width="100%" styleClass="fichefournisseur" columns="2">
                            <f:facet name="header"><h:outputText value="Date rendez-vous"/></f:facet>
                            <h:column><h:outputText value="Date rendez-vous prévu:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccDateRdv}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/></h:column>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable border="0" enableContextMenu="false" headerClass="headerTab" id="tableIdr" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" height="100px" width="100%" style="border:solid 1px green"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.dataModelElements}" var="vac" >
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.selectionElementListe}"/>
                                <rich:column label="Code" sortable="false" width="25%">
                                    <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                    <h:outputText  value="#{vac.code}"/>
                                </rich:column>
                                <rich:column label="Nom examen" sortable="false" width="25%">
                                    <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                    <h:outputText value="#{vac.nom_FR}"/>
                                </rich:column>
                                <rich:column label="Examen demandé" sortable="false" width="10%" style="text-align:center">
                                    <f:facet name="header"><h:outputText  value="Démandé"/></f:facet>
                                    <h:selectBooleanCheckbox value="true" disabled="true"/>
                                </rich:column>
                                <rich:column label="Examen effectué" sortable="false" width="10%" style="text-align:center">
                                    <f:facet name="header"><h:outputText value="Réalisé"/></f:facet>
                                    <h:selectBooleanCheckbox value="#{vac.effectue}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                                        <a4j:support immediate="true" eventsQueue="maQueue" event="onchange" reRender="idLot1,idLot2"/>
                                    </h:selectBooleanCheckbox>
                                </rich:column>
                                <rich:column id="idLot1" label="Résultat examen" sortable="false" width="30%">
                                    <f:facet name="header"><h:outputText  value="Résultat"/></f:facet>
                                    <h:inputText value="#{vac.lot}" maxlength="20" id="idLot2" style="width:90%" rendered="#{vac.effectue==true}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                        <h:panelGrid headerClass="headerTab" width="100%" styleClass="fichefournisseur">
                            <f:facet name="header"><h:outputText value="Compte rendu TuberTest"/></f:facet>
                            <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccCirconstance}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                                <jsp:include flush="true" page="../css/tdt.jsp"/>
                            </rich:editor>
                        </h:panelGrid>
                        <h:panelGrid headerClass="headerTab" width="100%" styleClass="fichefournisseur">
                            <f:facet name="header"><h:outputText value="Aptitude"/></f:facet>
                            <h:selectOneRadio style="border:0px;color:red;font-weight:bold;font-size:50px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccPositif}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                                <f:selectItem itemLabel="Non Statué" itemValue="0"/>
                                <f:selectItem itemLabel="NON POSITIF" itemValue="1"/>
                                <f:selectItem itemLabel="POSITIF" itemValue="2"/>
                            </h:selectOneRadio>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Certificats" id="idCertificat" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.visibleOnglet}">
                    <jsp:include flush="true" page="/medical/ConsultationGeneCommun.jsp" />
                    <h:panelGrid width="100%" id="idPanCertif">
                        <h:panelGrid width="100%" id="idRepos" columns="2" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Type de certificat:"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccCertificat}" style="width:100%"  readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                                    <f:selectItem itemLabel="Sélection type Certificat" itemValue="0"/>
                                    <f:selectItem itemLabel="Certificat Médical Initial" itemValue="1"/>
                                    <f:selectItem itemLabel="Certificat Médical" itemValue="2"/>
                                    <f:selectItem itemLabel="Certificat Médical de Prolongation" itemValue="3"/>
                                    <f:selectItem itemLabel="Certificat Médical de Guérison" itemValue="4"/>
                                    <f:selectItem itemLabel="Certificat de Rechute" itemValue="5"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="idRepos,idRepos1,idRepos2,idRepos3,idRepos4,idRepos5,idRepos6,idRepos7,idRepos8"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column id="idRepos1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccCertificat==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccCertificat==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccCertificat==3||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccCertificat==5}"><h:outputText value="Date début repos:"/></h:column>
                            <h:column id="idRepos2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccCertificat==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccCertificat==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccCertificat==3||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccCertificat==5}">
                                <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccDateDu}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.calculNbRepos}" reRender="idRepos,idRepos6"/>
                                </rich:calendar>
                            </h:column>
                            <h:column id="idRepos3" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccCertificat==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccCertificat==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccCertificat==3||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccCertificat==5}"><h:outputText value="Date fin repos:"/></h:column>
                            <h:column id="idRepos4" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccCertificat==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccCertificat==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccCertificat==3||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccCertificat==5}">
                                <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccDateAu}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.calculNbRepos}" reRender="idRepos,idRepos6"/>
                                </rich:calendar>
                            </h:column>
                            <h:column id="idRepos5" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccCertificat==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccCertificat==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccCertificat==3||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccCertificat==5}"><h:outputText value="Soit un total de:"/></h:column>
                            <h:column id="idRepos6" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccCertificat==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccCertificat==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccCertificat==3||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccCertificat==5}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccNbJourRepos}" size="8" readonly="true" disabled="true"/></h:column>
                            <h:column id="idRepos7" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccCertificat!=0}"><h:outputText value="Motif du certificat:"/></h:column>
                            <h:column id="idRepos8" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccCertificat!=0}"><h:inputTextarea rows="6" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationInfirmerie.cslaccMotifRepos}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Scan" id="idScan" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.visibleOnglet}">
                    <jsp:include flush="true" page="/medical/ConsultationGeneCommun.jsp" />
                    <h:panelGrid width="100%" id="idPanScan">
                        <h:panelGrid width="100%" headerClass="headerTab">
                            <f:facet name="header"><h:outputText value="LISTE DES DOCUMENTS SCANNES"/></f:facet>
                            <br>
                            <a4j:region renderRegionOnly="false">
                                <h:panelGroup id="idScanGlobal" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}">
                                    <a4j:commandButton title="Ajouter document" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.ajouterDocumentScan}" reRender="panalAjoutFile"/>
                                </h:panelGroup>
                                <rich:dataGrid  style="background:transparent;border:0px;border:solid 1px green" width="100%" columns="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.dataModelDocumnts}" id="listeDoc" var="document" >
                                    <f:facet name="header"></f:facet>
                                    <rich:column>
                                        <a4j:commandButton  image="/images/imp_reader_big.png" value="#{document}" style="width:80px:height:80px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.lectureDoc}" reRender="panalVisuPj"/>
                                        <br>
                                        <h:outputText value="#{document}"/>
                                    </rich:column>
                                </rich:dataGrid>
                            </a4j:region>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Etat" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_acc_etat}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.autorisationEtat}">
                    <jsp:include flush="true" page="/medical/ConsultationGeneCommun.jsp" />
                    <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" id="idPanEtat">
                        <h:column><h:outputText value="ID CONSULTATION:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgId}" size="20" readonly="true"/></h:column>
                        <h:column><h:outputText value="Créateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgNomCreateur}" size="100" readonly="true"/></h:column>
                        <h:column><h:outputText value="ID créateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgIdCreateur}" size="20" readonly="true"/></h:column>
                        <h:column><h:outputText value="Date de création:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgDateCreat}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Modificateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgNomModif}" size="100" readonly="true"/></h:column>
                        <h:column><h:outputText value="ID modificateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgIdModif}" size="20" readonly="true"/></h:column>
                        <h:column><h:outputText value="Date de modification:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgDateModif}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date d'impression:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgDateImp}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date transfert en comptabilité:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgDateTransfert}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Etat:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgEtat}" disabled="true">
                                <f:selectItem itemLabel="En cours" itemValue="0"/>
                                    <f:selectItem itemLabel="Validé" itemValue="1"/>
                                    <f:selectItem itemLabel="Gelé" itemValue="2"/>
                                    <f:selectItem itemLabel="Annulé" itemValue="3"/>
                                    <f:selectItem itemLabel="Cloturé" itemValue="4"/>
                                    <f:selectItem itemLabel="Controlée" itemValue="5"/>
                                    <f:selectItem itemLabel="Refacturée Ass./Soc." itemValue="6"/>
                                    <f:selectItem itemLabel="Refacturée Compl." itemValue="7"/>
                            </h:selectOneMenu>&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton value="Réactiver le document" style="color:red"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgEtat==3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.maj}" onclick="if (!confirm('Etes-vous sur de vouloir réactiver ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.reactiverDocument}" reRender="idPanEtat"/>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Etat validation:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgEtatVal}" disabled="true">
                                <f:selectItem itemLabel="Sans méthode de validation" itemValue="0"/>
                                <f:selectItem itemLabel="Avec méthode de validation" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Date d'annulation:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgDateAnnule}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Motif d'annulation:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgMotifAnnule}" size="100" readonly="true"/></h:column>
                    </h:panelGrid>
                </rich:tab>

            </rich:tabPanel>

            <h:panelGroup id="prgtpAjt">
                <center>
                    <h:commandButton image="/images/annuler_big.png" id="linkanuAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.annuleSaisie}"  />&nbsp;&nbsp;
                    <h:commandButton image="/images/valider_big.png" id="link8Ajt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.saveInfirmerie}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.valideConsultation}" onclick="javascript:Richfaces.showModalPanel('modAttente');" />
                </center>
            </h:panelGroup>

        </a4j:form>
    </center>



    <rich:modalPanel domElementAttachment="parent"  id="panelDetailDci" headerClass="headerPanel" width="800" height="450" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.showModalPanelMedicammentDci}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.showModalPanelMedicammentDci}" var="detdci">
            <f:facet name="header"><h:outputText value="INFORMATIONS SUR LE PRODUIT"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.fermerDci}" image="/images/close.gif" styleClass="hidelink" reRender="panelDetailDci"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalDetailDci">
                <rich:hotKey key="return" handler="return false;"/>
                <rich:tabPanel switchType="client" immediate="true" style="border:0px;">

                    <rich:tab id="produitSpecialite" label="Spécialité">
                        <h:panelGrid columns="2" columnClasses="clos25,clos75" width="100%">
                            <h:column><h:outputText value="Code CIP:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.produitsMedicamment.promdcCodeCip}" readonly="true" style="width:100%"/></h:column>
                            <h:column><h:outputText value="Code COPHASE:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.produitsMedicamment.promdcCodeCophase}" readonly="true" style="width:100%"/></h:column>
                            <h:column><h:outputText value="DCI:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.produitsMedicamment.promdcCodeDci}" readonly="true" style="width:100%"/></h:column>
                            <h:column><h:outputText value="Spécialité:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.produitsMedicamment.promdcSpecialite}"readonly="true" style="width:100%"/></h:column>
                            <h:column><h:outputText value="Dosage:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.produitsMedicamment.promdcDosage}" readonly="true" style="width:100%"/></h:column>
                            <h:column><h:outputText value="Forme galénique:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.produitsMedicamment.promdcForme}" readonly="true" style="width:100%"/></h:column>
                            <h:column><h:outputText value="Classe thérapeutique:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.produitsMedicamment.promdcClasse}" readonly="true" style="width:100%"/></h:column>
                            <h:column><h:outputText value="Prix:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.produitsMedicamment.promdcPrix}" readonly="true" style="width:100%"/></h:column>
                            <h:column><h:outputText value="Liste:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.produitsMedicamment.promdcListe}" readonly="true" style="width:100%"/></h:column>
                            <h:column><h:outputText value="Laboratoire:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.produitsMedicamment.promdcLaboratoire}" readonly="true" style="width:100%"/></h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="produitDci" label="DCI">
                        <h:panelGrid columns="2" columnClasses="clos25,clos75" width="100%">
                            <h:column><h:outputText value="DCI:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.produitsDci.prodciCode}" readonly="true" style="width:100%"/></h:column>
                            <h:column><h:outputText value="Forme:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.produitsDci.prodciForme}"readonly="true" style="width:100%"/></h:column>
                            <h:column><h:outputText value="Indication:"/></h:column>
                            <h:column><h:inputTextarea value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.produitsDci.prodciIndication}" readonly="true" rows="4" style="width:100%" /></h:column>
                            <h:column><h:outputText value="Posologie:"/></h:column>
                            <h:column><h:inputTextarea value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.produitsDci.prodciPosologie}" readonly="true" rows="4" style="width:100%" /></h:column>
                            <h:column><h:outputText value="Contre indication:"/></h:column>
                            <h:column><h:inputTextarea value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.produitsDci.prodciContreIndic}" readonly="true" rows="4" style="width:100%" /></h:column>
                            <h:column><h:outputText value="Effet secondaire:"/></h:column>
                            <h:column><h:inputTextarea value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.produitsDci.prodciEffetSecond}" readonly="true" rows="4" style="width:100%" /></h:column>
                        </h:panelGrid>
                    </rich:tab>

                </rich:tabPanel>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelAntecedent" headerClass="headerPanel" width="600" height="450" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.showModalPanelAntecedent}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.showModalPanelAntecedent}" var="ant">
            <f:facet name="header"><h:outputText value="GESTION DES ANTECEDENTS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.fermerAntecedent}" image="/images/close.gif" styleClass="hidelink" reRender="panelAntecedent"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  width="100%">
                    <h:panelGrid columns="2" width="100%" columnClasses="clos20,clos80">
                        <h:column><h:outputText value="Type antécédents:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="anteItem" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_antecedent}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.patientAnt.patantId!=0}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesAntecedentItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" width="100%" columnClasses="clos20,clos80">
                        <h:column><h:outputText value="Date évènement:"/></h:column>
                        <h:column>
                            <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.patientAnt.patantDate}" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  style="background-color:white"  inputSize="8"></rich:calendar>
                        </h:column>
                        <h:column><h:outputText value="Etat:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.patientAnt.patantEtat}">
                                <f:selectItem itemLabel="En cours" itemValue="En cours"/>
                                <f:selectItem itemLabel="Résolu" itemValue="Résolu"/>
                                <f:selectItem itemLabel="Non Résolu" itemValue="Non résolu"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Description:"/></h:column>
                        <h:column><h:inputTextarea style="width:100%" rows="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.patientAnt.patantObservation}"/></h:column>
                        <h:column><h:outputText value="Médecin:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.patientAnt.patantMedecin}"/></h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br/>
                <h:panelGroup id="valAntecedent">
                    <center>
                        <a4j:commandButton id="idValAnt" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.saveAntecedent}" reRender="panelAntecedent,btnAntecedent,tableAntecedent"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelDiagnostic" headerClass="headerPanel" width="1000" height="650" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.showModalPaneldiagnostic}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.showModalPaneldiagnostic}" var="dia">
            <f:facet name="header"><h:outputText value="RECHERCHE DE DIAGNOSTIC"></h:outputText></f:facet>
            <a4j:form id="formModalpanelDiagnostic">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  width="100%">
                    <h:panelGrid  width="100%" columns="5">
                        <h:column><h:outputText value="Code CMD:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.recherche_cmd}" /></h:column>
                        <h:column><h:outputText value="Diagnostic:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.recherche_diag}" /></h:column>
                        <h:column>
                            <a4j:commandButton  value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.rechercheSuite}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="idTableDiag,scrollTable1"/>
                        </h:column>
                    </h:panelGrid>
                    <br>
                    <a4j:region renderRegionOnly="false">
                        <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable1" maxPages="20"align="left" for="idTableDiag"/>
                        <rich:extendedDataTable rows="200" id="idTableDiag" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" height="450px" width="100%" style="border:solid 1px green" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.dataModelDiagnostic}" var="diag" >
                            <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.selectionDiagnostic}" reRender="diag,lib1,idValCim"/>
                            <rich:column  width="10%" sortable="true" sortBy="#{diag.cimCodeCmd}" >
                                <f:facet name="header"><h:outputText  value="Code CMD"/></f:facet>
                                <h:outputText value="#{diag.cimCodeCmd}"/>
                            </rich:column>
                            <rich:column  width="30%" sortable="true" sortBy="#{diag.cimLibCmd}" >
                                <f:facet name="header"><h:outputText  value="Libellé CMD"/></f:facet>
                                <h:inputTextarea value="#{diag.cimLibCmd}" rows="2" readonly="true" style="width:100%"/>
                            </rich:column>
                            <rich:column  width="10%" sortable="true" sortBy="#{diag.cimCode}" >
                                <f:facet name="header"><h:outputText  value="Code CIM"/></f:facet>
                                <h:outputText value="#{diag.cimCode}"/>
                            </rich:column>
                            <rich:column width="30%" sortable="true" sortBy="#{diag.cimLibelleFR}">
                                <f:facet name="header"><h:outputText  value="Libellé CIM"/></f:facet>
                                <h:inputTextarea  value="#{diag.cimLibelleFR}" rows="2" readonly="true" style="width:100%"/>
                            </rich:column>
                            <rich:column width="20%" sortable="true" sortBy="#{diag.cimLibelleUK}">
                                <f:facet name="header"><h:outputText  value="Raccourci personnel"/></f:facet>
                                <h:inputText value="#{diag.cimLibelleUK}" style="width:100%">
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.majRaccourciPersonnel}" />
                                </h:inputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
                <br>
                <h:panelGroup id="idValCim">
                    <center>
                        <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.annuleDiagostic}" reRender="panelDiagnostic"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.calculeDiagnostic}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.cimMedical.cimId!=0}" reRender="panelDiagnostic,diag,diag2"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelListeProduits" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.showModalPanelProduits}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.showModalPanelProduits}" var="prd">
            <f:facet name="header"><h:outputText value="Sélection du produit"/></f:facet>
            <a4j:form id="formModalListeProduits">
                <rich:hotKey key="return" handler="return false;"/>
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable2" maxPages="20"align="left" for="tableProd"/>
                    <rich:extendedDataTable rows="200" id="tableProd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.datamodelProduits}"  var="prd">
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.choixPanenProd==3}" var="cas1">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.selectionLaboratoire}" reRender="valprd3"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.choixPanenProd==4}" var="cas2">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.selectionPharmacie}" reRender="valprd4"/>
                        </c:if>
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
                <h:panelGroup id="valprd3" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.choixPanenProd==3}">
                    <center>
                        <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.annulerLaboratoire}" reRender="panelListeProduits,ligneLabo"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.validerLaboratoire}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.produits.proId!=0}" reRender="panelListeProduits,ligneLabo"/>
                    </center>
                </h:panelGroup>
                <h:panelGroup id="valprd4" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.choixPanenProd==4}">
                    <center>
                        <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.annulerPharmacie}" reRender="panelListeProduits,lignePharmacie"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.validerPharmacie}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.produits.proId!=0}" reRender="panelListeProduits,lignePharmacie"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelListeMedicamment" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="1000" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.showModalPanelMedicamment}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.showModalPanelMedicamment}" var="med">
            <f:facet name="header"><h:outputText value="Sélection du médicamment (Le Mayité)"/></f:facet>
            <a4j:form id="formModalListeMedicamment">
                <rich:hotKey key="return" handler="return false;"/>
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable3" maxPages="20"align="left" for="tableMed"/>
                    <rich:extendedDataTable rows="200" id="tableMed" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.datamodelProduits}" var="prdmed">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.selectionMedicamment}" reRender="idValMed"/>
                        <rich:column label="CIP" sortable="true" sortBy="#{prdmed.promdcCodeCip}" width="10%">
                            <f:facet name="header"><h:outputText  value="CIP" /></f:facet>
                            <h:outputText value="#{prdmed.promdcCodeCip}"/>
                        </rich:column>
                        <rich:column label="DCI" sortable="true" sortBy="#{prdmed.promdcCodeDci}" width="20%">
                            <f:facet name="header"><h:outputText  value="DCI" /></f:facet>
                            <h:inputTextarea value="#{prdmed.promdcCodeDci}" readonly="true" rows="2" style="width:100%"/>
                        </rich:column>
                        <rich:column label="Spécialité" sortable="true" sortBy="#{prdmed.promdcSpecialite}" width="30%">
                            <f:facet name="header"><h:outputText  value="Spécialité" /></f:facet>
                            <h:inputTextarea value="#{prdmed.promdcSpecialite}" readonly="true" rows="2" style="width:100%"/>
                        </rich:column>
                        <rich:column label="Forme" sortable="true" sortBy="#{prdmed.promdcForme}" width="20%">
                            <f:facet name="header"><h:outputText  value="Forme" /></f:facet>
                            <h:inputTextarea value="#{prdmed.promdcForme}" readonly="true" rows="2" style="width:100%"/>
                        </rich:column>
                        <rich:column label="Classe" sortable="true" sortBy="#{prdmed.promdcClasse}" width="20%">
                            <f:facet name="header"><h:outputText  value="Classe" /></f:facet>
                            <h:inputTextarea value="#{prdmed.promdcClasse}" readonly="true" rows="2" style="width:100%"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
                <br>
                <h:panelGroup id="idValMed">
                    <center>
                        <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.annulerMedicamment}" reRender="panelListeMedicamment,inpMedDet,ligne2"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/detail.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.detailDci}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.produitsMedicamment.promdcId!=0}" reRender="panelDetailDci,formModalDetailDci"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.validerMedicamment}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.produitsMedicamment.promdcId!=0}" reRender="panelListeMedicamment,inpMedDet,ligne2"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelListeActes" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="1000" height="500" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.showModalPanelListeActes}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.showModalPanelListeActes}" var="act">
            <f:facet name="header"><h:outputText value="Sélection de l'acte"/></f:facet>
            <a4j:form id="formModalListeActes">
                <rich:hotKey key="return" handler="return false;"/>
                <rich:tabPanel switchType="client" immediate="true" style="border:0px;">

                    <rich:tab id="ccam" label="Code CCAM" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.afficheActeCCAM}">
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable4" maxPages="20"align="left" for="tableActesCCAM"/>
                            <rich:extendedDataTable rows="200" id="tableActesCCAM" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.datamodelProduitsCCAM}" var="prdact" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.simpleSelectionCCAM}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.extDTableCCAM}">
                                <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.selectionActesCCAM}" reRender="idValAct"/>
                                <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.valideActes}" reRender="panelListeActes,ligne,inpCodDet,panelCreationProduit"/>
                                <rich:column label="Code de l'acte" sortable="true" sortBy="#{prdact.ccamDetCode}" width="10%">
                                    <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                                    <h:outputText value="#{prdact.ccamDetCode}"/>
                                </rich:column>
                                <rich:column label="Libellé de l'acte" sortable="true" sortBy="#{prdact.ccamDetLibFr}" width="30%">
                                    <f:facet name="header"><h:outputText  value="Libellé" /></f:facet>
                                    <h:inputTextarea value="#{prdact.ccamDetLibFr}" readonly="true" rows="2" style="width:100%"/>
                                </rich:column>
                                <rich:column label="Famille" sortable="true" sortBy="#{prdact.ccamFamLibFr}" width="20%">
                                    <f:facet name="header"><h:outputText  value="Famille" /></f:facet>
                                    <h:inputTextarea value="#{prdact.ccamFamLibFr}" readonly="true" rows="2" style="width:100%"/>
                                </rich:column>
                                <rich:column label="Sous famille" sortable="true" sortBy="#{prdact.ccamSfamLibFr}" width="20%">
                                    <f:facet name="header"><h:outputText  value="Sous famille" /></f:facet>
                                    <h:inputTextarea value="#{prdact.ccamSfamLibFr}" readonly="true" rows="2" style="width:100%"/>
                                </rich:column>
                                <rich:column label="Sous Sous famille" sortable="true" sortBy="#{prdact.ccamSsfamLibFr}" width="20%">
                                    <f:facet name="header"><h:outputText  value="Sous Sous famille" /></f:facet>
                                    <h:inputTextarea value="#{prdact.ccamSsfamLibFr}" readonly="true" rows="2" style="width:100%"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </rich:tab>

                    <rich:tab id="ngap" label="Code NGAP" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.afficheActeNGAP}">
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable6" maxPages="20"align="left" for="tableActesNGAP"/>
                            <rich:extendedDataTable rows="200" id="tableActesNGAP" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.datamodelProduitsNGAP}" var="prdact" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.simpleSelectionNGAP}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.extDTableNGAP}">
                                <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.selectionActesNGAP}" reRender="idValAct"/>
                                <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.valideActes}" reRender="panelListeActes,ligne,inpCodDet,panelCreationProduit"/>
                                <rich:column label="Code de l'acte" sortable="true" sortBy="#{prdact.ngaDetCode}" width="10%">
                                    <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                                    <h:outputText value="#{prdact.ngaDetCode}"/>
                                </rich:column>
                                <rich:column label="Libellé de l'acte" sortable="true" sortBy="#{prdact.ngaDetLibelleFr}" width="30%">
                                    <f:facet name="header"><h:outputText  value="Libellé" /></f:facet>
                                    <h:inputTextarea value="#{prdact.ngaDetLibelleFr}" readonly="true" rows="2" style="width:100%"/>
                                </rich:column>
                                <rich:column label="Famille" sortable="true" sortBy="#{prdact.ngaFamLibFr}" width="20%">
                                    <f:facet name="header"><h:outputText  value="Famille" /></f:facet>
                                    <h:inputTextarea value="#{prdact.ngaFamLibFr}" readonly="true" rows="2" style="width:100%"/>
                                </rich:column>
                                <rich:column label="Sous famille" sortable="true" sortBy="#{prdact.ngaSfamLibFr}" width="20%">
                                    <f:facet name="header"><h:outputText  value="Sous famille" /></f:facet>
                                    <h:inputTextarea value="#{prdact.ngaSfamLibFr}" readonly="true" rows="2" style="width:100%"/>
                                </rich:column>
                                <rich:column label="Sous Sous famille" sortable="true" sortBy="#{prdact.ngaSsfamLibFr}" width="20%">
                                    <f:facet name="header"><h:outputText  value="Sous Sous famille" /></f:facet>
                                    <h:inputTextarea value="#{prdact.ngaSsfamLibFr}" readonly="true" rows="2" style="width:100%"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </rich:tab>

                    <rich:tab id="perso" label="Code Personnel" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.afficheActeCP}">
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable5" maxPages="20"align="left" for="tableActesCP"/>
                            <rich:extendedDataTable rows="200" id="tableActesCP" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.datamodelProduits}"  var="prd" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.simpleSelectionProduits}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.extDTableProduits}">
                                <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.selectionActesCP}" reRender="idValAct"/>
                                <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.valideActes}" reRender="panelListeActes,ligne,inpCodDet,panelCreationProduit"/>
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
                    </rich:tab>

                </rich:tabPanel>
                <br>
                <h:panelGroup id="idValAct">
                    <center>
                        <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.annuleActes}" reRender="panelListeActes,ligne1,inpCodDet"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.valideActes}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.produits.proId!=0||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.ccamMedical.ccamId!=0||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.ngapMedical.ngaId!=0}" reRender="panelListeActes,ligne,inpCodDet,panelCreationProduit"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelCreationProduit" headerClass="headerPanel" width="800" height="550" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.showModalPanelCreationActe}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.showModalPanelCreationActe}" var="detprd">
            <f:facet name="header"><h:outputText value="CREATION DU PRODUIT"></h:outputText></f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  width="100%" id="formModalCreationProduit">
                    <h:panelGrid columns="2" columnClasses="clos25,clos75" width="100%">
                        <h:column><h:outputText value="Code CCAM:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.ccamMedical.ccamDetCode}" readonly="true" disabled="true"/></h:column>
                        <h:column><h:outputText value="Libellé CCAM:"/></h:column>
                        <h:column><h:inputTextarea style="width:100%;" rows="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.ccamMedical.ccamDetLibFr}" readonly="true" disabled="true"/></h:column>
                        <h:column><h:outputText value="Libellé Produit:"/></h:column>
                        <h:column><h:inputTextarea style="width:100%;" rows="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.produits.proLibClient}"/></h:column>
                        <h:column><h:outputText value="Famille:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idFamille" style="width:600px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.inpCodeFamille}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesFamillesActesItems}"/>
                                <a4j:support eventsQueue="maQueue"  event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.calculeFamille}" reRender="idValProduit"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Lettre:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idLettre" style="width:600px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.lettreActe}">
                                <f:selectItem itemLabel="Sélectionnez une lettre" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesLettresItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.calculeTarif}" reRender="tableTarif,idValProduit" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Nombre de Lettres:"/></h:column>
                        <h:column><h:inputText style="width:50%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.produits.proNbUnite}"/></h:column>
                        <h:column><h:outputText value="Tarification:"/></h:column>
                        <h:column>
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable id="tableTarif" enableContextMenu="false" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.lesTarifs}" var="prdtar">
                                    <rich:column label="Catégorie" sortable="false" width="70%">
                                        <f:facet name="header"><h:outputText  value="Catégorie" /></f:facet>
                                        <h:outputText value="#{prdtar.protarOrdre} #{prdtar.protarClient}"/>
                                    </rich:column>
                                    <rich:column label="Coefficient" sortable="false" width="10%">
                                        <f:facet name="header"><h:outputText  value="Coef." /></f:facet>
                                        <h:inputText value="#{prdtar.protarCoef}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:inputText>
                                    </rich:column>
                                    <rich:column label="Prix unitaire" sortable="false" width="20%" style="text-align:right;">
                                        <f:facet name="header"><h:outputText  value="Valeur" /></f:facet>
                                        <h:inputText value="#{prdtar.protarPv}" readonly="true" style="text-align:right;width:90%">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br>
                <h:panelGroup id="idValProduit">
                    <center>
                        <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.fermerValidesProduit}" reRender="panelCreationProduit"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.validesProduit}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.produits.proVteCode!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.lettreActe!=null}" reRender="panelCreationProduit,panelListeActes,ligne,inpCodDet"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panalVisuPj" width="1100" height="600" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.showModalPanelPj}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.showModalPanelPj}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="Visualisation du fichier PDF"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.supprimerDocumentScan}" image="/images/supprimer.png" styleClass="hidelink" reRender="modAttente,panalVisuPj,listeDoc" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_aff_action}"/>&nbsp;&nbsp;
                    <h:column>
                        <a type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.fichierMine}" href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.fichierUrl}" target="_blank" title="Lire document"><img src="images/detail.png" alt="lecture"></a>
                    </h:column>&nbsp;&nbsp;
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.fermerVisuDocumentScan}" image="/images/close.gif" styleClass="hidelink" reRender="panalVisuPj"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%">
                    <object data="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.fichierUrl}" type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.fichierMine}" width="100%" height="550">
                        <a href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.fichierUrl}"></a>
                    </object>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panalAjoutFile" width="500" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.showModalPanelAjoutFile}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.showModalPanelAjoutFile}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="UPLOADER DES DOCUMENTS DANS LE DOSSIER MEDICAL"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.annulerDocumentScan}" image="/images/close.gif" styleClass="hidelink" reRender="panalAjoutFile"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%" headerClass="headerTab" styleClass="panneau_accueil">
                    <h:panelGrid style="width:100%;">
                        <h:outputLabel value="Nom du document" />
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.nomDocument}" maxlength="20"/></h:column>
                        <h:outputLabel for="idDoc" value="Ajoutez un document" />
                        <t:inputFileUpload id="idDoc" accept="application/pdf" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.uploadedPDFFile}"/>
                        <br>
                        <h:panelGroup>
                            <center>
                                <h:commandButton styleClass="exp_lienmenu" value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.validerDocumentScan}"/>
                            </center>
                        </h:panelGroup>
                        <br>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
