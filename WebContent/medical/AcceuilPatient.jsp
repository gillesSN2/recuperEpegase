<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="medicRdvMulti">

    <a4j:form>

        <center> <h2>
                <h:outputText id="idTitre" value="Le planning du service : " style="color:green;"/>
                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.serviceSelectionne}" style="width:200px">
                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.lesServicesItems}"/>
                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.selectionService}" reRender="idTableUsers,p1,idTitre"/>
                </h:selectOneMenu>
            </h2></center>

        <rich:tabPanel switchType="client" selectedTab="jour" immediate="true" id="p1" tabClass="text" width="100%" style="height:400px;margin-top:0px;border:0;">

            <rich:tab name="mois" label="Par Mois">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.modeMois}"/>
                <h:panelGrid columns="11">
                    <a4j:commandButton title="Mois précédent" image="/images/precedent.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.chargerLesRdvByMoisPrecedent}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRdv1,idDateMois"/>
                    <h:column>
                        <rich:calendar style=" background-color:white;text-align:center" id="idDateMois" locale="FR" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.parMois}"  datePattern="MM/yyyy" inputSize="8" enableManualInput="false"/>
                    </h:column>
                    <a4j:commandButton title="Mois suivant" image="/images/suivant.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.chargerLesRdvByMoisSuivant}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRdv1,idDateMois"/>
                    <h:column> <h:outputText value="Nature:"/></h:column>
                    <h:column>
                        <h:selectOneMenu  style="width:150px"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.valNatMois}"  >
                            <f:selectItem itemLabel="Toutes les natures" itemValue="99"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.mesNaturesRdvItems}"/>
                        </h:selectOneMenu>
                    </h:column>&nbsp;&nbsp;
                    <a4j:commandButton value="Rechercher" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.chargerLesRdvByMois}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRdv1,idDateMois"/>&nbsp;&nbsp;
                    <a4j:commandButton title="Imprimer le Mois" image="/images/print.png" reRender="panelImp,formModalImp,panchoixdoc,panelMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.initImpression}"/>
                </h:panelGrid><br>
                <rich:dataTable  styleClass="bg" id="tableRdv1" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" border="0" width="100%" style="height:500px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.datamodelLesRdvParMois}" var="rdv">
                    <rich:column  width="2%" style="height: 70px;" sortable="false" >
                        <f:facet name="header" ><h:outputText value="N°"/></f:facet>
                        <h:outputText value="#{rdv.num_sem}"/>
                    </rich:column>
                    <rich:column  width="14%" style="height: 70px;" sortable="false" >
                        <f:facet name="header" ><h:outputText value="Lundi"/></f:facet>
                        <h:outputText value="#{rdv.lundi}" styleClass="textAligneCalendar"/>&nbsp;&nbsp;
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.ajouterRdvCol01}" reRender="panelEvent" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche01&&rdv.lundi!=''}"/><br>
                        <rich:dataTable value="#{rdv.dataModelLundi}" var="rdvlundi" id="idrdvlundi" width="100%" border="0" onRowMouseOver="this.style.backgroundColor='#A1A1A1'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.modifierRdvCol01}" reRender="panelEvent"/>
                            <rich:column  width="20%">
                                <h:outputText value="#{rdvlundi.rdvHrDe}:#{rdvlundi.rdvMnDe}" style="#{rdvlundi.color}"/>
                            </rich:column>
                            <rich:column  width="70%">
                                <h:outputText value="#{rdvlundi.texteAffiche}" style="#{rdvlundi.color}"/>
                            </rich:column>
                            <rich:column width="10%">
                                <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.supprimerRdvCol01}" reRender="idrdvlundi" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche01&&rdvlundi.rdvEtat==0}"/>
                                <h:graphicImage alt="Traité" height="10" width="10" value="/images/valider.png" rendered="#{rdvlundi.rdvEtat==1}" style="text-align:center"/>
                                <h:graphicImage alt="Reporté" height="13" width="13" value="/images/transferer.png" rendered="#{rdvlundi.rdvEtat==2}" style="text-align:center"/>
                                <h:graphicImage alt="Annulé" height="10" width="10" value="/images/annuler.gif" rendered="#{rdvlundi.rdvEtat==3}" style="text-align:center"/>
                            </rich:column>
                        </rich:dataTable>
                    </rich:column>
                    <rich:column width="14%" style="height: 70px;" sortable="false">
                        <f:facet name="header" ><h:outputText value="Mardi"/></f:facet>
                        <h:outputText value="#{rdv.mardi}" styleClass="textAligneCalendar"/>&nbsp;&nbsp;
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.ajouterRdvCol02}" reRender="panelEvent" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche02&&rdv.mardi!=''}"/><br>
                        <rich:dataTable value="#{rdv.dataModelMardi}" var="rdvmardi" id="idrdvmardi" width="100%" border="0" onRowMouseOver="this.style.backgroundColor='#A1A1A1'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.modifierRdvCol02}" reRender="panelEvent"/>
                            <rich:column  width="20%">
                                <h:outputText value="#{rdvmardi.rdvHrDe}:#{rdvmardi.rdvMnDe}" style="#{rdvmardi.color}"/>
                            </rich:column>
                            <rich:column  width="70%">
                                <h:outputText value="#{rdvmardi.texteAffiche}" style="#{rdvmardi.color}"/>
                            </rich:column>
                            <rich:column width="10%">
                                <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.supprimerRdvCol02}" reRender="idrdvmardi" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche02&&rdvmardi.rdvEtat==0}"/>
                                <h:graphicImage alt="Traité" height="10" width="10" value="/images/valider.png" rendered="#{rdvmardi.rdvEtat==1}" style="text-align:center"/>
                                <h:graphicImage alt="Reporté" height="13" width="13" value="/images/transferer.png" rendered="#{rdvmardi.rdvEtat==2}" style="text-align:center"/>
                                <h:graphicImage alt="Annulé" height="10" width="10" value="/images/annuler.gif" rendered="#{rdvmardi.rdvEtat==3}" style="text-align:center"/>
                            </rich:column>
                        </rich:dataTable>
                    </rich:column>
                    <rich:column width="14%" style="height: 70px;"  sortable="false" >
                        <f:facet name="header" ><h:outputText value="Mercredi"/></f:facet>
                        <h:outputText value="#{rdv.mercredi}" styleClass="textAligneCalendar"/>&nbsp;&nbsp;
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.ajouterRdvCol03}" reRender="panelEvent" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche03&&rdv.mercredi!=''}"/><br>
                        <rich:dataTable value="#{rdv.dataModelMercredi}" var="rdvmercredi" id="idrdvmercredi" width="100%" border="0" onRowMouseOver="this.style.backgroundColor='#A1A1A1'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.modifierRdvCol03}" reRender="panelEvent"/>
                            <rich:column  width="20%">
                                <h:outputText value="#{rdvmercredi.rdvHrDe}:#{rdvmercredi.rdvMnDe}" style="#{rdvmercredi.color}"/>
                            </rich:column>
                            <rich:column  width="70%">
                                <h:outputText value="#{rdvmercredi.texteAffiche}" style="#{rdvmercredi.color}"/>
                            </rich:column>
                            <rich:column width="10%">
                                <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.supprimerRdvCol03}" reRender="idrdvmercredi" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche03&&rdvmercredi.rdvEtat==0}"/>
                                <h:graphicImage alt="Traité" height="10" width="10" value="/images/valider.png" rendered="#{rdvmercredi.rdvEtat==1}" style="text-align:center"/>
                                <h:graphicImage alt="Reporté" height="13" width="13" value="/images/transferer.png" rendered="#{rdvmercredi.rdvEtat==2}" style="text-align:center"/>
                                <h:graphicImage alt="Annulé" height="10" width="10" value="/images/annuler.gif" rendered="#{rdvmercredi.rdvEtat==3}" style="text-align:center"/>
                            </rich:column>
                        </rich:dataTable>
                    </rich:column>
                    <rich:column width="14%" style="height: 70px;"  sortable="false">
                        <f:facet name="header" ><h:outputText value="Jeudi"/></f:facet>
                        <h:outputText value="#{rdv.jeudi}" styleClass="textAligneCalendar"/>&nbsp;&nbsp;
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.ajouterRdvCol04}" reRender="panelEvent" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche04&&rdv.jeudi!=''}"/><br>
                        <rich:dataTable value="#{rdv.dataModelJeudi}" var="rdvjeudi" id="idrdvjeudi" width="100%" border="0" onRowMouseOver="this.style.backgroundColor='#A1A1A1'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.modifierRdvCol04}" reRender="panelEvent"/>
                            <rich:column width="20%">
                                <h:outputText value="#{rdvjeudi.rdvHrDe}:#{rdvjeudi.rdvMnDe}" style="#{rdvjeudi.color}"/>
                            </rich:column>
                            <rich:column width="70%">
                                <h:outputText value="#{rdvjeudi.texteAffiche}" style="#{rdvjeudi.color}"/>
                            </rich:column>
                            <rich:column width="10%">
                                <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.supprimerRdvCol04}" reRender="idrdvjeudi" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche04&&rdvjeudi.rdvEtat==0}"/>
                                <h:graphicImage alt="Traité" height="10" width="10" value="/images/valider.png" rendered="#{rdvjeudi.rdvEtat==1}" style="text-align:center"/>
                                <h:graphicImage alt="Reporté" height="13" width="13" value="/images/transferer.png" rendered="#{rdvjeudi.rdvEtat==2}" style="text-align:center"/>
                                <h:graphicImage alt="Annulé" height="10" width="10" value="/images/annuler.gif" rendered="#{rdvjeudi.rdvEtat==3}" style="text-align:center"/>
                            </rich:column>
                        </rich:dataTable>
                    </rich:column>
                    <rich:column width="14%" style="height: 70px;"  sortable="false">
                        <f:facet name="header" ><h:outputText value="Vendredi"/></f:facet>
                        <h:outputText value="#{rdv.vendredi}" styleClass="textAligneCalendar"/>&nbsp;&nbsp;
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.ajouterRdvCol05}" reRender="panelEvent" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche05&&rdv.vendredi!=''}"/><br>
                        <rich:dataTable value="#{rdv.dataModelVendredi}" var="rdvvendredi" id="idrdvvendredi" width="100%" border="0" onRowMouseOver="this.style.backgroundColor='#A1A1A1'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.modifierRdvCol05}" reRender="panelEvent"/>
                            <rich:column  width="20%">
                                <h:outputText value="#{rdvvendredi.rdvHrDe}:#{rdvvendredi.rdvMnDe}" style="#{rdvvendredi.color}"/>
                            </rich:column>
                            <rich:column  width="70%">
                                <h:outputText value="#{rdvvendredi.texteAffiche}" style="#{rdvvendredi.color}"/>
                            </rich:column>
                            <rich:column width="10%">
                                <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.supprimerRdvCol05}" reRender="idrdvvendredi" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche05&&rdvvendredi.rdvEtat==0}"/>
                                <h:graphicImage alt="Traité" height="10" width="10" value="/images/valider.png" rendered="#{rdvvendredi.rdvEtat==1}" style="text-align:center"/>
                                <h:graphicImage alt="Reporté" height="13" width="13" value="/images/transferer.png" rendered="#{rdvvendredi.rdvEtat==2}" style="text-align:center"/>
                                <h:graphicImage alt="Annulé" height="10" width="10" value="/images/annuler.gif" rendered="#{rdvvendredi.rdvEtat==3}" style="text-align:center"/>
                            </rich:column>
                        </rich:dataTable>
                    </rich:column>
                    <rich:column width="14%" style="height: 70px;"  sortable="false">
                        <f:facet name="header" ><h:outputText value="Samedi" style="color:red;"/></f:facet>
                        <h:outputText value="#{rdv.samedi}" styleClass="textAligneCalendar" style="color:red;"/>&nbsp;&nbsp;
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.ajouterRdvCol06}" reRender="panelEvent" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche06&&rdv.samedi!=''}"/><br>
                        <rich:dataTable value="#{rdv.dataModelSamedi}" var="rdvsamedi" id="idrdvsamedi" width="100%" border="0" onRowMouseOver="this.style.backgroundColor='#A1A1A1'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.modifierRdvCol06}" reRender="panelEvent"/>
                            <rich:column  width="20%">
                                <h:outputText value="#{rdvsamedi.rdvHrDe}:#{rdvsamedi.rdvMnDe}" style="#{rdvsamedi.color}"/>
                            </rich:column>
                            <rich:column  width="70%">
                                <h:outputText value="#{rdvsamedi.texteAffiche}" style="#{rdvsamedi.color}"/>
                            </rich:column>
                            <rich:column width="10%">
                                <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.supprimerRdvCol06}" reRender="idrdvsamedi" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche06&&rdvsamedi.rdvEtat==0}"/>
                                <h:graphicImage alt="Traité" height="10" width="10" value="/images/valider.png" rendered="#{rdvsamedi.rdvEtat==1}" style="text-align:center"/>
                                <h:graphicImage alt="Reporté" height="13" width="13" value="/images/transferer.png" rendered="#{rdvsamedi.rdvEtat==2}" style="text-align:center"/>
                                <h:graphicImage alt="Annulé" height="10" width="10" value="/images/annuler.gif" rendered="#{rdvsamedi.rdvEtat==3}" style="text-align:center"/>
                            </rich:column>
                        </rich:dataTable>
                    </rich:column>
                    <rich:column width="14%" style="height: 70px;"  sortable="false">
                        <f:facet name="header" ><h:outputText value="Dimanche" style="color:red;"/></f:facet>
                        <h:outputText value="#{rdv.dimanche}" styleClass="textAligneCalendar" style="color:red;"/>&nbsp;&nbsp;
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.ajouterRdvCol07}" reRender="panelEvent" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche07&&rdv.dimanche!=''}"/><br>
                        <rich:dataTable value="#{rdv.dataModelDimanche}" var="rdvdimanche" id="idrdvdimanche" width="100%" border="0" onRowMouseOver="this.style.backgroundColor='#A1A1A1'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.modifierRdvCol07}" reRender="panelEvent"/>
                            <rich:column  width="20%">
                                <h:outputText value="#{rdvdimanche.rdvHrDe}:#{rdvdimanche.rdvMnDe}" style="#{rdvdimanche.color}"/>
                            </rich:column>
                            <rich:column  width="70%">
                                <h:outputText value="#{rdvdimanche.texteAffiche}" style="#{rdvdimanche.color}"/>
                            </rich:column>
                            <rich:column width="10%">
                                <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.supprimerRdvCol07}" reRender="idrdvdimanche" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche07&&rdvdimanche.rdvEtat==0}"/>
                                <h:graphicImage alt="Traité" height="10" width="10" value="/images/valider.png" rendered="#{rdvdimanche.rdvEtat==1}" style="text-align:center"/>
                                <h:graphicImage alt="Reporté" height="13" width="13" value="/images/transferer.png" rendered="#{rdvdimanche.rdvEtat==2}" style="text-align:center"/>
                                <h:graphicImage alt="Annulé" height="10" width="10" value="/images/annuler.gif" rendered="#{rdvdimanche.rdvEtat==3}" style="text-align:center"/>
                            </rich:column>
                        </rich:dataTable>
                    </rich:column>
                </rich:dataTable>
            </rich:tab>

            <rich:tab name="semaine" label="Par Semaine">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.modeSemaine}"/>
                <h:panelGrid columns="11">
                    <a4j:commandButton title="Semaine précédente" image="/images/precedent.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.chargerLesRdvBySemainePrecedent}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRdv2,idDateSemaine"/>
                    <h:column>
                        <rich:calendar style=" background-color:white;" id="idDateSemaine" locale="FR" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.parSemaine}" datePattern="dd/MM/yyyy"  inputSize="8" enableManualInput="false"/>
                    </h:column>
                    <a4j:commandButton title="Semaine suivante" image="/images/suivant.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.chargerLesRdvBySemaineSuivant}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRdv2,idDateSemaine"/>
                    <h:column><h:outputText value="Nature:"/></h:column>
                    <h:column>
                        <h:selectOneMenu  style="width:150px"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.valNatSemaine}"  >
                            <f:selectItem itemLabel="Toutes les natures" itemValue="99"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.mesNaturesRdvItems}"/>
                        </h:selectOneMenu>
                    </h:column>&nbsp;&nbsp;
                    <a4j:commandButton value="Rechercher" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.chargerLesRdvBySemaine}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRdv2,idDateSemaine"/>&nbsp;&nbsp;
                    <a4j:commandButton title="Imprimer la Semaine" image="/images/print.png" reRender="panelImp,formModalImp,panchoixdoc,panelMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.initImpression}"/>
                </h:panelGrid> <br>
                <rich:dataTable  styleClass="bg" id="tableRdv2" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" border="0" width="100%" style="height:500px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.datamodelLesRdvParSemaine}" var="rdv" >
                    <rich:column  width="9%"    sortable="false" sortOrder="ASCENDING">
                        <f:facet name="header" ><h:outputText value="Heure"/></f:facet>
                        <h:outputText value="#{rdv.heure}" style="font-weight:bold;"/>
                    </rich:column>
                    <rich:column  width="13%" sortable="false">
                        <f:facet name="header"><h:outputText value="Lundi #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.dateLun}"/></f:facet>
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.ajouterRdvCol01Semaine}" reRender="panelEvent" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche01}"/>&nbsp;
                        <h:commandLink value="#{rdv.lundi}" immediate="true" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.modifierRdvCol01Semaine}" rel="false"/>&nbsp;
                        <h:column>
                            <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.supprimerRdvCol01Semaine}" reRender="idrdvlundi" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche01Sup&&rdv.rdvEtatLundi==0}"/>
                            <h:graphicImage alt="Traité" height="10" width="10" value="/images/valider.png" rendered="#{rdv.rdvEtatLundi==1}" style="text-align:center"/>
                            <h:graphicImage alt="Reporté" height="13" width="13" value="/images/transferer.png" rendered="#{rdv.rdvEtatLundi==2}" style="text-align:center"/>
                            <h:graphicImage alt="Annulé" height="10" width="10" value="/images/annuler.gif" rendered="#{rdv.rdvEtatLundi==3}" style="text-align:center"/>
                        </h:column>
                    </rich:column>
                    <rich:column width="13%" sortable="false" id="idMardiSemaine">
                        <f:facet name="header" ><h:outputText value="Mardi #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.dateMar}"/></f:facet>
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.ajouterRdvCol02Semaine}" reRender="panelEvent" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche02}"/>&nbsp;
                        <h:commandLink value="#{rdv.mardi}" immediate="true" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.modifierRdvCol02Semaine}" rel="false"/>&nbsp;
                        <h:column>
                            <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.supprimerRdvCol02Semaine}" reRender="idMardiSemaine" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche02Sup&&rdv.rdvEtatMardi==0}"/>
                            <h:graphicImage alt="Traité" height="10" width="10" value="/images/valider.png" rendered="#{rdv.rdvEtatMardi==1}" style="text-align:center"/>
                            <h:graphicImage alt="Reporté" height="13" width="13" value="/images/transferer.png" rendered="#{rdv.rdvEtatMardi==2}" style="text-align:center"/>
                            <h:graphicImage alt="Annulé" height="10" width="10" value="/images/annuler.gif" rendered="#{rdv.rdvEtatMardi==3}" style="text-align:center"/>
                        </h:column>
                    </rich:column>
                    <rich:column width="13%" sortable="false" >
                        <f:facet name="header" ><h:outputText value="Mercredi #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.dateMer}"/></f:facet>
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.ajouterRdvCol03Semaine}" reRender="panelEvent" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche03}"/>&nbsp;
                        <h:commandLink value="#{rdv.mercredi}" immediate="true" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.modifierRdvCol03Semaine}" rel="false"/>&nbsp;
                        <h:column>
                            <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.supprimerRdvCol03Semaine}" reRender="idrdvmercredi" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche03Sup&&rdv.rdvEtatMercredi==0}"/>
                            <h:graphicImage alt="Traité" height="10" width="10" value="/images/valider.png" rendered="#{rdv.rdvEtatMercredi==1}" style="text-align:center"/>
                            <h:graphicImage alt="Reporté" height="13" width="13" value="/images/transferer.png" rendered="#{rdv.rdvEtatMercredi==2}" style="text-align:center"/>
                            <h:graphicImage alt="Annulé" height="10" width="10" value="/images/annuler.gif" rendered="#{rdv.rdvEtatMercredi==3}" style="text-align:center"/>
                        </h:column>
                    </rich:column>
                    <rich:column width="13%" sortable="false">
                        <f:facet name="header" ><h:outputText value="Jeudi #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.dateJeu}"/></f:facet>
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.ajouterRdvCol04Semaine}" reRender="panelEvent" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche04}"/>&nbsp;
                        <h:commandLink value="#{rdv.jeudi}" immediate="true" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.modifierRdvCol04Semaine}" rel="false"/>&nbsp;
                        <h:column>
                            <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.supprimerRdvCol04Semaine}" reRender="idrdvjeudi" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche04Sup&&rdv.rdvEtatJeudi==0}"/>
                            <h:graphicImage alt="Traité" height="10" width="10" value="/images/valider.png" rendered="#{rdv.rdvEtatJeudi==1}" style="text-align:center"/>
                            <h:graphicImage alt="Reporté" height="13" width="13" value="/images/transferer.png" rendered="#{rdv.rdvEtatJeudi==2}" style="text-align:center"/>
                            <h:graphicImage alt="Annulé" height="10" width="10" value="/images/annuler.gif" rendered="#{rdv.rdvEtatJeudi==3}" style="text-align:center"/>
                        </h:column>
                    </rich:column>
                    <rich:column width="13%" sortable="false">
                        <f:facet name="header" ><h:outputText value="Vendredi #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.dateVen}"/></f:facet>
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.ajouterRdvCol05Semaine}" reRender="panelEvent" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche05}"/>&nbsp;
                        <h:commandLink value="#{rdv.vendredi}" immediate="true" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.modifierRdvCol05Semaine}" rel="false"/>&nbsp;
                        <h:column>
                            <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.supprimerRdvCol05Semaine}" reRender="idrdvvendredi" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche05Sup&&rdv.rdvEtatVendredi==0}"/>
                            <h:graphicImage alt="Traité" height="10" width="10" value="/images/valider.png" rendered="#{rdv.rdvEtatVendredi==1}" style="text-align:center"/>
                            <h:graphicImage alt="Reporté" height="13" width="13" value="/images/transferer.png" rendered="#{rdv.rdvEtatVendredi==2}" style="text-align:center"/>
                            <h:graphicImage alt="Annulé" height="10" width="10" value="/images/annuler.gif" rendered="#{rdv.rdvEtatVendredi==3}" style="text-align:center"/>
                        </h:column>
                    </rich:column>
                    <rich:column width="13%" sortable="false">
                        <f:facet name="header" ><h:outputText value="Samedi #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.dateSam}" style="color:red;"/></f:facet>
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.ajouterRdvCol06Semaine}" reRender="panelEvent" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche06}"/>&nbsp;
                        <h:commandLink value="#{rdv.samedi}" immediate="true" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.modifierRdvCol06Semaine}" rel="false"/>&nbsp;
                        <h:column>
                            <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.supprimerRdvCol06Semaine}" reRender="idrdvsamedi" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche06Sup&&rdv.rdvEtatSamedi==0}"/>
                            <h:graphicImage alt="Traité" height="10" width="10" value="/images/valider.png" rendered="#{rdv.rdvEtatSamedi==1}" style="text-align:center"/>
                            <h:graphicImage alt="Reporté" height="13" width="13" value="/images/transferer.png" rendered="#{rdv.rdvEtatSamedi==2}" style="text-align:center"/>
                            <h:graphicImage alt="Annulé" height="10" width="10" value="/images/annuler.gif" rendered="#{rdv.rdvEtatSamedi==3}" style="text-align:center"/>
                        </h:column>
                    </rich:column>
                    <rich:column width="13%" sortable="false">
                        <f:facet name="header" ><h:outputText value="Dimanche #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.dateDim}" style="color:red;"/></f:facet>
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.ajouterRdvCol07Semaine}" reRender="panelEvent" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche07}"/>&nbsp;
                        <h:commandLink value="#{rdv.dimanche}" immediate="true" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.modifierRdvCol07Semaine}" rel="false"/>&nbsp;
                        <h:column>
                            <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.supprimerRdvCol07Semaine}" reRender="idrdvdimanche" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche07Sup&&rdv.rdvEtatDimanche==0}"/>
                            <h:graphicImage alt="Traité" height="10" width="10" value="/images/valider.png" rendered="#{rdv.rdvEtatDimanche==1}" style="text-align:center"/>
                            <h:graphicImage alt="Reporté" height="13" width="13" value="/images/transferer.png" rendered="#{rdv.rdvEtatDimanche==2}" style="text-align:center"/>
                            <h:graphicImage alt="Annulé" height="10" width="10" value="/images/annuler.gif" rendered="#{rdv.rdvEtatDimanche==3}" style="text-align:center"/>
                        </h:column>
                    </rich:column>
                </rich:dataTable>
            </rich:tab>

            <rich:tab name="jour" label="Par Jour">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.modeJour}"/>
                <h:panelGrid columns="2">
                    <h:panelGrid id="pngBoutonJour" columns="3" width="100px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                        <a4j:commandButton image="/images/ajouter.png" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.ajouterRdvJour}" reRender="panelEvent"/>
                        <a4j:commandButton image="/images/modifier.png" title="Modifier Evènement sélectionné" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.modifierRdvJour}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.afficheRdvJour}" reRender="panelEvent"/>
                        <a4j:commandButton image="/images/supprimer.png" title="Supprimer Evènement sélectionné" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.supprimerRdvJour}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.afficheRdvJour}" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" reRender="pngBoutonJour,tableRdv3"/>
                    </h:panelGrid>
                    <h:panelGrid columns="11">
                        <a4j:commandButton title="Jour précédent" image="/images/precedent.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.chargerLesRdvByJourPrecedent}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRdv3,idDateJour"/>
                        <h:column>
                            <rich:calendar style=" background-color:white;" id="idDateJour" locale="FR" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.parJour}" datePattern="dd/MM/yyyy"  inputSize="8" enableManualInput="false"/>
                        </h:column>
                        <a4j:commandButton title="Jour suivant" image="/images/suivant.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.chargerLesRdvByJourSuivant}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRdv3,idDateJour"/>
                        <h:column><h:outputText value="Nature:"/></h:column>
                        <h:column>
                            <h:selectOneMenu  style="width:150px"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.valNatJour}"  >
                                <f:selectItem itemLabel="Toutes les natures" itemValue="99"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.mesNaturesRdvItems}"/>
                            </h:selectOneMenu>
                        </h:column>&nbsp;&nbsp;
                        <a4j:commandButton value="Rechercher" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.chargerLesRdvByJour}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRdv3,idDateJour"/>&nbsp;&nbsp;
                        <a4j:commandButton title="Imprimer le Jour" image="/images/print.png" reRender="panelImp,formModalImp,panchoixdoc,panelMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.initImpression}"/>
                    </h:panelGrid>
                </h:panelGrid><br>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable  enableContextMenu="false" styleClass="bg" id="tableRdv3" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="500px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.datamodelLesRdvParJour}" var="rdv" >
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.selectionRdvJour}" reRender="pngBoutonJour"/>
                        <rich:column width="80px" sortable="false" sortOrder="ASCENDING">
                            <f:facet name="header" ><h:outputText value="Heure"/></f:facet>
                            <h:outputText value="#{rdv.rdvHrDe}:#{rdv.rdvMnDe}" style="font-weight:bold;"/>&nbsp;
                            <h:graphicImage alt="Traité" height="10" width="10" value="/images/valider.png" rendered="#{rdv.rdvEtat==1}" style="text-align:center"/>
                            <h:graphicImage alt="Reporté" height="13" width="13" value="/images/transferer.png" rendered="#{rdv.rdvEtat==2}" style="text-align:center"/>
                            <h:graphicImage alt="Annulé" height="10" width="10" value="/images/annuler.gif" rendered="#{rdv.rdvEtat==3}" style="text-align:center"/>
                        </rich:column>
                        <rich:column width="10%" sortable="false">
                            <f:facet name="header" ><h:outputText value="Nature"/></f:facet>
                            <h:outputText value="#{rdv.libNature}"/>
                        </rich:column>
                        <rich:column width="20%" sortable="false">
                            <f:facet name="header" ><h:outputText value="Patient"/></f:facet>
                            <h:outputText value="#{rdv.rdvNomPat}"/>
                            <h:outputText value="#{rdv.rdvDiversNom}"/>
                        </rich:column>
                        <rich:column width="20%" sortable="false" >
                            <f:facet name="header" ><h:outputText value="Tache"/></f:facet>
                            <h:outputText value="#{rdv.rdvTache}"/>
                        </rich:column>
                        <rich:column width="30%" sortable="false">
                            <f:facet name="header" ><h:outputText value="Sujet"/></f:facet>
                            <h:outputText value="#{rdv.rdvSujet}"/>
                        </rich:column>
                        <rich:column width="10%" sortable="false">
                            <f:facet name="header" ><h:outputText value="Service"/></f:facet>
                            <h:outputText value="#{rdv.rdvService}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </rich:tab>

            <rich:tab name="parliste" label="Par Liste">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.modeListe}"/>
                <h:panelGrid columns="2">
                    <h:panelGrid id="pngBouton" columns="3" width="100px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                        <a4j:commandButton image="/images/ajouter.png" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.ajouterRdv}" reRender="panelEvent"/>
                        <a4j:commandButton image="/images/modifier.png" title="Modifier Evènement sélectionné" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.modifierRdv}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.afficheRdv}" reRender="panelEvent"/>
                        <a4j:commandButton image="/images/supprimer.png" title="Supprimer Evènement sélectionné" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.supprimerRdv}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.afficheRdv}" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" reRender="pngBouton,tableRdv4"/>
                    </h:panelGrid>
                    <h:panelGrid columns="12">
                        <h:outputText value="Du"/>
                        <rich:calendar style="background-color:white;" locale="FR" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.jourDeb}"  enableManualInput="true" datePattern="dd/MM/yyyy"  inputSize="8" />
                        <h:outputText value="Au"/>
                        <rich:calendar style=" background-color:white;" locale="FR" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.jourFin}"  enableManualInput="true" datePattern="dd/MM/yyyy"  inputSize="8" />
                        <h:column> <h:outputText value="Nature:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:150px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.valNatListe}"  >
                                <f:selectItem itemLabel="Toutes les natures" itemValue="99"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.mesNaturesRdvItems}"/>
                            </h:selectOneMenu>
                        </h:column>&nbsp;&nbsp;
                        <a4j:commandButton value="Rechercher" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.chargerLesRdv}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRdv4"/>&nbsp;&nbsp;
                        <a4j:commandButton title="Imprimer la Liste" image="/images/print.png" reRender="panelImp,formModalImp,panchoixdoc,panelMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.initImpression}"/>
                    </h:panelGrid>
                </h:panelGrid>
                <br>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable  enableContextMenu="false" styleClass="bg" id="tableRdv4" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="495px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.datamodelRdv}" var="rdv" >
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.selectionRdv}" reRender="pngBouton"/>
                        <rich:column width="8%" sortable="true" sortBy="#{rdv.libNature}">
                            <f:facet name="header" ><h:outputText value="Nature"/></f:facet>
                            <h:outputText value="#{rdv.libNature}"/>&nbsp;
                            <h:graphicImage alt="Traité" height="10" width="10" value="/images/valider.png" rendered="#{rdv.rdvEtat==1}" style="text-align:center"/>
                            <h:graphicImage alt="Reporté" height="13" width="13" value="/images/transferer.png" rendered="#{rdv.rdvEtat==2}" style="text-align:center"/>
                            <h:graphicImage alt="Annulé" height="10" width="10" value="/images/annuler.gif" rendered="#{rdv.rdvEtat==3}" style="text-align:center"/>
                        </rich:column>
                        <rich:column width="12%" sortable="true" sortBy="#{rdv.rdvDteDe} #{rdv.rdvHrDe}:#{rdv.rdvMnDe}" sortOrder="DESCENDING">
                            <f:facet name="header" ><h:outputText value="Date"/></f:facet>
                            <h:outputText value="#{rdv.rdvDteDe}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>&nbsp;
                            <h:outputText value="#{rdv.rdvHrDe}:#{rdv.rdvMnDe}"/>
                        </rich:column>
                        <rich:column width="20%" sortable="true" sortBy="#{rdv.nomTiers}" >
                            <f:facet name="header" ><h:outputText value="Patient"/></f:facet>
                            <h:outputText value="#{rdv.rdvNomPat}"/>
                            <h:outputText value="#{rdv.rdvDiversNom}"/>
                        </rich:column>
                        <rich:column width="10%" sortable="true" sortBy="#{rdv.rdvTache}" >
                            <f:facet name="header" ><h:outputText value="Tache"/></f:facet>
                            <h:outputText value="#{rdv.rdvTache}"/>
                        </rich:column>
                        <rich:column width="25%" sortable="true"  sortBy="#{rdv.rdvSujet}">
                            <f:facet name="header" ><h:outputText value="Sujet"/></f:facet>
                            <h:outputText value="#{rdv.rdvSujet}"/>
                        </rich:column>
                        <rich:column width="15%" sortable="true"  sortBy="#{rdv.rdvSujet}">
                            <f:facet name="header" ><h:outputText value="Statut"/></f:facet>
                            <h:outputText value="#{rdv.libEtat}  #{rdv.rdvCr}"/>
                        </rich:column>
                        <rich:column width="10%" sortable="false">
                            <f:facet name="header" ><h:outputText value="Service"/></f:facet>
                            <h:outputText value="#{rdv.rdvService}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </rich:tab>

        </rich:tabPanel>

        <h:panelGroup>
            <center>
                <h:outputText value="LEGENDE DES COULEURS:"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Rdv" style="color:#0000FF;"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Visite" style="color:#173B0B"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Intervention" style="color:#FAAC58;"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Appel" style="color:#01A9DB;"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Rappel" style="color:#000000;"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="ToDo" style="color:#B404AE;"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Post-it" style="color:#FA58F4;"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Emploi du temps" style="color:#610B0B;"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Pointage" style="color:#FF8000;"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Réunion" style="color:#FF0040;"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Message" style="color:#585858;"/>&nbsp;&nbsp;&nbsp;
            </center>
        </h:panelGroup>
        <h:panelGroup>
            <center>
                <h:outputText value="LEGENDE DES ICONES:"/>&nbsp;&nbsp;&nbsp;
                <h:graphicImage value="/images/ajouter.png" alt="Ajouter" height="15px" width="15px" title="Ajouter évènement"/>&nbsp;&nbsp;&nbsp;
                <h:graphicImage value="/images/supprimer.png" alt="En cours" height="15px" width="15px" title="Suppression possible"/>&nbsp;&nbsp;&nbsp;
                <h:graphicImage value="/images/valider.png" alt="Traité" height="15px" width="15px" title="Traité"/>&nbsp;&nbsp;&nbsp;
                <h:graphicImage value="/images/transferer.png" alt="Reporté" height="15px" width="15px" title="Reporté"/>&nbsp;&nbsp;&nbsp;
                <h:graphicImage value="/images/annuler.gif" alt="Annulé" height="15px" width="15px" title="Annulé"/>&nbsp;&nbsp;&nbsp;
            </center>
        </h:panelGroup>

    </a4j:form>



    <rich:modalPanel domElementAttachment="parent"  id="panelEvent" width="750" height="580" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.showModalPanelRdv}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.showModalPanelRdv}" var="event" >
            <f:facet name="header"><h:outputText value="GESTION DES EVENEMENTS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.annule}" image="/images/close.gif" styleClass="hidelink" reRender="panelEvent"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="idFormEvent">

                <rich:tabPanel switchType="client" immediate="true"  id="panelGlobal" style="border:0px;background-color:white;">

                    <rich:tab id="tabEvent" label="Evènement">
                        <h:panelGrid  width="100%" id="panelRdvGrid" headerClass="headerTab" styleClass="panneau_accueil" >
                            <h:panelGrid style="width:100%;">
                                <h:panelGrid  style="width:100%;" columnClasses="clos20,clos80"  columns="2">
                                    <h:column><h:outputText value="Nature:" /></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%;"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.rdv.rdvNature}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.rdvdetails}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.mesNaturesRdvItems}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.choixTypeRdv}" reRender="panelRdvGrid,tabMail"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGroup id="tiers" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.typeRdv!=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.typeRdv!=8}" >
                                    <h:panelGrid style="width:100%;" id="idTierTier" columnClasses="clos20,clos80" columns="2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.typeRdv!=9}">
                                        <h:column><h:outputText style="text-decoration:underline"  value="Patient Référencé:" /></h:column>
                                        <h:column>
                                            <h:inputText id="idPatient" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.rdv.rdvNomPat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.rdvdetails}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase">
                                                <rich:toolTip id="tooladdPat" followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les patients" style="background-color:#FFF8D4;"/>
                                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.recherchePatients}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idPatient,panelListePatients,formModalListePatients"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column><h:outputText value="Nouveau Patient:" /></h:column>
                                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.rdv.rdvDiversNom}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.rdvdetails}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                                    </h:panelGrid>
                                </h:panelGroup>
                                <h:panelGrid width="100%" columnClasses="clos20,clos80"  columns="2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.rdv.rdvNature!=10}">
                                    <h:column><h:outputText value="Date:" /></h:column>
                                    <h:column>
                                        <rich:calendar style="background-color:green;color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.rdv.rdvDteDe}" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.rdvdetails}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.dateVerrouillee}"/>&nbsp;&nbsp;&nbsp;&nbsp;
                                        <a4j:commandButton title="Reporter l'évènement" value="Reporter" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.reporterRdv}" reRender="panelReport" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.rdvdetails}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.rdv.rdvId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.rdv.rdvEtat==0}"/>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGroup id="heure" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.typeRdv!=8&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.typeRdv!=9}" >
                                    <h:panelGrid width="100%" columnClasses="clos20,clos80" columns="2" >
                                        <h:column><h:outputText value="Heure:" /></h:column>
                                        <h:column>
                                            <h:panelGrid  columns="4">
                                                <h:column>
                                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.rdv.rdvHrDe}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.rdvdetails}">
                                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}" />
                                                    </h:selectOneMenu>
                                                </h:column>
                                                <h:column>h</h:column>
                                                <h:column>
                                                    <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.rdv.rdvMnDe}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.rdvdetails}">
                                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}" />
                                                    </h:selectOneMenu>
                                                </h:column>
                                                <h:column>mn</h:column>
                                            </h:panelGrid>
                                        </h:column>
                                    </h:panelGrid>
                                </h:panelGroup>
                                <h:panelGrid style="width:100%;" columnClasses="clos20,clos80" columns="2">
                                    <h:column><h:outputText value="Sujet:" /></h:column>
                                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.rdv.rdvSujet}" maxlength="50"/></h:column>
                                    <h:column><h:outputText value="Description:" /></h:column>
                                    <h:column><h:inputTextarea id="idTexte" cols="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.rdv.rdvDescript}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.rdvdetails}"/></h:column>
                                    <h:column><h:outputText value="Service concerné:" /></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.rdv.rdvService}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.rdvdetails}">
                                            <f:selectItem itemValue="" itemLabel="Service non précisé"/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.lesServicesItems}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.chargerMedecinService}" reRender="idMedecin"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText style="text-decoration:underline" value="Médecin concerné:" /></h:column>
                                    <h:column>
                                        <h:selectOneMenu id="idMedecin" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.refCollaborateur}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.rdvdetails}">
                                            <f:selectItem itemValue="0" itemLabel="Médecin non précisé"/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.lesMedecinsItems}" />
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.typeRdv==0}"><h:outputText style="text-decoration:underline"  value="Tache à faire:" /></h:column>
                                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.typeRdv==0}">
                                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.choixTache}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.rdvdetails}">
                                            <f:selectItem itemValue="pas de tache" itemLabel="Pas de tache"/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesTachesItems}"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.typeRdv==0}"> <h:outputText value="Lieu concerné:" /></h:column>
                                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.typeRdv==0}"><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.rdv.rdvLieu}" maxlength="50" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.rdvdetails}"/></h:column>
                                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.typeRdv==0}"><h:outputText value="Mode:" /></h:column>
                                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.rdv.rdvMode}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.typeRdv==0}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.rdvdetails}">
                                        <f:selectItem itemLabel="Non renseigné" itemValue="Non renseigné"/>
                                        <f:selectItem itemLabel="Cabinet" itemValue="Cabinet"/>
                                        <f:selectItem itemLabel="Téléphone" itemValue="Téléphone"/>
                                        <f:selectItem itemLabel="Mailing" itemValue="Mail"/>
                                        <f:selectItem itemLabel="Visite" itemValue="Visite"/>
                                    </h:selectOneMenu>
                                </h:panelGrid>
                            </h:panelGrid>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabMail" label="Mailing" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.rdv.rdvNature==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.rdv.rdvNature==8)}">
                        <rich:extendedDataTable  enableContextMenu="false" styleClass="bg" id="tableContact" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="400px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.dataModelContacts}" var="con" >
                            <rich:column width="40%">
                                <f:facet name="header" ><h:outputText value="Nom et prénom"/></f:facet>
                                <h:outputText value="#{con.conpatronyme}"/>
                            </rich:column>
                            <rich:column width="40%">
                                <f:facet name="header" ><h:outputText value="Mail"/></f:facet>
                                <h:outputText value="#{con.mailCumul}"/>
                            </rich:column>
                            <rich:column width="20%">
                                <f:facet name="header" ><h:outputText value="Sélectionné"/></f:facet>
                                <h:selectBooleanCheckbox value="#{con.select}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.rdvdetails}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.rdv.rdvErreur}"><h:outputText value="ERREUR ENVOI:" style="color:red"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.rdv.rdvErreur}"><h:inputText style="width:100%;color:red;" readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.rdv.rdvStatut}"/></h:column>
                    </rich:tab>

                    <rich:tab id="tabCr" label="Compte rendu" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.compteRendu}">
                        <h:panelGrid  width="100%" headerClass="headerTab" styleClass="panneau_accueil" >
                            <h:panelGrid style="width:100%;">
                                <h:panelGrid style="width:100%;" columnClasses="clos20,clos80" columns="2">
                                    <h:column><h:outputText value="Etat:" /></h:column>
                                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.rdv.rdvEtat}">
                                        <f:selectItem itemLabel="En cours" itemValue="0"/>
                                        <f:selectItem itemLabel="Traité" itemValue="1"/>
                                        <f:selectItem itemLabel="Reporté" itemValue="2"/>
                                        <f:selectItem itemLabel="Annulé" itemValue="3"/>
                                    </h:selectOneMenu>
                                    <h:column><h:outputText value="Compte rendu:" /></h:column>
                                    <h:column><h:inputTextarea rows="15" cols="80" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.rdv.rdvCr}"/></h:column>
                                </h:panelGrid>
                            </h:panelGrid>
                        </h:panelGrid>
                    </rich:tab>

                </rich:tabPanel>
                <br/>
                <center>
                    <h:panelGroup  id="buttEvent">
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.saveEvent}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.rdvdetails||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.compteRendu}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEvent,pngBouton,tableRdv1,tableRdv2,tableRdv3,tableRdv4"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelReport" width="500" height="300" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.showModalPanelReport}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.showModalPanelReport}" var="report" >
            <f:facet name="header"><h:outputText value="REPORT EVENEMENT"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.fermerReportRdv}" image="/images/close.gif" styleClass="hidelink" reRender="panelReport"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="idFormReport">
                <h:panelGrid  width="100%" id="panelRdvGrid" headerClass="headerTab" styleClass="panneau_accueil" >
                    <h:panelGrid style="width:100%;">
                        <h:panelGrid width="100%" columnClasses="clos20,clos80"  columns="2">
                            <h:column><h:outputText value="Date report:" /></h:column>
                            <h:column>
                                <rich:calendar style="background-color:green;color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.dateReport}" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy" />
                            </h:column>
                        </h:panelGrid>
                        <h:panelGroup id="heure">
                            <h:panelGrid width="100%" columnClasses="clos20,clos80" columns="2" >
                                <h:column><h:outputText value="Heure de début:" /></h:column>
                                <h:column>
                                    <h:panelGrid  columns="4">
                                        <h:column>
                                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.heureReport}">
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}" />
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column>h</h:column>
                                        <h:column>
                                            <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.minuteReport}">
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}" />
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column>mn</h:column>
                                    </h:panelGrid>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGroup>
                        <h:panelGrid width="100%" columnClasses="clos20,clos80"  columns="2">
                            <h:column><h:outputText value="Motif report:" /></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.motifReport}" maxlength="20"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
                <br/>
                <center>
                    <h:panelGroup  id="buttReport">
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.validerReport}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEvent,panelReport,pngBouton,tableRdv1,tableRdv2,tableRdv3,tableRdv4"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelListePatients" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.showModalPanelPatients}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.showModalPanelPatients}" var="patients" >
            <f:facet name="header"><h:outputText value="Sélection du patient"/></f:facet>
            <a4j:form id="formModalListePatients">
                <h:panelGrid  width="100%">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTablePatient" maxPages="20"align="left" for="tablePatients"/>
                    <rich:extendedDataTable rows="200" id="tablePatients" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.datamodelPatients}"  var="pat">
                        <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.selectionPatients}"/>
                        <f:facet name="header"></f:facet>
                        <rich:column label="Civilité" sortable="true" sortBy="#{pat.patCivilite}" width="15%">
                            <f:facet name="header"><h:outputText  value="Civilité" /></f:facet>
                            <h:outputText value="#{pat.patCivilite}"/>
                        </rich:column>
                        <rich:column label="Nom" sortable="true" sortBy="#{pat.patNom}" width="55%">
                            <f:facet name="header"><h:outputText  value="Raison sociale" /></f:facet>
                            <h:outputText value="#{pat.patNom}"/>
                        </rich:column>
                        <rich:column label="Prénom" sortable="true" sortBy="#{pat.patPrenom}" width="20%">
                            <f:facet name="header"><h:outputText  value="Prénom" /></f:facet>
                            <h:outputText value="#{pat.patPrenom}"/>
                        </rich:column>
                        <rich:column label="Né(e)" sortable="true" sortBy="#{pat.patDateNaissance}" width="10%">
                            <f:facet name="header"><h:outputText  value="Né(e)" /></f:facet>
                            <h:outputText value="#{pat.patDateNaissance}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </h:panelGrid>
                <br>
                <h:panelGroup id="valpatients">
                    <center>
                        <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.annulePatients}" reRender="panelListePatients,tiers"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.calculePatients}" reRender="panelListePatients,tiers"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.showModalPanelPrint}" var="prt">
            <f:facet name="header"><h:outputText value="Impression" style="color:white;"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.closeImpression}" image="/images/close.gif" styleClass="hidelink" reRender="panelImp">
                        <rich:componentControl for="panelImp" attachTo="hideImp" operation="hide" event="onclick"/>
                    </a4j:commandButton>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalImp" target="_blank">
                <center>
                    <h:outputText value="Choisissez un modèle et un format d'Impression"  style="color:green;"/>
                    <br><br>
                </center>
                <h:panelGrid width="100%">
                    <h:panelGrid id="panchoixdoc" width="100%" style="border:solid 1px green;">
                        <f:facet name="header"><h:outputText value="Modèle"/></f:facet>
                        <h:selectOneMenu id="docSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.nomModeleDocument}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.listeImpressionsItems}"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%" style="border:solid 1px green;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="9" style="height:80px">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                <center>
                                    <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.imp}"/>
                                    <h:selectOneMenu id="impSelect" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                    </h:selectOneMenu>
                                </center>
                            </h:panelGroup>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.imprimerJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.imp}"/>
                            <h:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.envoieMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%"  id="panelMail" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.affMail}">
                        <h:panelGrid  width="100%"  style="border:solid 1px green;background-color:white;" columns="2" columnClasses="clos20,clos80">
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.impEmetteur}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.impDestinataire}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.utilPrint.lesbalDestinatairesItems}"/>
                                    <f:selectItem itemLabel="" itemValue="" />
                                </h:selectOneMenu >
                            </h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Copie à (CC):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.impDestinataireCC}"/></h:column>
                            <h:column><h:outputText value="Copie cachée (CCI):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.impDestinataireCCI}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" style="text-align:center;">
                            <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPlanning.affMail}" id="print" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>


