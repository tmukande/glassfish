/*
 * The contents of this file are subject to the terms 
 * of the Common Development and Distribution License 
 * (the "License").  You may not use this file except 
 * in compliance with the License.
 * 
 * You can obtain a copy of the license at 
 * glassfish/bootstrap/legal/CDDLv1.0.txt or 
 * https://glassfish.dev.java.net/public/CDDLv1.0.html. 
 * See the License for the specific language governing 
 * permissions and limitations under the License.
 * 
 * When distributing Covered Code, include this CDDL 
 * HEADER in each file and include the License file at 
 * glassfish/bootstrap/legal/CDDLv1.0.txt.  If applicable, 
 * add the following below this CDDL HEADER, with the 
 * fields enclosed by brackets "[]" replaced with your 
 * own identifying information: Portions Copyright [yyyy] 
 * [name of copyright owner]
 */
 
/*
 * $Header: /m/jws/jmxcmd/src/com/sun/cli/jmxcmd/util/jmx/AttributeChangeNotificationBuilder.java,v 1.2 2005/11/08 22:40:21 llc Exp $
 * $Revision: 1.2 $
 * $Date: 2005/11/08 22:40:21 $
 */

package com.sun.cli.jmxcmd.util.jmx;

import javax.management.Notification;
import javax.management.AttributeChangeNotification;
import javax.management.ObjectName;

/**
	Base class for building AMX Notifications.
 */
public class AttributeChangeNotificationBuilder extends NotificationBuilder
{
		public
	AttributeChangeNotificationBuilder(
		final ObjectName	source )
	{
		super( AttributeChangeNotification.ATTRIBUTE_CHANGE, source );
	}

		public final Notification
	buildNew()
	{
		throw new IllegalArgumentException();
	}
	
		public final Notification
	buildNew(
		final String	key,
		final Object	value )
	{
		throw new IllegalArgumentException();
	}
	
		public final AttributeChangeNotification
	buildAttributeChange(
		final String	msg,
		final String	attributeName,
		final String	attributeType,
		final Object	oldValue,
		final Object	newValue )
	{
		final AttributeChangeNotification notif	= new AttributeChangeNotification(
			getSource(),
			nextSequenceNumber(),
			now(),
			msg,
			attributeName,
			attributeType,
			oldValue,
			newValue );
		
		return( notif );
	}
}





