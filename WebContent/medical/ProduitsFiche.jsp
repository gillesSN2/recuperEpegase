<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="ficproduits">

    <a4j:form id="produitformmed" enctype="multipart/form-data">
        <rich:hotKey key="return" handler="return false;"/>

        <center><h2><h:outputText value="FICHE PRODUIT (MEDICAL)" style="color:green;"/></h2></center>

        <h:panelGrid width="100%">
            <rich:tabPanel switchType="client" immediate="true"  id="tabProduit" style="border:0px;">

                <rich:tab label="Descriptif" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_acc_descriptif}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.autorisationDescription}" reRender="panDescription"/>
                    <h:panelGrid id="panDescription" width="100%">
                        <h:panelGrid columns="2" columnClasses="clos15,clos85" width="100%" styleClass="fichefournisseur">
                            <h:column><h:outputText value="Famille vente:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idFamille" style="width:600px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.inpFamilleVnt}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action>=2}">
                                    <f:selectItem itemLabel="Sélectionnez une famille" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesFamillesVentesUtilItems}"/>
                                    <a4j:support eventsQueue="maQueue"  event="onchange" reRender="panelButton,codPrd,nat" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.calculeCode}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Nature vente:" style="text-decoration:underline;"/></h:column>
                            <h:column><h:outputText id="nat" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.inpNatureVnt}" /></h:column>
                            <h:column><h:outputText value="Code produit:"/></h:column>
                            <h:column>
                                <h:inputText id="codPrd" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.verouxCod}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proCode}" onkeypress="return scanToucheLettre(event)" style="width:200px;text-transform:uppercase" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action>=2}">
                                    <a4j:support eventsQueue="maQueue"  event="onchange" reRender="panelButton" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.verifCode}" />
                                </h:inputText>&nbsp;&nbsp;&nbsp;&nbsp;
                                <h:column><h:outputText value="Etat Produit:" style="color:red"/></h:column>&nbsp;&nbsp;
                                <h:column>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proInactif}" style="color:red">
                                        <f:selectItem itemLabel="ACTIF" itemValue="0"/>
                                        <f:selectItem itemLabel="DESACTIVE" itemValue="1"/>
                                        <f:selectItem itemLabel="A SUPPRIMER" itemValue="2"/>
                                    </h:selectOneMenu>
                                </h:column>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <h:column><h:outputText value="Libellé libre dans documents:" style="color:red"/></h:column>&nbsp;&nbsp;
                                <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.libelle_libre}" style="color:red" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}"/></h:column>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2"columnClasses="clos15,clos85" width="100%">
                            <h:column><h:outputText value="Libellé client:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proLibClient}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Libellé technique:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proLibTech}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                            <h:column><h:outputText value="Descriptif:"/></h:column>
                            <h:column>
                                <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proDescrip}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}">
                                    <jsp:include flush="true" page="../css/tdt.jsp"/>
                                </rich:editor>
                            </h:column>
                            <h:column><h:outputText value="Marque:"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idMarque" style="width:800px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proMarque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}">
                                    <f:selectItem itemLabel="Sans marque" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesMarquesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="4" columnClasses="clos15,clos35,clos25,clos25g" width="100%" style="background-color:#DAEECB;">
                            <h:column><h:outputText value="Produit lié:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:inputText tabindex="1" id="inpCodDet" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proCodeLie}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}">
                                    <rich:toolTip id="tooladdPrd" followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les produits" style="background-color:#FFF8D4;"/>
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.rechercheProduitsLies}" reRender="panelListeProduitsLies,formModalListeProduits" oncomplete="javascript:Richfaces.showModalPanel('panelListeProduitsLies');"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Quantité liée:"/></h:column>
                            <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proQteLie}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Photos" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action>='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_acc_photo}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.autorisationPhoto}" reRender="panPhoto"/>
                    <jsp:include flush="true" page="/medical/ProduitsCommun.jsp" />
                    <h:panelGrid id="panPhoto" columns="2" style="height:150px" width="100%" styleClass="top" headerClass="headerTab">
                        <f:facet name="header"><h:outputText value="Photo"/></f:facet>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proPhoto==null}">
                            <t:inputFileUpload id="file" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.uploadedFile}"/>
                            <h:commandButton  styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.ajoutPhoto}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}">
                                <a4j:support eventsQueue="maQueue"  immediate="true" reRender="grp3"/>
                            </h:commandButton>
                            <h:message for="file" infoStyle="color: green;" errorStyle="color: red;" />
                        </h:panelGroup>
                        <br/>
                        <h:panelGroup  id="grp3" style="width:90px;height:90px;" >
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proPhoto!=null}">
                                <img alt="photoProduit" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.urlphotoProd}" width="100px" height="100px"/>&nbsp;
                                <h:commandButton image="/images/annuler.gif"title="supprimer photo" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.reInitPhoto}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}"/>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proPhoto==null}">
                                <img alt="photoProduit" src="images/no_image.jpeg" width="100px" height="100px" />
                            </c:if>
                        </h:panelGroup>
                    </h:panelGrid>
                    <h:panelGrid id="panPdf" columns="2" style="height:170px" width="100%" styleClass="top" headerClass="headerTab">
                        <f:facet name="header"><h:outputText value="PDF"/></f:facet>
                        <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_affFicPdf}">
                            <t:inputFileUpload id="filePdf"  storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.uploadedPDFFile}"/>
                            <h:commandButton  styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.submitPDF}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}">
                                <a4j:support eventsQueue="maQueue"  immediate="true"/>
                            </h:commandButton>
                            <h:message for="filePdf" infoStyle="color: green;" errorStyle="color: red;" />
                        </h:panelGroup>
                        <br/>
                        <h:panelGroup id="grp4" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_affFicPdf}">
                            <h:outputText value="Nom:"/>&nbsp;&nbsp;&nbsp;
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proPdf}" />&nbsp;&nbsp;&nbsp;
                            <h:commandButton value="Lire le ficher" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.readPdfFile}" />&nbsp;&nbsp;&nbsp;
                            <h:commandButton image="/images/annuler.gif"title="supprimer PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.reInitPDF}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}"/>
                        </h:panelGroup>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Caractéristiques " rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action>='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_acc_caracteristique}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.autorisationCaracteristique}" reRender="panCaracteristique"/>
                    <jsp:include flush="true" page="/medical/ProduitsCommun.jsp" />
                    <h:panelGrid id="panCaracteristique" width="100%">
                        <c:choose>
                            <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proVteNat=='1104'}">
                                <jsp:include flush="true" page="/medical/ProduitsCaractActeMed.jsp" />
                            </c:when>
                            <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proVteNat=='1105'}">
                                <jsp:include flush="true" page="/medical/ProduitsCaractPharmacieMed.jsp" />
                            </c:when>
                            <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proVteNat=='1106'}">
                                <jsp:include flush="true" page="/medical/ProduitsCaractLaboMed.jsp" />
                            </c:when>
                            <c:otherwise>
                                <jsp:include flush="true" page="/medical/ProduitsCaractStandard.jsp"/>
                            </c:otherwise>
                        </c:choose>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Stock" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action>='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_acc_stock}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.autorisationStock}" reRender="panStock"/>
                    <jsp:include flush="true" page="/medical/ProduitsCommun.jsp" />
                    <h:panelGrid id="panStock" width="100%">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable width="100%" style="border:solid 0px green;" border="0" height="250px" id="tableauDepot" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.datamodelDepot}" var="depotstock">
                                <rich:column sortable="true" sortBy="#{depotstock.prodepCle}" sortOrder="ASCENDING" width="20%">
                                    <f:facet name="header" >
                                        <h:outputText value="Code dépôt"  />
                                    </f:facet>
                                    <h:outputText value="#{depotstock.depot.dpoCode}" />
                                </rich:column>
                                <rich:column sortable="true" sortBy="#{depotstock.prodepCasier}"  width="30%">
                                    <f:facet name="header" >
                                        <h:outputText value="Casier"  />
                                    </f:facet>
                                    <h:outputText value="#{depotstock.prodepCasier}"/>
                                </rich:column>
                                <rich:column sortable="true" sortBy="#{depotstock.prodepLocalisation}"  width="30%">
                                    <f:facet name="header" >
                                        <h:outputText  value="Localisation"  />
                                    </f:facet>
                                    <h:outputText value="#{depotstock.prodepLocalisation}" />
                                </rich:column>
                                <rich:column sortable="true" sortBy="#{depotstock.prodepQteStk}" width="20%" style="text-align:right;">
                                    <f:facet name="header" >
                                        <h:outputText  value="Quantité"  />
                                    </f:facet>
                                    <h:outputText value="#{depotstock.prodepQteStk}" style="text-align:right;"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Tarifications" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action>='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_acc_tarification}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.autorisationTarification}" reRender="panTarification"/>
                    <jsp:include flush="true" page="/medical/ProduitsCommun.jsp" />
                    <h:panelGrid id="panTarification" width="100%" >
                        <rich:tabPanel switchType="client" immediate="true"  id="tabProduitTarif" style="border:0px;">
                            <rich:tab label="Tarifs Standards">
                                <a4j:region renderRegionOnly="false">
                                    <h:panelGrid columns="3">
                                        <h:panelGroup id="panelBoutonTarif" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action!=3}">
                                            <a4j:commandButton title="Ajouter tarif" image="/images/ajouter.png" reRender="panelTarif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.ajouterTarif}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_ajt}"/>&nbsp; &nbsp;&nbsp;
                                            <a4j:commandButton title="Modifier tarif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.modifierTarif}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.afficheButtModifProdTar&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_mod}" image="/images/modifier.png" reRender="panelTarif"/>&nbsp; &nbsp;&nbsp;
                                            <a4j:commandButton title="Supprimer tarif"  image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.afficheButtModifProdTar&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_sup}"  onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.deleteProduitTarif}" reRender="panelBoutonTarif,tableauTarif"/>
                                        </h:panelGroup>
                                        <h:panelGroup id="idGroupeLettre" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proVteNat=='1102'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proVteNat=='1103'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proVteNat=='1104'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proVteNat=='1106'}">
                                            <h:column><h:outputText value="Lettre utilisée:"/></h:column>&nbsp;&nbsp;&nbsp;
                                            <h:column>
                                                <h:selectOneMenu id="idLettre" style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.choixLettre}">
                                                    <f:selectItem itemLabel="Sans lettre" itemValue=""/>
                                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesLettresItems}"/>
                                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.saveLettre}" reRender="tableauTarif,idGroupeLettre,idNbLettre1,idNbLettre2,idNbLettre3,idNbLettre4"/>
                                                </h:selectOneMenu>
                                            </h:column>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        </h:panelGroup>
                                        <h:panelGroup id="idMajoration" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.optionsMedical.coefMajoration!='0'}">
                                            <h:column><h:outputText value="Gestion majoration tiers:"/></h:column>&nbsp;&nbsp;&nbsp;
                                            <h:column>
                                                <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produits.proMajoration}">
                                                    <f:selectItem itemLabel="Majoration autorisée" itemValue="0"/>
                                                    <f:selectItem itemLabel="Majoration bloquée" itemValue="1"/>
                                                </h:selectOneMenu>
                                            </h:column>
                                        </h:panelGroup>
                                    </h:panelGrid>
                                    <rich:extendedDataTable width="100%" style="border:solid 0px green;" border="0"  height="250px" id="tableauTarif" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" enableContextMenu="false" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.datamodelTarif}" var="tarif">
                                        <a4j:support eventsQueue="maQueue" event="onRowClick"  reRender="panelBoutonTarif"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.selectionTarif}"/>
                                        <rich:column sortable="false" width="20%" sortBy="#{tarif.protarClient}" sortOrder="ASCENDING">
                                            <f:facet name="header" ><h:outputText value="Famille Tarification"/></f:facet>
                                            <h:outputText value="#{tarif.protarClient}"/>
                                        </rich:column>
                                        <rich:column sortable="false" width="20%" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.lettreUtil}">
                                            <f:facet name="header" ><h:outputText value="Condtionnement"/></f:facet>
                                            <h:outputText value="#{tarif.protarCondit}"/>
                                        </rich:column>
                                        <rich:column sortable="false" width="5%" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.lettreUtil}">
                                            <f:facet name="header" ><h:outputText value="Coefficient"/></f:facet>
                                            <h:outputText value="#{tarif.protarCoef}" />
                                        </rich:column>
                                        <rich:column sortable="false" width="15%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.lettreUtil}">
                                            <f:facet name="header" ><h:outputText value="Nb Lettre"/></f:facet>
                                            <h:outputText value="#{tarif.protarLettre} : #{tarif.protarNb} * #{tarif.protarValeur}" />
                                        </rich:column>
                                        <rich:column sortable="false" width="10%" style="text-align:right;">
                                            <f:facet name="header"><h:outputText  value="P.U. #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.htTtc}"/></f:facet>
                                            <h:outputText value="#{tarif.protarPv}" >
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column sortable="false" width="15%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.lettreUtil&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.optionsMedical.cnamgs=='1'}">
                                            <f:facet name="header" ><h:outputText value="Nb Lettre Cnamgs"/></f:facet>
                                            <h:outputText value="#{tarif.protarLettre} : #{tarif.protarNbCnamgs} * #{tarif.protarValeurCnamgs}" />
                                        </rich:column>
                                        <rich:column sortable="false" width="10%" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.optionsMedical.cnamgs=='1'}">
                                            <f:facet name="header"><h:outputText  value="P.U. Cnamgs"/></f:facet>
                                            <h:outputText value="#{tarif.protarPvCnamgs}" >
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column sortable="false" width="5%" id="etatProdTar" style="text-align:center;">
                                            <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                                            <h:commandButton image="#{tarif.etat}" rendered="#{tarif.inactif}" onclick="if (!confirm('Voulez-vous réactiver ce journal ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.reactiverProdTarif}" title="Supprimer" style="text-align:right;">
                                                <a4j:support eventsQueue="maQueue" reRender="etatProdTar,tableauTarif" event="onclick"/>
                                            </h:commandButton>
                                        </rich:column>
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </rich:tab>
                            <rich:tab label="Tarifs Conventionnés">
                                <h:panelGroup id="panelBoutonTarifConvention" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action!=3}">
                                    <a4j:commandButton title="Ajouter tarif" image="/images/ajouter.png" reRender="panelTarifConvention" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.ajouterTarifConvention}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_ajt}"/>&nbsp; &nbsp;&nbsp;
                                    <a4j:commandButton title="Modifier tarif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.modifierTarifConvention}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.afficheButtModifProdTarConvention&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_mod}" image="/images/modifier.png" reRender="panelTarifConvention"/>&nbsp; &nbsp;&nbsp;
                                    <a4j:commandButton title="Supprimer tarif" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.afficheButtModifProdTarConvention&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_sup}"  onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.deleteProduitTarifConvention}" reRender="panelBoutonTarifConvention,tableauTarifConvention"/>
                                </h:panelGroup>
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable width="100%" style="border:solid 0px green;" border="0"  height="250px" id="tableauTarifConvention" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" enableContextMenu="false" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.datamodelTarifConvention}" var="tarifConv">
                                        <a4j:support eventsQueue="maQueue" event="onRowClick" reRender="panelBoutonTarifConvention" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.selectionTarifConvention}"/>
                                        <rich:column sortable="false" width="50%" sortBy="#{tarifConv.tiers.tieraisonsocialenom}" sortOrder="ASCENDING">
                                            <f:facet name="header" ><h:outputText value="Nom Convention"/></f:facet>
                                            <h:outputText value="#{tarifConv.tiers.tieraisonsocialenom}"/>
                                        </rich:column>
                                        <rich:column sortable="false" width="10%" sortBy="#{tarifConv.cvnLettre}">
                                            <f:facet name="header" ><h:outputText value="Lettre"/></f:facet>
                                            <h:outputText value="#{tarifConv.cvnLettre}"/>
                                        </rich:column>
                                        <rich:column sortable="false" width="20%" style="text-align:right;">
                                            <f:facet name="header"><h:outputText  value="P.U. Origine #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.htTtc}"/></f:facet>
                                            <h:outputText value="#{tarifConv.cvnValeurOrigine}" >
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column sortable="false" width="20%" style="text-align:right;">
                                            <f:facet name="header"><h:outputText  value="P.U. Conv. #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.htTtc}"/></f:facet>
                                            <h:outputText value="#{tarifConv.cvnValeur}" >
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </rich:tab>
                        </rich:tabPanel>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Option.vente" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action>='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_acc_option_vte}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.autorisationOptionVte}" reRender="panOption"/>
                    <jsp:include flush="true" page="/medical/ProduitsCommun.jsp" />
                    <h:panelGrid id="panOption" width="100%">
                        <jsp:include flush="true" page="/medical/ProduitsOptions.jsp" />
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Mots.cles" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action>='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_acc_motcle}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.autorisationMotCle}" reRender="panMotcles"/>
                    <jsp:include flush="true" page="/medical/ProduitsCommun.jsp" />
                    <h:panelGrid id="panMotcles" width="100%">
                        <center>
                            <h:panelGrid id="panelBoutonProdMCl" columns="3" width="150px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action!=3}">
                                <a4j:commandButton title="Ajouter mot clé" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.ajoutMotCle}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_ajt}" reRender="panelMotCle"/>
                                <a4j:commandButton title="Modifier mot clé" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.modifMotCle}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.afficheButtModifProdMotCle&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_mod}"  reRender="panelMotCle"/>
                                <a4j:commandButton title="Supprimer mot clé" image="/images/supprimer.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.deleteProduitMotCle}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.afficheButtModifProdMotCle&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_sup}"  onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false"  reRender="tableauMotCle,panelBoutonProdMCl"/>
                            </h:panelGrid>
                        </center>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable width="100%" style="border:solid 0px green;" border="0"  height="250px" id="tableauMotCle" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.datamodelMotCle}" var="depotMotCle">
                                <a4j:support eventsQueue="maQueue" event="onRowClick"  reRender="panelBoutonProdMCl"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.initProduitMotClSelected}"    />
                                <rich:column sortable="false" sortBy="#{depotMotCle.promclMot}" sortOrder="ASCENDING" width="100%">
                                    <f:facet name="header" ><h:outputText value="Mots clés"  /></f:facet>
                                    <h:outputText value="#{depotMotCle.promclMot}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Services" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action>='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_acc_service}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.autorisationService}" reRender="panServices"/>
                    <jsp:include flush="true" page="/medical/ProduitsCommun.jsp" />
                    <h:panelGrid id="panServices" width="100%">
                        <center>
                            <h:panelGrid id="panelBoutonService" columns="2" width="100px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action!=3}">
                                <a4j:commandButton title="ajouter" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.ajoutProService}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_ajt}" reRender="panelService"/>
                                <a4j:commandButton title="supprimer" image="/images/supprimer.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.deleteProduitsServices}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.afficheButtSuppProdServ&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false"   reRender="tableauService,panelBoutonService"/>
                            </h:panelGrid>
                        </center>
                        <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" styleClass="fichefournisseur1">
                            <h:column><h:outputText value="Service facturé (choix 1):"  style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.service1Facture}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}">
                                    <f:selectItem itemLabel="Sélectionnez le service" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesServices2Items}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="panServices"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.service1Facture!=null}"><h:outputText value="Service facturé (choix 2):"  style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.service1Facture!=null}">
                                <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.service2Facture}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}">
                                    <f:selectItem itemLabel="Sélectionnez le service" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesServices2Items}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="panServices"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.service2Facture!=null}"><h:outputText value="Service facturé (choix 3):"  style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.service2Facture!=null}">
                                <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.service3Facture}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}">
                                    <f:selectItem itemLabel="Sélectionnez le service" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesServicesItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="panServices"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.service3Facture!=null}"><h:outputText value="Service facturé (choix 4):"  style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.service3Facture!=null}">
                                <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.service4Facture}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}">
                                    <f:selectItem itemLabel="Sélectionnez le service" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesServicesItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="panServices"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.service4Facture!=null}"><h:outputText value="Service facturé (choix 5):"  style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.service4Facture!=null}">
                                <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.service5Facture}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}">
                                    <f:selectItem itemLabel="Sélectionnez le service" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesServicesItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="panServices"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        </br>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable width="100%" style="border:solid 0px green;" border="0"  height="250px" id="tableauService" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.datamodelProService}" var="serv">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" reRender="panelBoutonService"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.initProduitsServiceSelected}"    />
                                <rich:column sortable="false" sortBy="#{serv.proserCode}" sortOrder="ASCENDING" width="30%">
                                    <f:facet name="header" ><h:outputText  value="Code service"  /></f:facet>
                                    <h:outputText value="#{serv.proserCode}"/>
                                </rich:column>
                                <rich:column sortable="false" width="60%">
                                    <f:facet name="header" ><h:outputText  value="Libellé service"  /></f:facet>
                                    <h:outputText value="#{serv.proserNomFr}"/>
                                </rich:column>
                                <rich:column sortable="false" width="10%">
                                    <f:facet name="header" ><h:outputText  value="Qte"  /></f:facet>
                                    <h:outputText value="#{serv.proserQte}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>

            </rich:tabPanel>
            <h:panelGroup id="panelButton">
                <center>
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.annuleSaisie}"  />&nbsp;&nbsp;
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.majProduit}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.existCod}" />
                </center>
            </h:panelGroup>
        </h:panelGrid>
    </a4j:form>


    <rich:modalPanel id="panelTarif" width="500" height="430" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.showModalPanelTarif}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.showModalPanelTarif}" var="tar">
            <f:facet name="header"><h:outputText value="GESTION DES TARIFS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.fermerTarif}" image="/images/close.gif" styleClass="hidelink" reRender="panelTarif"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid id="idTarifDetail" width="100%">
                    <h:panelGrid columns="2" columnClasses="clos35,clos65g" styleClass="fichefournisseur">
                        <h:column><h:outputText value="Famille Tarification:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="IdfamTarif" style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.tarifOrdClt}">
                                <f:selectItem itemLabel="Sélectionnez la famille" itemValue=""/>
                                <f:selectItem itemLabel="Tarif UNIQUE" itemValue="-3"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesCategoriesItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.decouperMesTarifItems}" reRender="idTarifDetail,buttGrpProdFour"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.lettreUtil}"><h:outputText value="Conditionnement:"/></h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.lettreUtil}">
                            <h:selectOneMenu id="idCondTarif" style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsTarif.protarCondit}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesConditionnementsItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.decouperMesTarifItems}" reRender="idTarifDetail,buttGrpProdFour"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.lettreUtil}"><h:outputText value="Lettre utilisée:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.lettreUtil}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.choixLettre}" style="width:180px" readonly="true"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.lettreUtil}"><h:outputText value="Coéfficient:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.lettreUtil}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsTarif.protarCoef}" style="text-align:right;width:180px">
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.calculeLettres}" reRender="idTarifDetail"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <br/>
                    <h:panelGrid columns="2" columnClasses="clos35,clos65g" styleClass="fichefournisseur1">
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.lettreUtil}"><h:outputText value="Valeur lettre standard:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.lettreUtil}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.valeurLettre}" style="text-align:right;width:180px" readonly="true"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.lettreUtil}"><h:outputText value="Nb lettre standard:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.lettreUtil}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsTarif.protarNb}" style="text-align:right;width:180px">
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.calculPrixLettre}" reRender="idTarifDetail"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Prix de vente standard:"/></h:column>
                        <h:column>
                            <h:inputText id="pv" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsTarif.protarPv}"  style="text-align:right;width:180px" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.valeurLettre!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <br/>
                    <h:panelGrid columns="2" columnClasses="clos35,clos65g" styleClass="fichefournisseur" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.optionsMedical.cnamgs=='1'}">
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.lettreUtil}"><h:outputText value="Valeur lettre Cnamgs:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.lettreUtil}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.valeurLettreCnamgs}" style="text-align:right;width:180px" readonly="true"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.lettreUtil}"><h:outputText value="Nb lettre Cnamgs:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.lettreUtil}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsTarif.protarNbCnamgs}" style="text-align:right;width:180px">
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.calculPrixLettreCnamgs}" reRender="idTarifDetail"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Prix de vente Cnamgs:"/></h:column>
                        <h:column>
                            <h:inputText id="pvcnamgs" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsTarif.protarPvCnamgs}" style="text-align:right;width:180px" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.valeurLettreCnamgs!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br/> <br/>
                <center>
                    <h:panelGroup  id="buttGrpProdFour">
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.saveProduitsTarif}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.testDoubleProduitsTarif}" reRender="panelTarif,tableauTarif,panelBoutonTarif"/>
                        <h:outputText style="color:red;" value="La famille et le conditionnement doivent être unique!" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.testDoubleProduitsTarif}"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel id="panelTarifConvention" width="600" height="200" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.showModalPanelTarifconvention}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.showModalPanelTarifconvention}" var="tar">
            <f:facet name="header"><h:outputText value="GESTION DES TARIFS DES CONVENTIONS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.fermerTarifConvention}" image="/images/close.gif" styleClass="hidelink" reRender="panelTarifConvention"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid id="idTarifDetailConvention" width="100%">
                    <h:panelGrid columns="2" columnClasses="clos35,clos65g" styleClass="fichefournisseur">
                        <h:column><h:outputText value="Famille Tarification:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="IdfamConvention" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.idTierConvention}">
                                <f:selectItem itemLabel="Sélectionnez le tiers" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.mesTiersClientsItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="false"><h:outputText value="Lettre utilisée:"/></h:column>
                        <h:column rendered="false"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.conventionMedical.cvnLettre}" style="width:180px" readonly="true"/></h:column>
                        <h:column><h:outputText value="Prix de vente origine:"/></h:column>
                        <h:column>
                            <h:inputText id="pvorg" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.conventionMedical.cvnValeurOrigine}"  style="text-align:right;width:180px">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Prix de vente conventionné:"/></h:column>
                        <h:column>
                            <h:inputText id="pv" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.conventionMedical.cvnValeur}"  style="text-align:right;width:180px">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br/> <br/>
                <center>
                    <h:panelGroup  id="buttGrpConvention">
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.saveTarifConvention}" reRender="panelTarifConvention,tableauTarifConvention,panelBoutonTarifConvention"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel id="panelMotCle" width="400" height="200" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.showModalPanelMotcles}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.showModalPanelMotcles}" var="mcl">
            <f:facet name="header"><h:outputText value="GESTION DES MOTS CLES"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.fermerMotcle}" image="/images/close.gif" styleClass="hidelink" reRender="panelMotCle"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid columns="2">
                    <h:outputText value="Mot clé:"/>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsMcles.promclMot}" onkeypress="return scanToucheLettre(event)" style="width:300px;text-transform:uppercase"/>
                </h:panelGrid>
                <br/>  <br/>
                <center>
                    <h:panelGroup  id="buttGrpProdMotCle">
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.saveProduitsMotCle}" reRender="panelMotCle,tableauMotCle"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel id="panelService" width="500" height="150" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.showModalPanelService}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.showModalPanelService}" var="sev">
            <f:facet name="header"><h:outputText value="GESTION DES SERVICES"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.fermerService}" image="/images/close.gif" styleClass="hidelink" reRender="panelService"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid columns="2">
                    <h:outputText id="outcodlib" value="Code et libéllé des services:" />
                    <h:selectOneMenu id="idService" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.prodCodeLibService}">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesServices2Items}"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.decoupageCodLibService}" reRender="outcodlib,buttGrpProdSer,outpAjtCodLib"/>
                    </h:selectOneMenu>
                    <h:outputText value="Quantité (produit chainé):" />
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsServices.proserQte}" style="text-align:right;width:100px"/></h:column>
                </h:panelGrid>
                <br/><br/>
                <center>
                    <h:panelGroup  id="buttGrpProdSer">
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.saveProduitsServices}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.testCodLibService}" reRender="panelService,tableauService"/>
                        <h:outputText  id="outpAjtCodLib" style="color:red;" value="Sélectionnez un service qui n'est pas encore utilisé!" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.testCodLibService}"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel id="panelListeProduits" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.showModalPanelListeProduit}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.showModalPanelListeProduit}" var="lpr">
            <f:facet name="header"><h:outputText value="Sélection du produit"/></f:facet>
            <a4j:form id="formModalListeProduits">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  width="100%">
                    <rich:extendedDataTable id="tableProd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.datamodelProduitsLieRecherche}"  var="prd">
                        <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.selectionProduitsLies}"/>
                        <f:facet name="header"></f:facet>
                        <rich:column label="Code" sortable="true" sortBy="#{prd.proCode}" width="15%">
                            <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                            <h:outputText value="#{prd.proCode}"/>
                        </rich:column>
                        <rich:column label="Libellé produit" sortable="true" sortBy="#{prd.proLibClient}" width="55%">
                            <f:facet name="header"><h:outputText  value="Libellé produit" /></f:facet>
                            <h:outputText value="#{prd.proLibClient}"/>
                        </rich:column>
                        <rich:column label="Famille" sortable="true" sortBy="#{prd.proVteLib}" width="20%">
                            <f:facet name="header"><h:outputText  value="Famille" /></f:facet>
                            <h:outputText value="#{prd.proVteLib}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </h:panelGrid>
                <br>
                <h:panelGroup id="valprod">
                    <center>
                        <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.annuleProduits}"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.calculeProduits}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel id="panelFourchette" width="600" height="400" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.showModalPanelFourchette}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.showModalPanelFourchette}" var="fch">
            <f:facet name="header"><h:outputText value="GESTION DES FOURCHETTES"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.fermerFourchette}" image="/images/close.gif" styleClass="hidelink" reRender="panelFourchette"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid columns="2" width="100%" columnClasses="clos20,clos80" id="panFour">
                    <h:column><h:outputText value="Type Genre:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsFourchette.profchSexe}">
                            <f:selectItem itemLabel="Tout sexe" itemValue="2"/>
                            <f:selectItem itemLabel="Femme" itemValue="0"/>
                            <f:selectItem itemLabel="Homme" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Type Age:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsFourchette.profchAge}">
                            <f:selectItem itemLabel="Tout age" itemValue="0"/>
                            <f:selectItem itemLabel="Bébé" itemValue="1"/>
                            <f:selectItem itemLabel="Enfant" itemValue="2"/>
                            <f:selectItem itemLabel="Adolescent" itemValue="3"/>
                            <f:selectItem itemLabel="Adulte" itemValue="4"/>
                            <f:selectItem itemLabel="Sénior" itemValue="5"/>
                            <f:selectItem itemLabel="Age en année" itemValue="10"/>
                            <f:selectItem itemLabel="Age en mois" itemValue="11"/>
                            <f:selectItem itemLabel="Age en jour" itemValue="12"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.calculeFourchette}" reRender="labo,panFour"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsFourchette.profchAge!=0}"><h:outputText value="Age début:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsFourchette.profchAge!=0}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsFourchette.profchAgeDebut}" style="text-align:right;width:100px"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsFourchette.profchAge!=0}"><h:outputText value="Age fin:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsFourchette.profchAge!=0}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsFourchette.profchAgeFin}" style="text-align:right;width:100px"/></h:column>
                    <h:column><h:outputText value="Fourchette Minimale:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsFourchette.profchFmini}" style="text-align:right;width:100px"/></h:column>
                    <h:column><h:outputText value="Fourchette Maximale:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsFourchette.profchFmaxi}" style="text-align:right;width:100px"/></h:column>
                    <h:column><h:outputText value="Limite Minimale:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsFourchette.profchLmini}" style="text-align:right;width:100px"/></h:column>
                    <h:column><h:outputText value="Limite Maximale:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsFourchette.profchLmaxi}" style="text-align:right;width:100px"/></h:column>
                    <h:column><h:outputText value="Normes:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsFourchette.profchNorme}" style="width:100%"/></h:column>
                </h:panelGrid>
                <br/>  <br/>
                <center>
                    <h:panelGroup id="buttGrpFourchette">
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.saveProduitsFourchette}" reRender="panelFourchette,panelFourchetteDetail,tableauFourchetteDetail,tableauFourchette"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel id="panelReponse" width="730" height="350" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);">
        <f:facet name="header"><h:outputText value="GESTION DES REPONSES PREDEFINIES"></h:outputText></f:facet>
        <f:facet name="controls">
            <h:panelGroup>
                <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="hidelinkRep"/>
                <rich:componentControl for="panelReponse" attachTo="hidelinkRep" operation="hide" event="onclick"/>
            </h:panelGroup>
        </f:facet>
        <a4j:form>
            <rich:hotKey key="return" handler="return false;"/>
            <h:panelGrid width="100%" style="height:200;border:0px solid green" >
                <h:inputTextarea  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsReponse.prorepReponse}" style="width:100%" rows="5"/>
            </h:panelGrid>
            <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsLaboratoire.prolabType==6}">
                <h:column rendered="false"><h:outputText value="Question:"/></h:column>
                <h:column rendered="false"><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsReponse.prorepQuestion}"/></h:column>
                <h:column rendered="false"><h:outputText value="Réponse négative:"/></h:column>
                <h:column rendered="false"><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsReponse.prorepActionNegative}"/></h:column>
                <h:column rendered="false"><h:outputText value="Réponse positive:"/></h:column>
                <h:column rendered="false"><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsReponse.prorepActionPositive}"/></h:column>
                <h:column><h:outputText value="Réponse numérique:"/></h:column>
                <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsReponse.prorepActionNumerique}"/></h:column>
                <h:column><h:outputText value="Réponse texte:"/></h:column>
                <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsReponse.prorepActionTexte}"/></h:column>
                <h:column><h:outputText value="Texte prédifini:"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsReponse.prorepTexteModifiable}"/></h:column>
            </h:panelGrid>
            <br/>  <br/>
            <center>
                <h:panelGroup  id="buttGrpReponse">
                    <a4j:commandButton image="/images/valider_big.png" id="saveRep">
                        <rich:componentControl for="panelReponse" attachTo="saveRep" operation="hide" event="onclick"/>
                        <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.saveProduitsReponse}" reRender="tableauReponse"/>
                    </a4j:commandButton >
                </h:panelGroup>
            </center>
        </a4j:form>
    </rich:modalPanel>


    <rich:modalPanel id="panelExamenChaine" width="500" height="300" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);">
        <f:facet name="header"><h:outputText value="GESTION DES EXAMENS CHAINES"></h:outputText></f:facet>
        <f:facet name="controls">
            <h:panelGroup>
                <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="hidelinkEC"/>
                <rich:componentControl for="panelExamenChaine" attachTo="hidelinkEC" operation="hide" event="onclick"/>
            </h:panelGroup>
        </f:facet>
        <a4j:form>
            <rich:hotKey key="return" handler="return false;"/>
            <h:panelGrid width="100%" style="height:200;border:0px solid green" >
                <h:column>
                    <h:selectOneMenu style="width:90%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsReponse.prorepCodeExamen}">
                        <f:selectItem itemLabel="Sélection examen" itemValue=""/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.mesExamnensChainesItems}"/>
                    </h:selectOneMenu>
                </h:column>
            </h:panelGrid>
            <br/>  <br/>
            <center>
                <h:panelGroup  id="buttGrpExamenChaine">
                    <a4j:commandButton image="/images/valider_big.png" id="saveRep">
                        <rich:componentControl for="panelExamenChaine" attachTo="saveRep" operation="hide" event="onclick"/>
                        <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.saveProduitsExamenChaine}" reRender="tableauExamenChaine"/>
                    </a4j:commandButton >
                </h:panelGroup>
            </center>
        </a4j:form>
    </rich:modalPanel>


    <rich:modalPanel id="panelDetail" width="800" height="600" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.showModalPanelDetail}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.showModalPanelDetail}" var="det">
            <f:facet name="header"><h:outputText value="GESTION DU DETAIL D'UN EXAMEN"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.fermerDetail}" image="/images/close.gif" styleClass="hidelink" reRender="panelDetail"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid id="labo2"  width="100%">
                    <h:panelGrid columns="2" width="100%" columnClasses="clos15,clos85" styleClass="fichefournisseur">
                        <h:column><h:outputText value="Libellé:"/></h:column>
                        <h:column><h:inputTextarea  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsDetail.prodetLibelle}" style="width:100%"/></h:column>
                        <h:column><h:outputText value="Normes:"/></h:column>
                        <h:column><h:inputTextarea  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsDetail.prodetNorme}" style="width:100%" rows="5"/></h:column>
                        <h:column><h:outputText value="Interprétations (texte):"/></h:column>
                        <h:column><h:inputTextarea  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsDetail.prodetInterpretationTexte}" style="width:100%" rows="5"/></h:column>
                        <h:column><h:outputText value="Interprétations (image):"/></h:column>
                        <h:column>
                            <h:panelGrid id="panInterpretation2" columns="2" style="height:150px" width="100%">
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsDetail.prodetInterpretation==null}">
                                    <t:inputFileUpload id="file1" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.uploadedFile}" accept="image/*"/>
                                    <h:commandButton  styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.ajoutInterpretation2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}">
                                        <a4j:support eventsQueue="maQueue" immediate="true" reRender="grpI2"/>
                                    </h:commandButton>
                                    <h:message for="file" infoStyle="color: green;" errorStyle="color: red;" />
                                </h:panelGroup>
                                <br/>
                                <h:panelGroup  id="grpI2" style="width:90px;height:90px;" >
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsDetail.prodetInterpretation!=null}">
                                        <img alt="" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.urlphotoInterpretation2}" width="600px" height="100px"/>&nbsp;
                                        <h:commandButton image="/images/annuler.gif"title="supprimer Interpretation" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.reInitInterpretation2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==3}"/>
                                    </c:if>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsDetail.prodetInterpretation==null}">
                                        <img alt="" src="images/no_image.jpeg" width="100px" height="100px" />
                                    </c:if>
                                </h:panelGroup>
                            </h:panelGrid>
                        </h:column>
                        <h:column><h:outputText value="Type résultat:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:250px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsDetail.prodetType}">
                                <f:selectItem itemLabel="Titre" itemValue="0"/>
                                <f:selectItem itemLabel="Numérique" itemValue="1"/>
                                <f:selectItem itemLabel="Numérique + (Négatif ou Positif)" itemValue="11"/>
                                <f:selectItem itemLabel="Date" itemValue="2"/>
                                <f:selectItem itemLabel="Image/PDF" itemValue="3"/>
                                <f:selectItem itemLabel="Texte long" itemValue="4"/>
                                <f:selectItem itemLabel="Texte court" itemValue="9"/>
                                <f:selectItem itemLabel="Texte court + (Négatif ou Positif)" itemValue="10"/>
                                <f:selectItem itemLabel="Réponse unique" itemValue="5"/>
                                <f:selectItem itemLabel="Sélection examen secondaire" itemValue="6"/>
                                <f:selectItem itemLabel="Réponse multiple" itemValue="7"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="labo2,numerique3,numerique4,reponse2,reponse3"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Catégorie:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idCate" style="width:250px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsDetail.prodetCategorie}">
                                <f:selectItem itemLabel="Sans catégorie" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.mesCategoriesExamensItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>

                    <h:panelGrid id="numerique3" columns="2" columnClasses="clos15,clos85" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsDetail.prodetType==1}">
                        <h:column><h:outputText value="Unité:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsDetail.prodetUnite}" maxlength="20"/></h:column>
                        <h:column><h:outputText value="Conversion:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsDetail.prodetCoef}"/></h:column>
                        <h:column><h:outputText value="Unité convertie:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsDetail.prodetUniteConv}" maxlength="20"/></h:column>
                        <h:column><h:outputText value="Fourchette (texte):"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsDetail.prodetFourchette}" maxlength="100"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid id="numerique4" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsDetail.prodetType==1}">
                        <center>
                            <h:panelGrid id="panelBoutonFourchetteDetail" columns="3" width="150px">
                                <a4j:commandButton title="Ajouter fourchette" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.ajouterFourchetteDetail}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_ajt}"  oncomplete="javascript:Richfaces.showModalPanel('panelFourchetteDetail');" reRender="panelFourchetteDetail,formFourchetteDetail"/>
                                <a4j:commandButton title="Modifier fourchette" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.modifierFourchetteDetail}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.afficheButtFourchetteDetail&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_mod}" reRender="panelFourchetteDetail,formFourchetteDetail"/>
                                <a4j:commandButton title="Supprimer fourchette" image="/images/supprimer.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.supprimerFourchetteDetail}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.afficheButtFourchetteDetail&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_sup}"  onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false"  reRender="panelBoutonFourchetteDetail,tableauFourchetteDetail"/>
                            </h:panelGrid>
                        </center>
                        <rich:extendedDataTable width="100%" style="border:solid 0px green;" border="0"  height="250px" id="tableauFourchetteDetail" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.datamodelFourchetteDetail}" var="four">
                            <a4j:support eventsQueue="maQueue" event="onRowClick"  reRender="panelBoutonFourchetteDetail"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.selectionFourchetteDetail}"/>
                            <rich:column sortable="false" sortBy="#{four.var_sexe}" width="10%" sortOrder="ASCENDING">
                                <f:facet name="header" ><h:outputText  value="Type Sexe"/></f:facet>
                                <h:outputText value="#{four.var_sexe}"/>
                            </rich:column>
                            <rich:column sortable="false" sortBy="#{four.var_age}" width="10%">
                                <f:facet name="header" ><h:outputText  value="Type Age"/></f:facet>
                                <h:outputText value="#{four.var_age}"/>
                            </rich:column>
                            <rich:column sortable="false" width="10%" style="text-align:right;">
                                <f:facet name="header" ><h:outputText  value="Age Début"/></f:facet>
                                <h:outputText value="#{four.profchAgeDebut}" />
                            </rich:column>
                            <rich:column sortable="false" width="10%" style="text-align:right;">
                                <f:facet name="header" ><h:outputText  value="Age Fin"/></f:facet>
                                <h:outputText value="#{four.profchAgeFin}" />
                            </rich:column>
                            <rich:column sortable="false" width="10%" style="text-align:right;">
                                <f:facet name="header" ><h:outputText  value="Mini."/></f:facet>
                                <h:outputText value="#{four.profchFmini}" />
                            </rich:column>
                            <rich:column sortable="false" width="10%" style="text-align:right;">
                                <f:facet name="header" ><h:outputText  value="Maxi."/></f:facet>
                                <h:outputText value="#{four.profchFmaxi}" />
                            </rich:column>
                            <rich:column sortable="false" width="40%">
                                <f:facet name="header" ><h:outputText  value="Normes"/></f:facet>
                                <h:outputText value="#{four.profchNorme}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </h:panelGrid>

                    <h:panelGrid id="reponse2" width="100%" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsDetail.prodetType==5||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsDetail.prodetType==7)}">
                        <center>
                            <h:panelGrid id="panelBoutonReponseDetail" columns="3" width="150px">
                                <a4j:commandButton title="Ajouter réponse" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.ajouterReponseDetail}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_ajt}"  oncomplete="javascript:Richfaces.showModalPanel('panelReponseDetail');" reRender="panelReponseDetail"/>
                                <a4j:commandButton title="Modifier réponse" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.modifierReponseDetail}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.afficheButtReponseDetail&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_mod}"  oncomplete="javascript:Richfaces.showModalPanel('panelReponseDetail');" reRender="panelReponseDetail"/>
                                <a4j:commandButton title="Supprimer réponse" image="/images/supprimer.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.supprimerReponseDetail}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.afficheButtReponseDetail&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_sup}"  onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false"  reRender="tableauReponseDetail,panelBoutonReponseDetail"/>
                            </h:panelGrid>
                        </center>
                        <rich:extendedDataTable width="100%" style="border:solid 0px green;" border="0"  height="250px" id="tableauReponseDetail" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" enableContextMenu="false" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.datamodelReponseDetail}" var="rep">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" reRender="panelBoutonReponseDetail"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.selectionReponseDetail}"/>
                            <rich:column sortable="false" width="10%" >
                                <f:facet name="header" ><h:outputText  value="Ordre"/></f:facet>
                                <h:outputText value="#{rep.prorepOrdre}"/>
                            </rich:column>
                            <rich:column style="height:20px;" width="5%" sortable="false">
                                <f:facet name="header"><h:outputText  value="Down" /></f:facet>
                                <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.descendreReponseDetail}" image="/images/downarrow.png" rendered="#{((bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.datamodelReponseDetail.rowIndex+1)<bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.datamodelReponseDetail.rowCount)==true}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                            </rich:column>
                            <rich:column style="height:20px;" width="5%" sortable="false" >
                                <f:facet name="header"><h:outputText  value="Up" /></f:facet>
                                <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.monterReponseDetail}"  image="/images/uparrow.png" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.datamodelReponseDetail.rowIndex>=1)==true}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                            </rich:column>
                            <rich:column sortable="false" width="80%">
                                <f:facet name="header" ><h:outputText  value="Réponse"/></f:facet>
                                <h:outputText value="#{rep.prorepReponse}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </h:panelGrid>

                    <h:panelGrid id="reponse3" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsDetail.prodetType==6}">
                        <center>
                            <h:panelGrid id="panelBoutonReponseExamenChaine" columns="2" width="100px">
                                <a4j:commandButton title="Ajouter examen chainé" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.ajouterReponseExamenChaine}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_ajt}"  oncomplete="javascript:Richfaces.showModalPanel('panelExamenChaine');" reRender="panelExamenChaine"/>
                                <a4j:commandButton title="Supprimer examen chainé" image="/images/supprimer.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.supprimerReponseExamenChaine}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.afficheButtReponseDetail&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_sup}"  onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false"  reRender="tableauReponseExamenChaine,panelBoutonReponseExamenChaine"/>
                            </h:panelGrid>
                        </center>
                        <rich:extendedDataTable width="100%" style="border:solid 0px green;" border="0"  height="250px" id="tableauReponseExamenChaine" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" enableContextMenu="false" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.datamodelReponseDetail}" var="rep">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" reRender="panelBoutonReponseExamenChaine"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.selectionReponseExamenChaine}"/>
                            <rich:column sortable="false" width="10%" >
                                <f:facet name="header" ><h:outputText  value="Ordre"/></f:facet>
                                <h:outputText value="#{rep.prorepOrdre}"/>
                            </rich:column>
                            <rich:column style="height:20px;" width="5%" sortable="false">
                                <f:facet name="header"><h:outputText  value="Down" /></f:facet>
                                <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.descendreReponseDetail}" image="/images/downarrow.png" rendered="#{((bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.datamodelReponseDetail.rowIndex+1)<bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.datamodelReponseDetail.rowCount)==true}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                            </rich:column>
                            <rich:column style="height:20px;" width="5%" sortable="false" >
                                <f:facet name="header"><h:outputText  value="Up" /></f:facet>
                                <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.monterReponseDetail}"  image="/images/uparrow.png" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.datamodelReponseDetail.rowIndex>=1)==true}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                            </rich:column>
                            <rich:column sortable="false" width="10%">
                                <f:facet name="header" ><h:outputText  value="Code"/></f:facet>
                                <h:outputText value="#{rep.prorepCodeExamen}"/>
                            </rich:column>
                            <rich:column sortable="false" width="70%">
                                <f:facet name="header" ><h:outputText  value="Examen"/></f:facet>
                                <h:outputText value="#{rep.prorepLibelleExamen}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </h:panelGrid>

                </h:panelGrid>
                <br/>  <br/>
                <center>
                    <h:panelGroup id="buttGrpDetail">
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.saveProduitsDetail}" reRender="panelDetail,tableauDetail"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel id="panelFourchetteDetail" width="600" height="400" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.showModalPanelFourchetteDetail}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.showModalPanelFourchetteDetail}" var="rdf">
            <f:facet name="header"><h:outputText value="GESTION DES FOURCHETTES DES EXAMENS"></h:outputText></f:facet>
            <f:facet name="controls">
                <h:panelGroup>
                    <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="hidelinkFourDet"/>
                    <rich:componentControl for="panelFourchetteDetail" attachTo="hidelinkFourDet" operation="hide" event="onclick"/>
                </h:panelGroup>
            </f:facet>
            <a4j:form id="formFourchetteDetail">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid columns="2" width="100%" columnClasses="clos20,clos80" id="panFourDet">
                    <h:column><h:outputText value="Type Genre:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsFourchette.profchSexe}">
                            <f:selectItem itemLabel="Tout sexe" itemValue="2"/>
                            <f:selectItem itemLabel="Femme" itemValue="0"/>
                            <f:selectItem itemLabel="Homme" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Type Age:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsFourchette.profchAge}">
                            <f:selectItem itemLabel="Tout age" itemValue="0"/>
                            <f:selectItem itemLabel="Bébé" itemValue="1"/>
                            <f:selectItem itemLabel="Enfant" itemValue="2"/>
                            <f:selectItem itemLabel="Adolescent" itemValue="3"/>
                            <f:selectItem itemLabel="Adulte" itemValue="4"/>
                            <f:selectItem itemLabel="Sénior" itemValue="5"/>
                            <f:selectItem itemLabel="Age en année" itemValue="10"/>
                            <f:selectItem itemLabel="Age en mois" itemValue="11"/>
                            <f:selectItem itemLabel="Age en jour" itemValue="12"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.calculeFourchette}" reRender="labo2,panFourDet"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsFourchette.profchAge!=0}"><h:outputText value="Age début:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsFourchette.profchAge!=0}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsFourchette.profchAgeDebut}" style="text-align:right;width:100px"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsFourchette.profchAge!=0}"><h:outputText value="Age fin:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsFourchette.profchAge!=0}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsFourchette.profchAgeFin}" style="text-align:right;width:100px"/></h:column>
                    <h:column><h:outputText value="Fourchette Minimale:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsFourchette.profchFmini}" style="text-align:right;width:100px"/></h:column>
                    <h:column><h:outputText value="Fourchette Maximale:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsFourchette.profchFmaxi}" style="text-align:right;width:100px"/></h:column>
                    <h:column><h:outputText value="Limite Minimale:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsFourchette.profchLmini}" style="text-align:right;width:100px"/></h:column>
                    <h:column><h:outputText value="Limite Maximale:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsFourchette.profchLmaxi}" style="text-align:right;width:100px"/></h:column>
                    <h:column><h:outputText value="Normes:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsFourchette.profchNorme}" style="width:100%"/></h:column>
                </h:panelGrid>
                <br/>  <br/>
                <center>
                    <h:panelGroup  id="buttGrpFourchetteDet">
                        <a4j:commandButton image="/images/valider_big.png" id="savePanDet">
                            <rich:componentControl for="panelFourchetteDetail" attachTo="savePanDet" operation="hide" event="onclick"/>
                            <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.saveProduitsFourchetteDetail}" reRender="tableauFourchetteDetail"/>
                        </a4j:commandButton >
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel id="panelReponseDetail" width="730" height="350" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.showModalPanelReponseDetail}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.showModalPanelReponseDetail}" var="rdf">
            <f:facet name="header"><h:outputText value="GESTION DES REPONSES PREDEFINIES DES EXAMENS"></h:outputText></f:facet>
            <f:facet name="controls">
                <h:panelGroup>
                    <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="hidelinkRepDet"/>
                    <rich:componentControl for="panelReponseDetail" attachTo="hidelinkRepDet" operation="hide" event="onclick"/>
                </h:panelGroup>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%" style="height:200;border:0px solid green" >
                    <h:inputTextarea  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsReponse.prorepReponse}" style="width:100%" rows="5"/>
                </h:panelGrid>
                <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsDetail.prodetType==6}">
                    <h:column rendered="false"><h:outputText value="Question:"/></h:column>
                    <h:column rendered="false"><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsReponse.prorepQuestion}"/></h:column>
                    <h:column rendered="false"><h:outputText value="Réponse négative:"/></h:column>
                    <h:column rendered="false"><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsReponse.prorepActionNegative}"/></h:column>
                    <h:column rendered="false"><h:outputText value="Réponse positive:"/></h:column>
                    <h:column rendered="false"><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsReponse.prorepActionPositive}"/></h:column>
                    <h:column><h:outputText value="Réponse numérique:"/></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsReponse.prorepActionNumerique}"/></h:column>
                    <h:column><h:outputText value="Réponse texte:"/></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsReponse.prorepActionTexte}"/></h:column>
                    <h:column><h:outputText value="Texte prédifini:"/></h:column>
                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsReponse.prorepTexteModifiable}"/></h:column>
                </h:panelGrid>
                <br/>  <br/>
                <center>
                    <h:panelGroup  id="buttGrpReponsDet">
                        <a4j:commandButton image="/images/valider_big.png" id="saveRepDet">
                            <rich:componentControl for="panelReponseDetail" attachTo="saveRepDet" operation="hide" event="onclick"/>
                            <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.saveProduitsReponseDetail}" reRender="tableauReponseDetail"/>
                        </a4j:commandButton >
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel id="panelReponseExamenChaine" width="500" height="300" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.showModalPanelReponseExamenChaine}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.showModalPanelReponseExamenChaine}" var="rdf">
            <f:facet name="header"><h:outputText value="GESTION DES EXAMENS CHAINES"></h:outputText></f:facet>
            <f:facet name="controls">
                <h:panelGroup>
                    <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="hidelinkRepDetEC"/>
                    <rich:componentControl for="panelReponseExamenChaine" attachTo="hidelinkRepDetEC" operation="hide" event="onclick"/>
                </h:panelGroup>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%" style="height:200;border:0px solid green" >
                    <h:column>
                        <h:selectOneMenu style="width:90%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.produitsReponse.prorepCodeExamen}">
                            <f:selectItem itemLabel="Sélection examen" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.mesExamnensChainesItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <br/>  <br/>
                <center>
                    <h:panelGroup  id="buttGrpReponsDetEC">
                        <a4j:commandButton image="/images/valider_big.png" id="saveRepDetEC">
                            <rich:componentControl for="panelReponseExamenChaine" attachTo="saveRepDet" operation="hide" event="onclick"/>
                            <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.saveProduitsReponseExamneChaine}" reRender="panelReponseExamenChaine"/>
                        </a4j:commandButton >
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel id="panelListeProduitsLies" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.showModalProduitRecherche}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.showModalProduitRecherche}" var="prdgrp">
            <f:facet name="header"><h:outputText value="Sélection du produit"/></f:facet>
            <a4j:form id="formModalListeProduits">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  width="100%">
                    <rich:extendedDataTable id="tableProd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.datamodelProduitsLieRecherche}"  var="prd">
                        <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.selectionProduits}"/>
                        <f:facet name="header"></f:facet>
                        <rich:column label="Code" sortable="true" sortBy="#{prd.proCode}" width="15%">
                            <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                            <h:outputText value="#{prd.proCode}"/>
                        </rich:column>
                        <rich:column label="Libellé produit" sortable="true" sortBy="#{prd.proLibClient}" width="55%">
                            <f:facet name="header"><h:outputText  value="Libellé produit" /></f:facet>
                            <h:outputText value="#{prd.proLibClient}"/>
                        </rich:column>
                        <rich:column label="Famille" sortable="true" sortBy="#{prd.proVteLib}" width="20%">
                            <f:facet name="header"><h:outputText  value="Famille" /></f:facet>
                            <h:outputText value="#{prd.proVteLib}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </h:panelGrid>
                <br>
                <h:panelGroup id="valprod">
                    <center>
                        <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.annuleProduits}" reRender="panelListeProduitsLies"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.calculeProduits}" reRender="panelListeProduitsLies,inpCodDet"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
