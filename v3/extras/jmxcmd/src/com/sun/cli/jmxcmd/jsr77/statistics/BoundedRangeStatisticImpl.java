/*
 * Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
 
/*
 * $Header: /m/jws/jmxcmd/src/com/sun/cli/jmxcmd/jsr77/statistics/BoundedRangeStatisticImpl.java,v 1.1 2004/10/14 19:06:22 llc Exp $
 * $Revision: 1.1 $
 * $Date: 2004/10/14 19:06:22 $
 */

package com.sun.cli.jmxcmd.jsr77.statistics;

import java.util.Map;
import java.io.Serializable;

import javax.management.openmbean.CompositeData;
import javax.management.j2ee.statistics.BoundedRangeStatistic;

import com.sun.cli.jmxcmd.util.jmx.OpenMBeanUtil;

/**
	Serializable implementation of a BoundedRangeStatistic
 */
public class BoundedRangeStatisticImpl extends RangeStatisticImpl
	implements BoundedRangeStatistic, Serializable
{
	static final long serialVersionUID = 4803476800834526575L;
	
	private long	LowerBound;
	private long	UpperBound;
	
	
		public
	BoundedRangeStatisticImpl(
		final String	name,
		final String	description,
		final String	unit,
		final long		startTime,
		final long		lastSampleTime,
		final long		low,
		final long		current,
		final long		high,
		final long		lowerBound,
		final long		upperBound )
	{
		super( name, description, unit, startTime, lastSampleTime, low, current, high );
		
		if ( lowerBound > upperBound )
		{
			throw new IllegalArgumentException();
		}
		
		LowerBound	= lowerBound;
		UpperBound	= UpperBound;
	}
	
		public
	BoundedRangeStatisticImpl( final CompositeData compositeData )
	{
		this( OpenMBeanUtil.compositeDataToMap( compositeData ) );
	}
	
		public
	BoundedRangeStatisticImpl( final Map m )
	{
		this( new MapStatisticImpl( m ) );
	}
	
		public
	BoundedRangeStatisticImpl( final MapStatistic s )
	{
		super( s );
		
		LowerBound	= s.getlong( "LowerBound" );
		UpperBound	= s.getlong( "UpperBound" );
	}
	
		public
	BoundedRangeStatisticImpl( final BoundedRangeStatistic s )
	{
		super( s );
		
		LowerBound	= s.getLowerBound();
		UpperBound	= s.getUpperBound();
	}
	
		public long
	getLowerBound()
	{
		return( LowerBound );
	}
	
		public long
	getUpperBound()
	{
		return( UpperBound );
	}
}





