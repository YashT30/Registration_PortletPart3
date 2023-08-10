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

package Reg.service.service.impl;

import Reg.service.model.Billing1;
import Reg.service.service.Billing1LocalServiceUtil;
import Reg.service.service.base.Billing1LocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=Reg.service.model.Billing1",
	service = AopService.class
)
public class Billing1LocalServiceImpl extends Billing1LocalServiceBaseImpl {
	public Billing1 addBilling1(long userId, String address, String address2, String city, String state, String zip) {
		long billingAddressId = counterLocalService.increment(Billing1.class.getName());
		
		Billing1 billing1 = createBilling1(billingAddressId);
		billing1 .setUserId(userId);
		billing1 .setAddress(address);
		billing1.setAddress2(address2);
		billing1.setCity(city);
		billing1.setState(state);
		billing1.setZip(zip);
		return addBilling1(billing1);
	}
	
	
		public Billing1 updateBilling1(long billingAddressId, String address, String address2, String city, String state, String zip) throws PortalException {
			Billing1 billing1 = getBilling1(billingAddressId);
			billing1.setAddress(address);
			billing1.setAddress2(address2);
			billing1.setCity(city);
			billing1.setState(state);
			billing1.setZip(zip);
			return updateBilling1(billing1);
		}
	
		public Billing1 deleteBilling1(long billingAddressId) throws PortalException {
			Billing1 billingAddress = getBilling1(billingAddressId);
			return deleteBilling1(billingAddress);
		}
		
		public List<Billing1> getStudentsByPostalCode(String zip) throws PortalException, SystemException {
		    DynamicQuery dynamicQuery = Billing1LocalServiceUtil.dynamicQuery()
		        .add(PropertyFactoryUtil.forName("zip").eq(zip));
		    return Billing1LocalServiceUtil.dynamicQuery(dynamicQuery);
		}
	}
