package org.glassfish.api.naming;

import org.jvnet.hk2.annotations.Service;

import javax.naming.Context;
import javax.naming.NamingException;

@Service
public interface NamingObjectFactory {

    /**
     * Tells if the result of create() is cacheable. If so
     * the naming manager will replace this object factory with
     * the object itself.
     *
     * @return true if the result of create() can be cached
     */
    public boolean isCreateResultCacheable();

    /**
     * Create ad return an object.
     *
     * @return an object
     */
    public Object create(Context ic)
            throws NamingException;

}
