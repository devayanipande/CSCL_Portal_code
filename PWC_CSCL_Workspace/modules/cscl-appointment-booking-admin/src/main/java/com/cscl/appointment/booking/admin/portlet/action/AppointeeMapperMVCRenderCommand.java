package com.cscl.appointment.booking.admin.portlet.action;

import com.cscl.appointment.booking.admin.constants.CsclAppointmentBookingAdminPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
		property = {
			"javax.portlet.name=" + CsclAppointmentBookingAdminPortletKeys.CSCLAPPOINTMENTBOOKINGADMIN,
			"mvc.command.name=/appointmentAdmin/manage_appointee_mapper"
		},
		service = MVCRenderCommand.class
	)

public class AppointeeMapperMVCRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		return "/appointmentAdmin/manage_appointee_mapper.jsp";
	}

}
