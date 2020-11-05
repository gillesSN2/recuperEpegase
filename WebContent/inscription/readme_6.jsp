<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<h:panelGrid  id="lic6" border="0" width="100%">

    <div style="text-align:center;">Le groupe Horus Solutions regroupe plusieurs filiales sur plusieurs pays afin d'être plus prés de ses clients.</div>

    <br>

    <h:panelGrid width="100%">
        <center>

            <rich:tabPanel switchType="client" immediate="true" style="border:0px;" width="100%">

                <rich:tab label="Le Groupe">

                    <center>
                        <a href="http://horus-solutions.net/" target="_blank"><img src="images/logo_horus.png" alt="Horus Solutions" height="100" width="200" style="margin-bottom:5px;" title="HORUS Solutions"></a>
                    </center>

                    <h:panelGrid columns="2" columnClasses="clos70,clos30" width="100%" style="border:solid 1px red;">
                        <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%">
                            <h:outputText value="Pays:" style="font-weight:bold;"></h:outputText>
                            <h:outputText value="MALI" />
                            <h:outputText value="Ville:" style="font-weight:bold;"></h:outputText>
                            <h:outputText value="Bamako" />
                            <h:outputText value="Domaines:" style="font-weight:bold;"></h:outputText>
                            <h:outputText value="Recherche & Développement, Assistances, Formations" />
                            <h:outputText value="Contact:" style="font-weight:bold;"></h:outputText>
                            <h:outputText value="Mr Bara NGOM" />
                            <h:outputText value="Adresse:" style="font-weight:bold;"></h:outputText>
                            <h:outputText value="Sotuba ACI" />
                            <h:outputText value="Tél.:" style="font-weight:bold;"></h:outputText>
                            <h:outputText value="+223 20 21 31 32" />
                        </h:panelGrid>
                    </h:panelGrid>

                    <h:panelGrid columns="2" columnClasses="clos70,clos30" width="100%" style="border:solid 1px red;">
                        <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%">
                            <h:outputText value="Pays:" style="font-weight:bold;"></h:outputText>
                            <h:outputText value="SENEGAL" />
                            <h:outputText value="Ville:" style="font-weight:bold;"></h:outputText>
                            <h:outputText value="Dakar" />
                            <h:outputText value="Domaines:" style="font-weight:bold;"></h:outputText>
                            <h:outputText value="Recherche & Développement, Assistances, Formations" />
                            <h:outputText value="Contact:" style="font-weight:bold;"></h:outputText>
                            <h:outputText value="Mr Khadim NDIAYE" />
                            <h:outputText value="Adresse:" style="font-weight:bold;"></h:outputText>
                            <h:outputText value="Yoff - Virage" />
                            <h:outputText value="Tél.:" style="font-weight:bold;"></h:outputText>
                            <h:outputText value="+221 77 787 49 34" />
                        </h:panelGrid>
                    </h:panelGrid>

                    <h:panelGrid columns="2" columnClasses="clos70,clos30" width="100%" style="border:solid 1px red;">
                        <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%">
                            <h:outputText value="Pays:" style="font-weight:bold;"></h:outputText>
                            <h:outputText value="GABON" />
                            <h:outputText value="Ville:" style="font-weight:bold;"></h:outputText>
                            <h:outputText value="Libreville" />
                            <h:outputText value="Domaines:" style="font-weight:bold;"></h:outputText>
                            <h:outputText value="Recherche & Développement, Assistances, Formations" />
                            <h:outputText value="Contact:" style="font-weight:bold;"></h:outputText>
                            <h:outputText value="Mr Gilles de CRUZEL" />
                            <h:outputText value="Adresse:" style="font-weight:bold;"></h:outputText>
                            <h:outputText value="Charbonage (Colis Postaux)" />
                            <h:outputText value="Tél.:" style="font-weight:bold;"></h:outputText>
                            <h:outputText value="+241 01 44 55 25" />
                        </h:panelGrid>
                    </h:panelGrid>

                     <h:panelGrid columns="2" columnClasses="clos70,clos30" width="100%" style="border:solid 1px red;">
                        <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%">
                            <h:outputText value="Pays:" style="font-weight:bold;"></h:outputText>
                            <h:outputText value="France" />
                            <h:outputText value="Ville:" style="font-weight:bold;"></h:outputText>
                            <h:outputText value="Metz" />
                            <h:outputText value="Domaines:" style="font-weight:bold;"></h:outputText>
                            <h:outputText value="DATA CENTER & HOSTING" />
                            <h:outputText value="Contact:" style="font-weight:bold;"></h:outputText>
                            <h:outputText value="Mr Christophe FOUBET" />
                            <h:outputText value="Adresse:" style="font-weight:bold;"></h:outputText>
                            <h:outputText value="..." />
                            <h:outputText value="Tél.:" style="font-weight:bold;"></h:outputText>
                            <h:outputText value="..." />
                        </h:panelGrid>
                    </h:panelGrid>

                    <h:panelGrid columns="4" columnClasses="clos12d,clos35d,clos12d,clos35d" width="100%" style="border:solid 1px red;">
                        <h:outputText value="Site Web:" style="font-weight:bold;"></h:outputText>
                        <h:outputLink value="http://www.horus-solutions.net" target="blank">
                            <h:outputText value="http://www.horus-solutions.net" />
                        </h:outputLink>
                        <h:outputText value="Adresse Mail:" style="font-weight:bold;"></h:outputText>
                        <h:outputLink value="mailto: info@horus-solutions.net">
                            <h:outputText value="info@horus-solutions.net" />
                        </h:outputLink>
                    </h:panelGrid>

                </rich:tab>

            </rich:tabPanel>
        </center>
    </h:panelGrid>
</h:panelGrid>


