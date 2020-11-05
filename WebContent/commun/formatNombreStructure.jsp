<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strformatdevise==0}">
    <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
</c:if>
<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strformatdevise==1}">
    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
</c:if>
<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strformatdevise==2}">
    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
</c:if>