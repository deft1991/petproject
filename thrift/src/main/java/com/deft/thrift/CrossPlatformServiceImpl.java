package com.deft.thrift;


import generated.CrossPlatformResource;
import generated.CrossPlatformService;
import generated.InvalidOperationException;

import org.apache.thrift.TException;

import java.util.Collections;
import java.util.List;
/**
 * @author Sergey Golitsyn
 * created on 06.10.2020
 */
public class CrossPlatformServiceImpl implements CrossPlatformService.Iface {

    public CrossPlatformResource get(final int id) throws InvalidOperationException, TException {
        // add some action
        return new CrossPlatformResource();
    }

    public void save(final CrossPlatformResource resource) throws InvalidOperationException, TException {
        // add some action
    }

    public List<CrossPlatformResource> getList() throws InvalidOperationException, TException {
        // add some action
        return Collections.emptyList();
    }

    public boolean ping() throws InvalidOperationException, TException {
        return true;
    }
}
