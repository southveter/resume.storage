package com.company.storage;

import com.company.exceptions.ExistStorageException;
import com.company.exceptions.NotExistStorageException;
import com.company.model.Resume;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by cic56 on 12.06.2017.
 */
public abstract class AbstractStorage<SK> implements Storage {

    protected abstract SK getSearchKey(String uuid);

    protected abstract void doUpdate(Resume r, SK searchKey);

    protected abstract boolean isExist(SK searchKey);

    protected abstract void doSave(Resume r, SK searchKey);

    protected abstract Resume doGet(SK searchKey);

    protected abstract void doDelete(SK searchKey);

    protected abstract List<Resume> doCopyAll();


    @Override
    public void save(Resume resume) {
        SK searchKey = getNotExistedSearchKey(resume.getUuid());
        doSave(resume,searchKey);
    }

    @Override
    public void delete(String uuid) {
        SK searchKey = getExistedSearchKey(uuid);
        doDelete(searchKey);
    }

    @Override
    public void update(Resume resume) {
        SK searchKey = getExistedSearchKey(resume.getUuid());
        doUpdate(resume,searchKey);
    }

    @Override
    public Resume get(String uuid) {
        SK searchKey = getExistedSearchKey(uuid);
        return doGet(searchKey);

    }

    private  SK getExistedSearchKey(String uuid){
        SK searchKey  = getSearchKey(uuid);
        if(!isExist(searchKey)){
          throw new NotExistStorageException(uuid)  ;
        }
        return searchKey;
    }
    private  SK getNotExistedSearchKey(String uuid){
        SK searchKey  = getSearchKey(uuid);
        if(isExist(searchKey)){
            throw new ExistStorageException(uuid)  ;
        }
        return searchKey;
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> list = doCopyAll();
        Collections.sort(list);
        return list;
    }


}
