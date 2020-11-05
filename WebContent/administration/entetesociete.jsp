<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<f:subview id="structureSoc">

    <a4j:form enctype="multipart/form-data">

        <center><h2><h:outputText style="color:green;text-transform:uppercase;" value="Entête de la société" /></h2></center>

        <rich:tabPanel switchType="client" immediate="true" width="100%" style="border:0px">

            <rich:tab  name="identification" label="Identification société">
                <center>
                    <h:panelGrid width="100%" styleClass="fichefournisseur">
                        <h:panelGrid columns="2" width="100%" columnClasses="clos15,clos85">
                            <h:column><h:outputText value="Raison Sociale:"/></h:column>
                            <h:column><h:inputText  style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strraisonsociale}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Descriptif:"/></h:column>
                            <h:column><h:inputText  style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdescriptif}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35" id="idIdentite">
                            <h:column><h:outputText  value="Sigle:" /></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strsigle}" /></h:column>
                            <h:column><h:outputText style="text-decoration:underline;" value="Type Entreprise:"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idTypeEntreprise" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strtypeentreprise}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.typeSociete.mesTypesSocietesItems}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText style="text-decoration:underline;" value="Forme Juridique:" /></h:column>
                            <h:column>
                                <h:selectOneMenu id="idFormeJuridique" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strformejuridique}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formJuridique.mesFormesJuridiquesItems}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText  value="Au capital de:" /></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strCapital}"/></h:column>
                            <h:column><h:outputText  value="Responsable:" /></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strResponsable}"/></h:column>
                            <h:column><h:outputText  value="En qualité de:" /></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strQualiteResponsable}"/></h:column>
                            <h:column><h:outputText value="Pays:" /></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strnompays}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Code ISO Pays:" /></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strisopays}"/></h:column>
                            <h:column><h:outputText value="langue:" /></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strlangue}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Devise:" /></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise}" readonly="true"/></h:column>
                            <h:column><h:outputText style="text-decoration:underline;" value="Zone Commerciale:" /></h:column>
                            <h:column>
                                <h:selectOneMenu id="idZoneCommerciale" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strzonecommerciale}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.zoneCommerciale.mesZonesCommercialesItems}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText style="text-decoration:underline;" value="Zone Fiscale principale:" /></h:column>
                            <h:column>
                                <h:selectOneMenu id="idZoneFiscaleN0" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strzonefiscale}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.zoneFiscales.mesZonesFiscalesItems}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText style="text-decoration:underline;" value="Bilan Social:" /></h:column>
                            <h:column>
                                <h:selectOneMenu id="idZoneBilan" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strbilansocial}">
                                    <f:selectItem itemLabel="Bilan Social Modèle 1" itemValue="BILAN_SOCIAL1"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText style="text-decoration:underline;" value="Zone Fiscale secondaire:" /></h:column>
                            <h:column id="idFiscal">
                                <h:selectOneMenu id="idZoneFiscaleN1" style="width:50%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strzonefiscale2}">
                                    <f:selectItem itemLabel="Sans fiscalité secondaire" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.zoneFiscales.mesZonesFiscalesItems}" />
                                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="idFiscal,idZoneFiscaleN1,idIdentite"/>
                                </h:selectOneMenu>&nbsp;&nbsp;
                                <h:outputText value="Date chg.:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strzonefiscale2!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strzonefiscale2!=''}"/>&nbsp;
                                <rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy" inputSize="8" locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdatefiscale2}" popup="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strzonefiscale2!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strzonefiscale2!=''}"/>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid width="100%">
                        <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                            <h:outputText value="Adresse:" />
                            <h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.stradresse}" />
                            <h:outputText value="Ville:" />
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strville}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/>
                            <h:outputText value="Rue N°:" />
                            <h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strrue}" />
                            <h:outputText value="Lot N°:" />
                            <h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strlot}"/>
                            <h:outputText value="Ilot N°:" />
                            <h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strlot}" />
                            <h:outputText value="Porte N°:" />
                            <h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strporte}"/>
                            <h:outputText value="Bâtiment:" />
                            <h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strbatiment}" />
                            <h:outputText value="Escalier:" />
                            <h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.stretage}" />
                            <h:outputText value="Quartier:" />
                            <h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strquartier}" />
                            <h:outputText value="Commune:" />
                            <h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcommune}" />
                            <h:outputText value="Zone:" />
                            <h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strzone}" />
                            <h:outputText value="Département:" />
                            <h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdepartement}"/>
                            <h:outputText value="Boite Postale:"/>
                            <h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strbp}" />
                            <h:outputText value="Cédex:" />
                            <h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcedex}" />
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid width="100%" styleClass="fichefournisseur">
                        <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                            <h:outputText value="Téléphone 1:" />
                            <h:inputText style="width:100%;"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strtel1}"/>
                            <h:outputText value="Téléphone 2:" />
                            <h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strtel2}" />
                            <h:outputText value="Téléphone 3:" />
                            <h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strtel3}" />
                            <h:outputText value="Fax:" />
                            <h:inputText style="width:100%;" maxlength="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strfax}"/>
                            <h:outputText value="Télex:" />
                            <h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strtelex}" />
                            <h:column><h:outputText value="Banque:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idBanque" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strBanqueDefaut}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.mesBanquesItems}" />
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid columns="2" width="100%" columnClasses="clos15,clos85">
                        <h:column><h:outputText value="Activités de l'entreprise:"/></h:column>
                        <h:column><h:inputTextarea  rows="4" cols="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.stractiviteCommerciale}"/></h:column>
                    </h:panelGrid>
                    <center>
                        <br>
                        <h:commandButton styleClass="exp_lienmenu" value="VALIDEZ" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.majStructure}" onclick="if (!confirm('Voulez-vous enregistrer les modifications ?')) return false;javascript:Richfaces.showModalPanel('modAttente');"></h:commandButton>
                    </center>
                </center>
            </rich:tab>

            <rich:tab name="logo" label="Logos société" style="width:100%">
                <center>
                    <h:panelGrid width="60%">
                        <h:outputText value="NE METTRE QUE DES IMAGES (JPG, PNG, BMP...)" />
                        <h:panelGrid id="l1" columns="4" style="border-bottom:solid 1px green;" width="100%">
                            <h:panelGroup style="border-right:solid 1px green;" id="tofLog1">
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLogo1!=null}">
                                    <img  alt="" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.baseLog}/photos/entete/${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLogo1}" width="100px" height="100px" />
                                </c:if>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLogo1==null}">
                                    <img alt="" src="images/no_image.jpeg" width="100px" height="100px" />
                                </c:if>
                            </h:panelGroup>
                            <h:outputLabel for="logo1" value="Ajoutez votre logo principal (1)" />
                            <t:inputFileUpload id="logo1" accept="image/*" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.uploadedFile}" />
                            <h:panelGroup>
                                <h:commandButton  styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.ajoutLogo1}"/>
                                <h:message for="logo1" infoStyle="color: green;" errorStyle="color: red;" />
                            </h:panelGroup>
                            <h:outputText value="" />
                            <h:panelGroup id="cancelTof1">
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLogo1!=null}">
                                    <a4j:commandButton image="/images/annuler.gif"title="supprimer logo1" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.reInitLogo1}" reRender="tofLog1,cancelTof1"/>
                                </c:if>
                            </h:panelGroup>
                        </h:panelGrid>
                        <h:panelGrid id="l2" columns="4" style="border-bottom:solid 1px green;"  width="100%">
                            <h:panelGroup style="border-right:solid 1px green;" id="tofLog2">
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLogo2!=null}">
                                    <img alt="" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.baseLog}/photos/entete/${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLogo2}" width="100px" height="100px" />
                                </c:if>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLogo2==null}">
                                    <img alt="" src="images/no_image.jpeg" width="100px" height="100px" />
                                </c:if>
                            </h:panelGroup>
                            <h:outputLabel for="logo2" value="Ajoutez votre logo secondaire (2)" />
                            <t:inputFileUpload id="logo2" accept="image/*"  storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.uploadedFileSecondaire}" />
                            <h:panelGroup>
                                <h:commandButton  styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.ajoutLogo2}"/>
                                <h:message for="logo2" infoStyle="color: green;" errorStyle="color: red;" />
                            </h:panelGroup>
                            <h:outputText value="" />
                            <h:panelGroup id="cancelTof2">
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLogo2!=null}">
                                    <a4j:commandButton image="/images/annuler.gif"title="supprimer logo2" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.reInitLogo2}" reRender="tofLog2,cancelTof2"/>
                                </c:if>
                            </h:panelGroup>
                        </h:panelGrid>
                        <h:panelGrid id="l3" columns="4" style="border-bottom:solid 1px green;" width="100%">
                            <h:panelGroup style="border-right:solid 1px green;" id="tofLog3">
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLogo3!=null}">
                                    <img alt="" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.baseLog}/photos/entete/${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLogo3}" width="100px" height="100px" />
                                </c:if>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLogo3==null}">
                                    <img alt="" src="images/no_image.jpeg" width="100px" height="100px" />
                                </c:if>
                            </h:panelGroup>
                            <h:outputLabel for="logo3" value="Ajoutez votre label de qualité (3)" />
                            <t:inputFileUpload accept="image/*" id="logo3"  storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.uploadedFileTertiaire}" />
                            <h:panelGroup>
                                <h:commandButton  styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.ajoutLogo3}"/>
                                <h:message for="logo3" infoStyle="color: green;" errorStyle="color: red;" />
                            </h:panelGroup>
                            <h:outputText value="" />
                            <h:panelGroup id="cancelTof3">
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLogo3!=null}">
                                    <a4j:commandButton image="/images/annuler.gif"title="supprimer logo3" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.reInitLogo3}" reRender="tofLog3,cancelTof3"/>
                                </c:if>
                            </h:panelGroup>
                        </h:panelGrid>
                        <h:panelGrid id="l4" columns="4"  width="100%">
                            <h:panelGroup style="border-right:solid 1px green;" id="tofLog4">
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLogo4!=null}">
                                    <img alt="" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.baseLog}/photos/entete/${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLogo4}" width="100px" height="100px" />
                                </c:if>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLogo4==null}">
                                    <img alt="" src="images/no_image.jpeg" width="100px" height="100px" />
                                </c:if>
                            </h:panelGroup>
                            <h:outputLabel for="logo4" value="Ajoutez le logo de votre groupe (4)" />
                            <t:inputFileUpload  id="logo4" accept="image/*" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.uploadedFileQuaternaire}" />
                            <h:panelGroup>
                                <h:commandButton  styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.ajoutLogo4}"/>
                                <h:message for="logo4" infoStyle="color: green;" errorStyle="color: red;" />
                            </h:panelGroup>
                            <h:outputText value="" />
                            <h:panelGroup id="cancelTof4">
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLogo4!=null}">
                                    <a4j:commandButton image="/images/annuler.gif"title="supprimer logo4" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.reInitLogo4}" reRender="tofLog4,cancelTof4"/>
                                </c:if>
                            </h:panelGroup>
                        </h:panelGrid>
                        <h:panelGrid id="l5" columns="4"  width="100%">
                            <h:panelGroup style="border-right:solid 1px green;" id="tofLog5">
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLogo5!=null}">
                                    <img alt="" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.baseLog}/photos/entete/${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLogo5}" width="100px" height="100px" />
                                </c:if>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLogo5==null}">
                                    <img alt="" src="images/no_image.jpeg" width="100px" height="100px" />
                                </c:if>
                            </h:panelGroup>
                            <h:outputLabel for="logo5" value="Ajoutez l'adresse normale (5)" />
                            <t:inputFileUpload  id="logo5" accept="image/*" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.uploadedFileCinq}" />
                            <h:panelGroup>
                                <h:commandButton  styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.ajoutLogo5}"/>
                                <h:message for="logo5" infoStyle="color: green;" errorStyle="color: red;" />
                            </h:panelGroup>
                            <h:outputText value="" />
                            <h:panelGroup id="cancelTof5">
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLogo5!=null}">
                                    <a4j:commandButton image="/images/annuler.gif"title="supprimer logo5" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.reInitLogo5}" reRender="tofLog5,cancelTof5"/>
                                </c:if>
                            </h:panelGroup>
                        </h:panelGrid>
                        <h:panelGrid id="l6" columns="4"  width="100%">
                            <h:panelGroup style="border-right:solid 1px green;" id="tofLog6">
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLogo6!=null}">
                                    <img alt="" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.baseLog}/photos/entete/${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLogo6}" width="100px" height="100px" />
                                </c:if>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLogo6==null}">
                                    <img alt="" src="images/no_image.jpeg" width="100px" height="100px" />
                                </c:if>
                            </h:panelGroup>
                            <h:outputLabel for="logo6" value="Ajoutez l'adresse réduite (6)" />
                            <t:inputFileUpload  id="logo6" accept="image/*" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.uploadedFileSix}" />
                            <h:panelGroup>
                                <h:commandButton  styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.ajoutLogo6}"/>
                                <h:message for="logo6" infoStyle="color: green;" errorStyle="color: red;" />
                            </h:panelGroup>
                            <h:outputText value="" />
                            <h:panelGroup id="cancelTof6">
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLogo6!=null}">
                                    <a4j:commandButton image="/images/annuler.gif"title="supprimer logo6" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.reInitLogo6}" reRender="tofLog6,cancelTof6"/>
                                </c:if>
                            </h:panelGroup>
                        </h:panelGrid>
                        <h:panelGrid id="l7" columns="4"  width="100%">
                            <h:panelGroup style="border-right:solid 1px green;" id="tofLog7">
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLogo7!=null}">
                                    <img alt="" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.baseLog}/photos/entete/${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLogo7}" width="100px" height="100px" />
                                </c:if>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLogo7==null}">
                                    <img alt="" src="images/no_image.jpeg" width="100px" height="100px" />
                                </c:if>
                            </h:panelGroup>
                            <h:outputLabel for="logo7" value="Ajoutez décoration 1 (7)" />
                            <t:inputFileUpload  id="logo7" accept="image/*" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.uploadedFileSept}" />
                            <h:panelGroup>
                                <h:commandButton  styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.ajoutLogo7}"/>
                                <h:message for="logo7" infoStyle="color: green;" errorStyle="color: red;" />
                            </h:panelGroup>
                            <h:outputText value="" />
                            <h:panelGroup id="cancelTof7">
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLogo7!=null}">
                                    <a4j:commandButton image="/images/annuler.gif"title="supprimer logo7" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.reInitLogo7}" reRender="tofLog7,cancelTof7"/>
                                </c:if>
                            </h:panelGroup>
                        </h:panelGrid>
                        <h:panelGrid id="l8" columns="4"  width="100%">
                            <h:panelGroup style="border-right:solid 1px green;" id="tofLog8">
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLogo8!=null}">
                                    <img alt="" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.baseLog}/photos/entete/${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLogo8}" width="100px" height="100px" />
                                </c:if>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLogo8==null}">
                                    <img alt="" src="images/no_image.jpeg" width="100px" height="100px" />
                                </c:if>
                            </h:panelGroup>
                            <h:outputLabel for="logo8" value="Ajoutez décoration 2 (8)" />
                            <t:inputFileUpload  id="logo8" accept="image/*" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.uploadedFileHuit}" />
                            <h:panelGroup>
                                <h:commandButton  styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.ajoutLogo8}"/>
                                <h:message for="logo8" infoStyle="color: green;" errorStyle="color: red;" />
                            </h:panelGroup>
                            <h:outputText value="" />
                            <h:panelGroup id="cancelTof8">
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLogo8!=null}">
                                    <a4j:commandButton image="/images/annuler.gif"title="supprimer logo8" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.reInitLogo8}" reRender="tofLog8,cancelTof8"/>
                                </c:if>
                            </h:panelGroup>
                        </h:panelGrid>

                        <h:panelGrid id="l9" columns="4"  width="100%">
                            <h:panelGroup style="border-right:solid 1px green;" id="tofLog9">
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLogo9!=null}">
                                    <img alt="" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.baseLog}/photos/entete/${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLogo9}" width="100px" height="100px" />
                                </c:if>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLogo9==null}">
                                    <img alt="" src="images/no_image.jpeg" width="100px" height="100px" />
                                </c:if>
                            </h:panelGroup>
                            <h:outputLabel for="logo9" value="Ajoutez décoration 3 (9)" />
                            <t:inputFileUpload  id="logo9" accept="image/*" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.uploadedFileNeuf}" />
                            <h:panelGroup>
                                <h:commandButton  styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.ajoutLogo9}"/>
                                <h:message for="logo8" infoStyle="color: green;" errorStyle="color: red;" />
                            </h:panelGroup>
                            <h:outputText value="" />
                            <h:panelGroup id="cancelTof9">
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLogo9!=null}">
                                    <a4j:commandButton image="/images/annuler.gif"title="supprimer logo9" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.reInitLogo9}" reRender="tofLog9,cancelTof9"/>
                                </c:if>
                            </h:panelGroup>
                        </h:panelGrid>
                        <h:panelGrid id="l10" columns="4"  width="100%">
                            <h:panelGroup style="border-right:solid 1px green;" id="tofLog10">
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLogo10!=null}">
                                    <img alt="" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.baseLog}/photos/entete/${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLogo10}" width="100px" height="100px" />
                                </c:if>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLogo10==null}">
                                    <img alt="" src="images/no_image.jpeg" width="100px" height="100px" />
                                </c:if>
                            </h:panelGroup>
                            <h:outputLabel for="logo10" value="Ajoutez Cachet entreprise" />
                            <t:inputFileUpload  id="logo10" accept="image/*" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.uploadedFileDix}" />
                            <h:panelGroup>
                                <h:commandButton  styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.ajoutLogo10}"/>
                                <h:message for="logo10" infoStyle="color: green;" errorStyle="color: red;" />
                            </h:panelGroup>
                            <h:outputText value="" />
                            <h:panelGroup id="cancelTof10">
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLogo10!=null}">
                                    <a4j:commandButton image="/images/annuler.gif"title="supprimer logo10" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.reInitLogo10}" reRender="tofLog10,cancelTof10"/>
                                </c:if>
                            </h:panelGroup>
                        </h:panelGrid>

                    </h:panelGrid>
                </center>
            </rich:tab>

            <rich:tab name="immatriculation" label="Immatriculations société">
                <center>
                    <h:panelGrid id="idNum" width="60%">
                        <h:panelGrid  style="background-color:#DAEECB;" columns ="2" width="100%" columnClasses="clos20,clos80"  headerClass="headerTab">
                            <f:facet name="header"><h:outputText value="Modules externes"/></f:facet>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm01=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm01}:" /></h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm01=='')==false}">
                                <h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strnum1}"/>&nbsp;&nbsp;
                                <h:outputText  value="(Identification fiscale)"/>
                            </h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm02=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm02}:"/></h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm02=='')==false}">
                                <h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strnum2}"/>&nbsp;&nbsp;
                                <h:outputText  value="(Registre du commerce)"/>
                            </h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm03=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm03}:"/></h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm03=='')==false}">
                                <h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strnum3}"/>&nbsp;&nbsp;
                                <h:outputText  value="(Caisse retraite)"/>
                            </h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm04=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm04}:"/></h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm04=='')==false}">
                                <h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strnum4}"/>&nbsp;&nbsp;
                                <h:outputText  value="(Assurance Maladie)"/>
                            </h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm05=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm05}:"/></h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm05=='')==false}">
                                <h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strnum5}"/>&nbsp;&nbsp;
                                <h:outputText  value="(Caisse Sécurité Sociale)"/>
                            </h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm06=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm06}:"/></h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm06=='')==false}"><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strnum6}"/></h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm07=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm07}:"/></h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm07=='')==false}"><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strnum7}"/></h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm08=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm08}:"/></h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm08=='')==false}"><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strnum8}"/></h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm09=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm09}:"/></h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm09=='')==false}"><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strnum9}"/></h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm10=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm10}:"/></h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm10=='')==false}"><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strnum10}"/></h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm11=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm11}:"/></h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm11=='')==false}"><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strnum11}"/></h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm12=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm12}:"/></h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm12=='')==false}"><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strnum12}"/></h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm13=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm13}:"/></h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm13=='')==false}"><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strnum13}"/></h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm14=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm14}:"/></h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm14=='')==false}"><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strnum14}"/></h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm15=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm15}:"/></h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm15=='')==false}"><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strnum15}"/></h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm16=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm16}:"/></h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm16=='')==false}"><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strnum16}"/></h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm17=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm17}:"/></h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm17=='')==false}"><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strnum17}"/></h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm18=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm18}:"/></h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm18=='')==false}"><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strnum18}"/></h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm19=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm19}:"/></h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm19=='')==false}"><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strnum19}"/></h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm20=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm20}:"/></h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm20=='')==false}"><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strnum20}"/></h:column>
                        </h:panelGrid>
                        <br>
                        <h:panelGrid columns ="2" width="100%" columnClasses="clos20,clos80">
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm03=='')==false}"><h:outputText value="Gestion #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm03}:" /></h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm03=='')==false}">
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strNumRetraiteMultiple}">
                                    <f:selectItem itemLabel="Un seul numéro #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm03}" itemValue="0"/>
                                    <f:selectItem itemLabel="Un numéro #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm03} par centre d'impôt" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm05=='')==false}"><h:outputText value="Gestion #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm05}:" /></h:column>
                            <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm05=='')==false}">
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strNumSecuMultiple}">
                                    <f:selectItem itemLabel="Un seul numéro #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm05}" itemValue="0"/>
                                    <f:selectItem itemLabel="Un numéro #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.pmoral.impm05} par centre" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <center>
                        <br>
                        <h:commandButton styleClass="exp_lienmenu" value="VALIDEZ" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.majStructure}" onclick="if (!confirm('Voulez-vous enregistrer les modifications ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" ></h:commandButton>
                    </center>
                </center>
            </rich:tab>

            <rich:tab name="messagerie" label="Comptes Messagerie société" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}">
                <h:panelGrid id="boutonBal" columns="5" width="400px" style="height:34px">
                    <a4j:commandButton image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.ajouterBal}" reRender="panelBal,formBal"/>
                    <a4j:commandButton image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.visibleBal}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.modifierBal}" reRender="panelBal,formBal"/>
                    <a4j:commandButton image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.visibleBal}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.supprimerBal}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="tableBal,boutonBal"/>
                    <a4j:commandButton image="/images/co-chef.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.visibleBal}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.defautBal}" onclick="if (!confirm('Etes-vous sur de vouloir définir cet élément comme élément par défaut?')) return false" reRender="tableBal,boutonBal"/>
                    <h:column>
                        <h:outputText value="Domaine émetteur:"/>&nbsp;&nbsp;
                        <h:selectOneMenu id="idChoixEmetteur" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strsmtChoix}">
                            <!--f:selectItem itemLabel="assistance@e-pegase.biz (Kheweul)" itemValue="0"/-->
                            <f:selectItem itemLabel="infos@e-pegase.biz" itemValue="6"/>
                            <!--f:selectItem itemLabel="infos@e-Pegase.info" itemValue="5" itemDisabled="true"/-->
                            <!--f:selectItem itemLabel="epegase.biz@gmail.com" itemValue="1" itemDisabled="true"/-->
                            <!--f:selectItem itemLabel="infos.epegase@yahoo.fr" itemValue="2" itemDisabled="true"/-->
                            <f:selectItem itemLabel="Mail société" itemValue="3"/>
                            <f:selectItem itemLabel="Mail user en cours" itemValue="4"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable style="max-height:100%;border:1px" styleClass="bg" id="tableBal" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.dataModelBal}" var="bal">
                        <a4j:support eventsQueue="maQueue" event="onRowClick"action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.selectionBal}" reRender="boutonBal"/>
                        <rich:column label="Administrateur" width="5%" sortable="true" sortBy="#{bal.balDefaut}" style="text-align:center;">
                            <f:facet name="header"> <h:outputText value="Défaut"/></f:facet>
                            <h:graphicImage value="/images/co-chef.png" rendered="#{bal.balDefaut==true}"/>
                        </rich:column>
                        <rich:column width="30%" sortable="true" sortBy="#{bal.balnomcompte}" >
                            <f:facet name="header"><h:outputText value="Nom du compte"/></f:facet>
                            <h:outputText value="#{bal.balnomcompte}" />
                        </rich:column>
                        <rich:column width="60%" sortable="true" sortBy="#{bal.baladressemail}">
                            <f:facet name="header"><h:outputText value="Adresse Mail"/></f:facet>
                            <h:outputText  value="#{bal.baladressemail}" />
                        </rich:column >
                        <rich:column  width="5%" sortable="true" sortBy="#{bal.usrfavInactif}">
                            <f:facet name="header"><h:outputText value="Etat" /></f:facet>
                            <h:commandButton image="#{bal.etat}"  rendered="#{bal.afficheImag}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </rich:tab>

            <rich:tab  name="Horaire" label="Horaires société">
                <center>
                    <h:panelGrid id="idHoraire" width="60%">
                        <h:panelGrid style="background-color:#DAEECB;" width="100%">
                            <h:panelGrid columns="2" columnClasses="clos15,clos35" width="100%" headerClass="headerTab">
                                <f:facet name="header"><h:outputText value="Horaires de travail standard"/></f:facet>
                                <h:column><h:outputText value="Heure début :"/></h:column>
                                <h:column>
                                    <h:panelGrid  columns="4">
                                        <h:column>
                                            <h:selectOneMenu id="idHeures" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strHrDeb}">
                                                <f:selectItem itemLabel="00" itemValue="00"/>
                                                <f:selectItem itemLabel="01" itemValue="01"/>
                                                <f:selectItem itemLabel="02" itemValue="02"/>
                                                <f:selectItem itemLabel="03" itemValue="03"/>
                                                <f:selectItem itemLabel="04" itemValue="04"/>
                                                <f:selectItem itemLabel="05" itemValue="05"/>
                                                <f:selectItem itemLabel="06" itemValue="06"/>
                                                <f:selectItem itemLabel="07" itemValue="07"/>
                                                <f:selectItem itemLabel="08" itemValue="08"/>
                                                <f:selectItem itemLabel="09" itemValue="09"/>
                                                <f:selectItem itemLabel="10" itemValue="10"/>
                                                <f:selectItem itemLabel="11" itemValue="11"/>
                                                <f:selectItem itemLabel="12" itemValue="12"/>
                                                <f:selectItem itemLabel="13" itemValue="13"/>
                                                <f:selectItem itemLabel="14" itemValue="14"/>
                                                <f:selectItem itemLabel="15" itemValue="15"/>
                                                <f:selectItem itemLabel="16" itemValue="16"/>
                                                <f:selectItem itemLabel="17" itemValue="17"/>
                                                <f:selectItem itemLabel="18" itemValue="18"/>
                                                <f:selectItem itemLabel="19" itemValue="19"/>
                                                <f:selectItem itemLabel="20" itemValue="20"/>
                                                <f:selectItem itemLabel="21" itemValue="21"/>
                                                <f:selectItem itemLabel="22" itemValue="22"/>
                                                <f:selectItem itemLabel="23" itemValue="23"/>
                                                <f:selectItem itemLabel="24" itemValue="24"/>
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column>h</h:column>
                                        <h:column>
                                            <h:selectOneMenu id="idMinutes" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strMnDeb}">
                                                <f:selectItem itemLabel="00" itemValue="00"/>
                                                <f:selectItem itemLabel="05" itemValue="05"/>
                                                <f:selectItem itemLabel="10" itemValue="10"/>
                                                <f:selectItem itemLabel="15" itemValue="15"/>
                                                <f:selectItem itemLabel="20" itemValue="20"/>
                                                <f:selectItem itemLabel="25" itemValue="25"/>
                                                <f:selectItem itemLabel="30" itemValue="30"/>
                                                <f:selectItem itemLabel="35" itemValue="35"/>
                                                <f:selectItem itemLabel="40" itemValue="40"/>
                                                <f:selectItem itemLabel="45" itemValue="45"/>
                                                <f:selectItem itemLabel="50" itemValue="50"/>
                                                <f:selectItem itemLabel="55" itemValue="55"/>
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column>mn</h:column>
                                    </h:panelGrid>
                                </h:column>
                                <h:column><h:outputText value="Pas:"/></h:column>
                                <h:column>
                                    <h:panelGrid  columns="4">
                                        <h:column>
                                            <h:selectOneMenu id="idDebHeures" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strHrPas}">
                                                <f:selectItem itemLabel="00" itemValue="00"/>
                                                <f:selectItem itemLabel="01" itemValue="01"/>
                                                <f:selectItem itemLabel="02" itemValue="02"/>
                                                <f:selectItem itemLabel="03" itemValue="03"/>
                                                <f:selectItem itemLabel="04" itemValue="04"/>
                                                <f:selectItem itemLabel="05" itemValue="05"/>
                                                <f:selectItem itemLabel="06" itemValue="06"/>
                                                <f:selectItem itemLabel="07" itemValue="07"/>
                                                <f:selectItem itemLabel="08" itemValue="08"/>
                                                <f:selectItem itemLabel="09" itemValue="09"/>
                                                <f:selectItem itemLabel="10" itemValue="10"/>
                                                <f:selectItem itemLabel="11" itemValue="11"/>
                                                <f:selectItem itemLabel="12" itemValue="12"/>
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column>h</h:column>
                                        <h:column>
                                            <h:selectOneMenu id="idDebMinutes" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strMnPas}">
                                                <f:selectItem itemLabel="00" itemValue="00"/>
                                                <f:selectItem itemLabel="05" itemValue="05"/>
                                                <f:selectItem itemLabel="10" itemValue="10"/>
                                                <f:selectItem itemLabel="15" itemValue="15"/>
                                                <f:selectItem itemLabel="20" itemValue="20"/>
                                                <f:selectItem itemLabel="25" itemValue="25"/>
                                                <f:selectItem itemLabel="30" itemValue="30"/>
                                                <f:selectItem itemLabel="35" itemValue="35"/>
                                                <f:selectItem itemLabel="40" itemValue="40"/>
                                                <f:selectItem itemLabel="45" itemValue="45"/>
                                                <f:selectItem itemLabel="50" itemValue="50"/>
                                                <f:selectItem itemLabel="55" itemValue="55"/>
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column>mn</h:column>
                                    </h:panelGrid>
                                </h:column>
                                <h:column><h:outputText value="Heure Fin:"/></h:column>
                                <h:column>
                                    <h:panelGrid  columns="4">
                                        <h:column>
                                            <h:selectOneMenu id="idFinHeures" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strHrFin}">
                                                <f:selectItem itemLabel="00" itemValue="00"/>
                                                <f:selectItem itemLabel="01" itemValue="01"/>
                                                <f:selectItem itemLabel="02" itemValue="02"/>
                                                <f:selectItem itemLabel="03" itemValue="03"/>
                                                <f:selectItem itemLabel="04" itemValue="04"/>
                                                <f:selectItem itemLabel="05" itemValue="05"/>
                                                <f:selectItem itemLabel="06" itemValue="06"/>
                                                <f:selectItem itemLabel="07" itemValue="07"/>
                                                <f:selectItem itemLabel="08" itemValue="08"/>
                                                <f:selectItem itemLabel="09" itemValue="09"/>
                                                <f:selectItem itemLabel="10" itemValue="10"/>
                                                <f:selectItem itemLabel="11" itemValue="11"/>
                                                <f:selectItem itemLabel="12" itemValue="12"/>
                                                <f:selectItem itemLabel="13" itemValue="13"/>
                                                <f:selectItem itemLabel="14" itemValue="14"/>
                                                <f:selectItem itemLabel="15" itemValue="15"/>
                                                <f:selectItem itemLabel="16" itemValue="16"/>
                                                <f:selectItem itemLabel="17" itemValue="17"/>
                                                <f:selectItem itemLabel="18" itemValue="18"/>
                                                <f:selectItem itemLabel="19" itemValue="19"/>
                                                <f:selectItem itemLabel="20" itemValue="20"/>
                                                <f:selectItem itemLabel="21" itemValue="21"/>
                                                <f:selectItem itemLabel="22" itemValue="22"/>
                                                <f:selectItem itemLabel="23" itemValue="23"/>
                                                <f:selectItem itemLabel="24" itemValue="24"/>
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column>h</h:column>
                                        <h:column>
                                            <h:selectOneMenu id="idFinMinutes" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strMnFin}">
                                                <f:selectItem itemLabel="00" itemValue="00"/>
                                                <f:selectItem itemLabel="05" itemValue="05"/>
                                                <f:selectItem itemLabel="10" itemValue="10"/>
                                                <f:selectItem itemLabel="15" itemValue="15"/>
                                                <f:selectItem itemLabel="20" itemValue="20"/>
                                                <f:selectItem itemLabel="25" itemValue="25"/>
                                                <f:selectItem itemLabel="30" itemValue="30"/>
                                                <f:selectItem itemLabel="35" itemValue="35"/>
                                                <f:selectItem itemLabel="40" itemValue="40"/>
                                                <f:selectItem itemLabel="45" itemValue="45"/>
                                                <f:selectItem itemLabel="50" itemValue="50"/>
                                                <f:selectItem itemLabel="55" itemValue="55"/>
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column>mn</h:column>
                                    </h:panelGrid>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <br><br>
                        <h:panelGrid style="background-color:#DAEECB;" width="100%">
                            <h:panelGrid  columns="2" columnClasses="clos15,clos35" width="100%" headerClass="headerTab">
                                <f:facet name="header"><h:outputText value="Configuration des Quarts (3 8)"/></f:facet>
                                <h:column><h:outputText value="Quart N° 1 : Heure Début:"/></h:column>
                                <h:column>
                                    <h:panelGrid  columns="4">
                                        <h:column>
                                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strQuart1DebutHeure}">
                                                <f:selectItem itemLabel="00" itemValue="00"/>
                                                <f:selectItem itemLabel="01" itemValue="01"/>
                                                <f:selectItem itemLabel="02" itemValue="02"/>
                                                <f:selectItem itemLabel="03" itemValue="03"/>
                                                <f:selectItem itemLabel="04" itemValue="04"/>
                                                <f:selectItem itemLabel="05" itemValue="05"/>
                                                <f:selectItem itemLabel="06" itemValue="06"/>
                                                <f:selectItem itemLabel="07" itemValue="07"/>
                                                <f:selectItem itemLabel="08" itemValue="08"/>
                                                <f:selectItem itemLabel="09" itemValue="09"/>
                                                <f:selectItem itemLabel="10" itemValue="10"/>
                                                <f:selectItem itemLabel="11" itemValue="11"/>
                                                <f:selectItem itemLabel="12" itemValue="12"/>
                                                <f:selectItem itemLabel="13" itemValue="13"/>
                                                <f:selectItem itemLabel="14" itemValue="14"/>
                                                <f:selectItem itemLabel="15" itemValue="15"/>
                                                <f:selectItem itemLabel="16" itemValue="16"/>
                                                <f:selectItem itemLabel="17" itemValue="17"/>
                                                <f:selectItem itemLabel="18" itemValue="18"/>
                                                <f:selectItem itemLabel="19" itemValue="19"/>
                                                <f:selectItem itemLabel="20" itemValue="20"/>
                                                <f:selectItem itemLabel="21" itemValue="21"/>
                                                <f:selectItem itemLabel="22" itemValue="22"/>
                                                <f:selectItem itemLabel="23" itemValue="23"/>
                                                <f:selectItem itemLabel="24" itemValue="24"/>
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column>h</h:column>
                                        <h:column>
                                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strQuart1DebutMinute}">
                                                <f:selectItem itemLabel="00" itemValue="00"/>
                                                <f:selectItem itemLabel="05" itemValue="05"/>
                                                <f:selectItem itemLabel="10" itemValue="10"/>
                                                <f:selectItem itemLabel="15" itemValue="15"/>
                                                <f:selectItem itemLabel="20" itemValue="20"/>
                                                <f:selectItem itemLabel="25" itemValue="25"/>
                                                <f:selectItem itemLabel="30" itemValue="30"/>
                                                <f:selectItem itemLabel="35" itemValue="35"/>
                                                <f:selectItem itemLabel="40" itemValue="40"/>
                                                <f:selectItem itemLabel="45" itemValue="45"/>
                                                <f:selectItem itemLabel="50" itemValue="50"/>
                                                <f:selectItem itemLabel="55" itemValue="55"/>
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column>mn</h:column>
                                    </h:panelGrid>
                                </h:column>
                                <h:column><h:outputText value="Quart N° 1 : Heure Fin"/></h:column>
                                <h:column>
                                    <h:panelGrid  columns="4">
                                        <h:column>
                                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strQuart1FinHeure}">
                                                <f:selectItem itemLabel="00" itemValue="00"/>
                                                <f:selectItem itemLabel="01" itemValue="01"/>
                                                <f:selectItem itemLabel="02" itemValue="02"/>
                                                <f:selectItem itemLabel="03" itemValue="03"/>
                                                <f:selectItem itemLabel="04" itemValue="04"/>
                                                <f:selectItem itemLabel="05" itemValue="05"/>
                                                <f:selectItem itemLabel="06" itemValue="06"/>
                                                <f:selectItem itemLabel="07" itemValue="07"/>
                                                <f:selectItem itemLabel="08" itemValue="08"/>
                                                <f:selectItem itemLabel="09" itemValue="09"/>
                                                <f:selectItem itemLabel="10" itemValue="10"/>
                                                <f:selectItem itemLabel="11" itemValue="11"/>
                                                <f:selectItem itemLabel="12" itemValue="12"/>
                                                <f:selectItem itemLabel="13" itemValue="13"/>
                                                <f:selectItem itemLabel="14" itemValue="14"/>
                                                <f:selectItem itemLabel="15" itemValue="15"/>
                                                <f:selectItem itemLabel="16" itemValue="16"/>
                                                <f:selectItem itemLabel="17" itemValue="17"/>
                                                <f:selectItem itemLabel="18" itemValue="18"/>
                                                <f:selectItem itemLabel="19" itemValue="19"/>
                                                <f:selectItem itemLabel="20" itemValue="20"/>
                                                <f:selectItem itemLabel="21" itemValue="21"/>
                                                <f:selectItem itemLabel="22" itemValue="22"/>
                                                <f:selectItem itemLabel="23" itemValue="23"/>
                                                <f:selectItem itemLabel="24" itemValue="24"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="idHoraire"/>
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column>h</h:column>
                                        <h:column>
                                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strQuart1FinMinute}">
                                                <f:selectItem itemLabel="00" itemValue="00"/>
                                                <f:selectItem itemLabel="05" itemValue="05"/>
                                                <f:selectItem itemLabel="10" itemValue="10"/>
                                                <f:selectItem itemLabel="15" itemValue="15"/>
                                                <f:selectItem itemLabel="20" itemValue="20"/>
                                                <f:selectItem itemLabel="25" itemValue="25"/>
                                                <f:selectItem itemLabel="30" itemValue="30"/>
                                                <f:selectItem itemLabel="35" itemValue="35"/>
                                                <f:selectItem itemLabel="40" itemValue="40"/>
                                                <f:selectItem itemLabel="45" itemValue="45"/>
                                                <f:selectItem itemLabel="50" itemValue="50"/>
                                                <f:selectItem itemLabel="55" itemValue="55"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="idHoraire"/>
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column>mn</h:column>
                                    </h:panelGrid>
                                </h:column>
                                <h:column><h:outputText value="Quart N° 2 : Heure Début:"/></h:column>
                                <h:column>
                                    <h:panelGrid  columns="4">
                                        <h:column>
                                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strQuart1FinHeure}" readonly="true" disabled="true">
                                                <f:selectItem itemLabel="00" itemValue="00"/>
                                                <f:selectItem itemLabel="01" itemValue="01"/>
                                                <f:selectItem itemLabel="02" itemValue="02"/>
                                                <f:selectItem itemLabel="03" itemValue="03"/>
                                                <f:selectItem itemLabel="04" itemValue="04"/>
                                                <f:selectItem itemLabel="05" itemValue="05"/>
                                                <f:selectItem itemLabel="06" itemValue="06"/>
                                                <f:selectItem itemLabel="07" itemValue="07"/>
                                                <f:selectItem itemLabel="08" itemValue="08"/>
                                                <f:selectItem itemLabel="09" itemValue="09"/>
                                                <f:selectItem itemLabel="10" itemValue="10"/>
                                                <f:selectItem itemLabel="11" itemValue="11"/>
                                                <f:selectItem itemLabel="12" itemValue="12"/>
                                                <f:selectItem itemLabel="13" itemValue="13"/>
                                                <f:selectItem itemLabel="14" itemValue="14"/>
                                                <f:selectItem itemLabel="15" itemValue="15"/>
                                                <f:selectItem itemLabel="16" itemValue="16"/>
                                                <f:selectItem itemLabel="17" itemValue="17"/>
                                                <f:selectItem itemLabel="18" itemValue="18"/>
                                                <f:selectItem itemLabel="19" itemValue="19"/>
                                                <f:selectItem itemLabel="20" itemValue="20"/>
                                                <f:selectItem itemLabel="21" itemValue="21"/>
                                                <f:selectItem itemLabel="22" itemValue="22"/>
                                                <f:selectItem itemLabel="23" itemValue="23"/>
                                                <f:selectItem itemLabel="24" itemValue="24"/>
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column>h</h:column>
                                        <h:column>
                                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strQuart1FinMinute}" readonly="true" disabled="true">
                                                <f:selectItem itemLabel="00" itemValue="00"/>
                                                <f:selectItem itemLabel="05" itemValue="05"/>
                                                <f:selectItem itemLabel="10" itemValue="10"/>
                                                <f:selectItem itemLabel="15" itemValue="15"/>
                                                <f:selectItem itemLabel="20" itemValue="20"/>
                                                <f:selectItem itemLabel="25" itemValue="25"/>
                                                <f:selectItem itemLabel="30" itemValue="30"/>
                                                <f:selectItem itemLabel="35" itemValue="35"/>
                                                <f:selectItem itemLabel="40" itemValue="40"/>
                                                <f:selectItem itemLabel="45" itemValue="45"/>
                                                <f:selectItem itemLabel="50" itemValue="50"/>
                                                <f:selectItem itemLabel="55" itemValue="55"/>
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column>mn</h:column>
                                    </h:panelGrid>
                                </h:column>
                                <h:column><h:outputText value="Quart N° 2 : Heure Fin"/></h:column>
                                <h:column>
                                    <h:panelGrid  columns="4">
                                        <h:column>
                                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strQuart2FinHeure}">
                                                <f:selectItem itemLabel="00" itemValue="00"/>
                                                <f:selectItem itemLabel="01" itemValue="01"/>
                                                <f:selectItem itemLabel="02" itemValue="02"/>
                                                <f:selectItem itemLabel="03" itemValue="03"/>
                                                <f:selectItem itemLabel="04" itemValue="04"/>
                                                <f:selectItem itemLabel="05" itemValue="05"/>
                                                <f:selectItem itemLabel="06" itemValue="06"/>
                                                <f:selectItem itemLabel="07" itemValue="07"/>
                                                <f:selectItem itemLabel="08" itemValue="08"/>
                                                <f:selectItem itemLabel="09" itemValue="09"/>
                                                <f:selectItem itemLabel="10" itemValue="10"/>
                                                <f:selectItem itemLabel="11" itemValue="11"/>
                                                <f:selectItem itemLabel="12" itemValue="12"/>
                                                <f:selectItem itemLabel="13" itemValue="13"/>
                                                <f:selectItem itemLabel="14" itemValue="14"/>
                                                <f:selectItem itemLabel="15" itemValue="15"/>
                                                <f:selectItem itemLabel="16" itemValue="16"/>
                                                <f:selectItem itemLabel="17" itemValue="17"/>
                                                <f:selectItem itemLabel="18" itemValue="18"/>
                                                <f:selectItem itemLabel="19" itemValue="19"/>
                                                <f:selectItem itemLabel="20" itemValue="20"/>
                                                <f:selectItem itemLabel="21" itemValue="21"/>
                                                <f:selectItem itemLabel="22" itemValue="22"/>
                                                <f:selectItem itemLabel="23" itemValue="23"/>
                                                <f:selectItem itemLabel="24" itemValue="24"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="idHoraire"/>
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column>h</h:column>
                                        <h:column>
                                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strQuart2FinMinute}">
                                                <f:selectItem itemLabel="00" itemValue="00"/>
                                                <f:selectItem itemLabel="05" itemValue="05"/>
                                                <f:selectItem itemLabel="10" itemValue="10"/>
                                                <f:selectItem itemLabel="15" itemValue="15"/>
                                                <f:selectItem itemLabel="20" itemValue="20"/>
                                                <f:selectItem itemLabel="25" itemValue="25"/>
                                                <f:selectItem itemLabel="30" itemValue="30"/>
                                                <f:selectItem itemLabel="35" itemValue="35"/>
                                                <f:selectItem itemLabel="40" itemValue="40"/>
                                                <f:selectItem itemLabel="45" itemValue="45"/>
                                                <f:selectItem itemLabel="50" itemValue="50"/>
                                                <f:selectItem itemLabel="55" itemValue="55"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="idHoraire"/>
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column>mn</h:column>
                                    </h:panelGrid>
                                </h:column>
                                <h:column><h:outputText value="Quart N° 3 : Heure Début:"/></h:column>
                                <h:column>
                                    <h:panelGrid  columns="4">
                                        <h:column>
                                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strQuart2FinHeure}" readonly="true" disabled="true">
                                                <f:selectItem itemLabel="00" itemValue="00"/>
                                                <f:selectItem itemLabel="01" itemValue="01"/>
                                                <f:selectItem itemLabel="02" itemValue="02"/>
                                                <f:selectItem itemLabel="03" itemValue="03"/>
                                                <f:selectItem itemLabel="04" itemValue="04"/>
                                                <f:selectItem itemLabel="05" itemValue="05"/>
                                                <f:selectItem itemLabel="06" itemValue="06"/>
                                                <f:selectItem itemLabel="07" itemValue="07"/>
                                                <f:selectItem itemLabel="08" itemValue="08"/>
                                                <f:selectItem itemLabel="09" itemValue="09"/>
                                                <f:selectItem itemLabel="10" itemValue="10"/>
                                                <f:selectItem itemLabel="11" itemValue="11"/>
                                                <f:selectItem itemLabel="12" itemValue="12"/>
                                                <f:selectItem itemLabel="13" itemValue="13"/>
                                                <f:selectItem itemLabel="14" itemValue="14"/>
                                                <f:selectItem itemLabel="15" itemValue="15"/>
                                                <f:selectItem itemLabel="16" itemValue="16"/>
                                                <f:selectItem itemLabel="17" itemValue="17"/>
                                                <f:selectItem itemLabel="18" itemValue="18"/>
                                                <f:selectItem itemLabel="19" itemValue="19"/>
                                                <f:selectItem itemLabel="20" itemValue="20"/>
                                                <f:selectItem itemLabel="21" itemValue="21"/>
                                                <f:selectItem itemLabel="22" itemValue="22"/>
                                                <f:selectItem itemLabel="23" itemValue="23"/>
                                                <f:selectItem itemLabel="24" itemValue="24"/>
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column>h</h:column>
                                        <h:column>
                                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strQuart2FinMinute}" readonly="true" disabled="true">
                                                <f:selectItem itemLabel="00" itemValue="00"/>
                                                <f:selectItem itemLabel="05" itemValue="05"/>
                                                <f:selectItem itemLabel="10" itemValue="10"/>
                                                <f:selectItem itemLabel="15" itemValue="15"/>
                                                <f:selectItem itemLabel="20" itemValue="20"/>
                                                <f:selectItem itemLabel="25" itemValue="25"/>
                                                <f:selectItem itemLabel="30" itemValue="30"/>
                                                <f:selectItem itemLabel="35" itemValue="35"/>
                                                <f:selectItem itemLabel="40" itemValue="40"/>
                                                <f:selectItem itemLabel="45" itemValue="45"/>
                                                <f:selectItem itemLabel="50" itemValue="50"/>
                                                <f:selectItem itemLabel="55" itemValue="55"/>
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column>mn</h:column>
                                    </h:panelGrid>
                                </h:column>
                                <h:column><h:outputText value="Quart N° 3 : Heure Fin"/></h:column>
                                <h:column>
                                    <h:panelGrid  columns="4">
                                        <h:column>
                                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strQuart3FinHeure}">
                                                <f:selectItem itemLabel="00" itemValue="00"/>
                                                <f:selectItem itemLabel="01" itemValue="01"/>
                                                <f:selectItem itemLabel="02" itemValue="02"/>
                                                <f:selectItem itemLabel="03" itemValue="03"/>
                                                <f:selectItem itemLabel="04" itemValue="04"/>
                                                <f:selectItem itemLabel="05" itemValue="05"/>
                                                <f:selectItem itemLabel="06" itemValue="06"/>
                                                <f:selectItem itemLabel="07" itemValue="07"/>
                                                <f:selectItem itemLabel="08" itemValue="08"/>
                                                <f:selectItem itemLabel="09" itemValue="09"/>
                                                <f:selectItem itemLabel="10" itemValue="10"/>
                                                <f:selectItem itemLabel="11" itemValue="11"/>
                                                <f:selectItem itemLabel="12" itemValue="12"/>
                                                <f:selectItem itemLabel="13" itemValue="13"/>
                                                <f:selectItem itemLabel="14" itemValue="14"/>
                                                <f:selectItem itemLabel="15" itemValue="15"/>
                                                <f:selectItem itemLabel="16" itemValue="16"/>
                                                <f:selectItem itemLabel="17" itemValue="17"/>
                                                <f:selectItem itemLabel="18" itemValue="18"/>
                                                <f:selectItem itemLabel="19" itemValue="19"/>
                                                <f:selectItem itemLabel="20" itemValue="20"/>
                                                <f:selectItem itemLabel="21" itemValue="21"/>
                                                <f:selectItem itemLabel="22" itemValue="22"/>
                                                <f:selectItem itemLabel="23" itemValue="23"/>
                                                <f:selectItem itemLabel="24" itemValue="24"/>
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column>h</h:column>
                                        <h:column>
                                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strQuart3FinMinute}">
                                                <f:selectItem itemLabel="00" itemValue="00"/>
                                                <f:selectItem itemLabel="05" itemValue="05"/>
                                                <f:selectItem itemLabel="10" itemValue="10"/>
                                                <f:selectItem itemLabel="15" itemValue="15"/>
                                                <f:selectItem itemLabel="20" itemValue="20"/>
                                                <f:selectItem itemLabel="25" itemValue="25"/>
                                                <f:selectItem itemLabel="30" itemValue="30"/>
                                                <f:selectItem itemLabel="35" itemValue="35"/>
                                                <f:selectItem itemLabel="40" itemValue="40"/>
                                                <f:selectItem itemLabel="45" itemValue="45"/>
                                                <f:selectItem itemLabel="50" itemValue="50"/>
                                                <f:selectItem itemLabel="55" itemValue="55"/>
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column>mn</h:column>
                                    </h:panelGrid>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGrid>

                    </h:panelGrid>
                    <center>
                        <br>
                        <h:commandButton styleClass="exp_lienmenu" value="VALIDEZ" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.majStructure}" onclick="if (!confirm('Voulez-vous enregistrer les modifications ?')) return false;javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </center>
            </rich:tab>

            <rich:tab name="Boutique" label="Interface Externe">
                <center>
                    <h:panelGrid id="idExterne" width="60%">
                        <h:panelGrid style="background-color:#DAEECB;" columns="2" columnClasses="clos50d,clos50g" width="100%" headerClass="headerTab">
                            <f:facet name="header"><h:outputText value="Modules externes"/></f:facet>
                            <h:column><h:outputText style="text-decoration:underline;" value="Mode fonctionnement:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmode}">
                                    <f:selectItem itemLabel="Full internet" itemValue="0"/>
                                    <f:selectItem itemLabel="Full intranet" itemValue="1"/>
                                    <f:selectItem itemLabel="Mixte" itemValue="2"/>
                                    <f:selectItem itemLabel="Spécial" itemValue="3"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:outputText value="Adresse du site Web:" />
                            <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strsitewzb}"  />
                            <rich:spacer height="20px"/>
                            <rich:spacer height="20px"/>
                            <h:outputText rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" value="Nom de domaine:" />
                            <h:inputText rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdomaine}"  />
                            <h:outputText rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" value="Adresse IP du site:" />
                            <h:inputText rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strip}"  />
                            <h:outputText rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" value="Nom de la base de données:" />
                            <h:inputText rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strnombd}"  />
                            <h:outputText rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" value="Login base de données:" />
                            <h:inputText rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strlogbd}"  />
                            <h:outputText rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" value="Mot de passe:" />
                            <h:inputText rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strpwbd}"  />
                            <h:outputText rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" value="Répertoire des images:" />
                            <h:inputText rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strrepimage}"  />
                            <rich:spacer rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" height="20px"/>
                            <rich:spacer rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" height="20px"/>
                            <h:outputText rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication}" value="Répertoire du dossier client:" />
                            <h:inputText rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication}" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strRepDocument}"  />
                            <h:outputText rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication}" value="Répertoire du dossier de configuration:" />
                            <h:inputText rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication}" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strRepConfiguration}"  />
                            <h:outputText rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication}" value="Répertoire du dossier des src java:" />
                            <h:inputText rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication}" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strRepSource}"  />
                            <rich:spacer height="20px"/>
                            <rich:spacer height="20px"/>
                            <h:outputText rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" value="Accès à AddInto:" />
                            <h:selectOneRadio rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strAddInto}">
                                <f:selectItem itemLabel="Autorisé" itemValue="0"/>
                                <f:selectItem itemLabel="Interdit" itemValue="1"/>
                            </h:selectOneRadio>
                            <h:outputText rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" value="Accès à Géo-Map:" />
                            <h:selectOneRadio rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strClusterMap}">
                                <f:selectItem itemLabel="Autorisé" itemValue="0"/>
                                <f:selectItem itemLabel="Interdit" itemValue="1"/>
                            </h:selectOneRadio>
                            <h:outputText rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" value="Accès à Google Traduction:" />
                            <h:selectOneRadio rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strGoogleTraduction}">
                                <f:selectItem itemLabel="Autorisé" itemValue="0"/>
                                <f:selectItem itemLabel="Interdit" itemValue="1"/>
                            </h:selectOneRadio>
                            <h:outputText rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" value="Accès à Visio-conférence:" />
                            <h:selectOneMenu style="width:100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strHangout}">
                                <f:selectItem itemLabel="Interdit" itemValue="0"/>
                                <f:selectItem itemLabel="Hangouts (compte Gmail)" itemValue="1"/>
                                <f:selectItem itemLabel="Jitsi Meet" itemValue="2"/>
                                <f:selectItem itemLabel="Google Meet (compte G-Suite)" itemValue="3"/>
                                <f:selectItem itemLabel="U-Meeting" itemValue="4"/>
                                <f:selectItem itemLabel="Skype" itemValue="5"/>
                            </h:selectOneMenu>
                            <h:outputText rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" value="Compte Orange Money:" />
                            <h:inputText rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcpteorange}"/>
                            <h:outputText rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" value="Compte UniverSign:" />
                            <h:inputText rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcpteuniversign}"/>
                            <h:outputText rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" value="Mot de passe UniverSign:" />
                            <h:inputSecret rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strpwuniversign}"/>
                            <rich:spacer height="20px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmaitrecabinet==1}" />
                            <rich:spacer height="20px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmaitrecabinet==1}"/>
                            <h:outputText value="Mise à jour structures du cabinet:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmaitrecabinet==1}"/>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmajcabinet}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmaitrecabinet==1}">
                                <f:selectItem itemLabel="Mise à jour BD" itemValue="0"/>
                                <f:selectItem itemLabel="Mise à jour BD + options" itemValue="1"/>
                                <f:selectItem itemLabel="Mise à jour BD + options + dossier impression" itemValue="2"/>
                            </h:selectOneMenu>
                            <h:outputText value="Structure du format des backup:"/>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strappDropbox}">
                                <f:selectItem itemLabel="Sans backup" itemValue="0"/>
                                <f:selectItem itemLabel="nom_backup + Date" itemValue="1"/>
                                <f:selectItem itemLabel="nom_backup + Date + Heures" itemValue="2"/>
                                <f:selectItem itemLabel="nom_backup + Date + Heures + Minutes" itemValue="3"/>
                            </h:selectOneMenu>
                        </h:panelGrid>
                    </h:panelGrid>
                    <br>
                    <center>
                        <h:commandButton  styleClass="exp_lienmenu"value="VALIDEZ" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.majStructure}" onclick="if (!confirm('Voulez-vous enregistrer les modifications ?')) return false;javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </center>
            </rich:tab>
        </rich:tabPanel>

    </a4j:form>



    <rich:modalPanel domElementAttachment="parent" headerClass="headerPanel" id="panelBal" width="850" height="700" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.showModalPanelBal}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.showModalPanelBal}" var="bal">
            <f:facet name="header"><h:outputText value="GESTION DES B.A.L.S DE LA SOCIETE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idCanBal" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.annulerBal}" styleClass="hidelink" reRender="panelBal,boutonBal"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanBal')}.click()" />
                </a4j:form>
            </f:facet>
            <a4j:form id="formBal">
                <h:panelGrid width="100%" id="pngdCpte">
                    <h:panelGrid columnClasses="clos30,clos70" columns="2" headerClass="headerTab" width="100%" >
                        <f:facet name="header"><h:outputText value="Identification compte société"/></f:facet>
                        <h:column><h:outputText value="Nom du compte:"/></h:column>
                        <h:column><h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.bal.balnomcompte}"/></h:column>
                        <h:column><h:outputText value="Email du compte:"/></h:column>
                        <h:column>
                            <h:inputText disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.bal.balid!=0}" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.bal.baladressemail}">
                                <a4j:support eventsQueue="maQueue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.verifExistMail}" event="onchange" reRender="idValBal,pngdCpte"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.var_existMail}"></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.var_existMail}"><h:outputText value="Ce mail existe déjà. Veuillez en saisir un autre!!!" style="color:red;"/></h:column>
                        <h:column><h:outputText value="Répondre à:"/></h:column>
                        <h:column><h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.bal.baladressemailreponse}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.bal.balid==0}"><h:outputText value="Mot de passe:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.bal.balid==0}"><h:inputSecret size="30" id="pwpop" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.bal.balpw}"/></h:column>
                        <h:column><h:outputText value="Etat du compte:"/></h:column>
                        <h:column>
                            <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.bal.balinactif}">
                                <f:selectItem itemValue="0" itemLabel="Actif"/>
                                <f:selectItem itemValue="1" itemLabel="Inactif"/>
                            </h:selectOneRadio>
                        </h:column>
                        <h:column><h:outputText value="Connexion SSL:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.bal.balssl}">
                                <f:selectItem itemValue="0" itemLabel="Connexion sans SSL"/>
                                <f:selectItem itemValue="1" itemLabel="Connexion avec SSL"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid   columnClasses="clos30,clos70" columns="2" headerClass="headerTab" width="100%" >
                        <f:facet name="header"><h:outputText value="POP de la société (Courriers entrants)"/></f:facet>
                        <h:column><h:outputText value="Serveur POP:"/></h:column>
                        <h:column><h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.bal.balpopserveur}"/></h:column>
                        <h:column><h:outputText value="Port:"/></h:column>
                        <h:column><h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.bal.balpopport}"/></h:column>
                        <h:column><h:outputText value="Exemplaire des mails:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.bal.balpopexemplaire}">
                                <f:selectItem itemValue="0" itemLabel="Laisser un exemplaire sur le serveur d'origine"/>
                                <f:selectItem itemValue="1" itemLabel="Enlever du serveur d'origine"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Authentification:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.bal.balpopauthentification}">
                                <f:selectItem itemValue="0" itemLabel="Automatique"/>
                                <f:selectItem itemValue="1" itemLabel="AUTHCRAM-MDS"/>
                                <f:selectItem itemValue="2" itemLabel="AUTHLOGIN"/>
                                <f:selectItem itemValue="3" itemLabel="Text plain"/>
                                <f:selectItem itemValue="4" itemLabel="Aucune"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid   columnClasses="clos30,clos70" columns="2" headerClass="headerTab" width="100%" >
                        <f:facet name="header"><h:outputText value="IMAP de la société (Courriers entrants)"/></f:facet>
                        <h:column><h:outputText value="Serveur IMAP:"/></h:column>
                        <h:column><h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.bal.balimapserveur}"/></h:column>
                        <h:column><h:outputText value="Port:"/></h:column>
                        <h:column><h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.bal.balimapport}"/></h:column>
                        <h:column><h:outputText value="Authentification:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.bal.balsmtauthentification}">
                                <f:selectItem itemValue="0" itemLabel="Sans Authentification"/>
                                <f:selectItem itemValue="1" itemLabel="Avec Authentification"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid  columnClasses="clos30,clos70" columns="2" headerClass="headerTab" width="100%" >
                        <f:facet name="header"><h:outputText value="SMTP de la société (Courriers sortants)"/></f:facet>
                        <h:column><h:outputText value="Serveur SMTP:"/></h:column>
                        <h:column><h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.bal.balsmtpserveur}"/></h:column>
                        <h:column><h:outputText value="Port:"/></h:column>
                        <h:column><h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.bal.balsmtpport}"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid  headerClass="headerTab" width="100%" >
                        <f:facet name="header"><h:outputText value="Signature automatique"/></f:facet>
                        <h:column>
                            <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.bal.balSignature}">
                                <jsp:include flush="true" page="../css/tdt.jsp"/>
                            </rich:editor>
                        </h:column>
                        <h:panelGroup>
                        </h:panelGroup>
                    </h:panelGrid>
                    <h:panelGroup>
                        <br>
                        <center>
                            <a4j:commandButton id="idValBal" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.saveBal}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.var_valide_bal}" reRender="boutonBal,tableBal,panelBal"/>
                        </center>
                        <rich:hotKey key="return" handler="#{rich:element('idValBal')}.click()" />
                    </h:panelGroup>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelError" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="450" height="150" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.errorConnection}" >
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.errorConnection}" var="btq">
            <f:facet name="header"><h:outputText value="Erreur de connexion"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idCanErr" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.annulerPingServer}" styleClass="hidelink" reRender="panelError"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanErr')}.click()" />
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalError" >
                <h:panelGrid id="grpError" columns="1" >
                    <center> <h:outputText value="e-Pégase ne parvient pas à se connecter à la base de données de votre site " style="color:red;"/></center>
                    <center> <h:outputText value="Vérifiez vos paramêtres de connexion" style=""/></center>
                    <br/>
                    <h:panelGroup id="buton">
                        <center>
                            <h:commandButton id="cancel"  value="Annuler" action="#{bakingbeanepegase.annulerPingServer}">
                                <rich:componentControl for="panelError" attachTo="cancel" operation="hide" event="onclick"/>
                            </h:commandButton>
                            &nbsp;&nbsp;&nbsp;
                            <a4j:commandButton value="Reessayer" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formStructureEntete.majStructure}" reRender="panelError" />
                        </center>
                    </h:panelGroup>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>