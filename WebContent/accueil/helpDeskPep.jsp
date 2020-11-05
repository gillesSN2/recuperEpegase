<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="hd">

    <center><h2><h:outputText value="Helpdesk Assistants" style="color:green;"/></h2></center>

    <a4j:form id="formhelpdeskAss">

        <h:panelGrid width="100%" border="0">

            <center>
                <table width="400" border="0" cellspacing="0" cellpadding="0" align="center">
                    <tr>
                        <td>
                            <center>
                                <a href="https://foubetc.synology.me/osticket/scp" target="_blank"><font face="Arial" size="-1">Help-desk OSTICKET</font></a>
                            </center>
                        </td>
                    </tr>
                </table>
            </center>

        </h:panelGrid>

    </a4j:form>

</f:subview>