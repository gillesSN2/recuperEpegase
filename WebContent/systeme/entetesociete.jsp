<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="connectionCompte">

    <a4j:form enctype="multipart/form-data">

        <center><h2><h:outputText style="color:green;text-transform:uppercase;" value="Entête de la société" /></h2></center>

        <rich:tabPanel switchType="client" immediate="true"   width="100%" style="border:0px">

            <rich:tab  name="identification" label="Identification société">

                <center>
                    <h:panelGrid  width="100%">
                        <h:panelGrid width="100%">
                            <h:panelGrid width="100%" styleClass="fichefournisseur">
                                <h:panelGrid columns="2" width="100%" columnClasses="clos15,clos85">
                                    <h:column><h:outputText value="Raison Sociale:"/></h:column>
                                    <h:column><h:inputText  size="110" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strraisonsociale}" readonly="true"/></h:column>
                                </h:panelGrid>
                                <h:panelGrid id="slDv" columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                                    <h:column><h:outputText  value="Sigle:" /></h:column>
                                    <h:column><h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strsigle}" /></h:column>
                                    <h:column><h:outputText style="text-decoration:underline;" value="Forme Juridique:" /></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:211;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strformejuridique}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.mesFormeJuridiqueItem}" />
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText style="text-decoration:underline;" value="Type Entreprise:"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:211;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strtypeentreprise}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.mesTypeEntrepriseItem}" />
                                        </h:selectOneMenu>
                                    </h:column>

                                    <h:column><h:outputText value="Pays:" /></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:211;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strnompays}" >
                                            <a4j:support eventsQueue="maQueue" reRender="slDv" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.selectionElement}"/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.mesPaysItem}" />
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="langue:" /></h:column>
                                    <h:column><h:inputText style="width:211;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strlangue}" readonly="true"  /></h:column>
                                    <h:column><h:outputText value="Devise:" /></h:column>
                                    <h:column><h:inputText style="width:211;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strdevise}" readonly="true"  /></h:column>
                                    <h:column><h:outputText style="text-decoration:underline;" value="Zone Commerciale:" /></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:211;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strzonecommerciale}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.mesZoneCommercialeItem}" />
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText style="text-decoration:underline;" value="Zone Fiscale:" /></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:211;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strzonefiscale}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.mesZoneFiscaleItem}" />
                                        </h:selectOneMenu>
                                    </h:column>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid width="100%">
                                <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                                    <h:outputText value="Adresse:" />
                                    <h:inputText size="30" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.stradresse}" />
                                    <h:outputText value="Ville:" />
                                    <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strville}" />
                                    <h:outputText value="Rue N°:" />
                                    <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strrue}" />
                                    <h:outputText value="Lot N°:" />
                                    <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strlot}"/>
                                    <h:outputText value="Ilot N°:" />
                                    <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strlot}" />
                                    <h:outputText value="Porte N°:" />
                                    <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strporte}"/>
                                    <h:outputText value="Bâtiment:" />
                                    <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strbatiment}" />
                                    <h:outputText value="Escalier:" />
                                    <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.stretage}" />
                                    <h:outputText value="Quartier:" />
                                    <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strquartier}" />
                                    <h:outputText value="Commune:" />
                                    <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strcommune}" />
                                    <h:outputText value="Zone:" />
                                    <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strzone}" />
                                    <h:outputText value="Département:" />
                                    <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strdepartement}"/>
                                    <h:outputText value="Boite Postale:"/>
                                    <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strbp}" />
                                    <h:outputText value="Cédex:" />
                                    <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strcedex}" />
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid width="100%" styleClass="fichefournisseur">
                                <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                                    <h:outputText value="Téléphone 1:" />
                                    <h:inputText size="30"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strtel1}"/>
                                    <h:outputText value="Téléphone 2:" />
                                    <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strtel2}" />
                                    <h:outputText value="Téléphone 3:" />
                                    <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strtel3}" />
                                    <h:outputText value="Fax:" />
                                    <h:inputText size="30" maxlength="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strfax}"/>
                                    <h:outputText value="Télex:" />
                                    <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strtelex}" />
                                    <h:outputText value=""/>
                                    <h:outputText value=""/>
                                    <h:column><h:outputText style="text-decoration:underline;" value="Format devise:"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:211;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strformatdevise}">
                                            <f:selectItem  itemValue="0" itemLabel="Format Dollar"/>
                                            <f:selectItem  itemValue="1" itemLabel="Format Euro"/>
                                            <f:selectItem  itemValue="2" itemLabel="Format CFA"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText style="text-decoration:underline;color:red;" value="Etat société:"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:210px;color:red;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.stretat}">
                                            <f:selectItem  itemValue="0" itemLabel="Non activé"/>
                                            <f:selectItem  itemValue="1" itemLabel="Activé"/>
                                            <f:selectItem  itemValue="2" itemLabel="Bloqué"/>
                                            <f:selectItem  itemValue="3" itemLabel="Clôturé"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText style="text-decoration:underline;color:red;" value="Mode fonction:"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:210px;color:red;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strmode}">
                                            <f:selectItem  itemValue="0" itemLabel="Full internet"/>
                                            <f:selectItem  itemValue="1" itemLabel="Full intranet"/>
                                            <f:selectItem  itemValue="2" itemLabel="Mixte"/>
                                            <f:selectItem  itemValue="3" itemLabel="Spécial"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText style="text-decoration:underline;color:red;" value="Groupe:"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:210px;color:red;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strmaitrecabinet}">
                                            <f:selectItem  itemValue="0" itemLabel="Société Autonome"/>
                                            <f:selectItem  itemValue="1" itemLabel="Cabinet"/>
                                            <f:selectItem  itemValue="2" itemLabel="Groupe"/>
                                            <f:selectItem  itemValue="3" itemLabel="Franchise"/>
                                            <f:selectItem  itemValue="4" itemLabel="Centre de Formation"/>
                                            <f:selectItem  itemValue="5" itemLabel="Distributeur"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                </h:panelGrid>
                            </h:panelGrid>

                        </h:panelGrid>
                    </h:panelGrid>
                </center>
            </rich:tab>

            <rich:tab   name="immatriculation" label="Immatriculations société">
                <center>
                    <h:panelGrid columns ="2" width="50%" columnClasses="clos20,clos80">
                        <h:column><h:outputText value="Libellé 1:" /></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strnum1}"/></h:column>
                        <h:column><h:outputText value="Libellé 2:"/></h:column>
                        <h:column><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strnum2}"/></h:column>
                        <h:column ><h:outputText value="Libellé 3:"/></h:column>
                        <h:column ><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strnum3}"/></h:column>
                        <h:column ><h:outputText value="Libellé 4:"/></h:column>
                        <h:column ><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strnum4}"/></h:column>
                        <h:column ><h:outputText value="Libellé 5:"/></h:column>
                        <h:column ><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strnum5}"/></h:column>
                        <h:column ><h:outputText value="Libellé 6:"/></h:column>
                        <h:column ><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strnum6}"/></h:column>
                        <h:column ><h:outputText value="Libellé 7:"/></h:column>
                        <h:column ><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strnum7}"/></h:column>
                        <h:column ><h:outputText value="Libellé 8:"/></h:column>
                        <h:column><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strnum8}"/></h:column>
                        <h:column ><h:outputText value="Libellé 9:"/></h:column>
                        <h:column ><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strnum9}"/></h:column>
                        <h:column ><h:outputText value="Libellé 10:"/></h:column>
                        <h:column ><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strnum10}"/></h:column>
                        <h:column ><h:outputText value="Libellé 11:"/></h:column>
                        <h:column ><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strnum11}"/></h:column>
                        <h:column ><h:outputText value="Libellé 12:"/></h:column>
                        <h:column ><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strnum12}"/></h:column>
                        <h:column ><h:outputText value="Libellé 13:"/></h:column>
                        <h:column ><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strnum13}"/></h:column>
                        <h:column ><h:outputText value="Libellé 14:"/></h:column>
                        <h:column ><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strnum14}"/></h:column>
                        <h:column ><h:outputText value="Libellé 15:"/></h:column>
                        <h:column ><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strnum15}"/></h:column>
                        <h:column ><h:outputText value="Libellé 16:"/></h:column>
                        <h:column ><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strnum16}"/></h:column>
                        <h:column ><h:outputText value="Libellé 17:"/></h:column>
                        <h:column ><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strnum17}"/></h:column>
                        <h:column ><h:outputText value="Libellé 18:"/></h:column>
                        <h:column ><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strnum18}"/></h:column>
                        <h:column ><h:outputText value="Libellé 19:"/></h:column>
                        <h:column ><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strnum19}"/></h:column>
                        <h:column ><h:outputText value="Libellé 20:"/></h:column>
                        <h:column ><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strnum20}"/></h:column>
                    </h:panelGrid>
                </center>
            </rich:tab>

            <rich:tab  name="module" label="Modules ">
                <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                    <h:outputText value="Module 1:" />
                    <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strmod1}"/>
                    <h:outputText value="Module 2:" />
                    <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strmod2}" />
                    <h:outputText value="Module 3:" />
                    <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strmod3}" />
                    <h:outputText value="Module 4:" />
                    <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strmod4}"/>
                    <h:outputText value="Module 5:" />
                    <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strmod5}" />
                    <h:outputText value="Module 6:" />
                    <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strmod6}"/>
                    <h:outputText value="Module 7:" />
                    <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strmod7}" />
                    <h:outputText value="Module 8:" />
                    <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strmod8}" />
                    <h:outputText value="Module 9:" />
                    <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strmod9}" />
                    <h:outputText value="Module 10:" />
                    <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formSystemSociete.structurePeg.strmod10}" />
                </h:panelGrid>
                <br><br>
                <center>
                    <h:panelGrid columns="2" width="50%" columnClasses="clos20,clos80" style="border:1px solid green;">
                        <h:outputText value="40100:" />
                        <h:outputText value="Comptabilité libérale" />
                        <h:outputText value="40200:" />
                        <h:outputText value="Comptabilité société" />
                        <h:outputText value="40300:" />
                        <h:outputText value="Comptabilité projet" />
                        <h:outputText value="50000:" />
                        <h:outputText value="Paye" />
                        <h:outputText value="60000:" />
                        <h:outputText value="Achats" />
                        <h:outputText value="60010:" />
                        <h:outputText value="Achats - Papéterie" />
                        <h:outputText value="60020:" />
                        <h:outputText value="Achats - Eleveur Poulet" />
                        <h:outputText value="70000:" />
                        <h:outputText value="Parc" />
                        <h:outputText value="80100:" />
                        <h:outputText value="Ventes standard" />
                        <h:outputText value="80700:" />
                        <h:outputText value="Microfinance" />
                        <h:outputText value="80900:" />
                        <h:outputText value="Education" />
                        <h:outputText value="81500:" />
                        <h:outputText value="Médical - Infirmerie" />
                        <h:outputText value="81510:" />
                        <h:outputText value="Médical - Cabinet Médical" />
                        <h:outputText value="81520:" />
                        <h:outputText value="Médical - Laboratoire" />
                        <h:outputText value="81530:" />
                        <h:outputText value="Médical - Pharmacie" />
                        <h:outputText value="81540:" />
                        <h:outputText value="Médical - Clinique" />
                        <h:outputText value="81550:" />
                        <h:outputText value="Médical - Hopital" />
                        <h:outputText value="81600:" />
                        <h:outputText value="Immobilier - Location" />
                        <h:outputText value="81610:" />
                        <h:outputText value="Immobilier - Syndic" />
                        <h:outputText value="81620:" />
                        <h:outputText value="Immobilier - Négoce" />
                        <h:outputText value="90000:" />
                        <h:outputText value="Gestion caisse" />
                    </h:panelGrid>
                </center>
            </rich:tab>
        </rich:tabPanel>
        <center>
            <h:panelGrid columns="2" width="400px">
                <h:commandButton styleClass="exp_lienmenu" value="Annuler" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.annulerStructure}"/>
                <h:commandButton styleClass="exp_lienmenu" value="Valider" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.modifStructureSel}"/>
            </h:panelGrid>
        </center>
    </a4j:form>
                
</f:subview>