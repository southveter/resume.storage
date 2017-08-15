package com.company.storage;

import com.company.model.Resume;

import java.util.*;


/**
 * Created by cic56 on 12.06.2017.
 */
public class MapResumeStorage extends AbstractStorage<Resume> {
    private Map<String, Resume> map = new HashMap<>();



    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    protected Resume getSearchKey(String uuid) {

        return map.get(uuid);
    }

    @Override
    protected void doUpdate(Resume r, Resume searchKey) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected boolean isExist(Resume searchKey) {

        return searchKey != null;
    }

    @Override
    protected void doSave(Resume r, Resume searchKey) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected Resume doGet(Resume resume) {
        return resume;
    }

    @Override
    protected void doDelete(Resume resume) {
    map.remove((resume ).getUuid());
    }

    @Override
    protected List<Resume> doCopyAll() {
        return new ArrayList<>(map.values());
    }
}
