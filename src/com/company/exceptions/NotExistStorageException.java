package com.company.exceptions;

/**
 * Created by cic56 on 06.06.2017.
 */
public class NotExistStorageException extends StorageException {
    public NotExistStorageException(String uuid) {
        super("Resume " +uuid+ " not exist", uuid);
    }
}
