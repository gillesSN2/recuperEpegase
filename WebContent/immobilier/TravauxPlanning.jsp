<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="planningTravaux">

    <a4j:form>
        <rich:hotKey key="return" handler="return false;"/>

        <center> <h2><h:outputText value="PLANNING DES TRAVAUX VALIDEES" style="color:green;"/></h2></center>

        <rich:tabPanel switchType="client" immediate="true" id="p1" tabClass="text" width="100%" style="height:400px;margin-top:0px;border:0;">

            <rich:tab name="mois" label="Par Mois">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.modeMois}"/>
                <h:panelGrid columns="11">
                    <a4j:commandButton title="Mois précédent" image="/images/precedent.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.chargerLesRdvByMoisPrecedent}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRdv1,idDateMois"/>
                    <h:column>
                        <rich:calendar style=" background-color:white;text-align:center" id="idDateMois" locale="FR" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.parMois}"  datePattern="MM/yyyy" inputSize="8" enableManualInput="false"/>
                    </h:column>
                    <a4j:commandButton title="Mois suivant" image="/images/suivant.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.chargerLesRdvByMoisSuivant}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRdv1,idDateMois"/>
                    <h:column> <h:outputText value="Mode:"/></h:column>
                    <h:column>
                        <h:selectOneMenu  style="width:150px"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.valNatMois}"  >
                            <f:selectItem itemLabel="Tous les modes" itemValue="99"/>
                            <f:selectItem itemLabel="Non spécifié" itemValue="0"/>
                            <f:selectItem itemLabel="Livraison simple" itemValue="1"/>
                            <f:selectItem itemLabel="Livraison + Pose" itemValue="2"/>
                            <f:selectItem itemLabel="Livraison hors planning" itemValue="3"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Statut:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.valStatutMois}">
                            <f:selectItem  itemLabel="A faire" itemValue="10"/>
                            <f:selectItem  itemLabel="En cours" itemValue="0"/>
                            <f:selectItem  itemLabel="Effectué avec succés" itemValue="1"/>
                            <f:selectItem  itemLabel="Effectué avec échec" itemValue="2"/>
                            <f:selectItem  itemLabel="Report client" itemValue="3"/>
                            <f:selectItem  itemLabel="Report #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strraisonsociale}" itemValue="4"/>
                            <f:selectItem  itemLabel="Annulation client" itemValue="5"/>
                            <f:selectItem  itemLabel="Annulation #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strraisonsociale}" itemValue="6"/>
                            <f:selectItem  itemLabel="Hibernation client" itemValue="7"/>
                        </h:selectOneMenu>
                    </h:column>&nbsp;&nbsp;
                    <a4j:commandButton value="Rechercher" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.chargerLesRdvByMois}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRdv1,idDateMois"/>&nbsp;&nbsp;
                    <a4j:commandButton title="Imprimer le Mois" image="/images/print.png" reRender="printPlanning" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.initImpressionPlanning}"/>
                </h:panelGrid><br>
                <rich:dataTable style="max-height:100%" styleClass="bg" id="tableRdv1" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.datamodelLesRdvParMois}" var="rdv">
                    <rich:column  width="2%" style="height: 70px;" sortable="false" >
                        <f:facet name="header" ><h:outputText value="N°"/></f:facet>
                        <h:outputText value="#{rdv.num_sem}"/>
                    </rich:column>
                    <rich:column  width="14%" style="height: 70px;" sortable="false" >
                        <f:facet name="header" ><h:outputText value="Lundi"/></f:facet>
                        <h:outputText value="#{rdv.lundi}" styleClass="textAligneCalendar"/>&nbsp;&nbsp;
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.ajouterRdvCol01}" reRender="panelRdv" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche01&&rdv.lundi!=''}"/><br>
                        <rich:dataTable value="#{rdv.dataModelLundi}" var="rdvlundi" id="idrdvlundi" width="100%" border="0" onRowMouseOver="this.style.backgroundColor='#A1A1A1'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.modifDateCol01}" reRender="panelEvent,panelRdv"/>
                            <rich:column  width="20%">
                                <h:outputText value="#{rdvlundi.periode}" style="#{rdvlundi.color}"/><br>
                                <h:outputText value="(#{rdvlundi.bietraentCompteurReport})" style="color:red" rendered="#{rdvlundi.bietraentCompteurReport!=0}"/><br>
                                <h:outputText value="(HIB.)" style="color:red" rendered="#{rdvlundi.bietraentEtatLivraison==7}"/><br>
                            </rich:column>
                            <rich:column  width="70%">
                                <h:outputText value="#{rdvlundi.texteAffiche}" style="#{rdvlundi.color}"/>
                            </rich:column>
                            <rich:column width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche01&&rdvlundi.bietraentEtat==0&&rdvlundi.bietraentId==0}">
                                <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.supprimerRdvCol01}" reRender="idrdvlundi"/>
                            </rich:column>
                        </rich:dataTable>
                    </rich:column>
                    <rich:column width="14%" style="height: 70px;" sortable="false">
                        <f:facet name="header" ><h:outputText value="Mardi"/></f:facet>
                        <h:outputText value="#{rdv.mardi}" styleClass="textAligneCalendar"/>&nbsp;&nbsp;
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.ajouterRdvCol02}" reRender="panelRdv" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche02&&rdv.mardi!=''}"/><br>
                        <rich:dataTable value="#{rdv.dataModelMardi}" var="rdvmardi" id="idrdvmardi" width="100%" border="0" onRowMouseOver="this.style.backgroundColor='#A1A1A1'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.modifDateCol02}" reRender="panelEvent,panelRdv"/>
                            <rich:column  width="20%">
                                <h:outputText value="#{rdvmardi.periode}" style="#{rdvmardi.color}"/><br>
                                <h:outputText value="(#{rdvmardi.bietraentCompteurReport})" style="color:red" rendered="#{rdvmardi.bietraentCompteurReport!=0}"/><br>
                                <h:outputText value="(HIB.)" style="color:red" rendered="#{rdvmardi.bietraentEtatLivraison==7}"/><br>
                            </rich:column>
                            <rich:column  width="70%">
                                <h:outputText value="#{rdvmardi.texteAffiche}" style="#{rdvmardi.color}"/>
                            </rich:column>
                            <rich:column width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche02&&rdvmardi.bietraentEtat==0&&rdvmardi.bietraentId==0}">
                                <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.supprimerRdvCol02}" reRender="idrdvmardi"/>
                            </rich:column>
                        </rich:dataTable>
                    </rich:column>
                    <rich:column width="14%" style="height: 70px;"  sortable="false" >
                        <f:facet name="header" ><h:outputText value="Mercredi"/></f:facet>
                        <h:outputText value="#{rdv.mercredi}" styleClass="textAligneCalendar"/>&nbsp;&nbsp;
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.ajouterRdvCol03}" reRender="panelRdv" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche03&&rdv.mercredi!=''}"/><br>
                        <rich:dataTable value="#{rdv.dataModelMercredi}" var="rdvmercredi" id="idrdvmercredi" width="100%" border="0" onRowMouseOver="this.style.backgroundColor='#A1A1A1'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.modifDateCol03}" reRender="panelEvent,panelRdv"/>
                            <rich:column  width="20%">
                                <h:outputText value="#{rdvmercredi.periode}" style="#{rdvmercredi.color}"/><br>
                                <h:outputText value="(#{rdvmercredi.bietraentCompteurReport})" style="color:red" rendered="#{rdvmercredi.bietraentCompteurReport!=0}"/><br>
                                <h:outputText value="(HIB.)" style="color:red" rendered="#{rdvmercredi.bietraentEtatLivraison==7}"/><br>
                            </rich:column>
                            <rich:column  width="70%">
                                <h:outputText value="#{rdvmercredi.texteAffiche}" style="#{rdvmercredi.color}"/>
                            </rich:column>
                            <rich:column width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche03&&rdvmercredi.bietraentEtat==0&&rdvmercredi.bietraentId==0}">
                                <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.supprimerRdvCol03}" reRender="idrdvmercredi"/>
                            </rich:column>
                        </rich:dataTable>
                    </rich:column>
                    <rich:column width="14%" style="height: 70px;"  sortable="false">
                        <f:facet name="header" ><h:outputText value="Jeudi"/></f:facet>
                        <h:outputText value="#{rdv.jeudi}" styleClass="textAligneCalendar"/>&nbsp;&nbsp;
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.ajouterRdvCol04}" reRender="panelRdv" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche04&&rdv.jeudi!=''}"/><br>
                        <rich:dataTable value="#{rdv.dataModelJeudi}" var="rdvjeudi" id="idrdvjeudi" width="100%" border="0" onRowMouseOver="this.style.backgroundColor='#A1A1A1'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.modifDateCol04}" reRender="panelEvent,panelRdv"/>
                            <rich:column width="20%">
                                <h:outputText value="#{rdvjeudi.periode}" style="#{rdvjeudi.color}"/><br>
                                <h:outputText value="(#{rdvjeudi.bietraentCompteurReport})" style="color:red" rendered="#{rdvjeudi.bietraentCompteurReport!=0}"/><br>
                                <h:outputText value="(HIB.)" style="color:red" rendered="#{rdvjeudi.bietraentEtatLivraison==7}"/><br>
                            </rich:column>
                            <rich:column width="70%">
                                <h:outputText value="#{rdvjeudi.texteAffiche}" style="#{rdvjeudi.color}"/>
                            </rich:column>
                            <rich:column width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche04&&rdvjeudi.bietraentEtat==0&&rdvjeudi.bietraentId==0}">
                                <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.supprimerRdvCol04}" reRender="idrdvjeudi"/>
                            </rich:column>
                        </rich:dataTable>
                    </rich:column>
                    <rich:column width="14%" style="height: 70px;"  sortable="false">
                        <f:facet name="header" ><h:outputText value="Vendredi"/></f:facet>
                        <h:outputText value="#{rdv.vendredi}" styleClass="textAligneCalendar"/>&nbsp;&nbsp;
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.ajouterRdvCol05}" reRender="panelRdv" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche05&&rdv.vendredi!=''}"/><br>
                        <rich:dataTable value="#{rdv.dataModelVendredi}" var="rdvvendredi" id="idrdvvendredi" width="100%" border="0" onRowMouseOver="this.style.backgroundColor='#A1A1A1'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.modifDateCol05}" reRender="panelEvent,panelRdv"/>
                            <rich:column  width="20%">
                                <h:outputText value="#{rdvvendredi.periode}" style="#{rdvvendredi.color}"/><br>
                                <h:outputText value="(#{rdvvendredi.bietraentCompteurReport})" style="color:red" rendered="#{rdvvendredi.bietraentCompteurReport!=0}"/><br>
                                <h:outputText value="(HIB.)" style="color:red" rendered="#{rdvvendredi.bietraentEtatLivraison==7}"/><br>
                            </rich:column>
                            <rich:column  width="70%">
                                <h:outputText value="#{rdvvendredi.texteAffiche}" style="#{rdvvendredi.color}"/>
                            </rich:column>
                            <rich:column width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche05&&rdvvendredi.bietraentEtat==0&&rdvendredi.bietraentId==0}">
                                <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.supprimerRdvCol05}" reRender="idrdvvenredi"/>
                            </rich:column>
                        </rich:dataTable>
                    </rich:column>
                    <rich:column width="14%" style="height: 70px;"  sortable="false">
                        <f:facet name="header" ><h:outputText value="Samedi" style="color:red;"/></f:facet>
                        <h:outputText value="#{rdv.samedi}" styleClass="textAligneCalendar" style="color:red;"/>&nbsp;&nbsp;
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.ajouterRdvCol06}" reRender="panelRdv" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche06&&rdv.samedi!=''}"/><br>
                        <rich:dataTable value="#{rdv.dataModelSamedi}" var="rdvsamedi" id="idrdvsamedi" width="100%" border="0" onRowMouseOver="this.style.backgroundColor='#A1A1A1'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.modifDateCol06}" reRender="panelEvent,panelRdv"/>
                            <rich:column  width="20%">
                                <h:outputText value="#{rdvsamedi.periode}" style="#{rdvsamedi.color}"/><br>
                                <h:outputText value="(#{rdvsamedi.bietraentCompteurReport})" style="color:red" rendered="#{rdvsamedi.bietraentCompteurReport!=0}"/><br>
                                <h:outputText value="(HIB.)" style="color:red" rendered="#{rdvsamedi.bietraentEtatLivraison==7}"/><br>
                            </rich:column>
                            <rich:column  width="70%">
                                <h:outputText value="#{rdvsamedi.texteAffiche}" style="#{rdvsamedi.color}"/>
                            </rich:column>
                            <rich:column width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche06&&rdvsamedi.bietraentEtat==0&&rdvsamedi.bietraentId==0}">
                                <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.supprimerRdvCol06}" reRender="idrdvsamedi"/>
                            </rich:column>
                        </rich:dataTable>
                    </rich:column>
                    <rich:column width="14%" style="height: 70px;"  sortable="false">
                        <f:facet name="header" ><h:outputText value="Dimanche" style="color:red;"/></f:facet>
                        <h:outputText value="#{rdv.dimanche}" styleClass="textAligneCalendar" style="color:red;"/>&nbsp;&nbsp;
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.ajouterRdvCol07}" reRender="panelRdv" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche07&&rdv.dimanche!=''}"/><br>
                        <rich:dataTable value="#{rdv.dataModelDimanche}" var="rdvdimanche" id="idrdvdimanche" width="100%" border="0" onRowMouseOver="this.style.backgroundColor='#A1A1A1'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.modifDateCol07}" reRender="panelEvent,panelRdv"/>
                            <rich:column  width="20%">
                                <h:outputText value="#{rdvdimanche.periode}" style="#{rdvdimanche.color}"/><br>
                                <h:outputText value="(#{rdvdimanche.bietraentCompteurReport})" style="color:red" rendered="#{rdvdimanche.bietraentCompteurReport!=0}"/><br>
                                <h:outputText value="(HIB.)" style="color:red" rendered="#{rdvdimanche.bietraentEtatLivraison==7}"/><br>
                            </rich:column>
                            <rich:column  width="70%">
                                <h:outputText value="#{rdvdimanche.texteAffiche}" style="#{rdvdimanche.color}"/>
                            </rich:column>
                            <rich:column width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche06&&rdvdimanche.bietraentEtat==0&&rdvdimanche.bietraentId==0}">
                                <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.supprimerRdvCol07}" reRender="idrdvdimanche"/>
                            </rich:column>
                        </rich:dataTable>
                    </rich:column>
                </rich:dataTable>
            </rich:tab>

            <rich:tab name="semaine" label="Par Semaine">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.modeSemaine}"/>
                <h:panelGrid columns="11">
                    <a4j:commandButton title="Semaine précédente" image="/images/precedent.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.chargerLesRdvBySemainePrecedent}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRdv2,idDateSemaine"/>
                    <h:column>
                        <rich:calendar style=" background-color:white;" id="idDateSemaine" locale="FR" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.parSemaine}" datePattern="dd/MM/yyyy"  inputSize="8" enableManualInput="false"/>
                    </h:column>
                    <a4j:commandButton title="Semaine suivante" image="/images/suivant.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.chargerLesRdvBySemaineSuivant}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRdv2,idDateSemaine"/>
                    <h:column><h:outputText value="Mode:"/></h:column>
                    <h:column>
                        <h:selectOneMenu  style="width:150px"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.valNatSemaine}"  >
                            <f:selectItem itemLabel="Tous les modes" itemValue="99"/>
                            <f:selectItem itemLabel="Non spécifié" itemValue="0"/>
                            <f:selectItem itemLabel="Livraison simple" itemValue="1"/>
                            <f:selectItem itemLabel="Livraison + Pose" itemValue="2"/>
                            <f:selectItem itemLabel="Livraison hors planning" itemValue="3"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column> <h:outputText value="Statut:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.valStatutSemaine}">
                            <f:selectItem  itemLabel="A faire" itemValue="10"/>
                            <f:selectItem  itemLabel="En cours" itemValue="0"/>
                            <f:selectItem  itemLabel="Effectué avec succés" itemValue="1"/>
                            <f:selectItem  itemLabel="Effectué avec échec" itemValue="2"/>
                            <f:selectItem  itemLabel="Report client" itemValue="3"/>
                            <f:selectItem  itemLabel="Report #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strraisonsociale}" itemValue="4"/>
                            <f:selectItem  itemLabel="Annulation client" itemValue="5"/>
                            <f:selectItem  itemLabel="Annulation #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strraisonsociale}" itemValue="6"/>
                            <f:selectItem  itemLabel="Hibernation client" itemValue="7"/>
                        </h:selectOneMenu>
                    </h:column>&nbsp;&nbsp;
                    <a4j:commandButton value="Rechercher" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.chargerLesRdvBySemaine}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRdv2,idDateSemaine"/>&nbsp;&nbsp;
                    <a4j:commandButton title="Imprimer la Semaine" image="/images/print.png" reRender="printPlanning" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.initImpressionPlanning}"/>
                </h:panelGrid> <br>
                <rich:dataTable style="max-height:100%"  styleClass="bg" id="tableRdv2" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.datamodelLesRdvParSemaine}" var="rdv" >
                    <rich:column  width="9%" sortable="true" sortBy="#{rdv.heure}" sortOrder="ASCENDING">
                        <f:facet name="header" ><h:outputText value="Heure"/></f:facet>
                        <h:outputText value="#{rdv.heure}" style="font-weight:bold;"/>
                    </rich:column>
                    <rich:column  width="13%" sortable="false">
                        <f:facet name="header" ><h:outputText value="Lundi #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.dateLun}"/></f:facet>
                        <h:outputText value="#{rdv.lundi}" style="#{rdv.color}"/>
                    </rich:column>
                    <rich:column width="13%" sortable="false" id="idMardiSemaine">
                        <f:facet name="header" ><h:outputText value="Mardi #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.dateMar}"/></f:facet>
                        <h:outputText value="#{rdv.mardi}" style="#{rdv.color}"/>
                    </rich:column>
                    <rich:column width="13%" sortable="false" >
                        <f:facet name="header" ><h:outputText value="Mercredi #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.dateMer}"/></f:facet>
                        <h:outputText value="#{rdv.mercredi}" style="#{rdv.color}"/>
                    </rich:column>
                    <rich:column width="13%" sortable="false">
                        <f:facet name="header" ><h:outputText value="Jeudi #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.dateJeu}"/></f:facet>
                        <h:outputText value="#{rdv.jeudi}" style="#{rdv.color}"/>
                    </rich:column>
                    <rich:column width="13%" sortable="false">
                        <f:facet name="header" ><h:outputText value="Vendredi #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.dateVen}"/></f:facet>
                        <h:outputText value="#{rdv.vendredi}" style="#{rdv.color}"/>
                    </rich:column>
                    <rich:column width="13%" sortable="false">
                        <f:facet name="header" ><h:outputText value="Samedi #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.dateSam}" style="color:red;"/></f:facet>
                        <h:outputText value="#{rdv.samedi}" style="color:red;"/>
                    </rich:column>
                    <rich:column width="13%" sortable="false">
                        <f:facet name="header" ><h:outputText value="Dimanche #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.dateDim}" style="color:red;"/></f:facet>
                        <h:outputText value="#{rdv.dimanche}" style="color:red;"/>
                    </rich:column>
                </rich:dataTable>
            </rich:tab>

            <rich:tab name="jour" label="Par Jour">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.modeJour}"/>
                <h:panelGrid columns="11">
                    <a4j:commandButton title="Jour précédent" image="/images/precedent.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.chargerLesRdvByJourPrecedent}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRdv3,idDateJour"/>
                    <h:column>
                        <rich:calendar style=" background-color:white;" id="idDateJour" locale="FR" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.parJour}" datePattern="dd/MM/yyyy"  inputSize="8" enableManualInput="false"/>
                    </h:column>
                    <a4j:commandButton title="Jour suivant" image="/images/suivant.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.chargerLesRdvByJourSuivant}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRdv3,idDateJour"/>
                    <h:column><h:outputText value="Mode:"/></h:column>
                    <h:column>
                        <h:selectOneMenu  style="width:150px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.valNatJour}"  >
                            <f:selectItem itemLabel="Tous les modes" itemValue="99"/>
                            <f:selectItem itemLabel="Non spécifié" itemValue="0"/>
                            <f:selectItem itemLabel="Livraison simple" itemValue="1"/>
                            <f:selectItem itemLabel="Livraison + Pose" itemValue="2"/>
                            <f:selectItem itemLabel="Livraison hors planning" itemValue="3"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column> <h:outputText value="Statut:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.valStatutJour}">
                            <f:selectItem  itemLabel="A faire" itemValue="10"/>
                            <f:selectItem  itemLabel="En cours" itemValue="0"/>
                            <f:selectItem  itemLabel="Effectué avec succés" itemValue="1"/>
                            <f:selectItem  itemLabel="Effectué avec échec" itemValue="2"/>
                            <f:selectItem  itemLabel="Report client" itemValue="3"/>
                            <f:selectItem  itemLabel="Report #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strraisonsociale}" itemValue="4"/>
                            <f:selectItem  itemLabel="Annulation client" itemValue="5"/>
                            <f:selectItem  itemLabel="Annulation #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strraisonsociale}" itemValue="6"/>
                            <f:selectItem  itemLabel="Hibernation client" itemValue="7"/>
                        </h:selectOneMenu>
                    </h:column>&nbsp;&nbsp;
                    <a4j:commandButton value="Rechercher" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.chargerLesRdvByJour}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRdv3,idDateJour"/>&nbsp;&nbsp;
                    <a4j:commandButton title="Imprimer le Jour" image="/images/print.png" reRender="printPlanning" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.initImpressionPlanning}"/>
                </h:panelGrid> <br>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable style="max-height:100%" enableContextMenu="false" styleClass="bg" id="tableRdv3" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.datamodelLesRdvParJour}" var="rdv" >
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.selectionLigneJour}" reRender="panelEvent"/>
                        <rich:column width="10%" sortable="false" sortBy="#{rdv.bietraentHoraireLivraison} #{rdv.periode}" sortOrder="ASCENDING">
                            <f:facet name="header" ><h:outputText value="Heure"/></f:facet>
                            <h:outputText value="#{rdv.periode}" style="#{rdv.color}"/>&nbsp;&nbsp;&nbsp;
                            <h:outputText value="(#{rdv.bietraentCompteurReport})" style="color:red" rendered="#{rdv.bietraentCompteurReport!=0}"/>
                            <h:outputText value="(HIB.)" style="color:red" rendered="#{rdv.bietraentEtatLivraison==7}"/>
                        </rich:column>
                        <rich:column width="10%" sortable="false">
                            <f:facet name="header" ><h:outputText value="N° BC"/></f:facet>
                            <h:outputText value="#{rdv.bietraentNum}" style="#{rdv.color}"/>
                        </rich:column>
                        <rich:column width="20%" sortable="false">
                            <f:facet name="header" ><h:outputText value="Tiers"/></f:facet>
                            <h:outputText value="#{rdv.var_nom_tiers}" style="#{rdv.color}"/>
                        </rich:column>
                        <rich:column width="25%" sortable="false">
                            <f:facet name="header" ><h:outputText value="Contact"/></f:facet>
                            <h:outputText value="#{rdv.var_contactLivraison}" style="#{rdv.color}"/>
                        </rich:column>
                        <rich:column width="5%" sortable="false" >
                            <f:facet name="header" ><h:outputText value="Mode"/></f:facet>
                            <h:outputText value="#{rdv.libelleMode}" style="#{rdv.color}" rendered="#{rdv.var_nom_tiers!=null}"/>
                        </rich:column>
                        <rich:column width="30%" sortable="false">
                            <f:facet name="header" ><h:outputText value="Objet"/></f:facet>
                            <h:outputText value="#{rdv.bietraentObject}" style="#{rdv.color}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </rich:tab>

            <rich:tab name="parliste" label="Par Liste">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.modeListe}"/>
                <h:panelGrid columns="2">
                    <h:panelGrid id="pngBouton" columns="3" width="100px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                    </h:panelGrid>
                    <h:panelGrid columns="12">
                        <h:outputText value="Du"/>
                        <rich:calendar style="background-color:white;" locale="FR" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.jourDeb}"  enableManualInput="true" datePattern="dd/MM/yyyy"  inputSize="8" />
                        <h:outputText value="Au"/>
                        <rich:calendar style=" background-color:white;" locale="FR" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.jourFin}"  enableManualInput="true" datePattern="dd/MM/yyyy"  inputSize="8" />
                        <h:column> <h:outputText value="Mode:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:150px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.valNatListe}"  >
                                <f:selectItem itemLabel="Tous les modes" itemValue="99"/>
                                <f:selectItem itemLabel="Non spécifié" itemValue="0"/>
                                <f:selectItem itemLabel="Livraison simple" itemValue="1"/>
                                <f:selectItem itemLabel="Livraison + Pose" itemValue="2"/>
                                <f:selectItem itemLabel="Livraison hors planning" itemValue="3"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column> <h:outputText value="Statut:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.valStatutListe}">
                                <f:selectItem  itemLabel="A faire" itemValue="10"/>
                                <f:selectItem  itemLabel="En cours" itemValue="0"/>
                                <f:selectItem  itemLabel="Effectué avec succés" itemValue="1"/>
                                <f:selectItem  itemLabel="Effectué avec échec" itemValue="2"/>
                                <f:selectItem  itemLabel="Report client" itemValue="3"/>
                                <f:selectItem  itemLabel="Report #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strraisonsociale}" itemValue="4"/>
                                <f:selectItem  itemLabel="Annulation client" itemValue="5"/>
                                <f:selectItem  itemLabel="Annulation #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strraisonsociale}" itemValue="6"/>
                                <f:selectItem  itemLabel="Hibernation client" itemValue="7"/>
                            </h:selectOneMenu>
                        </h:column>&nbsp;&nbsp;
                        <a4j:commandButton value="Rechercher" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.chargerLesRdv}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRdv4"/>&nbsp;&nbsp;
                        <a4j:commandButton title="Imprimer la Liste" image="/images/print.png" reRender="printPlanning" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.initImpressionPlanning}"/>
                    </h:panelGrid>
                </h:panelGrid>
                <br>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable style="max-height:100%" enableContextMenu="false" styleClass="bg" id="tableRdv4" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.datamodelRdv}" var="rdv" >
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.selectionLigneListe}" reRender="panelEvent"/>
                        <rich:column width="10%" sortable="true" sortBy="#{rdv.bietraentDateLivraison} #{rdv.periode}" sortOrder="ASCENDING">
                            <f:facet name="header" ><h:outputText value="Date"/></f:facet>
                            <h:outputText value="#{rdv.bietraentDateLivraison}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>&nbsp;
                            <h:outputText value="#{rdv.periode}" style="#{rdv.color}"/>
                        </rich:column>
                        <rich:column width="10%" sortable="true" sortBy="#{rdv.bietraentNum}">
                            <h:outputText value="(#{rdv.bietraentCompteurReport})" style="color:red" rendered="#{rdv.bietraentCompteurReport!=0}"/>
                            <h:outputText value="(HIB.)" style="color:red" rendered="#{rdv.bietraentEtatLivraison==7}"/>
                        </rich:column>
                        <rich:column width="10%" sortable="true" sortBy="#{rdv.bietraentNum}">
                            <f:facet name="header" ><h:outputText value="N° BC"/></f:facet>
                            <h:outputText value="#{rdv.bietraentNum}" style="#{rdv.color}"/>
                        </rich:column>
                        <rich:column width="20%" sortable="true" sortBy="#{rdv.var_nom_tiers}" >
                            <f:facet name="header" ><h:outputText value="Tiers"/></f:facet>
                            <h:outputText value="#{rdv.var_nom_tiers}" style="#{rdv.color}"/>
                        </rich:column>
                        <rich:column width="25%" sortable="false">
                            <f:facet name="header" ><h:outputText value="Contact"/></f:facet>
                            <h:outputText value="#{rdv.var_contactLivraison}" style="#{rdv.color}"/>
                        </rich:column>
                        <rich:column width="5%" sortable="true" sortBy="#{rdv.libelleMode}" >
                            <f:facet name="header" ><h:outputText value="Mode"/></f:facet>
                            <h:outputText value="#{rdv.libelleMode}" style="#{rdv.color}"/>
                        </rich:column>
                        <rich:column width="30%" sortable="true"  sortBy="#{rdv.bietraentObject}">
                            <f:facet name="header" ><h:outputText value="Objet"/></f:facet>
                            <h:outputText value="#{rdv.bietraentObject}" style="#{rdv.color}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </rich:tab>

        </rich:tabPanel>

        <h:panelGroup>
            <center>
                <br>
                <a4j:commandButton value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.annule}" reRender="modAttente,idSubView"/>
            </center>
        </h:panelGroup>

        <h:panelGroup>
            <center>
                <br>
                <h:outputText value="LEGENDE DES COULEURS:"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Mode Non spécifié" style="color:#000000;"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Livraison simple" style="color:#0000FF"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Livraison + pose" style="color:#B404AE;"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Livraison hors planning" style="color:#610B0B;"/>&nbsp;&nbsp;&nbsp;
            </center>
        </h:panelGroup>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelEvent" width="700" height="450" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.showModalPanelPlanning}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.showModalPanelPlanning}" var="event" >
            <f:facet name="header"><h:outputText value="STATUT LIVRAISON"></h:outputText></f:facet>
            <a4j:form id="idFormEvent">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  width="100%">
                    <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;" >

                        <rich:tab id="tabStatut" label="Statut">
                            <h:panelGrid id="idpanStatut" width="100%">
                                <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" styleClass="fichefournisseur" id="idModeLivraison">
                                    <h:column><h:outputText value="Mode livraison:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentModeLivraison}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentEtatLivraison==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentEtatLivraison==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentEtatLivraison==5||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentEtatLivraison==6}">
                                            <f:selectItem  itemLabel="Non spécifié" itemValue="0"/>
                                            <f:selectItem  itemLabel="Livraison simple" itemValue="1"/>
                                            <f:selectItem  itemLabel="Livraison + pose" itemValue="2"/>
                                            <f:selectItem  itemLabel="Livraison hors planning" itemValue="3"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Lieu livraison:"/></h:column>
                                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentLieuLivraison}" style="width:95%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentEtatLivraison==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentEtatLivraison==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentEtatLivraison==5||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentEtatLivraison==6}" maxlength="100"/></h:column>
                                    <h:column><h:outputText value="Date livraison:"/></h:column>
                                    <h:column>
                                        <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentDateLivraison}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentEtatLivraison==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentEtatLivraison==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentEtatLivraison==5||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentEtatLivraison==6}"></rich:calendar>
                                    </h:column>
                                    <h:column><h:outputText value="Heure livraison:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentHoraireLivraison}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentEtatLivraison==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentEtatLivraison==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentEtatLivraison==5||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentEtatLivraison==6}">
                                            <f:selectItem  itemLabel="Non spécifié" itemValue="0"/>
                                            <f:selectItem  itemLabel="Matin (AM)" itemValue="1"/>
                                            <f:selectItem  itemLabel="Aprés midi (PM)" itemValue="2"/>
                                            <f:selectItem  itemLabel="Heure précise" itemValue="3"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="idModeLivraison,idHoraire1,idHoraire2"/>
                                        </h:selectOneMenu>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <h:outputText id="idHoraire1" value="Heure précise:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentHoraireLivraison==3}"/>&nbsp;&nbsp;
                                        <h:selectOneMenu id="idHoraire2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentHeureLivraison}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentEtatLivraison==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentEtatLivraison==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentEtatLivraison==5||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentEtatLivraison==6}" style="width:45px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentHoraireLivraison==3}">
                                            <f:selectItem  itemLabel="NP" itemValue="00"/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Info livraison:"/></h:column>
                                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentInfoLivraison}" style="width:95%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentEtatLivraison==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentEtatLivraison==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentEtatLivraison==5||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentEtatLivraison==6}" maxlength="100"/></h:column>
                                    <h:column><h:outputText value="Contact livraison:"/></h:column>
                                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentContactLivraison}" style="width:95%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentEtatLivraison==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentEtatLivraison==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentEtatLivraison==5||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentEtatLivraison==6}" maxlength="50"/></h:column>
                                    <h:column><h:outputText value="Téléphone contact:"/></h:column>
                                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentTelephoneLivraison}" style="width:300px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentEtatLivraison==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentEtatLivraison==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentEtatLivraison==5||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentEtatLivraison==6}" maxlength="20"/></h:column>
                                </h:panelGrid>
                                <br>
                                <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" styleClass="fichefournisseur">
                                    <h:column><h:outputText value="Etat rendez-vous:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentEtatLivraison}">
                                            <f:selectItem  itemLabel="En cours" itemValue="0"/>
                                            <f:selectItem  itemLabel="Effectué avec succés" itemValue="1"/>
                                            <f:selectItem  itemLabel="Effectué avec échec" itemValue="2"/>
                                            <f:selectItem  itemLabel="Report client" itemValue="3"/>
                                            <f:selectItem  itemLabel="Report #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strraisonsociale}" itemValue="4"/>
                                            <f:selectItem  itemLabel="Annulation client" itemValue="5"/>
                                            <f:selectItem  itemLabel="Annulation #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strraisonsociale}" itemValue="6"/>
                                            <f:selectItem  itemLabel="Hibernation client" itemValue="7"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="idpanStatut"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Observation:"/></h:column>
                                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentObservationLivraison}" style="width:95%" maxlength="50"/></h:column>
                                </h:panelGrid>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab id="tabCommande" label="Commande">

                            <h:panelGrid width="100%" style="background-color:#DAEECB;height:110px" id="idpanel1">
                                <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos30g,clos5d,clos21g,clos12d,clos21g" id="panelDate">
                                    <h:column><h:outputText value="Date:"/></h:column>
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentDate}"  inputSize="8" datePattern="dd/MM/yyyy HH:MM:ss" locale="fr" style=" background-color:white;" disabled="true" readonly="true"></rich:calendar></h:column>
                                    <h:column><h:outputText value="N°:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentNum}" readonly="true" disabled="true"/></h:column>
                                    <h:column><h:outputText value="Série:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:inputText style="width:30%" id="idSerie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentSerie}" disabled="true"/>&nbsp;&nbsp;
                                        <h:inputText style="width:30%" id="idDevise" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentDevise}" disabled="true"/>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="panelTiers" width="100%" columns="4" columnClasses="clos12d,clos55g,clos12d,clos21g">
                                    <h:column><h:outputText value="Nom client:" style="text-decoration:underline;width:100%"/></h:column>
                                    <h:column><h:inputText style="width:90%" id="idTiers" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentNomTiers}" disabled="true" readonly="true"/>&nbsp;</h:column>
                                    <h:column><h:outputText value="Catégorie:" style="text-decoration:underline;"/></h:column>
                                    <h:column><h:inputText style="width:100%" id="idCat" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentCat}" disabled="true"/></h:column>
                                </h:panelGrid>
                                <h:panelGroup id="panelTiersInformations" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.informationsTiers!=null}">
                                    <center>
                                        <h:outputText value="Message :  #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.informationsTiers}" style="color:red;font-weight:bold;font-size:20px,text-decoration: blink;"/>
                                    </center>
                                </h:panelGroup>
                                <h:panelGrid id="panelContact" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                    <h:column>
                                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.var_libcondest}:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentDiversTiers==0}"/>
                                        <h:outputText value="Nom Divers:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentDiversTiers==99}"/>
                                    </h:column>
                                    <h:column>
                                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentDiversTiers==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.contDest=='false'}">
                                            <h:inputText id="idPanelContact" style="width:80%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentNomContact}" disabled="true"/>
                                        </c:if>
                                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentDiversTiers==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.contDest=='true'}">
                                            <h:inputText id="idDestinataire" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentNomContact}" readonly="true"/>
                                        </c:if>
                                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentDiversTiers==99}">
                                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentDiversNom}" readonly="true"/>
                                        </c:if>
                                    </h:column>
                                    <h:column><h:outputText value="Responsable:" style="text-decoration:underline;"/></h:column>
                                    <h:column id="idResponsable">
                                        <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentNomResponsable}" disabled="true"/>
                                    </h:column>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.optionsVentes.responsable=='0'}">
                                        <h:column><h:outputText value="Objet:"/></h:column>
                                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentObject}" readonly="true" disabled="true"/></h:column>
                                    </c:if>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.optionsVentes.responsable!='0'}">
                                        <h:column><h:outputText value="Commercial:" style="text-decoration:underline;"/></h:column>
                                        <h:column>
                                            <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentNomCommercial}" disabled="true"/>
                                        </h:column>
                                    </c:if>
                                </h:panelGrid>
                                <h:panelGrid id="idTiersDivers" columns="2" style="background-color:white;" columnClasses="clos15,clos35,clos15,clos35" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentDiversTiers==99}">
                                    <h:column><h:outputText value="Adresse:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentDiversAdresse}" readonly="true" disabled="true"/></h:column>
                                    <h:column><h:outputText value="Ville:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentDiversVille}" readonly="true" disabled="true"/></h:column>
                                    <h:column><h:outputText value="Téléphone:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentDiversTel}" readonly="true" disabled="true"/></h:column>
                                    <h:column><h:outputText value="Mail:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.commandeEnteteVentes.bietraentDiversMail}" readonly="true" disabled="true"/></h:column>
                                </h:panelGrid>
                            </h:panelGrid>

                        </rich:tab>

                        <rich:tab id="tabProduit" label="Produits">
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable id="tableLigne" height="300px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " styleClass="bg" style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.datamodelLigne}" var="doclig">
                                    <rich:column sortable="false" width="15%">
                                        <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                        <h:outputText  value="#{doclig.bietraentligCode}" style="#{doclig.styleLigne}"/>&nbsp;&nbsp;
                                        <h:outputText value="PROCESS" style="color:red;#{doclig.styleLigne}" rendered="#{doclig.bietraentligProcess==1}"/>&nbsp;&nbsp;
                                        <h:outputText  value="#{doclig.bietraentligGroupe}" style="#{doclig.styleLigne}" rendered="#{doclig.bietraentligModeGroupe==2}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="40%">
                                        <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                        <h:outputText value="#{doclig.bietraentligLibelle}" style="#{doclig.styleLigne}"/><br>
                                        <h:outputText value="#{doclig.bietraentligComplement}" rendered="#{doclig.bietraentligComplement!=null}" style="#{doclig.styleLigne}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="15%" >
                                        <f:facet name="header"><h:outputText  value="Dépôt"/></f:facet>
                                        <h:outputText value="#{doclig.bietraentligDepot}" style="#{doclig.styleLigne}"/>
                                    </rich:column>
                                    <rich:column sortable="false" style="text-align:right" width="15%" >
                                        <f:facet name="header"><h:outputText  value="Qté"/></f:facet>
                                        <h:outputText value="#{doclig.bietraentligQte}" style="#{doclig.styleLigne}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.optionsVentes.nbDecQte}"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column sortable="false" width="15%">
                                        <f:facet name="header"><h:outputText  value="Unité"/></f:facet>
                                        <h:outputText value="#{doclig.var_lib_uni_condit}" style="#{doclig.styleLigne}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </rich:tab>

                        <rich:tab id="tabProcess" label="Process">

                        </rich:tab>

                    </rich:tabPanel>
                </h:panelGrid>
                <br>
                <h:panelGroup>
                    <center>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.fermerPlanning}" image="/images/annuler_big.png" reRender="panelEvent"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.validerPlanning}" image="/images/valider_big.png" reRender="panelEvent,tableRdv1,tableRdv2,tableRdv3,tableRdv4"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelRdv" width="750" height="400" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.showModalPanelRdv}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.showModalPanelRdv}" var="event" >
            <f:facet name="header"><h:outputText value="GESTION DES RDV COMPLEMENTAIRES"></h:outputText></f:facet>
            <a4j:form id="idFormEvent">
                <rich:hotKey key="return" handler="return false;"/>

                <rich:tabPanel switchType="client" immediate="true"  id="panelGlobal" style="border:0px;background-color:white;">

                    <rich:tab id="tabEvent" label="Rdv">
                        <h:panelGrid  width="100%" id="panelRdvGrid" headerClass="headerTab" styleClass="panneau_accueil" >
                            <h:panelGrid style="width:100%;">
                                <h:panelGrid  style="width:100%;" columnClasses="clos20,clos80"  columns="2">
                                    <h:column><h:outputText value="Nature:" /></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.rdv.rdvNature}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.rdvdetails}">
                                            <f:selectItem itemLabel="Rdv CMD" itemValue="12"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid width="100%" columnClasses="clos20,clos80"  columns="2">
                                    <h:column><h:outputText value="Date rdv:" /></h:column>
                                    <h:column>
                                        <rich:calendar style="background-color:green;color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.rdv.rdvDteDe}" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  disabled="true" readonly="true"/>&nbsp;&nbsp;&nbsp;&nbsp;
                                    </h:column>
                                    <h:column><h:outputText value="Mode:"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.rdv.rdvLieu}"  >
                                            <f:selectItem itemLabel="Tous les modes" itemValue="99"/>
                                            <f:selectItem itemLabel="Non spécifié" itemValue="0"/>
                                            <f:selectItem itemLabel="Livraison simple" itemValue="1"/>
                                            <f:selectItem itemLabel="Livraison + Pose" itemValue="2"/>
                                            <f:selectItem itemLabel="Livraison hors planning" itemValue="3"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGroup id="heure" >
                                    <h:panelGrid width="100%" columnClasses="clos20,clos80" columns="2" >
                                        <h:column><h:outputText value="Heure de début:" /></h:column>
                                        <h:column>
                                            <h:panelGrid  columns="4">
                                                <h:column>
                                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.rdv.rdvHrDe}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.rdvdetails}">
                                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}" />
                                                    </h:selectOneMenu>
                                                </h:column>
                                                <h:column>h</h:column>
                                                <h:column>
                                                    <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.rdv.rdvMnDe}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.rdvdetails}">
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
                                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.rdv.rdvSujet}" maxlength="50"/></h:column>
                                    <h:column><h:outputText value="Description:" /></h:column>
                                    <h:column><h:inputTextarea id="idTexte" cols="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.rdv.rdvDescript}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.rdvdetails}"/></h:column>
                                </h:panelGrid>
                            </h:panelGrid>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabCr" label="Compte rendu" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.compteRendu}">
                        <h:panelGrid  width="100%" headerClass="headerTab" styleClass="panneau_accueil" >
                            <h:panelGrid style="width:100%;">
                                <h:panelGrid style="width:100%;" columnClasses="clos20,clos80" columns="2">
                                    <h:column><h:outputText value="Etat:" /></h:column>
                                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.rdv.rdvEtat}">
                                        <f:selectItem itemLabel="En cours" itemValue="0"/>
                                        <f:selectItem itemLabel="Traité" itemValue="1"/>
                                        <f:selectItem itemLabel="Reporté" itemValue="2"/>
                                        <f:selectItem itemLabel="Annulé" itemValue="3"/>
                                    </h:selectOneMenu>
                                    <h:column><h:outputText value="Compte rendu:" /></h:column>
                                    <h:column><h:inputTextarea rows="15" cols="80" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.rdv.rdvCr}"/></h:column>
                                </h:panelGrid>
                            </h:panelGrid>
                        </h:panelGrid>
                    </rich:tab>

                </rich:tabPanel>
                <br>
                <h:panelGroup id="buttEvent">
                    <center>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.annulerRdv}" image="/images/annuler_big.png" reRender="panelRdv"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.saveEventRdv}" image="/images/valider_big.png" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.rdvdetails||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.compteRendu}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelRdv,tableRdv1,tableRdv2,tableRdv3,tableRdv4"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="printPlanning" width="650" height="350" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.showModalPanelPrintPlanning}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.showModalPanelPrintPlanning}" var="prp">
            <f:facet name="header"><h:outputText value="Impression des plannings"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.fermerPrintPlanning}" image="/images/close.gif" styleClass="hidelink" reRender="printPlanning"/>
                </a4j:form>
            </f:facet>
            <a4j:form target="_blank">
                <rich:hotKey key="return" handler="return false;"/>
                <center>
                    <h:outputText value="Choisissez un modèle et un format d'Impression"  style="color:green;"/>
                    <br><br>
                </center>
                <h:panelGrid  width="100%">
                    <h:panelGrid id="panchoixdoc" width="100%" style="border:solid 0px green;">
                        <f:facet name="header"><h:outputText value="Modèle"/></f:facet>
                        <br>
                        <h:selectOneMenu id="docSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.nomModeleDocument}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.planningImpressionsItems}"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%" style="border:solid 0px green;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <h:panelGrid  width="100%" columns="9" style="height:80px">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                <center>
                                    <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes du serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.imp}"/>
                                    <h:selectOneMenu id="impSelect1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                    </h:selectOneMenu>
                                </center>
                            </h:panelGroup>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.imprimerJRVPlanning}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.imprimerPDFPlanning}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.imprimerODTPlanning}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.imprimerXLSPlanning}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.imprimerDOCPlanning}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.imprimerHTMLPlanning}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.imprimerXMLPlanning}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuvente.imp}"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
