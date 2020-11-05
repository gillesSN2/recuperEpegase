<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="import">

    <a4j:form enctype="multipart/form-data">
        <rich:hotKey key="return" handler="return true;"/>

        <center> <h2><h:outputText value="GESTION DES NUMEROS DE SERIE" styleClass="titre"/></h2></center>

        <h:panelGroup id="grid">
            <center>
                <h:column>
                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.var_choix_importation}">
                        <f:selectItem itemLabel="Choissisez le mode d'importation..." itemValue="0"/>
                        <f:selectItem itemLabel="Importation par fichier texte (CSV)" itemValue="1"/>
                        <f:selectItem itemLabel="Importation via serveur FTP" itemValue="2" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif==0}"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="grid"/>
                    </h:selectOneMenu>
                </h:column>
                <br>
                <a4j:commandButton value="Information sur l'importation" title="Information" oncomplete="javascript:Richfaces.showModalPanel('panelInfo');" reRender="panelInfo" />
                <br>
                <h:commandButton rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.var_choix_importation==1}" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:300px;" value="Sélection du fichier à importer..." action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.selectionFichier}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                <h:commandButton rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.var_choix_importation==2}" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:300px;" value="Importation à  partir d'un site ftp" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.importFtp}"/>
            </center>
        </h:panelGroup>
        <br>
        <h:panelGrid id="panCtrl" styleClass="recherche" width="100%" columns="7">
            <h:column><h:outputText value="N°Série"/></h:column>
            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.inpNum}" size="5"/></h:column>
            <h:column>
                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.inpEtat}" style="width:150px;">
                    <f:selectItem itemLabel="Tous Etats" itemValue="100"/>
                    <f:selectItem itemLabel="Non imputé" itemValue="0"/>
                    <f:selectItem itemLabel="Imputé" itemValue="1"/>
                    <f:selectItem itemLabel="Disponible" itemValue="2"/>
                    <f:selectItem itemLabel="Non disponible" itemValue="3"/>
                </h:selectOneMenu>
            </h:column>
            <h:column>
                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.inpCarton}" style="width:150px;">
                    <f:selectItem itemValue="0" itemLabel="Tous les cartons"/>
                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.mesCartonsItem}" />
                </h:selectOneMenu>
            </h:column>
            <h:column>
                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.inpPalette}" style="width:150px;">
                    <f:selectItem itemValue="0" itemLabel="Toutes les palettes"/>
                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.mesPalettesItem}" />
                </h:selectOneMenu>
            </h:column>
            <h:column>
                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.inpLot}" style="width:150px;">
                    <f:selectItem itemValue="0" itemLabel="Tous les lots"/>
                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.mesLotsItem}" />
                </h:selectOneMenu>
            </h:column>
            <h:column>
                <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.executerRequete}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panCtrl,tableSerieGlobal,scrollTable"/>
                <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
            </h:column>
        </h:panelGrid>
        <br>
        <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20" align="left" for="tableSerieGlobal"/>
                <rich:extendedDataTable rows="100" id="tableSerieGlobal" enableContextMenu="true" footerClass="bard" headerClass="headerTab" activeClass="active-row" rowClasses="rows1,rows2,rowsd" noDataLabel=" " styleClass="bg" border="0" width="200%" style="max-height:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.dataModelSerie}" var="serie">
                    <rich:column label="N° Série" sortable="true" sortBy="#{serie.recserSerie}" width="150px">
                        <f:facet name="header"><h:outputText value="N° Série"/></f:facet>
                        <h:outputText value="#{serie.recserSerie}"/>
                    </rich:column>
                    <rich:column label="Code produit" sortable="true" width="150px">
                        <f:facet name="header"><h:outputText value="Produit"/></f:facet>
                        <h:outputText value="#{serie.recserCode}"/>
                    </rich:column>
                    <rich:column label="Carton" sortable="true" sortBy="#{serie.recserCarton}">
                        <f:facet name="header"><h:outputText value="Carton"/></f:facet>
                        <h:outputText value="#{serie.recserCarton}"/>
                    </rich:column>
                    <rich:column label="Palette" sortable="true" sortBy="#{serie.recserPalette}">
                        <f:facet name="header"><h:outputText value="Palette"/></f:facet>
                        <h:outputText value="#{serie.recserPalette}"/>
                    </rich:column>
                    <rich:column label="N° lot" sortable="true" sortBy="#{serie.recserLot}">
                        <f:facet name="header"><h:outputText value="N° lot"/></f:facet>
                        <h:outputText value="#{serie.recserLot}"/>
                    </rich:column>
                    <rich:column label="Champ 1" sortable="true" sortBy="#{serie.recserChamp1}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.champ1}">
                        <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.optionAchats.serie1}"/></f:facet>
                        <h:outputText value="#{serie.recserChamp1}"/>
                    </rich:column>
                    <rich:column label="Champ 2" sortable="true" sortBy="#{serie.recserChamp2}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.champ2}">
                        <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.optionAchats.serie2}"/></f:facet>
                        <h:outputText value="#{serie.recserChamp2}"/>
                    </rich:column>
                    <rich:column label="Champ 3" sortable="true" sortBy="#{serie.recserChamp3}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.champ3}">
                        <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.optionAchats.serie3}"/></f:facet>
                        <h:outputText value="#{serie.recserChamp3}"/>
                    </rich:column>
                    <rich:column label="Champ 4" sortable="true" sortBy="#{serie.recserChamp4}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.champ4}">
                        <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.optionAchats.serie4}"/></f:facet>
                        <h:outputText value="#{serie.recserChamp4}"/>
                    </rich:column>
                    <rich:column label="Champ 5" sortable="true" sortBy="#{serie.recserChamp5}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.champ5}">
                        <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.optionAchats.serie5}"/></f:facet>
                        <h:outputText value="#{serie.recserChamp5}"/>
                    </rich:column>
                    <rich:column label="Champ 6" sortable="true" sortBy="#{serie.recserChamp6}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.champ6}">
                        <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.optionAchats.serie6}"/></f:facet>
                        <h:outputText value="#{serie.recserChamp6}"/>
                    </rich:column>
                    <rich:column label="Champ 7" sortable="true" sortBy="#{serie.recserChamp7}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.champ7}">
                        <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.optionAchats.serie7}"/></f:facet>
                        <h:outputText value="#{serie.recserChamp7}"/>
                    </rich:column>
                    <rich:column label="Champ 8" sortable="true" sortBy="#{serie.recserChamp8}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.champ8}">
                        <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.optionAchats.serie8}"/></f:facet>
                        <h:outputText value="#{serie.recserChamp8}"/>
                    </rich:column>
                    <rich:column label="Champ 9" sortable="true" sortBy="#{serie.recserChamp9}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.champ9}">
                        <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.optionAchats.serie9}"/></f:facet>
                        <h:outputText value="#{serie.recserChamp9}"/>
                    </rich:column>
                    <rich:column label="Champ 10" sortable="true" sortBy="#{serie.recserChamp10}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.champ10}">
                        <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.optionAchats.serie10}"/></f:facet>
                        <h:outputText value="#{serie.recserChamp10}"/>
                    </rich:column>
                    <rich:column label="Champ 11" sortable="true" sortBy="#{serie.recserChamp11}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.champ11}">
                        <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.optionAchats.serie11}"/></f:facet>
                        <h:outputText value="#{serie.recserChamp11}"/>
                    </rich:column>
                    <rich:column label="Champ 12" sortable="true" sortBy="#{serie.recserChamp12}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.champ12}">
                        <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.optionAchats.serie12}"/></f:facet>
                        <h:outputText value="#{serie.recserChamp12}"/>
                    </rich:column>
                    <rich:column label="Champ 13" sortable="true" sortBy="#{serie.recserChamp13}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.champ13}">
                        <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.optionAchats.serie13}"/></f:facet>
                        <h:outputText value="#{serie.recserChamp13}"/>
                    </rich:column>
                    <rich:column label="Champ 14" sortable="true" sortBy="#{serie.recserChamp14}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.champ14}">
                        <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.optionAchats.serie14}"/></f:facet>
                        <h:outputText value="#{serie.recserChamp14}"/>
                    </rich:column>
                    <rich:column label="Champ 15" sortable="true" sortBy="#{serie.recserChamp15}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.champ15}">
                        <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.optionAchats.serie15}"/></f:facet>
                        <h:outputText value="#{serie.recserChamp15}"/>
                    </rich:column>
                    <rich:column label="Champ 16" sortable="true" sortBy="#{serie.recserChamp16}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.champ16}">
                        <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.optionAchats.serie16}"/></f:facet>
                        <h:outputText value="#{serie.recserChamp16}"/>
                    </rich:column>
                    <rich:column label="Champ 17" sortable="true" sortBy="#{serie.recserChamp17}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.champ17}">
                        <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.optionAchats.serie17}"/></f:facet>
                        <h:outputText value="#{serie.recserChamp17}"/>
                    </rich:column>
                    <rich:column label="Champ 18" sortable="true" sortBy="#{serie.recserChamp18}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.champ18}">
                        <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.optionAchats.serie18}"/></f:facet>
                        <h:outputText value="#{serie.recserChamp18}"/>
                    </rich:column>
                    <rich:column label="Champ 19" sortable="true" sortBy="#{serie.recserChamp19}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.champ19}">
                        <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.optionAchats.serie19}"/></f:facet>
                        <h:outputText value="#{serie.recserChamp19}"/>
                    </rich:column>
                    <rich:column label="Champ 20" sortable="true" sortBy="#{serie.recserChamp20}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.champ20}">
                        <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.optionAchats.serie20}"/></f:facet>
                        <h:outputText value="#{serie.recserChamp20}"/>
                    </rich:column>
                    <rich:column label="Date entrée" sortable="true">
                        <f:facet name="header"><h:outputText value="Entrée"/></f:facet>
                        <h:outputText value="#{serie.recserDateIn}">
                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                        </h:outputText>
                    </rich:column>
                    <rich:column label="N° Réception" sortable="true">
                        <f:facet name="header"><h:outputText value="Réception"/></f:facet>
                        <h:outputText value="#{serie.recserNum}"/>
                    </rich:column>
                    <rich:column label="N° Production" sortable="true">
                        <f:facet name="header"><h:outputText value="Production"/></f:facet>
                        <h:outputText value="#{serie.recserProduction}"/>
                    </rich:column>
                    <rich:column label="Date Sortie" sortable="true">
                        <f:facet name="header"><h:outputText value="Sortie"/></f:facet>
                        <h:outputText value="#{serie.recserDateOut}">
                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                        </h:outputText>
                    </rich:column>
                    <rich:column label="N° BL" sortable="true">
                        <f:facet name="header"><h:outputText value="Livraison"/></f:facet>
                        <h:outputText value="#{serie.recserNumBl}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </div>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelInfo" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="600" height="500">
        <center>
            <f:facet name="header"><h:outputText value="Information sur l'importation" style="color:white;"/></f:facet>
            <f:facet name="controls">
                <h:panelGroup>
                    <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="hidelinkInfo"/>
                    <rich:componentControl for="panelInfo" attachTo="hidelinkInfo" operation="hide" event="onclick"/>
                </h:panelGroup>
            </f:facet>
            <a4j:form id="formModalInfo" >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%">
                    <div style="text-align:center;text-decoration:underline;">Le format CSV (comma-separated-values) ?
                    </div>
                    <br><br>
                    <div style="text-align:justify;">Le format CSV (comma-separated-values) est un format de communication qui respecte la norme CSV décrite sous la référence <A target="_blank" HREF="http://tools.ietf.org/html/rfc4180" TITLE="description" style="color:blue;"> RFC 4180 </A>.
                        Le format de communication est donc le CSV et voici le détail de la structure du fichier. Chaque champ est séparé par une virgule et chaque enregistrement est terminé par un point-virgule puis par un retour chariot (car13).<br><br>
                        Il est constitué de 5 colonnes obligatoires et de plusieurs colonnes optionnelles:<br>
                        <b></b> <br>
                        - colonne 01 : N° de série (20 caractères maximum) <br>
                        - colonne 02 : Code produit (20 caractères maximun) <br>
                        - colonne 03 : Carton (20 caractères maximun) <br>
                        - colonne 04 : Palette (20 caractères maximun) <br>
                        - colonne 05 : N° lot (20 caractères maximun) <br>
                    </div>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.champ1}"><h:outputText value="- colonne 06 : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.optionAchats.serie1}"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.champ2}"><h:outputText value="- colonne 07 : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.optionAchats.serie2}"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.champ3}"><h:outputText value="- colonne 08 : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.optionAchats.serie3}"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.champ4}"><h:outputText value="- colonne 09 : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.optionAchats.serie4}"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.champ5}"><h:outputText value="- colonne 10 : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.optionAchats.serie5}"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.champ6}"><h:outputText value="- colonne 11 : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.optionAchats.serie6}"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.champ7}"><h:outputText value="- colonne 12 : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.optionAchats.serie7}"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.champ8}"><h:outputText value="- colonne 13 : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.optionAchats.serie8}"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.champ9}"><h:outputText value="- colonne 14 : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.optionAchats.serie9}"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.champ10}"><h:outputText value="- colonne 15 : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.optionAchats.serie10}"/></h:column>
                </h:panelGrid>
            </a4j:form>
        </center>
    </rich:modalPanel>

</f:subview>
