<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>

<rich:column label="Administrateur" width="7%" sortable="true" sortBy="#{utilisateur.usrSysteme}" style="text-align:center;">
    <f:facet name="header"> <h:outputText value="Adm."/></f:facet>
    <h:graphicImage value="/images/co-chef.png" rendered="#{utilisateur.usrSysteme==1}" title="Co-administrateur"/>
    <h:graphicImage value="/images/chef.png" rendered="#{utilisateur.usrSysteme==2}" title="Administrateur"/>
    <h:graphicImage value="/images/configuration.png" rendered="#{utilisateur.usrSysteme==3}"/>
    <h:graphicImage value="/images/tiers.png" height="15px" width="15px" rendered="#{utilisateur.usrIdSalarieGuest!=0}" title="Connexion Users/Salariés"/>
    <h:graphicImage value="/images/dollar.png" height="15px" width="15px" rendered="#{utilisateur.usrCaissier!=0&&utilisateur.groupe.grpModuleCai==1}" title="Accès caisse complète"/>
    <h:graphicImage value="/images/panier.png" height="15px" width="15px" rendered="#{utilisateur.usrCaissier!=0&&utilisateur.groupe.grpModuleCai==2}" title="Accès bon de sortie"/>
</rich:column>
<rich:column label="Etat" width="5%" sortable="true" sortBy="#{utilisateur.usrEtat}" style="text-align:center;">
    <f:facet name="header"> <h:outputText value="Etat"/></f:facet>
    <h:graphicImage value="/images/desactiver.png" rendered="#{utilisateur.usrEtat==0}"/>
</rich:column>
<rich:column label="Compte" width="10%" sortBy="#{utilisateur.usrCompte}" sortable="true">
    <f:facet name="header"> <h:outputText value="Cpt."/></f:facet>
    <h:outputText value="#{utilisateur.usrCompte}" style="#{utilisateur.color}"/>
</rich:column>
<rich:column label="Groupe" width="10%" sortBy="#{utilisateur.usrCollaboration}" sortable="true" filterBy="#{utilisateur.usrCollaboration}">
    <f:facet name="header"> <h:outputText value="Grp."/></f:facet>
    <h:outputText value="#{utilisateur.usrCollaboration}" style="#{utilisateur.color}"/>
</rich:column>
<rich:column label="Nom" width="30%" sortBy="#{utilisateur.usrNom}" sortable="true" sortOrder="ASCENDING" filterBy="#{utilisateur.usrNom}">
    <f:facet name="header"> <h:outputText value="Nom et prénom"/></f:facet>
    <h:outputText value="#{utilisateur.usrNom}  #{utilisateur.usrPrenom}" style="#{utilisateur.color}"/>
</rich:column>
<rich:column label="Service" width="10%" sortBy="#{utilisateur.usrService}" sortable="true" filterBy="#{utilisateur.usrService}">
    <f:facet name="header"> <h:outputText value="Service"/></f:facet>
    <h:outputText value="#{utilisateur.usrService}" style="#{utilisateur.color}"/>
</rich:column>
<rich:column label="Fonction" width="10%" sortBy="#{utilisateur.var_fonction}" sortable="true" filterBy="#{utilisateur.var_fonction}">
    <f:facet name="header"> <h:outputText value="Fonction"/></f:facet>
    <h:outputText value="#{utilisateur.var_fonction}" style="#{utilisateur.color}"/>
</rich:column>
<rich:column label="Options" width="10%" sortBy="#{utilisateur.var_options}" sortable="true">
    <f:facet name="header"> <h:outputText value="Options"/></f:facet>
    <h:outputText value="#{utilisateur.var_options}" style="#{utilisateur.color}"/>
</rich:column>
<rich:column label="Equipe" width="10%" sortBy="#{utilisateur.usrNomEquipe}" sortable="true">
    <f:facet name="header"> <h:outputText value="Equipe"/></f:facet>
    <h:outputText value="#{utilisateur.usrNomEquipe}" style="#{utilisateur.color}"/>
</rich:column>

