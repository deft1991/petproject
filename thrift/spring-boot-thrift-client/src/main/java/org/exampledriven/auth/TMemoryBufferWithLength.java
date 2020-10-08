package org.exampledriven.auth;

import org.apache.thrift.transport.TMemoryBuffer;

/**
 * @author Sergey Golitsyn
 * created on 07.10.2020
 */
public class TMemoryBufferWithLength extends TMemoryBuffer {
    private int actualLength = 0;

    public TMemoryBufferWithLength(int size) {
        super(size);
    }

    @Override
    public void write(byte[] buf, int off, int len) {
        super.write(buf, off, len);
        actualLength += len;
    }

    @Override
    public int length() {
        return actualLength;
    }
}
