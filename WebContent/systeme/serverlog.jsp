<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="fmrServerlog" >
    <center> <h2 style="color:green;font-size:18px;">SERVER.LOG</h2></center>

    <h:panelGrid width="100%" border="0">

        <h:inputTextarea value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.formServerLog.fichierServer}" readonly="true" rows="30" style="width:100%"/>

    </h:panelGrid>
    
</f:subview>