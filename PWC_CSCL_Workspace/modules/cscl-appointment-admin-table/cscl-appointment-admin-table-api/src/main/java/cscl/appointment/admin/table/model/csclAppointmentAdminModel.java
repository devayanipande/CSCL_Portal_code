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

package cscl.appointment.admin.table.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the csclAppointmentAdmin service. Represents a row in the &quot;cscl_Appointment_Admin&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>cscl.appointment.admin.table.model.impl.csclAppointmentAdminModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>cscl.appointment.admin.table.model.impl.csclAppointmentAdminImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see csclAppointmentAdmin
 * @generated
 */
@ProviderType
public interface csclAppointmentAdminModel
	extends BaseModel<csclAppointmentAdmin> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a cscl appointment admin model instance should use the {@link csclAppointmentAdmin} interface instead.
	 */

	/**
	 * Returns the primary key of this cscl appointment admin.
	 *
	 * @return the primary key of this cscl appointment admin
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this cscl appointment admin.
	 *
	 * @param primaryKey the primary key of this cscl appointment admin
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this cscl appointment admin.
	 *
	 * @return the uuid of this cscl appointment admin
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this cscl appointment admin.
	 *
	 * @param uuid the uuid of this cscl appointment admin
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the ID of this cscl appointment admin.
	 *
	 * @return the ID of this cscl appointment admin
	 */
	public long getID();

	/**
	 * Sets the ID of this cscl appointment admin.
	 *
	 * @param ID the ID of this cscl appointment admin
	 */
	public void setID(long ID);

	/**
	 * Returns the appointee ID of this cscl appointment admin.
	 *
	 * @return the appointee ID of this cscl appointment admin
	 */
	public long getAppointeeId();

	/**
	 * Sets the appointee ID of this cscl appointment admin.
	 *
	 * @param appointeeId the appointee ID of this cscl appointment admin
	 */
	public void setAppointeeId(long appointeeId);

	/**
	 * Returns the appointee of this cscl appointment admin.
	 *
	 * @return the appointee of this cscl appointment admin
	 */
	@AutoEscape
	public String getAppointee();

	/**
	 * Sets the appointee of this cscl appointment admin.
	 *
	 * @param appointee the appointee of this cscl appointment admin
	 */
	public void setAppointee(String appointee);

	/**
	 * Returns the appointed date of this cscl appointment admin.
	 *
	 * @return the appointed date of this cscl appointment admin
	 */
	@AutoEscape
	public String getAppointedDate();

	/**
	 * Sets the appointed date of this cscl appointment admin.
	 *
	 * @param appointedDate the appointed date of this cscl appointment admin
	 */
	public void setAppointedDate(String appointedDate);

	/**
	 * Returns the from time of this cscl appointment admin.
	 *
	 * @return the from time of this cscl appointment admin
	 */
	@AutoEscape
	public String getFromTime();

	/**
	 * Sets the from time of this cscl appointment admin.
	 *
	 * @param FromTime the from time of this cscl appointment admin
	 */
	public void setFromTime(String FromTime);

	/**
	 * Returns the to time of this cscl appointment admin.
	 *
	 * @return the to time of this cscl appointment admin
	 */
	@AutoEscape
	public String getToTime();

	/**
	 * Sets the to time of this cscl appointment admin.
	 *
	 * @param ToTime the to time of this cscl appointment admin
	 */
	public void setToTime(String ToTime);

	/**
	 * Returns the second time slot of this cscl appointment admin.
	 *
	 * @return the second time slot of this cscl appointment admin
	 */
	@AutoEscape
	public String getSecondTimeSlot();

	/**
	 * Sets the second time slot of this cscl appointment admin.
	 *
	 * @param SecondTimeSlot the second time slot of this cscl appointment admin
	 */
	public void setSecondTimeSlot(String SecondTimeSlot);

	/**
	 * Returns the third time slot of this cscl appointment admin.
	 *
	 * @return the third time slot of this cscl appointment admin
	 */
	@AutoEscape
	public String getThirdTimeSlot();

	/**
	 * Sets the third time slot of this cscl appointment admin.
	 *
	 * @param ThirdTimeSlot the third time slot of this cscl appointment admin
	 */
	public void setThirdTimeSlot(String ThirdTimeSlot);

	/**
	 * Returns the fourth time slot of this cscl appointment admin.
	 *
	 * @return the fourth time slot of this cscl appointment admin
	 */
	@AutoEscape
	public String getFourthTimeSlot();

	/**
	 * Sets the fourth time slot of this cscl appointment admin.
	 *
	 * @param FourthTimeSlot the fourth time slot of this cscl appointment admin
	 */
	public void setFourthTimeSlot(String FourthTimeSlot);

	/**
	 * Returns the fifth time slot of this cscl appointment admin.
	 *
	 * @return the fifth time slot of this cscl appointment admin
	 */
	@AutoEscape
	public String getFifthTimeSlot();

	/**
	 * Sets the fifth time slot of this cscl appointment admin.
	 *
	 * @param FifthTimeSlot the fifth time slot of this cscl appointment admin
	 */
	public void setFifthTimeSlot(String FifthTimeSlot);

	/**
	 * Returns the sixth time slot of this cscl appointment admin.
	 *
	 * @return the sixth time slot of this cscl appointment admin
	 */
	@AutoEscape
	public String getSixthTimeSlot();

	/**
	 * Sets the sixth time slot of this cscl appointment admin.
	 *
	 * @param SixthTimeSlot the sixth time slot of this cscl appointment admin
	 */
	public void setSixthTimeSlot(String SixthTimeSlot);

	/**
	 * Returns the seventh time slot of this cscl appointment admin.
	 *
	 * @return the seventh time slot of this cscl appointment admin
	 */
	@AutoEscape
	public String getSeventhTimeSlot();

	/**
	 * Sets the seventh time slot of this cscl appointment admin.
	 *
	 * @param SeventhTimeSlot the seventh time slot of this cscl appointment admin
	 */
	public void setSeventhTimeSlot(String SeventhTimeSlot);

	/**
	 * Returns the eighth time slot of this cscl appointment admin.
	 *
	 * @return the eighth time slot of this cscl appointment admin
	 */
	@AutoEscape
	public String getEighthTimeSlot();

	/**
	 * Sets the eighth time slot of this cscl appointment admin.
	 *
	 * @param EighthTimeSlot the eighth time slot of this cscl appointment admin
	 */
	public void setEighthTimeSlot(String EighthTimeSlot);

	/**
	 * Returns the nine time slot of this cscl appointment admin.
	 *
	 * @return the nine time slot of this cscl appointment admin
	 */
	@AutoEscape
	public String getNineTimeSlot();

	/**
	 * Sets the nine time slot of this cscl appointment admin.
	 *
	 * @param NineTimeSlot the nine time slot of this cscl appointment admin
	 */
	public void setNineTimeSlot(String NineTimeSlot);

	/**
	 * Returns the ten time slot of this cscl appointment admin.
	 *
	 * @return the ten time slot of this cscl appointment admin
	 */
	@AutoEscape
	public String getTenTimeSlot();

	/**
	 * Sets the ten time slot of this cscl appointment admin.
	 *
	 * @param TenTimeSlot the ten time slot of this cscl appointment admin
	 */
	public void setTenTimeSlot(String TenTimeSlot);

}