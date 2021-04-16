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

package cscl.appointment.admin.table.service.base;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import cscl.appointment.admin.table.model.csclAppointmentAdmin;
import cscl.appointment.admin.table.service.csclAppointmentAdminLocalService;
import cscl.appointment.admin.table.service.persistence.csclAppointmentAdminPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the cscl appointment admin local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link cscl.appointment.admin.table.service.impl.csclAppointmentAdminLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see cscl.appointment.admin.table.service.impl.csclAppointmentAdminLocalServiceImpl
 * @generated
 */
public abstract class csclAppointmentAdminLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, csclAppointmentAdminLocalService,
			   IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>csclAppointmentAdminLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>cscl.appointment.admin.table.service.csclAppointmentAdminLocalServiceUtil</code>.
	 */

	/**
	 * Adds the cscl appointment admin to the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclAppointmentAdmin the cscl appointment admin
	 * @return the cscl appointment admin that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public csclAppointmentAdmin addcsclAppointmentAdmin(
		csclAppointmentAdmin csclAppointmentAdmin) {

		csclAppointmentAdmin.setNew(true);

		return csclAppointmentAdminPersistence.update(csclAppointmentAdmin);
	}

	/**
	 * Creates a new cscl appointment admin with the primary key. Does not add the cscl appointment admin to the database.
	 *
	 * @param ID the primary key for the new cscl appointment admin
	 * @return the new cscl appointment admin
	 */
	@Override
	@Transactional(enabled = false)
	public csclAppointmentAdmin createcsclAppointmentAdmin(long ID) {
		return csclAppointmentAdminPersistence.create(ID);
	}

	/**
	 * Deletes the cscl appointment admin with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID the primary key of the cscl appointment admin
	 * @return the cscl appointment admin that was removed
	 * @throws PortalException if a cscl appointment admin with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public csclAppointmentAdmin deletecsclAppointmentAdmin(long ID)
		throws PortalException {

		return csclAppointmentAdminPersistence.remove(ID);
	}

	/**
	 * Deletes the cscl appointment admin from the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclAppointmentAdmin the cscl appointment admin
	 * @return the cscl appointment admin that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public csclAppointmentAdmin deletecsclAppointmentAdmin(
		csclAppointmentAdmin csclAppointmentAdmin) {

		return csclAppointmentAdminPersistence.remove(csclAppointmentAdmin);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			csclAppointmentAdmin.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return csclAppointmentAdminPersistence.findWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cscl.appointment.admin.table.model.impl.csclAppointmentAdminModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return csclAppointmentAdminPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cscl.appointment.admin.table.model.impl.csclAppointmentAdminModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return csclAppointmentAdminPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return csclAppointmentAdminPersistence.countWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return csclAppointmentAdminPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public csclAppointmentAdmin fetchcsclAppointmentAdmin(long ID) {
		return csclAppointmentAdminPersistence.fetchByPrimaryKey(ID);
	}

	/**
	 * Returns the cscl appointment admin with the primary key.
	 *
	 * @param ID the primary key of the cscl appointment admin
	 * @return the cscl appointment admin
	 * @throws PortalException if a cscl appointment admin with the primary key could not be found
	 */
	@Override
	public csclAppointmentAdmin getcsclAppointmentAdmin(long ID)
		throws PortalException {

		return csclAppointmentAdminPersistence.findByPrimaryKey(ID);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			csclAppointmentAdminLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(csclAppointmentAdmin.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("ID");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			csclAppointmentAdminLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			csclAppointmentAdmin.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("ID");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			csclAppointmentAdminLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(csclAppointmentAdmin.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("ID");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return csclAppointmentAdminLocalService.deletecsclAppointmentAdmin(
			(csclAppointmentAdmin)persistedModel);
	}

	public BasePersistence<csclAppointmentAdmin> getBasePersistence() {
		return csclAppointmentAdminPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return csclAppointmentAdminPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the cscl appointment admins.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cscl.appointment.admin.table.model.impl.csclAppointmentAdminModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl appointment admins
	 * @param end the upper bound of the range of cscl appointment admins (not inclusive)
	 * @return the range of cscl appointment admins
	 */
	@Override
	public List<csclAppointmentAdmin> getcsclAppointmentAdmins(
		int start, int end) {

		return csclAppointmentAdminPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of cscl appointment admins.
	 *
	 * @return the number of cscl appointment admins
	 */
	@Override
	public int getcsclAppointmentAdminsCount() {
		return csclAppointmentAdminPersistence.countAll();
	}

	/**
	 * Updates the cscl appointment admin in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param csclAppointmentAdmin the cscl appointment admin
	 * @return the cscl appointment admin that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public csclAppointmentAdmin updatecsclAppointmentAdmin(
		csclAppointmentAdmin csclAppointmentAdmin) {

		return csclAppointmentAdminPersistence.update(csclAppointmentAdmin);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			csclAppointmentAdminLocalService.class,
			IdentifiableOSGiService.class, PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		csclAppointmentAdminLocalService =
			(csclAppointmentAdminLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return csclAppointmentAdminLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return csclAppointmentAdmin.class;
	}

	protected String getModelClassName() {
		return csclAppointmentAdmin.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				csclAppointmentAdminPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	protected csclAppointmentAdminLocalService csclAppointmentAdminLocalService;

	@Reference
	protected csclAppointmentAdminPersistence csclAppointmentAdminPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetEntryLocalService
		assetEntryLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetTagLocalService
		assetTagLocalService;

}