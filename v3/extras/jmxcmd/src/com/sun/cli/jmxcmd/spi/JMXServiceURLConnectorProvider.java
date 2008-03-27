/*
 * Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
 
/*
 * $Header: /m/jws/jmxcmd/src/com/sun/cli/jmxcmd/spi/JMXServiceURLConnectorProvider.java,v 1.3 2005/11/15 20:59:54 llc Exp $
 * $Revision: 1.3 $
 * $Date: 2005/11/15 20:59:54 $
 */
 
package com.sun.cli.jmxcmd.spi;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Collections;
import java.io.IOException;

import javax.management.remote.JMXConnector;
import javax.management.remote.JMXServiceURL;
import javax.management.remote.JMXConnectorFactory;

import com.sun.cli.jcmd.util.misc.GSetUtil;


/**
	Supports connectivity via a JMXServiceURL.
	<p>
	Supported protocols are {@link #URL_PROTOCOL}
 */
public final class JMXServiceURLConnectorProvider
	extends JMXConnectorProviderBase
{
		public
	JMXServiceURLConnectorProvider()
	{
	}
	
	static final class Info implements JMXConnectorProviderInfo
	{
		private static final String	DESCRIPTION	=
			"Implements connectivity via a JMXServiceURL";
		private static final String	USAGE	=
			"connect --protocol|-r url " +
			"--url <url> " +
			"[--user|-u <user> --password-file|-f <path> ] "  +
			"[connection-name]";
		
			public String
		getDescription()
		{
			return( DESCRIPTION );
		}
			public String
		getUsage()
		{
			return( USAGE );
		}
	}
	
		public static JMXConnectorProviderInfo
	getInfo()
	{
		return( new Info() );
	}
	
		public JMXConnector
	connect( java.util.Map params )
		throws IOException
	{
		final String	urlString		= (String)params.get( URL );
		
		requireParam( urlString, "url" );
		
		final Map		env	= initEnv( params );
				
		return( connect( urlString, env ) );
	}
	
	public final static String	URL_PROTOCOL		= "url";
	public static final Set<String>	SUPPORTED_PROTOCOLS	=
		GSetUtil.newUnmodifiableStringSet( URL_PROTOCOL );
	
		protected Set
	getSupportedProtocols()
	{
		return( SUPPORTED_PROTOCOLS );
	}
}




