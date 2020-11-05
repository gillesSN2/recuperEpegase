<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="planningCommande">

    <a4j:form>
        <rich:hotKey key="return" handler="return false;"/>

        <center> <h2><h:outputText value="PLANNING DES COMMANDES VALIDEES OU TRANSFORMEES (EN PRODUCTION)" style="color:green;"/></h2></center>

        <rich:tabPanel switchType="client" immediate="true" id="p1" tabClass="text" width="100%" style="height:400px;margin-top:0px;border:0;">

            <rich:tab name="mois" label="Par Mois">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.modeMois}"/>
                <h:panelGrid columns="11">
                    <a4j:commandButton title="Mois précédent" image="/images/precedent.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.chargerLesRdvByMoisPrecedent}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRdv1,idDateMois"/>
                    <h:column>
                        <rich:calendar style=" background-color:white;text-align:center" id="idDateMois" locale="FR" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.parMois}"  datePattern="MM/yyyy" inputSize="8" enableManualInput="false"/>
                    </h:column>
                    <a4j:commandButton title="Mois suivant" image="/images/suivant.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.chargerLesRdvByMoisSuivant}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRdv1,idDateMois"/>
                    <h:column> <h:outputText value="Mode:"/></h:column>
                    <h:column>
                        <h:selectOneMenu  style="width:150px"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.valNatMois}"  >
                            <f:selectItem itemLabel="Tous les modes" itemValue="99"/>
                            <f:selectItem itemLabel="Non spécifié" itemValue="0"/>
                            <f:selectItem itemLabel="Livraison simple" itemValue="1"/>
                            <f:selectItem itemLabel="Livraison + Pose" itemValue="2"/>
                            <f:selectItem itemLabel="Livraison hors planning" itemValue="3"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Statut:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.valStatutMois}">
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
                    <a4j:commandButton value="Rechercher" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.chargerLesRdvByMois}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRdv1,idDateMois"/>&nbsp;&nbsp;
                    <a4j:commandButton title="Imprimer le Mois" image="/images/print.png" reRender="printPlanning" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.initImpressionPlanning}"/>
                </h:panelGrid><br>
                <rich:dataTable style="max-height:100%" styleClass="bg" id="tableRdv1" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.datamodelLesRdvParMois}" var="rdv">
                    <rich:column  width="2%" style="height: 70px;" sortable="false" >
                        <f:facet name="header" ><h:outputText value="N°"/></f:facet>
                        <h:outputText value="#{rdv.num_sem}"/>
                    </rich:column>
                    <rich:column  width="14%" style="height: 70px;" sortable="false" >
                        <f:facet name="header" ><h:outputText value="Lundi"/></f:facet>
                        <h:outputText value="#{rdv.lundi}" styleClass="textAligneCalendar"/>&nbsp;&nbsp;
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.ajouterRdvCol01}" reRender="panelRdv" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche01&&rdv.lundi!=''}"/><br>
                        <rich:dataTable value="#{rdv.dataModelLundi}" var="rdvlundi" id="idrdvlundi" width="100%" border="0" onRowMouseOver="this.style.backgroundColor='#A1A1A1'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.modifDateCol01}" reRender="panelEvent,panelRdv"/>
                            <rich:column  width="20%">
                                <h:outputText value="#{rdvlundi.periode}" style="#{rdvlundi.color}"/><br>
                                <h:outputText value="(#{rdvlundi.bcmCompteurReport})" style="color:red" rendered="#{rdvlundi.bcmCompteurReport!=0}"/><br>
                                <h:outputText value="(HIB.)" style="color:red" rendered="#{rdvlundi.bcmEtatLivraison==7}"/><br>
                            </rich:column>
                            <rich:column  width="70%">
                                <h:outputText value="#{rdvlundi.texteAffiche}" style="#{rdvlundi.color}"/>
                            </rich:column>
                            <rich:column width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche01&&rdvlundi.bcmEtat==0&&rdvlundi.bcmId==0}">
                                <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.supprimerRdvCol01}" reRender="idrdvlundi"/>
                            </rich:column>
                        </rich:dataTable>
                    </rich:column>
                    <rich:column width="14%" style="height: 70px;" sortable="false">
                        <f:facet name="header" ><h:outputText value="Mardi"/></f:facet>
                        <h:outputText value="#{rdv.mardi}" styleClass="textAligneCalendar"/>&nbsp;&nbsp;
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.ajouterRdvCol02}" reRender="panelRdv" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche02&&rdv.mardi!=''}"/><br>
                        <rich:dataTable value="#{rdv.dataModelMardi}" var="rdvmardi" id="idrdvmardi" width="100%" border="0" onRowMouseOver="this.style.backgroundColor='#A1A1A1'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.modifDateCol02}" reRender="panelEvent,panelRdv"/>
                            <rich:column  width="20%">
                                <h:outputText value="#{rdvmardi.periode}" style="#{rdvmardi.color}"/><br>
                                <h:outputText value="(#{rdvmardi.bcmCompteurReport})" style="color:red" rendered="#{rdvmardi.bcmCompteurReport!=0}"/><br>
                                <h:outputText value="(HIB.)" style="color:red" rendered="#{rdvmardi.bcmEtatLivraison==7}"/><br>
                            </rich:column>
                            <rich:column  width="70%">
                                <h:outputText value="#{rdvmardi.texteAffiche}" style="#{rdvmardi.color}"/>
                            </rich:column>
                            <rich:column width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche02&&rdvmardi.bcmEtat==0&&rdvmardi.bcmId==0}">
                                <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.supprimerRdvCol02}" reRender="idrdvmardi"/>
                            </rich:column>
                        </rich:dataTable>
                    </rich:column>
                    <rich:column width="14%" style="height: 70px;"  sortable="false" >
                        <f:facet name="header" ><h:outputText value="Mercredi"/></f:facet>
                        <h:outputText value="#{rdv.mercredi}" styleClass="textAligneCalendar"/>&nbsp;&nbsp;
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.ajouterRdvCol03}" reRender="panelRdv" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche03&&rdv.mercredi!=''}"/><br>
                        <rich:dataTable value="#{rdv.dataModelMercredi}" var="rdvmercredi" id="idrdvmercredi" width="100%" border="0" onRowMouseOver="this.style.backgroundColor='#A1A1A1'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.modifDateCol03}" reRender="panelEvent,panelRdv"/>
                            <rich:column  width="20%">
                                <h:outputText value="#{rdvmercredi.periode}" style="#{rdvmercredi.color}"/><br>
                                <h:outputText value="(#{rdvmercredi.bcmCompteurReport})" style="color:red" rendered="#{rdvmercredi.bcmCompteurReport!=0}"/><br>
                                <h:outputText value="(HIB.)" style="color:red" rendered="#{rdvmercredi.bcmEtatLivraison==7}"/><br>
                            </rich:column>
                            <rich:column  width="70%">
                                <h:outputText value="#{rdvmercredi.texteAffiche}" style="#{rdvmercredi.color}"/>
                            </rich:column>
                            <rich:column width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche03&&rdvmercredi.bcmEtat==0&&rdvmercredi.bcmId==0}">
                                <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.supprimerRdvCol03}" reRender="idrdvmercredi"/>
                            </rich:column>
                        </rich:dataTable>
                    </rich:column>
                    <rich:column width="14%" style="height: 70px;"  sortable="false">
                        <f:facet name="header" ><h:outputText value="Jeudi"/></f:facet>
                        <h:outputText value="#{rdv.jeudi}" styleClass="textAligneCalendar"/>&nbsp;&nbsp;
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.ajouterRdvCol04}" reRender="panelRdv" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche04&&rdv.jeudi!=''}"/><br>
                        <rich:dataTable value="#{rdv.dataModelJeudi}" var="rdvjeudi" id="idrdvjeudi" width="100%" border="0" onRowMouseOver="this.style.backgroundColor='#A1A1A1'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.modifDateCol04}" reRender="panelEvent,panelRdv"/>
                            <rich:column width="20%">
                                <h:outputText value="#{rdvjeudi.periode}" style="#{rdvjeudi.color}"/><br>
                                <h:outputText value="(#{rdvjeudi.bcmCompteurReport})" style="color:red" rendered="#{rdvjeudi.bcmCompteurReport!=0}"/><br>
                                <h:outputText value="(HIB.)" style="color:red" rendered="#{rdvjeudi.bcmEtatLivraison==7}"/><br>
                            </rich:column>
                            <rich:column width="70%">
                                <h:outputText value="#{rdvjeudi.texteAffiche}" style="#{rdvjeudi.color}"/>
                            </rich:column>
                            <rich:column width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche04&&rdvjeudi.bcmEtat==0&&rdvjeudi.bcmId==0}">
                                <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.supprimerRdvCol04}" reRender="idrdvjeudi"/>
                            </rich:column>
                        </rich:dataTable>
                    </rich:column>
                    <rich:column width="14%" style="height: 70px;"  sortable="false">
                        <f:facet name="header" ><h:outputText value="Vendredi"/></f:facet>
                        <h:outputText value="#{rdv.vendredi}" styleClass="textAligneCalendar"/>&nbsp;&nbsp;
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.ajouterRdvCol05}" reRender="panelRdv" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche05&&rdv.vendredi!=''}"/><br>
                        <rich:dataTable value="#{rdv.dataModelVendredi}" var="rdvvendredi" id="idrdvvendredi" width="100%" border="0" onRowMouseOver="this.style.backgroundColor='#A1A1A1'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.modifDateCol05}" reRender="panelEvent,panelRdv"/>
                            <rich:column  width="20%">
                                <h:outputText value="#{rdvvendredi.periode}" style="#{rdvvendredi.color}"/><br>
                                <h:outputText value="(#{rdvvendredi.bcmCompteurReport})" style="color:red" rendered="#{rdvvendredi.bcmCompteurReport!=0}"/><br>
                                <h:outputText value="(HIB.)" style="color:red" rendered="#{rdvvendredi.bcmEtatLivraison==7}"/><br>
                            </rich:column>
                            <rich:column  width="70%">
                                <h:outputText value="#{rdvvendredi.texteAffiche}" style="#{rdvvendredi.color}"/>
                            </rich:column>
                            <rich:column width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche05&&rdvvendredi.bcmEtat==0&&rdvendredi.bcmId==0}">
                                <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.supprimerRdvCol05}" reRender="idrdvvenredi"/>
                            </rich:column>
                        </rich:dataTable>
                    </rich:column>
                    <rich:column width="14%" style="height: 70px;"  sortable="false">
                        <f:facet name="header" ><h:outputText value="Samedi" style="color:red;"/></f:facet>
                        <h:outputText value="#{rdv.samedi}" styleClass="textAligneCalendar" style="color:red;"/>&nbsp;&nbsp;
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.ajouterRdvCol06}" reRender="panelRdv" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche06&&rdv.samedi!=''}"/><br>
                        <rich:dataTable value="#{rdv.dataModelSamedi}" var="rdvsamedi" id="idrdvsamedi" width="100%" border="0" onRowMouseOver="this.style.backgroundColor='#A1A1A1'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.modifDateCol06}" reRender="panelEvent,panelRdv"/>
                            <rich:column  width="20%">
                                <h:outputText value="#{rdvsamedi.periode}" style="#{rdvsamedi.color}"/><br>
                                <h:outputText value="(#{rdvsamedi.bcmCompteurReport})" style="color:red" rendered="#{rdvsamedi.bcmCompteurReport!=0}"/><br>
                                <h:outputText value="(HIB.)" style="color:red" rendered="#{rdvsamedi.bcmEtatLivraison==7}"/><br>
                            </rich:column>
                            <rich:column  width="70%">
                                <h:outputText value="#{rdvsamedi.texteAffiche}" style="#{rdvsamedi.color}"/>
                            </rich:column>
                            <rich:column width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche06&&rdvsamedi.bcmEtat==0&&rdvsamedi.bcmId==0}">
                                <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.supprimerRdvCol06}" reRender="idrdvsamedi"/>
                            </rich:column>
                        </rich:dataTable>
                    </rich:column>
                    <rich:column width="14%" style="height: 70px;"  sortable="false">
                        <f:facet name="header" ><h:outputText value="Dimanche" style="color:red;"/></f:facet>
                        <h:outputText value="#{rdv.dimanche}" styleClass="textAligneCalendar" style="color:red;"/>&nbsp;&nbsp;
                        <a4j:commandButton image="/images/ajouter.png" style="height:15px;width:15px" title="Ajouter Evènement" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.ajouterRdvCol07}" reRender="panelRdv" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche07&&rdv.dimanche!=''}"/><br>
                        <rich:dataTable value="#{rdv.dataModelDimanche}" var="rdvdimanche" id="idrdvdimanche" width="100%" border="0" onRowMouseOver="this.style.backgroundColor='#A1A1A1'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.modifDateCol07}" reRender="panelEvent,panelRdv"/>
                            <rich:column  width="20%">
                                <h:outputText value="#{rdvdimanche.periode}" style="#{rdvdimanche.color}"/><br>
                                <h:outputText value="(#{rdvdimanche.bcmCompteurReport})" style="color:red" rendered="#{rdvdimanche.bcmCompteurReport!=0}"/><br>
                                <h:outputText value="(HIB.)" style="color:red" rendered="#{rdvdimanche.bcmEtatLivraison==7}"/><br>
                            </rich:column>
                            <rich:column  width="70%">
                                <h:outputText value="#{rdvdimanche.texteAffiche}" style="#{rdvdimanche.color}"/>
                            </rich:column>
                            <rich:column width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&rdv.affiche06&&rdvdimanche.bcmEtat==0&&rdvdimanche.bcmId==0}">
                                <a4j:commandButton image="/images/supprimer.png" style="height:15px;width:15px" title="Supprimer Evènement" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.supprimerRdvCol07}" reRender="idrdvdimanche"/>
                            </rich:column>
                        </rich:dataTable>
                    </rich:column>
                </rich:dataTable>
            </rich:tab>

            <rich:tab name="semaine" label="Par Semaine">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.modeSemaine}"/>
                <h:panelGrid columns="11">
                    <a4j:commandButton title="Semaine précédente" image="/images/precedent.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.chargerLesRdvBySemainePrecedent}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRdv2,idDateSemaine"/>
                    <h:column>
                        <rich:calendar style=" background-color:white;" id="idDateSemaine" locale="FR" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.parSemaine}" datePattern="dd/MM/yyyy"  inputSize="8" enableManualInput="false"/>
                    </h:column>
                    <a4j:commandButton title="Semaine suivante" image="/images/suivant.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.chargerLesRdvBySemaineSuivant}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRdv2,idDateSemaine"/>
                    <h:column><h:outputText value="Mode:"/></h:column>
                    <h:column>
                        <h:selectOneMenu  style="width:150px"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.valNatSemaine}"  >
                            <f:selectItem itemLabel="Tous les modes" itemValue="99"/>
                            <f:selectItem itemLabel="Non spécifié" itemValue="0"/>
                            <f:selectItem itemLabel="Livraison simple" itemValue="1"/>
                            <f:selectItem itemLabel="Livraison + Pose" itemValue="2"/>
                            <f:selectItem itemLabel="Livraison hors planning" itemValue="3"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column> <h:outputText value="Statut:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.valStatutSemaine}">
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
                    <a4j:commandButton value="Rechercher" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.chargerLesRdvBySemaine}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRdv2,idDateSemaine"/>&nbsp;&nbsp;
                    <a4j:commandButton title="Imprimer la Semaine" image="/images/print.png" reRender="printPlanning" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.initImpressionPlanning}"/>
                </h:panelGrid> <br>
                <rich:dataTable style="max-height:100%"  styleClass="bg" id="tableRdv2" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.datamodelLesRdvParSemaine}" var="rdv" >
                    <rich:column  width="9%" sortable="true" sortBy="#{rdv.heure}" sortOrder="ASCENDING">
                        <f:facet name="header" ><h:outputText value="Heure"/></f:facet>
                        <h:outputText value="#{rdv.heure}" style="font-weight:bold;"/>
                    </rich:column>
                    <rich:column  width="13%" sortable="false">
                        <f:facet name="header" ><h:outputText value="Lundi #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.dateLun}"/></f:facet>
                        <h:outputText value="#{rdv.lundi}" style="#{rdv.color}"/>
                    </rich:column>
                    <rich:column width="13%" sortable="false" id="idMardiSemaine">
                        <f:facet name="header" ><h:outputText value="Mardi #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.dateMar}"/></f:facet>
                        <h:outputText value="#{rdv.mardi}" style="#{rdv.color}"/>
                    </rich:column>
                    <rich:column width="13%" sortable="false" >
                        <f:facet name="header" ><h:outputText value="Mercredi #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.dateMer}"/></f:facet>
                        <h:outputText value="#{rdv.mercredi}" style="#{rdv.color}"/>
                    </rich:column>
                    <rich:column width="13%" sortable="false">
                        <f:facet name="header" ><h:outputText value="Jeudi #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.dateJeu}"/></f:facet>
                        <h:outputText value="#{rdv.jeudi}" style="#{rdv.color}"/>
                    </rich:column>
                    <rich:column width="13%" sortable="false">
                        <f:facet name="header" ><h:outputText value="Vendredi #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.dateVen}"/></f:facet>
                        <h:outputText value="#{rdv.vendredi}" style="#{rdv.color}"/>
                    </rich:column>
                    <rich:column width="13%" sortable="false">
                        <f:facet name="header" ><h:outputText value="Samedi #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.dateSam}" style="color:red;"/></f:facet>
                        <h:outputText value="#{rdv.samedi}" style="color:red;"/>
                    </rich:column>
                    <rich:column width="13%" sortable="false">
                        <f:facet name="header" ><h:outputText value="Dimanche #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.dateDim}" style="color:red;"/></f:facet>
                        <h:outputText value="#{rdv.dimanche}" style="color:red;"/>
                    </rich:column>
                </rich:dataTable>
            </rich:tab>

            <rich:tab name="jour" label="Par Jour">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.modeJour}"/>
                <h:panelGrid columns="11">
                    <a4j:commandButton title="Jour précédent" image="/images/precedent.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.chargerLesRdvByJourPrecedent}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRdv3,idDateJour"/>
                    <h:column>
                        <rich:calendar style=" background-color:white;" id="idDateJour" locale="FR" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.parJour}" datePattern="dd/MM/yyyy"  inputSize="8" enableManualInput="false"/>
                    </h:column>
                    <a4j:commandButton title="Jour suivant" image="/images/suivant.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.chargerLesRdvByJourSuivant}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRdv3,idDateJour"/>
                    <h:column><h:outputText value="Mode:"/></h:column>
                    <h:column>
                        <h:selectOneMenu  style="width:150px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.valNatJour}"  >
                            <f:selectItem itemLabel="Tous les modes" itemValue="99"/>
                            <f:selectItem itemLabel="Non spécifié" itemValue="0"/>
                            <f:selectItem itemLabel="Livraison simple" itemValue="1"/>
                            <f:selectItem itemLabel="Livraison + Pose" itemValue="2"/>
                            <f:selectItem itemLabel="Livraison hors planning" itemValue="3"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column> <h:outputText value="Statut:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.valStatutJour}">
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
                    <a4j:commandButton value="Rechercher" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.chargerLesRdvByJour}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRdv3,idDateJour"/>&nbsp;&nbsp;
                    <a4j:commandButton title="Imprimer le Jour" image="/images/print.png" reRender="printPlanning" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.initImpressionPlanning}"/>
                </h:panelGrid> <br>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable style="max-height:100%" enableContextMenu="false" styleClass="bg" id="tableRdv3" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.datamodelLesRdvParJour}" var="rdv" >
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.selectionLigneJour}" reRender="panelEvent"/>
                        <rich:column width="10%" sortable="false" sortBy="#{rdv.bcmHoraireLivraison} #{rdv.periode}" sortOrder="ASCENDING">
                            <f:facet name="header" ><h:outputText value="Heure"/></f:facet>
                            <h:outputText value="#{rdv.periode}" style="#{rdv.color}"/>&nbsp;&nbsp;&nbsp;
                            <h:outputText value="(#{rdv.bcmCompteurReport})" style="color:red" rendered="#{rdv.bcmCompteurReport!=0}"/>
                            <h:outputText value="(HIB.)" style="color:red" rendered="#{rdv.bcmEtatLivraison==7}"/>
                        </rich:column>
                        <rich:column width="10%" sortable="false">
                            <f:facet name="header" ><h:outputText value="N° BC"/></f:facet>
                            <h:outputText value="#{rdv.bcmNum}" style="#{rdv.color}"/>
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
                        <rich:column width="20%" sortable="false">
                            <f:facet name="header" ><h:outputText value="Objet"/></f:facet>
                            <h:outputText value="#{rdv.bcmObject}" style="#{rdv.color}"/>
                        </rich:column>
                        <rich:column width="10%" sortable="false">
                            <f:facet name="header" ><h:outputText value="Agent"/></f:facet>
                            <h:outputText value="#{rdv.bcmNomResponsable}" style="#{rdv.color}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </rich:tab>

            <rich:tab name="parliste" label="Par Liste">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.modeListe}"/>
                <h:panelGrid columns="2">
                    <h:panelGrid id="pngBouton" columns="3" width="100px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                    </h:panelGrid>
                    <h:panelGrid columns="12">
                        <h:outputText value="Du"/>
                        <rich:calendar style="background-color:white;" locale="FR" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.jourDeb}"  enableManualInput="true" datePattern="dd/MM/yyyy"  inputSize="8" />
                        <h:outputText value="Au"/>
                        <rich:calendar style=" background-color:white;" locale="FR" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.jourFin}"  enableManualInput="true" datePattern="dd/MM/yyyy"  inputSize="8" />
                        <h:column> <h:outputText value="Mode:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:150px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.valNatListe}"  >
                                <f:selectItem itemLabel="Tous les modes" itemValue="99"/>
                                <f:selectItem itemLabel="Non spécifié" itemValue="0"/>
                                <f:selectItem itemLabel="Livraison simple" itemValue="1"/>
                                <f:selectItem itemLabel="Livraison + Pose" itemValue="2"/>
                                <f:selectItem itemLabel="Livraison hors planning" itemValue="3"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column> <h:outputText value="Statut:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.valStatutListe}">
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
                        <a4j:commandButton value="Rechercher" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.chargerLesRdv}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableRdv4"/>&nbsp;&nbsp;
                        <a4j:commandButton title="Imprimer la Liste" image="/images/print.png" reRender="printPlanning" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.initImpressionPlanning}"/>
                    </h:panelGrid>
                </h:panelGrid>
                <br>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable style="max-height:100%" enableContextMenu="false" styleClass="bg" id="tableRdv4" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.datamodelRdv}" var="rdv" >
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.selectionLigneListe}" reRender="panelEvent"/>
                        <rich:column width="10%" sortable="true" sortBy="#{rdv.bcmDateLivraison} #{rdv.periode}" sortOrder="ASCENDING">
                            <f:facet name="header" ><h:outputText value="Date"/></f:facet>
                            <h:outputText value="#{rdv.bcmDateLivraison}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>&nbsp;
                            <h:outputText value="#{rdv.periode}" style="#{rdv.color}"/>
                        </rich:column>
                        <rich:column width="10%" sortable="true" sortBy="#{rdv.bcmNum}">
                            <h:outputText value="(#{rdv.bcmCompteurReport})" style="color:red" rendered="#{rdv.bcmCompteurReport!=0}"/>
                            <h:outputText value="(HIB.)" style="color:red" rendered="#{rdv.bcmEtatLivraison==7}"/>
                        </rich:column>
                        <rich:column width="10%" sortable="true" sortBy="#{rdv.bcmNum}">
                            <f:facet name="header" ><h:outputText value="N° BC"/></f:facet>
                            <h:outputText value="#{rdv.bcmNum}" style="#{rdv.color}"/>
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
                        <rich:column width="30%" sortable="true"  sortBy="#{rdv.bcmObject}">
                            <f:facet name="header" ><h:outputText value="Objet"/></f:facet>
                            <h:outputText value="#{rdv.bcmObject}" style="#{rdv.color}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </rich:tab>

        </rich:tabPanel>

        <h:panelGroup>
            <center>
                <br>
                <a4j:commandButton value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.annule}" reRender="modAttente,idSubView"/>
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

    <rich:modalPanel domElementAttachment="parent"  id="panelEvent" width="700" height="450" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.showModalPanelPlanning}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.showModalPanelPlanning}" var="event" >
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
                                        <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmModeLivraison}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmEtatLivraison==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmEtatLivraison==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmEtatLivraison==5||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmEtatLivraison==6}">
                                            <f:selectItem  itemLabel="Non spécifié" itemValue="0"/>
                                            <f:selectItem  itemLabel="Livraison simple" itemValue="1"/>
                                            <f:selectItem  itemLabel="Livraison + pose" itemValue="2"/>
                                            <f:selectItem  itemLabel="Livraison hors planning" itemValue="3"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Lieu livraison:"/></h:column>
                                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmLieuLivraison}" style="width:95%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmEtatLivraison==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmEtatLivraison==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmEtatLivraison==5||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmEtatLivraison==6}" maxlength="100"/></h:column>
                                    <h:column><h:outputText value="Date livraison:"/></h:column>
                                    <h:column>
                                        <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmDateLivraison}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmEtatLivraison==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmEtatLivraison==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmEtatLivraison==5||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmEtatLivraison==6}"></rich:calendar>
                                    </h:column>
                                    <h:column><h:outputText value="Heure livraison:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmHoraireLivraison}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmEtatLivraison==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmEtatLivraison==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmEtatLivraison==5||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmEtatLivraison==6}">
                                            <f:selectItem  itemLabel="Non spécifié" itemValue="0"/>
                                            <f:selectItem  itemLabel="Matin (AM)" itemValue="1"/>
                                            <f:selectItem  itemLabel="Aprés midi (PM)" itemValue="2"/>
                                            <f:selectItem  itemLabel="Heure précise" itemValue="3"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="idModeLivraison,idHoraire1,idHoraire2"/>
                                        </h:selectOneMenu>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <h:outputText id="idHoraire1" value="Heure précise:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmHoraireLivraison==3}"/>&nbsp;&nbsp;
                                        <h:selectOneMenu id="idHoraire2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmHeureLivraison}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmEtatLivraison==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmEtatLivraison==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmEtatLivraison==5||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmEtatLivraison==6}" style="width:45px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmHoraireLivraison==3}">
                                            <f:selectItem  itemLabel="NP" itemValue="00"/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Info livraison:"/></h:column>
                                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmInfoLivraison}" style="width:95%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmEtatLivraison==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmEtatLivraison==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmEtatLivraison==5||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmEtatLivraison==6}" maxlength="100"/></h:column>
                                    <h:column><h:outputText value="Contact livraison:"/></h:column>
                                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmContactLivraison}" style="width:95%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmEtatLivraison==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmEtatLivraison==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmEtatLivraison==5||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmEtatLivraison==6}" maxlength="50"/></h:column>
                                    <h:column><h:outputText value="Téléphone contact:"/></h:column>
                                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmTelephoneLivraison}" style="width:300px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmEtatLivraison==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmEtatLivraison==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmEtatLivraison==5||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmEtatLivraison==6}" maxlength="20"/></h:column>
                                </h:panelGrid>
                                <br>
                                <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" styleClass="fichefournisseur">
                                    <h:column><h:outputText value="Etat rendez-vous:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmEtatLivraison}">
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
                                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmObservationLivraison}" style="width:95%" maxlength="50"/></h:column>
                                </h:panelGrid>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab id="tabCommande" label="Commande">

                            <h:panelGrid width="100%" style="background-color:#DAEECB;height:110px" id="idpanel1">
                                <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos30g,clos5d,clos21g,clos12d,clos21g" id="panelDate">
                                    <h:column><h:outputText value="Date:"/></h:column>
                                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmDate}"  inputSize="8" datePattern="dd/MM/yyyy HH:MM:ss" locale="fr" style=" background-color:white;" disabled="true" readonly="true"></rich:calendar></h:column>
                                    <h:column><h:outputText value="N°:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmNum}" readonly="true" disabled="true"/></h:column>
                                    <h:column><h:outputText value="Série:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:inputText style="width:30%" id="idSerie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmSerie}" disabled="true"/>&nbsp;&nbsp;
                                        <h:inputText style="width:30%" id="idDevise" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmDevise}" disabled="true"/>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="panelTiers" width="100%" columns="4" columnClasses="clos12d,clos55g,clos12d,clos21g">
                                    <h:column><h:outputText value="Nom client:" style="text-decoration:underline;width:100%"/></h:column>
                                    <h:column><h:inputText style="width:90%" id="idTiers" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmNomTiers}" disabled="true" readonly="true"/>&nbsp;</h:column>
                                    <h:column><h:outputText value="Catégorie:" style="text-decoration:underline;"/></h:column>
                                    <h:column><h:inputText style="width:100%" id="idCat" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmCat}" disabled="true"/></h:column>
                                </h:panelGrid>
                                <h:panelGroup id="panelTiersInformations" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.informationsTiers!=null}">
                                    <center>
                                        <h:outputText value="Message :  #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.informationsTiers}" style="color:red;font-weight:bold;font-size:20px,text-decoration: blink;"/>
                                    </center>
                                </h:panelGroup>
                                <h:panelGrid id="panelContact" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                    <h:column>
                                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.var_libcondest}:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmDiversTiers==0}"/>
                                        <h:outputText value="Nom Divers:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmDiversTiers==99}"/>
                                    </h:column>
                                    <h:column>
                                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmDiversTiers==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.contDest=='false'}">
                                            <h:inputText id="idPanelContact" style="width:80%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmNomContact}" disabled="true"/>
                                        </c:if>
                                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmDiversTiers==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.contDest=='true'}">
                                            <h:inputText id="idDestinataire" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmNomContact}" readonly="true"/>
                                        </c:if>
                                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmDiversTiers==99}">
                                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmDiversNom}" readonly="true"/>
                                        </c:if>
                                    </h:column>
                                    <h:column><h:outputText value="Responsable:" style="text-decoration:underline;"/></h:column>
                                    <h:column id="idResponsable">
                                        <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmNomResponsable}" disabled="true"/>
                                    </h:column>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.optionsVentes.responsable=='0'}">
                                        <h:column><h:outputText value="Objet:"/></h:column>
                                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmObject}" readonly="true" disabled="true"/></h:column>
                                    </c:if>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.optionsVentes.responsable!='0'}">
                                        <h:column><h:outputText value="Commercial:" style="text-decoration:underline;"/></h:column>
                                        <h:column>
                                            <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmNomCommercial}" disabled="true"/>
                                        </h:column>
                                    </c:if>
                                </h:panelGrid>
                                <h:panelGrid id="idTiersDivers" columns="2" style="background-color:white;" columnClasses="clos15,clos35,clos15,clos35" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmDiversTiers==99}">
                                    <h:column><h:outputText value="Adressé à:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmDiversAdresse}" readonly="true" disabled="true"/></h:column>
                                    <h:column><h:outputText value="Ville:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmDiversVille}" readonly="true" disabled="true"/></h:column>
                                    <h:column><h:outputText value="Téléphone:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmDiversTel}" readonly="true" disabled="true"/></h:column>
                                    <h:column><h:outputText value="Mail:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.commandeEnteteVentes.bcmDiversMail}" readonly="true" disabled="true"/></h:column>
                                </h:panelGrid>
                            </h:panelGrid>

                        </rich:tab>

                        <rich:tab id="tabProduit" label="Produits">
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable id="tableLigne" height="300px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " styleClass="bg" style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.datamodelLigne}" var="doclig">
                                    <rich:column sortable="false" width="15%">
                                        <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                        <h:outputText  value="#{doclig.bcmligCode}" style="#{doclig.styleLigne}"/>&nbsp;&nbsp;
                                        <h:outputText value="PROCESS" style="color:red;#{doclig.styleLigne}" rendered="#{doclig.bcmligProcess==1}"/>&nbsp;&nbsp;
                                        <h:outputText  value="#{doclig.bcmligGroupe}" style="#{doclig.styleLigne}" rendered="#{doclig.bcmligModeGroupe==2}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="40%">
                                        <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                        <h:outputText value="#{doclig.bcmligLibelle}" style="#{doclig.styleLigne}"/><br>
                                        <h:outputText value="#{doclig.bcmligComplement}" rendered="#{doclig.bcmligComplement!=null}" style="#{doclig.styleLigne}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="15%" >
                                        <f:facet name="header"><h:outputText  value="Dépôt"/></f:facet>
                                        <h:outputText value="#{doclig.bcmligDepot}" style="#{doclig.styleLigne}"/>
                                    </rich:column>
                                    <rich:column sortable="false" style="text-align:right" width="15%" >
                                        <f:facet name="header"><h:outputText  value="Qté"/></f:facet>
                                        <h:outputText value="#{doclig.bcmligQte}" style="#{doclig.styleLigne}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.optionsVentes.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.optionsVentes.nbDecQte}"/>
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
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.fermerPlanning}" image="/images/annuler_big.png" reRender="panelEvent"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.validerPlanning}" image="/images/valider_big.png" reRender="panelEvent,tableRdv1,tableRdv2,tableRdv3,tableRdv4"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelRdv" width="750" height="400" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.showModalPanelRdv}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.showModalPanelRdv}" var="event" >
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
                                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.rdv.rdvNature}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.rdvdetails}">
                                            <f:selectItem itemLabel="Rdv CMD" itemValue="12"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid width="100%" columnClasses="clos20,clos80"  columns="2">
                                    <h:column><h:outputText value="Date rdv:" /></h:column>
                                    <h:column>
                                        <rich:calendar style="background-color:green;color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.rdv.rdvDteDe}" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  disabled="true" readonly="true"/>&nbsp;&nbsp;&nbsp;&nbsp;
                                    </h:column>
                                    <h:column><h:outputText value="Mode:"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.rdv.rdvLieu}"  >
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
                                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.rdv.rdvHrDe}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.rdvdetails}">
                                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}" />
                                                    </h:selectOneMenu>
                                                </h:column>
                                                <h:column>h</h:column>
                                                <h:column>
                                                    <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.rdv.rdvMnDe}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.rdvdetails}">
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
                                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.rdv.rdvSujet}" maxlength="50"/></h:column>
                                    <h:column><h:outputText value="Description:" /></h:column>
                                    <h:column><h:inputTextarea id="idTexte" cols="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.rdv.rdvDescript}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.rdvdetails}"/></h:column>
                                </h:panelGrid>
                            </h:panelGrid>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabCr" label="Compte rendu" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.compteRendu}">
                        <h:panelGrid  width="100%" headerClass="headerTab" styleClass="panneau_accueil" >
                            <h:panelGrid style="width:100%;">
                                <h:panelGrid style="width:100%;" columnClasses="clos20,clos80" columns="2">
                                    <h:column><h:outputText value="Etat:" /></h:column>
                                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.rdv.rdvEtat}">
                                        <f:selectItem itemLabel="En cours" itemValue="0"/>
                                        <f:selectItem itemLabel="Traité" itemValue="1"/>
                                        <f:selectItem itemLabel="Reporté" itemValue="2"/>
                                        <f:selectItem itemLabel="Annulé" itemValue="3"/>
                                    </h:selectOneMenu>
                                    <h:column><h:outputText value="Compte rendu:" /></h:column>
                                    <h:column><h:inputTextarea rows="15" cols="80" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.rdv.rdvCr}"/></h:column>
                                </h:panelGrid>
                            </h:panelGrid>
                        </h:panelGrid>
                    </rich:tab>

                </rich:tabPanel>
                <br>
                <h:panelGroup id="buttEvent">
                    <center>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.annulerRdv}" image="/images/annuler_big.png" reRender="panelRdv"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.saveEventRdv}" image="/images/valider_big.png" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.rdvdetails||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.compteRendu}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelRdv,tableRdv1,tableRdv2,tableRdv3,tableRdv4"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="printPlanning" width="650" height="350" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.showModalPanelPrintPlanning}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.showModalPanelPrintPlanning}" var="prp">
            <f:facet name="header"><h:outputText value="Impression des plannings"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.fermerPrintPlanning}" image="/images/close.gif" styleClass="hidelink" reRender="printPlanning"/>
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
                        <h:selectOneMenu id="docSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.nomModeleDocument}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.planningImpressionsItems}"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%" style="border:solid 0px green;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <h:panelGrid  width="100%" columns="9" style="height:80px">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                <center>
                                    <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes du serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                                    <h:selectOneMenu id="impSelect1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                    </h:selectOneMenu>
                                </center>
                            </h:panelGroup>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.imprimerJRVPlanning}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.imprimerPDFPlanning}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.imprimerODTPlanning}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.imprimerXLSPlanning}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.imprimerDOCPlanning}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.imprimerHTMLPlanning}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.imprimerXMLPlanning}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
