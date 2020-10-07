package org.exampledriven.auth;

import org.apache.thrift.TBase;
import org.apache.thrift.TException;

/**
 * @author Sergey Golitsyn
 * created on 07.10.2020
 */
public interface AuthTokenExchanger<T extends TBase, U extends  TBase> {
    T createEmptyAuthToken();

    U process(T authToken) throws TException;
}
