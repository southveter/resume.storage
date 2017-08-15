package com.company.storage;

import com.company.exceptions.StorageException;
import com.company.model.Resume;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by cic56 on 27.06.2017.
 */
public  abstract class AbstractFileStorage  extends AbstractStorage<File> {
    protected File directory;

    protected abstract void doWrite(Resume r, OutputStream os) throws IOException;

    protected abstract Resume doRead(InputStream is) throws IOException;

    public AbstractFileStorage(File directory) {
        Objects.requireNonNull(directory, " directory must be not null");
        if(!directory.isDirectory()){
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not directory");
        }
        if(!directory.canRead() || !directory.canWrite()){
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not readable/writable");
        }
        this.directory = directory;
    }

    @Override
    public void clear() {
        File[] files = directory.listFiles();
        if(files != null){
            for(File file : files){
                doDelete(file);
            }
        }
    }
    @Override
    protected void doSave(Resume r, File file) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new StorageException("Could not create file " + file.getAbsolutePath(), file.getName(),e);
        }
        doUpdate(r, file);
    }

    @Override
    public int size() {
        String[] list = directory.list();
        if(list == null){
            throw new StorageException("Dirrectory read error");
        }
        return list.length;
    }

    @Override
    protected File getSearchKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected void doUpdate(Resume r, File file) {
        try {
            doWrite(r, new BufferedOutputStream( new FileOutputStream(file)));
        } catch (IOException e) {
            throw new StorageException("File write error", r.getUuid(), e);
        }
    }

    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }




    @Override
    protected Resume doGet(File file) {
        try {
            return doRead(new BufferedInputStream(new FileInputStream(file)));
        } catch (IOException e) {
            throw new StorageException("File read error", file.getName(),e);
        }
    }

    @Override
    protected void doDelete(File file) {
            if(!file.delete()){
                throw  new StorageException("File delete error");
            }
    }

    @Override
    protected List<Resume> doCopyAll() {

        File[] files = directory.listFiles();
        if(files == null){
            throw new StorageException("Directory read error");
        }
        List<Resume> list = new ArrayList<>(files.length);
        for(File file: files){
            list.add(doGet(file));
        }
        return list;
    }
}
