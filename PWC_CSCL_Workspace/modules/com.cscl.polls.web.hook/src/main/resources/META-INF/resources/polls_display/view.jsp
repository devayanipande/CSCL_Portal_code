<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>
<%@page import="java.net.URLEncoder" %>
<%@ include file="/polls_display/init.jsp" %>

<%
long blogPollId = GetterUtil.getLong(request.getAttribute("blog-poll-id"));
String site_url = themeDisplay.getPortalURL();
String temp_url = site_url + themeDisplay.getURLCurrent();
String current_url = URLEncoder.encode(temp_url , "UTF-8");
PollsQuestion question = null;
List<PollsChoice> choices = new ArrayList<PollsChoice>();
try {
	question = PollsUtil.getQuestionByPortlet(portletPreferences);
	if(blogPollId>0){
		question = PollsQuestionLocalServiceUtil.getPollsQuestion(blogPollId);
	}
}
catch (PortalException pe) {
}

if (question != null) {
	question = question.toEscapedModel();

	renderResponse.setTitle(HtmlUtil.unescape(question.getTitle(locale)));
}
%>

<c:choose>
	<c:when test="<%= question == null %>">

		<%
		renderRequest.setAttribute(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.TRUE);
		%>

		<c:choose>
			<c:when test="<%= !layout.isLayoutPrototypeLinkActive() %>">
				<div class="alert alert-info main-content-body portlet-configuration">
					<a href="<%= portletDisplay.getURLConfiguration() %>" onClick="<%= portletDisplay.getURLConfigurationJS() %>">
						<liferay-ui:message key="please-configure-this-portlet-to-make-it-visible-to-all-users" />
					</a>
				</div>
			</c:when>
			<c:otherwise>
				<div class="alert alert-info main-content-body">
					<liferay-ui:message key="please-configure-this-portlet-to-make-it-visible-to-all-users" />
				</div>
			</c:otherwise>
		</c:choose>
	</c:when>
	<c:otherwise>

		<%
		String redirect = StringPool.BLANK;
		choices = question.getChoices();
		String choiceId = "";
		boolean hasVoted = PollsUtil.hasVoted(request, question.getQuestionId());
		%>

		<portlet:actionURL name="/polls_display/vote_question" var="voteQuestionURL">
			<portlet:param name="mvcActionCommand" value="/polls_display/vote_question" />
		</portlet:actionURL>

		<aui:form action="<%= voteQuestionURL %>" method="post" name="fm">
			<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.VOTE %>" />
			<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
			<aui:input name="questionId" type="hidden" value="<%= question.getQuestionId() %>" />
			<aui:input name="choiceId" type="hidden" value="" />
			<aui:input name="successMessage" type="hidden" value='<%= LanguageUtil.get(request, "thank-you-for-your-vote") %>' />

			<liferay-ui:error exception="<%= DuplicateVoteException.class %>" message="you-may-only-vote-once" />
			<liferay-ui:error exception="<%= NoSuchChoiceException.class %>" message="please-select-an-option" />

			<aui:fieldset-group markupView="lexicon">
				<aui:fieldset>
					<h2>
						<%= StringUtil.replace(question.getDescription(locale), CharPool.NEW_LINE, "<br />") %>
					</h2>

					<c:choose>
						<c:when test="<%= !question.isExpired() && !hasVoted && PollsQuestionPermission.contains(permissionChecker, question, ActionKeys.ADD_VOTE) %>">
							<%
							for (PollsChoice choice : choices) {
								//choice = choice.toEscapedModel();
							%>
								<aui:field-wrapper cssClass="radio">
									<aui:input onChange="getChoiceId('<%= choice.getChoiceId() %>')" label='<%= choice.getName() + ". " + choice.getDescription(locale) %>' name="choiceId" type="radio" value="<%= choice.getChoiceId() %>" />
								</aui:field-wrapper>
							<%
							}
							%>
							<aui:button-row>								
								<aui:button type="button" value="vote" style="color: #FFF;background-color: #0B5FFF;border-color: #0B5FFF;box-shadow: none;" onClick="getUserBasicDetails()"/>
		
								<!-- <aui:button type="submit" value="vote[action]" /> -->
							</aui:button-row>
						</c:when>
						<c:otherwise>
							<%@ include file="/polls/view_question_results.jspf" %>

							<c:if test="<%= !themeDisplay.isSignedIn() && !question.isExpired() && !PollsQuestionPermission.contains(permissionChecker, question, ActionKeys.ADD_VOTE) %>">
								<%
								for (PollsChoice choice : choices) {
									choice = choice.toEscapedModel();
								%>
	
									<aui:field-wrapper cssClass="radio">
										<aui:input onChange="getChoiceId('<%= choice.getChoiceId() %>')"  label='<%= choice.getName() + ". " + choice.getDescription(locale) %>' name="choiceId" type="radio" value="<%= choice.getChoiceId() %>" />
									</aui:field-wrapper>
	
								<%
								}
								%>
								<aui:button-row>
									<aui:button type="button" value="vote" style="color: #FFF;background-color: #0B5FFF;border-color: #0B5FFF;box-shadow: none;" onClick="getUserBasicDetails()"/>
									<!-- <aui:button type="submit" value="vote[action]" /> -->
								</aui:button-row>
								<%-- <div class="alert alert-info">
									<a href="<%= themeDisplay.getURLSignIn() %>" target="_top"><liferay-ui:message key="please-sign-in-to-vote" /></a>
								</div> --%>
							</c:if>
						</c:otherwise>
					</c:choose>
				</aui:fieldset>
			</aui:fieldset-group>
		</aui:form>
	</c:otherwise>
</c:choose>

<%@ include file="/polls_display/view_options.jspf" %>

<script>
function getChoiceId(choiceId){
	var checkBoxValue;
	AUI().ready('aui-base',function(A){
		checkBoxValue= A.one("input[name=<portlet:namespace/>choiceId]:checked").get("value");
		document.getElementById('<portlet:namespace />choiceId').value = checkBoxValue;
	});
}

function getUserBasicDetails(){
	checkBoxValue = document.getElementById('<portlet:namespace />choiceId').value;
	if(checkBoxValue > 0){
		var siteUrl = '<%= site_url %>';
		var siteUrl2 = '/web/guest/poll-user-details?questionId='+<%= question.getQuestionId() %>+'&choiceId='+checkBoxValue+'&redirect=';
		siteUrl2 += '<%=current_url%>';
		location.href= siteUrl+siteUrl2; 
	}else{
		alert("Please select an option to vote.");
		event.preventDefault();
	}
}
</script>
<style>
.btn-vote {
    color: #FFF;
    background-color: #0B5FFF;
    border-color: #0B5FFF;
    box-shadow: none;
}
</style>
