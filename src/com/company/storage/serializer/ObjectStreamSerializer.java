package com.company.storage.serializer;

import com.company.exceptions.StorageException;
import com.company.model.Resume;

import java.io.*;

/**
 * Created by cic56 on 10.07.2017.
 */
public class ObjectStreamSerializer implements StreamSerializer {
    @Override
    public void doWrite(Resume r, OutputStream os) throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(os)){
            oos.writeObject(r);
        }
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try(ObjectInputStream ois = new ObjectInputStream(is)){
            return  (Resume) ois.readObject();
        } catch (ClassNotFoundException e){
                throw new StorageException("Error read resume", null, e);
        }

    }
}
