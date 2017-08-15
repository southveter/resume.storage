package com.company.exceptions;

/**
 * Created by cic56 on 06.06.2017.
 */
public class ExistStorageException extends StorageException{
    public ExistStorageException(String uuid) {
        super("Resume " +uuid+ " already exist", uuid);
    }
}
