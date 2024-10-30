<!doctype html public "-//w3c//dtd html 4.0 transitional//en">
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<html xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://www.w3.org/1999/xhtml" xmlns:rich="http://richfaces.org/rich" xmlns:a4j="http://richfaces.org/a4j">
    <head>
        <title>Richfaces/Native File Upload</title>
    </head>

    <body>
        <f:view>
            <h:form enctype="multipart/form-data">
                <h:panelGrid columns="2" cellpadding="2" cellspacing="2" styleClass="sectionHeaderTable">
                    <h:panelGrid columns="1" rendered="#{selectedExamBean.selectedExam != null and selectedExamBean.exam.rowCount > 0}"  styleClass="sectionHeaderTable" width="100%" cellpadding="4" cellspacing="4">
                        <h:inputFile value="#{processDatFileBean.uploadedFile}" required="true"/>
                        <h:outputText id="friendlyMsg" value="File to upload can be found at: c:\\cetarsanswers\\exam.dat or" styleClass="uploadText"/>
                        <h:outputText id="friendlyMsg2" value="c:\\Users\\Public\\Documents\\cetarsanswers\\exam.dat" styleClass="uploadText"/>
                    </h:panelGrid>

                    <h:panelGrid rendered="#{selectedExamBean.selectedExam != null}" id="inventory_1000" columns="2" styleClass="sectionHeaderTable" width="100%"  cellpadding="0" cellspacing="0">
                        <h:panelGrid columns="1" cellpadding="4" cellspacing="4">
                            <h:commandButton disabled="#{selectedExamBean.selectedExam == null or selectedExamBean.exam.rowCount < 1}" id="inventory_1400" value="Upload And Save" action="#{processDatFileBean.uploadFile}"/>
                            <h:commandButton disabled="#{not processDatFileBean.uploadSuccessful}" value="Review Grades" action="#{selectedExamBean.review}" id="AutoGeneratedId_11877936128430"/>
                            <h:commandButton disabled="#{selectedExamBean.selectedExam == null}" id="cnx" value="Cancel" action="#{processDatFileBean.cancel}"/>
                        </h:panelGrid>
                        <h:outputText value="#{processDatFileBean.displayMessage}" rendered="#{processDatFileBean.errors == null}" styleClass="errorText" id="AutoGeneratedId_11877936128431"/>
                        <h:dataTable id="errs"
                                        value="#{processDatFileBean.errors}"
                                        var="cur"
                                        columnClasses="leftJustified"
                                        rendered="#{processDatFileBean.errors != null}">
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Errors" styleClass="columnHeaderText"/>
                                </f:facet>
                                <h:outputText value="#{cur}" styleClass="errorText"/>
                            </h:column>
                        </h:dataTable>
                    </h:panelGrid>
                </h:panelGrid>
            </h:form>
        </f:view>
     </body>
 </html>